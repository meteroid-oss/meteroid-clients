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
public class PerUnitPricing {
    @JsonProperty private String rate;

    public PerUnitPricing() {}

    public PerUnitPricing rate(String rate) {
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
     * Create an instance of PerUnitPricing given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PerUnitPricing
     * @throws JsonProcessingException if the JSON string is invalid with respect to PerUnitPricing
     */
    public static PerUnitPricing fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PerUnitPricing.class);
    }

    /**
     * Convert an instance of PerUnitPricing to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
