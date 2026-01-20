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
public class ExtraRecurringPlanFee {
    @JsonProperty("billing_type")
    private BillingType billingType;

    @JsonProperty private BillingPeriodEnum cadence;
    @JsonProperty private Integer quantity;

    @JsonProperty("unit_price")
    private String unitPrice;

    public ExtraRecurringPlanFee() {}

    public ExtraRecurringPlanFee billingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    /**
     * Get billingType
     *
     * @return billingType
     */
    @javax.annotation.Nonnull
    public BillingType getBillingType() {
        return billingType;
    }

    public void setBillingType(BillingType billingType) {
        this.billingType = billingType;
    }

    public ExtraRecurringPlanFee cadence(BillingPeriodEnum cadence) {
        this.cadence = cadence;
        return this;
    }

    /**
     * Get cadence
     *
     * @return cadence
     */
    @javax.annotation.Nonnull
    public BillingPeriodEnum getCadence() {
        return cadence;
    }

    public void setCadence(BillingPeriodEnum cadence) {
        this.cadence = cadence;
    }

    public ExtraRecurringPlanFee quantity(Integer quantity) {
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

    public ExtraRecurringPlanFee unitPrice(String unitPrice) {
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
     * Create an instance of ExtraRecurringPlanFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ExtraRecurringPlanFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ExtraRecurringPlanFee
     */
    public static ExtraRecurringPlanFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ExtraRecurringPlanFee.class);
    }

    /**
     * Convert an instance of ExtraRecurringPlanFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
