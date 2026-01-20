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
public class ListCheckoutSessionsResponse {
    @JsonProperty private List<CheckoutSession> sessions;

    public ListCheckoutSessionsResponse() {}

    public ListCheckoutSessionsResponse sessions(List<CheckoutSession> sessions) {
        this.sessions = sessions;
        return this;
    }

    public ListCheckoutSessionsResponse addSessionsItem(CheckoutSession sessionsItem) {
        if (this.sessions == null) {
            this.sessions = new ArrayList<>();
        }
        this.sessions.add(sessionsItem);

        return this;
    }

    /**
     * Get sessions
     *
     * @return sessions
     */
    @javax.annotation.Nonnull
    public List<CheckoutSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<CheckoutSession> sessions) {
        this.sessions = sessions;
    }

    /**
     * Create an instance of ListCheckoutSessionsResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ListCheckoutSessionsResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ListCheckoutSessionsResponse
     */
    public static ListCheckoutSessionsResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ListCheckoutSessionsResponse.class);
    }

    /**
     * Convert an instance of ListCheckoutSessionsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
