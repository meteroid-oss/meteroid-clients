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
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class LinkedSegmentationMatrix {
    @JsonProperty("dimension1_key")
    private String dimension1Key;

    @JsonProperty("dimension2_key")
    private String dimension2Key;

    @JsonProperty("values")
    private Map<String, List<String>> values;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private LinkedSegmentationMatrix() {}

    private LinkedSegmentationMatrix(Builder builder) {
        this.dimension1Key = builder.dimension1Key;
        this.dimension2Key = builder.dimension2Key;
        this.values = Utils.copyMap(builder.values);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code LinkedSegmentationMatrix}.
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
        builder.dimension1Key = dimension1Key;
        builder.dimension2Key = dimension2Key;
        builder.values = Utils.mutableMap(values);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code dimension1_key} property.
     *
     * @return the value, never null
     */
    public String dimension1Key() {
        return Utils.required(dimension1Key, "dimension1_key");
    }

    /**
     * The {@code dimension2_key} property.
     *
     * @return the value, never null
     */
    public String dimension2Key() {
        return Utils.required(dimension2Key, "dimension2_key");
    }

    /**
     * The {@code values} property.
     *
     * @return the value, never null
     */
    public Map<String, List<String>> values() {
        return Utils.required(values, "values");
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
        LinkedSegmentationMatrix that = (LinkedSegmentationMatrix) o;
        return Objects.equals(dimension1Key, that.dimension1Key)
                && Objects.equals(dimension2Key, that.dimension2Key)
                && Objects.equals(values, that.values)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension1Key, dimension2Key, values, additionalProperties);
    }

    @Override
    public String toString() {
        return "LinkedSegmentationMatrix{"
                + "dimension1Key="
                + dimension1Key
                + ", dimension2Key="
                + dimension2Key
                + ", values="
                + values
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link LinkedSegmentationMatrix}. */
    public static final class Builder {
        private String dimension1Key;
        private String dimension2Key;
        private Map<String, List<String>> values;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code dimension1_key} property.
         *
         * @param dimension1Key the value
         * @return this builder
         */
        public Builder dimension1Key(String dimension1Key) {
            this.dimension1Key = dimension1Key;
            return this;
        }

        /**
         * The {@code dimension2_key} property.
         *
         * @param dimension2Key the value
         * @return this builder
         */
        public Builder dimension2Key(String dimension2Key) {
            this.dimension2Key = dimension2Key;
            return this;
        }

        /**
         * The {@code values} property.
         *
         * @param values the value
         * @return this builder
         */
        public Builder values(Map<String, List<String>> values) {
            this.values = Utils.mutableMap(values);
            return this;
        }

        /**
         * Puts an entry in {@code values}.
         *
         * @param key the key
         * @param item the item
         * @return this builder
         */
        public Builder putValuesItem(String key, List<String> item) {
            if (this.values == null) {
                this.values = new LinkedHashMap<>();
            }
            this.values.put(key, item);
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
         * The {@code LinkedSegmentationMatrix}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public LinkedSegmentationMatrix build() {
            Utils.checkRequired(dimension1Key, "dimension1_key");
            Utils.checkRequired(dimension2Key, "dimension2_key");
            Utils.checkRequired(values, "values");
            return new LinkedSegmentationMatrix(this);
        }
    }

    /**
     * Parse {@code json} as {@code LinkedSegmentationMatrix}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static LinkedSegmentationMatrix fromJson(String json) {
        return Utils.parse(json, LinkedSegmentationMatrix.class);
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
