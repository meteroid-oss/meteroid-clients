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
public class RevocationRequest {
    @JsonProperty private String token;

    @JsonProperty("token_type_hint")
    private String tokenTypeHint;

    public RevocationRequest() {}

    public RevocationRequest token(String token) {
        this.token = token;
        return this;
    }

    /**
     * The token to revoke
     *
     * @return token
     */
    @javax.annotation.Nonnull
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RevocationRequest tokenTypeHint(String tokenTypeHint) {
        this.tokenTypeHint = tokenTypeHint;
        return this;
    }

    /**
     * Optional hint about the token type (access_token or refresh_token)
     *
     * @return tokenTypeHint
     */
    @javax.annotation.Nullable
    public String getTokenTypeHint() {
        return tokenTypeHint;
    }

    public void setTokenTypeHint(String tokenTypeHint) {
        this.tokenTypeHint = tokenTypeHint;
    }

    /**
     * Create an instance of RevocationRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RevocationRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     RevocationRequest
     */
    public static RevocationRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, RevocationRequest.class);
    }

    /**
     * Convert an instance of RevocationRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
