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
public final class CreditType implements ToQueryParam {
    /** The value {@code "CREDIT_TO_BALANCE"}. */
    public static final CreditType CREDIT_TO_BALANCE =
            new CreditType("CREDIT_TO_BALANCE", Value.CREDIT_TO_BALANCE);

    /** The value {@code "REFUND"}. */
    public static final CreditType REFUND = new CreditType("REFUND", Value.REFUND);

    /** The value {@code "DEBT_CANCELLATION"}. */
    public static final CreditType DEBT_CANCELLATION =
            new CreditType("DEBT_CANCELLATION", Value.DEBT_CANCELLATION);

    private static final Map<String, CreditType> constants =
            Map.ofEntries(
                    Map.entry("CREDIT_TO_BALANCE", CREDIT_TO_BALANCE),
                    Map.entry("REFUND", REFUND),
                    Map.entry("DEBT_CANCELLATION", DEBT_CANCELLATION));

    private final String value;
    private final Value variant;

    private CreditType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CreditType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CreditType of(String value) {
        CreditType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CreditType(value, Value._UNKNOWN);
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
            throw new com.meteroid.exceptions.InvalidDataException("unknown CreditType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CreditType && Objects.equals(value, ((CreditType) o).value);
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
        /** The {@code CREDIT_TO_BALANCE} constant. */
        CREDIT_TO_BALANCE,
        /** The {@code REFUND} constant. */
        REFUND,
        /** The {@code DEBT_CANCELLATION} constant. */
        DEBT_CANCELLATION
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code CREDIT_TO_BALANCE} constant. */
        CREDIT_TO_BALANCE,
        /** The {@code REFUND} constant. */
        REFUND,
        /** The {@code DEBT_CANCELLATION} constant. */
        DEBT_CANCELLATION,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
