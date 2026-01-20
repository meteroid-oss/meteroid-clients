// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum TaxExemptionType implements ToQueryParam {
    REVERSE_CHARGE("ReverseCharge"),
    TAX_EXEMPT("TaxExempt"),
    NOT_REGISTERED("NotRegistered");
    private final String value;

    TaxExemptionType(String value) {
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
