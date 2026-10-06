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

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class PlanVersionSummary {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("id")
    private String id;

    @JsonProperty("is_draft")
    private Boolean isDraft;

    @JsonProperty("version")
    private Integer version;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private PlanVersionSummary() {}

    private PlanVersionSummary(Builder builder) {
        this.createdAt = builder.createdAt;
        this.currency = builder.currency;
        this.id = builder.id;
        this.isDraft = builder.isDraft;
        this.version = builder.version;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code PlanVersionSummary}.
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
        builder.id = id;
        builder.isDraft = isDraft;
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
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code is_draft} property.
     *
     * @return the value, never null
     */
    public Boolean isDraft() {
        return Utils.required(isDraft, "is_draft");
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
        PlanVersionSummary that = (PlanVersionSummary) o;
        return Objects.equals(createdAt, that.createdAt)
                && Objects.equals(currency, that.currency)
                && Objects.equals(id, that.id)
                && Objects.equals(isDraft, that.isDraft)
                && Objects.equals(version, that.version)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, currency, id, isDraft, version, additionalProperties);
    }

    @Override
    public String toString() {
        return "PlanVersionSummary{"
                + "createdAt="
                + createdAt
                + ", currency="
                + currency
                + ", id="
                + id
                + ", isDraft="
                + isDraft
                + ", version="
                + version
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link PlanVersionSummary}. */
    public static final class Builder {
        private OffsetDateTime createdAt;
        private String currency;
        private String id;
        private Boolean isDraft;
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
         * The {@code is_draft} property.
         *
         * @param isDraft the value
         * @return this builder
         */
        public Builder isDraft(Boolean isDraft) {
            this.isDraft = isDraft;
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
         * The {@code PlanVersionSummary}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public PlanVersionSummary build() {
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(isDraft, "is_draft");
            Utils.checkRequired(version, "version");
            return new PlanVersionSummary(this);
        }
    }

    /**
     * Parse {@code json} as {@code PlanVersionSummary}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PlanVersionSummary fromJson(String json) {
        return Utils.parse(json, PlanVersionSummary.class);
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
