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
public class CustomerPortalTokenRequest {
    @JsonProperty("expires_in_seconds")
    private Integer expiresInSeconds;

    public CustomerPortalTokenRequest() {}

    public CustomerPortalTokenRequest expiresInSeconds(Integer expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
        return this;
    }

    /**
     * Token lifetime in seconds. Defaults to 86400 (24 hours). Must be between 60 and 2592000 (30
     * days).
     *
     * @return expiresInSeconds
     */
    @javax.annotation.Nullable
    public Integer getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public void setExpiresInSeconds(Integer expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }

    /**
     * Create an instance of CustomerPortalTokenRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CustomerPortalTokenRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CustomerPortalTokenRequest
     */
    public static CustomerPortalTokenRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CustomerPortalTokenRequest.class);
    }

    /**
     * Convert an instance of CustomerPortalTokenRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
