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

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class AddOnEventData {
    @JsonProperty("add_on_id")
    private String addOnId;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;

    @JsonProperty("fee_type")
    private ProductFeeTypeEnum feeType;

    @JsonProperty("max_instances_per_subscription")
    private Integer maxInstancesPerSubscription;

    @JsonProperty private String name;

    @JsonProperty("price_id")
    private String priceId;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("self_serviceable")
    private Boolean selfServiceable;

    public AddOnEventData() {}

    public AddOnEventData addOnId(String addOnId) {
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

    public AddOnEventData createdAt(OffsetDateTime createdAt) {
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

    public AddOnEventData description(String description) {
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

    public AddOnEventData feeType(ProductFeeTypeEnum feeType) {
        this.feeType = feeType;
        return this;
    }

    /**
     * Get feeType
     *
     * @return feeType
     */
    @javax.annotation.Nullable
    public ProductFeeTypeEnum getFeeType() {
        return feeType;
    }

    public void setFeeType(ProductFeeTypeEnum feeType) {
        this.feeType = feeType;
    }

    public AddOnEventData maxInstancesPerSubscription(Integer maxInstancesPerSubscription) {
        this.maxInstancesPerSubscription = maxInstancesPerSubscription;
        return this;
    }

    /**
     * Get maxInstancesPerSubscription
     *
     * @return maxInstancesPerSubscription
     */
    @javax.annotation.Nullable
    public Integer getMaxInstancesPerSubscription() {
        return maxInstancesPerSubscription;
    }

    public void setMaxInstancesPerSubscription(Integer maxInstancesPerSubscription) {
        this.maxInstancesPerSubscription = maxInstancesPerSubscription;
    }

    public AddOnEventData name(String name) {
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

    public AddOnEventData priceId(String priceId) {
        this.priceId = priceId;
        return this;
    }

    /**
     * Get priceId
     *
     * @return priceId
     */
    @javax.annotation.Nonnull
    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public AddOnEventData productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Get productId
     *
     * @return productId
     */
    @javax.annotation.Nonnull
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public AddOnEventData selfServiceable(Boolean selfServiceable) {
        this.selfServiceable = selfServiceable;
        return this;
    }

    /**
     * Get selfServiceable
     *
     * @return selfServiceable
     */
    @javax.annotation.Nonnull
    public Boolean getSelfServiceable() {
        return selfServiceable;
    }

    public void setSelfServiceable(Boolean selfServiceable) {
        this.selfServiceable = selfServiceable;
    }

    /**
     * Create an instance of AddOnEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AddOnEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to AddOnEventData
     */
    public static AddOnEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, AddOnEventData.class);
    }

    /**
     * Convert an instance of AddOnEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
