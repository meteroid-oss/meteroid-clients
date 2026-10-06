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
public final class CalendarUnit implements ToQueryParam {
    /** The value {@code "HOUR"}. */
    public static final CalendarUnit HOUR = new CalendarUnit("HOUR", Value.HOUR);

    /** The value {@code "DAY"}. */
    public static final CalendarUnit DAY = new CalendarUnit("DAY", Value.DAY);

    /** The value {@code "WEEK"}. */
    public static final CalendarUnit WEEK = new CalendarUnit("WEEK", Value.WEEK);

    /** The value {@code "MONTH"}. */
    public static final CalendarUnit MONTH = new CalendarUnit("MONTH", Value.MONTH);

    /** The value {@code "YEAR"}. */
    public static final CalendarUnit YEAR = new CalendarUnit("YEAR", Value.YEAR);

    private static final Map<String, CalendarUnit> constants =
            Map.ofEntries(
                    Map.entry("HOUR", HOUR),
                    Map.entry("DAY", DAY),
                    Map.entry("WEEK", WEEK),
                    Map.entry("MONTH", MONTH),
                    Map.entry("YEAR", YEAR));

    private final String value;
    private final Value variant;

    private CalendarUnit(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CalendarUnit holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CalendarUnit of(String value) {
        CalendarUnit constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CalendarUnit(value, Value._UNKNOWN);
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
                    "unknown CalendarUnit: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CalendarUnit && Objects.equals(value, ((CalendarUnit) o).value);
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
        /** The {@code HOUR} constant. */
        HOUR,
        /** The {@code DAY} constant. */
        DAY,
        /** The {@code WEEK} constant. */
        WEEK,
        /** The {@code MONTH} constant. */
        MONTH,
        /** The {@code YEAR} constant. */
        YEAR
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code HOUR} constant. */
        HOUR,
        /** The {@code DAY} constant. */
        DAY,
        /** The {@code WEEK} constant. */
        WEEK,
        /** The {@code MONTH} constant. */
        MONTH,
        /** The {@code YEAR} constant. */
        YEAR,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
