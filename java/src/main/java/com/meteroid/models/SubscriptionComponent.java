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
public class SubscriptionComponent {
    @JsonProperty private SubscriptionFee fee;
    @JsonProperty private String name;
    @JsonProperty private SubscriptionFeeBillingPeriodEnum period;

    @JsonProperty("price_component_id")
    private String priceComponentId;

    @JsonProperty("product_id")
    private String productId;

    public SubscriptionComponent() {}

    public SubscriptionComponent fee(SubscriptionFee fee) {
        this.fee = fee;
        return this;
    }

    /**
     * Get fee
     *
     * @return fee
     */
    @javax.annotation.Nonnull
    public SubscriptionFee getFee() {
        return fee;
    }

    public void setFee(SubscriptionFee fee) {
        this.fee = fee;
    }

    public SubscriptionComponent name(String name) {
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

    public SubscriptionComponent period(SubscriptionFeeBillingPeriodEnum period) {
        this.period = period;
        return this;
    }

    /**
     * Get period
     *
     * @return period
     */
    @javax.annotation.Nonnull
    public SubscriptionFeeBillingPeriodEnum getPeriod() {
        return period;
    }

    public void setPeriod(SubscriptionFeeBillingPeriodEnum period) {
        this.period = period;
    }

    public SubscriptionComponent priceComponentId(String priceComponentId) {
        this.priceComponentId = priceComponentId;
        return this;
    }

    /**
     * Get priceComponentId
     *
     * @return priceComponentId
     */
    @javax.annotation.Nullable
    public String getPriceComponentId() {
        return priceComponentId;
    }

    public void setPriceComponentId(String priceComponentId) {
        this.priceComponentId = priceComponentId;
    }

    public SubscriptionComponent productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Get productId
     *
     * @return productId
     */
    @javax.annotation.Nullable
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Create an instance of SubscriptionComponent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionComponent
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SubscriptionComponent
     */
    public static SubscriptionComponent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionComponent.class);
    }

    /**
     * Convert an instance of SubscriptionComponent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
