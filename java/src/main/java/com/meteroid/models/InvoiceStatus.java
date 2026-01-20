// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum InvoiceStatus implements ToQueryParam {
    DRAFT("Draft"),
    FINALIZED("Finalized"),
    UNCOLLECTIBLE("Uncollectible"),
    VOID("Void");
    private final String value;

    InvoiceStatus(String value) {
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
