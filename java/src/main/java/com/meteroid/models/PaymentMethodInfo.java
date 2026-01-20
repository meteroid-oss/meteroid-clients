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
public class PaymentMethodInfo {
    @JsonProperty("account_number_hint")
    private String accountNumberHint;

    @JsonProperty("card_brand")
    private String cardBrand;

    @JsonProperty("card_last4")
    private String cardLast4;

    @JsonProperty("payment_method_type")
    private PaymentMethodTypeEnum paymentMethodType;

    public PaymentMethodInfo() {}

    public PaymentMethodInfo accountNumberHint(String accountNumberHint) {
        this.accountNumberHint = accountNumberHint;
        return this;
    }

    /**
     * Get accountNumberHint
     *
     * @return accountNumberHint
     */
    @javax.annotation.Nullable
    public String getAccountNumberHint() {
        return accountNumberHint;
    }

    public void setAccountNumberHint(String accountNumberHint) {
        this.accountNumberHint = accountNumberHint;
    }

    public PaymentMethodInfo cardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
        return this;
    }

    /**
     * Get cardBrand
     *
     * @return cardBrand
     */
    @javax.annotation.Nullable
    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public PaymentMethodInfo cardLast4(String cardLast4) {
        this.cardLast4 = cardLast4;
        return this;
    }

    /**
     * Get cardLast4
     *
     * @return cardLast4
     */
    @javax.annotation.Nullable
    public String getCardLast4() {
        return cardLast4;
    }

    public void setCardLast4(String cardLast4) {
        this.cardLast4 = cardLast4;
    }

    public PaymentMethodInfo paymentMethodType(PaymentMethodTypeEnum paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
        return this;
    }

    /**
     * Get paymentMethodType
     *
     * @return paymentMethodType
     */
    @javax.annotation.Nonnull
    public PaymentMethodTypeEnum getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(PaymentMethodTypeEnum paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    /**
     * Create an instance of PaymentMethodInfo given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PaymentMethodInfo
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     PaymentMethodInfo
     */
    public static PaymentMethodInfo fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PaymentMethodInfo.class);
    }

    /**
     * Convert an instance of PaymentMethodInfo to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
