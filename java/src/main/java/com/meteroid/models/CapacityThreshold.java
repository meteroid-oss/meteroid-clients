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
import com.meteroid.internal.Utils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class CapacityThreshold {
    @JsonProperty("included_amount")
    private Long includedAmount;

    @JsonProperty("per_unit_overage")
    private BigDecimal perUnitOverage;

    @JsonProperty("price")
    private BigDecimal price;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CapacityThreshold() {}

    private CapacityThreshold(Builder builder) {
        this.includedAmount = builder.includedAmount;
        this.perUnitOverage = builder.perUnitOverage;
        this.price = builder.price;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CapacityThreshold}.
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
        builder.includedAmount = includedAmount;
        builder.perUnitOverage = perUnitOverage;
        builder.price = price;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code included_amount} property.
     *
     * @return the value, never null
     */
    public Long includedAmount() {
        return Utils.required(includedAmount, "included_amount");
    }

    /**
     * The {@code per_unit_overage} property.
     *
     * @return the value, never null
     */
    public BigDecimal perUnitOverage() {
        return Utils.required(perUnitOverage, "per_unit_overage");
    }

    /**
     * The {@code price} property.
     *
     * @return the value, never null
     */
    public BigDecimal price() {
        return Utils.required(price, "price");
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
        CapacityThreshold that = (CapacityThreshold) o;
        return Objects.equals(includedAmount, that.includedAmount)
                && Objects.equals(perUnitOverage, that.perUnitOverage)
                && Objects.equals(price, that.price)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(includedAmount, perUnitOverage, price, additionalProperties);
    }

    @Override
    public String toString() {
        return "CapacityThreshold{"
                + "includedAmount="
                + includedAmount
                + ", perUnitOverage="
                + perUnitOverage
                + ", price="
                + price
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CapacityThreshold}. */
    public static final class Builder {
        private Long includedAmount;
        private BigDecimal perUnitOverage;
        private BigDecimal price;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code included_amount} property.
         *
         * @param includedAmount the value
         * @return this builder
         */
        public Builder includedAmount(Long includedAmount) {
            this.includedAmount = includedAmount;
            return this;
        }

        /**
         * The {@code per_unit_overage} property.
         *
         * @param perUnitOverage the value
         * @return this builder
         */
        public Builder perUnitOverage(BigDecimal perUnitOverage) {
            this.perUnitOverage = perUnitOverage;
            return this;
        }

        /**
         * The {@code price} property.
         *
         * @param price the value
         * @return this builder
         */
        public Builder price(BigDecimal price) {
            this.price = price;
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
         * The {@code CapacityThreshold}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CapacityThreshold build() {
            Utils.checkRequired(includedAmount, "included_amount");
            Utils.checkRequired(perUnitOverage, "per_unit_overage");
            Utils.checkRequired(price, "price");
            return new CapacityThreshold(this);
        }
    }

    /**
     * Parse {@code json} as {@code CapacityThreshold}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CapacityThreshold fromJson(String json) {
        return Utils.parse(json, CapacityThreshold.class);
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
