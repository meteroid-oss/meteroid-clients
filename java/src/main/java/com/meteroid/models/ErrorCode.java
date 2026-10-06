// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Values this version of the SDK does not know are kept, and sent back unchanged: {@link #value()}
 * is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on them.
 */
public final class ErrorCode implements ToQueryParam {
    /** The value {@code "BAD_REQUEST"}. */
    public static final ErrorCode BAD_REQUEST = new ErrorCode("BAD_REQUEST", Value.BAD_REQUEST);

    /** The value {@code "NOT_FOUND"}. */
    public static final ErrorCode NOT_FOUND = new ErrorCode("NOT_FOUND", Value.NOT_FOUND);

    /** The value {@code "CONFLICT"}. */
    public static final ErrorCode CONFLICT = new ErrorCode("CONFLICT", Value.CONFLICT);

    /** The value {@code "FORBIDDEN"}. */
    public static final ErrorCode FORBIDDEN = new ErrorCode("FORBIDDEN", Value.FORBIDDEN);

    /** The value {@code "UNAUTHORIZED"}. */
    public static final ErrorCode UNAUTHORIZED = new ErrorCode("UNAUTHORIZED", Value.UNAUTHORIZED);

    /** The value {@code "TOO_MANY_REQUESTS"}. */
    public static final ErrorCode TOO_MANY_REQUESTS =
            new ErrorCode("TOO_MANY_REQUESTS", Value.TOO_MANY_REQUESTS);

    /** The value {@code "INTERNAL_SERVER_ERROR"}. */
    public static final ErrorCode INTERNAL_SERVER_ERROR =
            new ErrorCode("INTERNAL_SERVER_ERROR", Value.INTERNAL_SERVER_ERROR);

    private static final Map<String, ErrorCode> constants =
            Map.ofEntries(
                    Map.entry("BAD_REQUEST", BAD_REQUEST),
                    Map.entry("NOT_FOUND", NOT_FOUND),
                    Map.entry("CONFLICT", CONFLICT),
                    Map.entry("FORBIDDEN", FORBIDDEN),
                    Map.entry("UNAUTHORIZED", UNAUTHORIZED),
                    Map.entry("TOO_MANY_REQUESTS", TOO_MANY_REQUESTS),
                    Map.entry("INTERNAL_SERVER_ERROR", INTERNAL_SERVER_ERROR));

    private final String value;
    private final Value variant;

    private ErrorCode(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown ErrorCode holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ErrorCode of(String value) {
        ErrorCode constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new ErrorCode(value, Value._UNKNOWN);
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
            throw new com.meteroid.exceptions.InvalidDataException("unknown ErrorCode: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ErrorCode && Objects.equals(value, ((ErrorCode) o).value);
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
        /** The {@code BAD_REQUEST} constant. */
        BAD_REQUEST,
        /** The {@code NOT_FOUND} constant. */
        NOT_FOUND,
        /** The {@code CONFLICT} constant. */
        CONFLICT,
        /** The {@code FORBIDDEN} constant. */
        FORBIDDEN,
        /** The {@code UNAUTHORIZED} constant. */
        UNAUTHORIZED,
        /** The {@code TOO_MANY_REQUESTS} constant. */
        TOO_MANY_REQUESTS,
        /** The {@code INTERNAL_SERVER_ERROR} constant. */
        INTERNAL_SERVER_ERROR
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code BAD_REQUEST} constant. */
        BAD_REQUEST,
        /** The {@code NOT_FOUND} constant. */
        NOT_FOUND,
        /** The {@code CONFLICT} constant. */
        CONFLICT,
        /** The {@code FORBIDDEN} constant. */
        FORBIDDEN,
        /** The {@code UNAUTHORIZED} constant. */
        UNAUTHORIZED,
        /** The {@code TOO_MANY_REQUESTS} constant. */
        TOO_MANY_REQUESTS,
        /** The {@code INTERNAL_SERVER_ERROR} constant. */
        INTERNAL_SERVER_ERROR,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
