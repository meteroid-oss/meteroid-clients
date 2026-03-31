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
import java.util.List;
import java.util.Map;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class LinkedSegmentationMatrix {
    @JsonProperty("dimension1_key")
    private String dimension1Key;

    @JsonProperty("dimension2_key")
    private String dimension2Key;

    @JsonProperty private Map<String, List<String>> values;

    public LinkedSegmentationMatrix() {}

    public LinkedSegmentationMatrix dimension1Key(String dimension1Key) {
        this.dimension1Key = dimension1Key;
        return this;
    }

    /**
     * Get dimension1Key
     *
     * @return dimension1Key
     */
    @javax.annotation.Nonnull
    public String getDimension1Key() {
        return dimension1Key;
    }

    public void setDimension1Key(String dimension1Key) {
        this.dimension1Key = dimension1Key;
    }

    public LinkedSegmentationMatrix dimension2Key(String dimension2Key) {
        this.dimension2Key = dimension2Key;
        return this;
    }

    /**
     * Get dimension2Key
     *
     * @return dimension2Key
     */
    @javax.annotation.Nonnull
    public String getDimension2Key() {
        return dimension2Key;
    }

    public void setDimension2Key(String dimension2Key) {
        this.dimension2Key = dimension2Key;
    }

    public LinkedSegmentationMatrix values(Map<String, List<String>> values) {
        this.values = values;
        return this;
    }

    public LinkedSegmentationMatrix putValuesItem(String key, List<String> valuesItem) {
        if (this.values == null) {
            this.values = new HashMap<>();
        }
        this.values.put(key, valuesItem);

        return this;
    }

    /**
     * Get values
     *
     * @return values
     */
    @javax.annotation.Nonnull
    public Map<String, List<String>> getValues() {
        return values;
    }

    public void setValues(Map<String, List<String>> values) {
        this.values = values;
    }

    /**
     * Create an instance of LinkedSegmentationMatrix given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of LinkedSegmentationMatrix
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     LinkedSegmentationMatrix
     */
    public static LinkedSegmentationMatrix fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, LinkedSegmentationMatrix.class);
    }

    /**
     * Convert an instance of LinkedSegmentationMatrix to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
