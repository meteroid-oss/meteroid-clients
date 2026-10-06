// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Identifies which mutation triggered a <code>subscription.updated</code> webhook.
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class SubscriptionUpdateType implements ToQueryParam {
    /** The value {@code "activated"}. */
    public static final SubscriptionUpdateType ACTIVATED =
            new SubscriptionUpdateType("activated", Value.ACTIVATED);

    /** The value {@code "trial_ended"}. */
    public static final SubscriptionUpdateType TRIAL_ENDED =
            new SubscriptionUpdateType("trial_ended", Value.TRIAL_ENDED);

    /** The value {@code "billing_configuration_updated"}. */
    public static final SubscriptionUpdateType BILLING_CONFIGURATION_UPDATED =
            new SubscriptionUpdateType(
                    "billing_configuration_updated", Value.BILLING_CONFIGURATION_UPDATED);

    /** The value {@code "plan_changed"}. */
    public static final SubscriptionUpdateType PLAN_CHANGED =
            new SubscriptionUpdateType("plan_changed", Value.PLAN_CHANGED);

    /** The value {@code "amended"}. */
    public static final SubscriptionUpdateType AMENDED =
            new SubscriptionUpdateType("amended", Value.AMENDED);

    /** The value {@code "units_changed"}. */
    public static final SubscriptionUpdateType UNITS_CHANGED =
            new SubscriptionUpdateType("units_changed", Value.UNITS_CHANGED);

    /** The value {@code "paused"}. */
    public static final SubscriptionUpdateType PAUSED =
            new SubscriptionUpdateType("paused", Value.PAUSED);

    /** The value {@code "cancellation_scheduled"}. */
    public static final SubscriptionUpdateType CANCELLATION_SCHEDULED =
            new SubscriptionUpdateType("cancellation_scheduled", Value.CANCELLATION_SCHEDULED);

    private static final Map<String, SubscriptionUpdateType> constants =
            Map.ofEntries(
                    Map.entry("activated", ACTIVATED),
                    Map.entry("trial_ended", TRIAL_ENDED),
                    Map.entry("billing_configuration_updated", BILLING_CONFIGURATION_UPDATED),
                    Map.entry("plan_changed", PLAN_CHANGED),
                    Map.entry("amended", AMENDED),
                    Map.entry("units_changed", UNITS_CHANGED),
                    Map.entry("paused", PAUSED),
                    Map.entry("cancellation_scheduled", CANCELLATION_SCHEDULED));

    private final String value;
    private final Value variant;

    private SubscriptionUpdateType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown SubscriptionUpdateType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SubscriptionUpdateType of(String value) {
        SubscriptionUpdateType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new SubscriptionUpdateType(value, Value._UNKNOWN);
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
                    "unknown SubscriptionUpdateType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SubscriptionUpdateType
                && Objects.equals(value, ((SubscriptionUpdateType) o).value);
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
        /** The {@code ACTIVATED} constant. */
        ACTIVATED,
        /** The {@code TRIAL_ENDED} constant. */
        TRIAL_ENDED,
        /** The {@code BILLING_CONFIGURATION_UPDATED} constant. */
        BILLING_CONFIGURATION_UPDATED,
        /** The {@code PLAN_CHANGED} constant. */
        PLAN_CHANGED,
        /** The {@code AMENDED} constant. */
        AMENDED,
        /** The {@code UNITS_CHANGED} constant. */
        UNITS_CHANGED,
        /** The {@code PAUSED} constant. */
        PAUSED,
        /** The {@code CANCELLATION_SCHEDULED} constant. */
        CANCELLATION_SCHEDULED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code ACTIVATED} constant. */
        ACTIVATED,
        /** The {@code TRIAL_ENDED} constant. */
        TRIAL_ENDED,
        /** The {@code BILLING_CONFIGURATION_UPDATED} constant. */
        BILLING_CONFIGURATION_UPDATED,
        /** The {@code PLAN_CHANGED} constant. */
        PLAN_CHANGED,
        /** The {@code AMENDED} constant. */
        AMENDED,
        /** The {@code UNITS_CHANGED} constant. */
        UNITS_CHANGED,
        /** The {@code PAUSED} constant. */
        PAUSED,
        /** The {@code CANCELLATION_SCHEDULED} constant. */
        CANCELLATION_SCHEDULED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
