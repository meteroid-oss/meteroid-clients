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
import com.meteroid.internal.JsonField;
import com.meteroid.internal.Utils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class MatrixRow {
    @JsonProperty("dimension1")
    private MatrixDimension dimension1;

    @JsonProperty("dimension2")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<MatrixDimension> dimension2 = JsonField.missing();

    @JsonProperty("per_unit_price")
    private BigDecimal perUnitPrice;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MatrixRow() {}

    private MatrixRow(Builder builder) {
        this.dimension1 = builder.dimension1;
        this.dimension2 = builder.dimension2;
        this.perUnitPrice = builder.perUnitPrice;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MatrixRow}.
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
        builder.perUnitPrice = perUnitPrice;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code dimension1} property.
     *
     * @return the value, never null
     */
    public MatrixDimension dimension1() {
        return Utils.required(dimension1, "dimension1");
    }

    /**
     * The {@code dimension2} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<MatrixDimension> dimension2() {
        return dimension2.asOptional();
    }

    /**
     * The {@code per_unit_price} property.
     *
     * @return the value, never null
     */
    public BigDecimal perUnitPrice() {
        return Utils.required(perUnitPrice, "per_unit_price");
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
        MatrixRow that = (MatrixRow) o;
        return Objects.equals(dimension1, that.dimension1)
                && Objects.equals(dimension2, that.dimension2)
                && Objects.equals(perUnitPrice, that.perUnitPrice)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension1, dimension2, perUnitPrice, additionalProperties);
    }

    @Override
    public String toString() {
        return "MatrixRow{"
                + "dimension1="
                + dimension1
                + ", dimension2="
                + dimension2
                + ", perUnitPrice="
                + perUnitPrice
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MatrixRow}. */
    public static final class Builder {
        private MatrixDimension dimension1;
        private JsonField<MatrixDimension> dimension2 = JsonField.missing();
        private BigDecimal perUnitPrice;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code dimension1} property.
         *
         * @param dimension1 the value
         * @return this builder
         */
        public Builder dimension1(MatrixDimension dimension1) {
            this.dimension1 = dimension1;
            return this;
        }

        /**
         * The {@code dimension2} property.
         *
         * @param dimension2 the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder dimension2(MatrixDimension dimension2) {
            this.dimension2 = JsonField.ofNullable(dimension2);
            return this;
        }

        /**
         * The {@code per_unit_price} property.
         *
         * @param perUnitPrice the value
         * @return this builder
         */
        public Builder perUnitPrice(BigDecimal perUnitPrice) {
            this.perUnitPrice = perUnitPrice;
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
         * The {@code MatrixRow}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MatrixRow build() {
            Utils.checkRequired(dimension1, "dimension1");
            Utils.checkRequired(perUnitPrice, "per_unit_price");
            return new MatrixRow(this);
        }
    }

    /**
     * Parse {@code json} as {@code MatrixRow}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MatrixRow fromJson(String json) {
        return Utils.parse(json, MatrixRow.class);
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
