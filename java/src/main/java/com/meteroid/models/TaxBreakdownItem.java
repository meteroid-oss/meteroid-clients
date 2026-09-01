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
public class TaxBreakdownItem {
    @JsonProperty("exemption_reason")
    private String exemptionReason;

    @JsonProperty("exemption_type")
    private TaxExemptionType exemptionType;

    @JsonProperty private String name;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("tax_rate")
    private BigDecimal taxRate;

    @JsonProperty("tax_reference")
    private String taxReference;

    @JsonProperty("taxable_amount")
    private Long taxableAmount;

    public TaxBreakdownItem() {}

    public TaxBreakdownItem exemptionReason(String exemptionReason) {
        this.exemptionReason = exemptionReason;
        return this;
    }

    /**
     * Free-text legal exemption mention (EU exempt&#x2f;reverse-charge invoices).
     *
     * @return exemptionReason
     */
    @javax.annotation.Nullable
    public String getExemptionReason() {
        return exemptionReason;
    }

    public void setExemptionReason(String exemptionReason) {
        this.exemptionReason = exemptionReason;
    }

    public TaxBreakdownItem exemptionType(TaxExemptionType exemptionType) {
        this.exemptionType = exemptionType;
        return this;
    }

    /**
     * Get exemptionType
     *
     * @return exemptionType
     */
    @javax.annotation.Nullable
    public TaxExemptionType getExemptionType() {
        return exemptionType;
    }

    public void setExemptionType(TaxExemptionType exemptionType) {
        this.exemptionType = exemptionType;
    }

    public TaxBreakdownItem name(String name) {
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

    public TaxBreakdownItem taxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    /**
     * Get taxAmount
     *
     * @return taxAmount
     */
    @javax.annotation.Nonnull
    public Long getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
    }

    public TaxBreakdownItem taxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    /**
     * Get taxRate
     *
     * @return taxRate
     */
    @javax.annotation.Nonnull
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public TaxBreakdownItem taxReference(String taxReference) {
        this.taxReference = taxReference;
        return this;
    }

    /**
     * Accounting&#x2f;reporting code of the tax rate for this line, for exports.
     *
     * @return taxReference
     */
    @javax.annotation.Nullable
    public String getTaxReference() {
        return taxReference;
    }

    public void setTaxReference(String taxReference) {
        this.taxReference = taxReference;
    }

    public TaxBreakdownItem taxableAmount(Long taxableAmount) {
        this.taxableAmount = taxableAmount;
        return this;
    }

    /**
     * Get taxableAmount
     *
     * @return taxableAmount
     */
    @javax.annotation.Nonnull
    public Long getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(Long taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    /**
     * Create an instance of TaxBreakdownItem given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TaxBreakdownItem
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     TaxBreakdownItem
     */
    public static TaxBreakdownItem fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, TaxBreakdownItem.class);
    }

    /**
     * Convert an instance of TaxBreakdownItem to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
