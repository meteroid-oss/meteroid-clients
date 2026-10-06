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

/**
 * Result of creating an OAuth app (includes the plain-text secret)
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class OAuthAppWithSecret {
    @JsonProperty("app")
    private OAuthApp app;

    @JsonProperty("client_secret")
    private String clientSecret;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private OAuthAppWithSecret() {}

    private OAuthAppWithSecret(Builder builder) {
        this.app = builder.app;
        this.clientSecret = builder.clientSecret;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code OAuthAppWithSecret}.
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
        builder.app = app;
        builder.clientSecret = clientSecret;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code app} property.
     *
     * @return the value, never null
     */
    public OAuthApp app() {
        return Utils.required(app, "app");
    }

    /**
     * The {@code client_secret} property.
     *
     * @return the value, never null
     */
    public String clientSecret() {
        return Utils.required(clientSecret, "client_secret");
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
        OAuthAppWithSecret that = (OAuthAppWithSecret) o;
        return Objects.equals(app, that.app)
                && Objects.equals(clientSecret, that.clientSecret)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(app, clientSecret, additionalProperties);
    }

    @Override
    public String toString() {
        return "OAuthAppWithSecret{"
                + "app="
                + app
                + ", clientSecret="
                + clientSecret
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link OAuthAppWithSecret}. */
    public static final class Builder {
        private OAuthApp app;
        private String clientSecret;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code app} property.
         *
         * @param app the value
         * @return this builder
         */
        public Builder app(OAuthApp app) {
            this.app = app;
            return this;
        }

        /**
         * The {@code client_secret} property.
         *
         * @param clientSecret the value
         * @return this builder
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
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
         * The {@code OAuthAppWithSecret}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public OAuthAppWithSecret build() {
            Utils.checkRequired(app, "app");
            Utils.checkRequired(clientSecret, "client_secret");
            return new OAuthAppWithSecret(this);
        }
    }

    /**
     * Parse {@code json} as {@code OAuthAppWithSecret}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static OAuthAppWithSecret fromJson(String json) {
        return Utils.parse(json, OAuthAppWithSecret.class);
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
