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
public class TrialConfig {
    @JsonProperty("duration_days")
    private Integer durationDays;

    @JsonProperty("is_free")
    private Boolean isFree;

    @JsonProperty("trialing_plan_id")
    private String trialingPlanId;

    public TrialConfig() {}

    public TrialConfig durationDays(Integer durationDays) {
        this.durationDays = durationDays;
        return this;
    }

    /**
     * Get durationDays
     *
     * @return durationDays
     */
    @javax.annotation.Nonnull
    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public TrialConfig isFree(Boolean isFree) {
        this.isFree = isFree;
        return this;
    }

    /**
     * Get isFree
     *
     * @return isFree
     */
    @javax.annotation.Nonnull
    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public TrialConfig trialingPlanId(String trialingPlanId) {
        this.trialingPlanId = trialingPlanId;
        return this;
    }

    /**
     * Get trialingPlanId
     *
     * @return trialingPlanId
     */
    @javax.annotation.Nullable
    public String getTrialingPlanId() {
        return trialingPlanId;
    }

    public void setTrialingPlanId(String trialingPlanId) {
        this.trialingPlanId = trialingPlanId;
    }

    /**
     * Create an instance of TrialConfig given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TrialConfig
     * @throws JsonProcessingException if the JSON string is invalid with respect to TrialConfig
     */
    public static TrialConfig fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, TrialConfig.class);
    }

    /**
     * Convert an instance of TrialConfig to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
