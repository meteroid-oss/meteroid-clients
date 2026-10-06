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
public final class CustomTaxRate {
    @JsonProperty("name")
    private String name;

    @JsonProperty("rate")
    private String rate;

    @JsonProperty("tax_code")
    private String taxCode;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CustomTaxRate() {}

    private CustomTaxRate(Builder builder) {
        this.name = builder.name;
        this.rate = builder.rate;
        this.taxCode = builder.taxCode;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CustomTaxRate}.
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
        builder.name = name;
        builder.rate = rate;
        builder.taxCode = taxCode;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code rate} property.
     *
     * @return the value, never null
     */
    public String rate() {
        return Utils.required(rate, "rate");
    }

    /**
     * The {@code tax_code} property.
     *
     * @return the value, never null
     */
    public String taxCode() {
        return Utils.required(taxCode, "tax_code");
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
        CustomTaxRate that = (CustomTaxRate) o;
        return Objects.equals(name, that.name)
                && Objects.equals(rate, that.rate)
                && Objects.equals(taxCode, that.taxCode)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate, taxCode, additionalProperties);
    }

    @Override
    public String toString() {
        return "CustomTaxRate{"
                + "name="
                + name
                + ", rate="
                + rate
                + ", taxCode="
                + taxCode
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CustomTaxRate}. */
    public static final class Builder {
        private String name;
        private String rate;
        private String taxCode;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code name} property.
         *
         * @param name the value
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The {@code rate} property.
         *
         * @param rate the value
         * @return this builder
         */
        public Builder rate(String rate) {
            this.rate = rate;
            return this;
        }

        /**
         * The {@code tax_code} property.
         *
         * @param taxCode the value
         * @return this builder
         */
        public Builder taxCode(String taxCode) {
            this.taxCode = taxCode;
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
         * The {@code CustomTaxRate}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CustomTaxRate build() {
            Utils.checkRequired(name, "name");
            Utils.checkRequired(rate, "rate");
            Utils.checkRequired(taxCode, "tax_code");
            return new CustomTaxRate(this);
        }
    }

    /**
     * Parse {@code json} as {@code CustomTaxRate}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CustomTaxRate fromJson(String json) {
        return Utils.parse(json, CustomTaxRate.class);
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
