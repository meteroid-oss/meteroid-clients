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
public final class TierRow {
    @JsonProperty("first_unit")
    private Long firstUnit;

    @JsonProperty("flat_cap")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BigDecimal> flatCap = JsonField.missing();

    @JsonProperty("flat_fee")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BigDecimal> flatFee = JsonField.missing();

    @JsonProperty("rate")
    private BigDecimal rate;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TierRow() {}

    private TierRow(Builder builder) {
        this.firstUnit = builder.firstUnit;
        this.flatCap = builder.flatCap;
        this.flatFee = builder.flatFee;
        this.rate = builder.rate;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TierRow}.
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
        builder.firstUnit = firstUnit;
        builder.flatCap = flatCap;
        builder.flatFee = flatFee;
        builder.rate = rate;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code first_unit} property.
     *
     * @return the value, never null
     */
    public Long firstUnit() {
        return Utils.required(firstUnit, "first_unit");
    }

    /**
     * The {@code flat_cap} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BigDecimal> flatCap() {
        return flatCap.asOptional();
    }

    /**
     * The {@code flat_fee} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BigDecimal> flatFee() {
        return flatFee.asOptional();
    }

    /**
     * The {@code rate} property.
     *
     * @return the value, never null
     */
    public BigDecimal rate() {
        return Utils.required(rate, "rate");
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
        TierRow that = (TierRow) o;
        return Objects.equals(firstUnit, that.firstUnit)
                && Objects.equals(flatCap, that.flatCap)
                && Objects.equals(flatFee, that.flatFee)
                && Objects.equals(rate, that.rate)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstUnit, flatCap, flatFee, rate, additionalProperties);
    }

    @Override
    public String toString() {
        return "TierRow{"
                + "firstUnit="
                + firstUnit
                + ", flatCap="
                + flatCap
                + ", flatFee="
                + flatFee
                + ", rate="
                + rate
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TierRow}. */
    public static final class Builder {
        private Long firstUnit;
        private JsonField<BigDecimal> flatCap = JsonField.missing();
        private JsonField<BigDecimal> flatFee = JsonField.missing();
        private BigDecimal rate;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code first_unit} property.
         *
         * @param firstUnit the value
         * @return this builder
         */
        public Builder firstUnit(Long firstUnit) {
            this.firstUnit = firstUnit;
            return this;
        }

        /**
         * The {@code flat_cap} property.
         *
         * @param flatCap the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder flatCap(BigDecimal flatCap) {
            this.flatCap = JsonField.ofNullable(flatCap);
            return this;
        }

        /**
         * The {@code flat_fee} property.
         *
         * @param flatFee the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder flatFee(BigDecimal flatFee) {
            this.flatFee = JsonField.ofNullable(flatFee);
            return this;
        }

        /**
         * The {@code rate} property.
         *
         * @param rate the value
         * @return this builder
         */
        public Builder rate(BigDecimal rate) {
            this.rate = rate;
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
         * The {@code TierRow}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TierRow build() {
            Utils.checkRequired(firstUnit, "first_unit");
            Utils.checkRequired(rate, "rate");
            return new TierRow(this);
        }
    }

    /**
     * Parse {@code json} as {@code TierRow}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TierRow fromJson(String json) {
        return Utils.parse(json, TierRow.class);
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
