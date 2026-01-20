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
public class TermRate {
    @JsonProperty private String price;
    @JsonProperty private BillingPeriodEnum term;

    public TermRate() {}

    public TermRate price(String price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
     * @return price
     */
    @javax.annotation.Nonnull
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public TermRate term(BillingPeriodEnum term) {
        this.term = term;
        return this;
    }

    /**
     * Get term
     *
     * @return term
     */
    @javax.annotation.Nonnull
    public BillingPeriodEnum getTerm() {
        return term;
    }

    public void setTerm(BillingPeriodEnum term) {
        this.term = term;
    }

    /**
     * Create an instance of TermRate given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TermRate
     * @throws JsonProcessingException if the JSON string is invalid with respect to TermRate
     */
    public static TermRate fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, TermRate.class);
    }

    /**
     * Convert an instance of TermRate to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
