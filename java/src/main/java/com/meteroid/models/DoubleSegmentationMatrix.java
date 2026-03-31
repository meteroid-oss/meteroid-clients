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
public class DoubleSegmentationMatrix {
    @JsonProperty private MetricDimension dimension1;
    @JsonProperty private MetricDimension dimension2;

    public DoubleSegmentationMatrix() {}

    public DoubleSegmentationMatrix dimension1(MetricDimension dimension1) {
        this.dimension1 = dimension1;
        return this;
    }

    /**
     * Get dimension1
     *
     * @return dimension1
     */
    @javax.annotation.Nonnull
    public MetricDimension getDimension1() {
        return dimension1;
    }

    public void setDimension1(MetricDimension dimension1) {
        this.dimension1 = dimension1;
    }

    public DoubleSegmentationMatrix dimension2(MetricDimension dimension2) {
        this.dimension2 = dimension2;
        return this;
    }

    /**
     * Get dimension2
     *
     * @return dimension2
     */
    @javax.annotation.Nonnull
    public MetricDimension getDimension2() {
        return dimension2;
    }

    public void setDimension2(MetricDimension dimension2) {
        this.dimension2 = dimension2;
    }

    /**
     * Create an instance of DoubleSegmentationMatrix given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of DoubleSegmentationMatrix
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     DoubleSegmentationMatrix
     */
    public static DoubleSegmentationMatrix fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, DoubleSegmentationMatrix.class);
    }

    /**
     * Convert an instance of DoubleSegmentationMatrix to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
