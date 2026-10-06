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
public final class ExtraComponent {
    @JsonProperty("name")
    private String name;

    @JsonProperty("price_entry")
    private PriceEntry priceEntry;

    @JsonProperty("product_ref")
    private ProductRef productRef;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ExtraComponent() {}

    private ExtraComponent(Builder builder) {
        this.name = builder.name;
        this.priceEntry = builder.priceEntry;
        this.productRef = builder.productRef;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ExtraComponent}.
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
        builder.priceEntry = priceEntry;
        builder.productRef = productRef;
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
     * The {@code price_entry} property.
     *
     * @return the value, never null
     */
    public PriceEntry priceEntry() {
        return Utils.required(priceEntry, "price_entry");
    }

    /**
     * The {@code product_ref} property.
     *
     * @return the value, never null
     */
    public ProductRef productRef() {
        return Utils.required(productRef, "product_ref");
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
        ExtraComponent that = (ExtraComponent) o;
        return Objects.equals(name, that.name)
                && Objects.equals(priceEntry, that.priceEntry)
                && Objects.equals(productRef, that.productRef)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priceEntry, productRef, additionalProperties);
    }

    @Override
    public String toString() {
        return "ExtraComponent{"
                + "name="
                + name
                + ", priceEntry="
                + priceEntry
                + ", productRef="
                + productRef
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ExtraComponent}. */
    public static final class Builder {
        private String name;
        private PriceEntry priceEntry;
        private ProductRef productRef;
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
         * The {@code price_entry} property.
         *
         * @param priceEntry the value
         * @return this builder
         */
        public Builder priceEntry(PriceEntry priceEntry) {
            this.priceEntry = priceEntry;
            return this;
        }

        /**
         * The {@code product_ref} property.
         *
         * @param productRef the value
         * @return this builder
         */
        public Builder productRef(ProductRef productRef) {
            this.productRef = productRef;
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
         * The {@code ExtraComponent}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ExtraComponent build() {
            Utils.checkRequired(name, "name");
            Utils.checkRequired(priceEntry, "price_entry");
            Utils.checkRequired(productRef, "product_ref");
            return new ExtraComponent(this);
        }
    }

    /**
     * Parse {@code json} as {@code ExtraComponent}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ExtraComponent fromJson(String json) {
        return Utils.parse(json, ExtraComponent.class);
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
