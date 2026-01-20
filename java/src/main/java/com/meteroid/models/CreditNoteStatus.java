// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CreditNoteStatus implements ToQueryParam {
    DRAFT("DRAFT"),
    FINALIZED("FINALIZED"),
    VOIDED("VOIDED");
    private final String value;

    CreditNoteStatus(String value) {
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
