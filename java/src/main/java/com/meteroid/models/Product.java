// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.OffsetDateTime;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Product {
    @JsonProperty("archived_at")
    private OffsetDateTime archivedAt;

    @JsonProperty private Boolean catalog;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;

    @JsonProperty("fee_structure")
    private ProductFeeStructure feeStructure;

    @JsonProperty("fee_type")
    private ProductFeeTypeEnum feeType;

    @JsonProperty private String id;
    @JsonProperty private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    public Product() {}

    public Product archivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
        return this;
    }

    /**
     * Get archivedAt
     *
     * @return archivedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }

    public Product catalog(Boolean catalog) {
        this.catalog = catalog;
        return this;
    }

    /**
     * Get catalog
     *
     * @return catalog
     */
    @javax.annotation.Nonnull
    public Boolean getCatalog() {
        return catalog;
    }

    public void setCatalog(Boolean catalog) {
        this.catalog = catalog;
    }

    public Product createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product feeStructure(ProductFeeStructure feeStructure) {
        this.feeStructure = feeStructure;
        return this;
    }

    /**
     * Get feeStructure
     *
     * @return feeStructure
     */
    @javax.annotation.Nonnull
    public ProductFeeStructure getFeeStructure() {
        return feeStructure;
    }

    public void setFeeStructure(ProductFeeStructure feeStructure) {
        this.feeStructure = feeStructure;
    }

    public Product feeType(ProductFeeTypeEnum feeType) {
        this.feeType = feeType;
        return this;
    }

    /**
     * Get feeType
     *
     * @return feeType
     */
    @javax.annotation.Nonnull
    public ProductFeeTypeEnum getFeeType() {
        return feeType;
    }

    public void setFeeType(ProductFeeTypeEnum feeType) {
        this.feeType = feeType;
    }

    public Product id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product productFamilyId(String productFamilyId) {
        this.productFamilyId = productFamilyId;
        return this;
    }

    /**
     * Get productFamilyId
     *
     * @return productFamilyId
     */
    @javax.annotation.Nonnull
    public String getProductFamilyId() {
        return productFamilyId;
    }

    public void setProductFamilyId(String productFamilyId) {
        this.productFamilyId = productFamilyId;
    }

    /**
     * Create an instance of Product given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Product
     * @throws JsonProcessingException if the JSON string is invalid with respect to Product
     */
    public static Product fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Product.class);
    }

    /**
     * Convert an instance of Product to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
