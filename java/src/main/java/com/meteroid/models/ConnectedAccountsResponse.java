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
public class ConnectedAccountsResponse {
    @JsonProperty private List<ConnectedAccount> data;

    public ConnectedAccountsResponse() {}

    public ConnectedAccountsResponse data(List<ConnectedAccount> data) {
        this.data = data;
        return this;
    }

    public ConnectedAccountsResponse addDataItem(ConnectedAccount dataItem) {
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
    public List<ConnectedAccount> getData() {
        return data;
    }

    public void setData(List<ConnectedAccount> data) {
        this.data = data;
    }

    /**
     * Create an instance of ConnectedAccountsResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConnectedAccountsResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ConnectedAccountsResponse
     */
    public static ConnectedAccountsResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ConnectedAccountsResponse.class);
    }

    /**
     * Convert an instance of ConnectedAccountsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
