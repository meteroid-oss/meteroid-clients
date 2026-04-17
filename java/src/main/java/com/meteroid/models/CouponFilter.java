// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CouponFilter implements ToQueryParam {
    ALL("ALL"),
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    ARCHIVED("ARCHIVED");
    private final String value;

    CouponFilter(String value) {
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
