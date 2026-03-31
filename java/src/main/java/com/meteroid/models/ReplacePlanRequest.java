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
public class ReplacePlanRequest {
    @JsonProperty("add_ons")
    private List<PlanAddOnInput> addOns;

    @JsonProperty private BillingConfig billing;
    @JsonProperty private List<PriceComponentInput> components;
    @JsonProperty private String currency;
    @JsonProperty private String description;
    @JsonProperty private String name;
    @JsonProperty private PlanStatusEnum status;
    @JsonProperty private TrialConfig trial;

    public ReplacePlanRequest() {}

    public ReplacePlanRequest addOns(List<PlanAddOnInput> addOns) {
        this.addOns = addOns;
        return this;
    }

    public ReplacePlanRequest addAddOnsItem(PlanAddOnInput addOnsItem) {
        if (this.addOns == null) {
            this.addOns = new ArrayList<>();
        }
        this.addOns.add(addOnsItem);

        return this;
    }

    /**
     * Get addOns
     *
     * @return addOns
     */
    @javax.annotation.Nullable
    public List<PlanAddOnInput> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<PlanAddOnInput> addOns) {
        this.addOns = addOns;
    }

    public ReplacePlanRequest billing(BillingConfig billing) {
        this.billing = billing;
        return this;
    }

    /**
     * Get billing
     *
     * @return billing
     */
    @javax.annotation.Nullable
    public BillingConfig getBilling() {
        return billing;
    }

    public void setBilling(BillingConfig billing) {
        this.billing = billing;
    }

    public ReplacePlanRequest components(List<PriceComponentInput> components) {
        this.components = components;
        return this;
    }

    public ReplacePlanRequest addComponentsItem(PriceComponentInput componentsItem) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
        this.components.add(componentsItem);

        return this;
    }

    /**
     * Get components
     *
     * @return components
     */
    @javax.annotation.Nonnull
    public List<PriceComponentInput> getComponents() {
        return components;
    }

    public void setComponents(List<PriceComponentInput> components) {
        this.components = components;
    }

    public ReplacePlanRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @javax.annotation.Nonnull
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ReplacePlanRequest description(String description) {
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

    public ReplacePlanRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReplacePlanRequest status(PlanStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nullable
    public PlanStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PlanStatusEnum status) {
        this.status = status;
    }

    public ReplacePlanRequest trial(TrialConfig trial) {
        this.trial = trial;
        return this;
    }

    /**
     * Get trial
     *
     * @return trial
     */
    @javax.annotation.Nullable
    public TrialConfig getTrial() {
        return trial;
    }

    public void setTrial(TrialConfig trial) {
        this.trial = trial;
    }

    /**
     * Create an instance of ReplacePlanRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ReplacePlanRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ReplacePlanRequest
     */
    public static ReplacePlanRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ReplacePlanRequest.class);
    }

    /**
     * Convert an instance of ReplacePlanRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
