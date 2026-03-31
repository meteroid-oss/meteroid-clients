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
public class MetricSummary {
    @JsonProperty("aggregation_key")
    private String aggregationKey;

    @JsonProperty("aggregation_type")
    private BillingMetricAggregateEnum aggregationType;

    @JsonProperty("archived_at")
    private OffsetDateTime archivedAt;

    @JsonProperty private String code;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;
    @JsonProperty private String id;
    @JsonProperty private String name;

    public MetricSummary() {}

    public MetricSummary aggregationKey(String aggregationKey) {
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

    public MetricSummary aggregationType(BillingMetricAggregateEnum aggregationType) {
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

    public MetricSummary archivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
        return this;
    }

    /**
     * Get archivedAt
     *
     * @return archivedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }

    public MetricSummary code(String code) {
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

    public MetricSummary createdAt(OffsetDateTime createdAt) {
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

    public MetricSummary description(String description) {
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

    public MetricSummary id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MetricSummary name(String name) {
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

    /**
     * Create an instance of MetricSummary given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MetricSummary
     * @throws JsonProcessingException if the JSON string is invalid with respect to MetricSummary
     */
    public static MetricSummary fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricSummary.class);
    }

    /**
     * Convert an instance of MetricSummary to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
