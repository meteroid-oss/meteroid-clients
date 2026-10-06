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
public final class CustomPropertyType implements ToQueryParam {
    /** The value {@code "TEXT"}. */
    public static final CustomPropertyType TEXT = new CustomPropertyType("TEXT", Value.TEXT);

    /** The value {@code "NUMBER"}. */
    public static final CustomPropertyType NUMBER = new CustomPropertyType("NUMBER", Value.NUMBER);

    /** The value {@code "BOOLEAN"}. */
    public static final CustomPropertyType BOOLEAN =
            new CustomPropertyType("BOOLEAN", Value.BOOLEAN);

    /** The value {@code "DATE"}. */
    public static final CustomPropertyType DATE = new CustomPropertyType("DATE", Value.DATE);

    /** The value {@code "DATETIME"}. */
    public static final CustomPropertyType DATETIME =
            new CustomPropertyType("DATETIME", Value.DATETIME);

    /** The value {@code "SINGLE_SELECT"}. */
    public static final CustomPropertyType SINGLE_SELECT =
            new CustomPropertyType("SINGLE_SELECT", Value.SINGLE_SELECT);

    /** The value {@code "MULTI_SELECT"}. */
    public static final CustomPropertyType MULTI_SELECT =
            new CustomPropertyType("MULTI_SELECT", Value.MULTI_SELECT);

    /** The value {@code "JSON"}. */
    public static final CustomPropertyType JSON = new CustomPropertyType("JSON", Value.JSON);

    /** The value {@code "URL"}. */
    public static final CustomPropertyType URL = new CustomPropertyType("URL", Value.URL);

    /** The value {@code "EMAIL"}. */
    public static final CustomPropertyType EMAIL = new CustomPropertyType("EMAIL", Value.EMAIL);

    private static final Map<String, CustomPropertyType> constants =
            Map.ofEntries(
                    Map.entry("TEXT", TEXT),
                    Map.entry("NUMBER", NUMBER),
                    Map.entry("BOOLEAN", BOOLEAN),
                    Map.entry("DATE", DATE),
                    Map.entry("DATETIME", DATETIME),
                    Map.entry("SINGLE_SELECT", SINGLE_SELECT),
                    Map.entry("MULTI_SELECT", MULTI_SELECT),
                    Map.entry("JSON", JSON),
                    Map.entry("URL", URL),
                    Map.entry("EMAIL", EMAIL));

    private final String value;
    private final Value variant;

    private CustomPropertyType(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CustomPropertyType holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CustomPropertyType of(String value) {
        CustomPropertyType constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CustomPropertyType(value, Value._UNKNOWN);
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
                    "unknown CustomPropertyType: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CustomPropertyType
                && Objects.equals(value, ((CustomPropertyType) o).value);
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
        /** The {@code TEXT} constant. */
        TEXT,
        /** The {@code NUMBER} constant. */
        NUMBER,
        /** The {@code BOOLEAN} constant. */
        BOOLEAN,
        /** The {@code DATE} constant. */
        DATE,
        /** The {@code DATETIME} constant. */
        DATETIME,
        /** The {@code SINGLE_SELECT} constant. */
        SINGLE_SELECT,
        /** The {@code MULTI_SELECT} constant. */
        MULTI_SELECT,
        /** The {@code JSON} constant. */
        JSON,
        /** The {@code URL} constant. */
        URL,
        /** The {@code EMAIL} constant. */
        EMAIL
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code TEXT} constant. */
        TEXT,
        /** The {@code NUMBER} constant. */
        NUMBER,
        /** The {@code BOOLEAN} constant. */
        BOOLEAN,
        /** The {@code DATE} constant. */
        DATE,
        /** The {@code DATETIME} constant. */
        DATETIME,
        /** The {@code SINGLE_SELECT} constant. */
        SINGLE_SELECT,
        /** The {@code MULTI_SELECT} constant. */
        MULTI_SELECT,
        /** The {@code JSON} constant. */
        JSON,
        /** The {@code URL} constant. */
        URL,
        /** The {@code EMAIL} constant. */
        EMAIL,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
