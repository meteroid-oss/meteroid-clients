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

import java.math.BigDecimal;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MeteredEntitlementSpec {
    @JsonProperty private Boolean enabled;
    @JsonProperty private BigDecimal limit;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty("reset_period")
    private ResetPeriod resetPeriod;

    public MeteredEntitlementSpec() {}

    public MeteredEntitlementSpec enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     */
    @javax.annotation.Nonnull
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public MeteredEntitlementSpec limit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Get limit
     *
     * @return limit
     */
    @javax.annotation.Nullable
    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public MeteredEntitlementSpec metricId(String metricId) {
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

    public MeteredEntitlementSpec resetPeriod(ResetPeriod resetPeriod) {
        this.resetPeriod = resetPeriod;
        return this;
    }

    /**
     * Get resetPeriod
     *
     * @return resetPeriod
     */
    @javax.annotation.Nonnull
    public ResetPeriod getResetPeriod() {
        return resetPeriod;
    }

    public void setResetPeriod(ResetPeriod resetPeriod) {
        this.resetPeriod = resetPeriod;
    }

    /**
     * Create an instance of MeteredEntitlementSpec given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MeteredEntitlementSpec
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MeteredEntitlementSpec
     */
    public static MeteredEntitlementSpec fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MeteredEntitlementSpec.class);
    }

    /**
     * Convert an instance of MeteredEntitlementSpec to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
