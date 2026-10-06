// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Operator of a pre-aggregation [<code>MetricFilter</code>]. <code>EQUAL</code>/<code>NOT_EQUAL
 * </code> are the single-value forms of <code>IN</code>/<code>NOT_IN</code>. Negation (<code>
 * NOT_EQUAL</code>/<code>NOT_IN</code>) is presence-required: an event missing the property is
 * excluded.
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class MetricFilterOperator implements ToQueryParam {
    /** The value {@code "EQUAL"}. */
    public static final MetricFilterOperator EQUAL = new MetricFilterOperator("EQUAL", Value.EQUAL);

    /** The value {@code "NOT_EQUAL"}. */
    public static final MetricFilterOperator NOT_EQUAL =
            new MetricFilterOperator("NOT_EQUAL", Value.NOT_EQUAL);

    /** The value {@code "IN"}. */
    public static final MetricFilterOperator IN = new MetricFilterOperator("IN", Value.IN);

    /** The value {@code "NOT_IN"}. */
    public static final MetricFilterOperator NOT_IN =
            new MetricFilterOperator("NOT_IN", Value.NOT_IN);

    private static final Map<String, MetricFilterOperator> constants =
            Map.ofEntries(
                    Map.entry("EQUAL", EQUAL),
                    Map.entry("NOT_EQUAL", NOT_EQUAL),
                    Map.entry("IN", IN),
                    Map.entry("NOT_IN", NOT_IN));

    private final String value;
    private final Value variant;

    private MetricFilterOperator(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown MetricFilterOperator holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static MetricFilterOperator of(String value) {
        MetricFilterOperator constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new MetricFilterOperator(value, Value._UNKNOWN);
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
                    "unknown MetricFilterOperator: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof MetricFilterOperator
                && Objects.equals(value, ((MetricFilterOperator) o).value);
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
        /** The {@code EQUAL} constant. */
        EQUAL,
        /** The {@code NOT_EQUAL} constant. */
        NOT_EQUAL,
        /** The {@code IN} constant. */
        IN,
        /** The {@code NOT_IN} constant. */
        NOT_IN
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code EQUAL} constant. */
        EQUAL,
        /** The {@code NOT_EQUAL} constant. */
        NOT_EQUAL,
        /** The {@code IN} constant. */
        IN,
        /** The {@code NOT_IN} constant. */
        NOT_IN,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
