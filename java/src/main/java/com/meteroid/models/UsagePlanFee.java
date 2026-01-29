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
public class UsagePlanFee {
    @JsonProperty private BillingPeriodEnum cadence;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty private PlanUsagePricingModel pricing;

    public UsagePlanFee() {}

    public UsagePlanFee cadence(BillingPeriodEnum cadence) {
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

    public UsagePlanFee metricId(String metricId) {
        this.metricId = metricId;
        return this;
    }

    /**
     * Get metricId
     *
     * @return metricId
     */
    @javax.annotation.Nonnull
    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }

    public UsagePlanFee pricing(PlanUsagePricingModel pricing) {
        this.pricing = pricing;
        return this;
    }

    /**
     * Get pricing
     *
     * @return pricing
     */
    @javax.annotation.Nonnull
    public PlanUsagePricingModel getPricing() {
        return pricing;
    }

    public void setPricing(PlanUsagePricingModel pricing) {
        this.pricing = pricing;
    }

    /**
     * Create an instance of UsagePlanFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UsagePlanFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to UsagePlanFee
     */
    public static UsagePlanFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UsagePlanFee.class);
    }

    /**
     * Convert an instance of UsagePlanFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
