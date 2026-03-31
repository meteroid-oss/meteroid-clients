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
public class CreateMetricRequest {
    @JsonProperty("aggregation_key")
    private String aggregationKey;

    @JsonProperty("aggregation_type")
    private BillingMetricAggregateEnum aggregationType;

    @JsonProperty private String code;
    @JsonProperty private String description;
    @JsonProperty private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("segmentation_matrix")
    private MetricSegmentationMatrix segmentationMatrix;

    @JsonProperty("unit_conversion")
    private UnitConversion unitConversion;

    @JsonProperty("usage_group_key")
    private String usageGroupKey;

    public CreateMetricRequest() {}

    public CreateMetricRequest aggregationKey(String aggregationKey) {
        this.aggregationKey = aggregationKey;
        return this;
    }

    /**
     * Get aggregationKey
     *
     * @return aggregationKey
     */
    @javax.annotation.Nullable
    public String getAggregationKey() {
        return aggregationKey;
    }

    public void setAggregationKey(String aggregationKey) {
        this.aggregationKey = aggregationKey;
    }

    public CreateMetricRequest aggregationType(BillingMetricAggregateEnum aggregationType) {
        this.aggregationType = aggregationType;
        return this;
    }

    /**
     * Get aggregationType
     *
     * @return aggregationType
     */
    @javax.annotation.Nonnull
    public BillingMetricAggregateEnum getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(BillingMetricAggregateEnum aggregationType) {
        this.aggregationType = aggregationType;
    }

    public CreateMetricRequest code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     */
    @javax.annotation.Nonnull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CreateMetricRequest description(String description) {
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

    public CreateMetricRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateMetricRequest productFamilyId(String productFamilyId) {
        this.productFamilyId = productFamilyId;
        return this;
    }

    /**
     * Get productFamilyId
     *
     * @return productFamilyId
     */
    @javax.annotation.Nonnull
    public String getProductFamilyId() {
        return productFamilyId;
    }

    public void setProductFamilyId(String productFamilyId) {
        this.productFamilyId = productFamilyId;
    }

    public CreateMetricRequest productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Get productId
     *
     * @return productId
     */
    @javax.annotation.Nullable
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public CreateMetricRequest segmentationMatrix(MetricSegmentationMatrix segmentationMatrix) {
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

    public CreateMetricRequest unitConversion(UnitConversion unitConversion) {
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

    public CreateMetricRequest usageGroupKey(String usageGroupKey) {
        this.usageGroupKey = usageGroupKey;
        return this;
    }

    /**
     * Get usageGroupKey
     *
     * @return usageGroupKey
     */
    @javax.annotation.Nullable
    public String getUsageGroupKey() {
        return usageGroupKey;
    }

    public void setUsageGroupKey(String usageGroupKey) {
        this.usageGroupKey = usageGroupKey;
    }

    /**
     * Create an instance of CreateMetricRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateMetricRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateMetricRequest
     */
    public static CreateMetricRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateMetricRequest.class);
    }

    /**
     * Convert an instance of CreateMetricRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
