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
public class PatchPlanRequest {
    @JsonProperty private String description;
    @JsonProperty private String name;

    @JsonProperty("self_service_rank")
    private Integer selfServiceRank;

    public PatchPlanRequest() {}

    public PatchPlanRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PatchPlanRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PatchPlanRequest selfServiceRank(Integer selfServiceRank) {
        this.selfServiceRank = selfServiceRank;
        return this;
    }

    /**
     * Get selfServiceRank
     *
     * @return selfServiceRank
     */
    @javax.annotation.Nullable
    public Integer getSelfServiceRank() {
        return selfServiceRank;
    }

    public void setSelfServiceRank(Integer selfServiceRank) {
        this.selfServiceRank = selfServiceRank;
    }

    /**
     * Create an instance of PatchPlanRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PatchPlanRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     PatchPlanRequest
     */
    public static PatchPlanRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PatchPlanRequest.class);
    }

    /**
     * Convert an instance of PatchPlanRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
