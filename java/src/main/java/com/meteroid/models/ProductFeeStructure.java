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
        property = "fee_type",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ProductFeeStructure.Rate.class, name = "RATE"),
    @JsonSubTypes.Type(value = ProductFeeStructure.Slot.class, name = "SLOT"),
    @JsonSubTypes.Type(value = ProductFeeStructure.Capacity.class, name = "CAPACITY"),
    @JsonSubTypes.Type(value = ProductFeeStructure.Usage.class, name = "USAGE"),
    @JsonSubTypes.Type(value = ProductFeeStructure.ExtraRecurring.class, name = "EXTRA_RECURRING"),
    @JsonSubTypes.Type(value = ProductFeeStructure.OneTime.class, name = "ONE_TIME")
})
@ToString
@EqualsAndHashCode
public abstract class ProductFeeStructure {
    /** Get the discriminator value identifying this variant. */
    public abstract String getFeeType();

    /**
     * Convert an instance of ProductFeeStructure to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of ProductFeeStructure from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of ProductFeeStructure
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static ProductFeeStructure fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ProductFeeStructure.class);
    }

    // Variant classes
    /**
     * Variant: RATE
     *
     * <p>This variant wraps RateFeeStructure.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("RATE")
    public static class Rate extends ProductFeeStructure {
        @JsonUnwrapped private RateFeeStructure data;

        public Rate() {}

        public Rate(RateFeeStructure data) {
            this.data = data;
        }

        @java.lang.Override
        public String getFeeType() {
            return "RATE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public RateFeeStructure getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Rate data(RateFeeStructure data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: SLOT
     *
     * <p>This variant wraps SlotFeeStructure.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("SLOT")
    public static class Slot extends ProductFeeStructure {
        @JsonUnwrapped private SlotFeeStructure data;

        public Slot() {}

        public Slot(SlotFeeStructure data) {
            this.data = data;
        }

        @java.lang.Override
        public String getFeeType() {
            return "SLOT";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public SlotFeeStructure getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Slot data(SlotFeeStructure data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: CAPACITY
     *
     * <p>This variant wraps CapacityFeeStructure.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("CAPACITY")
    public static class Capacity extends ProductFeeStructure {
        @JsonUnwrapped private CapacityFeeStructure data;

        public Capacity() {}

        public Capacity(CapacityFeeStructure data) {
            this.data = data;
        }

        @java.lang.Override
        public String getFeeType() {
            return "CAPACITY";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public CapacityFeeStructure getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Capacity data(CapacityFeeStructure data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: USAGE
     *
     * <p>This variant wraps UsageFeeStructure.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("USAGE")
    public static class Usage extends ProductFeeStructure {
        @JsonUnwrapped private UsageFeeStructure data;

        public Usage() {}

        public Usage(UsageFeeStructure data) {
            this.data = data;
        }

        @java.lang.Override
        public String getFeeType() {
            return "USAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public UsageFeeStructure getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Usage data(UsageFeeStructure data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: EXTRA_RECURRING
     *
     * <p>This variant wraps ExtraRecurringFeeStructure.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("EXTRA_RECURRING")
    public static class ExtraRecurring extends ProductFeeStructure {
        @JsonUnwrapped private ExtraRecurringFeeStructure data;

        public ExtraRecurring() {}

        public ExtraRecurring(ExtraRecurringFeeStructure data) {
            this.data = data;
        }

        @java.lang.Override
        public String getFeeType() {
            return "EXTRA_RECURRING";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ExtraRecurringFeeStructure getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public ExtraRecurring data(ExtraRecurringFeeStructure data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: ONE_TIME
     *
     * <p>This variant wraps OneTimeFeeStructure.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("ONE_TIME")
    public static class OneTime extends ProductFeeStructure {
        @JsonUnwrapped private OneTimeFeeStructure data;

        public OneTime() {}

        public OneTime(OneTimeFeeStructure data) {
            this.data = data;
        }

        @java.lang.Override
        public String getFeeType() {
            return "ONE_TIME";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public OneTimeFeeStructure getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public OneTime data(OneTimeFeeStructure data) {
            this.data = data;
            return this;
        }
    }
}
