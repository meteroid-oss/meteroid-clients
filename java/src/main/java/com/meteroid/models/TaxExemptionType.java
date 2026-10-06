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
public final class TaxExemptionType implements ToQueryParam {
    /** The value {@code "REVERSE_CHARGE"}. */
    public static final TaxExemptionType REVERSE_CHARGE =
            new TaxExemptionType("REVERSE_CHARGE", Value.REVERSE_CHARGE);

    /** The value {@code "TAX_EXEMPT"}. */
    public static final TaxExemptionType TAX_EXEMPT =
            new TaxExemptionType("TAX_EXEMPT", Value.TAX_EXEMPT);

    /** The value {@code "NOT_REGISTERED"}. */
    public static final TaxExemptionType NOT_REGISTERED =
            new TaxExemptionType("NOT_REGISTERED", Value.NOT_REGISTERED);

    /** The value {@code "EXPORT"}. */
    public static final TaxExemptionType EXPORT = new TaxExemptionType("EXPORT", Value.EXPORT);

    /** The value {@code "NO_VAT_TERRITORY"}. */
    public static final TaxExemptionType NO_VAT_TERRITORY =
            new TaxExemptionType("NO_VAT_TERRITORY", Value.NO_VAT_TERRITORY);

    private static final Map<String, TaxExemptionType> constants =
            Map.ofEntries(
                    Map.entry("REVERSE_CHARGE", REVERSE_CHARGE),
                    Map.entry("TAX_EXEMPT", TAX_EXEMPT),
                    Map.entry("NOT_REGISTERED", NOT_REGISTERED),
                    Map.entry("EXPORT", EXPORT),
                    Map.entry("NO_VAT_TERRITORY", NO_VAT_TERRITORY));

    private final String value;
    private final Value variant;

    private TaxExemptionType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown TaxExemptionType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static TaxExemptionType of(String value) {
        TaxExemptionType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new TaxExemptionType(value, Value._UNKNOWN);
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
                    "unknown TaxExemptionType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TaxExemptionType && Objects.equals(value, ((TaxExemptionType) o).value);
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
        /** The {@code REVERSE_CHARGE} constant. */
        REVERSE_CHARGE,
        /** The {@code TAX_EXEMPT} constant. */
        TAX_EXEMPT,
        /** The {@code NOT_REGISTERED} constant. */
        NOT_REGISTERED,
        /** The {@code EXPORT} constant. */
        EXPORT,
        /** The {@code NO_VAT_TERRITORY} constant. */
        NO_VAT_TERRITORY
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code REVERSE_CHARGE} constant. */
        REVERSE_CHARGE,
        /** The {@code TAX_EXEMPT} constant. */
        TAX_EXEMPT,
        /** The {@code NOT_REGISTERED} constant. */
        NOT_REGISTERED,
        /** The {@code EXPORT} constant. */
        EXPORT,
        /** The {@code NO_VAT_TERRITORY} constant. */
        NO_VAT_TERRITORY,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
