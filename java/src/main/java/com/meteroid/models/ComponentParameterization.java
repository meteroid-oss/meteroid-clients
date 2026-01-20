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
public class ComponentParameterization {
    @JsonProperty("component_id")
    private String componentId;

    @JsonProperty private ComponentParameters parameters;

    public ComponentParameterization() {}

    public ComponentParameterization componentId(String componentId) {
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

    public ComponentParameterization parameters(ComponentParameters parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get parameters
     *
     * @return parameters
     */
    @javax.annotation.Nonnull
    public ComponentParameters getParameters() {
        return parameters;
    }

    public void setParameters(ComponentParameters parameters) {
        this.parameters = parameters;
    }

    /**
     * Create an instance of ComponentParameterization given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ComponentParameterization
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ComponentParameterization
     */
    public static ComponentParameterization fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ComponentParameterization.class);
    }

    /**
     * Convert an instance of ComponentParameterization to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
