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

import java.math.BigDecimal;
import java.time.LocalDate;
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
public final class CreateCheckoutSessionRequest {
    @JsonProperty("add_ons")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<CreateSubscriptionAddOn>> addOns = JsonField.missing();

    @JsonProperty("auto_advance_invoices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> autoAdvanceInvoices = JsonField.missing();

    @JsonProperty("billing_day_anchor")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> billingDayAnchor = JsonField.missing();

    @JsonProperty("billing_start_date")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> billingStartDate = JsonField.missing();

    @JsonProperty("cancel_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cancelUrl = JsonField.missing();

    @JsonProperty("charge_automatically")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> chargeAutomatically = JsonField.missing();

    @JsonProperty("components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<CreateSubscriptionComponents> components = JsonField.missing();

    @JsonProperty("coupon_code")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> couponCode = JsonField.missing();

    @JsonProperty("coupon_ids")
    private List<String> couponIds;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("end_date")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> endDate = JsonField.missing();

    @JsonProperty("expires_in_hours")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> expiresInHours = JsonField.missing();

    @JsonProperty("invoice_memo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoiceMemo = JsonField.missing();

    @JsonProperty("invoice_threshold")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BigDecimal> invoiceThreshold = JsonField.missing();

    @JsonProperty("metadata")
    private Object metadata;

    @JsonProperty("net_terms")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> netTerms = JsonField.missing();

    @JsonProperty("payment_methods_config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();

    @JsonProperty("plan_version_id")
    private String planVersionId;

    @JsonProperty("purchase_order")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> purchaseOrder = JsonField.missing();

    @JsonProperty("success_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> successUrl = JsonField.missing();

    @JsonProperty("trial_duration_days")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> trialDurationDays = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateCheckoutSessionRequest() {}

    private CreateCheckoutSessionRequest(Builder builder) {
        this.addOns = builder.addOns.map(Utils::copyList);
        this.autoAdvanceInvoices = builder.autoAdvanceInvoices;
        this.billingDayAnchor = builder.billingDayAnchor;
        this.billingStartDate = builder.billingStartDate;
        this.cancelUrl = builder.cancelUrl;
        this.chargeAutomatically = builder.chargeAutomatically;
        this.components = builder.components;
        this.couponCode = builder.couponCode;
        this.couponIds = Utils.copyList(builder.couponIds);
        this.customerId = builder.customerId;
        this.endDate = builder.endDate;
        this.expiresInHours = builder.expiresInHours;
        this.invoiceMemo = builder.invoiceMemo;
        this.invoiceThreshold = builder.invoiceThreshold;
        this.metadata = builder.metadata;
        this.netTerms = builder.netTerms;
        this.paymentMethodsConfig = builder.paymentMethodsConfig;
        this.planVersionId = builder.planVersionId;
        this.purchaseOrder = builder.purchaseOrder;
        this.successUrl = builder.successUrl;
        this.trialDurationDays = builder.trialDurationDays;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateCheckoutSessionRequest}.
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
        builder.addOns = addOns.map(Utils::mutableList);
        builder.autoAdvanceInvoices = autoAdvanceInvoices;
        builder.billingDayAnchor = billingDayAnchor;
        builder.billingStartDate = billingStartDate;
        builder.cancelUrl = cancelUrl;
        builder.chargeAutomatically = chargeAutomatically;
        builder.components = components;
        builder.couponCode = couponCode;
        builder.couponIds = Utils.mutableList(couponIds);
        builder.customerId = customerId;
        builder.endDate = endDate;
        builder.expiresInHours = expiresInHours;
        builder.invoiceMemo = invoiceMemo;
        builder.invoiceThreshold = invoiceThreshold;
        builder.metadata = metadata;
        builder.netTerms = netTerms;
        builder.paymentMethodsConfig = paymentMethodsConfig;
        builder.planVersionId = planVersionId;
        builder.purchaseOrder = purchaseOrder;
        builder.successUrl = successUrl;
        builder.trialDurationDays = trialDurationDays;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code add_ons} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<CreateSubscriptionAddOn>> addOns() {
        return addOns.asOptional();
    }

    /**
     * If false, invoices will stay in Draft until manually reviewed and finalized. Default is true.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> autoAdvanceInvoices() {
        return autoAdvanceInvoices.asOptional();
    }

    /**
     * The {@code billing_day_anchor} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> billingDayAnchor() {
        return billingDayAnchor.asOptional();
    }

    /**
     * The {@code billing_start_date} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> billingStartDate() {
        return billingStartDate.asOptional();
    }

    /**
     * Absolute http(s) URL offered to the customer to leave the checkout without paying.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> cancelUrl() {
        return cancelUrl.asOptional();
    }

    /**
     * Automatically try to charge the customer's configured payment method on finalize. Default is
     * true.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> chargeAutomatically() {
        return chargeAutomatically.asOptional();
    }

    /**
     * The {@code components} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<CreateSubscriptionComponents> components() {
        return components.asOptional();
    }

    /**
     * The {@code coupon_code} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> couponCode() {
        return couponCode.asOptional();
    }

    /**
     * The {@code coupon_ids} property.
     *
     * @return the value, empty when unset
     */
    public Optional<List<String>> couponIds() {
        return Optional.ofNullable(couponIds);
    }

    /**
     * Customer ID or alias
     *
     * @return the value, never null
     */
    public String customerId() {
        return Utils.required(customerId, "customer_id");
    }

    /**
     * The {@code end_date} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> endDate() {
        return endDate.asOptional();
    }

    /**
     * Session expiry time in hours. Default is 1 hour for self-serve checkout.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> expiresInHours() {
        return expiresInHours.asOptional();
    }

    /**
     * The {@code invoice_memo} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> invoiceMemo() {
        return invoiceMemo.asOptional();
    }

    /**
     * The {@code invoice_threshold} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BigDecimal> invoiceThreshold() {
        return invoiceThreshold.asOptional();
    }

    /**
     * The {@code metadata} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Object> metadata() {
        return Optional.ofNullable(metadata);
    }

    /**
     * The {@code net_terms} property.
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
     * The {@code plan_version_id} property.
     *
     * @return the value, never null
     */
    public String planVersionId() {
        return Utils.required(planVersionId, "plan_version_id");
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
     * Absolute http(s) URL the customer is sent to after a successful checkout. <code>
     * checkout_session_id</code> is appended as a query parameter. Without it the customer stays on
     * the hosted confirmation page.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> successUrl() {
        return successUrl.asOptional();
    }

    /**
     * The {@code trial_duration_days} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> trialDurationDays() {
        return trialDurationDays.asOptional();
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
        CreateCheckoutSessionRequest that = (CreateCheckoutSessionRequest) o;
        return Objects.equals(addOns, that.addOns)
                && Objects.equals(autoAdvanceInvoices, that.autoAdvanceInvoices)
                && Objects.equals(billingDayAnchor, that.billingDayAnchor)
                && Objects.equals(billingStartDate, that.billingStartDate)
                && Objects.equals(cancelUrl, that.cancelUrl)
                && Objects.equals(chargeAutomatically, that.chargeAutomatically)
                && Objects.equals(components, that.components)
                && Objects.equals(couponCode, that.couponCode)
                && Objects.equals(couponIds, that.couponIds)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(endDate, that.endDate)
                && Objects.equals(expiresInHours, that.expiresInHours)
                && Objects.equals(invoiceMemo, that.invoiceMemo)
                && Objects.equals(invoiceThreshold, that.invoiceThreshold)
                && Objects.equals(metadata, that.metadata)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(paymentMethodsConfig, that.paymentMethodsConfig)
                && Objects.equals(planVersionId, that.planVersionId)
                && Objects.equals(purchaseOrder, that.purchaseOrder)
                && Objects.equals(successUrl, that.successUrl)
                && Objects.equals(trialDurationDays, that.trialDurationDays)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                addOns,
                autoAdvanceInvoices,
                billingDayAnchor,
                billingStartDate,
                cancelUrl,
                chargeAutomatically,
                components,
                couponCode,
                couponIds,
                customerId,
                endDate,
                expiresInHours,
                invoiceMemo,
                invoiceThreshold,
                metadata,
                netTerms,
                paymentMethodsConfig,
                planVersionId,
                purchaseOrder,
                successUrl,
                trialDurationDays,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateCheckoutSessionRequest{"
                + "addOns="
                + addOns
                + ", autoAdvanceInvoices="
                + autoAdvanceInvoices
                + ", billingDayAnchor="
                + billingDayAnchor
                + ", billingStartDate="
                + billingStartDate
                + ", cancelUrl="
                + cancelUrl
                + ", chargeAutomatically="
                + chargeAutomatically
                + ", components="
                + components
                + ", couponCode="
                + couponCode
                + ", couponIds="
                + couponIds
                + ", customerId="
                + customerId
                + ", endDate="
                + endDate
                + ", expiresInHours="
                + expiresInHours
                + ", invoiceMemo="
                + invoiceMemo
                + ", invoiceThreshold="
                + invoiceThreshold
                + ", metadata="
                + metadata
                + ", netTerms="
                + netTerms
                + ", paymentMethodsConfig="
                + paymentMethodsConfig
                + ", planVersionId="
                + planVersionId
                + ", purchaseOrder="
                + purchaseOrder
                + ", successUrl="
                + successUrl
                + ", trialDurationDays="
                + trialDurationDays
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateCheckoutSessionRequest}. */
    public static final class Builder {
        private JsonField<List<CreateSubscriptionAddOn>> addOns = JsonField.missing();
        private JsonField<Boolean> autoAdvanceInvoices = JsonField.missing();
        private JsonField<Integer> billingDayAnchor = JsonField.missing();
        private JsonField<LocalDate> billingStartDate = JsonField.missing();
        private JsonField<String> cancelUrl = JsonField.missing();
        private JsonField<Boolean> chargeAutomatically = JsonField.missing();
        private JsonField<CreateSubscriptionComponents> components = JsonField.missing();
        private JsonField<String> couponCode = JsonField.missing();
        private List<String> couponIds;
        private String customerId;
        private JsonField<LocalDate> endDate = JsonField.missing();
        private JsonField<Integer> expiresInHours = JsonField.missing();
        private JsonField<String> invoiceMemo = JsonField.missing();
        private JsonField<BigDecimal> invoiceThreshold = JsonField.missing();
        private Object metadata;
        private JsonField<Integer> netTerms = JsonField.missing();
        private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();
        private String planVersionId;
        private JsonField<String> purchaseOrder = JsonField.missing();
        private JsonField<String> successUrl = JsonField.missing();
        private JsonField<Integer> trialDurationDays = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code add_ons} property.
         *
         * @param addOns the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder addOns(List<CreateSubscriptionAddOn> addOns) {
            this.addOns = JsonField.ofNullable(Utils.mutableList(addOns));
            return this;
        }

        /**
         * Adds an item to {@code add_ons}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addAddOnsItem(CreateSubscriptionAddOn item) {
            List<CreateSubscriptionAddOn> items = this.addOns.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.addOns = JsonField.ofNullable(items);
            }
            items.add(item);
            return this;
        }

        /**
         * If false, invoices will stay in Draft until manually reviewed and finalized. Default is
         * true.
         *
         * @param autoAdvanceInvoices the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
            this.autoAdvanceInvoices = JsonField.ofNullable(autoAdvanceInvoices);
            return this;
        }

        /**
         * The {@code billing_day_anchor} property.
         *
         * @param billingDayAnchor the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingDayAnchor(Integer billingDayAnchor) {
            this.billingDayAnchor = JsonField.ofNullable(billingDayAnchor);
            return this;
        }

        /**
         * The {@code billing_start_date} property.
         *
         * @param billingStartDate the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingStartDate(LocalDate billingStartDate) {
            this.billingStartDate = JsonField.ofNullable(billingStartDate);
            return this;
        }

        /**
         * Absolute http(s) URL offered to the customer to leave the checkout without paying.
         *
         * @param cancelUrl the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder cancelUrl(String cancelUrl) {
            this.cancelUrl = JsonField.ofNullable(cancelUrl);
            return this;
        }

        /**
         * Automatically try to charge the customer's configured payment method on finalize. Default
         * is true.
         *
         * @param chargeAutomatically the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder chargeAutomatically(Boolean chargeAutomatically) {
            this.chargeAutomatically = JsonField.ofNullable(chargeAutomatically);
            return this;
        }

        /**
         * The {@code components} property.
         *
         * @param components the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder components(CreateSubscriptionComponents components) {
            this.components = JsonField.ofNullable(components);
            return this;
        }

        /**
         * The {@code coupon_code} property.
         *
         * @param couponCode the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder couponCode(String couponCode) {
            this.couponCode = JsonField.ofNullable(couponCode);
            return this;
        }

        /**
         * The {@code coupon_ids} property.
         *
         * @param couponIds the value
         * @return this builder
         */
        public Builder couponIds(List<String> couponIds) {
            this.couponIds = Utils.mutableList(couponIds);
            return this;
        }

        /**
         * Adds an item to {@code coupon_ids}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addCouponIdsItem(String item) {
            if (this.couponIds == null) {
                this.couponIds = new ArrayList<>();
            }
            this.couponIds.add(item);
            return this;
        }

        /**
         * Customer ID or alias
         *
         * @param customerId the value
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * The {@code end_date} property.
         *
         * @param endDate the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder endDate(LocalDate endDate) {
            this.endDate = JsonField.ofNullable(endDate);
            return this;
        }

        /**
         * Session expiry time in hours. Default is 1 hour for self-serve checkout.
         *
         * @param expiresInHours the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder expiresInHours(Integer expiresInHours) {
            this.expiresInHours = JsonField.ofNullable(expiresInHours);
            return this;
        }

        /**
         * The {@code invoice_memo} property.
         *
         * @param invoiceMemo the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder invoiceMemo(String invoiceMemo) {
            this.invoiceMemo = JsonField.ofNullable(invoiceMemo);
            return this;
        }

        /**
         * The {@code invoice_threshold} property.
         *
         * @param invoiceThreshold the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder invoiceThreshold(BigDecimal invoiceThreshold) {
            this.invoiceThreshold = JsonField.ofNullable(invoiceThreshold);
            return this;
        }

        /**
         * The {@code metadata} property.
         *
         * @param metadata the value
         * @return this builder
         */
        public Builder metadata(Object metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * The {@code net_terms} property.
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
         * The {@code plan_version_id} property.
         *
         * @param planVersionId the value
         * @return this builder
         */
        public Builder planVersionId(String planVersionId) {
            this.planVersionId = planVersionId;
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
         * Absolute http(s) URL the customer is sent to after a successful checkout. <code>
         * checkout_session_id</code> is appended as a query parameter. Without it the customer
         * stays on the hosted confirmation page.
         *
         * @param successUrl the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder successUrl(String successUrl) {
            this.successUrl = JsonField.ofNullable(successUrl);
            return this;
        }

        /**
         * The {@code trial_duration_days} property.
         *
         * @param trialDurationDays the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder trialDurationDays(Integer trialDurationDays) {
            this.trialDurationDays = JsonField.ofNullable(trialDurationDays);
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
         * The {@code CreateCheckoutSessionRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateCheckoutSessionRequest build() {
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(planVersionId, "plan_version_id");
            return new CreateCheckoutSessionRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateCheckoutSessionRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateCheckoutSessionRequest fromJson(String json) {
        return Utils.parse(json, CreateCheckoutSessionRequest.class);
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
