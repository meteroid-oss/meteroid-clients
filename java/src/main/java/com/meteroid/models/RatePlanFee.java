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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Recurring rate fee (e.g., monthly subscription)
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class RatePlanFee {
    @JsonProperty("rates")
    private List<TermRate> rates;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private RatePlanFee() {}

    private RatePlanFee(Builder builder) {
        this.rates = Utils.copyList(builder.rates);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code RatePlanFee}.
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
        builder.rates = Utils.mutableList(rates);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code rates} property.
     *
     * @return the value, never null
     */
    public List<TermRate> rates() {
        return Utils.required(rates, "rates");
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
        RatePlanFee that = (RatePlanFee) o;
        return Objects.equals(rates, that.rates)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates, additionalProperties);
    }

    @Override
    public String toString() {
        return "RatePlanFee{"
                + "rates="
                + rates
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link RatePlanFee}. */
    public static final class Builder {
        private List<TermRate> rates;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code rates} property.
         *
         * @param rates the value
         * @return this builder
         */
        public Builder rates(List<TermRate> rates) {
            this.rates = Utils.mutableList(rates);
            return this;
        }

        /**
         * Adds an item to {@code rates}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addRatesItem(TermRate item) {
            if (this.rates == null) {
                this.rates = new ArrayList<>();
            }
            this.rates.add(item);
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
         * The {@code RatePlanFee}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public RatePlanFee build() {
            Utils.checkRequired(rates, "rates");
            return new RatePlanFee(this);
        }
    }

    /**
     * Parse {@code json} as {@code RatePlanFee}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static RatePlanFee fromJson(String json) {
        return Utils.parse(json, RatePlanFee.class);
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
