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
public class SlotPlanFee {
    @JsonProperty("minimum_count")
    private Integer minimumCount;

    @JsonProperty private Integer quota;
    @JsonProperty private List<TermRate> rates;

    @JsonProperty("slot_unit_name")
    private String slotUnitName;

    public SlotPlanFee() {}

    public SlotPlanFee minimumCount(Integer minimumCount) {
        this.minimumCount = minimumCount;
        return this;
    }

    /**
     * Get minimumCount
     *
     * @return minimumCount
     */
    @javax.annotation.Nullable
    public Integer getMinimumCount() {
        return minimumCount;
    }

    public void setMinimumCount(Integer minimumCount) {
        this.minimumCount = minimumCount;
    }

    public SlotPlanFee quota(Integer quota) {
        this.quota = quota;
        return this;
    }

    /**
     * Get quota
     *
     * @return quota
     */
    @javax.annotation.Nullable
    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public SlotPlanFee rates(List<TermRate> rates) {
        this.rates = rates;
        return this;
    }

    public SlotPlanFee addRatesItem(TermRate ratesItem) {
        if (this.rates == null) {
            this.rates = new ArrayList<>();
        }
        this.rates.add(ratesItem);

        return this;
    }

    /**
     * Get rates
     *
     * @return rates
     */
    @javax.annotation.Nonnull
    public List<TermRate> getRates() {
        return rates;
    }

    public void setRates(List<TermRate> rates) {
        this.rates = rates;
    }

    public SlotPlanFee slotUnitName(String slotUnitName) {
        this.slotUnitName = slotUnitName;
        return this;
    }

    /**
     * Get slotUnitName
     *
     * @return slotUnitName
     */
    @javax.annotation.Nonnull
    public String getSlotUnitName() {
        return slotUnitName;
    }

    public void setSlotUnitName(String slotUnitName) {
        this.slotUnitName = slotUnitName;
    }

    /**
     * Create an instance of SlotPlanFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SlotPlanFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to SlotPlanFee
     */
    public static SlotPlanFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SlotPlanFee.class);
    }

    /**
     * Convert an instance of SlotPlanFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
