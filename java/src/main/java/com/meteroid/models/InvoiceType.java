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
public final class InvoiceType implements ToQueryParam {
    /** The value {@code "RECURRING"}. */
    public static final InvoiceType RECURRING = new InvoiceType("RECURRING", Value.RECURRING);

    /** The value {@code "ONE_OFF"}. */
    public static final InvoiceType ONE_OFF = new InvoiceType("ONE_OFF", Value.ONE_OFF);

    /** The value {@code "ADJUSTMENT"}. */
    public static final InvoiceType ADJUSTMENT = new InvoiceType("ADJUSTMENT", Value.ADJUSTMENT);

    /** The value {@code "USAGE_THRESHOLD"}. */
    public static final InvoiceType USAGE_THRESHOLD =
            new InvoiceType("USAGE_THRESHOLD", Value.USAGE_THRESHOLD);

    private static final Map<String, InvoiceType> constants =
            Map.ofEntries(
                    Map.entry("RECURRING", RECURRING),
                    Map.entry("ONE_OFF", ONE_OFF),
                    Map.entry("ADJUSTMENT", ADJUSTMENT),
                    Map.entry("USAGE_THRESHOLD", USAGE_THRESHOLD));

    private final String value;
    private final Value variant;

    private InvoiceType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown InvoiceType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static InvoiceType of(String value) {
        InvoiceType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new InvoiceType(value, Value._UNKNOWN);
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
            throw new com.meteroid.exceptions.InvalidDataException("unknown InvoiceType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof InvoiceType && Objects.equals(value, ((InvoiceType) o).value);
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
        /** The {@code RECURRING} constant. */
        RECURRING,
        /** The {@code ONE_OFF} constant. */
        ONE_OFF,
        /** The {@code ADJUSTMENT} constant. */
        ADJUSTMENT,
        /** The {@code USAGE_THRESHOLD} constant. */
        USAGE_THRESHOLD
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code RECURRING} constant. */
        RECURRING,
        /** The {@code ONE_OFF} constant. */
        ONE_OFF,
        /** The {@code ADJUSTMENT} constant. */
        ADJUSTMENT,
        /** The {@code USAGE_THRESHOLD} constant. */
        USAGE_THRESHOLD,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
