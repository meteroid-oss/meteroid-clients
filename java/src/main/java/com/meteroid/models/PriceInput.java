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
public final class PriceInput {
    @JsonProperty("cadence")
    private BillingPeriodEnum cadence;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("pricing")
    private Pricing pricing;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private PriceInput() {}

    private PriceInput(Builder builder) {
        this.cadence = builder.cadence;
        this.currency = builder.currency;
        this.pricing = builder.pricing;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code PriceInput}.
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
        builder.cadence = cadence;
        builder.currency = currency;
        builder.pricing = pricing;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code cadence} property.
     *
     * @return the value, never null
     */
    public BillingPeriodEnum cadence() {
        return Utils.required(cadence, "cadence");
    }

    /**
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public String currency() {
        return Utils.required(currency, "currency");
    }

    /**
     * The {@code pricing} property.
     *
     * @return the value, never null
     */
    public Pricing pricing() {
        return Utils.required(pricing, "pricing");
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
        PriceInput that = (PriceInput) o;
        return Objects.equals(cadence, that.cadence)
                && Objects.equals(currency, that.currency)
                && Objects.equals(pricing, that.pricing)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadence, currency, pricing, additionalProperties);
    }

    @Override
    public String toString() {
        return "PriceInput{"
                + "cadence="
                + cadence
                + ", currency="
                + currency
                + ", pricing="
                + pricing
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link PriceInput}. */
    public static final class Builder {
        private BillingPeriodEnum cadence;
        private String currency;
        private Pricing pricing;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code cadence} property.
         *
         * @param cadence the value
         * @return this builder
         */
        public Builder cadence(BillingPeriodEnum cadence) {
            this.cadence = cadence;
            return this;
        }

        /**
         * The {@code currency} property.
         *
         * @param currency the value
         * @return this builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * The {@code pricing} property.
         *
         * @param pricing the value
         * @return this builder
         */
        public Builder pricing(Pricing pricing) {
            this.pricing = pricing;
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
         * The {@code PriceInput}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public PriceInput build() {
            Utils.checkRequired(cadence, "cadence");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(pricing, "pricing");
            return new PriceInput(this);
        }
    }

    /**
     * Parse {@code json} as {@code PriceInput}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PriceInput fromJson(String json) {
        return Utils.parse(json, PriceInput.class);
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
