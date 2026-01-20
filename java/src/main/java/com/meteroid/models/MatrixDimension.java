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
public class MatrixDimension {
    @JsonProperty private String key;
    @JsonProperty private String value;

    public MatrixDimension() {}

    public MatrixDimension key(String key) {
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

    public MatrixDimension value(String value) {
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
     * Create an instance of MatrixDimension given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MatrixDimension
     * @throws JsonProcessingException if the JSON string is invalid with respect to MatrixDimension
     */
    public static MatrixDimension fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MatrixDimension.class);
    }

    /**
     * Convert an instance of MatrixDimension to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
