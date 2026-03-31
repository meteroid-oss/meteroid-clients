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

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CreateOAuthAppRequest {
    @JsonProperty private String name;

    @JsonProperty("redirect_uris")
    private List<String> redirectUris;

    @JsonProperty private List<String> scopes;

    public CreateOAuthAppRequest() {}

    public CreateOAuthAppRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateOAuthAppRequest redirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
        return this;
    }

    public CreateOAuthAppRequest addRedirectUrisItem(String redirectUrisItem) {
        if (this.redirectUris == null) {
            this.redirectUris = new ArrayList<>();
        }
        this.redirectUris.add(redirectUrisItem);

        return this;
    }

    /**
     * Get redirectUris
     *
     * @return redirectUris
     */
    @javax.annotation.Nonnull
    public List<String> getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
    }

    public CreateOAuthAppRequest scopes(List<String> scopes) {
        this.scopes = scopes;
        return this;
    }

    public CreateOAuthAppRequest addScopesItem(String scopesItem) {
        if (this.scopes == null) {
            this.scopes = new ArrayList<>();
        }
        this.scopes.add(scopesItem);

        return this;
    }

    /**
     * Get scopes
     *
     * @return scopes
     */
    @javax.annotation.Nullable
    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    /**
     * Create an instance of CreateOAuthAppRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateOAuthAppRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateOAuthAppRequest
     */
    public static CreateOAuthAppRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateOAuthAppRequest.class);
    }

    /**
     * Convert an instance of CreateOAuthAppRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
