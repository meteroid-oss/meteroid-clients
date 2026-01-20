package com.meteroid;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.stubbing.Scenario;
import com.meteroid.exceptions.ApiException;

import okhttp3.Headers;
import okhttp3.HttpUrl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Tests for the Meteroid HTTP client using WireMock.
 */
public class MeteroidClientTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(0);

    private MeteroidHttpClient client;

    @Before
    public void setUp() {
        HttpUrl baseUrl = HttpUrl.parse("http://localhost:" + wireMockRule.port());
        Map<String, String> headers = Map.of(
                "Authorization", "Bearer test-api-key",
                "User-Agent", "meteroid-java/" + Version.VERSION
        );
        client = new MeteroidHttpClient(baseUrl, headers, Arrays.asList(50L, 100L, 200L));
    }

    @Test
    public void testSuccessfulGetRequest() throws IOException, ApiException {
        stubFor(get(urlEqualTo("/api/v1/test"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": \"test-123\", \"name\": \"Test\"}")));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/test").build();
        TestResponse response = client.executeRequest("GET", url, null, null, TestResponse.class);

        assertThat(response.id).isEqualTo("test-123");
        assertThat(response.name).isEqualTo("Test");

        verify(getRequestedFor(urlEqualTo("/api/v1/test"))
                .withHeader("Authorization", equalTo("Bearer test-api-key"))
                .withHeader("User-Agent", containing("meteroid-java/")));
    }

    @Test
    public void testSuccessfulPostRequest() throws IOException, ApiException {
        stubFor(post(urlEqualTo("/api/v1/test"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": \"created-123\", \"name\": \"Created\"}")));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/test").build();
        TestRequest request = new TestRequest();
        request.name = "New Item";

        TestResponse response = client.executeRequest("POST", url, null, request, TestResponse.class);

        assertThat(response.id).isEqualTo("created-123");
        assertThat(response.name).isEqualTo("Created");

        verify(postRequestedFor(urlEqualTo("/api/v1/test"))
                .withHeader("Content-Type", equalTo("application/json; charset=utf-8"))
                .withHeader("idempotency-key", matching("auto_.*"))
                .withRequestBody(containing("\"name\":\"New Item\"")));
    }

    @Test
    public void testCustomIdempotencyKey() throws IOException, ApiException {
        stubFor(post(urlEqualTo("/api/v1/test"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": \"test\", \"name\": \"test\"}")));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/test").build();
        Headers headers = new Headers.Builder()
                .add("idempotency-key", "my-custom-key")
                .build();

        client.executeRequest("POST", url, headers, new TestRequest(), TestResponse.class);

        verify(postRequestedFor(urlEqualTo("/api/v1/test"))
                .withHeader("idempotency-key", equalTo("my-custom-key")));
    }

    @Test
    public void test204NoContentReturnsNull() throws IOException, ApiException {
        stubFor(delete(urlEqualTo("/api/v1/test/123"))
                .willReturn(aResponse()
                        .withStatus(204)));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/test/123").build();
        TestResponse response = client.executeRequest("DELETE", url, null, null, TestResponse.class);

        assertThat(response).isNull();
    }

    @Test
    public void testRetryOn500Error() throws IOException, ApiException {
        // First request fails with 500, second succeeds
        stubFor(get(urlEqualTo("/api/v1/test"))
                .inScenario("Retry Test")
                .whenScenarioStateIs(Scenario.STARTED)
                .willReturn(aResponse().withStatus(500).withBody("Internal Server Error"))
                .willSetStateTo("After First Failure"));

        stubFor(get(urlEqualTo("/api/v1/test"))
                .inScenario("Retry Test")
                .whenScenarioStateIs("After First Failure")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": \"success\", \"name\": \"Success\"}")));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/test").build();
        TestResponse response = client.executeRequest("GET", url, null, null, TestResponse.class);

        assertThat(response.id).isEqualTo("success");

        // Verify retry was made
        verify(2, getRequestedFor(urlEqualTo("/api/v1/test")));
    }

    @Test
    public void testMaxRetriesExhausted() {
        // Always return 500
        stubFor(get(urlEqualTo("/api/v1/fail"))
                .willReturn(aResponse().withStatus(500).withBody("Always fails")));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/fail").build();

        assertThatThrownBy(() -> client.executeRequest("GET", url, null, null, TestResponse.class))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> {
                    ApiException apiException = (ApiException) e;
                    assertThat(apiException.getCode()).isEqualTo(500);
                });

        // Should have made 4 total requests (1 initial + 3 retries)
        verify(4, getRequestedFor(urlEqualTo("/api/v1/fail")));
    }

    @Test
    public void test4xxErrorsAreNotRetried() {
        stubFor(get(urlEqualTo("/api/v1/notfound"))
                .willReturn(aResponse()
                        .withStatus(404)
                        .withBody("{\"error\": \"Not found\"}")));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/notfound").build();

        assertThatThrownBy(() -> client.executeRequest("GET", url, null, null, TestResponse.class))
                .isInstanceOf(ApiException.class)
                .satisfies(e -> {
                    ApiException apiException = (ApiException) e;
                    assertThat(apiException.getCode()).isEqualTo(404);
                    assertThat(apiException.getResponseBody()).contains("Not found");
                });

        // Should only make 1 request (no retries for 4xx)
        verify(1, getRequestedFor(urlEqualTo("/api/v1/notfound")));
    }

    @Test
    public void testBinaryRequest() throws IOException, ApiException {
        byte[] pdfContent = "fake pdf content".getBytes();
        stubFor(get(urlEqualTo("/api/v1/invoice/pdf"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/pdf")
                        .withBody(pdfContent)));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/invoice/pdf").build();
        byte[] response = client.executeBinaryRequest("GET", url, null, null);

        assertThat(response).isEqualTo(pdfContent);
    }

    @Test
    public void testRequestIdHeaderIsAdded() throws IOException, ApiException {
        stubFor(get(urlEqualTo("/api/v1/test"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\": \"test\", \"name\": \"test\"}")));

        HttpUrl url = client.newUrlBuilder().encodedPath("/api/v1/test").build();
        client.executeRequest("GET", url, null, null, TestResponse.class);

        verify(getRequestedFor(urlEqualTo("/api/v1/test"))
                .withHeader("x-meteroid-req-id", matching("\\d+")));
    }

    // Test helper classes
    public static class TestRequest {
        public String name;
    }

    public static class TestResponse {
        public String id;
        public String name;
    }
}
