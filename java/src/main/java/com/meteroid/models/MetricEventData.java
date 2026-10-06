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

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
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
public final class MetricEventData {
    @JsonProperty("aggregation_key")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> aggregationKey = JsonField.missing();

    @JsonProperty("aggregation_type")
    private BillingMetricAggregateEnum aggregationType;

    @JsonProperty("code")
    private String code;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("metric_id")
    private String metricId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    @JsonProperty("product_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> productId = JsonField.missing();

    @JsonProperty("segmentation_matrix")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<MetricSegmentationMatrix> segmentationMatrix = JsonField.missing();

    @JsonProperty("unit_conversion_factor")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> unitConversionFactor = JsonField.missing();

    @JsonProperty("unit_conversion_rounding")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<UnitConversionRoundingEnum> unitConversionRounding = JsonField.missing();

    @JsonProperty("usage_group_key")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> usageGroupKey = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MetricEventData() {}

    private MetricEventData(Builder builder) {
        this.aggregationKey = builder.aggregationKey;
        this.aggregationType = builder.aggregationType;
        this.code = builder.code;
        this.createdAt = builder.createdAt;
        this.description = builder.description;
        this.metricId = builder.metricId;
        this.name = builder.name;
        this.productFamilyId = builder.productFamilyId;
        this.productId = builder.productId;
        this.segmentationMatrix = builder.segmentationMatrix;
        this.unitConversionFactor = builder.unitConversionFactor;
        this.unitConversionRounding = builder.unitConversionRounding;
        this.usageGroupKey = builder.usageGroupKey;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MetricEventData}.
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
        builder.aggregationKey = aggregationKey;
        builder.aggregationType = aggregationType;
        builder.code = code;
        builder.createdAt = createdAt;
        builder.description = description;
        builder.metricId = metricId;
        builder.name = name;
        builder.productFamilyId = productFamilyId;
        builder.productId = productId;
        builder.segmentationMatrix = segmentationMatrix;
        builder.unitConversionFactor = unitConversionFactor;
        builder.unitConversionRounding = unitConversionRounding;
        builder.usageGroupKey = usageGroupKey;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code aggregation_key} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> aggregationKey() {
        return aggregationKey.asOptional();
    }

    /**
     * The {@code aggregation_type} property.
     *
     * @return the value, never null
     */
    public BillingMetricAggregateEnum aggregationType() {
        return Utils.required(aggregationType, "aggregation_type");
    }

    /**
     * The {@code code} property.
     *
     * @return the value, never null
     */
    public String code() {
        return Utils.required(code, "code");
    }

    /**
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
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
     * The {@code metric_id} property.
     *
     * @return the value, never null
     */
    public String metricId() {
        return Utils.required(metricId, "metric_id");
    }

    /**
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code product_family_id} property.
     *
     * @return the value, never null
     */
    public String productFamilyId() {
        return Utils.required(productFamilyId, "product_family_id");
    }

