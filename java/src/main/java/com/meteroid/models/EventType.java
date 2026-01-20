// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum EventType implements ToQueryParam {
    METRIC_CREATED("metric.created"),
    CUSTOMER_CREATED("customer.created"),
    SUBSCRIPTION_CREATED("subscription.created"),
    INVOICE_CREATED("invoice.created"),
    INVOICE_FINALIZED("invoice.finalized"),
    INVOICE_PAID("invoice.paid"),
    INVOICE_VOIDED("invoice.voided"),
    QUOTE_ACCEPTED("quote.accepted"),
    QUOTE_CONVERTED("quote.converted"),
    CREDIT_NOTE_CREATED("credit_note.created"),
    CREDIT_NOTE_FINALIZED("credit_note.finalized"),
    CREDIT_NOTE_VOIDED("credit_note.voided");
    private final String value;

    EventType(String value) {
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
