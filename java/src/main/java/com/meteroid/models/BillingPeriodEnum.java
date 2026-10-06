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
public final class BillingPeriodEnum implements ToQueryParam {
    /** The value {@code "MONTHLY"}. */
    public static final BillingPeriodEnum MONTHLY = new BillingPeriodEnum("MONTHLY", Value.MONTHLY);

    /** The value {@code "QUARTERLY"}. */
    public static final BillingPeriodEnum QUARTERLY =
            new BillingPeriodEnum("QUARTERLY", Value.QUARTERLY);

    /** The value {@code "SEMIANNUAL"}. */
    public static final BillingPeriodEnum SEMIANNUAL =
            new BillingPeriodEnum("SEMIANNUAL", Value.SEMIANNUAL);

    /** The value {@code "ANNUAL"}. */
    public static final BillingPeriodEnum ANNUAL = new BillingPeriodEnum("ANNUAL", Value.ANNUAL);

    private static final Map<String, BillingPeriodEnum> constants =
            Map.ofEntries(
                    Map.entry("MONTHLY", MONTHLY),
                    Map.entry("QUARTERLY", QUARTERLY),
                    Map.entry("SEMIANNUAL", SEMIANNUAL),
                    Map.entry("ANNUAL", ANNUAL));

    private final String value;
    private final Value variant;

    private BillingPeriodEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown BillingPeriodEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BillingPeriodEnum of(String value) {
        BillingPeriodEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new BillingPeriodEnum(value, Value._UNKNOWN);
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
                    "unknown BillingPeriodEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BillingPeriodEnum
                && Objects.equals(value, ((BillingPeriodEnum) o).value);
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
        /** The {@code MONTHLY} constant. */
        MONTHLY,
        /** The {@code QUARTERLY} constant. */
        QUARTERLY,
        /** The {@code SEMIANNUAL} constant. */
        SEMIANNUAL,
        /** The {@code ANNUAL} constant. */
        ANNUAL
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code MONTHLY} constant. */
        MONTHLY,
        /** The {@code QUARTERLY} constant. */
        QUARTERLY,
        /** The {@code SEMIANNUAL} constant. */
        SEMIANNUAL,
        /** The {@code ANNUAL} constant. */
        ANNUAL,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
