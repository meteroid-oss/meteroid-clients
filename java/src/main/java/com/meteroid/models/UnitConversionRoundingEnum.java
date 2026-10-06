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
public final class UnitConversionRoundingEnum implements ToQueryParam {
    /** The value {@code "UP"}. */
    public static final UnitConversionRoundingEnum UP =
            new UnitConversionRoundingEnum("UP", Value.UP);

    /** The value {@code "DOWN"}. */
    public static final UnitConversionRoundingEnum DOWN =
            new UnitConversionRoundingEnum("DOWN", Value.DOWN);

    /** The value {@code "NEAREST"}. */
    public static final UnitConversionRoundingEnum NEAREST =
            new UnitConversionRoundingEnum("NEAREST", Value.NEAREST);

    /** The value {@code "NEAREST_HALF"}. */
    public static final UnitConversionRoundingEnum NEAREST_HALF =
            new UnitConversionRoundingEnum("NEAREST_HALF", Value.NEAREST_HALF);

    /** The value {@code "NEAREST_DECILE"}. */
    public static final UnitConversionRoundingEnum NEAREST_DECILE =
            new UnitConversionRoundingEnum("NEAREST_DECILE", Value.NEAREST_DECILE);

    /** The value {@code "NONE"}. */
    public static final UnitConversionRoundingEnum NONE =
            new UnitConversionRoundingEnum("NONE", Value.NONE);

    private static final Map<String, UnitConversionRoundingEnum> constants =
            Map.ofEntries(
                    Map.entry("UP", UP),
                    Map.entry("DOWN", DOWN),
                    Map.entry("NEAREST", NEAREST),
                    Map.entry("NEAREST_HALF", NEAREST_HALF),
                    Map.entry("NEAREST_DECILE", NEAREST_DECILE),
                    Map.entry("NONE", NONE));

    private final String value;
    private final Value variant;

    private UnitConversionRoundingEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown UnitConversionRoundingEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UnitConversionRoundingEnum of(String value) {
        UnitConversionRoundingEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new UnitConversionRoundingEnum(value, Value._UNKNOWN);
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
                    "unknown UnitConversionRoundingEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof UnitConversionRoundingEnum
                && Objects.equals(value, ((UnitConversionRoundingEnum) o).value);
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
        /** The {@code UP} constant. */
        UP,
        /** The {@code DOWN} constant. */
        DOWN,
        /** The {@code NEAREST} constant. */
        NEAREST,
        /** The {@code NEAREST_HALF} constant. */
        NEAREST_HALF,
        /** The {@code NEAREST_DECILE} constant. */
        NEAREST_DECILE,
        /** The {@code NONE} constant. */
        NONE
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code UP} constant. */
        UP,
        /** The {@code DOWN} constant. */
        DOWN,
        /** The {@code NEAREST} constant. */
        NEAREST,
        /** The {@code NEAREST_HALF} constant. */
        NEAREST_HALF,
        /** The {@code NEAREST_DECILE} constant. */
        NEAREST_DECILE,
        /** The {@code NONE} constant. */
        NONE,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
