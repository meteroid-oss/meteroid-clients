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

import java.time.OffsetDateTime;
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
public final class ProductEventData {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("fee_type")
    private ProductFeeTypeEnum feeType;

    @JsonProperty("name")
    private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    @JsonProperty("product_id")
    private String productId;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ProductEventData() {}

    private ProductEventData(Builder builder) {
        this.createdAt = builder.createdAt;
        this.description = builder.description;
        this.feeType = builder.feeType;
        this.name = builder.name;
        this.productFamilyId = builder.productFamilyId;
        this.productId = builder.productId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ProductEventData}.
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
        builder.createdAt = createdAt;
        builder.description = description;
        builder.feeType = feeType;
        builder.name = name;
        builder.productFamilyId = productFamilyId;
        builder.productId = productId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
    }

    /**
     * The {@code description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> description() {
        return description.asOptional();
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
     * The {@code product_family_id} property.
     *
     * @return the value, never null
     */
    public String productFamilyId() {
        return Utils.required(productFamilyId, "product_family_id");
    }

    /**
     * The {@code product_id} property.
     *
     * @return the value, never null
     */
    public String productId() {
        return Utils.required(productId, "product_id");
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
        ProductEventData that = (ProductEventData) o;
        return Objects.equals(createdAt, that.createdAt)
                && Objects.equals(description, that.description)
                && Objects.equals(feeType, that.feeType)
                && Objects.equals(name, that.name)
                && Objects.equals(productFamilyId, that.productFamilyId)
                && Objects.equals(productId, that.productId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                createdAt,
                description,
                feeType,
                name,
                productFamilyId,
                productId,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "ProductEventData{"
                + "createdAt="
                + createdAt
                + ", description="
                + description
                + ", feeType="
                + feeType
                + ", name="
                + name
                + ", productFamilyId="
                + productFamilyId
                + ", productId="
                + productId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ProductEventData}. */
    public static final class Builder {
        private OffsetDateTime createdAt;
        private JsonField<String> description = JsonField.missing();
        private ProductFeeTypeEnum feeType;
        private String name;
        private String productFamilyId;
        private String productId;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code created_at} property.
         *
         * @param createdAt the value
         * @return this builder
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * The {@code description} property.
         *
         * @param description the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder description(String description) {
            this.description = JsonField.ofNullable(description);
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
         * The {@code product_family_id} property.
         *
         * @param productFamilyId the value
         * @return this builder
         */
        public Builder productFamilyId(String productFamilyId) {
            this.productFamilyId = productFamilyId;
            return this;
        }

        /**
         * The {@code product_id} property.
         *
         * @param productId the value
         * @return this builder
         */
        public Builder productId(String productId) {
            this.productId = productId;
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
         * The {@code ProductEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ProductEventData build() {
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(feeType, "fee_type");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(productFamilyId, "product_family_id");
            Utils.checkRequired(productId, "product_id");
            return new ProductEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code ProductEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ProductEventData fromJson(String json) {
        return Utils.parse(json, ProductEventData.class);
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
