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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Plan {
    @JsonProperty("available_parameters")
    private AvailableParameters availableParameters;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String currency;
    @JsonProperty private String description;
    @JsonProperty private String id;
    @JsonProperty private String name;

    @JsonProperty("net_terms")
    private Integer netTerms;

    @JsonProperty("plan_type")
    private PlanTypeEnum planType;

    @JsonProperty("price_components")
    private List<PriceComponent> priceComponents;

    @JsonProperty("product_family")
    private ProductFamily productFamily;

    @JsonProperty private PlanStatusEnum status;
    @JsonProperty private TrialConfig trial;
    @JsonProperty private Integer version;

    @JsonProperty("version_id")
    private String versionId;

    public Plan() {}

    public Plan availableParameters(AvailableParameters availableParameters) {
        this.availableParameters = availableParameters;
        return this;
    }

    /**
     * Get availableParameters
     *
     * @return availableParameters
     */
    @javax.annotation.Nonnull
    public AvailableParameters getAvailableParameters() {
        return availableParameters;
    }

    public void setAvailableParameters(AvailableParameters availableParameters) {
        this.availableParameters = availableParameters;
    }

    public Plan createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Plan currency(String currency) {
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

    public Plan description(String description) {
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

    public Plan id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Plan name(String name) {
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

    public Plan netTerms(Integer netTerms) {
        this.netTerms = netTerms;
        return this;
    }

    /**
     * Get netTerms
     *
     * @return netTerms
     */
    @javax.annotation.Nonnull
    public Integer getNetTerms() {
        return netTerms;
    }

    public void setNetTerms(Integer netTerms) {
        this.netTerms = netTerms;
    }

    public Plan planType(PlanTypeEnum planType) {
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

    public Plan priceComponents(List<PriceComponent> priceComponents) {
        this.priceComponents = priceComponents;
        return this;
    }

    public Plan addPriceComponentsItem(PriceComponent priceComponentsItem) {
        if (this.priceComponents == null) {
            this.priceComponents = new ArrayList<>();
        }
        this.priceComponents.add(priceComponentsItem);

        return this;
    }

    /**
     * Get priceComponents
     *
     * @return priceComponents
     */
    @javax.annotation.Nonnull
    public List<PriceComponent> getPriceComponents() {
        return priceComponents;
    }

    public void setPriceComponents(List<PriceComponent> priceComponents) {
        this.priceComponents = priceComponents;
    }

    public Plan productFamily(ProductFamily productFamily) {
        this.productFamily = productFamily;
        return this;
    }

    /**
     * Get productFamily
     *
     * @return productFamily
     */
    @javax.annotation.Nonnull
    public ProductFamily getProductFamily() {
        return productFamily;
    }

    public void setProductFamily(ProductFamily productFamily) {
        this.productFamily = productFamily;
    }

    public Plan status(PlanStatusEnum status) {
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

    public Plan trial(TrialConfig trial) {
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

    public Plan version(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     *
     * @return version
     */
    @javax.annotation.Nonnull
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Plan versionId(String versionId) {
        this.versionId = versionId;
        return this;
    }

    /**
     * Get versionId
     *
     * @return versionId
     */
    @javax.annotation.Nonnull
    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    /**
     * Create an instance of Plan given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Plan
     * @throws JsonProcessingException if the JSON string is invalid with respect to Plan
     */
    public static Plan fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Plan.class);
    }

    /**
     * Convert an instance of Plan to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
