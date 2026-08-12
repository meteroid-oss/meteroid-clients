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
public class SubscriptionEventData {
    @JsonProperty("activated_at")
    private OffsetDateTime activatedAt;

    @JsonProperty("auto_advance_invoices")
    private Boolean autoAdvanceInvoices;

    @JsonProperty("billing_day_anchor")
    private Integer billingDayAnchor;

    @JsonProperty("billing_start_date")
    private String billingStartDate;

    @JsonProperty("cancellation_reason")
    private String cancellationReason;

    @JsonProperty("change_type")
    private SubscriptionUpdateType changeType;

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_alias")
    private String customerAlias;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("invoice_memo")
    private String invoiceMemo;

    @JsonProperty("invoice_threshold")
    private String invoiceThreshold;

    @JsonProperty("mrr_cents")
    private Long mrrCents;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty private BillingPeriodEnum period;

    @JsonProperty("plan_name")
    private String planName;

    @JsonProperty("purchase_order")
    private String purchaseOrder;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty private SubscriptionStatusEnum status;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    @JsonProperty("trial_duration")
    private Integer trialDuration;

    @JsonProperty private Integer version;

    public SubscriptionEventData() {}

    public SubscriptionEventData activatedAt(OffsetDateTime activatedAt) {
        this.activatedAt = activatedAt;
        return this;
    }

    /**
     * Get activatedAt
     *
     * @return activatedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(OffsetDateTime activatedAt) {
        this.activatedAt = activatedAt;
    }

    public SubscriptionEventData autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
        this.autoAdvanceInvoices = autoAdvanceInvoices;
        return this;
    }

    /**
     * Get autoAdvanceInvoices
     *
     * @return autoAdvanceInvoices
     */
    @javax.annotation.Nonnull
    public Boolean getAutoAdvanceInvoices() {
        return autoAdvanceInvoices;
    }

    public void setAutoAdvanceInvoices(Boolean autoAdvanceInvoices) {
        this.autoAdvanceInvoices = autoAdvanceInvoices;
    }

    public SubscriptionEventData billingDayAnchor(Integer billingDayAnchor) {
        this.billingDayAnchor = billingDayAnchor;
        return this;
    }

    /**
     * Get billingDayAnchor
     *
     * @return billingDayAnchor
     */
    @javax.annotation.Nonnull
    public Integer getBillingDayAnchor() {
        return billingDayAnchor;
    }

    public void setBillingDayAnchor(Integer billingDayAnchor) {
        this.billingDayAnchor = billingDayAnchor;
    }

    public SubscriptionEventData billingStartDate(String billingStartDate) {
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

    public SubscriptionEventData cancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
        return this;
    }

    /**
     * Present on `subscription.cancelled` when a reason was supplied.
     *
     * @return cancellationReason
     */
    @javax.annotation.Nullable
    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public SubscriptionEventData changeType(SubscriptionUpdateType changeType) {
        this.changeType = changeType;
        return this;
    }

    /**
     * Get changeType
     *
     * @return changeType
     */
    @javax.annotation.Nullable
    public SubscriptionUpdateType getChangeType() {
        return changeType;
    }

    public void setChangeType(SubscriptionUpdateType changeType) {
        this.changeType = changeType;
    }

    public SubscriptionEventData chargeAutomatically(Boolean chargeAutomatically) {
        this.chargeAutomatically = chargeAutomatically;
        return this;
    }

    /**
     * Get chargeAutomatically
     *
     * @return chargeAutomatically
     */
    @javax.annotation.Nonnull
    public Boolean getChargeAutomatically() {
        return chargeAutomatically;
    }

    public void setChargeAutomatically(Boolean chargeAutomatically) {
        this.chargeAutomatically = chargeAutomatically;
    }

    public SubscriptionEventData createdAt(OffsetDateTime createdAt) {
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

    public SubscriptionEventData currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @javax.annotation.Nonnull
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SubscriptionEventData customProperties(Object customProperties) {
        this.customProperties = customProperties;
        return this;
    }

    /**
     * User-defined custom property values, keyed by definition key.
     *
     * @return customProperties
     */
    @javax.annotation.Nonnull
    public Object getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Object customProperties) {
        this.customProperties = customProperties;
    }

