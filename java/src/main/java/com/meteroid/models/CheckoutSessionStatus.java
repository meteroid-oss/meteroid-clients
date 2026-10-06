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
public final class CheckoutSessionStatus implements ToQueryParam {
    /** The value {@code "CREATED"}. */
    public static final CheckoutSessionStatus CREATED =
            new CheckoutSessionStatus("CREATED", Value.CREATED);

    /** The value {@code "AWAITING_PAYMENT"}. */
    public static final CheckoutSessionStatus AWAITING_PAYMENT =
            new CheckoutSessionStatus("AWAITING_PAYMENT", Value.AWAITING_PAYMENT);

    /** The value {@code "COMPLETED"}. */
    public static final CheckoutSessionStatus COMPLETED =
            new CheckoutSessionStatus("COMPLETED", Value.COMPLETED);

    /** The value {@code "EXPIRED"}. */
    public static final CheckoutSessionStatus EXPIRED =
            new CheckoutSessionStatus("EXPIRED", Value.EXPIRED);

    /** The value {@code "CANCELLED"}. */
    public static final CheckoutSessionStatus CANCELLED =
            new CheckoutSessionStatus("CANCELLED", Value.CANCELLED);

    private static final Map<String, CheckoutSessionStatus> constants =
            Map.ofEntries(
                    Map.entry("CREATED", CREATED),
                    Map.entry("AWAITING_PAYMENT", AWAITING_PAYMENT),
                    Map.entry("COMPLETED", COMPLETED),
                    Map.entry("EXPIRED", EXPIRED),
                    Map.entry("CANCELLED", CANCELLED));

    private final String value;
    private final Value variant;

    private CheckoutSessionStatus(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CheckoutSessionStatus holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CheckoutSessionStatus of(String value) {
        CheckoutSessionStatus constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CheckoutSessionStatus(value, Value._UNKNOWN);
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
                    "unknown CheckoutSessionStatus: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CheckoutSessionStatus
                && Objects.equals(value, ((CheckoutSessionStatus) o).value);
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
        /** The {@code CREATED} constant. */
        CREATED,
        /** The {@code AWAITING_PAYMENT} constant. */
        AWAITING_PAYMENT,
        /** The {@code COMPLETED} constant. */
        COMPLETED,
        /** The {@code EXPIRED} constant. */
        EXPIRED,
        /** The {@code CANCELLED} constant. */
        CANCELLED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code CREATED} constant. */
        CREATED,
        /** The {@code AWAITING_PAYMENT} constant. */
        AWAITING_PAYMENT,
        /** The {@code COMPLETED} constant. */
        COMPLETED,
        /** The {@code EXPIRED} constant. */
        EXPIRED,
        /** The {@code CANCELLED} constant. */
        CANCELLED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
