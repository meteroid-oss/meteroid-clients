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
public class QuoteEventData {
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("quote_id")
    private String quoteId;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    public QuoteEventData() {}

    public QuoteEventData customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Get customerId
     *
     * @return customerId
     */
    @javax.annotation.Nonnull
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public QuoteEventData quoteId(String quoteId) {
        this.quoteId = quoteId;
        return this;
    }

    /**
     * Get quoteId
     *
     * @return quoteId
     */
    @javax.annotation.Nonnull
    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public QuoteEventData subscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /**
     * Get subscriptionId
     *
     * @return subscriptionId
     */
    @javax.annotation.Nullable
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Create an instance of QuoteEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of QuoteEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to QuoteEventData
     */
    public static QuoteEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, QuoteEventData.class);
    }

    /**
     * Convert an instance of QuoteEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
