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
public final class BillingMetricAggregateEnum implements ToQueryParam {
    /** The value {@code "COUNT"}. */
    public static final BillingMetricAggregateEnum COUNT =
            new BillingMetricAggregateEnum("COUNT", Value.COUNT);

    /** The value {@code "LATEST"}. */
    public static final BillingMetricAggregateEnum LATEST =
            new BillingMetricAggregateEnum("LATEST", Value.LATEST);

    /** The value {@code "MAX"}. */
    public static final BillingMetricAggregateEnum MAX =
            new BillingMetricAggregateEnum("MAX", Value.MAX);

    /** The value {@code "MIN"}. */
    public static final BillingMetricAggregateEnum MIN =
            new BillingMetricAggregateEnum("MIN", Value.MIN);

    /** The value {@code "MEAN"}. */
    public static final BillingMetricAggregateEnum MEAN =
            new BillingMetricAggregateEnum("MEAN", Value.MEAN);

    /** The value {@code "SUM"}. */
    public static final BillingMetricAggregateEnum SUM =
            new BillingMetricAggregateEnum("SUM", Value.SUM);

    /** The value {@code "COUNT_DISTINCT"}. */
    public static final BillingMetricAggregateEnum COUNT_DISTINCT =
            new BillingMetricAggregateEnum("COUNT_DISTINCT", Value.COUNT_DISTINCT);

    private static final Map<String, BillingMetricAggregateEnum> constants =
            Map.ofEntries(
                    Map.entry("COUNT", COUNT),
                    Map.entry("LATEST", LATEST),
                    Map.entry("MAX", MAX),
                    Map.entry("MIN", MIN),
                    Map.entry("MEAN", MEAN),
                    Map.entry("SUM", SUM),
                    Map.entry("COUNT_DISTINCT", COUNT_DISTINCT));

    private final String value;
    private final Value variant;

    private BillingMetricAggregateEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown BillingMetricAggregateEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static BillingMetricAggregateEnum of(String value) {
        BillingMetricAggregateEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new BillingMetricAggregateEnum(value, Value._UNKNOWN);
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
                    "unknown BillingMetricAggregateEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BillingMetricAggregateEnum
                && Objects.equals(value, ((BillingMetricAggregateEnum) o).value);
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
        /** The {@code COUNT} constant. */
        COUNT,
        /** The {@code LATEST} constant. */
        LATEST,
        /** The {@code MAX} constant. */
        MAX,
        /** The {@code MIN} constant. */
        MIN,
        /** The {@code MEAN} constant. */
        MEAN,
        /** The {@code SUM} constant. */
        SUM,
        /** The {@code COUNT_DISTINCT} constant. */
        COUNT_DISTINCT
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code COUNT} constant. */
        COUNT,
        /** The {@code LATEST} constant. */
        LATEST,
        /** The {@code MAX} constant. */
        MAX,
        /** The {@code MIN} constant. */
        MIN,
        /** The {@code MEAN} constant. */
        MEAN,
        /** The {@code SUM} constant. */
        SUM,
        /** The {@code COUNT_DISTINCT} constant. */
        COUNT_DISTINCT,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
