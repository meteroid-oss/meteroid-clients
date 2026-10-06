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
public final class PackagePlanPricing {
    @JsonProperty("block_size")
    private Long blockSize;

    @JsonProperty("rate")
    private BigDecimal rate;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private PackagePlanPricing() {}

    private PackagePlanPricing(Builder builder) {
        this.blockSize = builder.blockSize;
        this.rate = builder.rate;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code PackagePlanPricing}.
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
        builder.blockSize = blockSize;
        builder.rate = rate;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code block_size} property.
     *
     * @return the value, never null
     */
    public Long blockSize() {
        return Utils.required(blockSize, "block_size");
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
        PackagePlanPricing that = (PackagePlanPricing) o;
        return Objects.equals(blockSize, that.blockSize)
                && Objects.equals(rate, that.rate)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockSize, rate, additionalProperties);
    }

    @Override
    public String toString() {
        return "PackagePlanPricing{"
                + "blockSize="
                + blockSize
                + ", rate="
                + rate
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link PackagePlanPricing}. */
    public static final class Builder {
        private Long blockSize;
        private BigDecimal rate;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code block_size} property.
         *
         * @param blockSize the value
         * @return this builder
         */
        public Builder blockSize(Long blockSize) {
            this.blockSize = blockSize;
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
         * The {@code PackagePlanPricing}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public PackagePlanPricing build() {
            Utils.checkRequired(blockSize, "block_size");
            Utils.checkRequired(rate, "rate");
            return new PackagePlanPricing(this);
        }
    }

    /**
     * Parse {@code json} as {@code PackagePlanPricing}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PackagePlanPricing fromJson(String json) {
        return Utils.parse(json, PackagePlanPricing.class);
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
