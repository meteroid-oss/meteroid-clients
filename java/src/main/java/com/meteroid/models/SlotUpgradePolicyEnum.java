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
public final class SlotUpgradePolicyEnum implements ToQueryParam {
    /** The value {@code "PRORATED"}. */
    public static final SlotUpgradePolicyEnum PRORATED =
            new SlotUpgradePolicyEnum("PRORATED", Value.PRORATED);

    private static final Map<String, SlotUpgradePolicyEnum> constants =
            Map.ofEntries(Map.entry("PRORATED", PRORATED));

    private final String value;
    private final Value variant;

    private SlotUpgradePolicyEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown SlotUpgradePolicyEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static SlotUpgradePolicyEnum of(String value) {
        SlotUpgradePolicyEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new SlotUpgradePolicyEnum(value, Value._UNKNOWN);
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
                    "unknown SlotUpgradePolicyEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SlotUpgradePolicyEnum
                && Objects.equals(value, ((SlotUpgradePolicyEnum) o).value);
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
        /** The {@code PRORATED} constant. */
        PRORATED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code PRORATED} constant. */
        PRORATED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
