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
public class ResolvedEntitlement {
    @JsonProperty private FeatureRef feature;
    @JsonProperty private ResolvedEntitlementValue value;

    public ResolvedEntitlement() {}

    public ResolvedEntitlement feature(FeatureRef feature) {
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

    public ResolvedEntitlement value(ResolvedEntitlementValue value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     */
    @javax.annotation.Nonnull
    public ResolvedEntitlementValue getValue() {
        return value;
    }

    public void setValue(ResolvedEntitlementValue value) {
        this.value = value;
    }

    /**
     * Create an instance of ResolvedEntitlement given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ResolvedEntitlement
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ResolvedEntitlement
     */
    public static ResolvedEntitlement fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ResolvedEntitlement.class);
    }

    /**
     * Convert an instance of ResolvedEntitlement to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
