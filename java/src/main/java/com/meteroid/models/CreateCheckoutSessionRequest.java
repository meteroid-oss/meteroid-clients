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

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CreateCheckoutSessionRequest {
    @JsonProperty("activation_condition")
    private SubscriptionActivationConditionEnum activationCondition;

    @JsonProperty("add_ons")
    private List<CreateSubscriptionAddOn> addOns;

    @JsonProperty("auto_advance_invoices")
    private Boolean autoAdvanceInvoices;

    @JsonProperty("billing_day_anchor")
    private Integer billingDayAnchor;

    @JsonProperty("billing_start_date")
    private String billingStartDate;

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty private CreateSubscriptionComponents components;

    @JsonProperty("coupon_code")
    private String couponCode;

    @JsonProperty("coupon_ids")
    private List<String> couponIds;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("expires_in_hours")
    private Integer expiresInHours;

    @JsonProperty("invoice_memo")
    private String invoiceMemo;

    @JsonProperty("invoice_threshold")
    private String invoiceThreshold;

    @JsonProperty private Object metadata;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("payment_strategy")
    private PaymentStrategy paymentStrategy;

    @JsonProperty("plan_version_id")
    private String planVersionId;

    @JsonProperty("purchase_order")
    private String purchaseOrder;

    @JsonProperty("trial_duration_days")
    private Integer trialDurationDays;

    public CreateCheckoutSessionRequest() {}

    public CreateCheckoutSessionRequest activationCondition(
            SubscriptionActivationConditionEnum activationCondition) {
        this.activationCondition = activationCondition;
        return this;
    }

    /**
     * Get activationCondition
     *
     * @return activationCondition
     */
    @javax.annotation.Nullable
    public SubscriptionActivationConditionEnum getActivationCondition() {
        return activationCondition;
    }

    public void setActivationCondition(SubscriptionActivationConditionEnum activationCondition) {
        this.activationCondition = activationCondition;
    }

    public CreateCheckoutSessionRequest addOns(List<CreateSubscriptionAddOn> addOns) {
        this.addOns = addOns;
        return this;
    }

    public CreateCheckoutSessionRequest addAddOnsItem(CreateSubscriptionAddOn addOnsItem) {
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
    @javax.annotation.Nullable
    public List<CreateSubscriptionAddOn> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<CreateSubscriptionAddOn> addOns) {
        this.addOns = addOns;
    }

    public CreateCheckoutSessionRequest autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
        this.autoAdvanceInvoices = autoAdvanceInvoices;
        return this;
    }

    /**
     * If false, invoices will stay in Draft until manually reviewed and finalized. Default is true.
     *
     * @return autoAdvanceInvoices
     */
    @javax.annotation.Nullable
    public Boolean getAutoAdvanceInvoices() {
        return autoAdvanceInvoices;
    }

    public void setAutoAdvanceInvoices(Boolean autoAdvanceInvoices) {
        this.autoAdvanceInvoices = autoAdvanceInvoices;
    }

    public CreateCheckoutSessionRequest billingDayAnchor(Integer billingDayAnchor) {
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

    public CreateCheckoutSessionRequest billingStartDate(String billingStartDate) {
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

    public CreateCheckoutSessionRequest chargeAutomatically(Boolean chargeAutomatically) {
        this.chargeAutomatically = chargeAutomatically;
        return this;
    }

    /**
     * Automatically try to charge the customer&#x27;s configured payment method on finalize.
     * Default is true.
     *
     * @return chargeAutomatically
     */
    @javax.annotation.Nullable
    public Boolean getChargeAutomatically() {
        return chargeAutomatically;
    }

    public void setChargeAutomatically(Boolean chargeAutomatically) {
        this.chargeAutomatically = chargeAutomatically;
    }

    public CreateCheckoutSessionRequest components(CreateSubscriptionComponents components) {
        this.components = components;
        return this;
    }

    /**
     * Get components
     *
     * @return components
     */
    @javax.annotation.Nullable
    public CreateSubscriptionComponents getComponents() {
        return components;
    }

    public void setComponents(CreateSubscriptionComponents components) {
        this.components = components;
    }

    public CreateCheckoutSessionRequest couponCode(String couponCode) {
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

    public CreateCheckoutSessionRequest couponIds(List<String> couponIds) {
        this.couponIds = couponIds;
        return this;
    }

    public CreateCheckoutSessionRequest addCouponIdsItem(String couponIdsItem) {
        if (this.couponIds == null) {
            this.couponIds = new ArrayList<>();
        }
        this.couponIds.add(couponIdsItem);

        return this;
    }

    /**
     * Get couponIds
     *
     * @return couponIds
     */
    @javax.annotation.Nullable
    public List<String> getCouponIds() {
        return couponIds;
    }

    public void setCouponIds(List<String> couponIds) {
        this.couponIds = couponIds;
    }

    public CreateCheckoutSessionRequest customerId(String customerId) {
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

    public CreateCheckoutSessionRequest endDate(String endDate) {
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

    public CreateCheckoutSessionRequest expiresInHours(Integer expiresInHours) {
        this.expiresInHours = expiresInHours;
        return this;
    }

    /**
     * Session expiry time in hours. Default is 1 hour for self-serve checkout.
     *
     * @return expiresInHours
     */
    @javax.annotation.Nullable
    public Integer getExpiresInHours() {
        return expiresInHours;
    }

    public void setExpiresInHours(Integer expiresInHours) {
        this.expiresInHours = expiresInHours;
    }

    public CreateCheckoutSessionRequest invoiceMemo(String invoiceMemo) {
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

    public CreateCheckoutSessionRequest invoiceThreshold(String invoiceThreshold) {
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

    public CreateCheckoutSessionRequest metadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     *
     * @return metadata
     */
    @javax.annotation.Nullable
    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public CreateCheckoutSessionRequest netTerms(Integer netTerms) {
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

    public CreateCheckoutSessionRequest paymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        return this;
    }

    /**
     * Get paymentStrategy
     *
     * @return paymentStrategy
     */
    @javax.annotation.Nullable
    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public CreateCheckoutSessionRequest planVersionId(String planVersionId) {
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

    public CreateCheckoutSessionRequest purchaseOrder(String purchaseOrder) {
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

    public CreateCheckoutSessionRequest trialDurationDays(Integer trialDurationDays) {
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
     * Create an instance of CreateCheckoutSessionRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateCheckoutSessionRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateCheckoutSessionRequest
     */
    public static CreateCheckoutSessionRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateCheckoutSessionRequest.class);
    }

    /**
     * Convert an instance of CreateCheckoutSessionRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
