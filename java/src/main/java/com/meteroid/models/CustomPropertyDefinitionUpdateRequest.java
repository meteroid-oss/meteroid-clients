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
public class CustomPropertyDefinitionUpdateRequest {
    @JsonProperty private PropertyConfig config;

    @JsonProperty("default_value")
    private Object defaultValue;

    @JsonProperty private String description;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty private String name;
    @JsonProperty private Boolean required;

    public CustomPropertyDefinitionUpdateRequest() {}

    public CustomPropertyDefinitionUpdateRequest config(PropertyConfig config) {
        this.config = config;
        return this;
    }

    /**
     * Get config
     *
     * @return config
     */
    @javax.annotation.Nullable
    public PropertyConfig getConfig() {
        return config;
    }

    public void setConfig(PropertyConfig config) {
        this.config = config;
    }

    public CustomPropertyDefinitionUpdateRequest defaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    /**
     * Get defaultValue
     *
     * @return defaultValue
     */
    @javax.annotation.Nullable
    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public CustomPropertyDefinitionUpdateRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomPropertyDefinitionUpdateRequest displayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
        return this;
    }

    /**
     * Get displayOrder
     *
     * @return displayOrder
     */
    @javax.annotation.Nullable
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public CustomPropertyDefinitionUpdateRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomPropertyDefinitionUpdateRequest required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * Get required
     *
     * @return required
     */
    @javax.annotation.Nullable
    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * Create an instance of CustomPropertyDefinitionUpdateRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CustomPropertyDefinitionUpdateRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CustomPropertyDefinitionUpdateRequest
     */
    public static CustomPropertyDefinitionUpdateRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper()
                .readValue(jsonString, CustomPropertyDefinitionUpdateRequest.class);
    }

    /**
     * Convert an instance of CustomPropertyDefinitionUpdateRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
