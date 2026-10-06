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
public final class SubLineItem {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("quantity")
    private BigDecimal quantity;

    @JsonProperty("total")
    private Long total;

    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SubLineItem() {}

    private SubLineItem(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.total = builder.total;
        this.unitPrice = builder.unitPrice;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SubLineItem}.
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
        builder.id = id;
        builder.name = name;
        builder.quantity = quantity;
        builder.total = total;
        builder.unitPrice = unitPrice;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
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
     * The {@code quantity} property.
     *
     * @return the value, never null
     */
    public BigDecimal quantity() {
        return Utils.required(quantity, "quantity");
    }

    /**
     * The {@code total} property.
     *
     * @return the value, never null
     */
    public Long total() {
        return Utils.required(total, "total");
    }

    /**
     * The {@code unit_price} property.
     *
     * @return the value, never null
     */
    public BigDecimal unitPrice() {
        return Utils.required(unitPrice, "unit_price");
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
        SubLineItem that = (SubLineItem) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(total, that.total)
                && Objects.equals(unitPrice, that.unitPrice)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, total, unitPrice, additionalProperties);
    }

    @Override
    public String toString() {
        return "SubLineItem{"
                + "id="
                + id
                + ", name="
                + name
                + ", quantity="
                + quantity
                + ", total="
                + total
                + ", unitPrice="
                + unitPrice
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SubLineItem}. */
    public static final class Builder {
        private String id;
        private String name;
        private BigDecimal quantity;
        private Long total;
        private BigDecimal unitPrice;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * The {@code quantity} property.
         *
         * @param quantity the value
         * @return this builder
         */
        public Builder quantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * The {@code total} property.
         *
         * @param total the value
         * @return this builder
         */
        public Builder total(Long total) {
            this.total = total;
            return this;
        }

        /**
         * The {@code unit_price} property.
         *
         * @param unitPrice the value
         * @return this builder
         */
        public Builder unitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
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
         * The {@code SubLineItem}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SubLineItem build() {
            Utils.checkRequired(id, "id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(quantity, "quantity");
            Utils.checkRequired(total, "total");
            Utils.checkRequired(unitPrice, "unit_price");
            return new SubLineItem(this);
        }
    }

    /**
     * Parse {@code json} as {@code SubLineItem}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SubLineItem fromJson(String json) {
        return Utils.parse(json, SubLineItem.class);
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
