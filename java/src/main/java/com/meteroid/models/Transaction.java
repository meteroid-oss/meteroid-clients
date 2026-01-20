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
public class Transaction {
    @JsonProperty private Long amount;
    @JsonProperty private String currency;
    @JsonProperty private String error;
    @JsonProperty private String id;

    @JsonProperty("payment_method_id")
    private String paymentMethodId;

    @JsonProperty("payment_method_info")
    private PaymentMethodInfo paymentMethodInfo;

    @JsonProperty("payment_type")
    private PaymentTypeEnum paymentType;

    @JsonProperty("processed_at")
    private OffsetDateTime processedAt;

    @JsonProperty("provider_transaction_id")
    private String providerTransactionId;

    @JsonProperty private PaymentStatusEnum status;

    public Transaction() {}

    public Transaction amount(Long amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     */
    @javax.annotation.Nonnull
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Transaction currency(String currency) {
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

    public Transaction error(String error) {
        this.error = error;
        return this;
    }

    /**
     * Get error
     *
     * @return error
     */
    @javax.annotation.Nullable
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Transaction id(String id) {
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

    public Transaction paymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
        return this;
    }

    /**
     * Get paymentMethodId
     *
     * @return paymentMethodId
     */
    @javax.annotation.Nullable
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Transaction paymentMethodInfo(PaymentMethodInfo paymentMethodInfo) {
        this.paymentMethodInfo = paymentMethodInfo;
        return this;
    }

    /**
     * Get paymentMethodInfo
     *
     * @return paymentMethodInfo
     */
    @javax.annotation.Nullable
    public PaymentMethodInfo getPaymentMethodInfo() {
        return paymentMethodInfo;
    }

    public void setPaymentMethodInfo(PaymentMethodInfo paymentMethodInfo) {
        this.paymentMethodInfo = paymentMethodInfo;
    }

    public Transaction paymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    /**
     * Get paymentType
     *
     * @return paymentType
     */
    @javax.annotation.Nonnull
    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public Transaction processedAt(OffsetDateTime processedAt) {
        this.processedAt = processedAt;
        return this;
    }

    /**
     * Get processedAt
     *
     * @return processedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(OffsetDateTime processedAt) {
        this.processedAt = processedAt;
    }

    public Transaction providerTransactionId(String providerTransactionId) {
        this.providerTransactionId = providerTransactionId;
        return this;
    }

    /**
     * Get providerTransactionId
     *
     * @return providerTransactionId
     */
    @javax.annotation.Nullable
    public String getProviderTransactionId() {
        return providerTransactionId;
    }

    public void setProviderTransactionId(String providerTransactionId) {
        this.providerTransactionId = providerTransactionId;
    }

    public Transaction status(PaymentStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    /**
     * Create an instance of Transaction given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Transaction
     * @throws JsonProcessingException if the JSON string is invalid with respect to Transaction
     */
    public static Transaction fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Transaction.class);
    }

    /**
     * Convert an instance of Transaction to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
