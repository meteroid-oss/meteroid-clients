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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Slot-based fee (e.g., per-seat pricing)
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class SlotPlanFee {
    @JsonProperty("minimum_count")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> minimumCount = JsonField.missing();

    @JsonProperty("quota")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> quota = JsonField.missing();

    @JsonProperty("rates")
    private List<TermRate> rates;

    @JsonProperty("slot_unit_name")
    private String slotUnitName;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SlotPlanFee() {}

    private SlotPlanFee(Builder builder) {
        this.minimumCount = builder.minimumCount;
        this.quota = builder.quota;
        this.rates = Utils.copyList(builder.rates);
        this.slotUnitName = builder.slotUnitName;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SlotPlanFee}.
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
        builder.minimumCount = minimumCount;
        builder.quota = quota;
        builder.rates = Utils.mutableList(rates);
        builder.slotUnitName = slotUnitName;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code minimum_count} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> minimumCount() {
        return minimumCount.asOptional();
    }

    /**
     * The {@code quota} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> quota() {
        return quota.asOptional();
    }

    /**
     * The {@code rates} property.
     *
     * @return the value, never null
     */
    public List<TermRate> rates() {
        return Utils.required(rates, "rates");
    }

    /**
     * The {@code slot_unit_name} property.
     *
     * @return the value, never null
     */
    public String slotUnitName() {
        return Utils.required(slotUnitName, "slot_unit_name");
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
        SlotPlanFee that = (SlotPlanFee) o;
        return Objects.equals(minimumCount, that.minimumCount)
                && Objects.equals(quota, that.quota)
                && Objects.equals(rates, that.rates)
                && Objects.equals(slotUnitName, that.slotUnitName)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumCount, quota, rates, slotUnitName, additionalProperties);
    }

    @Override
    public String toString() {
        return "SlotPlanFee{"
                + "minimumCount="
                + minimumCount
                + ", quota="
                + quota
                + ", rates="
                + rates
                + ", slotUnitName="
                + slotUnitName
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SlotPlanFee}. */
    public static final class Builder {
        private JsonField<Integer> minimumCount = JsonField.missing();
        private JsonField<Integer> quota = JsonField.missing();
        private List<TermRate> rates;
        private String slotUnitName;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code minimum_count} property.
         *
         * @param minimumCount the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder minimumCount(Integer minimumCount) {
            this.minimumCount = JsonField.ofNullable(minimumCount);
            return this;
        }

        /**
         * The {@code quota} property.
         *
         * @param quota the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder quota(Integer quota) {
            this.quota = JsonField.ofNullable(quota);
            return this;
        }

        /**
         * The {@code rates} property.
         *
         * @param rates the value
         * @return this builder
         */
        public Builder rates(List<TermRate> rates) {
            this.rates = Utils.mutableList(rates);
            return this;
        }

        /**
         * Adds an item to {@code rates}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addRatesItem(TermRate item) {
            if (this.rates == null) {
                this.rates = new ArrayList<>();
            }
            this.rates.add(item);
            return this;
        }

        /**
         * The {@code slot_unit_name} property.
         *
         * @param slotUnitName the value
         * @return this builder
         */
        public Builder slotUnitName(String slotUnitName) {
            this.slotUnitName = slotUnitName;
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
         * The {@code SlotPlanFee}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SlotPlanFee build() {
            Utils.checkRequired(rates, "rates");
            Utils.checkRequired(slotUnitName, "slot_unit_name");
            return new SlotPlanFee(this);
        }
    }

    /**
     * Parse {@code json} as {@code SlotPlanFee}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SlotPlanFee fromJson(String json) {
        return Utils.parse(json, SlotPlanFee.class);
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
