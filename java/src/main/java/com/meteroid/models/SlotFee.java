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
public final class SlotFee {
    @JsonProperty("initial_slots")
    private Integer initialSlots;

    @JsonProperty("max_slots")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> maxSlots = JsonField.missing();

    @JsonProperty("min_slots")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> minSlots = JsonField.missing();

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("unit_rate")
    private BigDecimal unitRate;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SlotFee() {}

    private SlotFee(Builder builder) {
        this.initialSlots = builder.initialSlots;
        this.maxSlots = builder.maxSlots;
        this.minSlots = builder.minSlots;
        this.unit = builder.unit;
        this.unitRate = builder.unitRate;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SlotFee}.
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
        builder.initialSlots = initialSlots;
        builder.maxSlots = maxSlots;
        builder.minSlots = minSlots;
        builder.unit = unit;
        builder.unitRate = unitRate;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code initial_slots} property.
     *
     * @return the value, never null
     */
    public Integer initialSlots() {
        return Utils.required(initialSlots, "initial_slots");
    }

    /**
     * The {@code max_slots} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> maxSlots() {
        return maxSlots.asOptional();
    }

    /**
     * The {@code min_slots} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> minSlots() {
        return minSlots.asOptional();
    }

    /**
     * The {@code unit} property.
     *
     * @return the value, never null
     */
    public String unit() {
        return Utils.required(unit, "unit");
    }

    /**
     * The {@code unit_rate} property.
     *
     * @return the value, never null
     */
    public BigDecimal unitRate() {
        return Utils.required(unitRate, "unit_rate");
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
        SlotFee that = (SlotFee) o;
        return Objects.equals(initialSlots, that.initialSlots)
                && Objects.equals(maxSlots, that.maxSlots)
                && Objects.equals(minSlots, that.minSlots)
                && Objects.equals(unit, that.unit)
                && Objects.equals(unitRate, that.unitRate)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialSlots, maxSlots, minSlots, unit, unitRate, additionalProperties);
    }

    @Override
    public String toString() {
        return "SlotFee{"
                + "initialSlots="
                + initialSlots
                + ", maxSlots="
                + maxSlots
                + ", minSlots="
                + minSlots
                + ", unit="
                + unit
                + ", unitRate="
                + unitRate
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SlotFee}. */
    public static final class Builder {
        private Integer initialSlots;
        private JsonField<Integer> maxSlots = JsonField.missing();
        private JsonField<Integer> minSlots = JsonField.missing();
        private String unit;
        private BigDecimal unitRate;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code initial_slots} property.
         *
         * @param initialSlots the value
         * @return this builder
         */
        public Builder initialSlots(Integer initialSlots) {
            this.initialSlots = initialSlots;
            return this;
        }

        /**
         * The {@code max_slots} property.
         *
         * @param maxSlots the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder maxSlots(Integer maxSlots) {
            this.maxSlots = JsonField.ofNullable(maxSlots);
            return this;
        }

        /**
         * The {@code min_slots} property.
         *
         * @param minSlots the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder minSlots(Integer minSlots) {
            this.minSlots = JsonField.ofNullable(minSlots);
            return this;
        }

        /**
         * The {@code unit} property.
         *
         * @param unit the value
         * @return this builder
         */
        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        /**
         * The {@code unit_rate} property.
         *
         * @param unitRate the value
         * @return this builder
         */
        public Builder unitRate(BigDecimal unitRate) {
            this.unitRate = unitRate;
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
         * The {@code SlotFee}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SlotFee build() {
            Utils.checkRequired(initialSlots, "initial_slots");
            Utils.checkRequired(unit, "unit");
            Utils.checkRequired(unitRate, "unit_rate");
            return new SlotFee(this);
        }
    }

    /**
     * Parse {@code json} as {@code SlotFee}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SlotFee fromJson(String json) {
        return Utils.parse(json, SlotFee.class);
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
