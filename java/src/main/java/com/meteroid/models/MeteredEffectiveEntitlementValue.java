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
public class MeteredEffectiveEntitlementValue {
    @JsonProperty private MeteredEntitlementSpec spec;
    @JsonProperty private MeteredEntitlementUsage usage;

    public MeteredEffectiveEntitlementValue() {}

    public MeteredEffectiveEntitlementValue spec(MeteredEntitlementSpec spec) {
        this.spec = spec;
        return this;
    }

    /**
     * Get spec
     *
     * @return spec
     */
    @javax.annotation.Nonnull
    public MeteredEntitlementSpec getSpec() {
        return spec;
    }

    public void setSpec(MeteredEntitlementSpec spec) {
        this.spec = spec;
    }

    public MeteredEffectiveEntitlementValue usage(MeteredEntitlementUsage usage) {
        this.usage = usage;
        return this;
    }

    /**
     * Get usage
     *
     * @return usage
     */
    @javax.annotation.Nonnull
    public MeteredEntitlementUsage getUsage() {
        return usage;
    }

    public void setUsage(MeteredEntitlementUsage usage) {
        this.usage = usage;
    }

    /**
     * Create an instance of MeteredEffectiveEntitlementValue given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MeteredEffectiveEntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MeteredEffectiveEntitlementValue
     */
    public static MeteredEffectiveEntitlementValue fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper()
                .readValue(jsonString, MeteredEffectiveEntitlementValue.class);
    }

    /**
     * Convert an instance of MeteredEffectiveEntitlementValue to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
