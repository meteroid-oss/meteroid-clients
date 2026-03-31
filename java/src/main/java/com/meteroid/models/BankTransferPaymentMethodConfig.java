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
public class BankTransferPaymentMethodConfig {
    @JsonProperty("account_id")
    private String accountId;

    public BankTransferPaymentMethodConfig() {}

    public BankTransferPaymentMethodConfig accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Get accountId
     *
     * @return accountId
     */
    @javax.annotation.Nullable
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Create an instance of BankTransferPaymentMethodConfig given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BankTransferPaymentMethodConfig
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BankTransferPaymentMethodConfig
     */
    public static BankTransferPaymentMethodConfig fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BankTransferPaymentMethodConfig.class);
    }

    /**
     * Convert an instance of BankTransferPaymentMethodConfig to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
