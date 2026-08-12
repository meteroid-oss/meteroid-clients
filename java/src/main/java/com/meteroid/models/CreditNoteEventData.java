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
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CreditNoteEventData {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("credit_note_id")
    private String creditNoteId;

    @JsonProperty("credit_note_number")
    private String creditNoteNumber;

    @JsonProperty("credited_amount_cents")
    private Long creditedAmountCents;

    @JsonProperty private String currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("invoice_number")
    private String invoiceNumber;

    @JsonProperty("line_items")
    private List<InvoiceLineItem> lineItems;

    @JsonProperty private String memo;
    @JsonProperty private String reason;

    @JsonProperty("refunded_amount_cents")
    private Long refundedAmountCents;

    @JsonProperty private CreditNoteStatus status;
    @JsonProperty private Long subtotal;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("tax_breakdown")
    private List<TaxBreakdownItem> taxBreakdown;

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

    public CreditNoteEventData creditNoteNumber(String creditNoteNumber) {
        this.creditNoteNumber = creditNoteNumber;
        return this;
    }

    /**
     * Absent while the credit note is a draft — the number is assigned at finalization.
     *
     * @return creditNoteNumber
     */
    @javax.annotation.Nullable
    public String getCreditNoteNumber() {
        return creditNoteNumber;
    }

    public void setCreditNoteNumber(String creditNoteNumber) {
        this.creditNoteNumber = creditNoteNumber;
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

    public CreditNoteEventData customProperties(Object customProperties) {
        this.customProperties = customProperties;
        return this;
    }

    /**
     * User-defined custom property values, keyed by definition key.
     *
     * @return customProperties
     */
    @javax.annotation.Nonnull
    public Object getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Object customProperties) {
        this.customProperties = customProperties;
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

    public CreditNoteEventData invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * Number of the invoice being credited.
     *
     * @return invoiceNumber
     */
    @javax.annotation.Nullable
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public CreditNoteEventData lineItems(List<InvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public CreditNoteEventData addLineItemsItem(InvoiceLineItem lineItemsItem) {
        if (this.lineItems == null) {
            this.lineItems = new ArrayList<>();
        }
        this.lineItems.add(lineItemsItem);

        return this;
    }

    /**
     * Credited line items (negated amounts).
     *
     * @return lineItems
     */
    @javax.annotation.Nonnull
    public List<InvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<InvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public CreditNoteEventData memo(String memo) {
        this.memo = memo;
        return this;
    }

    /**
     * Get memo
     *
     * @return memo
     */
    @javax.annotation.Nullable
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public CreditNoteEventData reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     */
    @javax.annotation.Nullable
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public CreditNoteEventData subtotal(Long subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    /**
     * Get subtotal
     *
     * @return subtotal
     */
    @javax.annotation.Nonnull
    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
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

    public CreditNoteEventData taxBreakdown(List<TaxBreakdownItem> taxBreakdown) {
        this.taxBreakdown = taxBreakdown;
        return this;
    }

    public CreditNoteEventData addTaxBreakdownItem(TaxBreakdownItem taxBreakdownItem) {
        if (this.taxBreakdown == null) {
            this.taxBreakdown = new ArrayList<>();
        }
        this.taxBreakdown.add(taxBreakdownItem);

        return this;
    }

    /**
     * Per-rate tax (VAT) breakdown for the credited amount.
     *
     * @return taxBreakdown
     */
    @javax.annotation.Nonnull
    public List<TaxBreakdownItem> getTaxBreakdown() {
        return taxBreakdown;
    }

    public void setTaxBreakdown(List<TaxBreakdownItem> taxBreakdown) {
        this.taxBreakdown = taxBreakdown;
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
