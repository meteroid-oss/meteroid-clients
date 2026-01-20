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
public class ComponentOverride {
    @JsonProperty private SubscriptionComponent component;

    @JsonProperty("component_id")
    private String componentId;

    public ComponentOverride() {}

    public ComponentOverride component(SubscriptionComponent component) {
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

    public ComponentOverride componentId(String componentId) {
        this.componentId = componentId;
        return this;
    }

    /**
     * Get componentId
     *
     * @return componentId
     */
    @javax.annotation.Nonnull
    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    /**
     * Create an instance of ComponentOverride given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ComponentOverride
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ComponentOverride
     */
    public static ComponentOverride fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ComponentOverride.class);
    }

    /**
     * Convert an instance of ComponentOverride to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
