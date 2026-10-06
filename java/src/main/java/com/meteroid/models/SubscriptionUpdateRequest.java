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
public final class SubscriptionUpdateRequest {
    @JsonProperty("auto_advance_invoices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> autoAdvanceInvoices = JsonField.missing();

    @JsonProperty("charge_automatically")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> chargeAutomatically = JsonField.missing();

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("invoice_memo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoiceMemo = JsonField.missing();

    @JsonProperty("net_terms")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> netTerms = JsonField.missing();

    @JsonProperty("payment_methods_config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();

    @JsonProperty("purchase_order")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> purchaseOrder = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SubscriptionUpdateRequest() {}

    private SubscriptionUpdateRequest(Builder builder) {
        this.autoAdvanceInvoices = builder.autoAdvanceInvoices;
        this.chargeAutomatically = builder.chargeAutomatically;
        this.customProperties = builder.customProperties;
        this.invoiceMemo = builder.invoiceMemo;
        this.netTerms = builder.netTerms;
        this.paymentMethodsConfig = builder.paymentMethodsConfig;
        this.purchaseOrder = builder.purchaseOrder;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SubscriptionUpdateRequest}.
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
        builder.autoAdvanceInvoices = autoAdvanceInvoices;
        builder.chargeAutomatically = chargeAutomatically;
        builder.customProperties = customProperties;
        builder.invoiceMemo = invoiceMemo;
        builder.netTerms = netTerms;
        builder.paymentMethodsConfig = paymentMethodsConfig;
        builder.purchaseOrder = purchaseOrder;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * If false, invoices will stay in Draft until manually reviewed and finalized.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> autoAdvanceInvoices() {
        return autoAdvanceInvoices.asOptional();
    }

    /**
     * Automatically try to charge the customer's configured payment method on finalize.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> chargeAutomatically() {
        return chargeAutomatically.asOptional();
    }

    /**
     * Partial update of custom property values (merge; send a key with <code>null</code> to remove
     * it). Validated against the tenant's <code>SUBSCRIPTION</code> property definitions. Omit to
     * leave unchanged.
     *
     * @return the value, empty when unset
     */
    public Optional<Object> customProperties() {
        return Optional.ofNullable(customProperties);
    }

    /**
     * Default memo for invoices
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> invoiceMemo() {
        return invoiceMemo.asOptional();
    }

    /**
     * Payment terms in days (0 = due on issue)
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> netTerms() {
        return netTerms.asOptional();
    }

    /**
     * The {@code payment_methods_config} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<PaymentMethodsConfig> paymentMethodsConfig() {
        return paymentMethodsConfig.asOptional();
    }

    /**
     * Purchase order number
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> purchaseOrder() {
        return purchaseOrder.asOptional();
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
        SubscriptionUpdateRequest that = (SubscriptionUpdateRequest) o;
        return Objects.equals(autoAdvanceInvoices, that.autoAdvanceInvoices)
                && Objects.equals(chargeAutomatically, that.chargeAutomatically)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(invoiceMemo, that.invoiceMemo)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(paymentMethodsConfig, that.paymentMethodsConfig)
                && Objects.equals(purchaseOrder, that.purchaseOrder)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                autoAdvanceInvoices,
                chargeAutomatically,
                customProperties,
                invoiceMemo,
                netTerms,
                paymentMethodsConfig,
                purchaseOrder,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "SubscriptionUpdateRequest{"
                + "autoAdvanceInvoices="
                + autoAdvanceInvoices
                + ", chargeAutomatically="
                + chargeAutomatically
                + ", customProperties="
                + customProperties
                + ", invoiceMemo="
                + invoiceMemo
                + ", netTerms="
                + netTerms
                + ", paymentMethodsConfig="
                + paymentMethodsConfig
                + ", purchaseOrder="
                + purchaseOrder
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SubscriptionUpdateRequest}. */
    public static final class Builder {
        private JsonField<Boolean> autoAdvanceInvoices = JsonField.missing();
        private JsonField<Boolean> chargeAutomatically = JsonField.missing();
        private Object customProperties;
        private JsonField<String> invoiceMemo = JsonField.missing();
        private JsonField<Integer> netTerms = JsonField.missing();
        private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();
        private JsonField<String> purchaseOrder = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * If false, invoices will stay in Draft until manually reviewed and finalized.
         *
         * @param autoAdvanceInvoices the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
            this.autoAdvanceInvoices = JsonField.ofNullable(autoAdvanceInvoices);
            return this;
        }

        /**
         * Automatically try to charge the customer's configured payment method on finalize.
         *
         * @param chargeAutomatically the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder chargeAutomatically(Boolean chargeAutomatically) {
            this.chargeAutomatically = JsonField.ofNullable(chargeAutomatically);
            return this;
        }

        /**
         * Partial update of custom property values (merge; send a key with <code>null</code> to
         * remove it). Validated against the tenant's <code>SUBSCRIPTION</code> property
         * definitions. Omit to leave unchanged.
         *
         * @param customProperties the value
         * @return this builder
         */
        public Builder customProperties(Object customProperties) {
            this.customProperties = customProperties;
            return this;
        }

        /**
         * Default memo for invoices
         *
         * @param invoiceMemo the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder invoiceMemo(String invoiceMemo) {
            this.invoiceMemo = JsonField.ofNullable(invoiceMemo);
            return this;
        }

        /**
         * Payment terms in days (0 = due on issue)
         *
         * @param netTerms the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder netTerms(Integer netTerms) {
            this.netTerms = JsonField.ofNullable(netTerms);
            return this;
        }

        /**
         * The {@code payment_methods_config} property.
         *
         * @param paymentMethodsConfig the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder paymentMethodsConfig(PaymentMethodsConfig paymentMethodsConfig) {
            this.paymentMethodsConfig = JsonField.ofNullable(paymentMethodsConfig);
            return this;
        }

        /**
         * Purchase order number
         *
         * @param purchaseOrder the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder purchaseOrder(String purchaseOrder) {
            this.purchaseOrder = JsonField.ofNullable(purchaseOrder);
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
         * The {@code SubscriptionUpdateRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SubscriptionUpdateRequest build() {
            return new SubscriptionUpdateRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code SubscriptionUpdateRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SubscriptionUpdateRequest fromJson(String json) {
        return Utils.parse(json, SubscriptionUpdateRequest.class);
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
