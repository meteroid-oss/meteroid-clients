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
public final class InvoiceStatus implements ToQueryParam {
    /** The value {@code "DRAFT"}. */
    public static final InvoiceStatus DRAFT = new InvoiceStatus("DRAFT", Value.DRAFT);

    /** The value {@code "FINALIZED"}. */
    public static final InvoiceStatus FINALIZED = new InvoiceStatus("FINALIZED", Value.FINALIZED);

    /** The value {@code "UNCOLLECTIBLE"}. */
    public static final InvoiceStatus UNCOLLECTIBLE =
            new InvoiceStatus("UNCOLLECTIBLE", Value.UNCOLLECTIBLE);

    /** The value {@code "VOID"}. */
    public static final InvoiceStatus VOID = new InvoiceStatus("VOID", Value.VOID);

    /** The value {@code "CLOSED"}. */
    public static final InvoiceStatus CLOSED = new InvoiceStatus("CLOSED", Value.CLOSED);

    private static final Map<String, InvoiceStatus> constants =
            Map.ofEntries(
                    Map.entry("DRAFT", DRAFT),
                    Map.entry("FINALIZED", FINALIZED),
                    Map.entry("UNCOLLECTIBLE", UNCOLLECTIBLE),
                    Map.entry("VOID", VOID),
                    Map.entry("CLOSED", CLOSED));

    private final String value;
    private final Value variant;

    private InvoiceStatus(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown InvoiceStatus holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static InvoiceStatus of(String value) {
        InvoiceStatus constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new InvoiceStatus(value, Value._UNKNOWN);
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
                    "unknown InvoiceStatus: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof InvoiceStatus && Objects.equals(value, ((InvoiceStatus) o).value);
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
        /** The {@code DRAFT} constant. */
        DRAFT,
        /** The {@code FINALIZED} constant. */
        FINALIZED,
        /** The {@code UNCOLLECTIBLE} constant. */
        UNCOLLECTIBLE,
        /** The {@code VOID} constant. */
        VOID,
        /** The {@code CLOSED} constant. */
        CLOSED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code DRAFT} constant. */
        DRAFT,
        /** The {@code FINALIZED} constant. */
        FINALIZED,
        /** The {@code UNCOLLECTIBLE} constant. */
        UNCOLLECTIBLE,
        /** The {@code VOID} constant. */
        VOID,
        /** The {@code CLOSED} constant. */
        CLOSED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
