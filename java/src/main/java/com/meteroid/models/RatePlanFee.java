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
public class RatePlanFee {
    @JsonProperty private List<TermRate> rates;

    public RatePlanFee() {}

    public RatePlanFee rates(List<TermRate> rates) {
        this.rates = rates;
        return this;
    }

    public RatePlanFee addRatesItem(TermRate ratesItem) {
        if (this.rates == null) {
            this.rates = new ArrayList<>();
        }
        this.rates.add(ratesItem);

        return this;
    }

    /**
     * Get rates
     *
     * @return rates
     */
    @javax.annotation.Nonnull
    public List<TermRate> getRates() {
        return rates;
    }

    public void setRates(List<TermRate> rates) {
        this.rates = rates;
    }

    /**
     * Create an instance of RatePlanFee given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RatePlanFee
     * @throws JsonProcessingException if the JSON string is invalid with respect to RatePlanFee
     */
    public static RatePlanFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, RatePlanFee.class);
    }

    /**
     * Convert an instance of RatePlanFee to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
