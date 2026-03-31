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
public class UpdateProductRequest {
    @JsonProperty private String description;

    @JsonProperty("fee_structure")
    private ProductFeeStructure feeStructure;

    @JsonProperty private String name;

    public UpdateProductRequest() {}

    public UpdateProductRequest description(String description) {
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

    public UpdateProductRequest feeStructure(ProductFeeStructure feeStructure) {
        this.feeStructure = feeStructure;
        return this;
    }

    /**
     * Get feeStructure
     *
     * @return feeStructure
     */
    @javax.annotation.Nullable
    public ProductFeeStructure getFeeStructure() {
        return feeStructure;
    }

    public void setFeeStructure(ProductFeeStructure feeStructure) {
        this.feeStructure = feeStructure;
    }

    public UpdateProductRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Create an instance of UpdateProductRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UpdateProductRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     UpdateProductRequest
     */
    public static UpdateProductRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UpdateProductRequest.class);
    }

    /**
     * Convert an instance of UpdateProductRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
