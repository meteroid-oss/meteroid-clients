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
public class CustomTaxRate {
    @JsonProperty private String name;
    @JsonProperty private String rate;

    @JsonProperty("tax_code")
    private String taxCode;

    public CustomTaxRate() {}

    public CustomTaxRate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomTaxRate rate(String rate) {
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

    public CustomTaxRate taxCode(String taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    /**
     * Get taxCode
     *
     * @return taxCode
     */
    @javax.annotation.Nonnull
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    /**
     * Create an instance of CustomTaxRate given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CustomTaxRate
     * @throws JsonProcessingException if the JSON string is invalid with respect to CustomTaxRate
     */
    public static CustomTaxRate fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CustomTaxRate.class);
    }

    /**
     * Convert an instance of CustomTaxRate to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
