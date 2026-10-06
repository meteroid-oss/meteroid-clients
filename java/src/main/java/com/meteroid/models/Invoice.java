// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.JsonField;
import com.meteroid.internal.Utils;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class Invoice {
    @JsonProperty("amount_due")
    private Long amountDue;

    @JsonProperty("applied_credits")
    private Long appliedCredits;

    @JsonProperty("billing_period_start")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> billingPeriodStart = JsonField.missing();

    @JsonProperty("child_invoice_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> childInvoiceId = JsonField.missing();

    @JsonProperty("coupons")
    private List<CouponLineItem> coupons;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_details")
    private CustomerDetails customerDetails;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("due_date")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> dueDate = JsonField.missing();

    @JsonProperty("einvoicing_status")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<EInvoicingStatus> einvoicingStatus = JsonField.missing();

    @JsonProperty("finalized_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> finalizedAt = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("invoice_date")
    private LocalDate invoiceDate;

    @JsonProperty("invoice_number")
    private String invoiceNumber;

    @JsonProperty("invoice_type")
    private InvoiceType invoiceType;

    @JsonProperty("line_items")
    private List<InvoiceLineItem> lineItems;

    @JsonProperty("marked_as_uncollectible_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> markedAsUncollectibleAt = JsonField.missing();

    @JsonProperty("memo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> memo = JsonField.missing();

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("paid_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> paidAt = JsonField.missing();

    @JsonProperty("parent_invoice_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> parentInvoiceId = JsonField.missing();

    @JsonProperty("payment_status")
    private InvoicePaymentStatus paymentStatus;

    @JsonProperty("purchase_order")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> purchaseOrder = JsonField.missing();

    @JsonProperty("reference")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> reference = JsonField.missing();

    @JsonProperty("status")
    private InvoiceStatus status;

    @JsonProperty("subscription_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> subscriptionId = JsonField.missing();

    @JsonProperty("subtotal")
    private Long subtotal;

    @JsonProperty("subtotal_recurring")
    private Long subtotalRecurring;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("tax_breakdown")
    private List<TaxBreakdownItem> taxBreakdown;

    @JsonProperty("total")
    private Long total;

    @JsonProperty("transactions")
    private List<Transaction> transactions;

    @JsonProperty("updated_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> updatedAt = JsonField.missing();

    @JsonProperty("voided_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> voidedAt = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Invoice() {}

    private Invoice(Builder builder) {
        this.amountDue = builder.amountDue;
        this.appliedCredits = builder.appliedCredits;
        this.billingPeriodStart = builder.billingPeriodStart;
        this.childInvoiceId = builder.childInvoiceId;
        this.coupons = Utils.copyList(builder.coupons);
        this.createdAt = builder.createdAt;
        this.currency = builder.currency;
        this.customProperties = builder.customProperties;
        this.customerDetails = builder.customerDetails;
        this.customerId = builder.customerId;
        this.dueDate = builder.dueDate;
        this.einvoicingStatus = builder.einvoicingStatus;
        this.finalizedAt = builder.finalizedAt;
        this.id = builder.id;
        this.invoiceDate = builder.invoiceDate;
        this.invoiceNumber = builder.invoiceNumber;
        this.invoiceType = builder.invoiceType;
        this.lineItems = Utils.copyList(builder.lineItems);
        this.markedAsUncollectibleAt = builder.markedAsUncollectibleAt;
        this.memo = builder.memo;
        this.netTerms = builder.netTerms;
        this.paidAt = builder.paidAt;
        this.parentInvoiceId = builder.parentInvoiceId;
        this.paymentStatus = builder.paymentStatus;
        this.purchaseOrder = builder.purchaseOrder;
        this.reference = builder.reference;
        this.status = builder.status;
        this.subscriptionId = builder.subscriptionId;
        this.subtotal = builder.subtotal;
        this.subtotalRecurring = builder.subtotalRecurring;
        this.taxAmount = builder.taxAmount;
        this.taxBreakdown = Utils.copyList(builder.taxBreakdown);
        this.total = builder.total;
        this.transactions = Utils.copyList(builder.transactions);
        this.updatedAt = builder.updatedAt;
        this.voidedAt = builder.voidedAt;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Invoice}.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder starting from this value.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.amountDue = amountDue;
        builder.appliedCredits = appliedCredits;
        builder.billingPeriodStart = billingPeriodStart;
        builder.childInvoiceId = childInvoiceId;
        builder.coupons = Utils.mutableList(coupons);
        builder.createdAt = createdAt;
        builder.currency = currency;
        builder.customProperties = customProperties;
        builder.customerDetails = customerDetails;
        builder.customerId = customerId;
        builder.dueDate = dueDate;
        builder.einvoicingStatus = einvoicingStatus;
        builder.finalizedAt = finalizedAt;
        builder.id = id;
        builder.invoiceDate = invoiceDate;
        builder.invoiceNumber = invoiceNumber;
        builder.invoiceType = invoiceType;
        builder.lineItems = Utils.mutableList(lineItems);
        builder.markedAsUncollectibleAt = markedAsUncollectibleAt;
        builder.memo = memo;
        builder.netTerms = netTerms;
        builder.paidAt = paidAt;
        builder.parentInvoiceId = parentInvoiceId;
        builder.paymentStatus = paymentStatus;
        builder.purchaseOrder = purchaseOrder;
        builder.reference = reference;
        builder.status = status;
        builder.subscriptionId = subscriptionId;
        builder.subtotal = subtotal;
        builder.subtotalRecurring = subtotalRecurring;
        builder.taxAmount = taxAmount;
        builder.taxBreakdown = Utils.mutableList(taxBreakdown);
        builder.total = total;
        builder.transactions = Utils.mutableList(transactions);
        builder.updatedAt = updatedAt;
        builder.voidedAt = voidedAt;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code amount_due} property.
     *
     * @return the value, never null
     */
    public Long amountDue() {
        return Utils.required(amountDue, "amount_due");
    }

    /**
     * The {@code applied_credits} property.
     *
     * @return the value, never null
     */
    public Long appliedCredits() {
        return Utils.required(appliedCredits, "applied_credits");
    }

    /**
     * The period/moment this invoice is about — the subscription period start, or the invoice's own
     * date for manual/one-off. Stable and always present, distinct from <code>invoice_date</code>
     * (the emission date). Shown as "Invoice date".
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> billingPeriodStart() {
        return billingPeriodStart.asOptional();
    }

    /**
     * The {@code child_invoice_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> childInvoiceId() {
        return childInvoiceId.asOptional();
    }

    /**
     * The {@code coupons} property.
     *
     * @return the value, never null
     */
    public List<CouponLineItem> coupons() {
        return Utils.required(coupons, "coupons");
    }

    /**
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
    }

    /**
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public Currency currency() {
        return Utils.required(currency, "currency");
    }

    /**
     * User-defined custom property values, keyed by definition <code>key</code>.
     *
     * @return the value, never null
     */
    public Object customProperties() {
        return Utils.required(customProperties, "custom_properties");
    }

    /**
     * The {@code customer_details} property.
     *
     * @return the value, never null
     */
    public CustomerDetails customerDetails() {
        return Utils.required(customerDetails, "customer_details");
    }

    /**
     * The {@code customer_id} property.
     *
     * @return the value, never null
     */
    public String customerId() {
        return Utils.required(customerId, "customer_id");
    }

    /**
     * The {@code due_date} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> dueDate() {
        return dueDate.asOptional();
    }

    /**
     * The {@code einvoicing_status} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<EInvoicingStatus> einvoicingStatus() {
        return einvoicingStatus.asOptional();
    }

    /**
     * The {@code finalized_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> finalizedAt() {
        return finalizedAt.asOptional();
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code invoice_date} property.
     *
     * @return the value, never null
     */
    public LocalDate invoiceDate() {
        return Utils.required(invoiceDate, "invoice_date");
    }

    /**
     * The {@code invoice_number} property.
     *
     * @return the value, never null
     */
    public String invoiceNumber() {
        return Utils.required(invoiceNumber, "invoice_number");
    }

    /**
     * The {@code invoice_type} property.
     *
     * @return the value, never null
     */
    public InvoiceType invoiceType() {
        return Utils.required(invoiceType, "invoice_type");
    }

    /**
     * The {@code line_items} property.
     *
     * @return the value, never null
     */
    public List<InvoiceLineItem> lineItems() {
        return Utils.required(lineItems, "line_items");
    }

    /**
     * The {@code marked_as_uncollectible_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> markedAsUncollectibleAt() {
        return markedAsUncollectibleAt.asOptional();
    }

    /**
     * The {@code memo} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> memo() {
        return memo.asOptional();
    }

    /**
     * The {@code net_terms} property.
     *
     * @return the value, never null
     */
    public Integer netTerms() {
        return Utils.required(netTerms, "net_terms");
    }

    /**
     * The {@code paid_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> paidAt() {
        return paidAt.asOptional();
    }

    /**
     * The {@code parent_invoice_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> parentInvoiceId() {
        return parentInvoiceId.asOptional();
    }

    /**
     * The {@code payment_status} property.
     *
     * @return the value, never null
     */
    public InvoicePaymentStatus paymentStatus() {
        return Utils.required(paymentStatus, "payment_status");
    }

    /**
     * The {@code purchase_order} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> purchaseOrder() {
        return purchaseOrder.asOptional();
    }

    /**
     * The {@code reference} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> reference() {
        return reference.asOptional();
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public InvoiceStatus status() {
        return Utils.required(status, "status");
    }

    /**
     * The {@code subscription_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> subscriptionId() {
        return subscriptionId.asOptional();
    }

    /**
     * The {@code subtotal} property.
     *
     * @return the value, never null
     */
    public Long subtotal() {
        return Utils.required(subtotal, "subtotal");
    }

    /**
     * The {@code subtotal_recurring} property.
     *
     * @return the value, never null
     */
    public Long subtotalRecurring() {
        return Utils.required(subtotalRecurring, "subtotal_recurring");
    }

    /**
     * The {@code tax_amount} property.
     *
     * @return the value, never null
     */
    public Long taxAmount() {
        return Utils.required(taxAmount, "tax_amount");
    }

    /**
     * The {@code tax_breakdown} property.
     *
     * @return the value, never null
     */
    public List<TaxBreakdownItem> taxBreakdown() {
        return Utils.required(taxBreakdown, "tax_breakdown");
    }

    /**
     * The {@code total} property.
     *
     * @return the value, never null
     */
    public Long total() {
        return Utils.required(total, "total");
    }

    /**
     * The {@code transactions} property.
     *
     * @return the value, never null
     */
    public List<Transaction> transactions() {
        return Utils.required(transactions, "transactions");
    }

    /**
     * The {@code updated_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> updatedAt() {
        return updatedAt.asOptional();
    }

    /**
     * The {@code voided_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> voidedAt() {
        return voidedAt.asOptional();
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnyGetter
    private Map<String, JsonNode> anyProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void putAnyProperty(String name, JsonNode value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Invoice that = (Invoice) o;
        return Objects.equals(amountDue, that.amountDue)
                && Objects.equals(appliedCredits, that.appliedCredits)
                && Objects.equals(billingPeriodStart, that.billingPeriodStart)
                && Objects.equals(childInvoiceId, that.childInvoiceId)
                && Objects.equals(coupons, that.coupons)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(currency, that.currency)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customerDetails, that.customerDetails)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(dueDate, that.dueDate)
                && Objects.equals(einvoicingStatus, that.einvoicingStatus)
                && Objects.equals(finalizedAt, that.finalizedAt)
                && Objects.equals(id, that.id)
                && Objects.equals(invoiceDate, that.invoiceDate)
                && Objects.equals(invoiceNumber, that.invoiceNumber)
                && Objects.equals(invoiceType, that.invoiceType)
                && Objects.equals(lineItems, that.lineItems)
                && Objects.equals(markedAsUncollectibleAt, that.markedAsUncollectibleAt)
                && Objects.equals(memo, that.memo)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(paidAt, that.paidAt)
                && Objects.equals(parentInvoiceId, that.parentInvoiceId)
                && Objects.equals(paymentStatus, that.paymentStatus)
                && Objects.equals(purchaseOrder, that.purchaseOrder)
                && Objects.equals(reference, that.reference)
                && Objects.equals(status, that.status)
                && Objects.equals(subscriptionId, that.subscriptionId)
                && Objects.equals(subtotal, that.subtotal)
                && Objects.equals(subtotalRecurring, that.subtotalRecurring)
                && Objects.equals(taxAmount, that.taxAmount)
                && Objects.equals(taxBreakdown, that.taxBreakdown)
                && Objects.equals(total, that.total)
                && Objects.equals(transactions, that.transactions)
                && Objects.equals(updatedAt, that.updatedAt)
                && Objects.equals(voidedAt, that.voidedAt)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                amountDue,
                appliedCredits,
                billingPeriodStart,
                childInvoiceId,
                coupons,
                createdAt,
                currency,
                customProperties,
                customerDetails,
                customerId,
                dueDate,
                einvoicingStatus,
                finalizedAt,
                id,
                invoiceDate,
                invoiceNumber,
                invoiceType,
                lineItems,
                markedAsUncollectibleAt,
                memo,
                netTerms,
                paidAt,
                parentInvoiceId,
                paymentStatus,
                purchaseOrder,
                reference,
                status,
                subscriptionId,
                subtotal,
                subtotalRecurring,
                taxAmount,
                taxBreakdown,
                total,
                transactions,
                updatedAt,
                voidedAt,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "Invoice{"
                + "amountDue="
                + amountDue
                + ", appliedCredits="
                + appliedCredits
                + ", billingPeriodStart="
                + billingPeriodStart
                + ", childInvoiceId="
                + childInvoiceId
                + ", coupons="
                + coupons
                + ", createdAt="
                + createdAt
                + ", currency="
                + currency
                + ", customProperties="
                + customProperties
                + ", customerDetails="
                + customerDetails
                + ", customerId="
                + customerId
                + ", dueDate="
                + dueDate
                + ", einvoicingStatus="
                + einvoicingStatus
                + ", finalizedAt="
                + finalizedAt
                + ", id="
                + id
                + ", invoiceDate="
                + invoiceDate
                + ", invoiceNumber="
                + invoiceNumber
                + ", invoiceType="
                + invoiceType
                + ", lineItems="
                + lineItems
                + ", markedAsUncollectibleAt="
                + markedAsUncollectibleAt
                + ", memo="
                + memo
                + ", netTerms="
                + netTerms
                + ", paidAt="
                + paidAt
                + ", parentInvoiceId="
                + parentInvoiceId
                + ", paymentStatus="
                + paymentStatus
                + ", purchaseOrder="
                + purchaseOrder
                + ", reference="
                + reference
                + ", status="
                + status
                + ", subscriptionId="
                + subscriptionId
                + ", subtotal="
                + subtotal
                + ", subtotalRecurring="
                + subtotalRecurring
                + ", taxAmount="
                + taxAmount
                + ", taxBreakdown="
                + taxBreakdown
                + ", total="
                + total
                + ", transactions="
                + transactions
                + ", updatedAt="
                + updatedAt
                + ", voidedAt="
                + voidedAt
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Invoice}. */
    public static final class Builder {
        private Long amountDue;
        private Long appliedCredits;
        private JsonField<LocalDate> billingPeriodStart = JsonField.missing();
        private JsonField<String> childInvoiceId = JsonField.missing();
        private List<CouponLineItem> coupons;
        private OffsetDateTime createdAt;
        private Currency currency;
        private Object customProperties;
        private CustomerDetails customerDetails;
        private String customerId;
        private JsonField<LocalDate> dueDate = JsonField.missing();
        private JsonField<EInvoicingStatus> einvoicingStatus = JsonField.missing();
        private JsonField<OffsetDateTime> finalizedAt = JsonField.missing();
        private String id;
        private LocalDate invoiceDate;
        private String invoiceNumber;
        private InvoiceType invoiceType;
        private List<InvoiceLineItem> lineItems;
        private JsonField<OffsetDateTime> markedAsUncollectibleAt = JsonField.missing();
        private JsonField<String> memo = JsonField.missing();
        private Integer netTerms;
        private JsonField<OffsetDateTime> paidAt = JsonField.missing();
        private JsonField<String> parentInvoiceId = JsonField.missing();
        private InvoicePaymentStatus paymentStatus;
        private JsonField<String> purchaseOrder = JsonField.missing();
        private JsonField<String> reference = JsonField.missing();
        private InvoiceStatus status;
        private JsonField<String> subscriptionId = JsonField.missing();
        private Long subtotal;
        private Long subtotalRecurring;
        private Long taxAmount;
        private List<TaxBreakdownItem> taxBreakdown;
        private Long total;
        private List<Transaction> transactions;
        private JsonField<OffsetDateTime> updatedAt = JsonField.missing();
        private JsonField<OffsetDateTime> voidedAt = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code amount_due} property.
         *
         * @param amountDue the value
         * @return this builder
         */
        public Builder amountDue(Long amountDue) {
            this.amountDue = amountDue;
            return this;
        }

        /**
         * The {@code applied_credits} property.
         *
         * @param appliedCredits the value
         * @return this builder
         */
        public Builder appliedCredits(Long appliedCredits) {
            this.appliedCredits = appliedCredits;
            return this;
        }

        /**
         * The period/moment this invoice is about — the subscription period start, or the invoice's
         * own date for manual/one-off. Stable and always present, distinct from <code>invoice_date
         * </code> (the emission date). Shown as "Invoice date".
         *
         * @param billingPeriodStart the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingPeriodStart(LocalDate billingPeriodStart) {
            this.billingPeriodStart = JsonField.ofNullable(billingPeriodStart);
            return this;
        }

        /**
         * The {@code child_invoice_id} property.
         *
         * @param childInvoiceId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder childInvoiceId(String childInvoiceId) {
            this.childInvoiceId = JsonField.ofNullable(childInvoiceId);
            return this;
        }

        /**
         * The {@code coupons} property.
         *
         * @param coupons the value
         * @return this builder
         */
        public Builder coupons(List<CouponLineItem> coupons) {
            this.coupons = Utils.mutableList(coupons);
            return this;
        }

        /**
         * Adds an item to {@code coupons}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addCouponsItem(CouponLineItem item) {
            if (this.coupons == null) {
                this.coupons = new ArrayList<>();
            }
            this.coupons.add(item);
            return this;
        }

        /**
         * The {@code created_at} property.
         *
         * @param createdAt the value
         * @return this builder
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * The {@code currency} property.
         *
         * @param currency the value
         * @return this builder
         */
        public Builder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        /**
         * User-defined custom property values, keyed by definition <code>key</code>.
         *
         * @param customProperties the value
         * @return this builder
         */
        public Builder customProperties(Object customProperties) {
            this.customProperties = customProperties;
            return this;
        }

        /**
         * The {@code customer_details} property.
         *
         * @param customerDetails the value
         * @return this builder
         */
        public Builder customerDetails(CustomerDetails customerDetails) {
            this.customerDetails = customerDetails;
            return this;
        }

        /**
         * The {@code customer_id} property.
         *
         * @param customerId the value
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * The {@code due_date} property.
         *
         * @param dueDate the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = JsonField.ofNullable(dueDate);
            return this;
        }

        /**
         * The {@code einvoicing_status} property.
         *
         * @param einvoicingStatus the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder einvoicingStatus(EInvoicingStatus einvoicingStatus) {
            this.einvoicingStatus = JsonField.ofNullable(einvoicingStatus);
            return this;
        }

        /**
         * The {@code finalized_at} property.
         *
         * @param finalizedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder finalizedAt(OffsetDateTime finalizedAt) {
            this.finalizedAt = JsonField.ofNullable(finalizedAt);
            return this;
        }

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * The {@code invoice_date} property.
         *
         * @param invoiceDate the value
         * @return this builder
         */
        public Builder invoiceDate(LocalDate invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        /**
         * The {@code invoice_number} property.
         *
         * @param invoiceNumber the value
         * @return this builder
         */
        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        /**
         * The {@code invoice_type} property.
         *
         * @param invoiceType the value
         * @return this builder
         */
        public Builder invoiceType(InvoiceType invoiceType) {
            this.invoiceType = invoiceType;
            return this;
        }

        /**
         * The {@code line_items} property.
         *
         * @param lineItems the value
         * @return this builder
         */
        public Builder lineItems(List<InvoiceLineItem> lineItems) {
            this.lineItems = Utils.mutableList(lineItems);
            return this;
        }

        /**
         * Adds an item to {@code line_items}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addLineItemsItem(InvoiceLineItem item) {
            if (this.lineItems == null) {
                this.lineItems = new ArrayList<>();
            }
            this.lineItems.add(item);
            return this;
        }

        /**
         * The {@code marked_as_uncollectible_at} property.
         *
         * @param markedAsUncollectibleAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder markedAsUncollectibleAt(OffsetDateTime markedAsUncollectibleAt) {
            this.markedAsUncollectibleAt = JsonField.ofNullable(markedAsUncollectibleAt);
            return this;
        }

        /**
         * The {@code memo} property.
         *
         * @param memo the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder memo(String memo) {
            this.memo = JsonField.ofNullable(memo);
            return this;
        }

        /**
         * The {@code net_terms} property.
         *
         * @param netTerms the value
         * @return this builder
         */
        public Builder netTerms(Integer netTerms) {
            this.netTerms = netTerms;
            return this;
        }

        /**
         * The {@code paid_at} property.
         *
         * @param paidAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder paidAt(OffsetDateTime paidAt) {
            this.paidAt = JsonField.ofNullable(paidAt);
            return this;
        }

        /**
         * The {@code parent_invoice_id} property.
         *
         * @param parentInvoiceId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder parentInvoiceId(String parentInvoiceId) {
            this.parentInvoiceId = JsonField.ofNullable(parentInvoiceId);
            return this;
        }

        /**
         * The {@code payment_status} property.
         *
         * @param paymentStatus the value
         * @return this builder
         */
        public Builder paymentStatus(InvoicePaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        /**
         * The {@code purchase_order} property.
         *
         * @param purchaseOrder the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder purchaseOrder(String purchaseOrder) {
            this.purchaseOrder = JsonField.ofNullable(purchaseOrder);
            return this;
        }

        /**
         * The {@code reference} property.
         *
         * @param reference the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder reference(String reference) {
            this.reference = JsonField.ofNullable(reference);
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(InvoiceStatus status) {
            this.status = status;
            return this;
        }

        /**
         * The {@code subscription_id} property.
         *
         * @param subscriptionId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = JsonField.ofNullable(subscriptionId);
            return this;
        }

        /**
         * The {@code subtotal} property.
         *
         * @param subtotal the value
         * @return this builder
         */
        public Builder subtotal(Long subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        /**
         * The {@code subtotal_recurring} property.
         *
         * @param subtotalRecurring the value
         * @return this builder
         */
        public Builder subtotalRecurring(Long subtotalRecurring) {
            this.subtotalRecurring = subtotalRecurring;
            return this;
        }

        /**
         * The {@code tax_amount} property.
         *
         * @param taxAmount the value
         * @return this builder
         */
        public Builder taxAmount(Long taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        /**
         * The {@code tax_breakdown} property.
         *
         * @param taxBreakdown the value
         * @return this builder
         */
        public Builder taxBreakdown(List<TaxBreakdownItem> taxBreakdown) {
            this.taxBreakdown = Utils.mutableList(taxBreakdown);
            return this;
        }

        /**
         * Adds an item to {@code tax_breakdown}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addTaxBreakdownItem(TaxBreakdownItem item) {
            if (this.taxBreakdown == null) {
                this.taxBreakdown = new ArrayList<>();
            }
            this.taxBreakdown.add(item);
            return this;
        }

        /**
         * The {@code total} property.
         *
         * @param total the value
         * @return this builder
         */
        public Builder total(Long total) {
            this.total = total;
            return this;
        }

        /**
         * The {@code transactions} property.
         *
         * @param transactions the value
         * @return this builder
         */
        public Builder transactions(List<Transaction> transactions) {
            this.transactions = Utils.mutableList(transactions);
            return this;
        }

        /**
         * Adds an item to {@code transactions}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addTransactionsItem(Transaction item) {
            if (this.transactions == null) {
                this.transactions = new ArrayList<>();
            }
            this.transactions.add(item);
            return this;
        }

        /**
         * The {@code updated_at} property.
         *
         * @param updatedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = JsonField.ofNullable(updatedAt);
            return this;
        }

        /**
         * The {@code voided_at} property.
         *
         * @param voidedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder voidedAt(OffsetDateTime voidedAt) {
            this.voidedAt = JsonField.ofNullable(voidedAt);
            return this;
        }

        /**
         * A property the SDK does not know, sent along.
         *
         * @param name the property name
         * @param value the JSON value
         * @return this builder
         */
        public Builder putAdditionalProperty(String name, JsonNode value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Properties the SDK does not know, sent along.
         *
         * @param additionalProperties the properties by name
         * @return this builder
         */
        public Builder putAllAdditionalProperties(Map<String, JsonNode> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        /**
         * Leaves out a property the SDK does not know.
         *
         * @param name the property name
         * @return this builder
         */
        public Builder removeAdditionalProperty(String name) {
            additionalProperties.remove(name);
            return this;
        }

        /**
         * The {@code Invoice}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Invoice build() {
            Utils.checkRequired(amountDue, "amount_due");
            Utils.checkRequired(appliedCredits, "applied_credits");
            Utils.checkRequired(coupons, "coupons");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(customProperties, "custom_properties");
            Utils.checkRequired(customerDetails, "customer_details");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(invoiceDate, "invoice_date");
            Utils.checkRequired(invoiceNumber, "invoice_number");
            Utils.checkRequired(invoiceType, "invoice_type");
            Utils.checkRequired(lineItems, "line_items");
            Utils.checkRequired(netTerms, "net_terms");
            Utils.checkRequired(paymentStatus, "payment_status");
            Utils.checkRequired(status, "status");
            Utils.checkRequired(subtotal, "subtotal");
            Utils.checkRequired(subtotalRecurring, "subtotal_recurring");
            Utils.checkRequired(taxAmount, "tax_amount");
            Utils.checkRequired(taxBreakdown, "tax_breakdown");
            Utils.checkRequired(total, "total");
            Utils.checkRequired(transactions, "transactions");
            return new Invoice(this);
        }
    }

    /**
     * Parse {@code json} as {@code Invoice}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Invoice fromJson(String json) {
        return Utils.parse(json, Invoice.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }
}
