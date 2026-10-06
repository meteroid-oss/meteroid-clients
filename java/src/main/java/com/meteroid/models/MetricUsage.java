// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class MetricUsage {
    @JsonProperty("grouped_usage")
    private List<GroupedUsage> groupedUsage;

    @JsonProperty("metric_code")
    private String metricCode;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty("metric_name")
    private String metricName;

    @JsonProperty("total_value")
    private BigDecimal totalValue;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MetricUsage() {}

    private MetricUsage(Builder builder) {
        this.groupedUsage = Utils.copyList(builder.groupedUsage);
        this.metricCode = builder.metricCode;
        this.metricId = builder.metricId;
        this.metricName = builder.metricName;
        this.totalValue = builder.totalValue;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MetricUsage}.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder starting from this value.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.groupedUsage = Utils.mutableList(groupedUsage);
        builder.metricCode = metricCode;
        builder.metricId = metricId;
        builder.metricName = metricName;
        builder.totalValue = totalValue;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code grouped_usage} property.
     *
     * @return the value, never null
     */
    public List<GroupedUsage> groupedUsage() {
        return Utils.required(groupedUsage, "grouped_usage");
    }

    /**
     * The {@code metric_code} property.
     *
     * @return the value, never null
     */
    public String metricCode() {
        return Utils.required(metricCode, "metric_code");
    }

    /**
     * The {@code metric_id} property.
     *
     * @return the value, never null
     */
    public String metricId() {
        return Utils.required(metricId, "metric_id");
    }

    /**
     * The {@code metric_name} property.
     *
     * @return the value, never null
     */
    public String metricName() {
        return Utils.required(metricName, "metric_name");
    }

    /**
     * The {@code total_value} property.
     *
     * @return the value, never null
     */
    public BigDecimal totalValue() {
        return Utils.required(totalValue, "total_value");
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnyGetter
    private Map<String, JsonNode> anyProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void putAnyProperty(String name, JsonNode value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetricUsage that = (MetricUsage) o;
        return Objects.equals(groupedUsage, that.groupedUsage)
                && Objects.equals(metricCode, that.metricCode)
                && Objects.equals(metricId, that.metricId)
                && Objects.equals(metricName, that.metricName)
                && Objects.equals(totalValue, that.totalValue)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                groupedUsage, metricCode, metricId, metricName, totalValue, additionalProperties);
    }

    @Override
    public String toString() {
        return "MetricUsage{"
                + "groupedUsage="
                + groupedUsage
                + ", metricCode="
                + metricCode
                + ", metricId="
                + metricId
                + ", metricName="
                + metricName
                + ", totalValue="
                + totalValue
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MetricUsage}. */
    public static final class Builder {
        private List<GroupedUsage> groupedUsage;
        private String metricCode;
        private String metricId;
        private String metricName;
        private BigDecimal totalValue;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code grouped_usage} property.
         *
         * @param groupedUsage the value
         * @return this builder
         */
        public Builder groupedUsage(List<GroupedUsage> groupedUsage) {
            this.groupedUsage = Utils.mutableList(groupedUsage);
            return this;
        }

        /**
         * Adds an item to {@code grouped_usage}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addGroupedUsageItem(GroupedUsage item) {
            if (this.groupedUsage == null) {
                this.groupedUsage = new ArrayList<>();
            }
            this.groupedUsage.add(item);
            return this;
        }

        /**
         * The {@code metric_code} property.
         *
         * @param metricCode the value
         * @return this builder
         */
        public Builder metricCode(String metricCode) {
            this.metricCode = metricCode;
            return this;
        }

        /**
         * The {@code metric_id} property.
         *
         * @param metricId the value
         * @return this builder
         */
        public Builder metricId(String metricId) {
            this.metricId = metricId;
            return this;
        }

        /**
         * The {@code metric_name} property.
         *
         * @param metricName the value
         * @return this builder
         */
        public Builder metricName(String metricName) {
            this.metricName = metricName;
            return this;
        }

        /**
         * The {@code total_value} property.
         *
         * @param totalValue the value
         * @return this builder
         */
        public Builder totalValue(BigDecimal totalValue) {
            this.totalValue = totalValue;
            return this;
        }

        /**
         * A property the SDK does not know, sent along.
         *
         * @param name the property name
         * @param value the JSON value
         * @return this builder
         */
        public Builder putAdditionalProperty(String name, JsonNode value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Properties the SDK does not know, sent along.
         *
         * @param additionalProperties the properties by name
         * @return this builder
         */
        public Builder putAllAdditionalProperties(Map<String, JsonNode> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        /**
         * Leaves out a property the SDK does not know.
         *
         * @param name the property name
         * @return this builder
         */
        public Builder removeAdditionalProperty(String name) {
            additionalProperties.remove(name);
            return this;
        }

        /**
         * The {@code MetricUsage}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MetricUsage build() {
            Utils.checkRequired(groupedUsage, "grouped_usage");
            Utils.checkRequired(metricCode, "metric_code");
            Utils.checkRequired(metricId, "metric_id");
            Utils.checkRequired(metricName, "metric_name");
            Utils.checkRequired(totalValue, "total_value");
            return new MetricUsage(this);
        }
    }

    /**
     * Parse {@code json} as {@code MetricUsage}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MetricUsage fromJson(String json) {
        return Utils.parse(json, MetricUsage.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }
}
