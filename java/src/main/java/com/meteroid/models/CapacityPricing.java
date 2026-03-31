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
public class CapacityPricing {
    @JsonProperty private Long included;

    @JsonProperty("overage_rate")
    private String overageRate;

    @JsonProperty private String rate;

    public CapacityPricing() {}

    public CapacityPricing included(Long included) {
        this.included = included;
        return this;
    }

    /**
     * Get included
     *
     * @return included
     */
    @javax.annotation.Nonnull
    public Long getIncluded() {
        return included;
    }

    public void setIncluded(Long included) {
        this.included = included;
    }

    public CapacityPricing overageRate(String overageRate) {
        this.overageRate = overageRate;
        return this;
    }

    /**
     * Get overageRate
     *
     * @return overageRate
     */
    @javax.annotation.Nonnull
    public String getOverageRate() {
        return overageRate;
    }

    public void setOverageRate(String overageRate) {
        this.overageRate = overageRate;
    }

    public CapacityPricing rate(String rate) {
        this.rate = rate;
        return this;
    }

    /**
     * Get rate
     *
     * @return rate
     */
    @javax.annotation.Nonnull
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Create an instance of CapacityPricing given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CapacityPricing
     * @throws JsonProcessingException if the JSON string is invalid with respect to CapacityPricing
     */
    public static CapacityPricing fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CapacityPricing.class);
    }

    /**
     * Convert an instance of CapacityPricing to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
