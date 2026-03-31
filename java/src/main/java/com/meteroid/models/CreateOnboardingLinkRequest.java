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
public class CreateOnboardingLinkRequest {
    @JsonProperty("redirect_url")
    private String redirectUrl;

    public CreateOnboardingLinkRequest() {}

    public CreateOnboardingLinkRequest redirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    /**
     * Get redirectUrl
     *
     * @return redirectUrl
     */
    @javax.annotation.Nonnull
    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    /**
     * Create an instance of CreateOnboardingLinkRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateOnboardingLinkRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateOnboardingLinkRequest
     */
    public static CreateOnboardingLinkRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateOnboardingLinkRequest.class);
    }

    /**
     * Convert an instance of CreateOnboardingLinkRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
