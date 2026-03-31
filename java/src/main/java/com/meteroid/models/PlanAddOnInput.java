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
public class PlanAddOnInput {
    @JsonProperty("add_on_id")
    private String addOnId;

    @JsonProperty("max_instances")
    private Integer maxInstances;

    @JsonProperty("price_id")
    private String priceId;

    @JsonProperty("self_serviceable")
    private Boolean selfServiceable;

    public PlanAddOnInput() {}

    public PlanAddOnInput addOnId(String addOnId) {
        this.addOnId = addOnId;
        return this;
    }

    /**
     * Get addOnId
     *
     * @return addOnId
     */
    @javax.annotation.Nonnull
    public String getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(String addOnId) {
        this.addOnId = addOnId;
    }

    public PlanAddOnInput maxInstances(Integer maxInstances) {
        this.maxInstances = maxInstances;
        return this;
    }

    /**
     * Get maxInstances
     *
     * @return maxInstances
     */
    @javax.annotation.Nullable
    public Integer getMaxInstances() {
        return maxInstances;
    }

    public void setMaxInstances(Integer maxInstances) {
        this.maxInstances = maxInstances;
    }

    public PlanAddOnInput priceId(String priceId) {
        this.priceId = priceId;
        return this;
    }

    /**
     * Get priceId
     *
     * @return priceId
     */
    @javax.annotation.Nullable
    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public PlanAddOnInput selfServiceable(Boolean selfServiceable) {
        this.selfServiceable = selfServiceable;
        return this;
    }

    /**
     * Get selfServiceable
     *
     * @return selfServiceable
     */
    @javax.annotation.Nullable
    public Boolean getSelfServiceable() {
        return selfServiceable;
    }

    public void setSelfServiceable(Boolean selfServiceable) {
        this.selfServiceable = selfServiceable;
    }

    /**
     * Create an instance of PlanAddOnInput given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PlanAddOnInput
     * @throws JsonProcessingException if the JSON string is invalid with respect to PlanAddOnInput
     */
    public static PlanAddOnInput fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PlanAddOnInput.class);
    }

    /**
     * Convert an instance of PlanAddOnInput to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
