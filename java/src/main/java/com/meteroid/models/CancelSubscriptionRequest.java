// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CancelSubscriptionRequest {
    @JsonProperty("effective_date")
    private String effectiveDate;

    @JsonProperty private String reason;

    public CancelSubscriptionRequest() {}

    public CancelSubscriptionRequest effectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    /**
     * If not provided, the cancellation will be effective at the end of the current billing or
     * committed period.
     *
     * @return effectiveDate
     */
    @javax.annotation.Nullable
    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public CancelSubscriptionRequest reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     */
    @javax.annotation.Nullable
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Create an instance of CancelSubscriptionRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CancelSubscriptionRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CancelSubscriptionRequest
     */
    public static CancelSubscriptionRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CancelSubscriptionRequest.class);
    }

    /**
     * Convert an instance of CancelSubscriptionRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
