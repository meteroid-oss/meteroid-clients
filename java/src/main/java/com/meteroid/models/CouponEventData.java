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
public class CouponEventData {
    @JsonProperty private String code;

    @JsonProperty("coupon_id")
    private String couponId;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;
    @JsonProperty private Boolean disabled;
    @JsonProperty private CouponDiscountRest discount;

    @JsonProperty("expires_at")
    private OffsetDateTime expiresAt;

    @JsonProperty("recurring_value")
    private Integer recurringValue;

    @JsonProperty("redemption_limit")
    private Integer redemptionLimit;

    @JsonProperty private Boolean reusable;

    public CouponEventData() {}

    public CouponEventData code(String code) {
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

    public CouponEventData couponId(String couponId) {
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

    public CouponEventData createdAt(OffsetDateTime createdAt) {
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

    public CouponEventData description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @javax.annotation.Nonnull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CouponEventData disabled(Boolean disabled) {
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

    public CouponEventData discount(CouponDiscountRest discount) {
        this.discount = discount;
        return this;
    }

    /**
     * Get discount
     *
     * @return discount
     */
    @javax.annotation.Nonnull
    public CouponDiscountRest getDiscount() {
        return discount;
    }

    public void setDiscount(CouponDiscountRest discount) {
        this.discount = discount;
    }

    public CouponEventData expiresAt(OffsetDateTime expiresAt) {
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

    public CouponEventData recurringValue(Integer recurringValue) {
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

    public CouponEventData redemptionLimit(Integer redemptionLimit) {
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

    public CouponEventData reusable(Boolean reusable) {
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
     * Create an instance of CouponEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CouponEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to CouponEventData
     */
    public static CouponEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CouponEventData.class);
    }

    /**
     * Convert an instance of CouponEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
