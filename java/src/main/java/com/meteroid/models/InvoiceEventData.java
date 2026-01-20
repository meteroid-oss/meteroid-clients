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

import java.time.OffsetDateTime;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class InvoiceEventData {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String currency;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty private InvoiceStatus status;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty private Long total;

    public InvoiceEventData() {}

    public InvoiceEventData createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public InvoiceEventData currency(String currency) {
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

    public InvoiceEventData customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Get customerId
     *
     * @return customerId
     */
    @javax.annotation.Nonnull
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public InvoiceEventData invoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    /**
     * Get invoiceId
     *
     * @return invoiceId
     */
    @javax.annotation.Nonnull
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceEventData status(InvoiceStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public InvoiceEventData taxAmount(Long taxAmount) {
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

    public InvoiceEventData total(Long total) {
        this.total = total;
        return this;
    }

    /**
     * Get total
     *
     * @return total
     */
    @javax.annotation.Nonnull
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * Create an instance of InvoiceEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of InvoiceEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     InvoiceEventData
     */
    public static InvoiceEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, InvoiceEventData.class);
    }

    /**
     * Convert an instance of InvoiceEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
