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
    @JsonSubTypes.Type(value = Fee.Rate.class, name = "RATE"),
    @JsonSubTypes.Type(value = Fee.Slot.class, name = "SLOT"),
    @JsonSubTypes.Type(value = Fee.Capacity.class, name = "CAPACITY"),
    @JsonSubTypes.Type(value = Fee.Usage.class, name = "USAGE"),
    @JsonSubTypes.Type(value = Fee.ExtraRecurring.class, name = "EXTRA_RECURRING"),
    @JsonSubTypes.Type(value = Fee.OneTime.class, name = "ONE_TIME")
})
@ToString
@EqualsAndHashCode
public abstract class Fee {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of Fee to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of Fee from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of Fee
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static Fee fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Fee.class);
    }

    // Variant classes
    /**
     * Variant: RATE
     *
     * <p>This variant wraps RatePlanFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("RATE")
    public static class Rate extends Fee {
        @JsonUnwrapped private RatePlanFee data;

        public Rate() {}

        public Rate(RatePlanFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "RATE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public RatePlanFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Rate data(RatePlanFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: SLOT
     *
     * <p>This variant wraps SlotPlanFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("SLOT")
    public static class Slot extends Fee {
        @JsonUnwrapped private SlotPlanFee data;

        public Slot() {}

        public Slot(SlotPlanFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "SLOT";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public SlotPlanFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Slot data(SlotPlanFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: CAPACITY
     *
     * <p>This variant wraps CapacityPlanFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("CAPACITY")
    public static class Capacity extends Fee {
        @JsonUnwrapped private CapacityPlanFee data;

        public Capacity() {}

        public Capacity(CapacityPlanFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "CAPACITY";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public CapacityPlanFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Capacity data(CapacityPlanFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: USAGE
     *
     * <p>This variant wraps UsagePlanFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("USAGE")
    public static class Usage extends Fee {
        @JsonUnwrapped private UsagePlanFee data;

        public Usage() {}

        public Usage(UsagePlanFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "USAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public UsagePlanFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Usage data(UsagePlanFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: EXTRA_RECURRING
     *
     * <p>This variant wraps ExtraRecurringPlanFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("EXTRA_RECURRING")
    public static class ExtraRecurring extends Fee {
        @JsonUnwrapped private ExtraRecurringPlanFee data;

        public ExtraRecurring() {}

        public ExtraRecurring(ExtraRecurringPlanFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "EXTRA_RECURRING";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ExtraRecurringPlanFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public ExtraRecurring data(ExtraRecurringPlanFee data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: ONE_TIME
     *
     * <p>This variant wraps OneTimePlanFee.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("ONE_TIME")
    public static class OneTime extends Fee {
        @JsonUnwrapped private OneTimePlanFee data;

        public OneTime() {}

        public OneTime(OneTimePlanFee data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "ONE_TIME";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public OneTimePlanFee getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public OneTime data(OneTimePlanFee data) {
            this.data = data;
            return this;
        }
    }
}
