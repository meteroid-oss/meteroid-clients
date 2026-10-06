// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Lifecycle status of a feature.
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class FeatureStatus implements ToQueryParam {
    /** The value {@code "ACTIVE"}. */
    public static final FeatureStatus ACTIVE = new FeatureStatus("ACTIVE", Value.ACTIVE);

    /** The value {@code "DISABLED"}. */
    public static final FeatureStatus DISABLED = new FeatureStatus("DISABLED", Value.DISABLED);

    /** The value {@code "ARCHIVED"}. */
    public static final FeatureStatus ARCHIVED = new FeatureStatus("ARCHIVED", Value.ARCHIVED);

    private static final Map<String, FeatureStatus> constants =
            Map.ofEntries(
                    Map.entry("ACTIVE", ACTIVE),
                    Map.entry("DISABLED", DISABLED),
                    Map.entry("ARCHIVED", ARCHIVED));

    private final String value;
    private final Value variant;

    private FeatureStatus(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown FeatureStatus holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static FeatureStatus of(String value) {
        FeatureStatus constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new FeatureStatus(value, Value._UNKNOWN);
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
                    "unknown FeatureStatus: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FeatureStatus && Objects.equals(value, ((FeatureStatus) o).value);
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
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code DISABLED} constant. */
        DISABLED,
        /** The {@code ARCHIVED} constant. */
        ARCHIVED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code DISABLED} constant. */
        DISABLED,
        /** The {@code ARCHIVED} constant. */
        ARCHIVED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
