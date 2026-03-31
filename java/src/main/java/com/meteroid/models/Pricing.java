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
        property = "type",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Pricing.Rate.class, name = "RATE"),
    @JsonSubTypes.Type(value = Pricing.Slot.class, name = "SLOT"),
    @JsonSubTypes.Type(value = Pricing.Capacity.class, name = "CAPACITY"),
    @JsonSubTypes.Type(value = Pricing.Usage.class, name = "USAGE"),
    @JsonSubTypes.Type(value = Pricing.ExtraRecurring.class, name = "EXTRA_RECURRING"),
    @JsonSubTypes.Type(value = Pricing.OneTime.class, name = "ONE_TIME")
})
@ToString
@EqualsAndHashCode
public abstract class Pricing {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of Pricing to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of Pricing from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of Pricing
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static Pricing fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Pricing.class);
    }

    // Variant classes
    /**
     * Variant: RATE
     *
     * <p>This variant wraps RatePricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("RATE")
    public static class Rate extends Pricing {
        @JsonUnwrapped private RatePricing data;

        public Rate() {}

        public Rate(RatePricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "RATE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public RatePricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Rate data(RatePricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: SLOT
     *
     * <p>This variant wraps SlotPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("SLOT")
    public static class Slot extends Pricing {
        @JsonUnwrapped private SlotPricing data;

        public Slot() {}

        public Slot(SlotPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "SLOT";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public SlotPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Slot data(SlotPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: CAPACITY
     *
     * <p>This variant wraps CapacityPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("CAPACITY")
    public static class Capacity extends Pricing {
        @JsonUnwrapped private CapacityPricing data;

        public Capacity() {}

        public Capacity(CapacityPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "CAPACITY";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public CapacityPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Capacity data(CapacityPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: USAGE
     *
     * <p>This variant wraps UsagePricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("USAGE")
    public static class Usage extends Pricing {
        @JsonUnwrapped private UsagePricing data;

        public Usage() {}

        public Usage(UsagePricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "USAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public UsagePricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Usage data(UsagePricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: EXTRA_RECURRING
     *
     * <p>This variant wraps ExtraRecurringPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("EXTRA_RECURRING")
    public static class ExtraRecurring extends Pricing {
        @JsonUnwrapped private ExtraRecurringPricing data;

        public ExtraRecurring() {}

        public ExtraRecurring(ExtraRecurringPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "EXTRA_RECURRING";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ExtraRecurringPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public ExtraRecurring data(ExtraRecurringPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: ONE_TIME
     *
     * <p>This variant wraps OneTimePricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("ONE_TIME")
    public static class OneTime extends Pricing {
        @JsonUnwrapped private OneTimePricing data;

        public OneTime() {}

        public OneTime(OneTimePricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "ONE_TIME";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public OneTimePricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public OneTime data(OneTimePricing data) {
            this.data = data;
            return this;
        }
    }
}
