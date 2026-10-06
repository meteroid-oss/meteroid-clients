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
 * Token response as per OAuth 2.0 spec
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class TokenResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Long expiresIn;

    @JsonProperty("refresh_token")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> refreshToken = JsonField.missing();

    @JsonProperty("scope")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> scope = JsonField.missing();

    @JsonProperty("token_type")
    private String tokenType;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TokenResponse() {}

    private TokenResponse(Builder builder) {
        this.accessToken = builder.accessToken;
        this.expiresIn = builder.expiresIn;
        this.refreshToken = builder.refreshToken;
        this.scope = builder.scope;
        this.tokenType = builder.tokenType;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TokenResponse}.
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
        builder.accessToken = accessToken;
        builder.expiresIn = expiresIn;
        builder.refreshToken = refreshToken;
        builder.scope = scope;
        builder.tokenType = tokenType;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code access_token} property.
     *
     * @return the value, never null
     */
    public String accessToken() {
        return Utils.required(accessToken, "access_token");
    }

    /**
     * The {@code expires_in} property.
     *
     * @return the value, never null
     */
    public Long expiresIn() {
        return Utils.required(expiresIn, "expires_in");
    }

    /**
     * The {@code refresh_token} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> refreshToken() {
        return refreshToken.asOptional();
    }

    /**
     * The {@code scope} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> scope() {
        return scope.asOptional();
    }

    /**
     * The {@code token_type} property.
     *
     * @return the value, never null
     */
    public String tokenType() {
        return Utils.required(tokenType, "token_type");
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
        TokenResponse that = (TokenResponse) o;
        return Objects.equals(accessToken, that.accessToken)
                && Objects.equals(expiresIn, that.expiresIn)
                && Objects.equals(refreshToken, that.refreshToken)
                && Objects.equals(scope, that.scope)
                && Objects.equals(tokenType, that.tokenType)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                accessToken, expiresIn, refreshToken, scope, tokenType, additionalProperties);
    }

    @Override
    public String toString() {
        return "TokenResponse{"
                + "accessToken="
                + accessToken
                + ", expiresIn="
                + expiresIn
                + ", refreshToken="
                + refreshToken
                + ", scope="
                + scope
                + ", tokenType="
                + tokenType
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TokenResponse}. */
    public static final class Builder {
        private String accessToken;
        private Long expiresIn;
        private JsonField<String> refreshToken = JsonField.missing();
        private JsonField<String> scope = JsonField.missing();
        private String tokenType;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code access_token} property.
         *
         * @param accessToken the value
         * @return this builder
         */
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        /**
         * The {@code expires_in} property.
         *
         * @param expiresIn the value
         * @return this builder
         */
        public Builder expiresIn(Long expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        /**
         * The {@code refresh_token} property.
         *
         * @param refreshToken the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder refreshToken(String refreshToken) {
            this.refreshToken = JsonField.ofNullable(refreshToken);
            return this;
        }

        /**
         * The {@code scope} property.
         *
         * @param scope the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder scope(String scope) {
            this.scope = JsonField.ofNullable(scope);
            return this;
        }

        /**
         * The {@code token_type} property.
         *
         * @param tokenType the value
         * @return this builder
         */
        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
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
         * The {@code TokenResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TokenResponse build() {
            Utils.checkRequired(accessToken, "access_token");
            Utils.checkRequired(expiresIn, "expires_in");
            Utils.checkRequired(tokenType, "token_type");
            return new TokenResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code TokenResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TokenResponse fromJson(String json) {
        return Utils.parse(json, TokenResponse.class);
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
