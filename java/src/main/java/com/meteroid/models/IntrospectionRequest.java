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
public class IntrospectionRequest {
    @JsonProperty private String token;

    public IntrospectionRequest() {}

    public IntrospectionRequest token(String token) {
        this.token = token;
        return this;
    }

    /**
     * The token to introspect
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
     * Create an instance of IntrospectionRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IntrospectionRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     IntrospectionRequest
     */
    public static IntrospectionRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, IntrospectionRequest.class);
    }

    /**
     * Convert an instance of IntrospectionRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
