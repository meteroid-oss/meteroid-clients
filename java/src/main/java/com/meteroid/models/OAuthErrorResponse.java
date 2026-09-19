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
public class OAuthErrorResponse {
    @JsonProperty private OAuthErrorCode error;

    @JsonProperty("error_description")
    private String errorDescription;

    @JsonProperty("error_uri")
    private String errorUri;

    public OAuthErrorResponse() {}

    public OAuthErrorResponse error(OAuthErrorCode error) {
        this.error = error;
        return this;
    }

    /**
     * Get error
     *
     * @return error
     */
    @javax.annotation.Nonnull
    public OAuthErrorCode getError() {
        return error;
    }

    public void setError(OAuthErrorCode error) {
        this.error = error;
    }

    public OAuthErrorResponse errorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }

    /**
     * Get errorDescription
     *
     * @return errorDescription
     */
    @javax.annotation.Nullable
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public OAuthErrorResponse errorUri(String errorUri) {
        this.errorUri = errorUri;
        return this;
    }

    /**
     * Get errorUri
     *
     * @return errorUri
     */
    @javax.annotation.Nullable
    public String getErrorUri() {
        return errorUri;
    }

    public void setErrorUri(String errorUri) {
        this.errorUri = errorUri;
    }

    /**
     * Create an instance of OAuthErrorResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OAuthErrorResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     OAuthErrorResponse
     */
    public static OAuthErrorResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OAuthErrorResponse.class);
    }

    /**
     * Convert an instance of OAuthErrorResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
