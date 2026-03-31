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

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class SubscriptionUpdateRequest {
    @JsonProperty("auto_advance_invoices")
    private Boolean autoAdvanceInvoices;

    @JsonProperty("charge_automatically")
    private Boolean chargeAutomatically;

    @JsonProperty("invoice_memo")
    private String invoiceMemo;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("payment_methods_config")
    private PaymentMethodsConfig paymentMethodsConfig;

    @JsonProperty("purchase_order")
    private String purchaseOrder;

    public SubscriptionUpdateRequest() {}

    public SubscriptionUpdateRequest autoAdvanceInvoices(Boolean autoAdvanceInvoices) {
        this.autoAdvanceInvoices = autoAdvanceInvoices;
        return this;
    }

    /**
     * If false, invoices will stay in Draft until manually reviewed and finalized.
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

    public SubscriptionUpdateRequest chargeAutomatically(Boolean chargeAutomatically) {
        this.chargeAutomatically = chargeAutomatically;
        return this;
    }

    /**
     * Automatically try to charge the customer&#x27;s configured payment method on finalize.
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

    public SubscriptionUpdateRequest invoiceMemo(String invoiceMemo) {
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

    public SubscriptionUpdateRequest netTerms(Integer netTerms) {
        this.netTerms = netTerms;
        return this;
    }

    /**
     * Payment terms in days (0 = due on issue)
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

    public SubscriptionUpdateRequest paymentMethodsConfig(
            PaymentMethodsConfig paymentMethodsConfig) {
        this.paymentMethodsConfig = paymentMethodsConfig;
        return this;
    }

    /**
     * Get paymentMethodsConfig
     *
     * @return paymentMethodsConfig
     */
    @javax.annotation.Nullable
    public PaymentMethodsConfig getPaymentMethodsConfig() {
        return paymentMethodsConfig;
    }

    public void setPaymentMethodsConfig(PaymentMethodsConfig paymentMethodsConfig) {
        this.paymentMethodsConfig = paymentMethodsConfig;
    }

    public SubscriptionUpdateRequest purchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        return this;
    }

    /**
     * Purchase order number
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

    /**
     * Create an instance of SubscriptionUpdateRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionUpdateRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionUpdateRequest
     */
    public static SubscriptionUpdateRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionUpdateRequest.class);
    }

    /**
     * Convert an instance of SubscriptionUpdateRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
