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
public class CapacityFee {
    @JsonProperty private Long included;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty("overage_rate")
    private String overageRate;

    @JsonProperty private String rate;

    public CapacityFee() {}

    public CapacityFee included(Long included) {
        this.included = included;
        return this;
    }

    /**
     * Get included
     *
     * @return included
     */
    @javax.annotation.Nonnull
    public Long getIncluded() {
        return included;
    }

    public void setIncluded(Long included) {
        this.included = included;
    }

    public CapacityFee metricId(String metricId) {
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

    public CapacityFee overageRate(String overageRate) {
        this.overageRate = overageRate;
        return this;
    }

    /**
     * Get overageRate
     *
     * @return overageRate
     */
    @javax.annotation.Nonnull
    public String getOverageRate() {
        return overageRate;
    }

    public void setOverageRate(String overageRate) {
        this.overageRate = overageRate;
    }

    public CapacityFee rate(String rate) {
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
     * Create an instance of CapacityFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CapacityFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to CapacityFee
     */
    public static CapacityFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CapacityFee.class);
    }

    /**
     * Convert an instance of CapacityFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
