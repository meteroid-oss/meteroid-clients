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

/**
 * A raw entitlement row attached to one entity (feature, plan version, add-on, or subscription).
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class Entitlement {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("feature_id")
    private String featureId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    @JsonProperty("value")
    private EntitlementValue value;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Entitlement() {}

    private Entitlement(Builder builder) {
        this.createdAt = builder.createdAt;
        this.featureId = builder.featureId;
        this.id = builder.id;
        this.updatedAt = builder.updatedAt;
        this.value = builder.value;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Entitlement}.
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
        builder.featureId = featureId;
        builder.id = id;
        builder.updatedAt = updatedAt;
        builder.value = value;
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
     * The {@code feature_id} property.
     *
     * @return the value, never null
     */
    public String featureId() {
        return Utils.required(featureId, "feature_id");
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
     * The {@code updated_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime updatedAt() {
        return Utils.required(updatedAt, "updated_at");
    }

    /**
     * The {@code value} property.
     *
     * @return the value, never null
     */
    public EntitlementValue value() {
        return Utils.required(value, "value");
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
        Entitlement that = (Entitlement) o;
        return Objects.equals(createdAt, that.createdAt)
                && Objects.equals(featureId, that.featureId)
                && Objects.equals(id, that.id)
                && Objects.equals(updatedAt, that.updatedAt)
                && Objects.equals(value, that.value)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, featureId, id, updatedAt, value, additionalProperties);
    }

    @Override
    public String toString() {
        return "Entitlement{"
                + "createdAt="
                + createdAt
                + ", featureId="
                + featureId
                + ", id="
                + id
                + ", updatedAt="
                + updatedAt
                + ", value="
                + value
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Entitlement}. */
    public static final class Builder {
        private OffsetDateTime createdAt;
        private String featureId;
        private String id;
        private OffsetDateTime updatedAt;
        private EntitlementValue value;
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
         * The {@code feature_id} property.
         *
         * @param featureId the value
         * @return this builder
         */
        public Builder featureId(String featureId) {
            this.featureId = featureId;
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
         * The {@code updated_at} property.
         *
         * @param updatedAt the value
         * @return this builder
         */
        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * The {@code value} property.
         *
         * @param value the value
         * @return this builder
         */
        public Builder value(EntitlementValue value) {
            this.value = value;
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
         * The {@code Entitlement}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Entitlement build() {
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(featureId, "feature_id");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(updatedAt, "updated_at");
            Utils.checkRequired(value, "value");
            return new Entitlement(this);
        }
    }

    /**
     * Parse {@code json} as {@code Entitlement}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Entitlement fromJson(String json) {
        return Utils.parse(json, Entitlement.class);
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
