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
public class UsageFee {
    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty private UsagePricingModel model;

    public UsageFee() {}

    public UsageFee metricId(String metricId) {
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

    public UsageFee model(UsagePricingModel model) {
        this.model = model;
        return this;
    }

    /**
     * Get model
     *
     * @return model
     */
    @javax.annotation.Nonnull
    public UsagePricingModel getModel() {
        return model;
    }

    public void setModel(UsagePricingModel model) {
        this.model = model;
    }

    /**
     * Create an instance of UsageFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UsageFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to UsageFee
     */
    public static UsageFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UsageFee.class);
    }

    /**
     * Convert an instance of UsageFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
