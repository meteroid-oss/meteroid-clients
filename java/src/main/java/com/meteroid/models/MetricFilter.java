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
 * A pre-aggregation filter: only events whose <code>property</code> matches feed the metric's
 * aggregation. Distinct from a segmentation dimension (which splits pricing). Multiple filters are
 * ANDed.
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class MetricFilter {
    @JsonProperty("op")
    private MetricFilterOperator op;

    @JsonProperty("property")
    private String property;

    @JsonProperty("values")
    private List<String> values;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MetricFilter() {}

    private MetricFilter(Builder builder) {
        this.op = builder.op;
        this.property = builder.property;
        this.values = Utils.copyList(builder.values);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MetricFilter}.
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
        builder.op = op;
        builder.property = property;
        builder.values = Utils.mutableList(values);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code op} property.
     *
     * @return the value, never null
     */
    public MetricFilterOperator op() {
        return Utils.required(op, "op");
    }

    /**
     * The {@code property} property.
     *
     * @return the value, never null
     */
    public String property() {
        return Utils.required(property, "property");
    }

    /**
     * The {@code values} property.
     *
     * @return the value, never null
     */
    public List<String> values() {
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
        MetricFilter that = (MetricFilter) o;
        return Objects.equals(op, that.op)
                && Objects.equals(property, that.property)
                && Objects.equals(values, that.values)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(op, property, values, additionalProperties);
    }

    @Override
    public String toString() {
        return "MetricFilter{"
                + "op="
                + op
                + ", property="
                + property
                + ", values="
                + values
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MetricFilter}. */
    public static final class Builder {
        private MetricFilterOperator op;
        private String property;
        private List<String> values;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code op} property.
         *
         * @param op the value
         * @return this builder
         */
        public Builder op(MetricFilterOperator op) {
            this.op = op;
            return this;
        }

        /**
         * The {@code property} property.
         *
         * @param property the value
         * @return this builder
         */
        public Builder property(String property) {
            this.property = property;
            return this;
        }

        /**
         * The {@code values} property.
         *
         * @param values the value
         * @return this builder
         */
        public Builder values(List<String> values) {
            this.values = Utils.mutableList(values);
            return this;
        }

        /**
         * Adds an item to {@code values}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addValuesItem(String item) {
            if (this.values == null) {
                this.values = new ArrayList<>();
            }
            this.values.add(item);
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
         * The {@code MetricFilter}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MetricFilter build() {
            Utils.checkRequired(op, "op");
            Utils.checkRequired(property, "property");
            Utils.checkRequired(values, "values");
            return new MetricFilter(this);
        }
    }

    /**
     * Parse {@code json} as {@code MetricFilter}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MetricFilter fromJson(String json) {
        return Utils.parse(json, MetricFilter.class);
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
