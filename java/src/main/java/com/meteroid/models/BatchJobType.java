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
public final class BatchJobType implements ToQueryParam {
    /** The value {@code "EVENT_CSV_IMPORT"}. */
    public static final BatchJobType EVENT_CSV_IMPORT =
            new BatchJobType("EVENT_CSV_IMPORT", Value.EVENT_CSV_IMPORT);

    /** The value {@code "CUSTOMER_CSV_IMPORT"}. */
    public static final BatchJobType CUSTOMER_CSV_IMPORT =
            new BatchJobType("CUSTOMER_CSV_IMPORT", Value.CUSTOMER_CSV_IMPORT);

    /** The value {@code "SUBSCRIPTION_CSV_IMPORT"}. */
    public static final BatchJobType SUBSCRIPTION_CSV_IMPORT =
            new BatchJobType("SUBSCRIPTION_CSV_IMPORT", Value.SUBSCRIPTION_CSV_IMPORT);

    /** The value {@code "SUBSCRIPTION_PLAN_MIGRATION"}. */
    public static final BatchJobType SUBSCRIPTION_PLAN_MIGRATION =
            new BatchJobType("SUBSCRIPTION_PLAN_MIGRATION", Value.SUBSCRIPTION_PLAN_MIGRATION);

    /** The value {@code "TAX_REPORT_EXPORT"}. */
    public static final BatchJobType TAX_REPORT_EXPORT =
            new BatchJobType("TAX_REPORT_EXPORT", Value.TAX_REPORT_EXPORT);

    private static final Map<String, BatchJobType> constants =
            Map.ofEntries(
                    Map.entry("EVENT_CSV_IMPORT", EVENT_CSV_IMPORT),
                    Map.entry("CUSTOMER_CSV_IMPORT", CUSTOMER_CSV_IMPORT),
                    Map.entry("SUBSCRIPTION_CSV_IMPORT", SUBSCRIPTION_CSV_IMPORT),
                    Map.entry("SUBSCRIPTION_PLAN_MIGRATION", SUBSCRIPTION_PLAN_MIGRATION),
                    Map.entry("TAX_REPORT_EXPORT", TAX_REPORT_EXPORT));

    private final String value;
    private final Value variant;

    private BatchJobType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown BatchJobType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BatchJobType of(String value) {
        BatchJobType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new BatchJobType(value, Value._UNKNOWN);
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
                    "unknown BatchJobType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BatchJobType && Objects.equals(value, ((BatchJobType) o).value);
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
        /** The {@code EVENT_CSV_IMPORT} constant. */
        EVENT_CSV_IMPORT,
        /** The {@code CUSTOMER_CSV_IMPORT} constant. */
        CUSTOMER_CSV_IMPORT,
        /** The {@code SUBSCRIPTION_CSV_IMPORT} constant. */
        SUBSCRIPTION_CSV_IMPORT,
        /** The {@code SUBSCRIPTION_PLAN_MIGRATION} constant. */
        SUBSCRIPTION_PLAN_MIGRATION,
        /** The {@code TAX_REPORT_EXPORT} constant. */
        TAX_REPORT_EXPORT
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code EVENT_CSV_IMPORT} constant. */
        EVENT_CSV_IMPORT,
        /** The {@code CUSTOMER_CSV_IMPORT} constant. */
        CUSTOMER_CSV_IMPORT,
        /** The {@code SUBSCRIPTION_CSV_IMPORT} constant. */
        SUBSCRIPTION_CSV_IMPORT,
        /** The {@code SUBSCRIPTION_PLAN_MIGRATION} constant. */
        SUBSCRIPTION_PLAN_MIGRATION,
        /** The {@code TAX_REPORT_EXPORT} constant. */
        TAX_REPORT_EXPORT,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
