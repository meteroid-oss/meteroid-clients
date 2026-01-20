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
public class MetricDimension {
    @JsonProperty private String key;
    @JsonProperty private List<String> values;

    public MetricDimension() {}

    public MetricDimension key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Get key
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

    public MetricDimension values(List<String> values) {
        this.values = values;
        return this;
    }

    public MetricDimension addValuesItem(String valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);

        return this;
    }

    /**
     * Get values
     *
     * @return values
     */
    @javax.annotation.Nonnull
    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    /**
     * Create an instance of MetricDimension given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MetricDimension
     * @throws JsonProcessingException if the JSON string is invalid with respect to MetricDimension
     */
    public static MetricDimension fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricDimension.class);
    }

    /**
     * Convert an instance of MetricDimension to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
