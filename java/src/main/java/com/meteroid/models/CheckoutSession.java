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
public final class CheckoutSession {
    @JsonProperty("billing_day_anchor")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> billingDayAnchor = JsonField.missing();

    @JsonProperty("billing_start_date")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<LocalDate> billingStartDate = JsonField.missing();

    @JsonProperty("cancel_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cancelUrl = JsonField.missing();

    @JsonProperty("checkout_type")
    private CheckoutType checkoutType;

    @JsonProperty("checkout_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> checkoutUrl = JsonField.missing();

    @JsonProperty("completed_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> completedAt = JsonField.missing();

    @JsonProperty("coupon_code")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> couponCode = JsonField.missing();

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("expires_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> expiresAt = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("net_terms")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> netTerms = JsonField.missing();

    @JsonProperty("payment_methods_config")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();

    @JsonProperty("plan_version_id")
    private String planVersionId;

    @JsonProperty("status")
    private CheckoutSessionStatus status;

    @JsonProperty("subscription_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> subscriptionId = JsonField.missing();

    @JsonProperty("success_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> successUrl = JsonField.missing();

    @JsonProperty("trial_duration_days")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> trialDurationDays = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CheckoutSession() {}

    private CheckoutSession(Builder builder) {
        this.billingDayAnchor = builder.billingDayAnchor;
        this.billingStartDate = builder.billingStartDate;
        this.cancelUrl = builder.cancelUrl;
        this.checkoutType = builder.checkoutType;
        this.checkoutUrl = builder.checkoutUrl;
        this.completedAt = builder.completedAt;
        this.couponCode = builder.couponCode;
        this.createdAt = builder.createdAt;
        this.customerId = builder.customerId;
        this.expiresAt = builder.expiresAt;
        this.id = builder.id;
        this.netTerms = builder.netTerms;
        this.paymentMethodsConfig = builder.paymentMethodsConfig;
        this.planVersionId = builder.planVersionId;
        this.status = builder.status;
        this.subscriptionId = builder.subscriptionId;
        this.successUrl = builder.successUrl;
        this.trialDurationDays = builder.trialDurationDays;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CheckoutSession}.
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
        builder.billingDayAnchor = billingDayAnchor;
        builder.billingStartDate = billingStartDate;
        builder.cancelUrl = cancelUrl;
        builder.checkoutType = checkoutType;
        builder.checkoutUrl = checkoutUrl;
        builder.completedAt = completedAt;
        builder.couponCode = couponCode;
        builder.createdAt = createdAt;
        builder.customerId = customerId;
        builder.expiresAt = expiresAt;
        builder.id = id;
        builder.netTerms = netTerms;
        builder.paymentMethodsConfig = paymentMethodsConfig;
        builder.planVersionId = planVersionId;
        builder.status = status;
        builder.subscriptionId = subscriptionId;
        builder.successUrl = successUrl;
        builder.trialDurationDays = trialDurationDays;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * The {@code cancel_url} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> cancelUrl() {
        return cancelUrl.asOptional();
    }

    /**
     * The {@code checkout_type} property.
     *
     * @return the value, never null
     */
    public CheckoutType checkoutType() {
        return Utils.required(checkoutType, "checkout_type");
    }

    /**
     * The {@code checkout_url} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> checkoutUrl() {
        return checkoutUrl.asOptional();
    }

    /**
     * The {@code completed_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> completedAt() {
        return completedAt.asOptional();
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
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
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
     * When the session expires. None means the session never expires.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> expiresAt() {
        return expiresAt.asOptional();
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
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public CheckoutSessionStatus status() {
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
     * The {@code success_url} property.
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
        CheckoutSession that = (CheckoutSession) o;
        return Objects.equals(billingDayAnchor, that.billingDayAnchor)
                && Objects.equals(billingStartDate, that.billingStartDate)
                && Objects.equals(cancelUrl, that.cancelUrl)
                && Objects.equals(checkoutType, that.checkoutType)
                && Objects.equals(checkoutUrl, that.checkoutUrl)
                && Objects.equals(completedAt, that.completedAt)
                && Objects.equals(couponCode, that.couponCode)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(expiresAt, that.expiresAt)
                && Objects.equals(id, that.id)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(paymentMethodsConfig, that.paymentMethodsConfig)
                && Objects.equals(planVersionId, that.planVersionId)
                && Objects.equals(status, that.status)
                && Objects.equals(subscriptionId, that.subscriptionId)
                && Objects.equals(successUrl, that.successUrl)
                && Objects.equals(trialDurationDays, that.trialDurationDays)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                billingDayAnchor,
                billingStartDate,
                cancelUrl,
                checkoutType,
                checkoutUrl,
                completedAt,
                couponCode,
                createdAt,
                customerId,
                expiresAt,
                id,
                netTerms,
                paymentMethodsConfig,
                planVersionId,
                status,
                subscriptionId,
                successUrl,
                trialDurationDays,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CheckoutSession{"
                + "billingDayAnchor="
                + billingDayAnchor
                + ", billingStartDate="
                + billingStartDate
                + ", cancelUrl="
                + cancelUrl
                + ", checkoutType="
                + checkoutType
                + ", checkoutUrl="
                + checkoutUrl
                + ", completedAt="
                + completedAt
                + ", couponCode="
                + couponCode
                + ", createdAt="
                + createdAt
                + ", customerId="
                + customerId
                + ", expiresAt="
                + expiresAt
                + ", id="
                + id
                + ", netTerms="
                + netTerms
                + ", paymentMethodsConfig="
                + paymentMethodsConfig
                + ", planVersionId="
                + planVersionId
                + ", status="
                + status
                + ", subscriptionId="
                + subscriptionId
                + ", successUrl="
                + successUrl
                + ", trialDurationDays="
                + trialDurationDays
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CheckoutSession}. */
    public static final class Builder {
        private JsonField<Integer> billingDayAnchor = JsonField.missing();
        private JsonField<LocalDate> billingStartDate = JsonField.missing();
        private JsonField<String> cancelUrl = JsonField.missing();
        private CheckoutType checkoutType;
        private JsonField<String> checkoutUrl = JsonField.missing();
        private JsonField<OffsetDateTime> completedAt = JsonField.missing();
        private JsonField<String> couponCode = JsonField.missing();
        private OffsetDateTime createdAt;
        private String customerId;
        private JsonField<OffsetDateTime> expiresAt = JsonField.missing();
        private String id;
        private JsonField<Integer> netTerms = JsonField.missing();
        private JsonField<PaymentMethodsConfig> paymentMethodsConfig = JsonField.missing();
        private String planVersionId;
        private CheckoutSessionStatus status;
        private JsonField<String> subscriptionId = JsonField.missing();
        private JsonField<String> successUrl = JsonField.missing();
        private JsonField<Integer> trialDurationDays = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * The {@code cancel_url} property.
         *
         * @param cancelUrl the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder cancelUrl(String cancelUrl) {
            this.cancelUrl = JsonField.ofNullable(cancelUrl);
            return this;
        }

        /**
         * The {@code checkout_type} property.
         *
         * @param checkoutType the value
         * @return this builder
         */
        public Builder checkoutType(CheckoutType checkoutType) {
            this.checkoutType = checkoutType;
            return this;
        }

        /**
         * The {@code checkout_url} property.
         *
         * @param checkoutUrl the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder checkoutUrl(String checkoutUrl) {
            this.checkoutUrl = JsonField.ofNullable(checkoutUrl);
            return this;
        }

        /**
         * The {@code completed_at} property.
         *
         * @param completedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder completedAt(OffsetDateTime completedAt) {
            this.completedAt = JsonField.ofNullable(completedAt);
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
         * When the session expires. None means the session never expires.
         *
         * @param expiresAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder expiresAt(OffsetDateTime expiresAt) {
            this.expiresAt = JsonField.ofNullable(expiresAt);
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
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(CheckoutSessionStatus status) {
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
         * The {@code success_url} property.
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
         * The {@code CheckoutSession}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CheckoutSession build() {
            Utils.checkRequired(checkoutType, "checkout_type");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(planVersionId, "plan_version_id");
            Utils.checkRequired(status, "status");
            return new CheckoutSession(this);
        }
    }

    /**
     * Parse {@code json} as {@code CheckoutSession}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CheckoutSession fromJson(String json) {
        return Utils.parse(json, CheckoutSession.class);
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
