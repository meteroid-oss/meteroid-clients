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
public final class PriceComponent {
    @JsonProperty("fee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Fee> fee = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("product_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> productId = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private PriceComponent() {}

    private PriceComponent(Builder builder) {
        this.fee = builder.fee;
        this.id = builder.id;
        this.name = builder.name;
        this.productId = builder.productId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code PriceComponent}.
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
        builder.fee = fee;
        builder.id = id;
        builder.name = name;
        builder.productId = productId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code fee} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Fee> fee() {
        return fee.asOptional();
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
     * The {@code product_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> productId() {
        return productId.asOptional();
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
        PriceComponent that = (PriceComponent) o;
        return Objects.equals(fee, that.fee)
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(productId, that.productId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fee, id, name, productId, additionalProperties);
    }

    @Override
    public String toString() {
        return "PriceComponent{"
                + "fee="
                + fee
                + ", id="
                + id
                + ", name="
                + name
                + ", productId="
                + productId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link PriceComponent}. */
    public static final class Builder {
        private JsonField<Fee> fee = JsonField.missing();
        private String id;
        private String name;
        private JsonField<String> productId = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code fee} property.
         *
         * @param fee the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder fee(Fee fee) {
            this.fee = JsonField.ofNullable(fee);
            return this;
        }

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
         * The {@code product_id} property.
         *
         * @param productId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder productId(String productId) {
            this.productId = JsonField.ofNullable(productId);
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
         * The {@code PriceComponent}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public PriceComponent build() {
            Utils.checkRequired(id, "id");
            Utils.checkRequired(name, "name");
            return new PriceComponent(this);
        }
    }

    /**
     * Parse {@code json} as {@code PriceComponent}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PriceComponent fromJson(String json) {
        return Utils.parse(json, PriceComponent.class);
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
