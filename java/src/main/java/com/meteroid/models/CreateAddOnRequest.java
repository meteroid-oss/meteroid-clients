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
public class CreateAddOnRequest {
    @JsonProperty private String description;

    @JsonProperty("max_instances_per_subscription")
    private Integer maxInstancesPerSubscription;

    @JsonProperty private String name;

    @JsonProperty("price_id")
    private String priceId;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("self_serviceable")
    private Boolean selfServiceable;

    public CreateAddOnRequest() {}

    public CreateAddOnRequest description(String description) {
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

    public CreateAddOnRequest maxInstancesPerSubscription(Integer maxInstancesPerSubscription) {
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

    public CreateAddOnRequest name(String name) {
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

    public CreateAddOnRequest priceId(String priceId) {
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

    public CreateAddOnRequest productId(String productId) {
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

    public CreateAddOnRequest selfServiceable(Boolean selfServiceable) {
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
     * Create an instance of CreateAddOnRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateAddOnRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateAddOnRequest
     */
    public static CreateAddOnRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateAddOnRequest.class);
    }

    /**
     * Convert an instance of CreateAddOnRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
