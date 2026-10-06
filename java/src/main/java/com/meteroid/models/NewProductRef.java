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
public final class NewProductRef {
    @JsonProperty("fee_structure")
    private ProductFeeStructure feeStructure;

    @JsonProperty("fee_type")
    private ProductFeeTypeEnum feeType;

    @JsonProperty("name")
    private String name;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private NewProductRef() {}

    private NewProductRef(Builder builder) {
        this.feeStructure = builder.feeStructure;
        this.feeType = builder.feeType;
        this.name = builder.name;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code NewProductRef}.
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
        builder.feeStructure = feeStructure;
        builder.feeType = feeType;
        builder.name = name;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code fee_structure} property.
     *
     * @return the value, never null
     */
    public ProductFeeStructure feeStructure() {
        return Utils.required(feeStructure, "fee_structure");
    }

    /**
     * The {@code fee_type} property.
     *
     * @return the value, never null
     */
    public ProductFeeTypeEnum feeType() {
        return Utils.required(feeType, "fee_type");
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
        NewProductRef that = (NewProductRef) o;
        return Objects.equals(feeStructure, that.feeStructure)
                && Objects.equals(feeType, that.feeType)
                && Objects.equals(name, that.name)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feeStructure, feeType, name, additionalProperties);
    }

    @Override
    public String toString() {
        return "NewProductRef{"
                + "feeStructure="
                + feeStructure
                + ", feeType="
                + feeType
                + ", name="
                + name
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link NewProductRef}. */
    public static final class Builder {
        private ProductFeeStructure feeStructure;
        private ProductFeeTypeEnum feeType;
        private String name;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code fee_structure} property.
         *
         * @param feeStructure the value
         * @return this builder
         */
        public Builder feeStructure(ProductFeeStructure feeStructure) {
            this.feeStructure = feeStructure;
            return this;
        }

        /**
         * The {@code fee_type} property.
         *
         * @param feeType the value
         * @return this builder
         */
        public Builder feeType(ProductFeeTypeEnum feeType) {
            this.feeType = feeType;
            return this;
        }

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
         * The {@code NewProductRef}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public NewProductRef build() {
            Utils.checkRequired(feeStructure, "fee_structure");
            Utils.checkRequired(feeType, "fee_type");
            Utils.checkRequired(name, "name");
            return new NewProductRef(this);
        }
    }

    /**
     * Parse {@code json} as {@code NewProductRef}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static NewProductRef fromJson(String json) {
        return Utils.parse(json, NewProductRef.class);
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
