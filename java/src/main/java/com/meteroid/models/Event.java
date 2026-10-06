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
public final class Event {
    @JsonProperty("code")
    private String code;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("properties")
    private Map<String, String> properties;

    @JsonProperty("timestamp")
    private String timestamp;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Event() {}

    private Event(Builder builder) {
        this.code = builder.code;
        this.customerId = builder.customerId;
        this.eventId = builder.eventId;
        this.properties = Utils.copyMap(builder.properties);
        this.timestamp = builder.timestamp;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Event}.
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
        builder.code = code;
        builder.customerId = customerId;
        builder.eventId = eventId;
        builder.properties = Utils.mutableMap(properties);
        builder.timestamp = timestamp;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Billable metric code. Max 512 characters.
     *
     * @return the value, never null
     */
    public String code() {
        return Utils.required(code, "code");
    }

    /**
     * Meteroid customer ID or external customer alias.
     *
     * @return the value, never null
     */
    public String customerId() {
        return Utils.required(customerId, "customer_id");
    }

    /**
     * Unique event identifier. Max 255 characters. A UUID or ULID is recommended.
     *
     * @return the value, never null
     */
    public String eventId() {
        return Utils.required(eventId, "event_id");
    }

    /**
     * Arbitrary string key-value pairs used by billable metrics for filtering and aggregation.
     *
     * @return the value, empty when unset
     */
    public Optional<Map<String, String>> properties() {
        return Optional.ofNullable(properties);
    }

    /**
     * RFC 3339 timestamp. Defaults to ingestion time if omitted. Must be between 24 hours ago and 1
     * hour from now. Set <code>allow_backfilling</code> to remove the past limit.
     *
     * @return the value, never null
     */
    public String timestamp() {
        return Utils.required(timestamp, "timestamp");
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
        Event that = (Event) o;
        return Objects.equals(code, that.code)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(eventId, that.eventId)
                && Objects.equals(properties, that.properties)
                && Objects.equals(timestamp, that.timestamp)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, customerId, eventId, properties, timestamp, additionalProperties);
    }

    @Override
    public String toString() {
        return "Event{"
                + "code="
                + code
                + ", customerId="
                + customerId
                + ", eventId="
                + eventId
                + ", properties="
                + properties
                + ", timestamp="
                + timestamp
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Event}. */
    public static final class Builder {
        private String code;
        private String customerId;
        private String eventId;
        private Map<String, String> properties;
        private String timestamp;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Billable metric code. Max 512 characters.
         *
         * @param code the value
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Meteroid customer ID or external customer alias.
         *
         * @param customerId the value
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Unique event identifier. Max 255 characters. A UUID or ULID is recommended.
         *
         * @param eventId the value
         * @return this builder
         */
        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        /**
         * Arbitrary string key-value pairs used by billable metrics for filtering and aggregation.
         *
         * @param properties the value
         * @return this builder
         */
        public Builder properties(Map<String, String> properties) {
            this.properties = Utils.mutableMap(properties);
            return this;
        }

        /**
         * Puts an entry in {@code properties}.
         *
         * @param key the key
         * @param item the item
         * @return this builder
         */
        public Builder putPropertiesItem(String key, String item) {
            if (this.properties == null) {
                this.properties = new LinkedHashMap<>();
            }
            this.properties.put(key, item);
            return this;
        }

        /**
         * RFC 3339 timestamp. Defaults to ingestion time if omitted. Must be between 24 hours ago
         * and 1 hour from now. Set <code>allow_backfilling</code> to remove the past limit.
         *
         * @param timestamp the value
         * @return this builder
         */
        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
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
         * The {@code Event}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Event build() {
            Utils.checkRequired(code, "code");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(eventId, "event_id");
            Utils.checkRequired(timestamp, "timestamp");
            return new Event(this);
        }
    }

    /**
     * Parse {@code json} as {@code Event}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Event fromJson(String json) {
        return Utils.parse(json, Event.class);
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
