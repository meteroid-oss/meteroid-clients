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
public class BooleanEntitlementValue {
    @JsonProperty private Boolean enabled;

    public BooleanEntitlementValue() {}

    public BooleanEntitlementValue enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     */
    @javax.annotation.Nonnull
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Create an instance of BooleanEntitlementValue given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BooleanEntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BooleanEntitlementValue
     */
    public static BooleanEntitlementValue fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BooleanEntitlementValue.class);
    }

    /**
     * Convert an instance of BooleanEntitlementValue to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
