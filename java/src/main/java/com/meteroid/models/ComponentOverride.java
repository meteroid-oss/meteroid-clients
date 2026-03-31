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
    @JsonProperty("component_id")
    private String componentId;

    @JsonProperty private String name;

    @JsonProperty("price_entry")
    private PriceEntry priceEntry;

    public ComponentOverride() {}

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

    public ComponentOverride name(String name) {
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

    public ComponentOverride priceEntry(PriceEntry priceEntry) {
        this.priceEntry = priceEntry;
        return this;
    }

    /**
     * Get priceEntry
     *
     * @return priceEntry
     */
    @javax.annotation.Nonnull
    public PriceEntry getPriceEntry() {
        return priceEntry;
    }

    public void setPriceEntry(PriceEntry priceEntry) {
        this.priceEntry = priceEntry;
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
