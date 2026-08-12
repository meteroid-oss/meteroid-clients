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
public class ConfigEffectiveEntitlementValue {
    @JsonProperty private ConfigValue value;

    public ConfigEffectiveEntitlementValue() {}

    public ConfigEffectiveEntitlementValue value(ConfigValue value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     */
    @javax.annotation.Nonnull
    public ConfigValue getValue() {
        return value;
    }

    public void setValue(ConfigValue value) {
        this.value = value;
    }

    /**
     * Create an instance of ConfigEffectiveEntitlementValue given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConfigEffectiveEntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ConfigEffectiveEntitlementValue
     */
    public static ConfigEffectiveEntitlementValue fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ConfigEffectiveEntitlementValue.class);
    }

    /**
     * Convert an instance of ConfigEffectiveEntitlementValue to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
