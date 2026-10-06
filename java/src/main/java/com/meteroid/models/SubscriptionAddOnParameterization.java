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
public final class SubscriptionAddOnParameterization {
    @JsonProperty("billing_period")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BillingPeriodEnum> billingPeriod = JsonField.missing();

    @JsonProperty("committed_capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> committedCapacity = JsonField.missing();

    @JsonProperty("initial_slot_count")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> initialSlotCount = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SubscriptionAddOnParameterization() {}

    private SubscriptionAddOnParameterization(Builder builder) {
        this.billingPeriod = builder.billingPeriod;
        this.committedCapacity = builder.committedCapacity;
        this.initialSlotCount = builder.initialSlotCount;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SubscriptionAddOnParameterization}.
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
        builder.billingPeriod = billingPeriod;
        builder.committedCapacity = committedCapacity;
        builder.initialSlotCount = initialSlotCount;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code billing_period} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BillingPeriodEnum> billingPeriod() {
        return billingPeriod.asOptional();
    }

    /**
     * The {@code committed_capacity} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Long> committedCapacity() {
        return committedCapacity.asOptional();
    }

    /**
     * The {@code initial_slot_count} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> initialSlotCount() {
        return initialSlotCount.asOptional();
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
        SubscriptionAddOnParameterization that = (SubscriptionAddOnParameterization) o;
        return Objects.equals(billingPeriod, that.billingPeriod)
                && Objects.equals(committedCapacity, that.committedCapacity)
                && Objects.equals(initialSlotCount, that.initialSlotCount)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                billingPeriod, committedCapacity, initialSlotCount, additionalProperties);
    }

    @Override
    public String toString() {
        return "SubscriptionAddOnParameterization{"
                + "billingPeriod="
                + billingPeriod
                + ", committedCapacity="
                + committedCapacity
                + ", initialSlotCount="
                + initialSlotCount
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SubscriptionAddOnParameterization}. */
    public static final class Builder {
        private JsonField<BillingPeriodEnum> billingPeriod = JsonField.missing();
        private JsonField<Long> committedCapacity = JsonField.missing();
        private JsonField<Integer> initialSlotCount = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code billing_period} property.
         *
         * @param billingPeriod the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingPeriod(BillingPeriodEnum billingPeriod) {
            this.billingPeriod = JsonField.ofNullable(billingPeriod);
            return this;
        }

        /**
         * The {@code committed_capacity} property.
         *
         * @param committedCapacity the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder committedCapacity(Long committedCapacity) {
            this.committedCapacity = JsonField.ofNullable(committedCapacity);
            return this;
        }

        /**
         * The {@code initial_slot_count} property.
         *
         * @param initialSlotCount the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder initialSlotCount(Integer initialSlotCount) {
            this.initialSlotCount = JsonField.ofNullable(initialSlotCount);
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
         * The {@code SubscriptionAddOnParameterization}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SubscriptionAddOnParameterization build() {
            return new SubscriptionAddOnParameterization(this);
        }
    }

    /**
     * Parse {@code json} as {@code SubscriptionAddOnParameterization}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SubscriptionAddOnParameterization fromJson(String json) {
        return Utils.parse(json, SubscriptionAddOnParameterization.class);
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
