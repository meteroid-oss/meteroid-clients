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

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ComponentsScope {
    @JsonProperty("component_names")
    private List<String> componentNames;

    public ComponentsScope() {}

    public ComponentsScope componentNames(List<String> componentNames) {
        this.componentNames = componentNames;
        return this;
    }

    public ComponentsScope addComponentNamesItem(String componentNamesItem) {
        if (this.componentNames == null) {
            this.componentNames = new ArrayList<>();
        }
        this.componentNames.add(componentNamesItem);

        return this;
    }

    /**
     * Get componentNames
     *
     * @return componentNames
     */
    @javax.annotation.Nonnull
    public List<String> getComponentNames() {
        return componentNames;
    }

    public void setComponentNames(List<String> componentNames) {
        this.componentNames = componentNames;
    }

    /**
     * Create an instance of ComponentsScope given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ComponentsScope
     * @throws JsonProcessingException if the JSON string is invalid with respect to ComponentsScope
     */
    public static ComponentsScope fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ComponentsScope.class);
    }

    /**
     * Convert an instance of ComponentsScope to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
