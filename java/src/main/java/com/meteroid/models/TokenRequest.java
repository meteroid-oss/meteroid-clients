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
 * Token request (from POST body, application/x-www-form-urlencoded)
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class TokenRequest {
    @JsonProperty("client_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> clientId = JsonField.missing();

    @JsonProperty("client_secret")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> clientSecret = JsonField.missing();

    @JsonProperty("code")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> code = JsonField.missing();

    @JsonProperty("code_verifier")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> codeVerifier = JsonField.missing();

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("redirect_uri")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> redirectUri = JsonField.missing();

    @JsonProperty("refresh_token")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> refreshToken = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TokenRequest() {}

    private TokenRequest(Builder builder) {
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.code = builder.code;
        this.codeVerifier = builder.codeVerifier;
        this.grantType = builder.grantType;
        this.redirectUri = builder.redirectUri;
        this.refreshToken = builder.refreshToken;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TokenRequest}.
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
        builder.clientId = clientId;
        builder.clientSecret = clientSecret;
        builder.code = code;
        builder.codeVerifier = codeVerifier;
        builder.grantType = grantType;
        builder.redirectUri = redirectUri;
        builder.refreshToken = refreshToken;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Client ID (if not using HTTP Basic auth)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> clientId() {
        return clientId.asOptional();
    }

    /**
     * Client secret (if not using HTTP Basic auth)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> clientSecret() {
        return clientSecret.asOptional();
    }

    /**
     * Authorization code (for authorization_code grant)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> code() {
        return code.asOptional();
    }

    /**
     * PKCE code verifier (for authorization_code grant with PKCE)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> codeVerifier() {
        return codeVerifier.asOptional();
    }

    /**
     * Grant type: "authorization_code" or "refresh_token"
     *
     * @return the value, never null
     */
    public String grantType() {
        return Utils.required(grantType, "grant_type");
    }

    /**
     * Redirect URI (for authorization_code grant, must match the one used in /authorize)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> redirectUri() {
        return redirectUri.asOptional();
    }

    /**
     * Refresh token (for refresh_token grant)
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> refreshToken() {
        return refreshToken.asOptional();
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
        TokenRequest that = (TokenRequest) o;
        return Objects.equals(clientId, that.clientId)
                && Objects.equals(clientSecret, that.clientSecret)
                && Objects.equals(code, that.code)
                && Objects.equals(codeVerifier, that.codeVerifier)
                && Objects.equals(grantType, that.grantType)
                && Objects.equals(redirectUri, that.redirectUri)
                && Objects.equals(refreshToken, that.refreshToken)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                clientId,
                clientSecret,
                code,
                codeVerifier,
                grantType,
                redirectUri,
                refreshToken,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "TokenRequest{"
                + "clientId="
                + clientId
                + ", clientSecret="
                + clientSecret
                + ", code="
                + code
                + ", codeVerifier="
                + codeVerifier
                + ", grantType="
                + grantType
                + ", redirectUri="
                + redirectUri
                + ", refreshToken="
                + refreshToken
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TokenRequest}. */
    public static final class Builder {
        private JsonField<String> clientId = JsonField.missing();
        private JsonField<String> clientSecret = JsonField.missing();
        private JsonField<String> code = JsonField.missing();
        private JsonField<String> codeVerifier = JsonField.missing();
        private String grantType;
        private JsonField<String> redirectUri = JsonField.missing();
        private JsonField<String> refreshToken = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Client ID (if not using HTTP Basic auth)
         *
         * @param clientId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder clientId(String clientId) {
            this.clientId = JsonField.ofNullable(clientId);
            return this;
        }

        /**
         * Client secret (if not using HTTP Basic auth)
         *
         * @param clientSecret the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder clientSecret(String clientSecret) {
            this.clientSecret = JsonField.ofNullable(clientSecret);
            return this;
        }

        /**
         * Authorization code (for authorization_code grant)
         *
         * @param code the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder code(String code) {
            this.code = JsonField.ofNullable(code);
            return this;
        }

        /**
         * PKCE code verifier (for authorization_code grant with PKCE)
         *
         * @param codeVerifier the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder codeVerifier(String codeVerifier) {
            this.codeVerifier = JsonField.ofNullable(codeVerifier);
            return this;
        }

        /**
         * Grant type: "authorization_code" or "refresh_token"
         *
         * @param grantType the value
         * @return this builder
         */
        public Builder grantType(String grantType) {
            this.grantType = grantType;
            return this;
        }

        /**
         * Redirect URI (for authorization_code grant, must match the one used in /authorize)
         *
         * @param redirectUri the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder redirectUri(String redirectUri) {
            this.redirectUri = JsonField.ofNullable(redirectUri);
            return this;
        }

        /**
         * Refresh token (for refresh_token grant)
         *
         * @param refreshToken the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder refreshToken(String refreshToken) {
            this.refreshToken = JsonField.ofNullable(refreshToken);
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
         * The {@code TokenRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TokenRequest build() {
            Utils.checkRequired(grantType, "grant_type");
            return new TokenRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code TokenRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TokenRequest fromJson(String json) {
        return Utils.parse(json, TokenRequest.class);
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
