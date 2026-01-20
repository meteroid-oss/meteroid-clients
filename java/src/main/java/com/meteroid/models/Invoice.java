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
public class Invoice {
    @JsonProperty("amount_due")
    private Long amountDue;

    @JsonProperty("applied_credits")
    private Long appliedCredits;

    @JsonProperty private List<CouponLineItem> coupons;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private Currency currency;

    @JsonProperty("customer_details")
    private CustomerDetails customerDetails;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("due_date")
    private String dueDate;

    @JsonProperty("finalized_at")
    private OffsetDateTime finalizedAt;

    @JsonProperty private String id;

    @JsonProperty("invoice_date")
    private String invoiceDate;

    @JsonProperty("invoice_number")
    private String invoiceNumber;

    @JsonProperty("invoice_type")
    private InvoiceType invoiceType;

    @JsonProperty("line_items")
    private List<InvoiceLineItem> lineItems;

    @JsonProperty("marked_as_uncollectible_at")
    private OffsetDateTime markedAsUncollectibleAt;

    @JsonProperty private String memo;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("paid_at")
    private OffsetDateTime paidAt;

    @JsonProperty("payment_status")
    private InvoicePaymentStatus paymentStatus;

    @JsonProperty("purchase_order")
    private String purchaseOrder;

    @JsonProperty private String reference;
    @JsonProperty private InvoiceStatus status;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty private Long subtotal;

    @JsonProperty("subtotal_recurring")
    private Long subtotalRecurring;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("tax_breakdown")
    private List<TaxBreakdownItem> taxBreakdown;

    @JsonProperty private Long total;
    @JsonProperty private List<Transaction> transactions;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    @JsonProperty("voided_at")
    private OffsetDateTime voidedAt;

    public Invoice() {}

    public Invoice amountDue(Long amountDue) {
        this.amountDue = amountDue;
        return this;
    }

    /**
     * Get amountDue
     *
     * @return amountDue
     */
    @javax.annotation.Nonnull
    public Long getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Long amountDue) {
        this.amountDue = amountDue;
    }

    public Invoice appliedCredits(Long appliedCredits) {
        this.appliedCredits = appliedCredits;
        return this;
    }

    /**
     * Get appliedCredits
     *
     * @return appliedCredits
     */
    @javax.annotation.Nonnull
    public Long getAppliedCredits() {
        return appliedCredits;
    }

    public void setAppliedCredits(Long appliedCredits) {
        this.appliedCredits = appliedCredits;
    }

    public Invoice coupons(List<CouponLineItem> coupons) {
        this.coupons = coupons;
        return this;
    }

    public Invoice addCouponsItem(CouponLineItem couponsItem) {
        if (this.coupons == null) {
            this.coupons = new ArrayList<>();
        }
        this.coupons.add(couponsItem);

        return this;
    }

    /**
     * Get coupons
     *
     * @return coupons
     */
    @javax.annotation.Nonnull
    public List<CouponLineItem> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponLineItem> coupons) {
        this.coupons = coupons;
    }

    public Invoice createdAt(OffsetDateTime createdAt) {
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

    public Invoice currency(Currency currency) {
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

    public Invoice customerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
        return this;
    }

    /**
     * Get customerDetails
     *
     * @return customerDetails
     */
    @javax.annotation.Nonnull
    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Invoice customerId(String customerId) {
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

    public Invoice dueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    /**
     * Get dueDate
     *
     * @return dueDate
     */
    @javax.annotation.Nullable
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Invoice finalizedAt(OffsetDateTime finalizedAt) {
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

    public Invoice id(String id) {
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

    public Invoice invoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    /**
     * Get invoiceDate
     *
     * @return invoiceDate
     */
    @javax.annotation.Nonnull
    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Invoice invoiceNumber(String invoiceNumber) {
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

    public Invoice invoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
        return this;
    }

    /**
     * Get invoiceType
     *
     * @return invoiceType
     */
    @javax.annotation.Nonnull
    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Invoice lineItems(List<InvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public Invoice addLineItemsItem(InvoiceLineItem lineItemsItem) {
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

    public Invoice markedAsUncollectibleAt(OffsetDateTime markedAsUncollectibleAt) {
        this.markedAsUncollectibleAt = markedAsUncollectibleAt;
        return this;
    }

    /**
     * Get markedAsUncollectibleAt
     *
     * @return markedAsUncollectibleAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getMarkedAsUncollectibleAt() {
        return markedAsUncollectibleAt;
    }

    public void setMarkedAsUncollectibleAt(OffsetDateTime markedAsUncollectibleAt) {
        this.markedAsUncollectibleAt = markedAsUncollectibleAt;
    }

    public Invoice memo(String memo) {
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

    public Invoice netTerms(Integer netTerms) {
        this.netTerms = netTerms;
        return this;
    }

    /**
     * Get netTerms
     *
     * @return netTerms
     */
    @javax.annotation.Nonnull
    public Integer getNetTerms() {
        return netTerms;
    }

    public void setNetTerms(Integer netTerms) {
        this.netTerms = netTerms;
    }

    public Invoice paidAt(OffsetDateTime paidAt) {
        this.paidAt = paidAt;
        return this;
    }

    /**
     * Get paidAt
     *
     * @return paidAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(OffsetDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public Invoice paymentStatus(InvoicePaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    /**
     * Get paymentStatus
     *
     * @return paymentStatus
     */
    @javax.annotation.Nonnull
    public InvoicePaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(InvoicePaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Invoice purchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        return this;
    }

    /**
     * Get purchaseOrder
     *
     * @return purchaseOrder
     */
    @javax.annotation.Nullable
    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Invoice reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Get reference
     *
     * @return reference
     */
    @javax.annotation.Nullable
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Invoice status(InvoiceStatus status) {
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

    public Invoice subscriptionId(String subscriptionId) {
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

    public Invoice subtotal(Long subtotal) {
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

    public Invoice subtotalRecurring(Long subtotalRecurring) {
        this.subtotalRecurring = subtotalRecurring;
        return this;
    }

    /**
     * Get subtotalRecurring
     *
     * @return subtotalRecurring
     */
    @javax.annotation.Nonnull
    public Long getSubtotalRecurring() {
        return subtotalRecurring;
    }

    public void setSubtotalRecurring(Long subtotalRecurring) {
        this.subtotalRecurring = subtotalRecurring;
    }

    public Invoice taxAmount(Long taxAmount) {
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

    public Invoice taxBreakdown(List<TaxBreakdownItem> taxBreakdown) {
        this.taxBreakdown = taxBreakdown;
        return this;
    }

    public Invoice addTaxBreakdownItem(TaxBreakdownItem taxBreakdownItem) {
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

    public Invoice total(Long total) {
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

    public Invoice transactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public Invoice addTransactionsItem(Transaction transactionsItem) {
        if (this.transactions == null) {
            this.transactions = new ArrayList<>();
        }
        this.transactions.add(transactionsItem);

        return this;
    }

    /**
     * Get transactions
     *
     * @return transactions
     */
    @javax.annotation.Nonnull
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Invoice updatedAt(OffsetDateTime updatedAt) {
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

    public Invoice voidedAt(OffsetDateTime voidedAt) {
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
     * Create an instance of Invoice given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Invoice
     * @throws JsonProcessingException if the JSON string is invalid with respect to Invoice
     */
    public static Invoice fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Invoice.class);
    }

    /**
     * Convert an instance of Invoice to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
