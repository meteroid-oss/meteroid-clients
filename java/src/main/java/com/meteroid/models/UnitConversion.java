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
public final class UnitConversion {
    @JsonProperty("factor")
    private Integer factor;

    @JsonProperty("rounding")
    private UnitConversionRoundingEnum rounding;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private UnitConversion() {}

    private UnitConversion(Builder builder) {
        this.factor = builder.factor;
        this.rounding = builder.rounding;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code UnitConversion}.
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
        builder.factor = factor;
        builder.rounding = rounding;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code factor} property.
     *
     * @return the value, never null
     */
    public Integer factor() {
        return Utils.required(factor, "factor");
    }

    /**
     * The {@code rounding} property.
     *
     * @return the value, never null
     */
    public UnitConversionRoundingEnum rounding() {
        return Utils.required(rounding, "rounding");
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
        UnitConversion that = (UnitConversion) o;
        return Objects.equals(factor, that.factor)
                && Objects.equals(rounding, that.rounding)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factor, rounding, additionalProperties);
    }

    @Override
    public String toString() {
        return "UnitConversion{"
                + "factor="
                + factor
                + ", rounding="
                + rounding
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link UnitConversion}. */
    public static final class Builder {
        private Integer factor;
        private UnitConversionRoundingEnum rounding;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code factor} property.
         *
         * @param factor the value
         * @return this builder
         */
        public Builder factor(Integer factor) {
            this.factor = factor;
            return this;
        }

        /**
         * The {@code rounding} property.
         *
         * @param rounding the value
         * @return this builder
         */
        public Builder rounding(UnitConversionRoundingEnum rounding) {
            this.rounding = rounding;
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
         * The {@code UnitConversion}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public UnitConversion build() {
            Utils.checkRequired(factor, "factor");
            Utils.checkRequired(rounding, "rounding");
            return new UnitConversion(this);
        }
    }

    /**
     * Parse {@code json} as {@code UnitConversion}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static UnitConversion fromJson(String json) {
        return Utils.parse(json, UnitConversion.class);
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
