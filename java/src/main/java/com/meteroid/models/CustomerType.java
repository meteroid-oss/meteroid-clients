// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Company vs. individual (B2C). Defaults to <code>COMPANY</code>.
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class CustomerType implements ToQueryParam {
    /** The value {@code "COMPANY"}. */
    public static final CustomerType COMPANY = new CustomerType("COMPANY", Value.COMPANY);

    /** The value {@code "INDIVIDUAL"}. */
    public static final CustomerType INDIVIDUAL = new CustomerType("INDIVIDUAL", Value.INDIVIDUAL);

    private static final Map<String, CustomerType> constants =
            Map.ofEntries(Map.entry("COMPANY", COMPANY), Map.entry("INDIVIDUAL", INDIVIDUAL));

    private final String value;
    private final Value variant;

    private CustomerType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CustomerType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CustomerType of(String value) {
        CustomerType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CustomerType(value, Value._UNKNOWN);
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
                    "unknown CustomerType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CustomerType && Objects.equals(value, ((CustomerType) o).value);
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
        /** The {@code COMPANY} constant. */
        COMPANY,
        /** The {@code INDIVIDUAL} constant. */
        INDIVIDUAL
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code COMPANY} constant. */
        COMPANY,
        /** The {@code INDIVIDUAL} constant. */
        INDIVIDUAL,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
