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
public class PriceInput {
    @JsonProperty private BillingPeriodEnum cadence;
    @JsonProperty private String currency;
    @JsonProperty private Pricing pricing;

    public PriceInput() {}

    public PriceInput cadence(BillingPeriodEnum cadence) {
        this.cadence = cadence;
        return this;
    }

    /**
     * Get cadence
     *
     * @return cadence
     */
    @javax.annotation.Nonnull
    public BillingPeriodEnum getCadence() {
        return cadence;
    }

    public void setCadence(BillingPeriodEnum cadence) {
        this.cadence = cadence;
    }

    public PriceInput currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @javax.annotation.Nonnull
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PriceInput pricing(Pricing pricing) {
        this.pricing = pricing;
        return this;
    }

    /**
     * Get pricing
     *
     * @return pricing
     */
    @javax.annotation.Nonnull
    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    /**
     * Create an instance of PriceInput given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PriceInput
     * @throws JsonProcessingException if the JSON string is invalid with respect to PriceInput
     */
    public static PriceInput fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PriceInput.class);
    }

    /**
     * Convert an instance of PriceInput to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
