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
public class SubscriptionAddOnPriceOverride {
    @JsonProperty private String name;

    @JsonProperty("price_entry")
    private PriceEntry priceEntry;

    public SubscriptionAddOnPriceOverride() {}

    public SubscriptionAddOnPriceOverride name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubscriptionAddOnPriceOverride priceEntry(PriceEntry priceEntry) {
        this.priceEntry = priceEntry;
        return this;
    }

    /**
     * Get priceEntry
     *
     * @return priceEntry
     */
    @javax.annotation.Nonnull
    public PriceEntry getPriceEntry() {
        return priceEntry;
    }

    public void setPriceEntry(PriceEntry priceEntry) {
        this.priceEntry = priceEntry;
    }

    /**
     * Create an instance of SubscriptionAddOnPriceOverride given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionAddOnPriceOverride
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionAddOnPriceOverride
     */
    public static SubscriptionAddOnPriceOverride fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionAddOnPriceOverride.class);
    }

    /**
     * Convert an instance of SubscriptionAddOnPriceOverride to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
