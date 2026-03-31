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
public class NewProductRef {
    @JsonProperty("fee_structure")
    private ProductFeeStructure feeStructure;

    @JsonProperty("fee_type")
    private ProductFeeTypeEnum feeType;

    @JsonProperty private String name;

    public NewProductRef() {}

    public NewProductRef feeStructure(ProductFeeStructure feeStructure) {
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

    public NewProductRef feeType(ProductFeeTypeEnum feeType) {
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

    public NewProductRef name(String name) {
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

    /**
     * Create an instance of NewProductRef given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of NewProductRef
     * @throws JsonProcessingException if the JSON string is invalid with respect to NewProductRef
     */
    public static NewProductRef fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, NewProductRef.class);
    }

    /**
     * Convert an instance of NewProductRef to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
