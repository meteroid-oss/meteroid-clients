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
public class EffectiveEntitlementListResponse {
    @JsonProperty private List<EffectiveEntitlement> data;

    public EffectiveEntitlementListResponse() {}

    public EffectiveEntitlementListResponse data(List<EffectiveEntitlement> data) {
        this.data = data;
        return this;
    }

    public EffectiveEntitlementListResponse addDataItem(EffectiveEntitlement dataItem) {
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
    public List<EffectiveEntitlement> getData() {
        return data;
    }

    public void setData(List<EffectiveEntitlement> data) {
        this.data = data;
    }

    /**
     * Create an instance of EffectiveEntitlementListResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of EffectiveEntitlementListResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     EffectiveEntitlementListResponse
     */
    public static EffectiveEntitlementListResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper()
                .readValue(jsonString, EffectiveEntitlementListResponse.class);
    }

    /**
     * Convert an instance of EffectiveEntitlementListResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
