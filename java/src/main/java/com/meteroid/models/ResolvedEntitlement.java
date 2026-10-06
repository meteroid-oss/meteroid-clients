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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Merged entitlement value for a feature across the priority hierarchy, without usage data.
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ResolvedEntitlement {
    @JsonProperty("feature")
    private FeatureRef feature;

    @JsonProperty("value")
    private ResolvedEntitlementValue value;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ResolvedEntitlement() {}

    private ResolvedEntitlement(Builder builder) {
        this.feature = builder.feature;
        this.value = builder.value;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ResolvedEntitlement}.
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
        builder.feature = feature;
        builder.value = value;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code feature} property.
     *
     * @return the value, never null
     */
    public FeatureRef feature() {
        return Utils.required(feature, "feature");
    }

    /**
     * The {@code value} property.
     *
     * @return the value, never null
     */
    public ResolvedEntitlementValue value() {
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
        ResolvedEntitlement that = (ResolvedEntitlement) o;
        return Objects.equals(feature, that.feature)
                && Objects.equals(value, that.value)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feature, value, additionalProperties);
    }

    @Override
    public String toString() {
        return "ResolvedEntitlement{"
                + "feature="
                + feature
                + ", value="
                + value
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ResolvedEntitlement}. */
    public static final class Builder {
        private FeatureRef feature;
        private ResolvedEntitlementValue value;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code feature} property.
         *
         * @param feature the value
         * @return this builder
         */
        public Builder feature(FeatureRef feature) {
            this.feature = feature;
            return this;
        }

        /**
         * The {@code value} property.
         *
         * @param value the value
         * @return this builder
         */
        public Builder value(ResolvedEntitlementValue value) {
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
         * The {@code ResolvedEntitlement}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ResolvedEntitlement build() {
            Utils.checkRequired(feature, "feature");
            Utils.checkRequired(value, "value");
            return new ResolvedEntitlement(this);
        }
    }

    /**
     * Parse {@code json} as {@code ResolvedEntitlement}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ResolvedEntitlement fromJson(String json) {
        return Utils.parse(json, ResolvedEntitlement.class);
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
