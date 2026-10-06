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
public final class IngestEventsResponse {
    @JsonProperty("failures")
    private List<IngestFailure> failures;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private IngestEventsResponse() {}

    private IngestEventsResponse(Builder builder) {
        this.failures = Utils.copyList(builder.failures);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code IngestEventsResponse}.
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
        builder.failures = Utils.mutableList(failures);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Events that failed to ingest. Omitted when no failures.
     *
     * @return the value, empty when unset
     */
    public Optional<List<IngestFailure>> failures() {
        return Optional.ofNullable(failures);
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
        IngestEventsResponse that = (IngestEventsResponse) o;
        return Objects.equals(failures, that.failures)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(failures, additionalProperties);
    }

    @Override
    public String toString() {
        return "IngestEventsResponse{"
                + "failures="
                + failures
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link IngestEventsResponse}. */
    public static final class Builder {
        private List<IngestFailure> failures;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Events that failed to ingest. Omitted when no failures.
         *
         * @param failures the value
         * @return this builder
         */
        public Builder failures(List<IngestFailure> failures) {
            this.failures = Utils.mutableList(failures);
            return this;
        }

        /**
         * Adds an item to {@code failures}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addFailuresItem(IngestFailure item) {
            if (this.failures == null) {
                this.failures = new ArrayList<>();
            }
            this.failures.add(item);
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
         * The {@code IngestEventsResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public IngestEventsResponse build() {
            return new IngestEventsResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code IngestEventsResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static IngestEventsResponse fromJson(String json) {
        return Utils.parse(json, IngestEventsResponse.class);
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
