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
public class OAuthAppWithSecret {
    @JsonProperty private OAuthApp app;

    @JsonProperty("client_secret")
    private String clientSecret;

    public OAuthAppWithSecret() {}

    public OAuthAppWithSecret app(OAuthApp app) {
        this.app = app;
        return this;
    }

    /**
     * Get app
     *
     * @return app
     */
    @javax.annotation.Nonnull
    public OAuthApp getApp() {
        return app;
    }

    public void setApp(OAuthApp app) {
        this.app = app;
    }

    public OAuthAppWithSecret clientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    /**
     * Get clientSecret
     *
     * @return clientSecret
     */
    @javax.annotation.Nonnull
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * Create an instance of OAuthAppWithSecret given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OAuthAppWithSecret
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     OAuthAppWithSecret
     */
    public static OAuthAppWithSecret fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OAuthAppWithSecret.class);
    }

    /**
     * Convert an instance of OAuthAppWithSecret to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
