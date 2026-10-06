// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Whether the structured e-invoice was produced with the accounting PDF. Absent when the invoicing
 * entity had not opted in at the time the invoice was issued.
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class EInvoicingStatus implements ToQueryParam {
    /** The value {@code "GENERATED"}. */
    public static final EInvoicingStatus GENERATED =
            new EInvoicingStatus("GENERATED", Value.GENERATED);

    /** The value {@code "FAILED"}. */
    public static final EInvoicingStatus FAILED = new EInvoicingStatus("FAILED", Value.FAILED);

    private static final Map<String, EInvoicingStatus> constants =
            Map.ofEntries(Map.entry("GENERATED", GENERATED), Map.entry("FAILED", FAILED));

    private final String value;
    private final Value variant;

    private EInvoicingStatus(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown EInvoicingStatus holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EInvoicingStatus of(String value) {
        EInvoicingStatus constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new EInvoicingStatus(value, Value._UNKNOWN);
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
                    "unknown EInvoicingStatus: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof EInvoicingStatus && Objects.equals(value, ((EInvoicingStatus) o).value);
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
        /** The {@code GENERATED} constant. */
        GENERATED,
        /** The {@code FAILED} constant. */
        FAILED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code GENERATED} constant. */
        GENERATED,
        /** The {@code FAILED} constant. */
        FAILED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
