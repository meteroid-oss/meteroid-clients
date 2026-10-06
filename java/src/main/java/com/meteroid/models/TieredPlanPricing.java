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

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class TieredPlanPricing {
    @JsonProperty("block_size")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> blockSize = JsonField.missing();

    @JsonProperty("tiers")
    private List<TierRow> tiers;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TieredPlanPricing() {}

    private TieredPlanPricing(Builder builder) {
        this.blockSize = builder.blockSize;
        this.tiers = Utils.copyList(builder.tiers);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TieredPlanPricing}.
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
        builder.blockSize = blockSize;
        builder.tiers = Utils.mutableList(tiers);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code block_size} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Long> blockSize() {
        return blockSize.asOptional();
    }

    /**
     * The {@code tiers} property.
     *
     * @return the value, never null
     */
    public List<TierRow> tiers() {
        return Utils.required(tiers, "tiers");
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
        TieredPlanPricing that = (TieredPlanPricing) o;
        return Objects.equals(blockSize, that.blockSize)
                && Objects.equals(tiers, that.tiers)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockSize, tiers, additionalProperties);
    }

    @Override
    public String toString() {
        return "TieredPlanPricing{"
                + "blockSize="
                + blockSize
                + ", tiers="
                + tiers
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TieredPlanPricing}. */
    public static final class Builder {
        private JsonField<Long> blockSize = JsonField.missing();
        private List<TierRow> tiers;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code block_size} property.
         *
         * @param blockSize the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder blockSize(Long blockSize) {
            this.blockSize = JsonField.ofNullable(blockSize);
            return this;
        }

        /**
         * The {@code tiers} property.
         *
         * @param tiers the value
         * @return this builder
         */
        public Builder tiers(List<TierRow> tiers) {
            this.tiers = Utils.mutableList(tiers);
            return this;
        }

        /**
         * Adds an item to {@code tiers}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addTiersItem(TierRow item) {
            if (this.tiers == null) {
                this.tiers = new ArrayList<>();
            }
            this.tiers.add(item);
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
         * The {@code TieredPlanPricing}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TieredPlanPricing build() {
            Utils.checkRequired(tiers, "tiers");
            return new TieredPlanPricing(this);
        }
    }

    /**
     * Parse {@code json} as {@code TieredPlanPricing}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TieredPlanPricing fromJson(String json) {
        return Utils.parse(json, TieredPlanPricing.class);
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
