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
public final class SubscriptionCreateRequest {
    @JsonProperty("activation_condition")
    private SubscriptionActivationConditionEnum activationCondition;

    @JsonProperty("add_ons")
    private List<CreateSubscriptionAddOn> addOns;

    @JsonProperty("auto_advance_invoices")
    private Boolean autoAdvanceInvoices;

    @JsonProperty("backdate_invoices")
    private Boolean backdateInvoices;

    @JsonProperty("billing_day_anchor")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> billingDayAnchor = JsonField.missing();

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty("coupon_codes")
    private List<String> couponCodes;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_id_or_alias")
    private String customerIdOrAlias;

    @JsonProperty("end_date")
    private LocalDate endDate;

    @JsonProperty("invoice_memo")
    private String invoiceMemo;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("payment_methods_config")
    private PaymentMethodsConfig paymentMethodsConfig;

    @JsonProperty("plan_id")
    private String planId;

    @JsonProperty("price_components")
    private CreateSubscriptionComponents priceComponents;

    @JsonProperty("purchase_order")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> purchaseOrder = JsonField.missing();

    @JsonProperty("skip_past_invoices")
    private Boolean skipPastInvoices;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("trial_days")
    private Integer trialDays;

    @JsonProperty("version")
    private Integer version;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SubscriptionCreateRequest() {}

