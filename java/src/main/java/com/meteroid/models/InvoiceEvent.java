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
import com.meteroid.internal.Unions;
import com.meteroid.internal.Utils;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class InvoiceEvent {
    @JsonProperty("id")
    private String id;

    @JsonProperty("timestamp")
    private OffsetDateTime timestamp;

    @JsonProperty("type")
    private EventType type;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private InvoiceEvent() {}

    private InvoiceEvent(Builder builder) {
        this.id = builder.id;
        this.timestamp = builder.timestamp;
        this.type = builder.type;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code InvoiceEvent}.
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
        builder.id = id;
        builder.timestamp = timestamp;
        builder.type = type;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The properties of {@link InvoiceEventData}, which this schema extends.
     *
     * @return the properties of this part
     */
    public InvoiceEventData invoiceEventData() {
        return Unions.convert(additionalProperties, InvoiceEventData.class);
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code timestamp} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime timestamp() {
        return Utils.required(timestamp, "timestamp");
    }

    /**
     * The {@code type} property.
     *
     * @return the value, never null
     */
    public EventType type() {
        return Utils.required(type, "type");
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        Map<String, JsonNode> unknown = new LinkedHashMap<>(additionalProperties);
        unknown.keySet().retainAll(invoiceEventData().additionalProperties().keySet());
        return Collections.unmodifiableMap(unknown);
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
        InvoiceEvent that = (InvoiceEvent) o;
        return Objects.equals(id, that.id)
                && Objects.equals(timestamp, that.timestamp)
                && Objects.equals(type, that.type)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, type, additionalProperties);
    }

    @Override
    public String toString() {
        return "InvoiceEvent{"
                + "id="
                + id
                + ", timestamp="
                + timestamp
                + ", type="
                + type
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link InvoiceEvent}. */
    public static final class Builder {
        private String id;
        private OffsetDateTime timestamp;
        private EventType type;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Sets the properties of {@link InvoiceEventData}, which this schema extends.
         *
         * @param invoiceEventData the properties
         * @return this builder
         */
        public Builder invoiceEventData(InvoiceEventData invoiceEventData) {
            additionalProperties.putAll(Utils.properties(invoiceEventData));
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
         * The {@code timestamp} property.
         *
         * @param timestamp the value
         * @return this builder
         */
        public Builder timestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * The {@code type} property.
         *
         * @param type the value
         * @return this builder
         */
        public Builder type(EventType type) {
            this.type = type;
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
         * The {@code InvoiceEvent}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public InvoiceEvent build() {
            Utils.checkRequired(id, "id");
            Utils.checkRequired(timestamp, "timestamp");
            Utils.checkRequired(type, "type");
            return new InvoiceEvent(this);
        }
    }

    /**
     * Parse {@code json} as {@code InvoiceEvent}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static InvoiceEvent fromJson(String json) {
        return Utils.parse(json, InvoiceEvent.class);
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
