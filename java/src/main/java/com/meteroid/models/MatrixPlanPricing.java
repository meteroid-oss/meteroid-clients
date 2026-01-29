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
public class MatrixPlanPricing {
    @JsonProperty private List<MatrixRow> rates;

    public MatrixPlanPricing() {}

    public MatrixPlanPricing rates(List<MatrixRow> rates) {
        this.rates = rates;
        return this;
    }

    public MatrixPlanPricing addRatesItem(MatrixRow ratesItem) {
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
    public List<MatrixRow> getRates() {
        return rates;
    }

    public void setRates(List<MatrixRow> rates) {
        this.rates = rates;
    }

    /**
     * Create an instance of MatrixPlanPricing given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MatrixPlanPricing
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MatrixPlanPricing
     */
    public static MatrixPlanPricing fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MatrixPlanPricing.class);
    }

    /**
     * Convert an instance of MatrixPlanPricing to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