    public SubscriptionEventData customerAlias(String customerAlias) {
        this.customerAlias = customerAlias;
        return this;
    }

    /**
     * Get customerAlias
     *
     * @return customerAlias
     */
    @javax.annotation.Nullable
    public String getCustomerAlias() {
        return customerAlias;
    }

    public void setCustomerAlias(String customerAlias) {
        this.customerAlias = customerAlias;
    }

    public SubscriptionEventData customerId(String customerId) {
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

    public SubscriptionEventData customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    /**
     * Get customerName
     *
     * @return customerName
     */
    @javax.annotation.Nonnull
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public SubscriptionEventData endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     */
    @javax.annotation.Nullable
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public SubscriptionEventData invoiceMemo(String invoiceMemo) {
        this.invoiceMemo = invoiceMemo;
        return this;
    }

    /**
     * Get invoiceMemo
     *
     * @return invoiceMemo
     */
    @javax.annotation.Nullable
    public String getInvoiceMemo() {
        return invoiceMemo;
    }

    public void setInvoiceMemo(String invoiceMemo) {
        this.invoiceMemo = invoiceMemo;
    }

    public SubscriptionEventData invoiceThreshold(String invoiceThreshold) {
        this.invoiceThreshold = invoiceThreshold;
        return this;
    }

    /**
     * Get invoiceThreshold
     *
     * @return invoiceThreshold
     */
    @javax.annotation.Nullable
    public String getInvoiceThreshold() {
        return invoiceThreshold;
    }

    public void setInvoiceThreshold(String invoiceThreshold) {
        this.invoiceThreshold = invoiceThreshold;
    }

    public SubscriptionEventData mrrCents(Long mrrCents) {
        this.mrrCents = mrrCents;
        return this;
    }

    /**
     * Get mrrCents
     *
     * @return mrrCents
     */
    @javax.annotation.Nonnull
    public Long getMrrCents() {
        return mrrCents;
    }

    public void setMrrCents(Long mrrCents) {
        this.mrrCents = mrrCents;
    }

    public SubscriptionEventData netTerms(Integer netTerms) {
        this.netTerms = netTerms;
        return this;
    }

    /**
     * Get netTerms
     *
     * @return netTerms
     */
    @javax.annotation.Nonnull
    public Integer getNetTerms() {
        return netTerms;
    }

    public void setNetTerms(Integer netTerms) {
        this.netTerms = netTerms;
    }

    public SubscriptionEventData period(BillingPeriodEnum period) {
        this.period = period;
        return this;
    }

    /**
     * Get period
     *
     * @return period
     */
    @javax.annotation.Nonnull
    public BillingPeriodEnum getPeriod() {
        return period;
    }

    public void setPeriod(BillingPeriodEnum period) {
        this.period = period;
    }

    public SubscriptionEventData planName(String planName) {
        this.planName = planName;
        return this;
    }

    /**
     * Get planName
     *
     * @return planName
     */
    @javax.annotation.Nonnull
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public SubscriptionEventData purchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        return this;
    }

    /**
     * Get purchaseOrder
     *
     * @return purchaseOrder
     */
    @javax.annotation.Nullable
    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public SubscriptionEventData startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     */
    @javax.annotation.Nonnull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public SubscriptionEventData status(SubscriptionStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public SubscriptionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatusEnum status) {
        this.status = status;
    }

    public SubscriptionEventData subscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /**
     * Get subscriptionId
     *
     * @return subscriptionId
     */
    @javax.annotation.Nonnull
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public SubscriptionEventData trialDuration(Integer trialDuration) {
        this.trialDuration = trialDuration;
        return this;
    }

    /**
     * Get trialDuration
     *
     * @return trialDuration
     */
    @javax.annotation.Nullable
    public Integer getTrialDuration() {
        return trialDuration;
    }

    public void setTrialDuration(Integer trialDuration) {
        this.trialDuration = trialDuration;
    }

    public SubscriptionEventData version(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     *
     * @return version
     */
    @javax.annotation.Nonnull
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Create an instance of SubscriptionEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionEventData
     */
    public static SubscriptionEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionEventData.class);
    }

    /**
     * Convert an instance of SubscriptionEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
