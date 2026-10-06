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
public final class CustomPropertyEntityType implements ToQueryParam {
    /** The value {@code "CUSTOMER"}. */
    public static final CustomPropertyEntityType CUSTOMER =
            new CustomPropertyEntityType("CUSTOMER", Value.CUSTOMER);

    /** The value {@code "SUBSCRIPTION"}. */
    public static final CustomPropertyEntityType SUBSCRIPTION =
            new CustomPropertyEntityType("SUBSCRIPTION", Value.SUBSCRIPTION);

    /** The value {@code "INVOICE"}. */
    public static final CustomPropertyEntityType INVOICE =
            new CustomPropertyEntityType("INVOICE", Value.INVOICE);

    /** The value {@code "CREDIT_NOTE"}. */
    public static final CustomPropertyEntityType CREDIT_NOTE =
            new CustomPropertyEntityType("CREDIT_NOTE", Value.CREDIT_NOTE);

    private static final Map<String, CustomPropertyEntityType> constants =
            Map.ofEntries(
                    Map.entry("CUSTOMER", CUSTOMER),
                    Map.entry("SUBSCRIPTION", SUBSCRIPTION),
                    Map.entry("INVOICE", INVOICE),
                    Map.entry("CREDIT_NOTE", CREDIT_NOTE));

    private final String value;
    private final Value variant;

    private CustomPropertyEntityType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CustomPropertyEntityType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CustomPropertyEntityType of(String value) {
        CustomPropertyEntityType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CustomPropertyEntityType(value, Value._UNKNOWN);
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
                    "unknown CustomPropertyEntityType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CustomPropertyEntityType
                && Objects.equals(value, ((CustomPropertyEntityType) o).value);
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
        /** The {@code CUSTOMER} constant. */
        CUSTOMER,
        /** The {@code SUBSCRIPTION} constant. */
        SUBSCRIPTION,
        /** The {@code INVOICE} constant. */
        INVOICE,
        /** The {@code CREDIT_NOTE} constant. */
        CREDIT_NOTE
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code CUSTOMER} constant. */
        CUSTOMER,
        /** The {@code SUBSCRIPTION} constant. */
        SUBSCRIPTION,
        /** The {@code INVOICE} constant. */
        INVOICE,
        /** The {@code CREDIT_NOTE} constant. */
        CREDIT_NOTE,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
