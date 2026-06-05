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
public class BooleanFeatureType {
    public BooleanFeatureType() {}

    /**
     * Create an instance of BooleanFeatureType given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BooleanFeatureType
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BooleanFeatureType
     */
    public static BooleanFeatureType fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BooleanFeatureType.class);
    }

    /**
     * Convert an instance of BooleanFeatureType to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
