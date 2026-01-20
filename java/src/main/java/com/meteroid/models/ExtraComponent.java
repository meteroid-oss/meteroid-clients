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
public class ExtraComponent {
    @JsonProperty private SubscriptionComponent component;

    public ExtraComponent() {}

    public ExtraComponent component(SubscriptionComponent component) {
        this.component = component;
        return this;
    }

    /**
     * Get component
     *
     * @return component
     */
    @javax.annotation.Nonnull
    public SubscriptionComponent getComponent() {
        return component;
    }

    public void setComponent(SubscriptionComponent component) {
        this.component = component;
    }

    /**
     * Create an instance of ExtraComponent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ExtraComponent
     * @throws JsonProcessingException if the JSON string is invalid with respect to ExtraComponent
     */
    public static ExtraComponent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ExtraComponent.class);
    }

    /**
     * Convert an instance of ExtraComponent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
