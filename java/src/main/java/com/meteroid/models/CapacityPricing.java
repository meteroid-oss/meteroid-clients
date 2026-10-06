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
public final class CapacityPricing {
    @JsonProperty("included")
    private Long included;

    @JsonProperty("overage_rate")
    private BigDecimal overageRate;

    @JsonProperty("rate")
    private BigDecimal rate;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CapacityPricing() {}

    private CapacityPricing(Builder builder) {
        this.included = builder.included;
        this.overageRate = builder.overageRate;
        this.rate = builder.rate;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CapacityPricing}.
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
        builder.included = included;
        builder.overageRate = overageRate;
        builder.rate = rate;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code included} property.
     *
     * @return the value, never null
     */
    public Long included() {
        return Utils.required(included, "included");
    }

    /**
     * The {@code overage_rate} property.
     *
     * @return the value, never null
     */
    public BigDecimal overageRate() {
        return Utils.required(overageRate, "overage_rate");
    }

    /**
     * The {@code rate} property.
     *
     * @return the value, never null
     */
    public BigDecimal rate() {
        return Utils.required(rate, "rate");
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
        CapacityPricing that = (CapacityPricing) o;
        return Objects.equals(included, that.included)
                && Objects.equals(overageRate, that.overageRate)
                && Objects.equals(rate, that.rate)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(included, overageRate, rate, additionalProperties);
    }

    @Override
    public String toString() {
        return "CapacityPricing{"
                + "included="
                + included
                + ", overageRate="
                + overageRate
                + ", rate="
                + rate
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CapacityPricing}. */
    public static final class Builder {
        private Long included;
        private BigDecimal overageRate;
        private BigDecimal rate;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code included} property.
         *
         * @param included the value
         * @return this builder
         */
        public Builder included(Long included) {
            this.included = included;
            return this;
        }

        /**
         * The {@code overage_rate} property.
         *
         * @param overageRate the value
         * @return this builder
         */
        public Builder overageRate(BigDecimal overageRate) {
            this.overageRate = overageRate;
            return this;
        }

        /**
         * The {@code rate} property.
         *
         * @param rate the value
         * @return this builder
         */
        public Builder rate(BigDecimal rate) {
            this.rate = rate;
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
         * The {@code CapacityPricing}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CapacityPricing build() {
            Utils.checkRequired(included, "included");
            Utils.checkRequired(overageRate, "overage_rate");
            Utils.checkRequired(rate, "rate");
            return new CapacityPricing(this);
        }
    }

    /**
     * Parse {@code json} as {@code CapacityPricing}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CapacityPricing fromJson(String json) {
        return Utils.parse(json, CapacityPricing.class);
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
