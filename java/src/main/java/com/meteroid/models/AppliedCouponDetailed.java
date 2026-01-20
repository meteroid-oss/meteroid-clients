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
public class AppliedCouponDetailed {
    @JsonProperty("applied_coupon")
    private AppliedCoupon appliedCoupon;

    @JsonProperty private Coupon coupon;

    public AppliedCouponDetailed() {}

    public AppliedCouponDetailed appliedCoupon(AppliedCoupon appliedCoupon) {
        this.appliedCoupon = appliedCoupon;
        return this;
    }

    /**
     * Get appliedCoupon
     *
     * @return appliedCoupon
     */
    @javax.annotation.Nonnull
    public AppliedCoupon getAppliedCoupon() {
        return appliedCoupon;
    }

    public void setAppliedCoupon(AppliedCoupon appliedCoupon) {
        this.appliedCoupon = appliedCoupon;
    }

    public AppliedCouponDetailed coupon(Coupon coupon) {
        this.coupon = coupon;
        return this;
    }

    /**
     * Get coupon
     *
     * @return coupon
     */
    @javax.annotation.Nonnull
    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    /**
     * Create an instance of AppliedCouponDetailed given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AppliedCouponDetailed
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     AppliedCouponDetailed
     */
    public static AppliedCouponDetailed fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, AppliedCouponDetailed.class);
    }

    /**
     * Convert an instance of AppliedCouponDetailed to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
