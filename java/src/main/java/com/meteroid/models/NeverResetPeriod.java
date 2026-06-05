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
public class NeverResetPeriod {
    public NeverResetPeriod() {}

    /**
     * Create an instance of NeverResetPeriod given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of NeverResetPeriod
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     NeverResetPeriod
     */
    public static NeverResetPeriod fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, NeverResetPeriod.class);
    }

    /**
     * Convert an instance of NeverResetPeriod to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
