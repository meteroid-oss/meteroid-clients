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
public class CouponLineItem {
    @JsonProperty("coupon_id")
    private String couponId;

    @JsonProperty private String name;
    @JsonProperty private Long total;

    public CouponLineItem() {}

    public CouponLineItem couponId(String couponId) {
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

    public CouponLineItem name(String name) {
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

    public CouponLineItem total(Long total) {
        this.total = total;
        return this;
    }

    /**
     * Get total
     *
     * @return total
     */
    @javax.annotation.Nonnull
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * Create an instance of CouponLineItem given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CouponLineItem
     * @throws JsonProcessingException if the JSON string is invalid with respect to CouponLineItem
     */
    public static CouponLineItem fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CouponLineItem.class);
    }

    /**
     * Convert an instance of CouponLineItem to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
