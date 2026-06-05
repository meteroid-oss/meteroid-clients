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
public class EffectiveEntitlement {
    @JsonProperty private FeatureRef feature;
    @JsonProperty private EffectiveEntitlementValue value;

    public EffectiveEntitlement() {}

    public EffectiveEntitlement feature(FeatureRef feature) {
        this.feature = feature;
        return this;
    }

    /**
     * Get feature
     *
     * @return feature
     */
    @javax.annotation.Nonnull
    public FeatureRef getFeature() {
        return feature;
    }

    public void setFeature(FeatureRef feature) {
        this.feature = feature;
    }

    public EffectiveEntitlement value(EffectiveEntitlementValue value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     */
    @javax.annotation.Nonnull
    public EffectiveEntitlementValue getValue() {
        return value;
    }

    public void setValue(EffectiveEntitlementValue value) {
        this.value = value;
    }

    /**
     * Create an instance of EffectiveEntitlement given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of EffectiveEntitlement
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     EffectiveEntitlement
     */
    public static EffectiveEntitlement fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, EffectiveEntitlement.class);
    }

    /**
     * Convert an instance of EffectiveEntitlement to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
