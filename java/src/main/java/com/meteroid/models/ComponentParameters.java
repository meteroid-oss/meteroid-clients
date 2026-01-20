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
public class ComponentParameters {
    @JsonProperty("billing_period")
    private BillingPeriodEnum billingPeriod;

    @JsonProperty("committed_capacity")
    private Long committedCapacity;

    @JsonProperty("initial_slot_count")
    private Integer initialSlotCount;

    public ComponentParameters() {}

    public ComponentParameters billingPeriod(BillingPeriodEnum billingPeriod) {
        this.billingPeriod = billingPeriod;
        return this;
    }

    /**
     * Get billingPeriod
     *
     * @return billingPeriod
     */
    @javax.annotation.Nullable
    public BillingPeriodEnum getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(BillingPeriodEnum billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public ComponentParameters committedCapacity(Long committedCapacity) {
        this.committedCapacity = committedCapacity;
        return this;
    }

    /**
     * Get committedCapacity
     *
     * @return committedCapacity
     */
    @javax.annotation.Nullable
    public Long getCommittedCapacity() {
        return committedCapacity;
    }

    public void setCommittedCapacity(Long committedCapacity) {
        this.committedCapacity = committedCapacity;
    }

    public ComponentParameters initialSlotCount(Integer initialSlotCount) {
        this.initialSlotCount = initialSlotCount;
        return this;
    }

    /**
     * Get initialSlotCount
     *
     * @return initialSlotCount
     */
    @javax.annotation.Nullable
    public Integer getInitialSlotCount() {
        return initialSlotCount;
    }

    public void setInitialSlotCount(Integer initialSlotCount) {
        this.initialSlotCount = initialSlotCount;
    }

    /**
     * Create an instance of ComponentParameters given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ComponentParameters
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ComponentParameters
     */
    public static ComponentParameters fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ComponentParameters.class);
    }

    /**
     * Convert an instance of ComponentParameters to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
