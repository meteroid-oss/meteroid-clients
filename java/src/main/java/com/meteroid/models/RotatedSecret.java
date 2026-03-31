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
public class RotatedSecret {
    @JsonProperty("client_secret")
    private String clientSecret;

    @JsonProperty("client_secret_hint")
    private String clientSecretHint;

    public RotatedSecret() {}

    public RotatedSecret clientSecret(String clientSecret) {
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

    public RotatedSecret clientSecretHint(String clientSecretHint) {
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

    /**
     * Create an instance of RotatedSecret given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RotatedSecret
     * @throws JsonProcessingException if the JSON string is invalid with respect to RotatedSecret
     */
    public static RotatedSecret fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, RotatedSecret.class);
    }

    /**
     * Convert an instance of RotatedSecret to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
