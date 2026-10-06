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
public final class SubscriptionFeeBillingPeriodEnum implements ToQueryParam {
    /** The value {@code "ONE_TIME"}. */
    public static final SubscriptionFeeBillingPeriodEnum ONE_TIME =
            new SubscriptionFeeBillingPeriodEnum("ONE_TIME", Value.ONE_TIME);

    /** The value {@code "MONTHLY"}. */
    public static final SubscriptionFeeBillingPeriodEnum MONTHLY =
            new SubscriptionFeeBillingPeriodEnum("MONTHLY", Value.MONTHLY);

    /** The value {@code "QUARTERLY"}. */
    public static final SubscriptionFeeBillingPeriodEnum QUARTERLY =
            new SubscriptionFeeBillingPeriodEnum("QUARTERLY", Value.QUARTERLY);

    /** The value {@code "SEMIANNUAL"}. */
    public static final SubscriptionFeeBillingPeriodEnum SEMIANNUAL =
            new SubscriptionFeeBillingPeriodEnum("SEMIANNUAL", Value.SEMIANNUAL);

    /** The value {@code "ANNUAL"}. */
    public static final SubscriptionFeeBillingPeriodEnum ANNUAL =
            new SubscriptionFeeBillingPeriodEnum("ANNUAL", Value.ANNUAL);

    private static final Map<String, SubscriptionFeeBillingPeriodEnum> constants =
            Map.ofEntries(
                    Map.entry("ONE_TIME", ONE_TIME),
                    Map.entry("MONTHLY", MONTHLY),
                    Map.entry("QUARTERLY", QUARTERLY),
                    Map.entry("SEMIANNUAL", SEMIANNUAL),
                    Map.entry("ANNUAL", ANNUAL));

    private final String value;
    private final Value variant;

    private SubscriptionFeeBillingPeriodEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown SubscriptionFeeBillingPeriodEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SubscriptionFeeBillingPeriodEnum of(String value) {
        SubscriptionFeeBillingPeriodEnum constant =
                constants.get(Objects.requireNonNull(value, "value"));
        return constant != null
                ? constant
                : new SubscriptionFeeBillingPeriodEnum(value, Value._UNKNOWN);
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
                    "unknown SubscriptionFeeBillingPeriodEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SubscriptionFeeBillingPeriodEnum
                && Objects.equals(value, ((SubscriptionFeeBillingPeriodEnum) o).value);
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
        /** The {@code ONE_TIME} constant. */
        ONE_TIME,
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
        /** The {@code ONE_TIME} constant. */
        ONE_TIME,
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
