// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.internal.Utils.ToQueryParam;

import java.util.Map;
import java.util.Objects;

/**
 * Status of a connected account
 *
 * <p>Values this version of the SDK does not know are kept, and sent back unchanged: {@link
 * #value()} is an enum to switch on, {@code _UNKNOWN} for them, and {@link #known()} throws on
 * them.
 */
public final class ConnectionStatus implements ToQueryParam {
    /** The value {@code "pending"}. */
    public static final ConnectionStatus PENDING = new ConnectionStatus("pending", Value.PENDING);

    /** The value {@code "active"}. */
    public static final ConnectionStatus ACTIVE = new ConnectionStatus("active", Value.ACTIVE);

    /** The value {@code "revoked"}. */
    public static final ConnectionStatus REVOKED = new ConnectionStatus("revoked", Value.REVOKED);

    /** The value {@code "suspended"}. */
    public static final ConnectionStatus SUSPENDED =
            new ConnectionStatus("suspended", Value.SUSPENDED);

    private static final Map<String, ConnectionStatus> constants =
            Map.ofEntries(
                    Map.entry("pending", PENDING),
                    Map.entry("active", ACTIVE),
                    Map.entry("revoked", REVOKED),
                    Map.entry("suspended", SUSPENDED));

    private final String value;
    private final Value variant;

    private ConnectionStatus(String value, Value variant) {
        this.value = value;
        this.variant = variant;
    }

    /**
     * The constant for {@code value}, or an unknown ConnectionStatus holding it.
     *
     * @param value the value
     * @return the constant
     */
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ConnectionStatus of(String value) {
        ConnectionStatus constant = constants.get(Objects.requireNonNull(value, "value"));
        return constant != null ? constant : new ConnectionStatus(value, Value._UNKNOWN);
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
                    "unknown ConnectionStatus: " + value);
        }
        return Known.valueOf(variant.name());
    }

    @Override
    public String toQueryParam() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ConnectionStatus && Objects.equals(value, ((ConnectionStatus) o).value);
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
        /** The {@code PENDING} constant. */
        PENDING,
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code REVOKED} constant. */
        REVOKED,
        /** The {@code SUSPENDED} constant. */
        SUSPENDED
    }

    /** The values this version of the SDK knows, and {@code _UNKNOWN} for the others. */
    public enum Value {
        /** The {@code PENDING} constant. */
        PENDING,
        /** The {@code ACTIVE} constant. */
        ACTIVE,
        /** The {@code REVOKED} constant. */
        REVOKED,
        /** The {@code SUSPENDED} constant. */
        SUSPENDED,
        /** A value this version of the SDK does not know. */
        _UNKNOWN
    }
}