    private SubscriptionCreateRequest(Builder builder) {
        this.activationCondition = builder.activationCondition;
        this.addOns = Utils.copyList(builder.addOns);
        this.autoAdvanceInvoices = builder.autoAdvanceInvoices;
        this.backdateInvoices = builder.backdateInvoices;
        this.billingDayAnchor = builder.billingDayAnchor;
        this.chargeAutomatically = builder.chargeAutomatically;
        this.couponCodes = Utils.copyList(builder.couponCodes);
        this.customProperties = builder.customProperties;
        this.customerIdOrAlias = builder.customerIdOrAlias;
        this.endDate = builder.endDate;
        this.invoiceMemo = builder.invoiceMemo;
        this.netTerms = builder.netTerms;
        this.paymentMethodsConfig = builder.paymentMethodsConfig;
        this.planId = builder.planId;
        this.priceComponents = builder.priceComponents;
        this.purchaseOrder = builder.purchaseOrder;
        this.skipPastInvoices = builder.skipPastInvoices;
        this.startDate = builder.startDate;
        this.trialDays = builder.trialDays;
        this.version = builder.version;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SubscriptionCreateRequest}.
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
        builder.activationCondition = activationCondition;
        builder.addOns = Utils.mutableList(addOns);
        builder.autoAdvanceInvoices = autoAdvanceInvoices;
        builder.backdateInvoices = backdateInvoices;
        builder.billingDayAnchor = billingDayAnchor;
        builder.chargeAutomatically = chargeAutomatically;
        builder.couponCodes = Utils.mutableList(couponCodes);
        builder.customProperties = customProperties;
        builder.customerIdOrAlias = customerIdOrAlias;
        builder.endDate = endDate;
        builder.invoiceMemo = invoiceMemo;
        builder.netTerms = netTerms;
        builder.paymentMethodsConfig = paymentMethodsConfig;
        builder.planId = planId;
        builder.priceComponents = priceComponents;
        builder.purchaseOrder = purchaseOrder;
        builder.skipPastInvoices = skipPastInvoices;
        builder.startDate = startDate;
        builder.trialDays = trialDays;
        builder.version = version;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code activation_condition} property.
     *
     * @return the value, never null
     */
    public SubscriptionActivationConditionEnum activationCondition() {
        return Utils.required(activationCondition, "activation_condition");
    }

    /**
     * The {@code add_ons} property.
     *
     * @return the value, empty when unset
     */
    public Optional<List<CreateSubscriptionAddOn>> addOns() {
        return Optional.ofNullable(addOns);
    }

    /**
     * The {@code auto_advance_invoices} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> autoAdvanceInvoices() {
        return Optional.ofNullable(autoAdvanceInvoices);
    }

    /**
     * Historical import mode: when true, invoices finalized for this subscription keep their
     * billing-period date as the invoice date instead of being stamped with the emission date.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> backdateInvoices() {
        return Optional.ofNullable(backdateInvoices);
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
     * The {@code charge_automatically} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> chargeAutomatically() {
        return Optional.ofNullable(chargeAutomatically);
    }

    /**
     * The {@code coupon_codes} property.
     *
     * @return the value, empty when unset
     */
    public Optional<List<String>> couponCodes() {
        return Optional.ofNullable(couponCodes);
    }

    /**
     * User-defined custom property values, keyed by definition <code>key</code>. Validated against
     * the tenant's subscription definitions.
     *
     * @return the value, empty when unset
     */
    public Optional<Object> customProperties() {
        return Optional.ofNullable(customProperties);
    }

    /**
     * The {@code customer_id_or_alias} property.
     *
     * @return the value, never null
     */
    public String customerIdOrAlias() {
        return Utils.required(customerIdOrAlias, "customer_id_or_alias");
    }

    /**
     * The {@code end_date} property.
     *
     * @return the value, empty when unset
     */
    public Optional<LocalDate> endDate() {
        return Optional.ofNullable(endDate);
    }

    /**
     * The {@code invoice_memo} property.
     *
     * @return the value, empty when unset
     */
    public Optional<String> invoiceMemo() {
        return Optional.ofNullable(invoiceMemo);
    }

    /**
     * The {@code net_terms} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> netTerms() {
        return Optional.ofNullable(netTerms);
    }

    /**
     * Payment methods configuration. If not specified, inherits from the invoicing entity.
     *
     * @return the value, empty when unset
     */
    public Optional<PaymentMethodsConfig> paymentMethodsConfig() {
        return Optional.ofNullable(paymentMethodsConfig);
    }

    /**
     * The {@code plan_id} property.
     *
     * @return the value, never null
     */
    public String planId() {
        return Utils.required(planId, "plan_id");
    }

    /**
     * The {@code price_components} property.
     *
     * @return the value, empty when unset
     */
    public Optional<CreateSubscriptionComponents> priceComponents() {
        return Optional.ofNullable(priceComponents);
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
     * Migration mode: when true with a past start_date, skip creating invoices for past cycles. The
     * subscription will be set to the current billing period with correct cycle_index.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> skipPastInvoices() {
        return Optional.ofNullable(skipPastInvoices);
    }

    /**
     * The {@code start_date} property.
     *
     * @return the value, never null
     */
    public LocalDate startDate() {
        return Utils.required(startDate, "start_date");
    }

    /**
     * The {@code trial_days} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> trialDays() {
        return Optional.ofNullable(trialDays);
    }

    /**
     * The {@code version} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> version() {
        return Optional.ofNullable(version);
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
        SubscriptionCreateRequest that = (SubscriptionCreateRequest) o;
        return Objects.equals(activationCondition, that.activationCondition)
                && Objects.equals(addOns, that.addOns)
                && Objects.equals(autoAdvanceInvoices, that.autoAdvanceInvoices)
                && Objects.equals(backdateInvoices, that.backdateInvoices)
                && Objects.equals(billingDayAnchor, that.billingDayAnchor)
                && Objects.equals(chargeAutomatically, that.chargeAutomatically)
                && Objects.equals(couponCodes, that.couponCodes)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customerIdOrAlias, that.customerIdOrAlias)
                && Objects.equals(endDate, that.endDate)
                && Objects.equals(invoiceMemo, that.invoiceMemo)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(paymentMethodsConfig, that.paymentMethodsConfig)
                && Objects.equals(planId, that.planId)
                && Objects.equals(priceComponents, that.priceComponents)
                && Objects.equals(purchaseOrder, that.purchaseOrder)
                && Objects.equals(skipPastInvoices, that.skipPastInvoices)
                && Objects.equals(startDate, that.startDate)
                && Objects.equals(trialDays, that.trialDays)
                && Objects.equals(version, that.version)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                activationCondition,
                addOns,
                autoAdvanceInvoices,
                backdateInvoices,
                billingDayAnchor,
                chargeAutomatically,
                couponCodes,
                customProperties,
                customerIdOrAlias,
                endDate,
                invoiceMemo,
                netTerms,
                paymentMethodsConfig,
                planId,
                priceComponents,
                purchaseOrder,
                skipPastInvoices,
                startDate,
                trialDays,
                version,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "SubscriptionCreateRequest{"
                + "activationCondition="
                + activationCondition
                + ", addOns="
                + addOns
                + ", autoAdvanceInvoices="
                + autoAdvanceInvoices
                + ", backdateInvoices="
                + backdateInvoices
                + ", billingDayAnchor="
                + billingDayAnchor
                + ", chargeAutomatically="
                + chargeAutomatically
                + ", couponCodes="
                + couponCodes
                + ", customProperties="
                + customProperties
                + ", customerIdOrAlias="
                + customerIdOrAlias
                + ", endDate="
                + endDate
                + ", invoiceMemo="
                + invoiceMemo
                + ", netTerms="
                + netTerms
                + ", paymentMethodsConfig="
                + paymentMethodsConfig
                + ", planId="
                + planId
                + ", priceComponents="
                + priceComponents
                + ", purchaseOrder="
                + purchaseOrder
                + ", skipPastInvoices="
                + skipPastInvoices
                + ", startDate="
                + startDate
                + ", trialDays="
                + trialDays
                + ", version="
                + version
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SubscriptionCreateRequest}. */
    public static final class Builder {
        private SubscriptionActivationConditionEnum activationCondition;
        private List<CreateSubscriptionAddOn> addOns;
        private Boolean autoAdvanceInvoices;
        private Boolean backdateInvoices;
        private JsonField<Integer> billingDayAnchor = JsonField.missing();
        private Boolean chargeAutomatically;
        private List<String> couponCodes;
        private Object customProperties;
        private String customerIdOrAlias;
        private LocalDate endDate;
        private String invoiceMemo;
        private Integer netTerms;
        private PaymentMethodsConfig paymentMethodsConfig;
        private String planId;
        private CreateSubscriptionComponents priceComponents;
        private JsonField<String> purchaseOrder = JsonField.missing();
        private Boolean skipPastInvoices;
        private LocalDate startDate;
        private Integer trialDays;
        private Integer version;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code activation_condition} property.
         *
         * @param activationCondition the value
         * @return this builder
         */
        public Builder activationCondition(
                SubscriptionActivationConditionEnum activationCondition) {
            this.activationCondition = activationCondition;
            return this;
        }

        /**
         * The {@code add_ons} property.
         *
         * @param addOns the value
         * @return this builder
         */
        public Builder addOns(List<CreateSubscriptionAddOn> addOns) {
            this.addOns = Utils.mutableList(addOns);
            return this;
        }

        /**
         * Adds an item to {@code add_ons}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addAddOnsItem(CreateSubscriptionAddOn item) {
            if (this.addOns == null) {
                this.addOns = new ArrayList<>();
            }
            this.addOns.add(item);
            return this;
        }

        /**
         * The {@code auto_advance_invoices} property.
         *
         * @param autoAdvanceInvoices the value
         * @return this builder
         */
        public Builder autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
            this.autoAdvanceInvoices = autoAdvanceInvoices;
            return this;
        }

        /**
         * Historical import mode: when true, invoices finalized for this subscription keep their
         * billing-period date as the invoice date instead of being stamped with the emission date.
         *
         * @param backdateInvoices the value
         * @return this builder
         */
        public Builder backdateInvoices(Boolean backdateInvoices) {
            this.backdateInvoices = backdateInvoices;
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
         * The {@code charge_automatically} property.
         *
         * @param chargeAutomatically the value
         * @return this builder
         */
        public Builder chargeAutomatically(Boolean chargeAutomatically) {
            this.chargeAutomatically = chargeAutomatically;
            return this;
        }

        /**
         * The {@code coupon_codes} property.
         *
         * @param couponCodes the value
         * @return this builder
         */
        public Builder couponCodes(List<String> couponCodes) {
            this.couponCodes = Utils.mutableList(couponCodes);
            return this;
        }

        /**
         * Adds an item to {@code coupon_codes}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addCouponCodesItem(String item) {
            if (this.couponCodes == null) {
                this.couponCodes = new ArrayList<>();
            }
            this.couponCodes.add(item);
            return this;
        }

        /**
         * User-defined custom property values, keyed by definition <code>key</code>. Validated
         * against the tenant's subscription definitions.
         *
         * @param customProperties the value
         * @return this builder
         */
        public Builder customProperties(Object customProperties) {
            this.customProperties = customProperties;
            return this;
        }

        /**
         * The {@code customer_id_or_alias} property.
         *
         * @param customerIdOrAlias the value
         * @return this builder
         */
        public Builder customerIdOrAlias(String customerIdOrAlias) {
            this.customerIdOrAlias = customerIdOrAlias;
            return this;
        }

        /**
         * The {@code end_date} property.
         *
         * @param endDate the value
         * @return this builder
         */
        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        /**
         * The {@code invoice_memo} property.
         *
         * @param invoiceMemo the value
         * @return this builder
         */
        public Builder invoiceMemo(String invoiceMemo) {
            this.invoiceMemo = invoiceMemo;
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
         * Payment methods configuration. If not specified, inherits from the invoicing entity.
         *
         * @param paymentMethodsConfig the value
         * @return this builder
         */
        public Builder paymentMethodsConfig(PaymentMethodsConfig paymentMethodsConfig) {
            this.paymentMethodsConfig = paymentMethodsConfig;
            return this;
        }

        /**
         * The {@code plan_id} property.
         *
         * @param planId the value
         * @return this builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        /**
         * The {@code price_components} property.
         *
         * @param priceComponents the value
         * @return this builder
         */
        public Builder priceComponents(CreateSubscriptionComponents priceComponents) {
            this.priceComponents = priceComponents;
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
         * Migration mode: when true with a past start_date, skip creating invoices for past cycles.
         * The subscription will be set to the current billing period with correct cycle_index.
         *
         * @param skipPastInvoices the value
         * @return this builder
         */
        public Builder skipPastInvoices(Boolean skipPastInvoices) {
            this.skipPastInvoices = skipPastInvoices;
            return this;
        }

        /**
         * The {@code start_date} property.
         *
         * @param startDate the value
         * @return this builder
         */
        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * The {@code trial_days} property.
         *
         * @param trialDays the value
         * @return this builder
         */
        public Builder trialDays(Integer trialDays) {
            this.trialDays = trialDays;
            return this;
        }

        /**
         * The {@code version} property.
         *
         * @param version the value
         * @return this builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * The {@code SubscriptionCreateRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SubscriptionCreateRequest build() {
            Utils.checkRequired(activationCondition, "activation_condition");
            Utils.checkRequired(customerIdOrAlias, "customer_id_or_alias");
            Utils.checkRequired(planId, "plan_id");
            Utils.checkRequired(startDate, "start_date");
            return new SubscriptionCreateRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code SubscriptionCreateRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SubscriptionCreateRequest fromJson(String json) {
        return Utils.parse(json, SubscriptionCreateRequest.class);
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
