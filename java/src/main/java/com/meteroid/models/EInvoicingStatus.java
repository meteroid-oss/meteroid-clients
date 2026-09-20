// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum EInvoicingStatus implements ToQueryParam {
    GENERATED("GENERATED"),
    FAILED("FAILED");
    private final String value;

    EInvoicingStatus(String value) {
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
