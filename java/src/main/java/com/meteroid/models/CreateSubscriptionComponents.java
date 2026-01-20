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
public class CreateSubscriptionComponents {
    @JsonProperty("extra_components")
    private List<ExtraComponent> extraComponents;

    @JsonProperty("overridden_components")
    private List<ComponentOverride> overriddenComponents;

    @JsonProperty("parameterized_components")
    private List<ComponentParameterization> parameterizedComponents;

    @JsonProperty("remove_components")
    private List<String> removeComponents;

    public CreateSubscriptionComponents() {}

    public CreateSubscriptionComponents extraComponents(List<ExtraComponent> extraComponents) {
        this.extraComponents = extraComponents;
        return this;
    }

    public CreateSubscriptionComponents addExtraComponentsItem(ExtraComponent extraComponentsItem) {
        if (this.extraComponents == null) {
            this.extraComponents = new ArrayList<>();
        }
        this.extraComponents.add(extraComponentsItem);

        return this;
    }

    /**
     * Get extraComponents
     *
     * @return extraComponents
     */
    @javax.annotation.Nullable
    public List<ExtraComponent> getExtraComponents() {
        return extraComponents;
    }

    public void setExtraComponents(List<ExtraComponent> extraComponents) {
        this.extraComponents = extraComponents;
    }

    public CreateSubscriptionComponents overriddenComponents(
            List<ComponentOverride> overriddenComponents) {
        this.overriddenComponents = overriddenComponents;
        return this;
    }

    public CreateSubscriptionComponents addOverriddenComponentsItem(
            ComponentOverride overriddenComponentsItem) {
        if (this.overriddenComponents == null) {
            this.overriddenComponents = new ArrayList<>();
        }
        this.overriddenComponents.add(overriddenComponentsItem);

        return this;
    }

    /**
     * Get overriddenComponents
     *
     * @return overriddenComponents
     */
    @javax.annotation.Nullable
    public List<ComponentOverride> getOverriddenComponents() {
        return overriddenComponents;
    }

    public void setOverriddenComponents(List<ComponentOverride> overriddenComponents) {
        this.overriddenComponents = overriddenComponents;
    }

    public CreateSubscriptionComponents parameterizedComponents(
            List<ComponentParameterization> parameterizedComponents) {
        this.parameterizedComponents = parameterizedComponents;
        return this;
    }

    public CreateSubscriptionComponents addParameterizedComponentsItem(
            ComponentParameterization parameterizedComponentsItem) {
        if (this.parameterizedComponents == null) {
            this.parameterizedComponents = new ArrayList<>();
        }
        this.parameterizedComponents.add(parameterizedComponentsItem);

        return this;
    }

    /**
     * Get parameterizedComponents
     *
     * @return parameterizedComponents
     */
    @javax.annotation.Nullable
    public List<ComponentParameterization> getParameterizedComponents() {
        return parameterizedComponents;
    }

    public void setParameterizedComponents(
            List<ComponentParameterization> parameterizedComponents) {
        this.parameterizedComponents = parameterizedComponents;
    }

    public CreateSubscriptionComponents removeComponents(List<String> removeComponents) {
        this.removeComponents = removeComponents;
        return this;
    }

    public CreateSubscriptionComponents addRemoveComponentsItem(String removeComponentsItem) {
        if (this.removeComponents == null) {
            this.removeComponents = new ArrayList<>();
        }
        this.removeComponents.add(removeComponentsItem);

        return this;
    }

    /**
     * Get removeComponents
     *
     * @return removeComponents
     */
    @javax.annotation.Nullable
    public List<String> getRemoveComponents() {
        return removeComponents;
    }

    public void setRemoveComponents(List<String> removeComponents) {
        this.removeComponents = removeComponents;
    }

    /**
     * Create an instance of CreateSubscriptionComponents given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateSubscriptionComponents
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateSubscriptionComponents
     */
    public static CreateSubscriptionComponents fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateSubscriptionComponents.class);
    }

    /**
     * Convert an instance of CreateSubscriptionComponents to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
