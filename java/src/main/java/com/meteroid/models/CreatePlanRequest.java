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
public class CreatePlanRequest {
    @JsonProperty("add_ons")
    private List<PlanAddOnInput> addOns;

    @JsonProperty private BillingConfig billing;
    @JsonProperty private List<PriceComponentInput> components;
    @JsonProperty private String currency;
    @JsonProperty private String description;
    @JsonProperty private String name;

    @JsonProperty("plan_type")
    private PlanTypeEnum planType;

    @JsonProperty("product_family_id")
    private String productFamilyId;

    @JsonProperty("self_service_rank")
    private Integer selfServiceRank;

    @JsonProperty private PlanStatusEnum status;
    @JsonProperty private TrialConfig trial;

    public CreatePlanRequest() {}

    public CreatePlanRequest addOns(List<PlanAddOnInput> addOns) {
        this.addOns = addOns;
        return this;
    }

    public CreatePlanRequest addAddOnsItem(PlanAddOnInput addOnsItem) {
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

    public CreatePlanRequest billing(BillingConfig billing) {
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

    public CreatePlanRequest components(List<PriceComponentInput> components) {
        this.components = components;
        return this;
    }

    public CreatePlanRequest addComponentsItem(PriceComponentInput componentsItem) {
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

    public CreatePlanRequest currency(String currency) {
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

    public CreatePlanRequest description(String description) {
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

    public CreatePlanRequest name(String name) {
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

    public CreatePlanRequest planType(PlanTypeEnum planType) {
        this.planType = planType;
        return this;
    }

    /**
     * Get planType
     *
     * @return planType
     */
    @javax.annotation.Nonnull
    public PlanTypeEnum getPlanType() {
        return planType;
    }

    public void setPlanType(PlanTypeEnum planType) {
        this.planType = planType;
    }

    public CreatePlanRequest productFamilyId(String productFamilyId) {
        this.productFamilyId = productFamilyId;
        return this;
    }

    /**
     * Get productFamilyId
     *
     * @return productFamilyId
     */
    @javax.annotation.Nonnull
    public String getProductFamilyId() {
        return productFamilyId;
    }

    public void setProductFamilyId(String productFamilyId) {
        this.productFamilyId = productFamilyId;
    }

    public CreatePlanRequest selfServiceRank(Integer selfServiceRank) {
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

    public CreatePlanRequest status(PlanStatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public PlanStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PlanStatusEnum status) {
        this.status = status;
    }

    public CreatePlanRequest trial(TrialConfig trial) {
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
     * Create an instance of CreatePlanRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreatePlanRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreatePlanRequest
     */
    public static CreatePlanRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreatePlanRequest.class);
    }

    /**
     * Convert an instance of CreatePlanRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
