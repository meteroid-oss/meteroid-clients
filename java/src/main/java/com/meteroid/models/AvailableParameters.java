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
import java.util.Optional;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class AvailableParameters {
    @JsonProperty("billing_periods")
    private Map<String, List<BillingPeriodEnum>> billingPeriods;

    @JsonProperty("capacity_thresholds")
    private Map<String, List<Long>> capacityThresholds;

    @JsonProperty("slot_components")
    private List<String> slotComponents;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private AvailableParameters() {}

    private AvailableParameters(Builder builder) {
        this.billingPeriods = Utils.copyMap(builder.billingPeriods);
        this.capacityThresholds = Utils.copyMap(builder.capacityThresholds);
        this.slotComponents = Utils.copyList(builder.slotComponents);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code AvailableParameters}.
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
        builder.billingPeriods = Utils.mutableMap(billingPeriods);
        builder.capacityThresholds = Utils.mutableMap(capacityThresholds);
        builder.slotComponents = Utils.mutableList(slotComponents);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Map of component_id -&gt; available billing periods (e.g., "MONTHLY", "ANNUAL")
     *
     * @return the value, empty when unset
     */
    public Optional<Map<String, List<BillingPeriodEnum>>> billingPeriods() {
        return Optional.ofNullable(billingPeriods);
    }

    /**
     * Map of component_id -&gt; available capacity values
     *
     * @return the value, empty when unset
     */
    public Optional<Map<String, List<Long>>> capacityThresholds() {
        return Optional.ofNullable(capacityThresholds);
    }

    /**
     * List of component_ids that support slot parametrization (initial slot count)
     *
     * @return the value, empty when unset
     */
    public Optional<List<String>> slotComponents() {
        return Optional.ofNullable(slotComponents);
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
        AvailableParameters that = (AvailableParameters) o;
        return Objects.equals(billingPeriods, that.billingPeriods)
                && Objects.equals(capacityThresholds, that.capacityThresholds)
                && Objects.equals(slotComponents, that.slotComponents)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                billingPeriods, capacityThresholds, slotComponents, additionalProperties);
    }

    @Override
    public String toString() {
        return "AvailableParameters{"
                + "billingPeriods="
                + billingPeriods
                + ", capacityThresholds="
                + capacityThresholds
                + ", slotComponents="
                + slotComponents
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link AvailableParameters}. */
    public static final class Builder {
        private Map<String, List<BillingPeriodEnum>> billingPeriods;
        private Map<String, List<Long>> capacityThresholds;
        private List<String> slotComponents;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Map of component_id -&gt; available billing periods (e.g., "MONTHLY", "ANNUAL")
         *
         * @param billingPeriods the value
         * @return this builder
         */
        public Builder billingPeriods(Map<String, List<BillingPeriodEnum>> billingPeriods) {
            this.billingPeriods = Utils.mutableMap(billingPeriods);
            return this;
        }

        /**
         * Puts an entry in {@code billing_periods}.
         *
         * @param key the key
         * @param item the item
         * @return this builder
         */
        public Builder putBillingPeriodsItem(String key, List<BillingPeriodEnum> item) {
            if (this.billingPeriods == null) {
                this.billingPeriods = new LinkedHashMap<>();
            }
            this.billingPeriods.put(key, item);
            return this;
        }

        /**
         * Map of component_id -&gt; available capacity values
         *
         * @param capacityThresholds the value
         * @return this builder
         */
        public Builder capacityThresholds(Map<String, List<Long>> capacityThresholds) {
            this.capacityThresholds = Utils.mutableMap(capacityThresholds);
            return this;
        }

        /**
         * Puts an entry in {@code capacity_thresholds}.
         *
         * @param key the key
         * @param item the item
         * @return this builder
         */
        public Builder putCapacityThresholdsItem(String key, List<Long> item) {
            if (this.capacityThresholds == null) {
                this.capacityThresholds = new LinkedHashMap<>();
            }
            this.capacityThresholds.put(key, item);
            return this;
        }

        /**
         * List of component_ids that support slot parametrization (initial slot count)
         *
         * @param slotComponents the value
         * @return this builder
         */
        public Builder slotComponents(List<String> slotComponents) {
            this.slotComponents = Utils.mutableList(slotComponents);
            return this;
        }

        /**
         * Adds an item to {@code slot_components}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addSlotComponentsItem(String item) {
            if (this.slotComponents == null) {
                this.slotComponents = new ArrayList<>();
            }
            this.slotComponents.add(item);
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
         * The {@code AvailableParameters}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public AvailableParameters build() {
            return new AvailableParameters(this);
        }
    }

    /**
     * Parse {@code json} as {@code AvailableParameters}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static AvailableParameters fromJson(String json) {
        return Utils.parse(json, AvailableParameters.class);
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
