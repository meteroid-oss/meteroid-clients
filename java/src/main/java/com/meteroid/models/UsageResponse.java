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

import java.time.LocalDate;
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
public final class UsageResponse {
    @JsonProperty("period_end")
    private LocalDate periodEnd;

    @JsonProperty("period_start")
    private LocalDate periodStart;

    @JsonProperty("usage")
    private List<MetricUsage> usage;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private UsageResponse() {}

    private UsageResponse(Builder builder) {
        this.periodEnd = builder.periodEnd;
        this.periodStart = builder.periodStart;
        this.usage = Utils.copyList(builder.usage);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code UsageResponse}.
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
        builder.periodEnd = periodEnd;
        builder.periodStart = periodStart;
        builder.usage = Utils.mutableList(usage);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code period_end} property.
     *
     * @return the value, never null
     */
    public LocalDate periodEnd() {
        return Utils.required(periodEnd, "period_end");
    }

    /**
     * The {@code period_start} property.
     *
     * @return the value, never null
     */
    public LocalDate periodStart() {
        return Utils.required(periodStart, "period_start");
    }

    /**
     * The {@code usage} property.
     *
     * @return the value, never null
     */
    public List<MetricUsage> usage() {
        return Utils.required(usage, "usage");
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
        UsageResponse that = (UsageResponse) o;
        return Objects.equals(periodEnd, that.periodEnd)
                && Objects.equals(periodStart, that.periodStart)
                && Objects.equals(usage, that.usage)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periodEnd, periodStart, usage, additionalProperties);
    }

    @Override
    public String toString() {
        return "UsageResponse{"
                + "periodEnd="
                + periodEnd
                + ", periodStart="
                + periodStart
                + ", usage="
                + usage
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link UsageResponse}. */
    public static final class Builder {
        private LocalDate periodEnd;
        private LocalDate periodStart;
        private List<MetricUsage> usage;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code period_end} property.
         *
         * @param periodEnd the value
         * @return this builder
         */
        public Builder periodEnd(LocalDate periodEnd) {
            this.periodEnd = periodEnd;
            return this;
        }

        /**
         * The {@code period_start} property.
         *
         * @param periodStart the value
         * @return this builder
         */
        public Builder periodStart(LocalDate periodStart) {
            this.periodStart = periodStart;
            return this;
        }

        /**
         * The {@code usage} property.
         *
         * @param usage the value
         * @return this builder
         */
        public Builder usage(List<MetricUsage> usage) {
            this.usage = Utils.mutableList(usage);
            return this;
        }

        /**
         * Adds an item to {@code usage}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addUsageItem(MetricUsage item) {
            if (this.usage == null) {
                this.usage = new ArrayList<>();
            }
            this.usage.add(item);
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
         * The {@code UsageResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public UsageResponse build() {
            Utils.checkRequired(periodEnd, "period_end");
            Utils.checkRequired(periodStart, "period_start");
            Utils.checkRequired(usage, "usage");
            return new UsageResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code UsageResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static UsageResponse fromJson(String json) {
        return Utils.parse(json, UsageResponse.class);
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
