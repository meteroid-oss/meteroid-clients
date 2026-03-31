// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class TokenRequest {
    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty private String code;

    @JsonProperty("code_verifier")
    private String codeVerifier;

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("redirect_uri")
    private String redirectUri;

    @JsonProperty("refresh_token")
    private String refreshToken;

    public TokenRequest() {}

    public TokenRequest clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Client ID (if not using HTTP Basic auth)
     *
     * @return clientId
     */
    @javax.annotation.Nullable
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public TokenRequest clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    /**
     * Client secret (if not using HTTP Basic auth)
     *
     * @return clientSecret
     */
    @javax.annotation.Nullable
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public TokenRequest code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Authorization code (for authorization_code grant)
     *
     * @return code
     */
    @javax.annotation.Nullable
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TokenRequest codeVerifier(String codeVerifier) {
        this.codeVerifier = codeVerifier;
        return this;
    }

    /**
     * PKCE code verifier (for authorization_code grant with PKCE)
     *
     * @return codeVerifier
     */
    @javax.annotation.Nullable
    public String getCodeVerifier() {
        return codeVerifier;
    }

    public void setCodeVerifier(String codeVerifier) {
        this.codeVerifier = codeVerifier;
    }

    public TokenRequest grantType(String grantType) {
        this.grantType = grantType;
        return this;
    }

    /**
     * Grant type: &quot;authorization_code&quot; or &quot;refresh_token&quot;
     *
     * @return grantType
     */
    @javax.annotation.Nonnull
    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public TokenRequest redirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
        return this;
    }

    /**
     * Redirect URI (for authorization_code grant, must match the one used in &#x2f;authorize)
     *
     * @return redirectUri
     */
    @javax.annotation.Nullable
    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public TokenRequest refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    /**
     * Refresh token (for refresh_token grant)
     *
     * @return refreshToken
     */
    @javax.annotation.Nullable
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Create an instance of TokenRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TokenRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to TokenRequest
     */
    public static TokenRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, TokenRequest.class);
    }

    /**
     * Convert an instance of TokenRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
