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
public class OneTimePlanFee {
    @JsonProperty private Integer quantity;

    @JsonProperty("unit_price")
    private String unitPrice;

    public OneTimePlanFee() {}

    public OneTimePlanFee quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     *
     * @return quantity
     */
    @javax.annotation.Nonnull
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OneTimePlanFee unitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Get unitPrice
     *
     * @return unitPrice
     */
    @javax.annotation.Nonnull
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Create an instance of OneTimePlanFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OneTimePlanFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to OneTimePlanFee
     */
    public static OneTimePlanFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OneTimePlanFee.class);
    }

    /**
     * Convert an instance of OneTimePlanFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
