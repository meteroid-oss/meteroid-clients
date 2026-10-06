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
public final class CreditNoteEventData {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("credit_note_id")
    private String creditNoteId;

    @JsonProperty("credit_note_number")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> creditNoteNumber = JsonField.missing();

    @JsonProperty("credited_amount_cents")
    private Long creditedAmountCents;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("invoice_number")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoiceNumber = JsonField.missing();

    @JsonProperty("line_items")
    private List<InvoiceLineItem> lineItems;

    @JsonProperty("memo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> memo = JsonField.missing();

    @JsonProperty("reason")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> reason = JsonField.missing();

    @JsonProperty("refunded_amount_cents")
    private Long refundedAmountCents;

    @JsonProperty("status")
    private CreditNoteStatus status;

    @JsonProperty("subtotal")
    private Long subtotal;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("tax_breakdown")
    private List<TaxBreakdownItem> taxBreakdown;

    @JsonProperty("total")
    private Long total;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreditNoteEventData() {}

    private CreditNoteEventData(Builder builder) {
        this.createdAt = builder.createdAt;
        this.creditNoteId = builder.creditNoteId;
        this.creditNoteNumber = builder.creditNoteNumber;
        this.creditedAmountCents = builder.creditedAmountCents;
        this.currency = builder.currency;
        this.customProperties = builder.customProperties;
        this.customerId = builder.customerId;
        this.invoiceId = builder.invoiceId;
        this.invoiceNumber = builder.invoiceNumber;
        this.lineItems = Utils.copyList(builder.lineItems);
        this.memo = builder.memo;
        this.reason = builder.reason;
        this.refundedAmountCents = builder.refundedAmountCents;
        this.status = builder.status;
        this.subtotal = builder.subtotal;
        this.taxAmount = builder.taxAmount;
        this.taxBreakdown = Utils.copyList(builder.taxBreakdown);
        this.total = builder.total;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreditNoteEventData}.
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
        builder.createdAt = createdAt;
        builder.creditNoteId = creditNoteId;
        builder.creditNoteNumber = creditNoteNumber;
        builder.creditedAmountCents = creditedAmountCents;
        builder.currency = currency;
        builder.customProperties = customProperties;
        builder.customerId = customerId;
        builder.invoiceId = invoiceId;
        builder.invoiceNumber = invoiceNumber;
        builder.lineItems = Utils.mutableList(lineItems);
        builder.memo = memo;
        builder.reason = reason;
        builder.refundedAmountCents = refundedAmountCents;
        builder.status = status;
        builder.subtotal = subtotal;
        builder.taxAmount = taxAmount;
        builder.taxBreakdown = Utils.mutableList(taxBreakdown);
        builder.total = total;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * The {@code credit_note_id} property.
     *
     * @return the value, never null
     */
    public String creditNoteId() {
        return Utils.required(creditNoteId, "credit_note_id");
    }

    /**
     * Absent while the credit note is a draft — the number is assigned at finalization.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> creditNoteNumber() {
        return creditNoteNumber.asOptional();
    }

    /**
     * The {@code credited_amount_cents} property.
     *
     * @return the value, never null
     */
    public Long creditedAmountCents() {
        return Utils.required(creditedAmountCents, "credited_amount_cents");
    }

    /**
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public String currency() {
        return Utils.required(currency, "currency");
    }

    /**
     * User-defined custom property values, keyed by definition key.
     *
     * @return the value, never null
     */
    public Object customProperties() {
        return Utils.required(customProperties, "custom_properties");
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
     * The {@code invoice_id} property.
     *
     * @return the value, never null
     */
    public String invoiceId() {
        return Utils.required(invoiceId, "invoice_id");
    }

    /**
     * Number of the invoice being credited.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> invoiceNumber() {
        return invoiceNumber.asOptional();
    }

    /**
     * Credited line items (negated amounts).
     *
     * @return the value, never null
     */
    public List<InvoiceLineItem> lineItems() {
        return Utils.required(lineItems, "line_items");
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
     * The {@code reason} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> reason() {
        return reason.asOptional();
    }

    /**
     * The {@code refunded_amount_cents} property.
     *
     * @return the value, never null
     */
    public Long refundedAmountCents() {
        return Utils.required(refundedAmountCents, "refunded_amount_cents");
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public CreditNoteStatus status() {
        return Utils.required(status, "status");
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
     * The {@code tax_amount} property.
     *
     * @return the value, never null
     */
    public Long taxAmount() {
        return Utils.required(taxAmount, "tax_amount");
    }

    /**
     * Per-rate tax (VAT) breakdown for the credited amount.
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
        CreditNoteEventData that = (CreditNoteEventData) o;
        return Objects.equals(createdAt, that.createdAt)
                && Objects.equals(creditNoteId, that.creditNoteId)
                && Objects.equals(creditNoteNumber, that.creditNoteNumber)
                && Objects.equals(creditedAmountCents, that.creditedAmountCents)
                && Objects.equals(currency, that.currency)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(invoiceId, that.invoiceId)
                && Objects.equals(invoiceNumber, that.invoiceNumber)
                && Objects.equals(lineItems, that.lineItems)
                && Objects.equals(memo, that.memo)
                && Objects.equals(reason, that.reason)
                && Objects.equals(refundedAmountCents, that.refundedAmountCents)
                && Objects.equals(status, that.status)
                && Objects.equals(subtotal, that.subtotal)
                && Objects.equals(taxAmount, that.taxAmount)
                && Objects.equals(taxBreakdown, that.taxBreakdown)
                && Objects.equals(total, that.total)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                createdAt,
                creditNoteId,
                creditNoteNumber,
                creditedAmountCents,
                currency,
                customProperties,
                customerId,
                invoiceId,
                invoiceNumber,
                lineItems,
                memo,
                reason,
                refundedAmountCents,
                status,
                subtotal,
                taxAmount,
                taxBreakdown,
                total,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CreditNoteEventData{"
                + "createdAt="
                + createdAt
                + ", creditNoteId="
                + creditNoteId
                + ", creditNoteNumber="
                + creditNoteNumber
                + ", creditedAmountCents="
                + creditedAmountCents
                + ", currency="
                + currency
                + ", customProperties="
                + customProperties
                + ", customerId="
                + customerId
                + ", invoiceId="
                + invoiceId
                + ", invoiceNumber="
                + invoiceNumber
                + ", lineItems="
                + lineItems
                + ", memo="
                + memo
                + ", reason="
                + reason
                + ", refundedAmountCents="
                + refundedAmountCents
                + ", status="
                + status
                + ", subtotal="
                + subtotal
                + ", taxAmount="
                + taxAmount
                + ", taxBreakdown="
                + taxBreakdown
                + ", total="
                + total
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreditNoteEventData}. */
    public static final class Builder {
        private OffsetDateTime createdAt;
        private String creditNoteId;
        private JsonField<String> creditNoteNumber = JsonField.missing();
        private Long creditedAmountCents;
        private String currency;
        private Object customProperties;
        private String customerId;
        private String invoiceId;
        private JsonField<String> invoiceNumber = JsonField.missing();
        private List<InvoiceLineItem> lineItems;
        private JsonField<String> memo = JsonField.missing();
        private JsonField<String> reason = JsonField.missing();
        private Long refundedAmountCents;
        private CreditNoteStatus status;
        private Long subtotal;
        private Long taxAmount;
        private List<TaxBreakdownItem> taxBreakdown;
        private Long total;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * The {@code credit_note_id} property.
         *
         * @param creditNoteId the value
         * @return this builder
         */
        public Builder creditNoteId(String creditNoteId) {
            this.creditNoteId = creditNoteId;
            return this;
        }

        /**
         * Absent while the credit note is a draft — the number is assigned at finalization.
         *
         * @param creditNoteNumber the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder creditNoteNumber(String creditNoteNumber) {
            this.creditNoteNumber = JsonField.ofNullable(creditNoteNumber);
            return this;
        }

        /**
         * The {@code credited_amount_cents} property.
         *
         * @param creditedAmountCents the value
         * @return this builder
         */
        public Builder creditedAmountCents(Long creditedAmountCents) {
            this.creditedAmountCents = creditedAmountCents;
            return this;
        }

        /**
         * The {@code currency} property.
         *
         * @param currency the value
         * @return this builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * User-defined custom property values, keyed by definition key.
         *
         * @param customProperties the value
         * @return this builder
         */
        public Builder customProperties(Object customProperties) {
            this.customProperties = customProperties;
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
         * The {@code invoice_id} property.
         *
         * @param invoiceId the value
         * @return this builder
         */
        public Builder invoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        /**
         * Number of the invoice being credited.
         *
         * @param invoiceNumber the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = JsonField.ofNullable(invoiceNumber);
            return this;
        }

        /**
         * Credited line items (negated amounts).
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
         * The {@code reason} property.
         *
         * @param reason the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder reason(String reason) {
            this.reason = JsonField.ofNullable(reason);
            return this;
        }

        /**
         * The {@code refunded_amount_cents} property.
         *
         * @param refundedAmountCents the value
         * @return this builder
         */
        public Builder refundedAmountCents(Long refundedAmountCents) {
            this.refundedAmountCents = refundedAmountCents;
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(CreditNoteStatus status) {
            this.status = status;
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
         * Per-rate tax (VAT) breakdown for the credited amount.
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
         * The {@code CreditNoteEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreditNoteEventData build() {
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(creditNoteId, "credit_note_id");
            Utils.checkRequired(creditedAmountCents, "credited_amount_cents");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(customProperties, "custom_properties");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(invoiceId, "invoice_id");
            Utils.checkRequired(lineItems, "line_items");
            Utils.checkRequired(refundedAmountCents, "refunded_amount_cents");
            Utils.checkRequired(status, "status");
            Utils.checkRequired(subtotal, "subtotal");
            Utils.checkRequired(taxAmount, "tax_amount");
            Utils.checkRequired(taxBreakdown, "tax_breakdown");
            Utils.checkRequired(total, "total");
            return new CreditNoteEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreditNoteEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreditNoteEventData fromJson(String json) {
        return Utils.parse(json, CreditNoteEventData.class);
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
