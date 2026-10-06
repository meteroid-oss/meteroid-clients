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
public final class Product {
    @JsonProperty("archived_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> archivedAt = JsonField.missing();

    @JsonProperty("catalog")
    private Boolean catalog;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("fee_structure")
    private ProductFeeStructure feeStructure;

    @JsonProperty("fee_type")
    private ProductFeeTypeEnum feeType;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Product() {}

    private Product(Builder builder) {
        this.archivedAt = builder.archivedAt;
        this.catalog = builder.catalog;
        this.createdAt = builder.createdAt;
        this.description = builder.description;
        this.feeStructure = builder.feeStructure;
        this.feeType = builder.feeType;
        this.id = builder.id;
        this.name = builder.name;
        this.productFamilyId = builder.productFamilyId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Product}.
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
        builder.archivedAt = archivedAt;
        builder.catalog = catalog;
        builder.createdAt = createdAt;
        builder.description = description;
        builder.feeStructure = feeStructure;
        builder.feeType = feeType;
        builder.id = id;
        builder.name = name;
        builder.productFamilyId = productFamilyId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code archived_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> archivedAt() {
        return archivedAt.asOptional();
    }

    /**
     * The {@code catalog} property.
     *
     * @return the value, never null
     */
    public Boolean catalog() {
        return Utils.required(catalog, "catalog");
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
     * The {@code product_family_id} property.
     *
     * @return the value, never null
     */
    public String productFamilyId() {
        return Utils.required(productFamilyId, "product_family_id");
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
        Product that = (Product) o;
        return Objects.equals(archivedAt, that.archivedAt)
                && Objects.equals(catalog, that.catalog)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(description, that.description)
                && Objects.equals(feeStructure, that.feeStructure)
                && Objects.equals(feeType, that.feeType)
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(productFamilyId, that.productFamilyId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                archivedAt,
                catalog,
                createdAt,
                description,
                feeStructure,
                feeType,
                id,
                name,
                productFamilyId,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "Product{"
                + "archivedAt="
                + archivedAt
                + ", catalog="
                + catalog
                + ", createdAt="
                + createdAt
                + ", description="
                + description
                + ", feeStructure="
                + feeStructure
                + ", feeType="
                + feeType
                + ", id="
                + id
                + ", name="
                + name
                + ", productFamilyId="
                + productFamilyId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Product}. */
    public static final class Builder {
        private JsonField<OffsetDateTime> archivedAt = JsonField.missing();
        private Boolean catalog;
        private OffsetDateTime createdAt;
        private JsonField<String> description = JsonField.missing();
        private ProductFeeStructure feeStructure;
        private ProductFeeTypeEnum feeType;
        private String id;
        private String name;
        private String productFamilyId;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code archived_at} property.
         *
         * @param archivedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder archivedAt(OffsetDateTime archivedAt) {
            this.archivedAt = JsonField.ofNullable(archivedAt);
            return this;
        }

        /**
         * The {@code catalog} property.
         *
         * @param catalog the value
         * @return this builder
         */
        public Builder catalog(Boolean catalog) {
            this.catalog = catalog;
            return this;
        }

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
         * The {@code Product}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Product build() {
            Utils.checkRequired(catalog, "catalog");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(feeStructure, "fee_structure");
            Utils.checkRequired(feeType, "fee_type");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(productFamilyId, "product_family_id");
            return new Product(this);
        }
    }

    /**
     * Parse {@code json} as {@code Product}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Product fromJson(String json) {
        return Utils.parse(json, Product.class);
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
