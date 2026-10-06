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

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Result of creating an onboarding link
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class OnboardingLinkResponse {
    @JsonProperty("expires_at")
    private OffsetDateTime expiresAt;

    @JsonProperty("url")
    private String url;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private OnboardingLinkResponse() {}

    private OnboardingLinkResponse(Builder builder) {
        this.expiresAt = builder.expiresAt;
        this.url = builder.url;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code OnboardingLinkResponse}.
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
        builder.expiresAt = expiresAt;
        builder.url = url;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code expires_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime expiresAt() {
        return Utils.required(expiresAt, "expires_at");
    }

    /**
     * The {@code url} property.
     *
     * @return the value, never null
     */
    public String url() {
        return Utils.required(url, "url");
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
        OnboardingLinkResponse that = (OnboardingLinkResponse) o;
        return Objects.equals(expiresAt, that.expiresAt)
                && Objects.equals(url, that.url)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expiresAt, url, additionalProperties);
    }

    @Override
    public String toString() {
        return "OnboardingLinkResponse{"
                + "expiresAt="
                + expiresAt
                + ", url="
                + url
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link OnboardingLinkResponse}. */
    public static final class Builder {
        private OffsetDateTime expiresAt;
        private String url;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code expires_at} property.
         *
         * @param expiresAt the value
         * @return this builder
         */
        public Builder expiresAt(OffsetDateTime expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }

        /**
         * The {@code url} property.
         *
         * @param url the value
         * @return this builder
         */
        public Builder url(String url) {
            this.url = url;
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
         * The {@code OnboardingLinkResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public OnboardingLinkResponse build() {
            Utils.checkRequired(expiresAt, "expires_at");
            Utils.checkRequired(url, "url");
            return new OnboardingLinkResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code OnboardingLinkResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static OnboardingLinkResponse fromJson(String json) {
        return Utils.parse(json, OnboardingLinkResponse.class);
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
