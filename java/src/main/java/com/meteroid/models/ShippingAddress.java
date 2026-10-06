// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.JsonField;
import com.meteroid.internal.Utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ShippingAddress {
    @JsonProperty("address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Address> address = JsonField.missing();

    @JsonProperty("same_as_billing")
    private Boolean sameAsBilling;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ShippingAddress() {}

    private ShippingAddress(Builder builder) {
        this.address = builder.address;
        this.sameAsBilling = builder.sameAsBilling;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ShippingAddress}.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder starting from this value.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.address = address;
        builder.sameAsBilling = sameAsBilling;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code address} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Address> address() {
        return address.asOptional();
    }

    /**
     * The {@code same_as_billing} property.
     *
     * @return the value, never null
     */
    public Boolean sameAsBilling() {
        return Utils.required(sameAsBilling, "same_as_billing");
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnyGetter
    private Map<String, JsonNode> anyProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void putAnyProperty(String name, JsonNode value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShippingAddress that = (ShippingAddress) o;
        return Objects.equals(address, that.address)
                && Objects.equals(sameAsBilling, that.sameAsBilling)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, sameAsBilling, additionalProperties);
    }

    @Override
    public String toString() {
        return "ShippingAddress{"
                + "address="
                + address
                + ", sameAsBilling="
                + sameAsBilling
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ShippingAddress}. */
    public static final class Builder {
        private JsonField<Address> address = JsonField.missing();
        private Boolean sameAsBilling;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code address} property.
         *
         * @param address the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder address(Address address) {
            this.address = JsonField.ofNullable(address);
            return this;
        }

        /**
         * The {@code same_as_billing} property.
         *
         * @param sameAsBilling the value
         * @return this builder
         */
        public Builder sameAsBilling(Boolean sameAsBilling) {
            this.sameAsBilling = sameAsBilling;
            return this;
        }

        /**
         * A property the SDK does not know, sent along.
         *
         * @param name the property name
         * @param value the JSON value
         * @return this builder
         */
        public Builder putAdditionalProperty(String name, JsonNode value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Properties the SDK does not know, sent along.
         *
         * @param additionalProperties the properties by name
         * @return this builder
         */
        public Builder putAllAdditionalProperties(Map<String, JsonNode> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        /**
         * Leaves out a property the SDK does not know.
         *
         * @param name the property name
         * @return this builder
         */
        public Builder removeAdditionalProperty(String name) {
            additionalProperties.remove(name);
            return this;
        }

        /**
         * The {@code ShippingAddress}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ShippingAddress build() {
            Utils.checkRequired(sameAsBilling, "same_as_billing");
            return new ShippingAddress(this);
        }
    }

    /**
     * Parse {@code json} as {@code ShippingAddress}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ShippingAddress fromJson(String json) {
        return Utils.parse(json, ShippingAddress.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }
}
