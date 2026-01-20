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
public class OneTimeFee {
    @JsonProperty private Integer quantity;
    @JsonProperty private String rate;

    public OneTimeFee() {}

    public OneTimeFee quantity(Integer quantity) {
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

    public OneTimeFee rate(String rate) {
        this.rate = rate;
        return this;
    }

    /**
     * Get rate
     *
     * @return rate
     */
    @javax.annotation.Nonnull
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Create an instance of OneTimeFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OneTimeFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to OneTimeFee
     */
    public static OneTimeFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OneTimeFee.class);
    }

    /**
     * Convert an instance of OneTimeFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
