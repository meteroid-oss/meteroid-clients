// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum InvoicePaymentStatus implements ToQueryParam {
    UNPAID("Unpaid"),
    PARTIALLY_PAID("PartiallyPaid"),
    PAID("Paid"),
    ERRORED("Errored");
    private final String value;

    InvoicePaymentStatus(String value) {
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
