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
public final class DoubleSegmentationMatrix {
    @JsonProperty("dimension1")
    private MetricDimension dimension1;

    @JsonProperty("dimension2")
    private MetricDimension dimension2;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private DoubleSegmentationMatrix() {}

    private DoubleSegmentationMatrix(Builder builder) {
        this.dimension1 = builder.dimension1;
        this.dimension2 = builder.dimension2;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code DoubleSegmentationMatrix}.
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
        builder.dimension1 = dimension1;
        builder.dimension2 = dimension2;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code dimension1} property.
     *
     * @return the value, never null
     */
    public MetricDimension dimension1() {
        return Utils.required(dimension1, "dimension1");
    }

    /**
     * The {@code dimension2} property.
     *
     * @return the value, never null
     */
    public MetricDimension dimension2() {
        return Utils.required(dimension2, "dimension2");
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
        DoubleSegmentationMatrix that = (DoubleSegmentationMatrix) o;
        return Objects.equals(dimension1, that.dimension1)
                && Objects.equals(dimension2, that.dimension2)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension1, dimension2, additionalProperties);
    }

    @Override
    public String toString() {
        return "DoubleSegmentationMatrix{"
                + "dimension1="
                + dimension1
                + ", dimension2="
                + dimension2
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link DoubleSegmentationMatrix}. */
    public static final class Builder {
        private MetricDimension dimension1;
        private MetricDimension dimension2;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code dimension1} property.
         *
         * @param dimension1 the value
         * @return this builder
         */
        public Builder dimension1(MetricDimension dimension1) {
            this.dimension1 = dimension1;
            return this;
        }

        /**
         * The {@code dimension2} property.
         *
         * @param dimension2 the value
         * @return this builder
         */
        public Builder dimension2(MetricDimension dimension2) {
            this.dimension2 = dimension2;
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
         * The {@code DoubleSegmentationMatrix}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public DoubleSegmentationMatrix build() {
            Utils.checkRequired(dimension1, "dimension1");
            Utils.checkRequired(dimension2, "dimension2");
            return new DoubleSegmentationMatrix(this);
        }
    }

    /**
     * Parse {@code json} as {@code DoubleSegmentationMatrix}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static DoubleSegmentationMatrix fromJson(String json) {
        return Utils.parse(json, DoubleSegmentationMatrix.class);
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
