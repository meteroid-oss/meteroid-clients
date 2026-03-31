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
public class BillingConfig {
    @JsonProperty("billing_cycles")
    private Integer billingCycles;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("period_start_day")
    private Integer periodStartDay;

    public BillingConfig() {}

    public BillingConfig billingCycles(Integer billingCycles) {
        this.billingCycles = billingCycles;
        return this;
    }

    /**
     * Get billingCycles
     *
     * @return billingCycles
     */
    @javax.annotation.Nullable
    public Integer getBillingCycles() {
        return billingCycles;
    }

    public void setBillingCycles(Integer billingCycles) {
        this.billingCycles = billingCycles;
    }

    public BillingConfig netTerms(Integer netTerms) {
        this.netTerms = netTerms;
        return this;
    }

    /**
     * Get netTerms
     *
     * @return netTerms
     */
    @javax.annotation.Nullable
    public Integer getNetTerms() {
        return netTerms;
    }

    public void setNetTerms(Integer netTerms) {
        this.netTerms = netTerms;
    }

    public BillingConfig periodStartDay(Integer periodStartDay) {
        this.periodStartDay = periodStartDay;
        return this;
    }

    /**
     * Get periodStartDay
     *
     * @return periodStartDay
     */
    @javax.annotation.Nullable
    public Integer getPeriodStartDay() {
        return periodStartDay;
    }

    public void setPeriodStartDay(Integer periodStartDay) {
        this.periodStartDay = periodStartDay;
    }

    /**
     * Create an instance of BillingConfig given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BillingConfig
     * @throws JsonProcessingException if the JSON string is invalid with respect to BillingConfig
     */
    public static BillingConfig fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BillingConfig.class);
    }

    /**
     * Convert an instance of BillingConfig to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
