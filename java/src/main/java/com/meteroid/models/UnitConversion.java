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
public class UnitConversion {
    @JsonProperty private Integer factor;
    @JsonProperty private UnitConversionRoundingEnum rounding;

    public UnitConversion() {}

    public UnitConversion factor(Integer factor) {
        this.factor = factor;
        return this;
    }

    /**
     * Get factor
     *
     * @return factor
     */
    @javax.annotation.Nonnull
    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public UnitConversion rounding(UnitConversionRoundingEnum rounding) {
        this.rounding = rounding;
        return this;
    }

    /**
     * Get rounding
     *
     * @return rounding
     */
    @javax.annotation.Nonnull
    public UnitConversionRoundingEnum getRounding() {
        return rounding;
    }

    public void setRounding(UnitConversionRoundingEnum rounding) {
        this.rounding = rounding;
    }

    /**
     * Create an instance of UnitConversion given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UnitConversion
     * @throws JsonProcessingException if the JSON string is invalid with respect to UnitConversion
     */
    public static UnitConversion fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UnitConversion.class);
    }

    /**
     * Convert an instance of UnitConversion to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
