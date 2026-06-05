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
public class ResolvedEntitlementListResponse {
    @JsonProperty private List<ResolvedEntitlement> data;

    public ResolvedEntitlementListResponse() {}

    public ResolvedEntitlementListResponse data(List<ResolvedEntitlement> data) {
        this.data = data;
        return this;
    }

    public ResolvedEntitlementListResponse addDataItem(ResolvedEntitlement dataItem) {
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
    public List<ResolvedEntitlement> getData() {
        return data;
    }

    public void setData(List<ResolvedEntitlement> data) {
        this.data = data;
    }

    /**
     * Create an instance of ResolvedEntitlementListResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ResolvedEntitlementListResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ResolvedEntitlementListResponse
     */
    public static ResolvedEntitlementListResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ResolvedEntitlementListResponse.class);
    }

    /**
     * Convert an instance of ResolvedEntitlementListResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
