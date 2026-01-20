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
public class CapacityThreshold {
    @JsonProperty("included_amount")
    private Long includedAmount;

    @JsonProperty("per_unit_overage")
    private String perUnitOverage;

    @JsonProperty private String price;

    public CapacityThreshold() {}

    public CapacityThreshold includedAmount(Long includedAmount) {
        this.includedAmount = includedAmount;
        return this;
    }

    /**
     * Get includedAmount
     *
     * @return includedAmount
     */
    @javax.annotation.Nonnull
    public Long getIncludedAmount() {
        return includedAmount;
    }

    public void setIncludedAmount(Long includedAmount) {
        this.includedAmount = includedAmount;
    }

    public CapacityThreshold perUnitOverage(String perUnitOverage) {
        this.perUnitOverage = perUnitOverage;
        return this;
    }

    /**
     * Get perUnitOverage
     *
     * @return perUnitOverage
     */
    @javax.annotation.Nonnull
    public String getPerUnitOverage() {
        return perUnitOverage;
    }

    public void setPerUnitOverage(String perUnitOverage) {
        this.perUnitOverage = perUnitOverage;
    }

    public CapacityThreshold price(String price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     */
    @javax.annotation.Nonnull
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Create an instance of CapacityThreshold given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CapacityThreshold
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CapacityThreshold
     */
    public static CapacityThreshold fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CapacityThreshold.class);
    }

    /**
     * Convert an instance of CapacityThreshold to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
