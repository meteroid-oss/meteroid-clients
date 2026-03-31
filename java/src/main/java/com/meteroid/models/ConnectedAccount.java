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

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ConnectedAccount {
    @JsonProperty("connected_organization_id")
    private String connectedOrganizationId;

    @JsonProperty("connected_tenant_id")
    private String connectedTenantId;

    @JsonProperty("connection_type")
    private ConnectionType connectionType;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String id;
    @JsonProperty private Object metadata;

    @JsonProperty("onboarding_completed_at")
    private OffsetDateTime onboardingCompletedAt;

    @JsonProperty("onboarding_mode")
    private OnboardingMode onboardingMode;

    @JsonProperty("pending_country")
    private String pendingCountry;

    @JsonProperty("pending_email")
    private String pendingEmail;

    @JsonProperty("pending_organization_name")
    private String pendingOrganizationName;

    @JsonProperty("platform_customer_id")
    private String platformCustomerId;

    @JsonProperty("platform_organization_id")
    private String platformOrganizationId;

    @JsonProperty("revoked_at")
    private OffsetDateTime revokedAt;

    @JsonProperty private ConnectionStatus status;

    public ConnectedAccount() {}

    public ConnectedAccount connectedOrganizationId(String connectedOrganizationId) {
        this.connectedOrganizationId = connectedOrganizationId;
        return this;
    }

    /**
     * Get connectedOrganizationId
     *
     * @return connectedOrganizationId
     */
    @javax.annotation.Nullable
    public String getConnectedOrganizationId() {
        return connectedOrganizationId;
    }

    public void setConnectedOrganizationId(String connectedOrganizationId) {
        this.connectedOrganizationId = connectedOrganizationId;
    }

    public ConnectedAccount connectedTenantId(String connectedTenantId) {
        this.connectedTenantId = connectedTenantId;
        return this;
    }

    /**
     * Get connectedTenantId
     *
     * @return connectedTenantId
     */
    @javax.annotation.Nullable
    public String getConnectedTenantId() {
        return connectedTenantId;
    }

    public void setConnectedTenantId(String connectedTenantId) {
        this.connectedTenantId = connectedTenantId;
    }

    public ConnectedAccount connectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
        return this;
    }

    /**
     * Get connectionType
     *
     * @return connectionType
     */
    @javax.annotation.Nonnull
    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public ConnectedAccount createdAt(OffsetDateTime createdAt) {
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

    public ConnectedAccount id(String id) {
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

    public ConnectedAccount metadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     *
     * @return metadata
     */
    @javax.annotation.Nullable
    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public ConnectedAccount onboardingCompletedAt(OffsetDateTime onboardingCompletedAt) {
        this.onboardingCompletedAt = onboardingCompletedAt;
        return this;
    }

    /**
     * Get onboardingCompletedAt
     *
     * @return onboardingCompletedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getOnboardingCompletedAt() {
        return onboardingCompletedAt;
    }

    public void setOnboardingCompletedAt(OffsetDateTime onboardingCompletedAt) {
        this.onboardingCompletedAt = onboardingCompletedAt;
    }

    public ConnectedAccount onboardingMode(OnboardingMode onboardingMode) {
        this.onboardingMode = onboardingMode;
        return this;
    }

    /**
     * Get onboardingMode
     *
     * @return onboardingMode
     */
    @javax.annotation.Nonnull
    public OnboardingMode getOnboardingMode() {
        return onboardingMode;
    }

    public void setOnboardingMode(OnboardingMode onboardingMode) {
        this.onboardingMode = onboardingMode;
    }

    public ConnectedAccount pendingCountry(String pendingCountry) {
        this.pendingCountry = pendingCountry;
        return this;
    }

    /**
     * Get pendingCountry
     *
     * @return pendingCountry
     */
    @javax.annotation.Nullable
    public String getPendingCountry() {
        return pendingCountry;
    }

    public void setPendingCountry(String pendingCountry) {
        this.pendingCountry = pendingCountry;
    }

    public ConnectedAccount pendingEmail(String pendingEmail) {
        this.pendingEmail = pendingEmail;
        return this;
    }

    /**
     * Email of the user being invited (express flow only)
     *
     * @return pendingEmail
     */
    @javax.annotation.Nullable
    public String getPendingEmail() {
        return pendingEmail;
    }

    public void setPendingEmail(String pendingEmail) {
        this.pendingEmail = pendingEmail;
    }

    public ConnectedAccount pendingOrganizationName(String pendingOrganizationName) {
        this.pendingOrganizationName = pendingOrganizationName;
        return this;
    }

    /**
     * Name of the organization to be created (express flow only)
     *
     * @return pendingOrganizationName
     */
    @javax.annotation.Nullable
    public String getPendingOrganizationName() {
        return pendingOrganizationName;
    }

    public void setPendingOrganizationName(String pendingOrganizationName) {
        this.pendingOrganizationName = pendingOrganizationName;
    }

    public ConnectedAccount platformCustomerId(String platformCustomerId) {
        this.platformCustomerId = platformCustomerId;
        return this;
    }

    /**
     * Get platformCustomerId
     *
     * @return platformCustomerId
     */
    @javax.annotation.Nullable
    public String getPlatformCustomerId() {
        return platformCustomerId;
    }

    public void setPlatformCustomerId(String platformCustomerId) {
        this.platformCustomerId = platformCustomerId;
    }

    public ConnectedAccount platformOrganizationId(String platformOrganizationId) {
        this.platformOrganizationId = platformOrganizationId;
        return this;
    }

    /**
     * Get platformOrganizationId
     *
     * @return platformOrganizationId
     */
    @javax.annotation.Nonnull
    public String getPlatformOrganizationId() {
        return platformOrganizationId;
    }

    public void setPlatformOrganizationId(String platformOrganizationId) {
        this.platformOrganizationId = platformOrganizationId;
    }

    public ConnectedAccount revokedAt(OffsetDateTime revokedAt) {
        this.revokedAt = revokedAt;
        return this;
    }

    /**
     * Get revokedAt
     *
     * @return revokedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getRevokedAt() {
        return revokedAt;
    }

    public void setRevokedAt(OffsetDateTime revokedAt) {
        this.revokedAt = revokedAt;
    }

    public ConnectedAccount status(ConnectionStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public ConnectionStatus getStatus() {
        return status;
    }

    public void setStatus(ConnectionStatus status) {
        this.status = status;
    }

    /**
     * Create an instance of ConnectedAccount given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConnectedAccount
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ConnectedAccount
     */
    public static ConnectedAccount fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ConnectedAccount.class);
    }

    /**
     * Convert an instance of ConnectedAccount to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
