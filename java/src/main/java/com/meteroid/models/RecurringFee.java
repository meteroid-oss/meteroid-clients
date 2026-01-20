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
public class RecurringFee {
    @JsonProperty("billing_type")
    private BillingTypeEnum billingType;

    @JsonProperty private Integer quantity;
    @JsonProperty private String rate;

    public RecurringFee() {}

    public RecurringFee billingType(BillingTypeEnum billingType) {
        this.billingType = billingType;
        return this;
    }

    /**
     * Get billingType
     *
     * @return billingType
     */
    @javax.annotation.Nonnull
    public BillingTypeEnum getBillingType() {
        return billingType;
    }

    public void setBillingType(BillingTypeEnum billingType) {
        this.billingType = billingType;
    }

    public RecurringFee quantity(Integer quantity) {
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

    public RecurringFee rate(String rate) {
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
     * Create an instance of RecurringFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RecurringFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to RecurringFee
     */
    public static RecurringFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, RecurringFee.class);
    }

    /**
     * Convert an instance of RecurringFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
