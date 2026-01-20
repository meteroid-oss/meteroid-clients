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
public class MatrixRow {
    @JsonProperty private MatrixDimension dimension1;
    @JsonProperty private MatrixDimension dimension2;

    @JsonProperty("per_unit_price")
    private String perUnitPrice;

    public MatrixRow() {}

    public MatrixRow dimension1(MatrixDimension dimension1) {
        this.dimension1 = dimension1;
        return this;
    }

    /**
     * Get dimension1
     *
     * @return dimension1
     */
    @javax.annotation.Nonnull
    public MatrixDimension getDimension1() {
        return dimension1;
    }

    public void setDimension1(MatrixDimension dimension1) {
        this.dimension1 = dimension1;
    }

    public MatrixRow dimension2(MatrixDimension dimension2) {
        this.dimension2 = dimension2;
        return this;
    }

    /**
     * Get dimension2
     *
     * @return dimension2
     */
    @javax.annotation.Nullable
    public MatrixDimension getDimension2() {
        return dimension2;
    }

    public void setDimension2(MatrixDimension dimension2) {
        this.dimension2 = dimension2;
    }

    public MatrixRow perUnitPrice(String perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
        return this;
    }

    /**
     * Get perUnitPrice
     *
     * @return perUnitPrice
     */
    @javax.annotation.Nonnull
    public String getPerUnitPrice() {
        return perUnitPrice;
    }

    public void setPerUnitPrice(String perUnitPrice) {
        this.perUnitPrice = perUnitPrice;
    }

    /**
     * Create an instance of MatrixRow given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MatrixRow
     * @throws JsonProcessingException if the JSON string is invalid with respect to MatrixRow
     */
    public static MatrixRow fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MatrixRow.class);
    }

    /**
     * Convert an instance of MatrixRow to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
