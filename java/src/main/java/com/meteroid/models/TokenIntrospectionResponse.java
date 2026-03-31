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
public class TokenIntrospectionResponse {
    @JsonProperty private Boolean active;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty private Long exp;
    @JsonProperty private Long iat;
    @JsonProperty private String scope;
    @JsonProperty private String sub;

    @JsonProperty("token_type")
    private String tokenType;

    public TokenIntrospectionResponse() {}

    public TokenIntrospectionResponse active(Boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Get active
     *
     * @return active
     */
    @javax.annotation.Nonnull
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public TokenIntrospectionResponse clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Get clientId
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

    public TokenIntrospectionResponse exp(Long exp) {
        this.exp = exp;
        return this;
    }

    /**
     * Get exp
     *
     * @return exp
     */
    @javax.annotation.Nullable
    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public TokenIntrospectionResponse iat(Long iat) {
        this.iat = iat;
        return this;
    }

    /**
     * Get iat
     *
     * @return iat
     */
    @javax.annotation.Nullable
    public Long getIat() {
        return iat;
    }

    public void setIat(Long iat) {
        this.iat = iat;
    }

    public TokenIntrospectionResponse scope(String scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     */
    @javax.annotation.Nullable
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public TokenIntrospectionResponse sub(String sub) {
        this.sub = sub;
        return this;
    }

    /**
     * Get sub
     *
     * @return sub
     */
    @javax.annotation.Nullable
    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public TokenIntrospectionResponse tokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    /**
     * Get tokenType
     *
     * @return tokenType
     */
    @javax.annotation.Nullable
    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * Create an instance of TokenIntrospectionResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TokenIntrospectionResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     TokenIntrospectionResponse
     */
    public static TokenIntrospectionResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, TokenIntrospectionResponse.class);
    }

    /**
     * Convert an instance of TokenIntrospectionResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
