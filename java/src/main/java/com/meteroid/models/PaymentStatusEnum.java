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
public final class PaymentStatusEnum implements ToQueryParam {
    /** The value {@code "READY"}. */
    public static final PaymentStatusEnum READY = new PaymentStatusEnum("READY", Value.READY);

    /** The value {@code "PENDING"}. */
    public static final PaymentStatusEnum PENDING = new PaymentStatusEnum("PENDING", Value.PENDING);

    /** The value {@code "SETTLED"}. */
    public static final PaymentStatusEnum SETTLED = new PaymentStatusEnum("SETTLED", Value.SETTLED);

    /** The value {@code "CANCELLED"}. */
    public static final PaymentStatusEnum CANCELLED =
            new PaymentStatusEnum("CANCELLED", Value.CANCELLED);

    /** The value {@code "FAILED"}. */
    public static final PaymentStatusEnum FAILED = new PaymentStatusEnum("FAILED", Value.FAILED);

    /** The value {@code "REFUNDED"}. */
    public static final PaymentStatusEnum REFUNDED =
            new PaymentStatusEnum("REFUNDED", Value.REFUNDED);

    private static final Map<String, PaymentStatusEnum> constants =
            Map.ofEntries(
                    Map.entry("READY", READY),
                    Map.entry("PENDING", PENDING),
                    Map.entry("SETTLED", SETTLED),
                    Map.entry("CANCELLED", CANCELLED),
                    Map.entry("FAILED", FAILED),
                    Map.entry("REFUNDED", REFUNDED));

    private final String value;
    private final Value variant;

    private PaymentStatusEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown PaymentStatusEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PaymentStatusEnum of(String value) {
        PaymentStatusEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new PaymentStatusEnum(value, Value._UNKNOWN);
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
                    "unknown PaymentStatusEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof PaymentStatusEnum
                && Objects.equals(value, ((PaymentStatusEnum) o).value);
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
        /** The {@code READY} constant. */
        READY,
        /** The {@code PENDING} constant. */
        PENDING,
        /** The {@code SETTLED} constant. */
        SETTLED,
        /** The {@code CANCELLED} constant. */
        CANCELLED,
        /** The {@code FAILED} constant. */
        FAILED,
        /** The {@code REFUNDED} constant. */
        REFUNDED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code READY} constant. */
        READY,
        /** The {@code PENDING} constant. */
        PENDING,
        /** The {@code SETTLED} constant. */
        SETTLED,
        /** The {@code CANCELLED} constant. */
        CANCELLED,
        /** The {@code FAILED} constant. */
        FAILED,
        /** The {@code REFUNDED} constant. */
        REFUNDED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
