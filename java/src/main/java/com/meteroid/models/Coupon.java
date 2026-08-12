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
public class Coupon {
    @JsonProperty("archived_at")
    private OffsetDateTime archivedAt;

    @JsonProperty private String code;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;
    @JsonProperty private Boolean disabled;
    @JsonProperty private CouponDiscount discount;

    @JsonProperty("expires_at")
    private OffsetDateTime expiresAt;

    @JsonProperty private String id;

    @JsonProperty("plan_ids")
    private List<String> planIds;

    @JsonProperty("recurring_value")
    private Integer recurringValue;

    @JsonProperty("redemption_count")
    private Integer redemptionCount;

    @JsonProperty("redemption_limit")
    private Integer redemptionLimit;

    @JsonProperty private Boolean reusable;

    public Coupon() {}

    public Coupon archivedAt(OffsetDateTime archivedAt) {
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

    public Coupon code(String code) {
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

    public Coupon createdAt(OffsetDateTime createdAt) {
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

    public Coupon description(String description) {
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

    public Coupon disabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * Get disabled
     *
     * @return disabled
     */
    @javax.annotation.Nonnull
    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Coupon discount(CouponDiscount discount) {
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

    public Coupon expiresAt(OffsetDateTime expiresAt) {
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

    public Coupon id(String id) {
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

    public Coupon planIds(List<String> planIds) {
        this.planIds = planIds;
        return this;
    }

    public Coupon addPlanIdsItem(String planIdsItem) {
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
    @javax.annotation.Nonnull
    public List<String> getPlanIds() {
        return planIds;
    }

    public void setPlanIds(List<String> planIds) {
        this.planIds = planIds;
    }

    public Coupon recurringValue(Integer recurringValue) {
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

    public Coupon redemptionCount(Integer redemptionCount) {
        this.redemptionCount = redemptionCount;
        return this;
    }

    /**
     * Get redemptionCount
     *
     * @return redemptionCount
     */
    @javax.annotation.Nonnull
    public Integer getRedemptionCount() {
        return redemptionCount;
    }

    public void setRedemptionCount(Integer redemptionCount) {
        this.redemptionCount = redemptionCount;
    }

    public Coupon redemptionLimit(Integer redemptionLimit) {
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

    public Coupon reusable(Boolean reusable) {
        this.reusable = reusable;
        return this;
    }

    /**
     * Get reusable
     *
     * @return reusable
     */
    @javax.annotation.Nonnull
    public Boolean getReusable() {
        return reusable;
    }

    public void setReusable(Boolean reusable) {
        this.reusable = reusable;
    }

    /**
     * Create an instance of Coupon given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Coupon
     * @throws JsonProcessingException if the JSON string is invalid with respect to Coupon
     */
    public static Coupon fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Coupon.class);
    }

    /**
     * Convert an instance of Coupon to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
