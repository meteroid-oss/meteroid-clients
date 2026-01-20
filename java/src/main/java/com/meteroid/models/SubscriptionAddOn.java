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
public class SubscriptionAddOn {
    @JsonProperty("add_on_id")
    private String addOnId;

    @JsonProperty private SubscriptionFee fee;
    @JsonProperty private String name;
    @JsonProperty private SubscriptionFeeBillingPeriodEnum period;

    public SubscriptionAddOn() {}

    public SubscriptionAddOn addOnId(String addOnId) {
        this.addOnId = addOnId;
        return this;
    }

    /**
     * Get addOnId
     *
     * @return addOnId
     */
    @javax.annotation.Nullable
    public String getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(String addOnId) {
        this.addOnId = addOnId;
    }

    public SubscriptionAddOn fee(SubscriptionFee fee) {
        this.fee = fee;
        return this;
    }

    /**
     * Get fee
     *
     * @return fee
     */
    @javax.annotation.Nonnull
    public SubscriptionFee getFee() {
        return fee;
    }

    public void setFee(SubscriptionFee fee) {
        this.fee = fee;
    }

    public SubscriptionAddOn name(String name) {
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

    public SubscriptionAddOn period(SubscriptionFeeBillingPeriodEnum period) {
        this.period = period;
        return this;
    }

    /**
     * Get period
     *
     * @return period
     */
    @javax.annotation.Nonnull
    public SubscriptionFeeBillingPeriodEnum getPeriod() {
        return period;
    }

    public void setPeriod(SubscriptionFeeBillingPeriodEnum period) {
        this.period = period;
    }

    /**
     * Create an instance of SubscriptionAddOn given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionAddOn
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionAddOn
     */
    public static SubscriptionAddOn fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionAddOn.class);
    }

    /**
     * Convert an instance of SubscriptionAddOn to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
