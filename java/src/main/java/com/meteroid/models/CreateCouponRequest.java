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
public class CreateCouponRequest {
    @JsonProperty private String code;
    @JsonProperty private String description;
    @JsonProperty private CouponDiscount discount;

    @JsonProperty("expires_at")
    private OffsetDateTime expiresAt;

    @JsonProperty("plan_ids")
    private List<String> planIds;

    @JsonProperty("recurring_value")
    private Integer recurringValue;

    @JsonProperty("redemption_limit")
    private Integer redemptionLimit;

    @JsonProperty private Boolean reusable;

    public CreateCouponRequest() {}

    public CreateCouponRequest code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     */
    @javax.annotation.Nonnull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CreateCouponRequest description(String description) {
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

    public CreateCouponRequest discount(CouponDiscount discount) {
        this.discount = discount;
        return this;
    }

    /**
     * Get discount
     *
     * @return discount
     */
    @javax.annotation.Nonnull
    public CouponDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(CouponDiscount discount) {
        this.discount = discount;
    }

    public CreateCouponRequest expiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * Get expiresAt
     *
     * @return expiresAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CreateCouponRequest planIds(List<String> planIds) {
        this.planIds = planIds;
        return this;
    }

    public CreateCouponRequest addPlanIdsItem(String planIdsItem) {
        if (this.planIds == null) {
            this.planIds = new ArrayList<>();
        }
        this.planIds.add(planIdsItem);

        return this;
    }

    /**
     * Get planIds
     *
     * @return planIds
     */
    @javax.annotation.Nullable
    public List<String> getPlanIds() {
        return planIds;
    }

    public void setPlanIds(List<String> planIds) {
        this.planIds = planIds;
    }

    public CreateCouponRequest recurringValue(Integer recurringValue) {
        this.recurringValue = recurringValue;
        return this;
    }

    /**
     * Get recurringValue
     *
     * @return recurringValue
     */
    @javax.annotation.Nullable
    public Integer getRecurringValue() {
        return recurringValue;
    }

    public void setRecurringValue(Integer recurringValue) {
        this.recurringValue = recurringValue;
    }

    public CreateCouponRequest redemptionLimit(Integer redemptionLimit) {
        this.redemptionLimit = redemptionLimit;
        return this;
    }

    /**
     * Get redemptionLimit
     *
     * @return redemptionLimit
     */
    @javax.annotation.Nullable
    public Integer getRedemptionLimit() {
        return redemptionLimit;
    }

    public void setRedemptionLimit(Integer redemptionLimit) {
        this.redemptionLimit = redemptionLimit;
    }

    public CreateCouponRequest reusable(Boolean reusable) {
        this.reusable = reusable;
        return this;
    }

    /**
     * Get reusable
     *
     * @return reusable
     */
    @javax.annotation.Nullable
    public Boolean getReusable() {
        return reusable;
    }

    public void setReusable(Boolean reusable) {
        this.reusable = reusable;
    }

    /**
     * Create an instance of CreateCouponRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreateCouponRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreateCouponRequest
     */
    public static CreateCouponRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CreateCouponRequest.class);
    }

    /**
     * Convert an instance of CreateCouponRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
