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
public class OAuthAppsResponse {
    @JsonProperty private List<OAuthApp> data;

    public OAuthAppsResponse() {}

    public OAuthAppsResponse data(List<OAuthApp> data) {
        this.data = data;
        return this;
    }

    public OAuthAppsResponse addDataItem(OAuthApp dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);

        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @javax.annotation.Nonnull
    public List<OAuthApp> getData() {
        return data;
    }

    public void setData(List<OAuthApp> data) {
        this.data = data;
    }

    /**
     * Create an instance of OAuthAppsResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OAuthAppsResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     OAuthAppsResponse
     */
    public static OAuthAppsResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OAuthAppsResponse.class);
    }

    /**
     * Convert an instance of OAuthAppsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
