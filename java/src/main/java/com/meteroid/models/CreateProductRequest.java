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

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CreateProductRequest {
    @JsonProperty private Boolean catalog;
    @JsonProperty private String description;

    @JsonProperty("fee_structure")
    private ProductFeeStructure feeStructure;

    @JsonProperty private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    public CreateProductRequest() {}

    public CreateProductRequest catalog(Boolean catalog) {
        this.catalog = catalog;
        return this;
    }

    /**
     * Get catalog
     *
     * @return catalog
     */
    @javax.annotation.Nullable
    public Boolean getCatalog() {
        return catalog;
    }

    public void setCatalog(Boolean catalog) {
        this.catalog = catalog;
    }

    public CreateProductRequest description(String description) {
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

    public CreateProductRequest feeStructure(ProductFeeStructure feeStructure) {
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

    public CreateProductRequest name(String name) {
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

    public CreateProductRequest productFamilyId(String productFamilyId) {
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
     * Create an instance of CreateProductRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateProductRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateProductRequest
     */
    public static CreateProductRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateProductRequest.class);
    }

    /**
     * Convert an instance of CreateProductRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
