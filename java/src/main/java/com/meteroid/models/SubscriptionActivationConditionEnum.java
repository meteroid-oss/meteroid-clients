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
public final class SubscriptionActivationConditionEnum implements ToQueryParam {
    /** The value {@code "ON_START"}. */
    public static final SubscriptionActivationConditionEnum ON_START =
            new SubscriptionActivationConditionEnum("ON_START", Value.ON_START);

    /** The value {@code "ON_CHECKOUT"}. */
    public static final SubscriptionActivationConditionEnum ON_CHECKOUT =
            new SubscriptionActivationConditionEnum("ON_CHECKOUT", Value.ON_CHECKOUT);

    /** The value {@code "MANUAL"}. */
    public static final SubscriptionActivationConditionEnum MANUAL =
            new SubscriptionActivationConditionEnum("MANUAL", Value.MANUAL);

    private static final Map<String, SubscriptionActivationConditionEnum> constants =
            Map.ofEntries(
                    Map.entry("ON_START", ON_START),
                    Map.entry("ON_CHECKOUT", ON_CHECKOUT),
                    Map.entry("MANUAL", MANUAL));

    private final String value;
    private final Value variant;

    private SubscriptionActivationConditionEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown SubscriptionActivationConditionEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SubscriptionActivationConditionEnum of(String value) {
        SubscriptionActivationConditionEnum constant =
                constants.get(Objects.requireNonNull(value, "value"));
        return constant != null
                ? constant
                : new SubscriptionActivationConditionEnum(value, Value._UNKNOWN);
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
                    "unknown SubscriptionActivationConditionEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SubscriptionActivationConditionEnum
                && Objects.equals(value, ((SubscriptionActivationConditionEnum) o).value);
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
        /** The {@code ON_START} constant. */
        ON_START,
        /** The {@code ON_CHECKOUT} constant. */
        ON_CHECKOUT,
        /** The {@code MANUAL} constant. */
        MANUAL
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code ON_START} constant. */
        ON_START,
        /** The {@code ON_CHECKOUT} constant. */
        ON_CHECKOUT,
        /** The {@code MANUAL} constant. */
        MANUAL,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
