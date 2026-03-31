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
public class MetricUsage {
    @JsonProperty("grouped_usage")
    private List<GroupedUsage> groupedUsage;

    @JsonProperty("metric_code")
    private String metricCode;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty("metric_name")
    private String metricName;

    @JsonProperty("total_value")
    private String totalValue;

    public MetricUsage() {}

    public MetricUsage groupedUsage(List<GroupedUsage> groupedUsage) {
        this.groupedUsage = groupedUsage;
        return this;
    }

    public MetricUsage addGroupedUsageItem(GroupedUsage groupedUsageItem) {
        if (this.groupedUsage == null) {
            this.groupedUsage = new ArrayList<>();
        }
        this.groupedUsage.add(groupedUsageItem);

        return this;
    }

    /**
     * Get groupedUsage
     *
     * @return groupedUsage
     */
    @javax.annotation.Nonnull
    public List<GroupedUsage> getGroupedUsage() {
        return groupedUsage;
    }

    public void setGroupedUsage(List<GroupedUsage> groupedUsage) {
        this.groupedUsage = groupedUsage;
    }

    public MetricUsage metricCode(String metricCode) {
        this.metricCode = metricCode;
        return this;
    }

    /**
     * Get metricCode
     *
     * @return metricCode
     */
    @javax.annotation.Nonnull
    public String getMetricCode() {
        return metricCode;
    }

    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }

    public MetricUsage metricId(String metricId) {
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

    public MetricUsage metricName(String metricName) {
        this.metricName = metricName;
        return this;
    }

    /**
     * Get metricName
     *
     * @return metricName
     */
    @javax.annotation.Nonnull
    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public MetricUsage totalValue(String totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    /**
     * Get totalValue
     *
     * @return totalValue
     */
    @javax.annotation.Nonnull
    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * Create an instance of MetricUsage given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MetricUsage
     * @throws JsonProcessingException if the JSON string is invalid with respect to MetricUsage
     */
    public static MetricUsage fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricUsage.class);
    }

    /**
     * Convert an instance of MetricUsage to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
