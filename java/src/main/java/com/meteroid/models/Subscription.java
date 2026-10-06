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
public final class Subscription {
    @JsonProperty("activated_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> activatedAt = JsonField.missing();

    @JsonProperty("auto_advance_invoices")
    private Boolean autoAdvanceInvoices;

    @JsonProperty("billing_day_anchor")
    private Integer billingDayAnchor;

    @JsonProperty("billing_start_date")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> billingStartDate = JsonField.missing();

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("current_period_end")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> currentPeriodEnd = JsonField.missing();

    @JsonProperty("current_period_start")
    private LocalDate currentPeriodStart;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_alias")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> customerAlias = JsonField.missing();

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("end_date")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> endDate = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("invoice_memo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoiceMemo = JsonField.missing();

    @JsonProperty("mrr_cents")
    private Long mrrCents;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("payment_methods_config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();

    @JsonProperty("period")
    private BillingPeriodEnum period;

    @JsonProperty("plan_description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> planDescription = JsonField.missing();

    @JsonProperty("plan_id")
    private String planId;

    @JsonProperty("plan_name")
    private String planName;

    @JsonProperty("plan_version")
    private Integer planVersion;

    @JsonProperty("plan_version_id")
    private String planVersionId;

    @JsonProperty("purchase_order")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> purchaseOrder = JsonField.missing();

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("status")
    private SubscriptionStatusEnum status;

    @JsonProperty("trial_duration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> trialDuration = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Subscription() {}

    private Subscription(Builder builder) {
        this.activatedAt = builder.activatedAt;
        this.autoAdvanceInvoices = builder.autoAdvanceInvoices;
        this.billingDayAnchor = builder.billingDayAnchor;
        this.billingStartDate = builder.billingStartDate;
        this.chargeAutomatically = builder.chargeAutomatically;
        this.createdAt = builder.createdAt;
        this.currency = builder.currency;
        this.currentPeriodEnd = builder.currentPeriodEnd;
        this.currentPeriodStart = builder.currentPeriodStart;
        this.customProperties = builder.customProperties;
        this.customerAlias = builder.customerAlias;
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.endDate = builder.endDate;
        this.id = builder.id;
        this.invoiceMemo = builder.invoiceMemo;
        this.mrrCents = builder.mrrCents;
        this.netTerms = builder.netTerms;
        this.paymentMethodsConfig = builder.paymentMethodsConfig;
        this.period = builder.period;
        this.planDescription = builder.planDescription;
        this.planId = builder.planId;
        this.planName = builder.planName;
        this.planVersion = builder.planVersion;
        this.planVersionId = builder.planVersionId;
        this.purchaseOrder = builder.purchaseOrder;
        this.startDate = builder.startDate;
        this.status = builder.status;
        this.trialDuration = builder.trialDuration;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Subscription}.
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
        builder.activatedAt = activatedAt;
        builder.autoAdvanceInvoices = autoAdvanceInvoices;
        builder.billingDayAnchor = billingDayAnchor;
        builder.billingStartDate = billingStartDate;
        builder.chargeAutomatically = chargeAutomatically;
        builder.createdAt = createdAt;
        builder.currency = currency;
        builder.currentPeriodEnd = currentPeriodEnd;
        builder.currentPeriodStart = currentPeriodStart;
        builder.customProperties = customProperties;
        builder.customerAlias = customerAlias;
        builder.customerId = customerId;
        builder.customerName = customerName;
        builder.endDate = endDate;
        builder.id = id;
        builder.invoiceMemo = invoiceMemo;
        builder.mrrCents = mrrCents;
        builder.netTerms = netTerms;
        builder.paymentMethodsConfig = paymentMethodsConfig;
        builder.period = period;
        builder.planDescription = planDescription;
        builder.planId = planId;
        builder.planName = planName;
        builder.planVersion = planVersion;
        builder.planVersionId = planVersionId;
        builder.purchaseOrder = purchaseOrder;
        builder.startDate = startDate;
        builder.status = status;
        builder.trialDuration = trialDuration;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * When the subscription was activated (first payment or activation condition met)
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> activatedAt() {
        return activatedAt.asOptional();
    }

    /**
     * If false, invoices will stay in Draft until manually reviewed and finalized. Default to true.
     *
     * @return the value, never null
     */
    public Boolean autoAdvanceInvoices() {
        return Utils.required(autoAdvanceInvoices, "auto_advance_invoices");
    }

    /**
     * The {@code billing_day_anchor} property.
     *
     * @return the value, never null
     */
    public Integer billingDayAnchor() {
        return Utils.required(billingDayAnchor, "billing_day_anchor");
    }

    /**
     * When billing started (after any trial period)
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> billingStartDate() {
        return billingStartDate.asOptional();
    }

    /**
     * Automatically try to charge the customer's configured payment method on finalize.
     *
     * @return the value, never null
     */
    public Boolean chargeAutomatically() {
        return Utils.required(chargeAutomatically, "charge_automatically");
    }

    /**
     * When the subscription was created
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
     * Current billing period end date
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> currentPeriodEnd() {
        return currentPeriodEnd.asOptional();
    }

    /**
     * Current billing period start date
     *
     * @return the value, never null
     */
    public LocalDate currentPeriodStart() {
        return Utils.required(currentPeriodStart, "current_period_start");
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
     * The {@code customer_alias} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> customerAlias() {
        return customerAlias.asOptional();
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
     * The {@code customer_name} property.
     *
     * @return the value, never null
     */
    public String customerName() {
        return Utils.required(customerName, "customer_name");
    }

    /**
     * When the subscription ends (if set)
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> endDate() {
        return endDate.asOptional();
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
     * Default memo for invoices
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> invoiceMemo() {
        return invoiceMemo.asOptional();
    }

    /**
     * Monthly recurring revenue in cents
     *
     * @return the value, never null
     */
    public Long mrrCents() {
        return Utils.required(mrrCents, "mrr_cents");
    }

    /**
     * Payment terms in days (0 = due on issue)
     *
     * @return the value, never null
     */
    public Integer netTerms() {
        return Utils.required(netTerms, "net_terms");
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
     * Billing period (monthly, annual, etc.)
     *
     * @return the value, never null
     */
    public BillingPeriodEnum period() {
        return Utils.required(period, "period");
    }

    /**
     * The {@code plan_description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> planDescription() {
        return planDescription.asOptional();
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
     * The {@code plan_name} property.
     *
     * @return the value, never null
     */
    public String planName() {
        return Utils.required(planName, "plan_name");
    }

    /**
     * The {@code plan_version} property.
     *
     * @return the value, never null
     */
    public Integer planVersion() {
        return Utils.required(planVersion, "plan_version");
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
     * When the subscription contract starts (benefits apply from this date)
     *
     * @return the value, never null
     */
    public LocalDate startDate() {
        return Utils.required(startDate, "start_date");
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public SubscriptionStatusEnum status() {
        return Utils.required(status, "status");
    }

    /**
     * Trial duration in days
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> trialDuration() {
        return trialDuration.asOptional();
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
        Subscription that = (Subscription) o;
        return Objects.equals(activatedAt, that.activatedAt)
                && Objects.equals(autoAdvanceInvoices, that.autoAdvanceInvoices)
                && Objects.equals(billingDayAnchor, that.billingDayAnchor)
                && Objects.equals(billingStartDate, that.billingStartDate)
                && Objects.equals(chargeAutomatically, that.chargeAutomatically)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(currency, that.currency)
                && Objects.equals(currentPeriodEnd, that.currentPeriodEnd)
                && Objects.equals(currentPeriodStart, that.currentPeriodStart)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customerAlias, that.customerAlias)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(customerName, that.customerName)
                && Objects.equals(endDate, that.endDate)
                && Objects.equals(id, that.id)
                && Objects.equals(invoiceMemo, that.invoiceMemo)
                && Objects.equals(mrrCents, that.mrrCents)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(paymentMethodsConfig, that.paymentMethodsConfig)
                && Objects.equals(period, that.period)
                && Objects.equals(planDescription, that.planDescription)
                && Objects.equals(planId, that.planId)
                && Objects.equals(planName, that.planName)
                && Objects.equals(planVersion, that.planVersion)
                && Objects.equals(planVersionId, that.planVersionId)
                && Objects.equals(purchaseOrder, that.purchaseOrder)
                && Objects.equals(startDate, that.startDate)
                && Objects.equals(status, that.status)
                && Objects.equals(trialDuration, that.trialDuration)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                activatedAt,
                autoAdvanceInvoices,
                billingDayAnchor,
                billingStartDate,
                chargeAutomatically,
                createdAt,
                currency,
                currentPeriodEnd,
                currentPeriodStart,
                customProperties,
                customerAlias,
                customerId,
                customerName,
                endDate,
                id,
                invoiceMemo,
                mrrCents,
                netTerms,
                paymentMethodsConfig,
                period,
                planDescription,
                planId,
                planName,
                planVersion,
                planVersionId,
                purchaseOrder,
                startDate,
                status,
                trialDuration,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "Subscription{"
                + "activatedAt="
                + activatedAt
                + ", autoAdvanceInvoices="
                + autoAdvanceInvoices
                + ", billingDayAnchor="
                + billingDayAnchor
                + ", billingStartDate="
                + billingStartDate
                + ", chargeAutomatically="
                + chargeAutomatically
                + ", createdAt="
                + createdAt
                + ", currency="
                + currency
                + ", currentPeriodEnd="
                + currentPeriodEnd
                + ", currentPeriodStart="
                + currentPeriodStart
                + ", customProperties="
                + customProperties
                + ", customerAlias="
                + customerAlias
                + ", customerId="
                + customerId
                + ", customerName="
                + customerName
                + ", endDate="
                + endDate
                + ", id="
                + id
                + ", invoiceMemo="
                + invoiceMemo
                + ", mrrCents="
                + mrrCents
                + ", netTerms="
                + netTerms
                + ", paymentMethodsConfig="
                + paymentMethodsConfig
                + ", period="
                + period
                + ", planDescription="
                + planDescription
                + ", planId="
                + planId
                + ", planName="
                + planName
                + ", planVersion="
                + planVersion
                + ", planVersionId="
                + planVersionId
                + ", purchaseOrder="
                + purchaseOrder
                + ", startDate="
                + startDate
                + ", status="
                + status
                + ", trialDuration="
                + trialDuration
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Subscription}. */
    public static final class Builder {
        private JsonField<OffsetDateTime> activatedAt = JsonField.missing();
        private Boolean autoAdvanceInvoices;
        private Integer billingDayAnchor;
        private JsonField<LocalDate> billingStartDate = JsonField.missing();
        private Boolean chargeAutomatically;
        private OffsetDateTime createdAt;
        private Currency currency;
        private JsonField<LocalDate> currentPeriodEnd = JsonField.missing();
        private LocalDate currentPeriodStart;
        private Object customProperties;
        private JsonField<String> customerAlias = JsonField.missing();
        private String customerId;
        private String customerName;
        private JsonField<LocalDate> endDate = JsonField.missing();
        private String id;
        private JsonField<String> invoiceMemo = JsonField.missing();
        private Long mrrCents;
        private Integer netTerms;
        private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();
        private BillingPeriodEnum period;
        private JsonField<String> planDescription = JsonField.missing();
        private String planId;
        private String planName;
        private Integer planVersion;
        private String planVersionId;
        private JsonField<String> purchaseOrder = JsonField.missing();
        private LocalDate startDate;
        private SubscriptionStatusEnum status;
        private JsonField<Integer> trialDuration = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * When the subscription was activated (first payment or activation condition met)
         *
         * @param activatedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder activatedAt(OffsetDateTime activatedAt) {
            this.activatedAt = JsonField.ofNullable(activatedAt);
            return this;
        }

        /**
         * If false, invoices will stay in Draft until manually reviewed and finalized. Default to
         * true.
         *
         * @param autoAdvanceInvoices the value
         * @return this builder
         */
        public Builder autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
            this.autoAdvanceInvoices = autoAdvanceInvoices;
            return this;
        }

        /**
         * The {@code billing_day_anchor} property.
         *
         * @param billingDayAnchor the value
         * @return this builder
         */
        public Builder billingDayAnchor(Integer billingDayAnchor) {
            this.billingDayAnchor = billingDayAnchor;
            return this;
        }

        /**
         * When billing started (after any trial period)
         *
         * @param billingStartDate the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingStartDate(LocalDate billingStartDate) {
            this.billingStartDate = JsonField.ofNullable(billingStartDate);
            return this;
        }

        /**
         * Automatically try to charge the customer's configured payment method on finalize.
         *
         * @param chargeAutomatically the value
         * @return this builder
         */
        public Builder chargeAutomatically(Boolean chargeAutomatically) {
            this.chargeAutomatically = chargeAutomatically;
            return this;
        }

        /**
         * When the subscription was created
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
         * Current billing period end date
         *
         * @param currentPeriodEnd the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder currentPeriodEnd(LocalDate currentPeriodEnd) {
            this.currentPeriodEnd = JsonField.ofNullable(currentPeriodEnd);
            return this;
        }

        /**
         * Current billing period start date
         *
         * @param currentPeriodStart the value
         * @return this builder
         */
        public Builder currentPeriodStart(LocalDate currentPeriodStart) {
            this.currentPeriodStart = currentPeriodStart;
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
         * The {@code customer_alias} property.
         *
         * @param customerAlias the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder customerAlias(String customerAlias) {
            this.customerAlias = JsonField.ofNullable(customerAlias);
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
         * The {@code customer_name} property.
         *
         * @param customerName the value
         * @return this builder
         */
        public Builder customerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        /**
         * When the subscription ends (if set)
         *
         * @param endDate the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder endDate(LocalDate endDate) {
            this.endDate = JsonField.ofNullable(endDate);
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
         * Monthly recurring revenue in cents
         *
         * @param mrrCents the value
         * @return this builder
         */
        public Builder mrrCents(Long mrrCents) {
            this.mrrCents = mrrCents;
            return this;
        }

        /**
         * Payment terms in days (0 = due on issue)
         *
         * @param netTerms the value
         * @return this builder
         */
        public Builder netTerms(Integer netTerms) {
            this.netTerms = netTerms;
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
         * Billing period (monthly, annual, etc.)
         *
         * @param period the value
         * @return this builder
         */
        public Builder period(BillingPeriodEnum period) {
            this.period = period;
            return this;
        }

        /**
         * The {@code plan_description} property.
         *
         * @param planDescription the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder planDescription(String planDescription) {
            this.planDescription = JsonField.ofNullable(planDescription);
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
         * The {@code plan_name} property.
         *
         * @param planName the value
         * @return this builder
         */
        public Builder planName(String planName) {
            this.planName = planName;
            return this;
        }

        /**
         * The {@code plan_version} property.
         *
         * @param planVersion the value
         * @return this builder
         */
        public Builder planVersion(Integer planVersion) {
            this.planVersion = planVersion;
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
         * When the subscription contract starts (benefits apply from this date)
         *
         * @param startDate the value
         * @return this builder
         */
        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(SubscriptionStatusEnum status) {
            this.status = status;
            return this;
        }

        /**
         * Trial duration in days
         *
         * @param trialDuration the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder trialDuration(Integer trialDuration) {
            this.trialDuration = JsonField.ofNullable(trialDuration);
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
         * The {@code Subscription}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Subscription build() {
            Utils.checkRequired(autoAdvanceInvoices, "auto_advance_invoices");
            Utils.checkRequired(billingDayAnchor, "billing_day_anchor");
            Utils.checkRequired(chargeAutomatically, "charge_automatically");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(currentPeriodStart, "current_period_start");
            Utils.checkRequired(customProperties, "custom_properties");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(customerName, "customer_name");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(mrrCents, "mrr_cents");
            Utils.checkRequired(netTerms, "net_terms");
            Utils.checkRequired(period, "period");
            Utils.checkRequired(planId, "plan_id");
            Utils.checkRequired(planName, "plan_name");
            Utils.checkRequired(planVersion, "plan_version");
            Utils.checkRequired(planVersionId, "plan_version_id");
            Utils.checkRequired(startDate, "start_date");
            Utils.checkRequired(status, "status");
            return new Subscription(this);
        }
    }

    /**
     * Parse {@code json} as {@code Subscription}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Subscription fromJson(String json) {
        return Utils.parse(json, Subscription.class);
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
