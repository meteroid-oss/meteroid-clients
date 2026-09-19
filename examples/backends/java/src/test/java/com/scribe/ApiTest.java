package com.scribe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.Webhook;

import io.javalin.Javalin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

/**
 * The parts of the contract that are reachable with no Meteroid tenant: health, the session-token
 * gate, request validation, the error envelope, the 404 fallback, and the whole webhook path.
 *
 * <p>The webhook path works offline because the SDK ships a <b>signer</b> as well as a verifier, so
 * a test can produce a validly signed payload. Everything that actually talks to Meteroid is
 * exercised by {@code examples/tests/contract} against a live tenant, not here.
 */
class ApiTest {

    private static final String SESSION_SECRET = "test-session-secret";
    private static final String WEBHOOK_SECRET =
            "whsec_"
                    + Base64.getEncoder()
                            .encodeToString(
                                    "scribe-demo-webhook-secret".getBytes(StandardCharsets.UTF_8));

    private static Javalin app;
    private static int port;
    private static final HttpClient HTTP = HttpClient.newHttpClient();

    @BeforeAll
    static void startServer() {
        app = Main.router(new AppState(Config.forTests(SESSION_SECRET, WEBHOOK_SECRET)));
        app.start(0);
        port = app.port();
    }

    @AfterAll
    static void stopServer() {
        if (app != null) {
            app.stop();
        }
    }

    // ------------------------------------------------------------------ health

    @Test
    void healthReportsTheBackendAndItsConfiguration() throws Exception {
        HttpResponse<String> response = get("/api/health", null);
        assertEquals(200, response.statusCode());

        JsonNode body = json(response);
        assertEquals("ok", body.get("status").asText());
        assertEquals("java", body.get("backend").asText());
        // No METEROID_API_KEY in a test configuration, which is exactly what this field is for.
        assertFalse(body.get("meteroid_configured").asBoolean());
        assertTrue(body.has("version"));
    }

    // ------------------------------------------------------------------ the error envelope

    @Test
    void aMissingSessionTokenIsAnUnauthorizedEnvelope() throws Exception {
        HttpResponse<String> response = get("/api/me", null);
        assertEquals(401, response.statusCode());
        assertErrorEnvelope(json(response), "UNAUTHORIZED");
    }

    @Test
    void aTokenFromAnotherDeploymentIsRejected() throws Exception {
        String foreign = SessionToken.mint("some-other-secret", "scribe-demo-1");
        HttpResponse<String> response = get("/api/me", foreign);
        assertEquals(401, response.statusCode());
        assertErrorEnvelope(json(response), "UNAUTHORIZED");
    }

    @Test
    void anUnmatchedRouteStillArrivesInTheEnvelope() throws Exception {
        HttpResponse<String> response = get("/api/nope", null);
        assertEquals(404, response.statusCode());
        assertErrorEnvelope(json(response), "NOT_FOUND");
    }

    // ------------------------------------------------------------------ request validation
    //
    // Each of these is rejected before the handler reaches Meteroid, so they run offline.

    @Test
    void rejectsAnOutOfRangeTranscriptionDuration() throws Exception {
        HttpResponse<String> response =
                post(
                        "/api/transcriptions",
                        token(),
                        "{\"title\":\"Weekly standup\",\"duration_seconds\":99999}");
        assertEquals(400, response.statusCode());
        assertErrorEnvelope(json(response), "BAD_REQUEST");
    }

    @Test
    void rejectsAnUnknownFieldInARequestBody() throws Exception {
        HttpResponse<String> response =
                post(
                        "/api/transcriptions",
                        token(),
                        "{\"title\":\"x\",\"duration_seconds\":60,\"surprise\":1}");
        assertEquals(400, response.statusCode());
        assertErrorEnvelope(json(response), "BAD_REQUEST");
    }

    @Test
    void rejectsAnOutOfRangePortalTokenLifetime() throws Exception {
        HttpResponse<String> response =
                post("/api/portal-session", token(), "{\"expires_in_seconds\":5}");
        assertEquals(400, response.statusCode());
        assertErrorEnvelope(json(response), "BAD_REQUEST");
    }

