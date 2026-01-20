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
public class CreateSubscriptionAddOn {
    @JsonProperty("add_on_id")
    private String addOnId;

    @JsonProperty private SubscriptionAddOnCustomization customization;

    public CreateSubscriptionAddOn() {}

    public CreateSubscriptionAddOn addOnId(String addOnId) {
        this.addOnId = addOnId;
        return this;
    }

    /**
     * Get addOnId
     *
     * @return addOnId
     */
    @javax.annotation.Nonnull
    public String getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(String addOnId) {
        this.addOnId = addOnId;
    }

    public CreateSubscriptionAddOn customization(SubscriptionAddOnCustomization customization) {
        this.customization = customization;
        return this;
    }

    /**
     * Get customization
     *
     * @return customization
     */
    @javax.annotation.Nullable
    public SubscriptionAddOnCustomization getCustomization() {
        return customization;
    }

    public void setCustomization(SubscriptionAddOnCustomization customization) {
        this.customization = customization;
    }

    /**
     * Create an instance of CreateSubscriptionAddOn given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateSubscriptionAddOn
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateSubscriptionAddOn
     */
    public static CreateSubscriptionAddOn fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateSubscriptionAddOn.class);
    }

    /**
     * Convert an instance of CreateSubscriptionAddOn to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
