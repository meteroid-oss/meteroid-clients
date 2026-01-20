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
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class SubscriptionDetails {
    @JsonProperty("activated_at")
    private OffsetDateTime activatedAt;

    @JsonProperty("add_ons")
    private List<SubscriptionAddOn> addOns;

    @JsonProperty("applied_coupons")
    private List<AppliedCouponDetailed> appliedCoupons;

    @JsonProperty("auto_advance_invoices")
    private Boolean autoAdvanceInvoices;

    @JsonProperty("billing_day_anchor")
    private Integer billingDayAnchor;

    @JsonProperty("billing_start_date")
    private String billingStartDate;

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty("checkout_url")
    private String checkoutUrl;

    @JsonProperty private List<SubscriptionComponent> components;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private Currency currency;

    @JsonProperty("current_period_end")
    private String currentPeriodEnd;

    @JsonProperty("current_period_start")
    private String currentPeriodStart;

    @JsonProperty("customer_alias")
    private String customerAlias;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty private String id;

    @JsonProperty("invoice_memo")
    private String invoiceMemo;

    @JsonProperty("mrr_cents")
    private Long mrrCents;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty private BillingPeriodEnum period;

    @JsonProperty("plan_id")
    private String planId;

    @JsonProperty("plan_name")
    private String planName;

    @JsonProperty("plan_version")
    private Integer planVersion;

    @JsonProperty("plan_version_id")
    private String planVersionId;

    @JsonProperty("purchase_order")
    private String purchaseOrder;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty private SubscriptionStatusEnum status;

    @JsonProperty("trial_duration")
    private Integer trialDuration;

    public SubscriptionDetails() {}

    public SubscriptionDetails activatedAt(OffsetDateTime activatedAt) {
        this.activatedAt = activatedAt;
        return this;
    }

    /**
     * When the subscription was activated (first payment or activation condition met)
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

    public SubscriptionDetails addOns(List<SubscriptionAddOn> addOns) {
        this.addOns = addOns;
        return this;
    }

    public SubscriptionDetails addAddOnsItem(SubscriptionAddOn addOnsItem) {
        if (this.addOns == null) {
            this.addOns = new ArrayList<>();
        }
        this.addOns.add(addOnsItem);

        return this;
    }

    /**
     * Get addOns
     *
     * @return addOns
     */
    @javax.annotation.Nonnull
    public List<SubscriptionAddOn> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<SubscriptionAddOn> addOns) {
        this.addOns = addOns;
    }

    public SubscriptionDetails appliedCoupons(List<AppliedCouponDetailed> appliedCoupons) {
        this.appliedCoupons = appliedCoupons;
        return this;
    }

    public SubscriptionDetails addAppliedCouponsItem(AppliedCouponDetailed appliedCouponsItem) {
        if (this.appliedCoupons == null) {
            this.appliedCoupons = new ArrayList<>();
        }
        this.appliedCoupons.add(appliedCouponsItem);

        return this;
    }

    /**
     * Get appliedCoupons
     *
     * @return appliedCoupons
     */
    @javax.annotation.Nonnull
    public List<AppliedCouponDetailed> getAppliedCoupons() {
        return appliedCoupons;
    }

    public void setAppliedCoupons(List<AppliedCouponDetailed> appliedCoupons) {
        this.appliedCoupons = appliedCoupons;
    }

    public SubscriptionDetails autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
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

    public SubscriptionDetails billingDayAnchor(Integer billingDayAnchor) {
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

    public SubscriptionDetails billingStartDate(String billingStartDate) {
        this.billingStartDate = billingStartDate;
        return this;
    }

    /**
     * When billing started (after any trial period)
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

    public SubscriptionDetails chargeAutomatically(Boolean chargeAutomatically) {
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

    public SubscriptionDetails checkoutUrl(String checkoutUrl) {
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

    public SubscriptionDetails components(List<SubscriptionComponent> components) {
        this.components = components;
        return this;
    }

    public SubscriptionDetails addComponentsItem(SubscriptionComponent componentsItem) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
        this.components.add(componentsItem);

        return this;
    }

    /**
     * Get components
     *
     * @return components
     */
    @javax.annotation.Nonnull
    public List<SubscriptionComponent> getComponents() {
        return components;
    }

    public void setComponents(List<SubscriptionComponent> components) {
        this.components = components;
    }

    public SubscriptionDetails createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * When the subscription was created
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

    public SubscriptionDetails currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @javax.annotation.Nonnull
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public SubscriptionDetails currentPeriodEnd(String currentPeriodEnd) {
        this.currentPeriodEnd = currentPeriodEnd;
        return this;
    }

    /**
     * Current billing period end date
     *
     * @return currentPeriodEnd
     */
    @javax.annotation.Nullable
    public String getCurrentPeriodEnd() {
        return currentPeriodEnd;
    }

    public void setCurrentPeriodEnd(String currentPeriodEnd) {
        this.currentPeriodEnd = currentPeriodEnd;
    }

    public SubscriptionDetails currentPeriodStart(String currentPeriodStart) {
        this.currentPeriodStart = currentPeriodStart;
        return this;
    }

    /**
     * Current billing period start date
     *
     * @return currentPeriodStart
     */
    @javax.annotation.Nonnull
    public String getCurrentPeriodStart() {
        return currentPeriodStart;
    }

    public void setCurrentPeriodStart(String currentPeriodStart) {
        this.currentPeriodStart = currentPeriodStart;
    }

    public SubscriptionDetails customerAlias(String customerAlias) {
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

    public SubscriptionDetails customerId(String customerId) {
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

    public SubscriptionDetails customerName(String customerName) {
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

    public SubscriptionDetails endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * When the subscription ends (if set)
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

    public SubscriptionDetails id(String id) {
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

    public SubscriptionDetails invoiceMemo(String invoiceMemo) {
        this.invoiceMemo = invoiceMemo;
        return this;
    }

    /**
     * Default memo for invoices
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

    public SubscriptionDetails mrrCents(Long mrrCents) {
        this.mrrCents = mrrCents;
        return this;
    }

    /**
     * Monthly recurring revenue in cents
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

    public SubscriptionDetails netTerms(Integer netTerms) {
        this.netTerms = netTerms;
        return this;
    }

    /**
     * Payment terms in days (0 = due on issue)
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

    public SubscriptionDetails period(BillingPeriodEnum period) {
        this.period = period;
        return this;
    }

    /**
     * Billing period (monthly, annual, etc.)
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

    public SubscriptionDetails planId(String planId) {
        this.planId = planId;
        return this;
    }

    /**
     * Get planId
     *
     * @return planId
     */
    @javax.annotation.Nonnull
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public SubscriptionDetails planName(String planName) {
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

    public SubscriptionDetails planVersion(Integer planVersion) {
        this.planVersion = planVersion;
        return this;
    }

    /**
     * Get planVersion
     *
     * @return planVersion
     */
    @javax.annotation.Nonnull
    public Integer getPlanVersion() {
        return planVersion;
    }

    public void setPlanVersion(Integer planVersion) {
        this.planVersion = planVersion;
    }

    public SubscriptionDetails planVersionId(String planVersionId) {
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

    public SubscriptionDetails purchaseOrder(String purchaseOrder) {
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

    public SubscriptionDetails startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * When the subscription contract starts (benefits apply from this date)
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

    public SubscriptionDetails status(SubscriptionStatusEnum status) {
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

    public SubscriptionDetails trialDuration(Integer trialDuration) {
        this.trialDuration = trialDuration;
        return this;
    }

    /**
     * Trial duration in days
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

    /**
     * Create an instance of SubscriptionDetails given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionDetails
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionDetails
     */
    public static SubscriptionDetails fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionDetails.class);
    }

    /**
     * Convert an instance of SubscriptionDetails to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
