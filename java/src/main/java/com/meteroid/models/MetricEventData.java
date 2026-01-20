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

import java.time.OffsetDateTime;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MetricEventData {
    @JsonProperty("aggregation_key")
    private String aggregationKey;

    @JsonProperty("aggregation_type")
    private BillingMetricAggregateEnum aggregationType;

    @JsonProperty private String code;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("segmentation_matrix")
    private MetricSegmentationMatrix segmentationMatrix;

    @JsonProperty("unit_conversion_factor")
    private Integer unitConversionFactor;

    @JsonProperty("unit_conversion_rounding")
    private UnitConversionRoundingEnum unitConversionRounding;

    @JsonProperty("usage_group_key")
    private String usageGroupKey;

    public MetricEventData() {}

    public MetricEventData aggregationKey(String aggregationKey) {
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

    public MetricEventData aggregationType(BillingMetricAggregateEnum aggregationType) {
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

    public MetricEventData code(String code) {
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

    public MetricEventData createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public MetricEventData description(String description) {
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

    public MetricEventData metricId(String metricId) {
        this.metricId = metricId;
        return this;
    }

    /**
     * Get metricId
     *
     * @return metricId
     */
    @javax.annotation.Nonnull
    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }

    public MetricEventData name(String name) {
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

    public MetricEventData productFamilyId(String productFamilyId) {
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

    public MetricEventData productId(String productId) {
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

    public MetricEventData segmentationMatrix(MetricSegmentationMatrix segmentationMatrix) {
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

    public MetricEventData unitConversionFactor(Integer unitConversionFactor) {
        this.unitConversionFactor = unitConversionFactor;
        return this;
    }

    /**
     * Get unitConversionFactor
     *
     * @return unitConversionFactor
     */
    @javax.annotation.Nullable
    public Integer getUnitConversionFactor() {
        return unitConversionFactor;
    }

    public void setUnitConversionFactor(Integer unitConversionFactor) {
        this.unitConversionFactor = unitConversionFactor;
    }

    public MetricEventData unitConversionRounding(
            UnitConversionRoundingEnum unitConversionRounding) {
        this.unitConversionRounding = unitConversionRounding;
        return this;
    }

    /**
     * Get unitConversionRounding
     *
     * @return unitConversionRounding
     */
    @javax.annotation.Nullable
    public UnitConversionRoundingEnum getUnitConversionRounding() {
        return unitConversionRounding;
    }

    public void setUnitConversionRounding(UnitConversionRoundingEnum unitConversionRounding) {
        this.unitConversionRounding = unitConversionRounding;
    }

    public MetricEventData usageGroupKey(String usageGroupKey) {
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
     * Create an instance of MetricEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MetricEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to MetricEventData
     */
    public static MetricEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricEventData.class);
    }

    /**
     * Convert an instance of MetricEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
