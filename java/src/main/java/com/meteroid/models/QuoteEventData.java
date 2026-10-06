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
public final class QuoteEventData {
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("quote_id")
    private String quoteId;

    @JsonProperty("subscription_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> subscriptionId = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private QuoteEventData() {}

    private QuoteEventData(Builder builder) {
        this.customerId = builder.customerId;
        this.quoteId = builder.quoteId;
        this.subscriptionId = builder.subscriptionId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code QuoteEventData}.
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
        builder.customerId = customerId;
        builder.quoteId = quoteId;
        builder.subscriptionId = subscriptionId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code customer_id} property.
     *
     * @return the value, never null
     */
    public String customerId() {
        return Utils.required(customerId, "customer_id");
    }

    /**
     * The {@code quote_id} property.
     *
     * @return the value, never null
     */
    public String quoteId() {
        return Utils.required(quoteId, "quote_id");
    }

    /**
     * The {@code subscription_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> subscriptionId() {
        return subscriptionId.asOptional();
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
        QuoteEventData that = (QuoteEventData) o;
        return Objects.equals(customerId, that.customerId)
                && Objects.equals(quoteId, that.quoteId)
                && Objects.equals(subscriptionId, that.subscriptionId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, quoteId, subscriptionId, additionalProperties);
    }

    @Override
    public String toString() {
        return "QuoteEventData{"
                + "customerId="
                + customerId
                + ", quoteId="
                + quoteId
                + ", subscriptionId="
                + subscriptionId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link QuoteEventData}. */
    public static final class Builder {
        private String customerId;
        private String quoteId;
        private JsonField<String> subscriptionId = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code customer_id} property.
         *
         * @param customerId the value
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * The {@code quote_id} property.
         *
         * @param quoteId the value
         * @return this builder
         */
        public Builder quoteId(String quoteId) {
            this.quoteId = quoteId;
            return this;
        }

        /**
         * The {@code subscription_id} property.
         *
         * @param subscriptionId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = JsonField.ofNullable(subscriptionId);
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
         * The {@code QuoteEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public QuoteEventData build() {
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(quoteId, "quote_id");
            return new QuoteEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code QuoteEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static QuoteEventData fromJson(String json) {
        return Utils.parse(json, QuoteEventData.class);
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
