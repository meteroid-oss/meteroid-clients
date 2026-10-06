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
public final class CreateProductRequest {
    @JsonProperty("catalog")
    private Boolean catalog;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("fee_structure")
    private ProductFeeStructure feeStructure;

    @JsonProperty("name")
    private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateProductRequest() {}

    private CreateProductRequest(Builder builder) {
        this.catalog = builder.catalog;
        this.description = builder.description;
        this.feeStructure = builder.feeStructure;
        this.name = builder.name;
        this.productFamilyId = builder.productFamilyId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateProductRequest}.
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
        builder.catalog = catalog;
        builder.description = description;
        builder.feeStructure = feeStructure;
        builder.name = name;
        builder.productFamilyId = productFamilyId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code catalog} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> catalog() {
        return Optional.ofNullable(catalog);
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
        CreateProductRequest that = (CreateProductRequest) o;
        return Objects.equals(catalog, that.catalog)
                && Objects.equals(description, that.description)
                && Objects.equals(feeStructure, that.feeStructure)
                && Objects.equals(name, that.name)
                && Objects.equals(productFamilyId, that.productFamilyId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                catalog, description, feeStructure, name, productFamilyId, additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateProductRequest{"
                + "catalog="
                + catalog
                + ", description="
                + description
                + ", feeStructure="
                + feeStructure
                + ", name="
                + name
                + ", productFamilyId="
                + productFamilyId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateProductRequest}. */
    public static final class Builder {
        private Boolean catalog;
        private JsonField<String> description = JsonField.missing();
        private ProductFeeStructure feeStructure;
        private String name;
        private String productFamilyId;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * The {@code CreateProductRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateProductRequest build() {
            Utils.checkRequired(feeStructure, "fee_structure");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(productFamilyId, "product_family_id");
            return new CreateProductRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateProductRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateProductRequest fromJson(String json) {
        return Utils.parse(json, CreateProductRequest.class);
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
