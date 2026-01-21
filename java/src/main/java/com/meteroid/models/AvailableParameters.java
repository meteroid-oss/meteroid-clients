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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class AvailableParameters {
    @JsonProperty("billing_periods")
    private Map<String, List<BillingPeriodEnum>> billingPeriods;

    @JsonProperty("capacity_thresholds")
    private Map<String, List<Long>> capacityThresholds;

    @JsonProperty("slot_components")
    private List<String> slotComponents;

    public AvailableParameters() {}

    public AvailableParameters billingPeriods(Map<String, List<BillingPeriodEnum>> billingPeriods) {
        this.billingPeriods = billingPeriods;
        return this;
    }

    public AvailableParameters putBillingPeriodsItem(
            String key, List<BillingPeriodEnum> billingPeriodsItem) {
        if (this.billingPeriods == null) {
            this.billingPeriods = new HashMap<>();
        }
        this.billingPeriods.put(key, billingPeriodsItem);

        return this;
    }

    /**
     * Map of component_id -> available billing periods (e.g., "MONTHLY", "ANNUAL")
     *
     * @return billingPeriods
     */
    @javax.annotation.Nullable
    public Map<String, List<BillingPeriodEnum>> getBillingPeriods() {
        return billingPeriods;
    }

    public void setBillingPeriods(Map<String, List<BillingPeriodEnum>> billingPeriods) {
        this.billingPeriods = billingPeriods;
    }

    public AvailableParameters capacityThresholds(Map<String, List<Long>> capacityThresholds) {
        this.capacityThresholds = capacityThresholds;
        return this;
    }

    public AvailableParameters putCapacityThresholdsItem(
            String key, List<Long> capacityThresholdsItem) {
        if (this.capacityThresholds == null) {
            this.capacityThresholds = new HashMap<>();
        }
        this.capacityThresholds.put(key, capacityThresholdsItem);

        return this;
    }

    /**
     * Map of component_id -> available capacity values
     *
     * @return capacityThresholds
     */
    @javax.annotation.Nullable
    public Map<String, List<Long>> getCapacityThresholds() {
        return capacityThresholds;
    }

    public void setCapacityThresholds(Map<String, List<Long>> capacityThresholds) {
        this.capacityThresholds = capacityThresholds;
    }

    public AvailableParameters slotComponents(List<String> slotComponents) {
        this.slotComponents = slotComponents;
        return this;
    }

    public AvailableParameters addSlotComponentsItem(String slotComponentsItem) {
        if (this.slotComponents == null) {
            this.slotComponents = new ArrayList<>();
        }
        this.slotComponents.add(slotComponentsItem);

        return this;
    }

    /**
     * List of component_ids that support slot parametrization (initial slot count)
     *
     * @return slotComponents
     */
    @javax.annotation.Nullable
    public List<String> getSlotComponents() {
        return slotComponents;
    }

    public void setSlotComponents(List<String> slotComponents) {
        this.slotComponents = slotComponents;
    }

    /**
     * Create an instance of AvailableParameters given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AvailableParameters
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     AvailableParameters
     */
    public static AvailableParameters fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, AvailableParameters.class);
    }

    /**
     * Convert an instance of AvailableParameters to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
