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
public final class MetricSummary {
    @JsonProperty("aggregation_key")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> aggregationKey = JsonField.missing();

    @JsonProperty("aggregation_type")
    private BillingMetricAggregateEnum aggregationType;

    @JsonProperty("archived_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> archivedAt = JsonField.missing();

    @JsonProperty("code")
    private String code;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MetricSummary() {}

    private MetricSummary(Builder builder) {
        this.aggregationKey = builder.aggregationKey;
        this.aggregationType = builder.aggregationType;
        this.archivedAt = builder.archivedAt;
        this.code = builder.code;
        this.createdAt = builder.createdAt;
        this.description = builder.description;
        this.id = builder.id;
        this.name = builder.name;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MetricSummary}.
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
        builder.archivedAt = archivedAt;
        builder.code = code;
        builder.createdAt = createdAt;
        builder.description = description;
        builder.id = id;
        builder.name = name;
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
     * The {@code archived_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> archivedAt() {
        return archivedAt.asOptional();
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
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
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
        MetricSummary that = (MetricSummary) o;
        return Objects.equals(aggregationKey, that.aggregationKey)
                && Objects.equals(aggregationType, that.aggregationType)
                && Objects.equals(archivedAt, that.archivedAt)
                && Objects.equals(code, that.code)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(description, that.description)
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                aggregationKey,
                aggregationType,
                archivedAt,
                code,
                createdAt,
                description,
                id,
                name,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "MetricSummary{"
                + "aggregationKey="
                + aggregationKey
                + ", aggregationType="
                + aggregationType
                + ", archivedAt="
                + archivedAt
                + ", code="
                + code
                + ", createdAt="
                + createdAt
                + ", description="
                + description
                + ", id="
                + id
                + ", name="
                + name
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MetricSummary}. */
    public static final class Builder {
        private JsonField<String> aggregationKey = JsonField.missing();
        private BillingMetricAggregateEnum aggregationType;
        private JsonField<OffsetDateTime> archivedAt = JsonField.missing();
        private String code;
        private OffsetDateTime createdAt;
        private JsonField<String> description = JsonField.missing();
        private String id;
        private String name;
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
         * The {@code archived_at} property.
         *
         * @param archivedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder archivedAt(OffsetDateTime archivedAt) {
            this.archivedAt = JsonField.ofNullable(archivedAt);
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
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
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
         * The {@code MetricSummary}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MetricSummary build() {
            Utils.checkRequired(aggregationType, "aggregation_type");
            Utils.checkRequired(code, "code");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(name, "name");
            return new MetricSummary(this);
        }
    }

    /**
     * Parse {@code json} as {@code MetricSummary}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MetricSummary fromJson(String json) {
        return Utils.parse(json, MetricSummary.class);
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
