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
public class PropertyConfig {
    @JsonProperty private Double max;

    @JsonProperty("max_length")
    private Integer maxLength;

    @JsonProperty private Double min;
    @JsonProperty private List<SelectOption> options;

    public PropertyConfig() {}

    public PropertyConfig max(Double max) {
        this.max = max;
        return this;
    }

    /**
     * Get max
     *
     * @return max
     */
    @javax.annotation.Nullable
    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public PropertyConfig maxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    /**
     * Maximum length for `TEXT`.
     *
     * @return maxLength
     */
    @javax.annotation.Nullable
    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public PropertyConfig min(Double min) {
        this.min = min;
        return this;
    }

    /**
     * Inclusive numeric bounds for `NUMBER`.
     *
     * @return min
     */
    @javax.annotation.Nullable
    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public PropertyConfig options(List<SelectOption> options) {
        this.options = options;
        return this;
    }

    public PropertyConfig addOptionsItem(SelectOption optionsItem) {
        if (this.options == null) {
            this.options = new ArrayList<>();
        }
        this.options.add(optionsItem);

        return this;
    }

    /**
     * Allowed choices for `SINGLE_SELECT` &#x2f; `MULTI_SELECT`.
     *
     * @return options
     */
    @javax.annotation.Nullable
    public List<SelectOption> getOptions() {
        return options;
    }

    public void setOptions(List<SelectOption> options) {
        this.options = options;
    }

    /**
     * Create an instance of PropertyConfig given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PropertyConfig
     * @throws JsonProcessingException if the JSON string is invalid with respect to PropertyConfig
     */
    public static PropertyConfig fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PropertyConfig.class);
    }

    /**
     * Convert an instance of PropertyConfig to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
