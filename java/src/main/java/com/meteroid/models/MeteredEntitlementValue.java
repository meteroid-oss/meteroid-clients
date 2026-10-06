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
public final class MeteredEntitlementValue {
    @JsonProperty("enabled")
    private Boolean enabled;

    @JsonProperty("limit")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BigDecimal> limit = JsonField.missing();

    @JsonProperty("reset_period")
    private ResetPeriod resetPeriod;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MeteredEntitlementValue() {}

    private MeteredEntitlementValue(Builder builder) {
        this.enabled = builder.enabled;
        this.limit = builder.limit;
        this.resetPeriod = builder.resetPeriod;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MeteredEntitlementValue}.
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
        builder.enabled = enabled;
        builder.limit = limit;
        builder.resetPeriod = resetPeriod;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Per-entitlement kill switch. <code>false</code> means disabled.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> enabled() {
        return Optional.ofNullable(enabled);
    }

    /**
     * Cap on usage. Null means unlimited.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BigDecimal> limit() {
        return limit.asOptional();
    }

    /**
     * The {@code reset_period} property.
     *
     * @return the value, empty when unset
     */
    public Optional<ResetPeriod> resetPeriod() {
        return Optional.ofNullable(resetPeriod);
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
        MeteredEntitlementValue that = (MeteredEntitlementValue) o;
        return Objects.equals(enabled, that.enabled)
                && Objects.equals(limit, that.limit)
                && Objects.equals(resetPeriod, that.resetPeriod)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, limit, resetPeriod, additionalProperties);
    }

    @Override
    public String toString() {
        return "MeteredEntitlementValue{"
                + "enabled="
                + enabled
                + ", limit="
                + limit
                + ", resetPeriod="
                + resetPeriod
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MeteredEntitlementValue}. */
    public static final class Builder {
        private Boolean enabled;
        private JsonField<BigDecimal> limit = JsonField.missing();
        private ResetPeriod resetPeriod;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Per-entitlement kill switch. <code>false</code> means disabled.
         *
         * @param enabled the value
         * @return this builder
         */
        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Cap on usage. Null means unlimited.
         *
         * @param limit the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder limit(BigDecimal limit) {
            this.limit = JsonField.ofNullable(limit);
            return this;
        }

        /**
         * The {@code reset_period} property.
         *
         * @param resetPeriod the value
         * @return this builder
         */
        public Builder resetPeriod(ResetPeriod resetPeriod) {
            this.resetPeriod = resetPeriod;
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
         * The {@code MeteredEntitlementValue}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MeteredEntitlementValue build() {
            return new MeteredEntitlementValue(this);
        }
    }

    /**
     * Parse {@code json} as {@code MeteredEntitlementValue}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MeteredEntitlementValue fromJson(String json) {
        return Utils.parse(json, MeteredEntitlementValue.class);
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
