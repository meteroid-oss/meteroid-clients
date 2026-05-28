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
public class TierRow {
    @JsonProperty("first_unit")
    private Long firstUnit;

    @JsonProperty("flat_cap")
    private BigDecimal flatCap;

    @JsonProperty("flat_fee")
    private BigDecimal flatFee;

    @JsonProperty private BigDecimal rate;

    public TierRow() {}

    public TierRow firstUnit(Long firstUnit) {
        this.firstUnit = firstUnit;
        return this;
    }

    /**
     * Get firstUnit
     *
     * @return firstUnit
     */
    @javax.annotation.Nonnull
    public Long getFirstUnit() {
        return firstUnit;
    }

    public void setFirstUnit(Long firstUnit) {
        this.firstUnit = firstUnit;
    }

    public TierRow flatCap(BigDecimal flatCap) {
        this.flatCap = flatCap;
        return this;
    }

    /**
     * Get flatCap
     *
     * @return flatCap
     */
    @javax.annotation.Nonnull
    public BigDecimal getFlatCap() {
        return flatCap;
    }

    public void setFlatCap(BigDecimal flatCap) {
        this.flatCap = flatCap;
    }

    public TierRow flatFee(BigDecimal flatFee) {
        this.flatFee = flatFee;
        return this;
    }

    /**
     * Get flatFee
     *
     * @return flatFee
     */
    @javax.annotation.Nonnull
    public BigDecimal getFlatFee() {
        return flatFee;
    }

    public void setFlatFee(BigDecimal flatFee) {
        this.flatFee = flatFee;
    }

    public TierRow rate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    /**
     * Get rate
     *
     * @return rate
     */
    @javax.annotation.Nonnull
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * Create an instance of TierRow given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TierRow
     * @throws JsonProcessingException if the JSON string is invalid with respect to TierRow
     */
    public static TierRow fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, TierRow.class);
    }

    /**
     * Convert an instance of TierRow to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
