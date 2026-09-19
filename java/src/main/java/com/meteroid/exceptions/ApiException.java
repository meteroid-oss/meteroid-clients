package com.meteroid.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meteroid.Utils;
import com.meteroid.models.OAuthErrorResponse;
import com.meteroid.models.RestErrorResponse;

import java.util.Optional;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * Thrown when the API responds with a non-2xx status.
 *
 * <p>The HTTP status ({@link #getCode()}) and the raw response body ({@link #getResponseBody()})
 * are always available. On top of that, the body is parsed as a {@link RestErrorResponse} first
 * ({@link #getError()}) and, failing that, as an {@link OAuthErrorResponse} ({@link
 * #getOAuthError()}). At most one of the two is present; neither is when the body matches none of
 * the API's error schemas.
 *
 * <p>The typed parse is strict: a body carrying an error code this version of the SDK doesn't
 * know (e.g. a new {@code ErrorCode} added server-side) does not parse, and only the status and
 * raw body are available.
 */
@Getter
public class ApiException extends Exception {
    private static final ObjectMapper DEFAULT_MAPPER = Utils.getObjectMapper();

    String message;
    String responseBody;
    int code;

    @Getter(AccessLevel.NONE)
    private final transient RestErrorResponse error;

    @Getter(AccessLevel.NONE)
    private final transient OAuthErrorResponse oauthError;

    public ApiException(final String message, final int code, final String responseBody) {
        this(message, code, responseBody, DEFAULT_MAPPER);
    }

    /**
     * Same as {@link #ApiException(String, int, String)}, parsing the body with the given mapper.
     */
    public ApiException(
            final String message,
            final int code,
            final String responseBody,
            final ObjectMapper objectMapper) {
        this.message = message;
        this.code = code;
        this.responseBody = responseBody;
        this.error = parseRestError(objectMapper, responseBody);
        this.oauthError = this.error == null ? parseOAuthError(objectMapper, responseBody) : null;
    }

    /** The parsed API error, if the body is a {@link RestErrorResponse}. */
    public Optional<RestErrorResponse> getError() {
        return Optional.ofNullable(error);
    }

    /** The parsed OAuth 2.0 error (RFC 6749 §5.2), if the body is an {@link OAuthErrorResponse}. */
    public Optional<OAuthErrorResponse> getOAuthError() {
        return Optional.ofNullable(oauthError);
    }

    private static RestErrorResponse parseRestError(ObjectMapper mapper, String body) {
        if (body == null || body.isEmpty()) {
            return null;
        }
        try {
            RestErrorResponse parsed = mapper.readValue(body, RestErrorResponse.class);
            // Unknown properties are ignored by the mapper, so enforce the required fields here.
            if (parsed == null || parsed.getCode() == null || parsed.getMessage() == null) {
                return null;
            }
            return parsed;
        } catch (Exception e) {
            return null;
        }
    }

    private static OAuthErrorResponse parseOAuthError(ObjectMapper mapper, String body) {
        if (body == null || body.isEmpty()) {
            return null;
        }
        try {
            OAuthErrorResponse parsed = mapper.readValue(body, OAuthErrorResponse.class);
            if (parsed == null || parsed.getError() == null) {
                return null;
            }
            return parsed;
        } catch (Exception e) {
            return null;
        }
    }
}
