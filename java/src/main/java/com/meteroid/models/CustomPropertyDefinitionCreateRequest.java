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
public class CustomPropertyDefinitionCreateRequest {
    @JsonProperty private PropertyConfig config;

    @JsonProperty("default_value")
    private Object defaultValue;

    @JsonProperty private String description;

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("entity_type")
    private CustomPropertyEntityType entityType;

    @JsonProperty private String key;
    @JsonProperty private String name;

    @JsonProperty("property_type")
    private CustomPropertyType propertyType;

    @JsonProperty private Boolean required;

    public CustomPropertyDefinitionCreateRequest() {}

    public CustomPropertyDefinitionCreateRequest config(PropertyConfig config) {
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

    public CustomPropertyDefinitionCreateRequest defaultValue(Object defaultValue) {
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

    public CustomPropertyDefinitionCreateRequest description(String description) {
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

    public CustomPropertyDefinitionCreateRequest displayOrder(Integer displayOrder) {
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

    public CustomPropertyDefinitionCreateRequest entityType(CustomPropertyEntityType entityType) {
        this.entityType = entityType;
        return this;
    }

    /**
     * Get entityType
     *
     * @return entityType
     */
    @javax.annotation.Nonnull
    public CustomPropertyEntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(CustomPropertyEntityType entityType) {
        this.entityType = entityType;
    }

    public CustomPropertyDefinitionCreateRequest key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Immutable machine name; letters, digits and underscores only. Unique per entity type.
     *
     * @return key
     */
    @javax.annotation.Nonnull
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CustomPropertyDefinitionCreateRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomPropertyDefinitionCreateRequest propertyType(CustomPropertyType propertyType) {
        this.propertyType = propertyType;
        return this;
    }

    /**
     * Get propertyType
     *
     * @return propertyType
     */
    @javax.annotation.Nonnull
    public CustomPropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(CustomPropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public CustomPropertyDefinitionCreateRequest required(Boolean required) {
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
     * Create an instance of CustomPropertyDefinitionCreateRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CustomPropertyDefinitionCreateRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CustomPropertyDefinitionCreateRequest
     */
    public static CustomPropertyDefinitionCreateRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper()
                .readValue(jsonString, CustomPropertyDefinitionCreateRequest.class);
    }

    /**
     * Convert an instance of CustomPropertyDefinitionCreateRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
