// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum SubscriptionUpdateType implements ToQueryParam {
    ACTIVATED("activated"),
    TRIAL_ENDED("trial_ended"),
    BILLING_CONFIGURATION_UPDATED("billing_configuration_updated"),
    PLAN_CHANGED("plan_changed"),
    AMENDED("amended"),
    UNITS_CHANGED("units_changed"),
    PAUSED("paused"),
    CANCELLATION_SCHEDULED("cancellation_scheduled");
    private final String value;

    SubscriptionUpdateType(String value) {
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
