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
public final class TrialConfig {
    @JsonProperty("duration_days")
    private Integer durationDays;

    @JsonProperty("is_free")
    private Boolean isFree;

    @JsonProperty("trialing_plan_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> trialingPlanId = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TrialConfig() {}

    private TrialConfig(Builder builder) {
        this.durationDays = builder.durationDays;
        this.isFree = builder.isFree;
        this.trialingPlanId = builder.trialingPlanId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TrialConfig}.
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
        builder.durationDays = durationDays;
        builder.isFree = isFree;
        builder.trialingPlanId = trialingPlanId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code duration_days} property.
     *
     * @return the value, never null
     */
    public Integer durationDays() {
        return Utils.required(durationDays, "duration_days");
    }

    /**
     * The {@code is_free} property.
     *
     * @return the value, never null
     */
    public Boolean isFree() {
        return Utils.required(isFree, "is_free");
    }

    /**
     * The {@code trialing_plan_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> trialingPlanId() {
        return trialingPlanId.asOptional();
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
        TrialConfig that = (TrialConfig) o;
        return Objects.equals(durationDays, that.durationDays)
                && Objects.equals(isFree, that.isFree)
                && Objects.equals(trialingPlanId, that.trialingPlanId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(durationDays, isFree, trialingPlanId, additionalProperties);
    }

    @Override
    public String toString() {
        return "TrialConfig{"
                + "durationDays="
                + durationDays
                + ", isFree="
                + isFree
                + ", trialingPlanId="
                + trialingPlanId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TrialConfig}. */
    public static final class Builder {
        private Integer durationDays;
        private Boolean isFree;
        private JsonField<String> trialingPlanId = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code duration_days} property.
         *
         * @param durationDays the value
         * @return this builder
         */
        public Builder durationDays(Integer durationDays) {
            this.durationDays = durationDays;
            return this;
        }

        /**
         * The {@code is_free} property.
         *
         * @param isFree the value
         * @return this builder
         */
        public Builder isFree(Boolean isFree) {
            this.isFree = isFree;
            return this;
        }

        /**
         * The {@code trialing_plan_id} property.
         *
         * @param trialingPlanId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder trialingPlanId(String trialingPlanId) {
            this.trialingPlanId = JsonField.ofNullable(trialingPlanId);
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
         * The {@code TrialConfig}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TrialConfig build() {
            Utils.checkRequired(durationDays, "duration_days");
            Utils.checkRequired(isFree, "is_free");
            return new TrialConfig(this);
        }
    }

    /**
     * Parse {@code json} as {@code TrialConfig}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TrialConfig fromJson(String json) {
        return Utils.parse(json, TrialConfig.class);
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
