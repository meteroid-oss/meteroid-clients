// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Onboarding mode for connected accounts
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class OnboardingMode implements ToQueryParam {
    /** The value {@code "express"}. */
    public static final OnboardingMode EXPRESS = new OnboardingMode("express", Value.EXPRESS);

    /** The value {@code "full"}. */
    public static final OnboardingMode FULL = new OnboardingMode("full", Value.FULL);

    private static final Map<String, OnboardingMode> constants =
            Map.ofEntries(Map.entry("express", EXPRESS), Map.entry("full", FULL));

    private final String value;
    private final Value variant;

    private OnboardingMode(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown OnboardingMode holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OnboardingMode of(String value) {
        OnboardingMode constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new OnboardingMode(value, Value._UNKNOWN);
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
                    "unknown OnboardingMode: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof OnboardingMode && Objects.equals(value, ((OnboardingMode) o).value);
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
        /** The {@code EXPRESS} constant. */
        EXPRESS,
        /** The {@code FULL} constant. */
        FULL
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code EXPRESS} constant. */
        EXPRESS,
        /** The {@code FULL} constant. */
        FULL,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
