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
public final class BatchJobStatus implements ToQueryParam {
    /** The value {@code "PENDING"}. */
    public static final BatchJobStatus PENDING = new BatchJobStatus("PENDING", Value.PENDING);

    /** The value {@code "CHUNKING"}. */
    public static final BatchJobStatus CHUNKING = new BatchJobStatus("CHUNKING", Value.CHUNKING);

    /** The value {@code "PROCESSING"}. */
    public static final BatchJobStatus PROCESSING =
            new BatchJobStatus("PROCESSING", Value.PROCESSING);

    /** The value {@code "COMPLETED"}. */
    public static final BatchJobStatus COMPLETED = new BatchJobStatus("COMPLETED", Value.COMPLETED);

    /** The value {@code "COMPLETED_WITH_ERRORS"}. */
    public static final BatchJobStatus COMPLETED_WITH_ERRORS =
            new BatchJobStatus("COMPLETED_WITH_ERRORS", Value.COMPLETED_WITH_ERRORS);

    /** The value {@code "FAILED"}. */
    public static final BatchJobStatus FAILED = new BatchJobStatus("FAILED", Value.FAILED);

    /** The value {@code "CANCELLED"}. */
    public static final BatchJobStatus CANCELLED = new BatchJobStatus("CANCELLED", Value.CANCELLED);

    private static final Map<String, BatchJobStatus> constants =
            Map.ofEntries(
                    Map.entry("PENDING", PENDING),
                    Map.entry("CHUNKING", CHUNKING),
                    Map.entry("PROCESSING", PROCESSING),
                    Map.entry("COMPLETED", COMPLETED),
                    Map.entry("COMPLETED_WITH_ERRORS", COMPLETED_WITH_ERRORS),
                    Map.entry("FAILED", FAILED),
                    Map.entry("CANCELLED", CANCELLED));

    private final String value;
    private final Value variant;

    private BatchJobStatus(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown BatchJobStatus holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BatchJobStatus of(String value) {
        BatchJobStatus constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new BatchJobStatus(value, Value._UNKNOWN);
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
                    "unknown BatchJobStatus: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BatchJobStatus && Objects.equals(value, ((BatchJobStatus) o).value);
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
        /** The {@code PENDING} constant. */
        PENDING,
        /** The {@code CHUNKING} constant. */
        CHUNKING,
        /** The {@code PROCESSING} constant. */
        PROCESSING,
        /** The {@code COMPLETED} constant. */
        COMPLETED,
        /** The {@code COMPLETED_WITH_ERRORS} constant. */
        COMPLETED_WITH_ERRORS,
        /** The {@code FAILED} constant. */
        FAILED,
        /** The {@code CANCELLED} constant. */
        CANCELLED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code PENDING} constant. */
        PENDING,
        /** The {@code CHUNKING} constant. */
        CHUNKING,
        /** The {@code PROCESSING} constant. */
        PROCESSING,
        /** The {@code COMPLETED} constant. */
        COMPLETED,
        /** The {@code COMPLETED_WITH_ERRORS} constant. */
        COMPLETED_WITH_ERRORS,
        /** The {@code FAILED} constant. */
        FAILED,
        /** The {@code CANCELLED} constant. */
        CANCELLED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
