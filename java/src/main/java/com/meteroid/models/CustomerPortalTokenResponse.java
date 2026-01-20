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
public class CustomerPortalTokenResponse {
    @JsonProperty("portal_url")
    private String portalUrl;

    @JsonProperty private String token;

    public CustomerPortalTokenResponse() {}

    public CustomerPortalTokenResponse portalUrl(String portalUrl) {
        this.portalUrl = portalUrl;
        return this;
    }

    /**
     * Base URL of the customer portal
     *
     * @return portalUrl
     */
    @javax.annotation.Nonnull
    public String getPortalUrl() {
        return portalUrl;
    }

    public void setPortalUrl(String portalUrl) {
        this.portalUrl = portalUrl;
    }

    public CustomerPortalTokenResponse token(String token) {
        this.token = token;
        return this;
    }

    /**
     * JWT token for portal access
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

    /**
     * Create an instance of CustomerPortalTokenResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CustomerPortalTokenResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CustomerPortalTokenResponse
     */
    public static CustomerPortalTokenResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CustomerPortalTokenResponse.class);
    }

    /**
     * Convert an instance of CustomerPortalTokenResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
