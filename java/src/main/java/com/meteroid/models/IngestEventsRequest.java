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
public final class IngestEventsRequest {
    @JsonProperty("allow_backfilling")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> allowBackfilling = JsonField.missing();

    @JsonProperty("allow_partial_failures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> allowPartialFailures = JsonField.missing();

    @JsonProperty("events")
    private List<Event> events;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private IngestEventsRequest() {}

    private IngestEventsRequest(Builder builder) {
        this.allowBackfilling = builder.allowBackfilling;
        this.allowPartialFailures = builder.allowPartialFailures;
        this.events = Utils.copyList(builder.events);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code IngestEventsRequest}.
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
        builder.allowBackfilling = allowBackfilling;
        builder.allowPartialFailures = allowPartialFailures;
        builder.events = Utils.mutableList(events);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Allow events with timestamps more than 1 day in the past. Defaults to <code>false</code>.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> allowBackfilling() {
        return allowBackfilling.asOptional();
    }

    /**
     * Accept the batch even if some events fail validation. Defaults to <code>false</code>. When
     * <code>true</code>, valid events are ingested and failures are reported in the response body.
     * When <code>false</code> (default), any invalid event rejects the entire batch.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> allowPartialFailures() {
        return allowPartialFailures.asOptional();
    }

    /**
     * 1–100 events per request.
     *
     * @return the value, never null
     */
    public List<Event> events() {
        return Utils.required(events, "events");
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
        IngestEventsRequest that = (IngestEventsRequest) o;
        return Objects.equals(allowBackfilling, that.allowBackfilling)
                && Objects.equals(allowPartialFailures, that.allowPartialFailures)
                && Objects.equals(events, that.events)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowBackfilling, allowPartialFailures, events, additionalProperties);
    }

    @Override
    public String toString() {
        return "IngestEventsRequest{"
                + "allowBackfilling="
                + allowBackfilling
                + ", allowPartialFailures="
                + allowPartialFailures
                + ", events="
                + events
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link IngestEventsRequest}. */
    public static final class Builder {
        private JsonField<Boolean> allowBackfilling = JsonField.missing();
        private JsonField<Boolean> allowPartialFailures = JsonField.missing();
        private List<Event> events;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Allow events with timestamps more than 1 day in the past. Defaults to <code>false</code>.
         *
         * @param allowBackfilling the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder allowBackfilling(Boolean allowBackfilling) {
            this.allowBackfilling = JsonField.ofNullable(allowBackfilling);
            return this;
        }

        /**
         * Accept the batch even if some events fail validation. Defaults to <code>false</code>.
         * When <code>true</code>, valid events are ingested and failures are reported in the
         * response body. When <code>false</code> (default), any invalid event rejects the entire
         * batch.
         *
         * @param allowPartialFailures the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder allowPartialFailures(Boolean allowPartialFailures) {
            this.allowPartialFailures = JsonField.ofNullable(allowPartialFailures);
            return this;
        }

        /**
         * 1–100 events per request.
         *
         * @param events the value
         * @return this builder
         */
        public Builder events(List<Event> events) {
            this.events = Utils.mutableList(events);
            return this;
        }

        /**
         * Adds an item to {@code events}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addEventsItem(Event item) {
            if (this.events == null) {
                this.events = new ArrayList<>();
            }
            this.events.add(item);
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
         * The {@code IngestEventsRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public IngestEventsRequest build() {
            Utils.checkRequired(events, "events");
            return new IngestEventsRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code IngestEventsRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static IngestEventsRequest fromJson(String json) {
        return Utils.parse(json, IngestEventsRequest.class);
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
