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

import java.util.HashMap;
import java.util.Map;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class GroupedUsage {
    @JsonProperty private Map<String, String> dimensions;
    @JsonProperty private String value;

    public GroupedUsage() {}

    public GroupedUsage dimensions(Map<String, String> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public GroupedUsage putDimensionsItem(String key, String dimensionsItem) {
        if (this.dimensions == null) {
            this.dimensions = new HashMap<>();
        }
        this.dimensions.put(key, dimensionsItem);

        return this;
    }

    /**
     * Get dimensions
     *
     * @return dimensions
     */
    @javax.annotation.Nonnull
    public Map<String, String> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Map<String, String> dimensions) {
        this.dimensions = dimensions;
    }

    public GroupedUsage value(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     */
    @javax.annotation.Nonnull
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Create an instance of GroupedUsage given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of GroupedUsage
     * @throws JsonProcessingException if the JSON string is invalid with respect to GroupedUsage
     */
    public static GroupedUsage fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, GroupedUsage.class);
    }

    /**
     * Convert an instance of GroupedUsage to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
