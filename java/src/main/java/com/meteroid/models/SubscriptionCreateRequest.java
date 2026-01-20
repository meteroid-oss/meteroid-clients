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
public class SubscriptionCreateRequest {
    @JsonProperty("activation_condition")
    private SubscriptionActivationConditionEnum activationCondition;

    @JsonProperty("add_ons")
    private List<CreateSubscriptionAddOn> addOns;

    @JsonProperty("auto_advance_invoices")
    private Boolean autoAdvanceInvoices;

    @JsonProperty("billing_day_anchor")
    private Integer billingDayAnchor;

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty("coupon_codes")
    private List<String> couponCodes;

    @JsonProperty("customer_id_or_alias")
    private String customerIdOrAlias;

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("invoice_memo")
    private String invoiceMemo;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("plan_id")
    private String planId;

    @JsonProperty("price_components")
    private CreateSubscriptionComponents priceComponents;

    @JsonProperty("purchase_order")
    private String purchaseOrder;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("trial_days")
    private Integer trialDays;

    @JsonProperty private Integer version;

    public SubscriptionCreateRequest() {}

    public SubscriptionCreateRequest activationCondition(
            SubscriptionActivationConditionEnum activationCondition) {
        this.activationCondition = activationCondition;
        return this;
    }

    /**
     * Get activationCondition
     *
     * @return activationCondition
     */
    @javax.annotation.Nonnull
    public SubscriptionActivationConditionEnum getActivationCondition() {
        return activationCondition;
    }

    public void setActivationCondition(SubscriptionActivationConditionEnum activationCondition) {
        this.activationCondition = activationCondition;
    }

    public SubscriptionCreateRequest addOns(List<CreateSubscriptionAddOn> addOns) {
        this.addOns = addOns;
        return this;
    }

    public SubscriptionCreateRequest addAddOnsItem(CreateSubscriptionAddOn addOnsItem) {
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

    public SubscriptionCreateRequest autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
        this.autoAdvanceInvoices = autoAdvanceInvoices;
        return this;
    }

    /**
     * Get autoAdvanceInvoices
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

    public SubscriptionCreateRequest billingDayAnchor(Integer billingDayAnchor) {
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

    public SubscriptionCreateRequest chargeAutomatically(Boolean chargeAutomatically) {
        this.chargeAutomatically = chargeAutomatically;
        return this;
    }

    /**
     * Get chargeAutomatically
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

    public SubscriptionCreateRequest couponCodes(List<String> couponCodes) {
        this.couponCodes = couponCodes;
        return this;
    }

    public SubscriptionCreateRequest addCouponCodesItem(String couponCodesItem) {
        if (this.couponCodes == null) {
            this.couponCodes = new ArrayList<>();
        }
        this.couponCodes.add(couponCodesItem);

        return this;
    }

    /**
     * Get couponCodes
     *
     * @return couponCodes
     */
    @javax.annotation.Nullable
    public List<String> getCouponCodes() {
        return couponCodes;
    }

    public void setCouponCodes(List<String> couponCodes) {
        this.couponCodes = couponCodes;
    }

    public SubscriptionCreateRequest customerIdOrAlias(String customerIdOrAlias) {
        this.customerIdOrAlias = customerIdOrAlias;
        return this;
    }

    /**
     * Get customerIdOrAlias
     *
     * @return customerIdOrAlias
     */
    @javax.annotation.Nonnull
    public String getCustomerIdOrAlias() {
        return customerIdOrAlias;
    }

    public void setCustomerIdOrAlias(String customerIdOrAlias) {
        this.customerIdOrAlias = customerIdOrAlias;
    }

    public SubscriptionCreateRequest endDate(String endDate) {
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

    public SubscriptionCreateRequest invoiceMemo(String invoiceMemo) {
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

    public SubscriptionCreateRequest netTerms(Integer netTerms) {
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

    public SubscriptionCreateRequest planId(String planId) {
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

    public SubscriptionCreateRequest priceComponents(CreateSubscriptionComponents priceComponents) {
        this.priceComponents = priceComponents;
        return this;
    }

    /**
     * Get priceComponents
     *
     * @return priceComponents
     */
    @javax.annotation.Nullable
    public CreateSubscriptionComponents getPriceComponents() {
        return priceComponents;
    }

    public void setPriceComponents(CreateSubscriptionComponents priceComponents) {
        this.priceComponents = priceComponents;
    }

    public SubscriptionCreateRequest purchaseOrder(String purchaseOrder) {
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

    public SubscriptionCreateRequest startDate(String startDate) {
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

    public SubscriptionCreateRequest trialDays(Integer trialDays) {
        this.trialDays = trialDays;
        return this;
    }

    /**
     * Get trialDays
     *
     * @return trialDays
     */
    @javax.annotation.Nullable
    public Integer getTrialDays() {
        return trialDays;
    }

    public void setTrialDays(Integer trialDays) {
        this.trialDays = trialDays;
    }

    public SubscriptionCreateRequest version(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     *
     * @return version
     */
    @javax.annotation.Nullable
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Create an instance of SubscriptionCreateRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionCreateRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionCreateRequest
     */
    public static SubscriptionCreateRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionCreateRequest.class);
    }

    /**
     * Convert an instance of SubscriptionCreateRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
