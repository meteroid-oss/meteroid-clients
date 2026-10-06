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
public final class UsageModelEnum implements ToQueryParam {
    /** The value {@code "PER_UNIT"}. */
    public static final UsageModelEnum PER_UNIT = new UsageModelEnum("PER_UNIT", Value.PER_UNIT);

    /** The value {@code "TIERED"}. */
    public static final UsageModelEnum TIERED = new UsageModelEnum("TIERED", Value.TIERED);

    /** The value {@code "VOLUME"}. */
    public static final UsageModelEnum VOLUME = new UsageModelEnum("VOLUME", Value.VOLUME);

    /** The value {@code "PACKAGE"}. */
    public static final UsageModelEnum PACKAGE = new UsageModelEnum("PACKAGE", Value.PACKAGE);

    /** The value {@code "MATRIX"}. */
    public static final UsageModelEnum MATRIX = new UsageModelEnum("MATRIX", Value.MATRIX);

    private static final Map<String, UsageModelEnum> constants =
            Map.ofEntries(
                    Map.entry("PER_UNIT", PER_UNIT),
                    Map.entry("TIERED", TIERED),
                    Map.entry("VOLUME", VOLUME),
                    Map.entry("PACKAGE", PACKAGE),
                    Map.entry("MATRIX", MATRIX));

    private final String value;
    private final Value variant;

    private UsageModelEnum(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown UsageModelEnum holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static UsageModelEnum of(String value) {
        UsageModelEnum constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new UsageModelEnum(value, Value._UNKNOWN);
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
                    "unknown UsageModelEnum: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof UsageModelEnum && Objects.equals(value, ((UsageModelEnum) o).value);
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
        /** The {@code PER_UNIT} constant. */
        PER_UNIT,
        /** The {@code TIERED} constant. */
        TIERED,
        /** The {@code VOLUME} constant. */
        VOLUME,
        /** The {@code PACKAGE} constant. */
        PACKAGE,
        /** The {@code MATRIX} constant. */
        MATRIX
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code PER_UNIT} constant. */
        PER_UNIT,
        /** The {@code TIERED} constant. */
        TIERED,
        /** The {@code VOLUME} constant. */
        VOLUME,
        /** The {@code PACKAGE} constant. */
        PACKAGE,
        /** The {@code MATRIX} constant. */
        MATRIX,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
