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
public class SlotPricing {
    @JsonProperty("max_slots")
    private Integer maxSlots;

    @JsonProperty("min_slots")
    private Integer minSlots;

    @JsonProperty("unit_rate")
    private String unitRate;

    public SlotPricing() {}

    public SlotPricing maxSlots(Integer maxSlots) {
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

    public SlotPricing minSlots(Integer minSlots) {
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

    public SlotPricing unitRate(String unitRate) {
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
     * Create an instance of SlotPricing given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SlotPricing
     * @throws JsonProcessingException if the JSON string is invalid with respect to SlotPricing
     */
    public static SlotPricing fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SlotPricing.class);
    }

    /**
     * Convert an instance of SlotPricing to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
