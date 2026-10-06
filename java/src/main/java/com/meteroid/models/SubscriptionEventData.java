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
public final class SubscriptionEventData {
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

    @JsonProperty("cancellation_reason")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cancellationReason = JsonField.missing();

    @JsonProperty("change_type")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<SubscriptionUpdateType> changeType = JsonField.missing();

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("currency")
    private String currency;

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

    @JsonProperty("invoice_memo")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoiceMemo = JsonField.missing();

    @JsonProperty("invoice_threshold")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoiceThreshold = JsonField.missing();

    @JsonProperty("mrr_cents")
    private Long mrrCents;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("period")
    private BillingPeriodEnum period;

    @JsonProperty("plan_name")
    private String planName;

    @JsonProperty("purchase_order")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> purchaseOrder = JsonField.missing();

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("status")
    private SubscriptionStatusEnum status;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("trial_duration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> trialDuration = JsonField.missing();

    @JsonProperty("version")
    private Integer version;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SubscriptionEventData() {}

    private SubscriptionEventData(Builder builder) {
        this.activatedAt = builder.activatedAt;
        this.autoAdvanceInvoices = builder.autoAdvanceInvoices;
        this.billingDayAnchor = builder.billingDayAnchor;
        this.billingStartDate = builder.billingStartDate;
        this.cancellationReason = builder.cancellationReason;
        this.changeType = builder.changeType;
        this.chargeAutomatically = builder.chargeAutomatically;
        this.createdAt = builder.createdAt;
        this.currency = builder.currency;
        this.customProperties = builder.customProperties;
        this.customerAlias = builder.customerAlias;
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.endDate = builder.endDate;
        this.invoiceMemo = builder.invoiceMemo;
        this.invoiceThreshold = builder.invoiceThreshold;
        this.mrrCents = builder.mrrCents;
        this.netTerms = builder.netTerms;
        this.period = builder.period;
        this.planName = builder.planName;
        this.purchaseOrder = builder.purchaseOrder;
        this.startDate = builder.startDate;
        this.status = builder.status;
        this.subscriptionId = builder.subscriptionId;
        this.trialDuration = builder.trialDuration;
        this.version = builder.version;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SubscriptionEventData}.
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
        builder.cancellationReason = cancellationReason;
        builder.changeType = changeType;
        builder.chargeAutomatically = chargeAutomatically;
        builder.createdAt = createdAt;
        builder.currency = currency;
        builder.customProperties = customProperties;
        builder.customerAlias = customerAlias;
        builder.customerId = customerId;
        builder.customerName = customerName;
        builder.endDate = endDate;
        builder.invoiceMemo = invoiceMemo;
        builder.invoiceThreshold = invoiceThreshold;
        builder.mrrCents = mrrCents;
        builder.netTerms = netTerms;
        builder.period = period;
        builder.planName = planName;
        builder.purchaseOrder = purchaseOrder;
        builder.startDate = startDate;
        builder.status = status;
        builder.subscriptionId = subscriptionId;
        builder.trialDuration = trialDuration;
        builder.version = version;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code activated_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> activatedAt() {
        return activatedAt.asOptional();
    }

    /**
     * The {@code auto_advance_invoices} property.
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
     * The {@code billing_start_date} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> billingStartDate() {
        return billingStartDate.asOptional();
    }

    /**
     * Present on <code>subscription.cancelled</code> when a reason was supplied.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> cancellationReason() {
        return cancellationReason.asOptional();
    }

    /**
     * The {@code change_type} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<SubscriptionUpdateType> changeType() {
        return changeType.asOptional();
    }

    /**
     * The {@code charge_automatically} property.
     *
     * @return the value, never null
     */
    public Boolean chargeAutomatically() {
        return Utils.required(chargeAutomatically, "charge_automatically");
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
     * The {@code end_date} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<LocalDate> endDate() {
        return endDate.asOptional();
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
    public Optional<String> invoiceThreshold() {
        return invoiceThreshold.asOptional();
    }

    /**
     * The {@code mrr_cents} property.
     *
     * @return the value, never null
     */
    public Long mrrCents() {
        return Utils.required(mrrCents, "mrr_cents");
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
     * The {@code period} property.
     *
     * @return the value, never null
     */
    public BillingPeriodEnum period() {
        return Utils.required(period, "period");
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
     * The {@code purchase_order} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> purchaseOrder() {
        return purchaseOrder.asOptional();
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
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public SubscriptionStatusEnum status() {
        return Utils.required(status, "status");
    }

    /**
     * The {@code subscription_id} property.
     *
     * @return the value, never null
     */
    public String subscriptionId() {
        return Utils.required(subscriptionId, "subscription_id");
    }

    /**
     * The {@code trial_duration} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> trialDuration() {
        return trialDuration.asOptional();
    }

    /**
     * The {@code version} property.
     *
     * @return the value, never null
     */
    public Integer version() {
        return Utils.required(version, "version");
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
        SubscriptionEventData that = (SubscriptionEventData) o;
        return Objects.equals(activatedAt, that.activatedAt)
                && Objects.equals(autoAdvanceInvoices, that.autoAdvanceInvoices)
                && Objects.equals(billingDayAnchor, that.billingDayAnchor)
                && Objects.equals(billingStartDate, that.billingStartDate)
                && Objects.equals(cancellationReason, that.cancellationReason)
                && Objects.equals(changeType, that.changeType)
                && Objects.equals(chargeAutomatically, that.chargeAutomatically)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(currency, that.currency)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customerAlias, that.customerAlias)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(customerName, that.customerName)
                && Objects.equals(endDate, that.endDate)
                && Objects.equals(invoiceMemo, that.invoiceMemo)
                && Objects.equals(invoiceThreshold, that.invoiceThreshold)
                && Objects.equals(mrrCents, that.mrrCents)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(period, that.period)
                && Objects.equals(planName, that.planName)
                && Objects.equals(purchaseOrder, that.purchaseOrder)
                && Objects.equals(startDate, that.startDate)
                && Objects.equals(status, that.status)
                && Objects.equals(subscriptionId, that.subscriptionId)
                && Objects.equals(trialDuration, that.trialDuration)
                && Objects.equals(version, that.version)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                activatedAt,
                autoAdvanceInvoices,
                billingDayAnchor,
                billingStartDate,
                cancellationReason,
                changeType,
                chargeAutomatically,
                createdAt,
                currency,
                customProperties,
                customerAlias,
                customerId,
                customerName,
                endDate,
                invoiceMemo,
                invoiceThreshold,
                mrrCents,
                netTerms,
                period,
                planName,
                purchaseOrder,
                startDate,
                status,
                subscriptionId,
                trialDuration,
                version,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "SubscriptionEventData{"
                + "activatedAt="
                + activatedAt
                + ", autoAdvanceInvoices="
                + autoAdvanceInvoices
                + ", billingDayAnchor="
                + billingDayAnchor
                + ", billingStartDate="
                + billingStartDate
                + ", cancellationReason="
                + cancellationReason
                + ", changeType="
                + changeType
                + ", chargeAutomatically="
                + chargeAutomatically
                + ", createdAt="
                + createdAt
                + ", currency="
                + currency
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
                + ", invoiceMemo="
                + invoiceMemo
                + ", invoiceThreshold="
                + invoiceThreshold
                + ", mrrCents="
                + mrrCents
                + ", netTerms="
                + netTerms
                + ", period="
                + period
                + ", planName="
                + planName
                + ", purchaseOrder="
                + purchaseOrder
                + ", startDate="
                + startDate
                + ", status="
                + status
                + ", subscriptionId="
                + subscriptionId
                + ", trialDuration="
                + trialDuration
                + ", version="
                + version
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SubscriptionEventData}. */
    public static final class Builder {
        private JsonField<OffsetDateTime> activatedAt = JsonField.missing();
        private Boolean autoAdvanceInvoices;
        private Integer billingDayAnchor;
        private JsonField<LocalDate> billingStartDate = JsonField.missing();
        private JsonField<String> cancellationReason = JsonField.missing();
        private JsonField<SubscriptionUpdateType> changeType = JsonField.missing();
        private Boolean chargeAutomatically;
        private OffsetDateTime createdAt;
        private String currency;
        private Object customProperties;
        private JsonField<String> customerAlias = JsonField.missing();
        private String customerId;
        private String customerName;
        private JsonField<LocalDate> endDate = JsonField.missing();
        private JsonField<String> invoiceMemo = JsonField.missing();
        private JsonField<String> invoiceThreshold = JsonField.missing();
        private Long mrrCents;
        private Integer netTerms;
        private BillingPeriodEnum period;
        private String planName;
        private JsonField<String> purchaseOrder = JsonField.missing();
        private LocalDate startDate;
        private SubscriptionStatusEnum status;
        private String subscriptionId;
        private JsonField<Integer> trialDuration = JsonField.missing();
        private Integer version;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code activated_at} property.
         *
         * @param activatedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder activatedAt(OffsetDateTime activatedAt) {
            this.activatedAt = JsonField.ofNullable(activatedAt);
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
         * Present on <code>subscription.cancelled</code> when a reason was supplied.
         *
         * @param cancellationReason the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder cancellationReason(String cancellationReason) {
            this.cancellationReason = JsonField.ofNullable(cancellationReason);
            return this;
        }

        /**
         * The {@code change_type} property.
         *
         * @param changeType the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder changeType(SubscriptionUpdateType changeType) {
            this.changeType = JsonField.ofNullable(changeType);
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
        public Builder invoiceThreshold(String invoiceThreshold) {
            this.invoiceThreshold = JsonField.ofNullable(invoiceThreshold);
            return this;
        }

        /**
         * The {@code mrr_cents} property.
         *
         * @param mrrCents the value
         * @return this builder
         */
        public Builder mrrCents(Long mrrCents) {
            this.mrrCents = mrrCents;
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
         * The {@code period} property.
         *
         * @param period the value
         * @return this builder
         */
        public Builder period(BillingPeriodEnum period) {
            this.period = period;
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
         * The {@code subscription_id} property.
         *
         * @param subscriptionId the value
         * @return this builder
         */
        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        /**
         * The {@code trial_duration} property.
         *
         * @param trialDuration the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder trialDuration(Integer trialDuration) {
            this.trialDuration = JsonField.ofNullable(trialDuration);
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
         * The {@code SubscriptionEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SubscriptionEventData build() {
            Utils.checkRequired(autoAdvanceInvoices, "auto_advance_invoices");
            Utils.checkRequired(billingDayAnchor, "billing_day_anchor");
            Utils.checkRequired(chargeAutomatically, "charge_automatically");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(customProperties, "custom_properties");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(customerName, "customer_name");
            Utils.checkRequired(mrrCents, "mrr_cents");
            Utils.checkRequired(netTerms, "net_terms");
            Utils.checkRequired(period, "period");
            Utils.checkRequired(planName, "plan_name");
            Utils.checkRequired(startDate, "start_date");
            Utils.checkRequired(status, "status");
            Utils.checkRequired(subscriptionId, "subscription_id");
            Utils.checkRequired(version, "version");
            return new SubscriptionEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code SubscriptionEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SubscriptionEventData fromJson(String json) {
        return Utils.parse(json, SubscriptionEventData.class);
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
