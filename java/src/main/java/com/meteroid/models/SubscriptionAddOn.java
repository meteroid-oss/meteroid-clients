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
import java.util.Optional;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class SubscriptionAddOn {
    @JsonProperty("add_on_id")
    private String addOnId;

    @JsonProperty("fee")
    private SubscriptionFee fee;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("period")
    private SubscriptionFeeBillingPeriodEnum period;

    @JsonProperty("quantity")
    private Integer quantity;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private SubscriptionAddOn() {}

    private SubscriptionAddOn(Builder builder) {
        this.addOnId = builder.addOnId;
        this.fee = builder.fee;
        this.id = builder.id;
        this.name = builder.name;
        this.period = builder.period;
        this.quantity = builder.quantity;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code SubscriptionAddOn}.
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
        builder.addOnId = addOnId;
        builder.fee = fee;
        builder.id = id;
        builder.name = name;
        builder.period = period;
        builder.quantity = quantity;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code add_on_id} property.
     *
     * @return the value, empty when unset
     */
    public Optional<String> addOnId() {
        return Optional.ofNullable(addOnId);
    }

    /**
     * The {@code fee} property.
     *
     * @return the value, never null
     */
    public SubscriptionFee fee() {
        return Utils.required(fee, "fee");
    }

    /**
     * The {@code id} property.
     *
     * @return the value, empty when unset
     */
    public Optional<String> id() {
        return Optional.ofNullable(id);
    }

    /**
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code period} property.
     *
     * @return the value, never null
     */
    public SubscriptionFeeBillingPeriodEnum period() {
        return Utils.required(period, "period");
    }

    /**
     * The {@code quantity} property.
     *
     * @return the value, never null
     */
    public Integer quantity() {
        return Utils.required(quantity, "quantity");
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
        SubscriptionAddOn that = (SubscriptionAddOn) o;
        return Objects.equals(addOnId, that.addOnId)
                && Objects.equals(fee, that.fee)
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(period, that.period)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addOnId, fee, id, name, period, quantity, additionalProperties);
    }

    @Override
    public String toString() {
        return "SubscriptionAddOn{"
                + "addOnId="
                + addOnId
                + ", fee="
                + fee
                + ", id="
                + id
                + ", name="
                + name
                + ", period="
                + period
                + ", quantity="
                + quantity
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link SubscriptionAddOn}. */
    public static final class Builder {
        private String addOnId;
        private SubscriptionFee fee;
        private String id;
        private String name;
        private SubscriptionFeeBillingPeriodEnum period;
        private Integer quantity;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code add_on_id} property.
         *
         * @param addOnId the value
         * @return this builder
         */
        public Builder addOnId(String addOnId) {
            this.addOnId = addOnId;
            return this;
        }

        /**
         * The {@code fee} property.
         *
         * @param fee the value
         * @return this builder
         */
        public Builder fee(SubscriptionFee fee) {
            this.fee = fee;
            return this;
        }

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * The {@code name} property.
         *
         * @param name the value
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The {@code period} property.
         *
         * @param period the value
         * @return this builder
         */
        public Builder period(SubscriptionFeeBillingPeriodEnum period) {
            this.period = period;
            return this;
        }

        /**
         * The {@code quantity} property.
         *
         * @param quantity the value
         * @return this builder
         */
        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
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
         * The {@code SubscriptionAddOn}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public SubscriptionAddOn build() {
            Utils.checkRequired(fee, "fee");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(period, "period");
            Utils.checkRequired(quantity, "quantity");
            return new SubscriptionAddOn(this);
        }
    }

    /**
     * Parse {@code json} as {@code SubscriptionAddOn}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SubscriptionAddOn fromJson(String json) {
        return Utils.parse(json, SubscriptionAddOn.class);
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
