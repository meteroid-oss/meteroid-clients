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

import java.math.BigDecimal;
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
public final class MeteredEntitlementUsage {
    @JsonProperty("consumed")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BigDecimal> consumed = JsonField.missing();

    @JsonProperty("remaining")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BigDecimal> remaining = JsonField.missing();

    @JsonProperty("reset_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> resetAt = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MeteredEntitlementUsage() {}

    private MeteredEntitlementUsage(Builder builder) {
        this.consumed = builder.consumed;
        this.remaining = builder.remaining;
        this.resetAt = builder.resetAt;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MeteredEntitlementUsage}.
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
        builder.consumed = consumed;
        builder.remaining = remaining;
        builder.resetAt = resetAt;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code consumed} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BigDecimal> consumed() {
        return consumed.asOptional();
    }

    /**
     * The {@code remaining} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BigDecimal> remaining() {
        return remaining.asOptional();
    }

    /**
     * The {@code reset_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> resetAt() {
        return resetAt.asOptional();
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
        MeteredEntitlementUsage that = (MeteredEntitlementUsage) o;
        return Objects.equals(consumed, that.consumed)
                && Objects.equals(remaining, that.remaining)
                && Objects.equals(resetAt, that.resetAt)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumed, remaining, resetAt, additionalProperties);
    }

    @Override
    public String toString() {
        return "MeteredEntitlementUsage{"
                + "consumed="
                + consumed
                + ", remaining="
                + remaining
                + ", resetAt="
                + resetAt
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MeteredEntitlementUsage}. */
    public static final class Builder {
        private JsonField<BigDecimal> consumed = JsonField.missing();
        private JsonField<BigDecimal> remaining = JsonField.missing();
        private JsonField<OffsetDateTime> resetAt = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code consumed} property.
         *
         * @param consumed the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder consumed(BigDecimal consumed) {
            this.consumed = JsonField.ofNullable(consumed);
            return this;
        }

        /**
         * The {@code remaining} property.
         *
         * @param remaining the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder remaining(BigDecimal remaining) {
            this.remaining = JsonField.ofNullable(remaining);
            return this;
        }

        /**
         * The {@code reset_at} property.
         *
         * @param resetAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder resetAt(OffsetDateTime resetAt) {
            this.resetAt = JsonField.ofNullable(resetAt);
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
         * The {@code MeteredEntitlementUsage}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MeteredEntitlementUsage build() {
            return new MeteredEntitlementUsage(this);
        }
    }

    /**
     * Parse {@code json} as {@code MeteredEntitlementUsage}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MeteredEntitlementUsage fromJson(String json) {
        return Utils.parse(json, MeteredEntitlementUsage.class);
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
