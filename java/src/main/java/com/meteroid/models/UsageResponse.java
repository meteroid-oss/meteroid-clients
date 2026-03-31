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
public class UsageResponse {
    @JsonProperty("period_end")
    private String periodEnd;

    @JsonProperty("period_start")
    private String periodStart;

    @JsonProperty private List<MetricUsage> usage;

    public UsageResponse() {}

    public UsageResponse periodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
        return this;
    }

    /**
     * Get periodEnd
     *
     * @return periodEnd
     */
    @javax.annotation.Nonnull
    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public UsageResponse periodStart(String periodStart) {
        this.periodStart = periodStart;
        return this;
    }

    /**
     * Get periodStart
     *
     * @return periodStart
     */
    @javax.annotation.Nonnull
    public String getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public UsageResponse usage(List<MetricUsage> usage) {
        this.usage = usage;
        return this;
    }

    public UsageResponse addUsageItem(MetricUsage usageItem) {
        if (this.usage == null) {
            this.usage = new ArrayList<>();
        }
        this.usage.add(usageItem);

        return this;
    }

    /**
     * Get usage
     *
     * @return usage
     */
    @javax.annotation.Nonnull
    public List<MetricUsage> getUsage() {
        return usage;
    }

    public void setUsage(List<MetricUsage> usage) {
        this.usage = usage;
    }

    /**
     * Create an instance of UsageResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UsageResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to UsageResponse
     */
    public static UsageResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UsageResponse.class);
    }

    /**
     * Convert an instance of UsageResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
