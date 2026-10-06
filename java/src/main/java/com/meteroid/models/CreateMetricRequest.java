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
public final class CreateMetricRequest {
    @JsonProperty("aggregation_key")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> aggregationKey = JsonField.missing();

    @JsonProperty("aggregation_type")
    private BillingMetricAggregateEnum aggregationType;

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<MetricFilter>> filters = JsonField.missing();

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

    @JsonProperty("unit_conversion")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<UnitConversion> unitConversion = JsonField.missing();

    @JsonProperty("usage_group_key")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> usageGroupKey = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateMetricRequest() {}

    private CreateMetricRequest(Builder builder) {
        this.aggregationKey = builder.aggregationKey;
        this.aggregationType = builder.aggregationType;
        this.code = builder.code;
        this.description = builder.description;
        this.filters = builder.filters.map(Utils::copyList);
        this.name = builder.name;
        this.productFamilyId = builder.productFamilyId;
        this.productId = builder.productId;
        this.segmentationMatrix = builder.segmentationMatrix;
        this.unitConversion = builder.unitConversion;
        this.usageGroupKey = builder.usageGroupKey;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateMetricRequest}.
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
        builder.description = description;
        builder.filters = filters.map(Utils::mutableList);
        builder.name = name;
        builder.productFamilyId = productFamilyId;
        builder.productId = productId;
        builder.segmentationMatrix = segmentationMatrix;
        builder.unitConversion = unitConversion;
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
     * The {@code description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> description() {
        return description.asOptional();
    }

    /**
     * Pre-aggregation property filters. Optional and backward-compatible; omit for none.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<MetricFilter>> filters() {
        return filters.asOptional();
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
     * The {@code unit_conversion} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<UnitConversion> unitConversion() {
        return unitConversion.asOptional();
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
        CreateMetricRequest that = (CreateMetricRequest) o;
        return Objects.equals(aggregationKey, that.aggregationKey)
                && Objects.equals(aggregationType, that.aggregationType)
                && Objects.equals(code, that.code)
                && Objects.equals(description, that.description)
                && Objects.equals(filters, that.filters)
                && Objects.equals(name, that.name)
                && Objects.equals(productFamilyId, that.productFamilyId)
                && Objects.equals(productId, that.productId)
                && Objects.equals(segmentationMatrix, that.segmentationMatrix)
                && Objects.equals(unitConversion, that.unitConversion)
                && Objects.equals(usageGroupKey, that.usageGroupKey)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                aggregationKey,
                aggregationType,
                code,
                description,
                filters,
                name,
                productFamilyId,
                productId,
                segmentationMatrix,
                unitConversion,
                usageGroupKey,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateMetricRequest{"
                + "aggregationKey="
                + aggregationKey
                + ", aggregationType="
                + aggregationType
                + ", code="
                + code
                + ", description="
                + description
                + ", filters="
                + filters
                + ", name="
                + name
                + ", productFamilyId="
                + productFamilyId
                + ", productId="
                + productId
                + ", segmentationMatrix="
                + segmentationMatrix
                + ", unitConversion="
                + unitConversion
                + ", usageGroupKey="
                + usageGroupKey
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateMetricRequest}. */
    public static final class Builder {
        private JsonField<String> aggregationKey = JsonField.missing();
        private BillingMetricAggregateEnum aggregationType;
        private String code;
        private JsonField<String> description = JsonField.missing();
        private JsonField<List<MetricFilter>> filters = JsonField.missing();
        private String name;
        private String productFamilyId;
        private JsonField<String> productId = JsonField.missing();
        private JsonField<MetricSegmentationMatrix> segmentationMatrix = JsonField.missing();
        private JsonField<UnitConversion> unitConversion = JsonField.missing();
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
         * Pre-aggregation property filters. Optional and backward-compatible; omit for none.
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
         * The {@code CreateMetricRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateMetricRequest build() {
            Utils.checkRequired(aggregationType, "aggregation_type");
            Utils.checkRequired(code, "code");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(productFamilyId, "product_family_id");
            return new CreateMetricRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateMetricRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateMetricRequest fromJson(String json) {
        return Utils.parse(json, CreateMetricRequest.class);
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
