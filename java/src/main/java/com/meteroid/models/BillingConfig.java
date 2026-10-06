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
public final class BillingConfig {
    @JsonProperty("billing_cycles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> billingCycles = JsonField.missing();

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("period_start_day")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> periodStartDay = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private BillingConfig() {}

    private BillingConfig(Builder builder) {
        this.billingCycles = builder.billingCycles;
        this.netTerms = builder.netTerms;
        this.periodStartDay = builder.periodStartDay;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code BillingConfig}.
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
        builder.billingCycles = billingCycles;
        builder.netTerms = netTerms;
        builder.periodStartDay = periodStartDay;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code billing_cycles} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> billingCycles() {
        return billingCycles.asOptional();
    }

    /**
     * The {@code net_terms} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> netTerms() {
        return Optional.ofNullable(netTerms);
    }

    /**
     * The {@code period_start_day} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> periodStartDay() {
        return periodStartDay.asOptional();
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
        BillingConfig that = (BillingConfig) o;
        return Objects.equals(billingCycles, that.billingCycles)
                && Objects.equals(netTerms, that.netTerms)
                && Objects.equals(periodStartDay, that.periodStartDay)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingCycles, netTerms, periodStartDay, additionalProperties);
    }

    @Override
    public String toString() {
        return "BillingConfig{"
                + "billingCycles="
                + billingCycles
                + ", netTerms="
                + netTerms
                + ", periodStartDay="
                + periodStartDay
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link BillingConfig}. */
    public static final class Builder {
        private JsonField<Integer> billingCycles = JsonField.missing();
        private Integer netTerms;
        private JsonField<Integer> periodStartDay = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code billing_cycles} property.
         *
         * @param billingCycles the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingCycles(Integer billingCycles) {
            this.billingCycles = JsonField.ofNullable(billingCycles);
            return this;
        }

        /**
         * The {@code net_terms} property.
         *
         * @param netTerms the value
         * @return this builder
         */
        public Builder netTerms(Integer netTerms) {
            this.netTerms = netTerms;
            return this;
        }

        /**
         * The {@code period_start_day} property.
         *
         * @param periodStartDay the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder periodStartDay(Integer periodStartDay) {
            this.periodStartDay = JsonField.ofNullable(periodStartDay);
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
         * The {@code BillingConfig}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public BillingConfig build() {
            return new BillingConfig(this);
        }
    }

    /**
     * Parse {@code json} as {@code BillingConfig}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static BillingConfig fromJson(String json) {
        return Utils.parse(json, BillingConfig.class);
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
