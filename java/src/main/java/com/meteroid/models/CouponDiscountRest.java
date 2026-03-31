// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "discount_type",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CouponDiscountRest.Percentage.class, name = "PERCENTAGE"),
    @JsonSubTypes.Type(value = CouponDiscountRest.Fixed.class, name = "FIXED")
})
@ToString
@EqualsAndHashCode
public abstract class CouponDiscountRest {
    /** Get the discriminator value identifying this variant. */
    public abstract String getDiscountType();

    /**
     * Convert an instance of CouponDiscountRest to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of CouponDiscountRest from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of CouponDiscountRest
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static CouponDiscountRest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CouponDiscountRest.class);
    }

    // Variant classes
    /**
     * Variant: PERCENTAGE
     *
     * <p>This variant wraps CouponPercentageDiscount.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("PERCENTAGE")
    public static class Percentage extends CouponDiscountRest {
        @JsonUnwrapped private CouponPercentageDiscount data;

        public Percentage() {}

        public Percentage(CouponPercentageDiscount data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscountType() {
            return "PERCENTAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public CouponPercentageDiscount getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Percentage data(CouponPercentageDiscount data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: FIXED
     *
     * <p>This variant wraps CouponFixedDiscount.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("FIXED")
    public static class Fixed extends CouponDiscountRest {
        @JsonUnwrapped private CouponFixedDiscount data;

        public Fixed() {}

        public Fixed(CouponFixedDiscount data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscountType() {
            return "FIXED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public CouponFixedDiscount getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Fixed data(CouponFixedDiscount data) {
            this.data = data;
            return this;
        }
    }
}
