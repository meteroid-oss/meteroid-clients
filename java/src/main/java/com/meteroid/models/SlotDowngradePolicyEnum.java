// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum SlotDowngradePolicyEnum implements ToQueryParam {
    REMOVE_AT_END_OF_PERIOD("REMOVE_AT_END_OF_PERIOD");
    private final String value;

    SlotDowngradePolicyEnum(String value) {
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
