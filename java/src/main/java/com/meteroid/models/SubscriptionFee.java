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
    @JsonSubTypes.Type(value = SubscriptionFee.Rate.class, name = "RATE"),
    @JsonSubTypes.Type(value = SubscriptionFee.OneTime.class, name = "ONE_TIME"),
    @JsonSubTypes.Type(value = SubscriptionFee.Recurring.class, name = "RECURRING"),
    @JsonSubTypes.Type(value = SubscriptionFee.Capacity.class, name = "CAPACITY"),
    @JsonSubTypes.Type(value = SubscriptionFee.Slot.class, name = "SLOT"),
    @JsonSubTypes.Type(value = SubscriptionFee.Usage.class, name = "USAGE")
})
@ToString
@EqualsAndHashCode
public abstract class SubscriptionFee {
    /** Get the discriminator value identifying this variant. */
    public abstract String getDiscriminator();

    /**
     * Convert an instance of SubscriptionFee to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of SubscriptionFee from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionFee
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static SubscriptionFee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionFee.class);
    }

    // Variant classes
    /**
     * Variant: RATE
     *
     * <p>This variant wraps RateFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("RATE")
    public static class Rate extends SubscriptionFee {
        @JsonUnwrapped private RateFee data;

        public Rate() {}

        public Rate(RateFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "RATE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public RateFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Rate data(RateFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: ONE_TIME
     *
     * <p>This variant wraps OneTimeFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("ONE_TIME")
    public static class OneTime extends SubscriptionFee {
        @JsonUnwrapped private OneTimeFee data;

        public OneTime() {}

        public OneTime(OneTimeFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "ONE_TIME";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public OneTimeFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public OneTime data(OneTimeFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: RECURRING
     *
     * <p>This variant wraps RecurringFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("RECURRING")
    public static class Recurring extends SubscriptionFee {
        @JsonUnwrapped private RecurringFee data;

        public Recurring() {}

        public Recurring(RecurringFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "RECURRING";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public RecurringFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Recurring data(RecurringFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: CAPACITY
     *
     * <p>This variant wraps CapacityFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("CAPACITY")
    public static class Capacity extends SubscriptionFee {
        @JsonUnwrapped private CapacityFee data;

        public Capacity() {}

        public Capacity(CapacityFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "CAPACITY";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public CapacityFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Capacity data(CapacityFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: SLOT
     *
     * <p>This variant wraps SlotFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("SLOT")
    public static class Slot extends SubscriptionFee {
        @JsonUnwrapped private SlotFee data;

        public Slot() {}

        public Slot(SlotFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "SLOT";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public SlotFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Slot data(SlotFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: USAGE
     *
     * <p>This variant wraps UsageFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("USAGE")
    public static class Usage extends SubscriptionFee {
        @JsonUnwrapped private UsageFee data;

        public Usage() {}

        public Usage(UsageFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "USAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public UsageFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Usage data(UsageFee data) {
            this.data = data;
            return this;
        }
    }
}
