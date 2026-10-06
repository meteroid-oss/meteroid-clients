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
public final class FixedDiscount {
    @JsonProperty("amount")
    private String amount;

    @JsonProperty("currency")
    private String currency;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private FixedDiscount() {}

    private FixedDiscount(Builder builder) {
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code FixedDiscount}.
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
        builder.amount = amount;
        builder.currency = currency;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code amount} property.
     *
     * @return the value, never null
     */
    public String amount() {
        return Utils.required(amount, "amount");
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
        FixedDiscount that = (FixedDiscount) o;
        return Objects.equals(amount, that.amount)
                && Objects.equals(currency, that.currency)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency, additionalProperties);
    }

    @Override
    public String toString() {
        return "FixedDiscount{"
                + "amount="
                + amount
                + ", currency="
                + currency
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link FixedDiscount}. */
    public static final class Builder {
        private String amount;
        private String currency;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code amount} property.
         *
         * @param amount the value
         * @return this builder
         */
        public Builder amount(String amount) {
            this.amount = amount;
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
         * The {@code FixedDiscount}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public FixedDiscount build() {
            Utils.checkRequired(amount, "amount");
            Utils.checkRequired(currency, "currency");
            return new FixedDiscount(this);
        }
    }

    /**
     * Parse {@code json} as {@code FixedDiscount}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static FixedDiscount fromJson(String json) {
        return Utils.parse(json, FixedDiscount.class);
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