    @Test
    void rejectsAnUnknownPlanCode() throws Exception {
        HttpResponse<String> response =
                post("/api/checkout", token(), "{\"plan_code\":\"enterprise\"}");
        assertEquals(400, response.statusCode());
        assertErrorEnvelope(json(response), "BAD_REQUEST");
    }

    /** In-memory history: a fresh workspace has none, and the shape is still the contract's. */
    @Test
    void listsAnEmptyTranscriptionHistory() throws Exception {
        HttpResponse<String> response = get("/api/transcriptions", token());
        assertEquals(200, response.statusCode());
        assertTrue(json(response).get("transcriptions").isArray());
        assertEquals(0, json(response).get("transcriptions").size());
    }

    // ------------------------------------------------------------------ webhooks

    @Test
    void acceptsACorrectlySignedEvent() throws Exception {
        String payload = "{\"id\":\"evt_1\",\"type\":\"invoice.paid\"}";
        HttpResponse<String> response = postSignedWebhook(payload, WEBHOOK_SECRET);

        assertEquals(202, response.statusCode());
        JsonNode body = json(response);
        assertTrue(body.get("received").asBoolean());
        assertEquals("evt_1", body.get("event_id").asText());
        assertEquals("invoice.paid", body.get("type").asText());
        assertTrue(body.get("handled").asBoolean());
    }

    /** A new Meteroid event type must never break a receiver: acknowledged, not rejected. */
    @Test
    void acknowledgesAnUnknownEventTypeWithoutHandlingIt() throws Exception {
        String payload = "{\"id\":\"evt_2\",\"type\":\"something.brand.new\"}";
        HttpResponse<String> response = postSignedWebhook(payload, WEBHOOK_SECRET);

        assertEquals(202, response.statusCode());
        assertFalse(json(response).get("handled").asBoolean());
    }

    /** Meteroid publishes no schema for the envelope, so an unexpected shape is still accepted. */
    @Test
    void acceptsASignedEventWithNoRecognizableFields() throws Exception {
        HttpResponse<String> response = postSignedWebhook("{\"whatever\":true}", WEBHOOK_SECRET);

        assertEquals(202, response.statusCode());
        JsonNode body = json(response);
        assertFalse(body.get("handled").asBoolean());
        assertTrue(body.get("type").isNull());
        // Falls back to the `webhook-id` header, which is required and always present.
        assertFalse(body.get("event_id").asText().isEmpty());
    }

    @Test
    void rejectsAnEventSignedWithAnotherSecret() throws Exception {
        String other =
                "whsec_"
                        + Base64.getEncoder()
                                .encodeToString("a-different-secret".getBytes(StandardCharsets.UTF_8));
        HttpResponse<String> response = postSignedWebhook("{\"id\":\"evt_3\"}", other);

        assertEquals(400, response.statusCode());
        assertErrorEnvelope(json(response), "WEBHOOK_SIGNATURE_INVALID");
    }

    @Test
    void rejectsAnEventWithNoSignatureHeadersAtAll() throws Exception {
        HttpResponse<String> response = post("/api/webhooks/meteroid", null, "{\"id\":\"evt_4\"}");
        assertEquals(400, response.statusCode());
        assertErrorEnvelope(json(response), "WEBHOOK_SIGNATURE_INVALID");
    }

