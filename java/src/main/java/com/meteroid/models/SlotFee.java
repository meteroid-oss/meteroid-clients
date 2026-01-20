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
public class SlotFee {
    @JsonProperty("initial_slots")
    private Integer initialSlots;

    @JsonProperty("max_slots")
    private Integer maxSlots;

    @JsonProperty("min_slots")
    private Integer minSlots;

    @JsonProperty private String unit;

    @JsonProperty("unit_rate")
    private String unitRate;

    public SlotFee() {}

    public SlotFee initialSlots(Integer initialSlots) {
        this.initialSlots = initialSlots;
        return this;
    }

    /**
     * Get initialSlots
     *
     * @return initialSlots
     */
    @javax.annotation.Nonnull
    public Integer getInitialSlots() {
        return initialSlots;
    }

    public void setInitialSlots(Integer initialSlots) {
        this.initialSlots = initialSlots;
    }

    public SlotFee maxSlots(Integer maxSlots) {
        this.maxSlots = maxSlots;
        return this;
    }

    /**
     * Get maxSlots
     *
     * @return maxSlots
     */
    @javax.annotation.Nullable
    public Integer getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(Integer maxSlots) {
        this.maxSlots = maxSlots;
    }

    public SlotFee minSlots(Integer minSlots) {
        this.minSlots = minSlots;
        return this;
    }

    /**
     * Get minSlots
     *
     * @return minSlots
     */
    @javax.annotation.Nullable
    public Integer getMinSlots() {
        return minSlots;
    }

    public void setMinSlots(Integer minSlots) {
        this.minSlots = minSlots;
    }

    public SlotFee unit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get unit
     *
     * @return unit
     */
    @javax.annotation.Nonnull
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public SlotFee unitRate(String unitRate) {
        this.unitRate = unitRate;
        return this;
    }

    /**
     * Get unitRate
     *
     * @return unitRate
     */
    @javax.annotation.Nonnull
    public String getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(String unitRate) {
        this.unitRate = unitRate;
    }

    /**
     * Create an instance of SlotFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SlotFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to SlotFee
     */
    public static SlotFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SlotFee.class);
    }

    /**
     * Convert an instance of SlotFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
