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
public final class Feature {
    @JsonProperty("code")
    private String code;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("entitlement")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Entitlement> entitlement = JsonField.missing();

    @JsonProperty("feature_type")
    private FeatureType featureType;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("product")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<EntitlementProductRef> product = JsonField.missing();

    @JsonProperty("status")
    private FeatureStatus status;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Feature() {}

    private Feature(Builder builder) {
        this.code = builder.code;
        this.createdAt = builder.createdAt;
        this.description = builder.description;
        this.entitlement = builder.entitlement;
        this.featureType = builder.featureType;
        this.id = builder.id;
        this.name = builder.name;
        this.product = builder.product;
        this.status = builder.status;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Feature}.
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
        builder.code = code;
        builder.createdAt = createdAt;
        builder.description = description;
        builder.entitlement = entitlement;
        builder.featureType = featureType;
        builder.id = id;
        builder.name = name;
        builder.product = product;
        builder.status = status;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Unique key used to reference this feature in your code. Cannot be changed after creation.
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
     * The {@code entitlement} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Entitlement> entitlement() {
        return entitlement.asOptional();
    }

    /**
     * The {@code feature_type} property.
     *
     * @return the value, never null
     */
    public FeatureType featureType() {
        return Utils.required(featureType, "feature_type");
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
     * The {@code product} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<EntitlementProductRef> product() {
        return product.asOptional();
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public FeatureStatus status() {
        return Utils.required(status, "status");
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
        Feature that = (Feature) o;
        return Objects.equals(code, that.code)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(description, that.description)
                && Objects.equals(entitlement, that.entitlement)
                && Objects.equals(featureType, that.featureType)
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(product, that.product)
                && Objects.equals(status, that.status)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                code,
                createdAt,
                description,
                entitlement,
                featureType,
                id,
                name,
                product,
                status,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "Feature{"
                + "code="
                + code
                + ", createdAt="
                + createdAt
                + ", description="
                + description
                + ", entitlement="
                + entitlement
                + ", featureType="
                + featureType
                + ", id="
                + id
                + ", name="
                + name
                + ", product="
                + product
                + ", status="
                + status
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Feature}. */
    public static final class Builder {
        private String code;
        private OffsetDateTime createdAt;
        private JsonField<String> description = JsonField.missing();
        private JsonField<Entitlement> entitlement = JsonField.missing();
        private FeatureType featureType;
        private String id;
        private String name;
        private JsonField<EntitlementProductRef> product = JsonField.missing();
        private FeatureStatus status;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Unique key used to reference this feature in your code. Cannot be changed after creation.
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
         * The {@code entitlement} property.
         *
         * @param entitlement the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder entitlement(Entitlement entitlement) {
            this.entitlement = JsonField.ofNullable(entitlement);
            return this;
        }

        /**
         * The {@code feature_type} property.
         *
         * @param featureType the value
         * @return this builder
         */
        public Builder featureType(FeatureType featureType) {
            this.featureType = featureType;
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
         * The {@code product} property.
         *
         * @param product the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder product(EntitlementProductRef product) {
            this.product = JsonField.ofNullable(product);
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(FeatureStatus status) {
            this.status = status;
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
         * The {@code Feature}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Feature build() {
            Utils.checkRequired(code, "code");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(featureType, "feature_type");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(status, "status");
            return new Feature(this);
        }
    }

    /**
     * Parse {@code json} as {@code Feature}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Feature fromJson(String json) {
        return Utils.parse(json, Feature.class);
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
