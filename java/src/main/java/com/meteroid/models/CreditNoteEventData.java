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
public class CreditNoteEventData {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("credit_note_id")
    private String creditNoteId;

    @JsonProperty("credited_amount_cents")
    private Long creditedAmountCents;

    @JsonProperty private String currency;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("refunded_amount_cents")
    private Long refundedAmountCents;

    @JsonProperty private CreditNoteStatus status;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty private Long total;

    public CreditNoteEventData() {}

    public CreditNoteEventData createdAt(OffsetDateTime createdAt) {
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

    public CreditNoteEventData creditNoteId(String creditNoteId) {
        this.creditNoteId = creditNoteId;
        return this;
    }

    /**
     * Get creditNoteId
     *
     * @return creditNoteId
     */
    @javax.annotation.Nonnull
    public String getCreditNoteId() {
        return creditNoteId;
    }

    public void setCreditNoteId(String creditNoteId) {
        this.creditNoteId = creditNoteId;
    }

    public CreditNoteEventData creditedAmountCents(Long creditedAmountCents) {
        this.creditedAmountCents = creditedAmountCents;
        return this;
    }

    /**
     * Get creditedAmountCents
     *
     * @return creditedAmountCents
     */
    @javax.annotation.Nonnull
    public Long getCreditedAmountCents() {
        return creditedAmountCents;
    }

    public void setCreditedAmountCents(Long creditedAmountCents) {
        this.creditedAmountCents = creditedAmountCents;
    }

    public CreditNoteEventData currency(String currency) {
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

    public CreditNoteEventData customerId(String customerId) {
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

    public CreditNoteEventData invoiceId(String invoiceId) {
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

    public CreditNoteEventData refundedAmountCents(Long refundedAmountCents) {
        this.refundedAmountCents = refundedAmountCents;
        return this;
    }

    /**
     * Get refundedAmountCents
     *
     * @return refundedAmountCents
     */
    @javax.annotation.Nonnull
    public Long getRefundedAmountCents() {
        return refundedAmountCents;
    }

    public void setRefundedAmountCents(Long refundedAmountCents) {
        this.refundedAmountCents = refundedAmountCents;
    }

    public CreditNoteEventData status(CreditNoteStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public CreditNoteStatus getStatus() {
        return status;
    }

    public void setStatus(CreditNoteStatus status) {
        this.status = status;
    }

    public CreditNoteEventData taxAmount(Long taxAmount) {
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

    public CreditNoteEventData total(Long total) {
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
     * Create an instance of CreditNoteEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreditNoteEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreditNoteEventData
     */
    public static CreditNoteEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreditNoteEventData.class);
    }

    /**
     * Convert an instance of CreditNoteEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
