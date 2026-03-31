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
public class UpdateMetricRequest {
    @JsonProperty private String description;
    @JsonProperty private String name;

    @JsonProperty("segmentation_matrix")
    private MetricSegmentationMatrix segmentationMatrix;

    @JsonProperty("unit_conversion")
    private UnitConversion unitConversion;

    public UpdateMetricRequest() {}

    public UpdateMetricRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateMetricRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateMetricRequest segmentationMatrix(MetricSegmentationMatrix segmentationMatrix) {
        this.segmentationMatrix = segmentationMatrix;
        return this;
    }

    /**
     * Get segmentationMatrix
     *
     * @return segmentationMatrix
     */
    @javax.annotation.Nullable
    public MetricSegmentationMatrix getSegmentationMatrix() {
        return segmentationMatrix;
    }

    public void setSegmentationMatrix(MetricSegmentationMatrix segmentationMatrix) {
        this.segmentationMatrix = segmentationMatrix;
    }

    public UpdateMetricRequest unitConversion(UnitConversion unitConversion) {
        this.unitConversion = unitConversion;
        return this;
    }

    /**
     * Get unitConversion
     *
     * @return unitConversion
     */
    @javax.annotation.Nullable
    public UnitConversion getUnitConversion() {
        return unitConversion;
    }

    public void setUnitConversion(UnitConversion unitConversion) {
        this.unitConversion = unitConversion;
    }

    /**
     * Create an instance of UpdateMetricRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UpdateMetricRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     UpdateMetricRequest
     */
    public static UpdateMetricRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UpdateMetricRequest.class);
    }

    /**
     * Convert an instance of UpdateMetricRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
