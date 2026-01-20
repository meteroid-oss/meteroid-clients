// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum PaymentMethodTypeEnum implements ToQueryParam {
    CARD("Card"),
    BANK_TRANSFER("BankTransfer"),
    WALLET("Wallet"),
    OTHER("Other");
    private final String value;

    PaymentMethodTypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @Override
    public String toQueryParam() {
        return this.value;
    }
}
