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
public class AppliedCoupon {
    @JsonProperty("applied_amount")
    private String appliedAmount;

    @JsonProperty("applied_count")
    private Integer appliedCount;

    @JsonProperty("coupon_id")
    private String couponId;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String id;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("last_applied_at")
    private OffsetDateTime lastAppliedAt;

    public AppliedCoupon() {}

    public AppliedCoupon appliedAmount(String appliedAmount) {
        this.appliedAmount = appliedAmount;
        return this;
    }

    /**
     * Get appliedAmount
     *
     * @return appliedAmount
     */
    @javax.annotation.Nullable
    public String getAppliedAmount() {
        return appliedAmount;
    }

    public void setAppliedAmount(String appliedAmount) {
        this.appliedAmount = appliedAmount;
    }

    public AppliedCoupon appliedCount(Integer appliedCount) {
        this.appliedCount = appliedCount;
        return this;
    }

    /**
     * Get appliedCount
     *
     * @return appliedCount
     */
    @javax.annotation.Nullable
    public Integer getAppliedCount() {
        return appliedCount;
    }

    public void setAppliedCount(Integer appliedCount) {
        this.appliedCount = appliedCount;
    }

    public AppliedCoupon couponId(String couponId) {
        this.couponId = couponId;
        return this;
    }

    /**
     * Get couponId
     *
     * @return couponId
     */
    @javax.annotation.Nonnull
    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public AppliedCoupon createdAt(OffsetDateTime createdAt) {
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

    public AppliedCoupon id(String id) {
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

    public AppliedCoupon isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    /**
     * Get isActive
     *
     * @return isActive
     */
    @javax.annotation.Nonnull
    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public AppliedCoupon lastAppliedAt(OffsetDateTime lastAppliedAt) {
        this.lastAppliedAt = lastAppliedAt;
        return this;
    }

    /**
     * Get lastAppliedAt
     *
     * @return lastAppliedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getLastAppliedAt() {
        return lastAppliedAt;
    }

    public void setLastAppliedAt(OffsetDateTime lastAppliedAt) {
        this.lastAppliedAt = lastAppliedAt;
    }

    /**
     * Create an instance of AppliedCoupon given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AppliedCoupon
     * @throws JsonProcessingException if the JSON string is invalid with respect to AppliedCoupon
     */
    public static AppliedCoupon fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, AppliedCoupon.class);
    }

    /**
     * Convert an instance of AppliedCoupon to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
