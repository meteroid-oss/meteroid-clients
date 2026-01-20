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
public class CreateCheckoutSessionResponse {
    @JsonProperty private CheckoutSession session;

    public CreateCheckoutSessionResponse() {}

    public CreateCheckoutSessionResponse session(CheckoutSession session) {
        this.session = session;
        return this;
    }

    /**
     * Get session
     *
     * @return session
     */
    @javax.annotation.Nonnull
    public CheckoutSession getSession() {
        return session;
    }

    public void setSession(CheckoutSession session) {
        this.session = session;
    }

    /**
     * Create an instance of CreateCheckoutSessionResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateCheckoutSessionResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateCheckoutSessionResponse
     */
    public static CreateCheckoutSessionResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateCheckoutSessionResponse.class);
    }

    /**
     * Convert an instance of CreateCheckoutSessionResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
