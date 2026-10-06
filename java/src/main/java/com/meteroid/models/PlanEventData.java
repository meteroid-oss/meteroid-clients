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
public final class PlanEventData {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("name")
    private String name;

    @JsonProperty("plan_id")
    private String planId;

    @JsonProperty("plan_type")
    private PlanTypeEnum planType;

    @JsonProperty("status")
    private PlanStatusEnum status;

    @JsonProperty("version")
    private Integer version;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private PlanEventData() {}

    private PlanEventData(Builder builder) {
        this.createdAt = builder.createdAt;
        this.currency = builder.currency;
        this.description = builder.description;
        this.name = builder.name;
        this.planId = builder.planId;
        this.planType = builder.planType;
        this.status = builder.status;
        this.version = builder.version;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code PlanEventData}.
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
        builder.createdAt = createdAt;
        builder.currency = currency;
        builder.description = description;
        builder.name = name;
        builder.planId = planId;
        builder.planType = planType;
        builder.status = status;
        builder.version = version;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public String currency() {
        return Utils.required(currency, "currency");
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
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code plan_id} property.
     *
     * @return the value, never null
     */
    public String planId() {
        return Utils.required(planId, "plan_id");
    }

    /**
     * The {@code plan_type} property.
     *
     * @return the value, never null
     */
    public PlanTypeEnum planType() {
        return Utils.required(planType, "plan_type");
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public PlanStatusEnum status() {
        return Utils.required(status, "status");
    }

    /**
     * The {@code version} property.
     *
     * @return the value, never null
     */
    public Integer version() {
        return Utils.required(version, "version");
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
        PlanEventData that = (PlanEventData) o;
        return Objects.equals(createdAt, that.createdAt)
                && Objects.equals(currency, that.currency)
                && Objects.equals(description, that.description)
                && Objects.equals(name, that.name)
                && Objects.equals(planId, that.planId)
                && Objects.equals(planType, that.planType)
                && Objects.equals(status, that.status)
                && Objects.equals(version, that.version)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                createdAt,
                currency,
                description,
                name,
                planId,
                planType,
                status,
                version,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "PlanEventData{"
                + "createdAt="
                + createdAt
                + ", currency="
                + currency
                + ", description="
                + description
                + ", name="
                + name
                + ", planId="
                + planId
                + ", planType="
                + planType
                + ", status="
                + status
                + ", version="
                + version
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link PlanEventData}. */
    public static final class Builder {
        private OffsetDateTime createdAt;
        private String currency;
        private JsonField<String> description = JsonField.missing();
        private String name;
        private String planId;
        private PlanTypeEnum planType;
        private PlanStatusEnum status;
        private Integer version;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * The {@code currency} property.
         *
         * @param currency the value
         * @return this builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
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
         * The {@code plan_id} property.
         *
         * @param planId the value
         * @return this builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        /**
         * The {@code plan_type} property.
         *
         * @param planType the value
         * @return this builder
         */
        public Builder planType(PlanTypeEnum planType) {
            this.planType = planType;
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(PlanStatusEnum status) {
            this.status = status;
            return this;
        }

        /**
         * The {@code version} property.
         *
         * @param version the value
         * @return this builder
         */
        public Builder version(Integer version) {
            this.version = version;
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
         * The {@code PlanEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public PlanEventData build() {
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(planId, "plan_id");
            Utils.checkRequired(planType, "plan_type");
            Utils.checkRequired(status, "status");
            Utils.checkRequired(version, "version");
            return new PlanEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code PlanEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PlanEventData fromJson(String json) {
        return Utils.parse(json, PlanEventData.class);
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
