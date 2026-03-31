// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum ExtraRecurringBillingTypeEnum implements ToQueryParam {
    ADVANCE("ADVANCE"),
    ARREARS("ARREARS");
    private final String value;

    ExtraRecurringBillingTypeEnum(String value) {
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
