// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Authoritative value type of a Config feature. <code>MAP</code>/<code>JSON</code> both carry a
 * JSON value.
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class ConfigValueType implements ToQueryParam {
    /** The value {@code "NUMBER"}. */
    public static final ConfigValueType NUMBER = new ConfigValueType("NUMBER", Value.NUMBER);

    /** The value {@code "BOOLEAN"}. */
    public static final ConfigValueType BOOLEAN = new ConfigValueType("BOOLEAN", Value.BOOLEAN);

    /** The value {@code "TEXT"}. */
    public static final ConfigValueType TEXT = new ConfigValueType("TEXT", Value.TEXT);

    /** The value {@code "MAP"}. */
    public static final ConfigValueType MAP = new ConfigValueType("MAP", Value.MAP);

    /** The value {@code "JSON"}. */
    public static final ConfigValueType JSON = new ConfigValueType("JSON", Value.JSON);

    /** The value {@code "SELECT"}. */
    public static final ConfigValueType SELECT = new ConfigValueType("SELECT", Value.SELECT);

    private static final Map<String, ConfigValueType> constants =
            Map.ofEntries(
                    Map.entry("NUMBER", NUMBER),
                    Map.entry("BOOLEAN", BOOLEAN),
                    Map.entry("TEXT", TEXT),
                    Map.entry("MAP", MAP),
                    Map.entry("JSON", JSON),
                    Map.entry("SELECT", SELECT));

    private final String value;
    private final Value variant;

    private ConfigValueType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown ConfigValueType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ConfigValueType of(String value) {
        ConfigValueType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new ConfigValueType(value, Value._UNKNOWN);
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
                    "unknown ConfigValueType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ConfigValueType && Objects.equals(value, ((ConfigValueType) o).value);
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
        /** The {@code NUMBER} constant. */
        NUMBER,
        /** The {@code BOOLEAN} constant. */
        BOOLEAN,
        /** The {@code TEXT} constant. */
        TEXT,
        /** The {@code MAP} constant. */
        MAP,
        /** The {@code JSON} constant. */
        JSON,
        /** The {@code SELECT} constant. */
        SELECT
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code NUMBER} constant. */
        NUMBER,
        /** The {@code BOOLEAN} constant. */
        BOOLEAN,
        /** The {@code TEXT} constant. */
        TEXT,
        /** The {@code MAP} constant. */
        MAP,
        /** The {@code JSON} constant. */
        JSON,
        /** The {@code SELECT} constant. */
        SELECT,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
