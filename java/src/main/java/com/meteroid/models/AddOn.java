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
public class AddOn {
    @JsonProperty("archived_at")
    private OffsetDateTime archivedAt;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;

    @JsonProperty("fee_type")
    private ProductFeeTypeEnum feeType;

    @JsonProperty private String id;

    @JsonProperty("max_instances_per_subscription")
    private Integer maxInstancesPerSubscription;

    @JsonProperty private String name;

    @JsonProperty("price_id")
    private String priceId;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("self_serviceable")
    private Boolean selfServiceable;

    public AddOn() {}

    public AddOn archivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
        return this;
    }

    /**
     * Get archivedAt
     *
     * @return archivedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }

    public AddOn createdAt(OffsetDateTime createdAt) {
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

    public AddOn description(String description) {
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

    public AddOn feeType(ProductFeeTypeEnum feeType) {
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

    public AddOn id(String id) {
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

    public AddOn maxInstancesPerSubscription(Integer maxInstancesPerSubscription) {
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

    public AddOn name(String name) {
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

    public AddOn priceId(String priceId) {
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

    public AddOn productId(String productId) {
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

    public AddOn selfServiceable(Boolean selfServiceable) {
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
     * Create an instance of AddOn given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AddOn
     * @throws JsonProcessingException if the JSON string is invalid with respect to AddOn
     */
    public static AddOn fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, AddOn.class);
    }

    /**
     * Convert an instance of AddOn to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
