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
 * Result of rotating a client secret
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class RotatedSecret {
    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("client_secret_hint")
    private String clientSecretHint;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private RotatedSecret() {}

    private RotatedSecret(Builder builder) {
        this.clientSecret = builder.clientSecret;
        this.clientSecretHint = builder.clientSecretHint;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code RotatedSecret}.
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
        builder.clientSecret = clientSecret;
        builder.clientSecretHint = clientSecretHint;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * The {@code client_secret_hint} property.
     *
     * @return the value, never null
     */
    public String clientSecretHint() {
        return Utils.required(clientSecretHint, "client_secret_hint");
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
        RotatedSecret that = (RotatedSecret) o;
        return Objects.equals(clientSecret, that.clientSecret)
                && Objects.equals(clientSecretHint, that.clientSecretHint)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientSecret, clientSecretHint, additionalProperties);
    }

    @Override
    public String toString() {
        return "RotatedSecret{"
                + "clientSecret="
                + clientSecret
                + ", clientSecretHint="
                + clientSecretHint
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link RotatedSecret}. */
    public static final class Builder {
        private String clientSecret;
        private String clientSecretHint;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * The {@code client_secret_hint} property.
         *
         * @param clientSecretHint the value
         * @return this builder
         */
        public Builder clientSecretHint(String clientSecretHint) {
            this.clientSecretHint = clientSecretHint;
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
         * The {@code RotatedSecret}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public RotatedSecret build() {
            Utils.checkRequired(clientSecret, "client_secret");
            Utils.checkRequired(clientSecretHint, "client_secret_hint");
            return new RotatedSecret(this);
        }
    }

    /**
     * Parse {@code json} as {@code RotatedSecret}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static RotatedSecret fromJson(String json) {
        return Utils.parse(json, RotatedSecret.class);
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
