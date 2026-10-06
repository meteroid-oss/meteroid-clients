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
public final class TermRate {
    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("term")
    private BillingPeriodEnum term;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TermRate() {}

    private TermRate(Builder builder) {
        this.price = builder.price;
        this.term = builder.term;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TermRate}.
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
        builder.price = price;
        builder.term = term;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * The {@code term} property.
     *
     * @return the value, never null
     */
    public BillingPeriodEnum term() {
        return Utils.required(term, "term");
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
        TermRate that = (TermRate) o;
        return Objects.equals(price, that.price)
                && Objects.equals(term, that.term)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, term, additionalProperties);
    }

    @Override
    public String toString() {
        return "TermRate{"
                + "price="
                + price
                + ", term="
                + term
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TermRate}. */
    public static final class Builder {
        private BigDecimal price;
        private BillingPeriodEnum term;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * The {@code term} property.
         *
         * @param term the value
         * @return this builder
         */
        public Builder term(BillingPeriodEnum term) {
            this.term = term;
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
         * The {@code TermRate}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TermRate build() {
            Utils.checkRequired(price, "price");
            Utils.checkRequired(term, "term");
            return new TermRate(this);
        }
    }

    /**
     * Parse {@code json} as {@code TermRate}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TermRate fromJson(String json) {
        return Utils.parse(json, TermRate.class);
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
