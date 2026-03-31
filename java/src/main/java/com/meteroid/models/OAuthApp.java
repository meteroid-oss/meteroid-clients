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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class OAuthApp {
    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("client_secret_hint")
    private String clientSecretHint;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String id;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty private String name;

    @JsonProperty("organization_id")
    private String organizationId;

    @JsonProperty("redirect_uris")
    private List<String> redirectUris;

    @JsonProperty private List<String> scopes;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    public OAuthApp() {}

    public OAuthApp clientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Get clientId
     *
     * @return clientId
     */
    @javax.annotation.Nonnull
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public OAuthApp clientSecretHint(String clientSecretHint) {
        this.clientSecretHint = clientSecretHint;
        return this;
    }

    /**
     * Get clientSecretHint
     *
     * @return clientSecretHint
     */
    @javax.annotation.Nonnull
    public String getClientSecretHint() {
        return clientSecretHint;
    }

    public void setClientSecretHint(String clientSecretHint) {
        this.clientSecretHint = clientSecretHint;
    }

    public OAuthApp createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OAuthApp id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OAuthApp isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    /**
     * Get isActive
     *
     * @return isActive
     */
    @javax.annotation.Nonnull
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OAuthApp name(String name) {
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

    public OAuthApp organizationId(String organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    /**
     * Get organizationId
     *
     * @return organizationId
     */
    @javax.annotation.Nonnull
    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public OAuthApp redirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
        return this;
    }

    public OAuthApp addRedirectUrisItem(String redirectUrisItem) {
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

    public OAuthApp scopes(List<String> scopes) {
        this.scopes = scopes;
        return this;
    }

    public OAuthApp addScopesItem(String scopesItem) {
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
    @javax.annotation.Nonnull
    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public OAuthApp updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Create an instance of OAuthApp given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OAuthApp
     * @throws JsonProcessingException if the JSON string is invalid with respect to OAuthApp
     */
    public static OAuthApp fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OAuthApp.class);
    }

    /**
     * Convert an instance of OAuthApp to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
