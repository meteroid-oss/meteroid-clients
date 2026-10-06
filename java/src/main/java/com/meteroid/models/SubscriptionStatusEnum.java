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
public final class SubscriptionStatusEnum implements ToQueryParam {
    /** The value {@code "PENDING_ACTIVATION"}. */
    public static final SubscriptionStatusEnum PENDING_ACTIVATION =
            new SubscriptionStatusEnum("PENDING_ACTIVATION", Value.PENDING_ACTIVATION);

    /** The value {@code "PENDING_CHARGE"}. */
    public static final SubscriptionStatusEnum PENDING_CHARGE =
            new SubscriptionStatusEnum("PENDING_CHARGE", Value.PENDING_CHARGE);

    /** The value {@code "TRIAL_ACTIVE"}. */
    public static final SubscriptionStatusEnum TRIAL_ACTIVE =
            new SubscriptionStatusEnum("TRIAL_ACTIVE", Value.TRIAL_ACTIVE);

    /** The value {@code "ACTIVE"}. */
    public static final SubscriptionStatusEnum ACTIVE =
            new SubscriptionStatusEnum("ACTIVE", Value.ACTIVE);

    /** The value {@code "TRIAL_EXPIRED"}. */
    public static final SubscriptionStatusEnum TRIAL_EXPIRED =
            new SubscriptionStatusEnum("TRIAL_EXPIRED", Value.TRIAL_EXPIRED);

    /** The value {@code "PAUSED"}. */
    public static final SubscriptionStatusEnum PAUSED =
            new SubscriptionStatusEnum("PAUSED", Value.PAUSED);

    /** The value {@code "SUSPENDED"}. */
    public static final SubscriptionStatusEnum SUSPENDED =
            new SubscriptionStatusEnum("SUSPENDED", Value.SUSPENDED);

    /** The value {@code "CANCELLED"}. */
    public static final SubscriptionStatusEnum CANCELLED =
            new SubscriptionStatusEnum("CANCELLED", Value.CANCELLED);

    /** The value {@code "ABORTED"}. */
    public static final SubscriptionStatusEnum ABORTED =
            new SubscriptionStatusEnum("ABORTED", Value.ABORTED);

    /** The value {@code "COMPLETED"}. */
    public static final SubscriptionStatusEnum COMPLETED =
            new SubscriptionStatusEnum("COMPLETED", Value.COMPLETED);

    /** The value {@code "SUPERSEDED"}. */
    public static final SubscriptionStatusEnum SUPERSEDED =
            new SubscriptionStatusEnum("SUPERSEDED", Value.SUPERSEDED);

    /** The value {@code "ERRORED"}. */
    public static final SubscriptionStatusEnum ERRORED =
            new SubscriptionStatusEnum("ERRORED", Value.ERRORED);

    private static final Map<String, SubscriptionStatusEnum> constants =
            Map.ofEntries(
                    Map.entry("PENDING_ACTIVATION", PENDING_ACTIVATION),
                    Map.entry("PENDING_CHARGE", PENDING_CHARGE),
                    Map.entry("TRIAL_ACTIVE", TRIAL_ACTIVE),
                    Map.entry("ACTIVE", ACTIVE),
                    Map.entry("TRIAL_EXPIRED", TRIAL_EXPIRED),
                    Map.entry("PAUSED", PAUSED),
                    Map.entry("SUSPENDED", SUSPENDED),
                    Map.entry("CANCELLED", CANCELLED),
                    Map.entry("ABORTED", ABORTED),
                    Map.entry("COMPLETED", COMPLETED),
                    Map.entry("SUPERSEDED", SUPERSEDED),
                    Map.entry("ERRORED", ERRORED));

    private final String value;
    private final Value variant;

    private SubscriptionStatusEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown SubscriptionStatusEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SubscriptionStatusEnum of(String value) {
        SubscriptionStatusEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new SubscriptionStatusEnum(value, Value._UNKNOWN);
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
                    "unknown SubscriptionStatusEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SubscriptionStatusEnum
                && Objects.equals(value, ((SubscriptionStatusEnum) o).value);
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
        /** The {@code PENDING_ACTIVATION} constant. */
        PENDING_ACTIVATION,
        /** The {@code PENDING_CHARGE} constant. */
        PENDING_CHARGE,
        /** The {@code TRIAL_ACTIVE} constant. */
        TRIAL_ACTIVE,
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code TRIAL_EXPIRED} constant. */
        TRIAL_EXPIRED,
        /** The {@code PAUSED} constant. */
        PAUSED,
        /** The {@code SUSPENDED} constant. */
        SUSPENDED,
        /** The {@code CANCELLED} constant. */
        CANCELLED,
        /** The {@code ABORTED} constant. */
        ABORTED,
        /** The {@code COMPLETED} constant. */
        COMPLETED,
        /** The {@code SUPERSEDED} constant. */
        SUPERSEDED,
        /** The {@code ERRORED} constant. */
        ERRORED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code PENDING_ACTIVATION} constant. */
        PENDING_ACTIVATION,
        /** The {@code PENDING_CHARGE} constant. */
        PENDING_CHARGE,
        /** The {@code TRIAL_ACTIVE} constant. */
        TRIAL_ACTIVE,
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code TRIAL_EXPIRED} constant. */
        TRIAL_EXPIRED,
        /** The {@code PAUSED} constant. */
        PAUSED,
        /** The {@code SUSPENDED} constant. */
        SUSPENDED,
        /** The {@code CANCELLED} constant. */
        CANCELLED,
        /** The {@code ABORTED} constant. */
        ABORTED,
        /** The {@code COMPLETED} constant. */
        COMPLETED,
        /** The {@code SUPERSEDED} constant. */
        SUPERSEDED,
        /** The {@code ERRORED} constant. */
        ERRORED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
