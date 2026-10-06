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
public final class ProductFeeTypeEnum implements ToQueryParam {
    /** The value {@code "RATE"}. */
    public static final ProductFeeTypeEnum RATE = new ProductFeeTypeEnum("RATE", Value.RATE);

    /** The value {@code "SLOT"}. */
    public static final ProductFeeTypeEnum SLOT = new ProductFeeTypeEnum("SLOT", Value.SLOT);

    /** The value {@code "CAPACITY"}. */
    public static final ProductFeeTypeEnum CAPACITY =
            new ProductFeeTypeEnum("CAPACITY", Value.CAPACITY);

    /** The value {@code "USAGE"}. */
    public static final ProductFeeTypeEnum USAGE = new ProductFeeTypeEnum("USAGE", Value.USAGE);

    /** The value {@code "EXTRA_RECURRING"}. */
    public static final ProductFeeTypeEnum EXTRA_RECURRING =
            new ProductFeeTypeEnum("EXTRA_RECURRING", Value.EXTRA_RECURRING);

    /** The value {@code "ONE_TIME"}. */
    public static final ProductFeeTypeEnum ONE_TIME =
            new ProductFeeTypeEnum("ONE_TIME", Value.ONE_TIME);

    private static final Map<String, ProductFeeTypeEnum> constants =
            Map.ofEntries(
                    Map.entry("RATE", RATE),
                    Map.entry("SLOT", SLOT),
                    Map.entry("CAPACITY", CAPACITY),
                    Map.entry("USAGE", USAGE),
                    Map.entry("EXTRA_RECURRING", EXTRA_RECURRING),
                    Map.entry("ONE_TIME", ONE_TIME));

    private final String value;
    private final Value variant;

    private ProductFeeTypeEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown ProductFeeTypeEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ProductFeeTypeEnum of(String value) {
        ProductFeeTypeEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new ProductFeeTypeEnum(value, Value._UNKNOWN);
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
                    "unknown ProductFeeTypeEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ProductFeeTypeEnum
                && Objects.equals(value, ((ProductFeeTypeEnum) o).value);
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
        /** The {@code RATE} constant. */
        RATE,
        /** The {@code SLOT} constant. */
        SLOT,
        /** The {@code CAPACITY} constant. */
        CAPACITY,
        /** The {@code USAGE} constant. */
        USAGE,
        /** The {@code EXTRA_RECURRING} constant. */
        EXTRA_RECURRING,
        /** The {@code ONE_TIME} constant. */
        ONE_TIME
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code RATE} constant. */
        RATE,
        /** The {@code SLOT} constant. */
        SLOT,
        /** The {@code CAPACITY} constant. */
        CAPACITY,
        /** The {@code USAGE} constant. */
        USAGE,
        /** The {@code EXTRA_RECURRING} constant. */
        EXTRA_RECURRING,
        /** The {@code ONE_TIME} constant. */
        ONE_TIME,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
