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
public class CancelSubscriptionResponse {
    @JsonProperty private Subscription subscription;

    public CancelSubscriptionResponse() {}

    public CancelSubscriptionResponse subscription(Subscription subscription) {
        this.subscription = subscription;
        return this;
    }

    /**
     * Get subscription
     *
     * @return subscription
     */
    @javax.annotation.Nonnull
    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * Create an instance of CancelSubscriptionResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CancelSubscriptionResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CancelSubscriptionResponse
     */
    public static CancelSubscriptionResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CancelSubscriptionResponse.class);
    }

    /**
     * Convert an instance of CancelSubscriptionResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
