package com.meteroid.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import com.meteroid.models.ErrorCode;
import com.meteroid.models.OAuthErrorCode;

import org.junit.Test;

public class ApiExceptionTest {
    @Test
    public void restErrorResponseIsParsed() {
        String body = "{\"code\":\"NOT_FOUND\",\"message\":\"no such customer\"}";
        ApiException e = new ApiException("msg", 404, body);

        assertThat(e.getCode()).isEqualTo(404);
        assertThat(e.getResponseBody()).isEqualTo(body);
        assertThat(e.getMessage()).isEqualTo("msg");
        assertThat(e.getError()).isPresent();
        assertThat(e.getError().get().getCode()).isEqualTo(ErrorCode.NOT_FOUND);
        assertThat(e.getError().get().getMessage()).isEqualTo("no such customer");
        assertThat(e.getOAuthError()).isEmpty();
    }

    @Test
    public void oauthErrorResponseIsParsedWhenNotARestError() {
        String body = "{\"error\":\"invalid_client\",\"error_uri\":\"https://example.com\"}";
        ApiException e = new ApiException("msg", 401, body);

        assertThat(e.getError()).isEmpty();
        assertThat(e.getOAuthError()).isPresent();
        assertThat(e.getOAuthError().get().getError()).isEqualTo(OAuthErrorCode.INVALID_CLIENT);
        assertThat(e.getOAuthError().get().getErrorDescription()).isNull();
        assertThat(e.getOAuthError().get().getErrorUri()).isEqualTo("https://example.com");
    }

    @Test
    public void missingRequiredFieldIsNotARestError() {
        // The mapper ignores unknown properties, so a body lacking `message` must not
        // be reported as a RestErrorResponse with a null message.
        ApiException e = new ApiException("msg", 400, "{\"code\":\"BAD_REQUEST\"}");

        assertThat(e.getError()).isEmpty();
        assertThat(e.getOAuthError()).isEmpty();
    }

    @Test
    public void unknownErrorCodeHasNoTypedError() {
        String body = "{\"code\":\"SOMETHING_NEW\",\"message\":\"new server-side code\"}";
        ApiException e = new ApiException("msg", 409, body);

        assertThat(e.getError()).isEmpty();
        assertThat(e.getOAuthError()).isEmpty();
        assertThat(e.getCode()).isEqualTo(409);
        assertThat(e.getResponseBody()).isEqualTo(body);
    }

    @Test
    public void nonJsonAndEmptyBodiesHaveNoTypedError() {
        for (String body : new String[] {"", "null", "not json", "{}", "[]"}) {
            ApiException e = new ApiException("msg", 500, body);
            assertThat(e.getError()).as(body).isEmpty();
            assertThat(e.getOAuthError()).as(body).isEmpty();
            assertThat(e.getResponseBody()).isEqualTo(body);
        }
        ApiException e = new ApiException("msg", 500, null);
        assertThat(e.getError()).isEmpty();
        assertThat(e.getOAuthError()).isEmpty();
    }
}
