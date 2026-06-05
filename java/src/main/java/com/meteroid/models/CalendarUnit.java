// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CalendarUnit implements ToQueryParam {
    HOUR("HOUR"),
    DAY("DAY"),
    WEEK("WEEK"),
    MONTH("MONTH"),
    YEAR("YEAR");
    private final String value;

    CalendarUnit(String value) {
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
