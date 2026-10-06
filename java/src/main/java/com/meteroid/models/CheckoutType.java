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
public final class CheckoutType implements ToQueryParam {
    /** The value {@code "SELF_SERVE"}. */
    public static final CheckoutType SELF_SERVE = new CheckoutType("SELF_SERVE", Value.SELF_SERVE);

    /** The value {@code "SUBSCRIPTION_ACTIVATION"}. */
    public static final CheckoutType SUBSCRIPTION_ACTIVATION =
            new CheckoutType("SUBSCRIPTION_ACTIVATION", Value.SUBSCRIPTION_ACTIVATION);

    /** The value {@code "PLAN_CHANGE"}. */
    public static final CheckoutType PLAN_CHANGE =
            new CheckoutType("PLAN_CHANGE", Value.PLAN_CHANGE);

    /** The value {@code "ADDON_PURCHASE"}. */
    public static final CheckoutType ADDON_PURCHASE =
            new CheckoutType("ADDON_PURCHASE", Value.ADDON_PURCHASE);

    private static final Map<String, CheckoutType> constants =
            Map.ofEntries(
                    Map.entry("SELF_SERVE", SELF_SERVE),
                    Map.entry("SUBSCRIPTION_ACTIVATION", SUBSCRIPTION_ACTIVATION),
                    Map.entry("PLAN_CHANGE", PLAN_CHANGE),
                    Map.entry("ADDON_PURCHASE", ADDON_PURCHASE));

    private final String value;
    private final Value variant;

    private CheckoutType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CheckoutType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CheckoutType of(String value) {
        CheckoutType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CheckoutType(value, Value._UNKNOWN);
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
                    "unknown CheckoutType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CheckoutType && Objects.equals(value, ((CheckoutType) o).value);
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
        /** The {@code SELF_SERVE} constant. */
        SELF_SERVE,
        /** The {@code SUBSCRIPTION_ACTIVATION} constant. */
        SUBSCRIPTION_ACTIVATION,
        /** The {@code PLAN_CHANGE} constant. */
        PLAN_CHANGE,
        /** The {@code ADDON_PURCHASE} constant. */
        ADDON_PURCHASE
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code SELF_SERVE} constant. */
        SELF_SERVE,
        /** The {@code SUBSCRIPTION_ACTIVATION} constant. */
        SUBSCRIPTION_ACTIVATION,
        /** The {@code PLAN_CHANGE} constant. */
        PLAN_CHANGE,
        /** The {@code ADDON_PURCHASE} constant. */
        ADDON_PURCHASE,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
