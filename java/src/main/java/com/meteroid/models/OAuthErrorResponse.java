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

/**
 * OAuth 2.0 error response as per RFC 6749 Section 5.2
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class OAuthErrorResponse {
    @JsonProperty("error")
    private OAuthErrorCode error;

    @JsonProperty("error_description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> errorDescription = JsonField.missing();

    @JsonProperty("error_uri")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> errorUri = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private OAuthErrorResponse() {}

    private OAuthErrorResponse(Builder builder) {
        this.error = builder.error;
        this.errorDescription = builder.errorDescription;
        this.errorUri = builder.errorUri;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code OAuthErrorResponse}.
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
        builder.error = error;
        builder.errorDescription = errorDescription;
        builder.errorUri = errorUri;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code error} property.
     *
     * @return the value, never null
     */
    public OAuthErrorCode error() {
        return Utils.required(error, "error");
    }

    /**
     * The {@code error_description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> errorDescription() {
        return errorDescription.asOptional();
    }

    /**
     * The {@code error_uri} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> errorUri() {
        return errorUri.asOptional();
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
        OAuthErrorResponse that = (OAuthErrorResponse) o;
        return Objects.equals(error, that.error)
                && Objects.equals(errorDescription, that.errorDescription)
                && Objects.equals(errorUri, that.errorUri)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, errorDescription, errorUri, additionalProperties);
    }

    @Override
    public String toString() {
        return "OAuthErrorResponse{"
                + "error="
                + error
                + ", errorDescription="
                + errorDescription
                + ", errorUri="
                + errorUri
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link OAuthErrorResponse}. */
    public static final class Builder {
        private OAuthErrorCode error;
        private JsonField<String> errorDescription = JsonField.missing();
        private JsonField<String> errorUri = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code error} property.
         *
         * @param error the value
         * @return this builder
         */
        public Builder error(OAuthErrorCode error) {
            this.error = error;
            return this;
        }

        /**
         * The {@code error_description} property.
         *
         * @param errorDescription the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder errorDescription(String errorDescription) {
            this.errorDescription = JsonField.ofNullable(errorDescription);
            return this;
        }

        /**
         * The {@code error_uri} property.
         *
         * @param errorUri the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder errorUri(String errorUri) {
            this.errorUri = JsonField.ofNullable(errorUri);
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
         * The {@code OAuthErrorResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public OAuthErrorResponse build() {
            Utils.checkRequired(error, "error");
            return new OAuthErrorResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code OAuthErrorResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static OAuthErrorResponse fromJson(String json) {
        return Utils.parse(json, OAuthErrorResponse.class);
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
