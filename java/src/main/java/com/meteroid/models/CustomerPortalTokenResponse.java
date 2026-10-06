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
public final class CustomerPortalTokenResponse {
    @JsonProperty("portal_url")
    private String portalUrl;

    @JsonProperty("token")
    private String token;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CustomerPortalTokenResponse() {}

    private CustomerPortalTokenResponse(Builder builder) {
        this.portalUrl = builder.portalUrl;
        this.token = builder.token;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CustomerPortalTokenResponse}.
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
        builder.portalUrl = portalUrl;
        builder.token = token;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Base URL of the customer portal
     *
     * @return the value, never null
     */
    public String portalUrl() {
        return Utils.required(portalUrl, "portal_url");
    }

    /**
     * JWT token for portal access
     *
     * @return the value, never null
     */
    public String token() {
        return Utils.required(token, "token");
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
        CustomerPortalTokenResponse that = (CustomerPortalTokenResponse) o;
        return Objects.equals(portalUrl, that.portalUrl)
                && Objects.equals(token, that.token)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portalUrl, token, additionalProperties);
    }

    @Override
    public String toString() {
        return "CustomerPortalTokenResponse{"
                + "portalUrl="
                + portalUrl
                + ", token="
                + token
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CustomerPortalTokenResponse}. */
    public static final class Builder {
        private String portalUrl;
        private String token;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Base URL of the customer portal
         *
         * @param portalUrl the value
         * @return this builder
         */
        public Builder portalUrl(String portalUrl) {
            this.portalUrl = portalUrl;
            return this;
        }

        /**
         * JWT token for portal access
         *
         * @param token the value
         * @return this builder
         */
        public Builder token(String token) {
            this.token = token;
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
         * The {@code CustomerPortalTokenResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CustomerPortalTokenResponse build() {
            Utils.checkRequired(portalUrl, "portal_url");
            Utils.checkRequired(token, "token");
            return new CustomerPortalTokenResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code CustomerPortalTokenResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CustomerPortalTokenResponse fromJson(String json) {
        return Utils.parse(json, CustomerPortalTokenResponse.class);
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
