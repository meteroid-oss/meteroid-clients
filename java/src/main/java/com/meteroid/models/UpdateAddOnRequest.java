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
public final class UpdateAddOnRequest {
    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("max_instances_per_subscription")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> maxInstancesPerSubscription = JsonField.missing();

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> name = JsonField.missing();

    @JsonProperty("price_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> priceId = JsonField.missing();

    @JsonProperty("self_serviceable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> selfServiceable = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private UpdateAddOnRequest() {}

    private UpdateAddOnRequest(Builder builder) {
        this.description = builder.description;
        this.maxInstancesPerSubscription = builder.maxInstancesPerSubscription;
        this.name = builder.name;
        this.priceId = builder.priceId;
        this.selfServiceable = builder.selfServiceable;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code UpdateAddOnRequest}.
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
        builder.maxInstancesPerSubscription = maxInstancesPerSubscription;
        builder.name = name;
        builder.priceId = priceId;
        builder.selfServiceable = selfServiceable;
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
     * The {@code max_instances_per_subscription} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> maxInstancesPerSubscription() {
        return maxInstancesPerSubscription.asOptional();
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
     * The {@code price_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> priceId() {
        return priceId.asOptional();
    }

    /**
     * The {@code self_serviceable} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> selfServiceable() {
        return selfServiceable.asOptional();
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
        UpdateAddOnRequest that = (UpdateAddOnRequest) o;
        return Objects.equals(description, that.description)
                && Objects.equals(maxInstancesPerSubscription, that.maxInstancesPerSubscription)
                && Objects.equals(name, that.name)
                && Objects.equals(priceId, that.priceId)
                && Objects.equals(selfServiceable, that.selfServiceable)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                description,
                maxInstancesPerSubscription,
                name,
                priceId,
                selfServiceable,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "UpdateAddOnRequest{"
                + "description="
                + description
                + ", maxInstancesPerSubscription="
                + maxInstancesPerSubscription
                + ", name="
                + name
                + ", priceId="
                + priceId
                + ", selfServiceable="
                + selfServiceable
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link UpdateAddOnRequest}. */
    public static final class Builder {
        private JsonField<String> description = JsonField.missing();
        private JsonField<Integer> maxInstancesPerSubscription = JsonField.missing();
        private JsonField<String> name = JsonField.missing();
        private JsonField<String> priceId = JsonField.missing();
        private JsonField<Boolean> selfServiceable = JsonField.missing();
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
         * The {@code max_instances_per_subscription} property.
         *
         * @param maxInstancesPerSubscription the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder maxInstancesPerSubscription(Integer maxInstancesPerSubscription) {
            this.maxInstancesPerSubscription = JsonField.ofNullable(maxInstancesPerSubscription);
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
         * The {@code price_id} property.
         *
         * @param priceId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder priceId(String priceId) {
            this.priceId = JsonField.ofNullable(priceId);
            return this;
        }

        /**
         * The {@code self_serviceable} property.
         *
         * @param selfServiceable the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder selfServiceable(Boolean selfServiceable) {
            this.selfServiceable = JsonField.ofNullable(selfServiceable);
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
         * The {@code UpdateAddOnRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public UpdateAddOnRequest build() {
            return new UpdateAddOnRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code UpdateAddOnRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static UpdateAddOnRequest fromJson(String json) {
        return Utils.parse(json, UpdateAddOnRequest.class);
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
