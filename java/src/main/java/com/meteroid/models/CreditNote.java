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
public class CreditNote {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("credit_note_number")
    private String creditNoteNumber;

    @JsonProperty("credit_type")
    private CreditType creditType;

    @JsonProperty("credited_amount_cents")
    private Long creditedAmountCents;

    @JsonProperty private Currency currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("finalized_at")
    private OffsetDateTime finalizedAt;

    @JsonProperty private String id;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("invoice_number")
    private String invoiceNumber;

    @JsonProperty("line_items")
    private List<InvoiceLineItem> lineItems;

    @JsonProperty private String memo;

    @JsonProperty("plan_version_id")
    private String planVersionId;

    @JsonProperty private String reason;

    @JsonProperty("refunded_amount_cents")
    private Long refundedAmountCents;

    @JsonProperty private CreditNoteStatus status;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty private Long subtotal;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("tax_breakdown")
    private List<TaxBreakdownItem> taxBreakdown;

    @JsonProperty private Long total;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    @JsonProperty("voided_at")
    private OffsetDateTime voidedAt;

    public CreditNote() {}

    public CreditNote createdAt(OffsetDateTime createdAt) {
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

    public CreditNote creditNoteNumber(String creditNoteNumber) {
        this.creditNoteNumber = creditNoteNumber;
        return this;
    }

    /**
     * Get creditNoteNumber
     *
     * @return creditNoteNumber
     */
    @javax.annotation.Nonnull
    public String getCreditNoteNumber() {
        return creditNoteNumber;
    }

    public void setCreditNoteNumber(String creditNoteNumber) {
        this.creditNoteNumber = creditNoteNumber;
    }

    public CreditNote creditType(CreditType creditType) {
        this.creditType = creditType;
        return this;
    }

    /**
     * Get creditType
     *
     * @return creditType
     */
    @javax.annotation.Nonnull
    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public CreditNote creditedAmountCents(Long creditedAmountCents) {
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

    public CreditNote currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @javax.annotation.Nonnull
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CreditNote customProperties(Object customProperties) {
        this.customProperties = customProperties;
        return this;
    }

    /**
     * User-defined custom property values, keyed by definition `key`.
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

    public CreditNote customerId(String customerId) {
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

    public CreditNote finalizedAt(OffsetDateTime finalizedAt) {
        this.finalizedAt = finalizedAt;
        return this;
    }

    /**
     * Get finalizedAt
     *
     * @return finalizedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getFinalizedAt() {
        return finalizedAt;
    }

    public void setFinalizedAt(OffsetDateTime finalizedAt) {
        this.finalizedAt = finalizedAt;
    }

    public CreditNote id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CreditNote invoiceId(String invoiceId) {
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

    public CreditNote invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * Get invoiceNumber
     *
     * @return invoiceNumber
     */
    @javax.annotation.Nonnull
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public CreditNote lineItems(List<InvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public CreditNote addLineItemsItem(InvoiceLineItem lineItemsItem) {
        if (this.lineItems == null) {
            this.lineItems = new ArrayList<>();
        }
        this.lineItems.add(lineItemsItem);

        return this;
    }

    /**
     * Get lineItems
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

    public CreditNote memo(String memo) {
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

    public CreditNote planVersionId(String planVersionId) {
        this.planVersionId = planVersionId;
        return this;
    }

    /**
     * Get planVersionId
     *
     * @return planVersionId
     */
    @javax.annotation.Nullable
    public String getPlanVersionId() {
        return planVersionId;
    }

    public void setPlanVersionId(String planVersionId) {
        this.planVersionId = planVersionId;
    }

    public CreditNote reason(String reason) {
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

    public CreditNote refundedAmountCents(Long refundedAmountCents) {
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

    public CreditNote status(CreditNoteStatus status) {
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

    public CreditNote subscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /**
     * Get subscriptionId
     *
     * @return subscriptionId
     */
    @javax.annotation.Nullable
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public CreditNote subtotal(Long subtotal) {
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

    public CreditNote taxAmount(Long taxAmount) {
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

    public CreditNote taxBreakdown(List<TaxBreakdownItem> taxBreakdown) {
        this.taxBreakdown = taxBreakdown;
        return this;
    }

    public CreditNote addTaxBreakdownItem(TaxBreakdownItem taxBreakdownItem) {
        if (this.taxBreakdown == null) {
            this.taxBreakdown = new ArrayList<>();
        }
        this.taxBreakdown.add(taxBreakdownItem);

        return this;
    }

    /**
     * Get taxBreakdown
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

    public CreditNote total(Long total) {
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

    public CreditNote updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CreditNote voidedAt(OffsetDateTime voidedAt) {
        this.voidedAt = voidedAt;
        return this;
    }

    /**
     * Get voidedAt
     *
     * @return voidedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getVoidedAt() {
        return voidedAt;
    }

    public void setVoidedAt(OffsetDateTime voidedAt) {
        this.voidedAt = voidedAt;
    }

    /**
     * Create an instance of CreditNote given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreditNote
     * @throws JsonProcessingException if the JSON string is invalid with respect to CreditNote
     */
    public static CreditNote fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreditNote.class);
    }

    /**
     * Convert an instance of CreditNote to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
