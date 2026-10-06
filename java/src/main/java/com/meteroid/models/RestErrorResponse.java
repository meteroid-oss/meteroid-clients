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

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class RestErrorResponse {
    @JsonProperty("code")
    private ErrorCode code;

    @JsonProperty("message")
    private String message;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private RestErrorResponse() {}

    private RestErrorResponse(Builder builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code RestErrorResponse}.
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
        builder.message = message;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code code} property.
     *
     * @return the value, never null
     */
    public ErrorCode code() {
        return Utils.required(code, "code");
    }

    /**
     * The {@code message} property.
     *
     * @return the value, never null
     */
    public String message() {
        return Utils.required(message, "message");
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
        RestErrorResponse that = (RestErrorResponse) o;
        return Objects.equals(code, that.code)
                && Objects.equals(message, that.message)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, additionalProperties);
    }

    @Override
    public String toString() {
        return "RestErrorResponse{"
                + "code="
                + code
                + ", message="
                + message
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link RestErrorResponse}. */
    public static final class Builder {
        private ErrorCode code;
        private String message;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code code} property.
         *
         * @param code the value
         * @return this builder
         */
        public Builder code(ErrorCode code) {
            this.code = code;
            return this;
        }

        /**
         * The {@code message} property.
         *
         * @param message the value
         * @return this builder
         */
        public Builder message(String message) {
            this.message = message;
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
         * The {@code RestErrorResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public RestErrorResponse build() {
            Utils.checkRequired(code, "code");
            Utils.checkRequired(message, "message");
            return new RestErrorResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code RestErrorResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static RestErrorResponse fromJson(String json) {
        return Utils.parse(json, RestErrorResponse.class);
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
