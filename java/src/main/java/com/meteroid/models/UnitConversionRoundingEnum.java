// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum UnitConversionRoundingEnum implements ToQueryParam {
    UP("UP"),
    DOWN("DOWN"),
    NEAREST("NEAREST"),
    NEAREST_HALF("NEAREST_HALF"),
    NEAREST_DECILE("NEAREST_DECILE"),
    NONE("NONE");
    private final String value;

    UnitConversionRoundingEnum(String value) {
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
