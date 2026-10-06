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
public final class PaymentTypeEnum implements ToQueryParam {
    /** The value {@code "PAYMENT"}. */
    public static final PaymentTypeEnum PAYMENT = new PaymentTypeEnum("PAYMENT", Value.PAYMENT);

    /** The value {@code "REFUND"}. */
    public static final PaymentTypeEnum REFUND = new PaymentTypeEnum("REFUND", Value.REFUND);

    private static final Map<String, PaymentTypeEnum> constants =
            Map.ofEntries(Map.entry("PAYMENT", PAYMENT), Map.entry("REFUND", REFUND));

    private final String value;
    private final Value variant;

    private PaymentTypeEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown PaymentTypeEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PaymentTypeEnum of(String value) {
        PaymentTypeEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new PaymentTypeEnum(value, Value._UNKNOWN);
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
                    "unknown PaymentTypeEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof PaymentTypeEnum && Objects.equals(value, ((PaymentTypeEnum) o).value);
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
        /** The {@code PAYMENT} constant. */
        PAYMENT,
        /** The {@code REFUND} constant. */
        REFUND
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code PAYMENT} constant. */
        PAYMENT,
        /** The {@code REFUND} constant. */
        REFUND,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
