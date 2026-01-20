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

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CheckoutSession {
    @JsonProperty("billing_day_anchor")
    private Integer billingDayAnchor;

    @JsonProperty("billing_start_date")
    private String billingStartDate;

    @JsonProperty("checkout_type")
    private CheckoutType checkoutType;

    @JsonProperty("checkout_url")
    private String checkoutUrl;

    @JsonProperty("completed_at")
    private OffsetDateTime completedAt;

    @JsonProperty("coupon_code")
    private String couponCode;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("expires_at")
    private OffsetDateTime expiresAt;

    @JsonProperty private String id;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("plan_version_id")
    private String planVersionId;

    @JsonProperty private CheckoutSessionStatus status;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("trial_duration_days")
    private Integer trialDurationDays;

    public CheckoutSession() {}

    public CheckoutSession billingDayAnchor(Integer billingDayAnchor) {
        this.billingDayAnchor = billingDayAnchor;
        return this;
    }

    /**
     * Get billingDayAnchor
     *
     * @return billingDayAnchor
     */
    @javax.annotation.Nullable
    public Integer getBillingDayAnchor() {
        return billingDayAnchor;
    }

    public void setBillingDayAnchor(Integer billingDayAnchor) {
        this.billingDayAnchor = billingDayAnchor;
    }

    public CheckoutSession billingStartDate(String billingStartDate) {
        this.billingStartDate = billingStartDate;
        return this;
    }

    /**
     * Get billingStartDate
     *
     * @return billingStartDate
     */
    @javax.annotation.Nullable
    public String getBillingStartDate() {
        return billingStartDate;
    }

    public void setBillingStartDate(String billingStartDate) {
        this.billingStartDate = billingStartDate;
    }

    public CheckoutSession checkoutType(CheckoutType checkoutType) {
        this.checkoutType = checkoutType;
        return this;
    }

    /**
     * Get checkoutType
     *
     * @return checkoutType
     */
    @javax.annotation.Nonnull
    public CheckoutType getCheckoutType() {
        return checkoutType;
    }

    public void setCheckoutType(CheckoutType checkoutType) {
        this.checkoutType = checkoutType;
    }

    public CheckoutSession checkoutUrl(String checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
        return this;
    }

    /**
     * Get checkoutUrl
     *
     * @return checkoutUrl
     */
    @javax.annotation.Nullable
    public String getCheckoutUrl() {
        return checkoutUrl;
    }

    public void setCheckoutUrl(String checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
    }

    public CheckoutSession completedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    /**
     * Get completedAt
     *
     * @return completedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public CheckoutSession couponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    /**
     * Get couponCode
     *
     * @return couponCode
     */
    @javax.annotation.Nullable
    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public CheckoutSession createdAt(OffsetDateTime createdAt) {
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

    public CheckoutSession customerId(String customerId) {
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

    public CheckoutSession expiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * When the session expires. None means the session never expires.
     *
     * @return expiresAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CheckoutSession id(String id) {
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

    public CheckoutSession netTerms(Integer netTerms) {
        this.netTerms = netTerms;
        return this;
    }

    /**
     * Get netTerms
     *
     * @return netTerms
     */
    @javax.annotation.Nullable
    public Integer getNetTerms() {
        return netTerms;
    }

    public void setNetTerms(Integer netTerms) {
        this.netTerms = netTerms;
    }

    public CheckoutSession planVersionId(String planVersionId) {
        this.planVersionId = planVersionId;
        return this;
    }

    /**
     * Get planVersionId
     *
     * @return planVersionId
     */
    @javax.annotation.Nonnull
    public String getPlanVersionId() {
        return planVersionId;
    }

    public void setPlanVersionId(String planVersionId) {
        this.planVersionId = planVersionId;
    }

    public CheckoutSession status(CheckoutSessionStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public CheckoutSessionStatus getStatus() {
        return status;
    }

    public void setStatus(CheckoutSessionStatus status) {
        this.status = status;
    }

    public CheckoutSession subscriptionId(String subscriptionId) {
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

    public CheckoutSession trialDurationDays(Integer trialDurationDays) {
        this.trialDurationDays = trialDurationDays;
        return this;
    }

    /**
     * Get trialDurationDays
     *
     * @return trialDurationDays
     */
    @javax.annotation.Nullable
    public Integer getTrialDurationDays() {
        return trialDurationDays;
    }

    public void setTrialDurationDays(Integer trialDurationDays) {
        this.trialDurationDays = trialDurationDays;
    }

    /**
     * Create an instance of CheckoutSession given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CheckoutSession
     * @throws JsonProcessingException if the JSON string is invalid with respect to CheckoutSession
     */
    public static CheckoutSession fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CheckoutSession.class);
    }

    /**
     * Convert an instance of CheckoutSession to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
