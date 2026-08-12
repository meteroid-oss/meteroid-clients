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
public class ConfigResolvedEntitlementValue {
    @JsonProperty private ConfigValue value;

    public ConfigResolvedEntitlementValue() {}

    public ConfigResolvedEntitlementValue value(ConfigValue value) {
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
     * Create an instance of ConfigResolvedEntitlementValue given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConfigResolvedEntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ConfigResolvedEntitlementValue
     */
    public static ConfigResolvedEntitlementValue fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ConfigResolvedEntitlementValue.class);
    }

    /**
     * Convert an instance of ConfigResolvedEntitlementValue to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
