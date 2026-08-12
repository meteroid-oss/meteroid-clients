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
public class MetricFilter {
    @JsonProperty private MetricFilterOperator op;
    @JsonProperty private String property;
    @JsonProperty private List<String> values;

    public MetricFilter() {}

    public MetricFilter op(MetricFilterOperator op) {
        this.op = op;
        return this;
    }

    /**
     * Get op
     *
     * @return op
     */
    @javax.annotation.Nonnull
    public MetricFilterOperator getOp() {
        return op;
    }

    public void setOp(MetricFilterOperator op) {
        this.op = op;
    }

    public MetricFilter property(String property) {
        this.property = property;
        return this;
    }

    /**
     * Get property
     *
     * @return property
     */
    @javax.annotation.Nonnull
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public MetricFilter values(List<String> values) {
        this.values = values;
        return this;
    }

    public MetricFilter addValuesItem(String valuesItem) {
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
     * Create an instance of MetricFilter given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MetricFilter
     * @throws JsonProcessingException if the JSON string is invalid with respect to MetricFilter
     */
    public static MetricFilter fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricFilter.class);
    }

    /**
     * Convert an instance of MetricFilter to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
