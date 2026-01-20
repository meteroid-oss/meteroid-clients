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
        property = "discriminator",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CouponDiscount.Percentage.class, name = "PERCENTAGE"),
    @JsonSubTypes.Type(value = CouponDiscount.Fixed.class, name = "FIXED")
})
@ToString
@EqualsAndHashCode
public abstract class CouponDiscount {
    /** Get the discriminator value identifying this variant. */
    public abstract String getDiscriminator();

    /**
     * Convert an instance of CouponDiscount to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of CouponDiscount from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of CouponDiscount
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static CouponDiscount fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CouponDiscount.class);
    }

    // Variant classes
    /**
     * Variant: PERCENTAGE
     *
     * <p>This variant wraps PercentageDiscount.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("PERCENTAGE")
    public static class Percentage extends CouponDiscount {
        @JsonUnwrapped private PercentageDiscount data;

        public Percentage() {}

        public Percentage(PercentageDiscount data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "PERCENTAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public PercentageDiscount getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Percentage data(PercentageDiscount data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: FIXED
     *
     * <p>This variant wraps FixedDiscount.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("FIXED")
    public static class Fixed extends CouponDiscount {
        @JsonUnwrapped private FixedDiscount data;

        public Fixed() {}

        public Fixed(FixedDiscount data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "FIXED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public FixedDiscount getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Fixed data(FixedDiscount data) {
            this.data = data;
            return this;
        }
    }
}
