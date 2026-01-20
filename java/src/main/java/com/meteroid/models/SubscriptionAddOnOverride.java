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
public class SubscriptionAddOnOverride {
    @JsonProperty private SubscriptionFee fee;
    @JsonProperty private String name;
    @JsonProperty private SubscriptionFeeBillingPeriodEnum period;

    public SubscriptionAddOnOverride() {}

    public SubscriptionAddOnOverride fee(SubscriptionFee fee) {
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

    public SubscriptionAddOnOverride name(String name) {
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

    public SubscriptionAddOnOverride period(SubscriptionFeeBillingPeriodEnum period) {
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
     * Create an instance of SubscriptionAddOnOverride given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionAddOnOverride
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionAddOnOverride
     */
    public static SubscriptionAddOnOverride fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionAddOnOverride.class);
    }

    /**
     * Convert an instance of SubscriptionAddOnOverride to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
