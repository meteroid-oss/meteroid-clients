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
import com.meteroid.internal.JsonField;
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
public final class UpdateMetricRequest {
    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<MetricFilter>> filters = JsonField.missing();

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> name = JsonField.missing();

    @JsonProperty("segmentation_matrix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<MetricSegmentationMatrix> segmentationMatrix = JsonField.missing();

    @JsonProperty("unit_conversion")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<UnitConversion> unitConversion = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private UpdateMetricRequest() {}

    private UpdateMetricRequest(Builder builder) {
        this.description = builder.description;
        this.filters = builder.filters.map(Utils::copyList);
        this.name = builder.name;
        this.segmentationMatrix = builder.segmentationMatrix;
        this.unitConversion = builder.unitConversion;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code UpdateMetricRequest}.
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
        builder.description = description;
        builder.filters = filters.map(Utils::mutableList);
        builder.name = name;
        builder.segmentationMatrix = segmentationMatrix;
        builder.unitConversion = unitConversion;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> description() {
        return description.asOptional();
    }

    /**
     * Absent = leave filters untouched; present (even empty) = replace them.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<MetricFilter>> filters() {
        return filters.asOptional();
    }

    /**
     * The {@code name} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> name() {
        return name.asOptional();
    }

    /**
     * The {@code segmentation_matrix} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<MetricSegmentationMatrix> segmentationMatrix() {
        return segmentationMatrix.asOptional();
    }

    /**
     * The {@code unit_conversion} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<UnitConversion> unitConversion() {
        return unitConversion.asOptional();
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
        UpdateMetricRequest that = (UpdateMetricRequest) o;
        return Objects.equals(description, that.description)
                && Objects.equals(filters, that.filters)
                && Objects.equals(name, that.name)
                && Objects.equals(segmentationMatrix, that.segmentationMatrix)
                && Objects.equals(unitConversion, that.unitConversion)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                description,
                filters,
                name,
                segmentationMatrix,
                unitConversion,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "UpdateMetricRequest{"
                + "description="
                + description
                + ", filters="
                + filters
                + ", name="
                + name
                + ", segmentationMatrix="
                + segmentationMatrix
                + ", unitConversion="
                + unitConversion
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link UpdateMetricRequest}. */
    public static final class Builder {
        private JsonField<String> description = JsonField.missing();
        private JsonField<List<MetricFilter>> filters = JsonField.missing();
        private JsonField<String> name = JsonField.missing();
        private JsonField<MetricSegmentationMatrix> segmentationMatrix = JsonField.missing();
        private JsonField<UnitConversion> unitConversion = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code description} property.
         *
         * @param description the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder description(String description) {
            this.description = JsonField.ofNullable(description);
            return this;
        }

        /**
         * Absent = leave filters untouched; present (even empty) = replace them.
         *
         * @param filters the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder filters(List<MetricFilter> filters) {
            this.filters = JsonField.ofNullable(Utils.mutableList(filters));
            return this;
        }

        /**
         * Adds an item to {@code filters}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addFiltersItem(MetricFilter item) {
            List<MetricFilter> items = this.filters.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.filters = JsonField.ofNullable(items);
            }
            items.add(item);
            return this;
        }

        /**
         * The {@code name} property.
         *
         * @param name the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder name(String name) {
            this.name = JsonField.ofNullable(name);
            return this;
        }

        /**
         * The {@code segmentation_matrix} property.
         *
         * @param segmentationMatrix the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder segmentationMatrix(MetricSegmentationMatrix segmentationMatrix) {
            this.segmentationMatrix = JsonField.ofNullable(segmentationMatrix);
            return this;
        }

        /**
         * The {@code unit_conversion} property.
         *
         * @param unitConversion the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder unitConversion(UnitConversion unitConversion) {
            this.unitConversion = JsonField.ofNullable(unitConversion);
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
         * The {@code UpdateMetricRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public UpdateMetricRequest build() {
            return new UpdateMetricRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code UpdateMetricRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static UpdateMetricRequest fromJson(String json) {
        return Utils.parse(json, UpdateMetricRequest.class);
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
