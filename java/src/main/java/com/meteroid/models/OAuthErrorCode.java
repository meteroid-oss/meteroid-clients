// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * OAuth 2.0 error codes as per RFC 6749
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class OAuthErrorCode implements ToQueryParam {
    /** The value {@code "invalid_request"}. */
    public static final OAuthErrorCode INVALID_REQUEST =
            new OAuthErrorCode("invalid_request", Value.INVALID_REQUEST);

    /** The value {@code "unauthorized_client"}. */
    public static final OAuthErrorCode UNAUTHORIZED_CLIENT =
            new OAuthErrorCode("unauthorized_client", Value.UNAUTHORIZED_CLIENT);

    /** The value {@code "access_denied"}. */
    public static final OAuthErrorCode ACCESS_DENIED =
            new OAuthErrorCode("access_denied", Value.ACCESS_DENIED);

    /** The value {@code "unsupported_response_type"}. */
    public static final OAuthErrorCode UNSUPPORTED_RESPONSE_TYPE =
            new OAuthErrorCode("unsupported_response_type", Value.UNSUPPORTED_RESPONSE_TYPE);

    /** The value {@code "invalid_scope"}. */
    public static final OAuthErrorCode INVALID_SCOPE =
            new OAuthErrorCode("invalid_scope", Value.INVALID_SCOPE);

    /** The value {@code "server_error"}. */
    public static final OAuthErrorCode SERVER_ERROR =
            new OAuthErrorCode("server_error", Value.SERVER_ERROR);

    /** The value {@code "temporarily_unavailable"}. */
    public static final OAuthErrorCode TEMPORARILY_UNAVAILABLE =
            new OAuthErrorCode("temporarily_unavailable", Value.TEMPORARILY_UNAVAILABLE);

    /** The value {@code "invalid_grant"}. */
    public static final OAuthErrorCode INVALID_GRANT =
            new OAuthErrorCode("invalid_grant", Value.INVALID_GRANT);

    /** The value {@code "invalid_client"}. */
    public static final OAuthErrorCode INVALID_CLIENT =
            new OAuthErrorCode("invalid_client", Value.INVALID_CLIENT);

    /** The value {@code "unsupported_grant_type"}. */
    public static final OAuthErrorCode UNSUPPORTED_GRANT_TYPE =
            new OAuthErrorCode("unsupported_grant_type", Value.UNSUPPORTED_GRANT_TYPE);

    private static final Map<String, OAuthErrorCode> constants =
            Map.ofEntries(
                    Map.entry("invalid_request", INVALID_REQUEST),
                    Map.entry("unauthorized_client", UNAUTHORIZED_CLIENT),
                    Map.entry("access_denied", ACCESS_DENIED),
                    Map.entry("unsupported_response_type", UNSUPPORTED_RESPONSE_TYPE),
                    Map.entry("invalid_scope", INVALID_SCOPE),
                    Map.entry("server_error", SERVER_ERROR),
                    Map.entry("temporarily_unavailable", TEMPORARILY_UNAVAILABLE),
                    Map.entry("invalid_grant", INVALID_GRANT),
                    Map.entry("invalid_client", INVALID_CLIENT),
                    Map.entry("unsupported_grant_type", UNSUPPORTED_GRANT_TYPE));

    private final String value;
    private final Value variant;

    private OAuthErrorCode(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown OAuthErrorCode holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OAuthErrorCode of(String value) {
        OAuthErrorCode constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new OAuthErrorCode(value, Value._UNKNOWN);
    }

    /**
     * The value as sent.
     *
     * @return the value
     */
    @JsonValue
    public String asString() {
        return value;
    }

    /**
     * Whether this version of the SDK knows the value.
     *
     * @return whether it is known
     */
    public boolean isKnown() {
        return variant != Value._UNKNOWN;
    }

    /**
     * The value as an enum to switch on, unknown values included.
     *
     * @return the enum, {@code _UNKNOWN} when unknown
     */
    public Value value() {
        return variant;
    }

    /**
     * The value as an enum of the known values only.
     *
     * @return the enum
     * @throws com.meteroid.exceptions.InvalidDataException when this version of the SDK does not
     *     know the value
     */
    public Known known() {
        if (!isKnown()) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown OAuthErrorCode: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof OAuthErrorCode && Objects.equals(value, ((OAuthErrorCode) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /** The values this version of the SDK knows. */
    public enum Known {
        /** The {@code INVALID_REQUEST} constant. */
        INVALID_REQUEST,
        /** The {@code UNAUTHORIZED_CLIENT} constant. */
        UNAUTHORIZED_CLIENT,
        /** The {@code ACCESS_DENIED} constant. */
        ACCESS_DENIED,
        /** The {@code UNSUPPORTED_RESPONSE_TYPE} constant. */
        UNSUPPORTED_RESPONSE_TYPE,
        /** The {@code INVALID_SCOPE} constant. */
        INVALID_SCOPE,
        /** The {@code SERVER_ERROR} constant. */
        SERVER_ERROR,
        /** The {@code TEMPORARILY_UNAVAILABLE} constant. */
        TEMPORARILY_UNAVAILABLE,
        /** The {@code INVALID_GRANT} constant. */
        INVALID_GRANT,
        /** The {@code INVALID_CLIENT} constant. */
        INVALID_CLIENT,
        /** The {@code UNSUPPORTED_GRANT_TYPE} constant. */
        UNSUPPORTED_GRANT_TYPE
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code INVALID_REQUEST} constant. */
        INVALID_REQUEST,
        /** The {@code UNAUTHORIZED_CLIENT} constant. */
        UNAUTHORIZED_CLIENT,
        /** The {@code ACCESS_DENIED} constant. */
        ACCESS_DENIED,
        /** The {@code UNSUPPORTED_RESPONSE_TYPE} constant. */
        UNSUPPORTED_RESPONSE_TYPE,
        /** The {@code INVALID_SCOPE} constant. */
        INVALID_SCOPE,
        /** The {@code SERVER_ERROR} constant. */
        SERVER_ERROR,
        /** The {@code TEMPORARILY_UNAVAILABLE} constant. */
        TEMPORARILY_UNAVAILABLE,
        /** The {@code INVALID_GRANT} constant. */
        INVALID_GRANT,
        /** The {@code INVALID_CLIENT} constant. */
        INVALID_CLIENT,
        /** The {@code UNSUPPORTED_GRANT_TYPE} constant. */
        UNSUPPORTED_GRANT_TYPE,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
