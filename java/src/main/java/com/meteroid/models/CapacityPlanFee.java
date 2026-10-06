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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Capacity-based fee with included committed usage and overage
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class CapacityPlanFee {
    @JsonProperty("cadence")
    private BillingPeriodEnum cadence;

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty("thresholds")
    private List<CapacityThreshold> thresholds;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CapacityPlanFee() {}

    private CapacityPlanFee(Builder builder) {
        this.cadence = builder.cadence;
        this.metricId = builder.metricId;
        this.thresholds = Utils.copyList(builder.thresholds);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CapacityPlanFee}.
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
        builder.cadence = cadence;
        builder.metricId = metricId;
        builder.thresholds = Utils.mutableList(thresholds);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code cadence} property.
     *
     * @return the value, never null
     */
    public BillingPeriodEnum cadence() {
        return Utils.required(cadence, "cadence");
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
     * The {@code thresholds} property.
     *
     * @return the value, never null
     */
    public List<CapacityThreshold> thresholds() {
        return Utils.required(thresholds, "thresholds");
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
        CapacityPlanFee that = (CapacityPlanFee) o;
        return Objects.equals(cadence, that.cadence)
                && Objects.equals(metricId, that.metricId)
                && Objects.equals(thresholds, that.thresholds)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cadence, metricId, thresholds, additionalProperties);
    }

    @Override
    public String toString() {
        return "CapacityPlanFee{"
                + "cadence="
                + cadence
                + ", metricId="
                + metricId
                + ", thresholds="
                + thresholds
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CapacityPlanFee}. */
    public static final class Builder {
        private BillingPeriodEnum cadence;
        private String metricId;
        private List<CapacityThreshold> thresholds;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code cadence} property.
         *
         * @param cadence the value
         * @return this builder
         */
        public Builder cadence(BillingPeriodEnum cadence) {
            this.cadence = cadence;
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
         * The {@code thresholds} property.
         *
         * @param thresholds the value
         * @return this builder
         */
        public Builder thresholds(List<CapacityThreshold> thresholds) {
            this.thresholds = Utils.mutableList(thresholds);
            return this;
        }

        /**
         * Adds an item to {@code thresholds}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addThresholdsItem(CapacityThreshold item) {
            if (this.thresholds == null) {
                this.thresholds = new ArrayList<>();
            }
            this.thresholds.add(item);
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
         * The {@code CapacityPlanFee}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CapacityPlanFee build() {
            Utils.checkRequired(cadence, "cadence");
            Utils.checkRequired(metricId, "metric_id");
            Utils.checkRequired(thresholds, "thresholds");
            return new CapacityPlanFee(this);
        }
    }

    /**
     * Parse {@code json} as {@code CapacityPlanFee}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CapacityPlanFee fromJson(String json) {
        return Utils.parse(json, CapacityPlanFee.class);
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
