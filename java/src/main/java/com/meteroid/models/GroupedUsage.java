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
public final class GroupedUsage {
    @JsonProperty("dimensions")
    private Map<String, String> dimensions;

    @JsonProperty("value")
    private BigDecimal value;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private GroupedUsage() {}

    private GroupedUsage(Builder builder) {
        this.dimensions = Utils.copyMap(builder.dimensions);
        this.value = builder.value;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code GroupedUsage}.
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
        builder.dimensions = Utils.mutableMap(dimensions);
        builder.value = value;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code dimensions} property.
     *
     * @return the value, never null
     */
    public Map<String, String> dimensions() {
        return Utils.required(dimensions, "dimensions");
    }

    /**
     * The {@code value} property.
     *
     * @return the value, never null
     */
    public BigDecimal value() {
        return Utils.required(value, "value");
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
        GroupedUsage that = (GroupedUsage) o;
        return Objects.equals(dimensions, that.dimensions)
                && Objects.equals(value, that.value)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimensions, value, additionalProperties);
    }

    @Override
    public String toString() {
        return "GroupedUsage{"
                + "dimensions="
                + dimensions
                + ", value="
                + value
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link GroupedUsage}. */
    public static final class Builder {
        private Map<String, String> dimensions;
        private BigDecimal value;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code dimensions} property.
         *
         * @param dimensions the value
         * @return this builder
         */
        public Builder dimensions(Map<String, String> dimensions) {
            this.dimensions = Utils.mutableMap(dimensions);
            return this;
        }

        /**
         * Puts an entry in {@code dimensions}.
         *
         * @param key the key
         * @param item the item
         * @return this builder
         */
        public Builder putDimensionsItem(String key, String item) {
            if (this.dimensions == null) {
                this.dimensions = new LinkedHashMap<>();
            }
            this.dimensions.put(key, item);
            return this;
        }

        /**
         * The {@code value} property.
         *
         * @param value the value
         * @return this builder
         */
        public Builder value(BigDecimal value) {
            this.value = value;
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
         * The {@code GroupedUsage}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public GroupedUsage build() {
            Utils.checkRequired(dimensions, "dimensions");
            Utils.checkRequired(value, "value");
            return new GroupedUsage(this);
        }
    }

    /**
     * Parse {@code json} as {@code GroupedUsage}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static GroupedUsage fromJson(String json) {
        return Utils.parse(json, GroupedUsage.class);
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
