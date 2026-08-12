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
public class ConfigFeatureType {
    @JsonProperty private List<String> options;

    @JsonProperty("value_type")
    private ConfigValueType valueType;

    public ConfigFeatureType() {}

    public ConfigFeatureType options(List<String> options) {
        this.options = options;
        return this;
    }

    public ConfigFeatureType addOptionsItem(String optionsItem) {
        if (this.options == null) {
            this.options = new ArrayList<>();
        }
        this.options.add(optionsItem);

        return this;
    }

    /**
     * Allowed values when `value_type = SELECT`. Empty otherwise.
     *
     * @return options
     */
    @javax.annotation.Nullable
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public ConfigFeatureType valueType(ConfigValueType valueType) {
        this.valueType = valueType;
        return this;
    }

    /**
     * The feature&#x27;s value type, fixed at creation.
     *
     * @return valueType
     */
    @javax.annotation.Nonnull
    public ConfigValueType getValueType() {
        return valueType;
    }

    public void setValueType(ConfigValueType valueType) {
        this.valueType = valueType;
    }

    /**
     * Create an instance of ConfigFeatureType given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConfigFeatureType
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ConfigFeatureType
     */
    public static ConfigFeatureType fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ConfigFeatureType.class);
    }

    /**
     * Convert an instance of ConfigFeatureType to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
