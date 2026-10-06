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
public final class CouponFilter implements ToQueryParam {
    /** The value {@code "ALL"}. */
    public static final CouponFilter ALL = new CouponFilter("ALL", Value.ALL);

    /** The value {@code "ACTIVE"}. */
    public static final CouponFilter ACTIVE = new CouponFilter("ACTIVE", Value.ACTIVE);

    /** The value {@code "INACTIVE"}. */
    public static final CouponFilter INACTIVE = new CouponFilter("INACTIVE", Value.INACTIVE);

    /** The value {@code "ARCHIVED"}. */
    public static final CouponFilter ARCHIVED = new CouponFilter("ARCHIVED", Value.ARCHIVED);

    private static final Map<String, CouponFilter> constants =
            Map.ofEntries(
                    Map.entry("ALL", ALL),
                    Map.entry("ACTIVE", ACTIVE),
                    Map.entry("INACTIVE", INACTIVE),
                    Map.entry("ARCHIVED", ARCHIVED));

    private final String value;
    private final Value variant;

    private CouponFilter(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown CouponFilter holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static CouponFilter of(String value) {
        CouponFilter constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new CouponFilter(value, Value._UNKNOWN);
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
                    "unknown CouponFilter: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CouponFilter && Objects.equals(value, ((CouponFilter) o).value);
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
        /** The {@code ALL} constant. */
        ALL,
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code INACTIVE} constant. */
        INACTIVE,
        /** The {@code ARCHIVED} constant. */
        ARCHIVED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code ALL} constant. */
        ALL,
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code INACTIVE} constant. */
        INACTIVE,
        /** The {@code ARCHIVED} constant. */
        ARCHIVED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
