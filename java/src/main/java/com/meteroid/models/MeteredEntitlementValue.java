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
public class MeteredEntitlementValue {
    @JsonProperty private Boolean enabled;
    @JsonProperty private BigDecimal limit;

    @JsonProperty("reset_period")
    private ResetPeriod resetPeriod;

    public MeteredEntitlementValue() {}

    public MeteredEntitlementValue enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Per-entitlement kill switch. `false` means disabled.
     *
     * @return enabled
     */
    @javax.annotation.Nullable
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public MeteredEntitlementValue limit(BigDecimal limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Cap on usage. Null means unlimited.
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

    public MeteredEntitlementValue resetPeriod(ResetPeriod resetPeriod) {
        this.resetPeriod = resetPeriod;
        return this;
    }

    /**
     * Get resetPeriod
     *
     * @return resetPeriod
     */
    @javax.annotation.Nullable
    public ResetPeriod getResetPeriod() {
        return resetPeriod;
    }

    public void setResetPeriod(ResetPeriod resetPeriod) {
        this.resetPeriod = resetPeriod;
    }

    /**
     * Create an instance of MeteredEntitlementValue given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MeteredEntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MeteredEntitlementValue
     */
    public static MeteredEntitlementValue fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MeteredEntitlementValue.class);
    }

    /**
     * Convert an instance of MeteredEntitlementValue to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
