// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum SubscriptionStatusEnum implements ToQueryParam {
    PENDING_ACTIVATION("PENDING_ACTIVATION"),
    PENDING_CHARGE("PENDING_CHARGE"),
    TRIAL_ACTIVE("TRIAL_ACTIVE"),
    ACTIVE("ACTIVE"),
    TRIAL_EXPIRED("TRIAL_EXPIRED"),
    PAUSED("PAUSED"),
    SUSPENDED("SUSPENDED"),
    CANCELLED("CANCELLED"),
    COMPLETED("COMPLETED"),
    SUPERSEDED("SUPERSEDED"),
    ERRORED("ERRORED");
    private final String value;

    SubscriptionStatusEnum(String value) {
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