    /**
     * The signature is computed over the exact bytes sent. Verifying a re-serialized body is the
     * classic bug, so this signs one spelling and sends another.
     */
    @Test
    void rejectsABodyThatWasReserializedAfterSigning() throws Exception {
        String signed = "{\"id\":\"evt_5\",\"type\":\"invoice.paid\"}";
        String reserialized = "{\"type\": \"invoice.paid\", \"id\": \"evt_5\"}";

        String msgId = "msg_reserialized";
        long timestamp = Instant.now().getEpochSecond();
        String signature = new Webhook(WEBHOOK_SECRET).sign(msgId, timestamp, signed);

        HttpResponse<String> response =
                HTTP.send(
                        HttpRequest.newBuilder(uri("/api/webhooks/meteroid"))
                                .header("Content-Type", "application/json")
                                .header("webhook-id", msgId)
                                .header("webhook-timestamp", String.valueOf(timestamp))
                                .header("webhook-signature", signature)
                                .POST(HttpRequest.BodyPublishers.ofString(reserialized))
                                .build(),
                        HttpResponse.BodyHandlers.ofString());

        assertEquals(400, response.statusCode());
        assertErrorEnvelope(json(response), "WEBHOOK_SIGNATURE_INVALID");
    }

    /** An unset METEROID_WEBHOOK_SECRET is an operator problem, never "your signature is bad". */
    @Test
    void reportsAnUnconfiguredWebhookSecretAsAnInternalError() throws Exception {
        Javalin unconfigured =
                Main.router(new AppState(Config.forTests(SESSION_SECRET, "")));
        unconfigured.start(0);
        try {
            HttpResponse<String> response =
                    HTTP.send(
                            HttpRequest.newBuilder(
                                            URI.create(
                                                    "http://localhost:"
                                                            + unconfigured.port()
                                                            + "/api/webhooks/meteroid"))
                                    .header("Content-Type", "application/json")
                                    .POST(HttpRequest.BodyPublishers.ofString("{}"))
                                    .build(),
                            HttpResponse.BodyHandlers.ofString());

            assertEquals(500, response.statusCode());
            assertErrorEnvelope(json(response), "INTERNAL");
        } finally {
            unconfigured.stop();
        }
    }

    // ------------------------------------------------------------------ helpers

    private static String token() {
        return SessionToken.mint(SESSION_SECRET, "scribe-demo-test");
    }

    private static URI uri(String path) {
        return URI.create("http://localhost:" + port + path);
    }

    private static HttpResponse<String> get(String path, String bearer)
            throws IOException, InterruptedException {
        HttpRequest.Builder request = HttpRequest.newBuilder(uri(path)).GET();
        if (bearer != null) {
            request.header("Authorization", "Bearer " + bearer);
        }
        return HTTP.send(request.build(), HttpResponse.BodyHandlers.ofString());
    }

    private static HttpResponse<String> post(String path, String bearer, String body)
            throws IOException, InterruptedException {
        HttpRequest.Builder request =
                HttpRequest.newBuilder(uri(path))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(body));
        if (bearer != null) {
            request.header("Authorization", "Bearer " + bearer);
        }
        return HTTP.send(request.build(), HttpResponse.BodyHandlers.ofString());
    }

    private static HttpResponse<String> postSignedWebhook(String payload, String signingSecret)
            throws Exception {
        String msgId = "msg_" + Math.abs(payload.hashCode());
        long timestamp = Instant.now().getEpochSecond();
        String signature = new Webhook(signingSecret).sign(msgId, timestamp, payload);

        return HTTP.send(
                HttpRequest.newBuilder(uri("/api/webhooks/meteroid"))
                        .header("Content-Type", "application/json")
                        .header("webhook-id", msgId)
                        .header("webhook-timestamp", String.valueOf(timestamp))
                        .header("webhook-signature", signature)
                        .POST(HttpRequest.BodyPublishers.ofString(payload))
                        .build(),
                HttpResponse.BodyHandlers.ofString());
    }

    private static JsonNode json(HttpResponse<String> response) throws IOException {
        return Json.mapper().readTree(response.body());
    }

    /**
     * The contract's error envelope has exactly four keys, and {@code quota} and {@code
     * upgrade_plan_code} are always present — {@code null} where they do not apply.
     */
    private static void assertErrorEnvelope(JsonNode body, String expectedCode) {
        assertEquals(expectedCode, body.get("code").asText());
        assertTrue(body.get("message").isTextual());
        assertTrue(body.has("quota"));
        assertTrue(body.has("upgrade_plan_code"));
        assertEquals(4, body.size(), "the error envelope is additionalProperties: false");
    }
}
