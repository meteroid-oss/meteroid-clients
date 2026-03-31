// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class OneTimeFeeStructure {
    public OneTimeFeeStructure() {}

    /**
     * Create an instance of OneTimeFeeStructure given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OneTimeFeeStructure
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     OneTimeFeeStructure
     */
    public static OneTimeFeeStructure fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OneTimeFeeStructure.class);
    }

    /**
     * Convert an instance of OneTimeFeeStructure to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
