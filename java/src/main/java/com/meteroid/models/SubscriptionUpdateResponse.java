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
public class SubscriptionUpdateResponse {
    @JsonProperty private SubscriptionDetails subscription;

    public SubscriptionUpdateResponse() {}

    public SubscriptionUpdateResponse subscription(SubscriptionDetails subscription) {
        this.subscription = subscription;
        return this;
    }

    /**
     * Get subscription
     *
     * @return subscription
     */
    @javax.annotation.Nonnull
    public SubscriptionDetails getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionDetails subscription) {
        this.subscription = subscription;
    }

    /**
     * Create an instance of SubscriptionUpdateResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionUpdateResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionUpdateResponse
     */
    public static SubscriptionUpdateResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionUpdateResponse.class);
    }

    /**
     * Convert an instance of SubscriptionUpdateResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
