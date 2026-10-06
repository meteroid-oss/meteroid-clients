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
import java.util.Collections;
import java.util.LinkedHashMap;
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
public final class InvoiceEventData {
    @JsonProperty("consolidated_into_invoice_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> consolidatedIntoInvoiceId = JsonField.missing();

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

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

    @JsonProperty("parent_invoice_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> parentInvoiceId = JsonField.missing();

    @JsonProperty("status")
    private InvoiceStatus status;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("total")
    private Long total;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private InvoiceEventData() {}

    private InvoiceEventData(Builder builder) {
        this.consolidatedIntoInvoiceId = builder.consolidatedIntoInvoiceId;
        this.createdAt = builder.createdAt;
        this.currency = builder.currency;
        this.customProperties = builder.customProperties;
        this.customerId = builder.customerId;
        this.invoiceId = builder.invoiceId;
        this.invoiceNumber = builder.invoiceNumber;
        this.parentInvoiceId = builder.parentInvoiceId;
        this.status = builder.status;
        this.taxAmount = builder.taxAmount;
        this.total = builder.total;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code InvoiceEventData}.
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
        builder.consolidatedIntoInvoiceId = consolidatedIntoInvoiceId;
        builder.createdAt = createdAt;
        builder.currency = currency;
        builder.customProperties = customProperties;
        builder.customerId = customerId;
        builder.invoiceId = invoiceId;
        builder.invoiceNumber = invoiceNumber;
        builder.parentInvoiceId = parentInvoiceId;
        builder.status = status;
        builder.taxAmount = taxAmount;
        builder.total = total;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code consolidated_into_invoice_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> consolidatedIntoInvoiceId() {
        return consolidatedIntoInvoiceId.asOptional();
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
     * Absent while the invoice is a draft — the number is assigned at finalization.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> invoiceNumber() {
        return invoiceNumber.asOptional();
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
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public InvoiceStatus status() {
        return Utils.required(status, "status");
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
        InvoiceEventData that = (InvoiceEventData) o;
        return Objects.equals(consolidatedIntoInvoiceId, that.consolidatedIntoInvoiceId)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(currency, that.currency)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(invoiceId, that.invoiceId)
                && Objects.equals(invoiceNumber, that.invoiceNumber)
                && Objects.equals(parentInvoiceId, that.parentInvoiceId)
                && Objects.equals(status, that.status)
                && Objects.equals(taxAmount, that.taxAmount)
                && Objects.equals(total, that.total)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                consolidatedIntoInvoiceId,
                createdAt,
                currency,
                customProperties,
                customerId,
                invoiceId,
                invoiceNumber,
                parentInvoiceId,
                status,
                taxAmount,
                total,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "InvoiceEventData{"
                + "consolidatedIntoInvoiceId="
                + consolidatedIntoInvoiceId
                + ", createdAt="
                + createdAt
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
                + ", parentInvoiceId="
                + parentInvoiceId
                + ", status="
                + status
                + ", taxAmount="
                + taxAmount
                + ", total="
                + total
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link InvoiceEventData}. */
    public static final class Builder {
        private JsonField<String> consolidatedIntoInvoiceId = JsonField.missing();
        private OffsetDateTime createdAt;
        private String currency;
        private Object customProperties;
        private String customerId;
        private String invoiceId;
        private JsonField<String> invoiceNumber = JsonField.missing();
        private JsonField<String> parentInvoiceId = JsonField.missing();
        private InvoiceStatus status;
        private Long taxAmount;
        private Long total;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code consolidated_into_invoice_id} property.
         *
         * @param consolidatedIntoInvoiceId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder consolidatedIntoInvoiceId(String consolidatedIntoInvoiceId) {
            this.consolidatedIntoInvoiceId = JsonField.ofNullable(consolidatedIntoInvoiceId);
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
         * Absent while the invoice is a draft — the number is assigned at finalization.
         *
         * @param invoiceNumber the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = JsonField.ofNullable(invoiceNumber);
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
         * The {@code InvoiceEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public InvoiceEventData build() {
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(customProperties, "custom_properties");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(invoiceId, "invoice_id");
            Utils.checkRequired(status, "status");
            Utils.checkRequired(taxAmount, "tax_amount");
            Utils.checkRequired(total, "total");
            return new InvoiceEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code InvoiceEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static InvoiceEventData fromJson(String json) {
        return Utils.parse(json, InvoiceEventData.class);
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