    /**
     * The {@code product_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> productId() {
        return productId.asOptional();
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
     * The {@code unit_conversion_factor} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> unitConversionFactor() {
        return unitConversionFactor.asOptional();
    }

    /**
     * The {@code unit_conversion_rounding} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<UnitConversionRoundingEnum> unitConversionRounding() {
        return unitConversionRounding.asOptional();
    }

    /**
     * The {@code usage_group_key} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> usageGroupKey() {
        return usageGroupKey.asOptional();
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
        MetricEventData that = (MetricEventData) o;
        return Objects.equals(aggregationKey, that.aggregationKey)
                && Objects.equals(aggregationType, that.aggregationType)
                && Objects.equals(code, that.code)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(description, that.description)
                && Objects.equals(metricId, that.metricId)
                && Objects.equals(name, that.name)
                && Objects.equals(productFamilyId, that.productFamilyId)
                && Objects.equals(productId, that.productId)
                && Objects.equals(segmentationMatrix, that.segmentationMatrix)
                && Objects.equals(unitConversionFactor, that.unitConversionFactor)
                && Objects.equals(unitConversionRounding, that.unitConversionRounding)
                && Objects.equals(usageGroupKey, that.usageGroupKey)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                aggregationKey,
                aggregationType,
                code,
                createdAt,
                description,
                metricId,
                name,
                productFamilyId,
                productId,
                segmentationMatrix,
                unitConversionFactor,
                unitConversionRounding,
                usageGroupKey,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "MetricEventData{"
                + "aggregationKey="
                + aggregationKey
                + ", aggregationType="
                + aggregationType
                + ", code="
                + code
                + ", createdAt="
                + createdAt
                + ", description="
                + description
                + ", metricId="
                + metricId
                + ", name="
                + name
                + ", productFamilyId="
                + productFamilyId
                + ", productId="
                + productId
                + ", segmentationMatrix="
                + segmentationMatrix
                + ", unitConversionFactor="
                + unitConversionFactor
                + ", unitConversionRounding="
                + unitConversionRounding
                + ", usageGroupKey="
                + usageGroupKey
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MetricEventData}. */
    public static final class Builder {
        private JsonField<String> aggregationKey = JsonField.missing();
        private BillingMetricAggregateEnum aggregationType;
        private String code;
        private OffsetDateTime createdAt;
        private JsonField<String> description = JsonField.missing();
        private String metricId;
        private String name;
        private String productFamilyId;
        private JsonField<String> productId = JsonField.missing();
        private JsonField<MetricSegmentationMatrix> segmentationMatrix = JsonField.missing();
        private JsonField<Integer> unitConversionFactor = JsonField.missing();
        private JsonField<UnitConversionRoundingEnum> unitConversionRounding = JsonField.missing();
        private JsonField<String> usageGroupKey = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code aggregation_key} property.
         *
         * @param aggregationKey the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder aggregationKey(String aggregationKey) {
            this.aggregationKey = JsonField.ofNullable(aggregationKey);
            return this;
        }

        /**
         * The {@code aggregation_type} property.
         *
         * @param aggregationType the value
         * @return this builder
         */
        public Builder aggregationType(BillingMetricAggregateEnum aggregationType) {
            this.aggregationType = aggregationType;
            return this;
        }

        /**
         * The {@code code} property.
         *
         * @param code the value
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * The {@code created_at} property.
         *
         * @param createdAt the value
         * @return this builder
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

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
         * The {@code name} property.
         *
         * @param name the value
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The {@code product_family_id} property.
         *
         * @param productFamilyId the value
         * @return this builder
         */
        public Builder productFamilyId(String productFamilyId) {
            this.productFamilyId = productFamilyId;
            return this;
        }

        /**
         * The {@code product_id} property.
         *
         * @param productId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder productId(String productId) {
            this.productId = JsonField.ofNullable(productId);
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
         * The {@code unit_conversion_factor} property.
         *
         * @param unitConversionFactor the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder unitConversionFactor(Integer unitConversionFactor) {
            this.unitConversionFactor = JsonField.ofNullable(unitConversionFactor);
            return this;
        }

        /**
         * The {@code unit_conversion_rounding} property.
         *
         * @param unitConversionRounding the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder unitConversionRounding(UnitConversionRoundingEnum unitConversionRounding) {
            this.unitConversionRounding = JsonField.ofNullable(unitConversionRounding);
            return this;
        }

        /**
         * The {@code usage_group_key} property.
         *
         * @param usageGroupKey the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder usageGroupKey(String usageGroupKey) {
            this.usageGroupKey = JsonField.ofNullable(usageGroupKey);
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
         * The {@code MetricEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MetricEventData build() {
            Utils.checkRequired(aggregationType, "aggregation_type");
            Utils.checkRequired(code, "code");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(metricId, "metric_id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(productFamilyId, "product_family_id");
            return new MetricEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code MetricEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MetricEventData fromJson(String json) {
        return Utils.parse(json, MetricEventData.class);
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
