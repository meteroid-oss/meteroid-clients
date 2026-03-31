// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum InvoiceStatus implements ToQueryParam {
    DRAFT("DRAFT"),
    FINALIZED("FINALIZED"),
    UNCOLLECTIBLE("UNCOLLECTIBLE"),
    VOID("VOID");
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
