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

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CapacityPlanFee {
    @JsonProperty private BillingPeriodEnum cadence;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty private List<CapacityThreshold> thresholds;

    public CapacityPlanFee() {}

    public CapacityPlanFee cadence(BillingPeriodEnum cadence) {
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

    public CapacityPlanFee metricId(String metricId) {
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

    public CapacityPlanFee thresholds(List<CapacityThreshold> thresholds) {
        this.thresholds = thresholds;
        return this;
    }

    public CapacityPlanFee addThresholdsItem(CapacityThreshold thresholdsItem) {
        if (this.thresholds == null) {
            this.thresholds = new ArrayList<>();
        }
        this.thresholds.add(thresholdsItem);

        return this;
    }

    /**
     * Get thresholds
     *
     * @return thresholds
     */
    @javax.annotation.Nonnull
    public List<CapacityThreshold> getThresholds() {
        return thresholds;
    }

    public void setThresholds(List<CapacityThreshold> thresholds) {
        this.thresholds = thresholds;
    }

    /**
     * Create an instance of CapacityPlanFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CapacityPlanFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to CapacityPlanFee
     */
    public static CapacityPlanFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CapacityPlanFee.class);
    }

    /**
     * Convert an instance of CapacityPlanFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
