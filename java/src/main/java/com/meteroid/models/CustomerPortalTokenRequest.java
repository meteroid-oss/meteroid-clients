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
public final class CustomerPortalTokenRequest {
    @JsonProperty("expires_in_seconds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> expiresInSeconds = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CustomerPortalTokenRequest() {}

    private CustomerPortalTokenRequest(Builder builder) {
        this.expiresInSeconds = builder.expiresInSeconds;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CustomerPortalTokenRequest}.
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
        builder.expiresInSeconds = expiresInSeconds;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Token lifetime in seconds. Defaults to 86400 (24 hours). Must be between 60 and 2592000 (30
     * days).
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> expiresInSeconds() {
        return expiresInSeconds.asOptional();
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
        CustomerPortalTokenRequest that = (CustomerPortalTokenRequest) o;
        return Objects.equals(expiresInSeconds, that.expiresInSeconds)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expiresInSeconds, additionalProperties);
    }

    @Override
    public String toString() {
        return "CustomerPortalTokenRequest{"
                + "expiresInSeconds="
                + expiresInSeconds
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CustomerPortalTokenRequest}. */
    public static final class Builder {
        private JsonField<Integer> expiresInSeconds = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Token lifetime in seconds. Defaults to 86400 (24 hours). Must be between 60 and 2592000
         * (30 days).
         *
         * @param expiresInSeconds the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder expiresInSeconds(Integer expiresInSeconds) {
            this.expiresInSeconds = JsonField.ofNullable(expiresInSeconds);
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
         * The {@code CustomerPortalTokenRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CustomerPortalTokenRequest build() {
            return new CustomerPortalTokenRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CustomerPortalTokenRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CustomerPortalTokenRequest fromJson(String json) {
        return Utils.parse(json, CustomerPortalTokenRequest.class);
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
