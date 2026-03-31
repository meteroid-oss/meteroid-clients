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
public class CreateConnectedAccountRequest {
    @JsonProperty("connected_organization_id")
    private String connectedOrganizationId;

    @JsonProperty("connection_type")
    private ConnectionType connectionType;

    @JsonProperty private Object metadata;

    @JsonProperty("platform_customer_id")
    private String platformCustomerId;

    public CreateConnectedAccountRequest() {}

    public CreateConnectedAccountRequest connectedOrganizationId(String connectedOrganizationId) {
        this.connectedOrganizationId = connectedOrganizationId;
        return this;
    }

    /**
     * Get connectedOrganizationId
     *
     * @return connectedOrganizationId
     */
    @javax.annotation.Nonnull
    public String getConnectedOrganizationId() {
        return connectedOrganizationId;
    }

    public void setConnectedOrganizationId(String connectedOrganizationId) {
        this.connectedOrganizationId = connectedOrganizationId;
    }

    public CreateConnectedAccountRequest connectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
        return this;
    }

    /**
     * Get connectionType
     *
     * @return connectionType
     */
    @javax.annotation.Nullable
    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public CreateConnectedAccountRequest metadata(Object metadata) {
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

    public CreateConnectedAccountRequest platformCustomerId(String platformCustomerId) {
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

    /**
     * Create an instance of CreateConnectedAccountRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateConnectedAccountRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateConnectedAccountRequest
     */
    public static CreateConnectedAccountRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateConnectedAccountRequest.class);
    }

    /**
     * Convert an instance of CreateConnectedAccountRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
