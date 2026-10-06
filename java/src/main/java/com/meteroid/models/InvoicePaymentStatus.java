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
public final class InvoicePaymentStatus implements ToQueryParam {
    /** The value {@code "UNPAID"}. */
    public static final InvoicePaymentStatus UNPAID =
            new InvoicePaymentStatus("UNPAID", Value.UNPAID);

    /** The value {@code "PARTIALLY_PAID"}. */
    public static final InvoicePaymentStatus PARTIALLY_PAID =
            new InvoicePaymentStatus("PARTIALLY_PAID", Value.PARTIALLY_PAID);

    /** The value {@code "PAID"}. */
    public static final InvoicePaymentStatus PAID = new InvoicePaymentStatus("PAID", Value.PAID);

    /** The value {@code "ERRORED"}. */
    public static final InvoicePaymentStatus ERRORED =
            new InvoicePaymentStatus("ERRORED", Value.ERRORED);

    /** The value {@code "PROCESSING"}. */
    public static final InvoicePaymentStatus PROCESSING =
            new InvoicePaymentStatus("PROCESSING", Value.PROCESSING);

    private static final Map<String, InvoicePaymentStatus> constants =
            Map.ofEntries(
                    Map.entry("UNPAID", UNPAID),
                    Map.entry("PARTIALLY_PAID", PARTIALLY_PAID),
                    Map.entry("PAID", PAID),
                    Map.entry("ERRORED", ERRORED),
                    Map.entry("PROCESSING", PROCESSING));

    private final String value;
    private final Value variant;

    private InvoicePaymentStatus(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown InvoicePaymentStatus holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static InvoicePaymentStatus of(String value) {
        InvoicePaymentStatus constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new InvoicePaymentStatus(value, Value._UNKNOWN);
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
                    "unknown InvoicePaymentStatus: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof InvoicePaymentStatus
                && Objects.equals(value, ((InvoicePaymentStatus) o).value);
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
        /** The {@code UNPAID} constant. */
        UNPAID,
        /** The {@code PARTIALLY_PAID} constant. */
        PARTIALLY_PAID,
        /** The {@code PAID} constant. */
        PAID,
        /** The {@code ERRORED} constant. */
        ERRORED,
        /** The {@code PROCESSING} constant. */
        PROCESSING
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code UNPAID} constant. */
        UNPAID,
        /** The {@code PARTIALLY_PAID} constant. */
        PARTIALLY_PAID,
        /** The {@code PAID} constant. */
        PAID,
        /** The {@code ERRORED} constant. */
        ERRORED,
        /** The {@code PROCESSING} constant. */
        PROCESSING,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
