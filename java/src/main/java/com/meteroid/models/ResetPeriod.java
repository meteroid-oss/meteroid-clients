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
    @JsonSubTypes.Type(value = ResetPeriod.BillingCycle.class, name = "BILLING_CYCLE"),
    @JsonSubTypes.Type(value = ResetPeriod.Calendar.class, name = "CALENDAR"),
    @JsonSubTypes.Type(value = ResetPeriod.FixedWindow.class, name = "FIXED_WINDOW"),
    @JsonSubTypes.Type(value = ResetPeriod.SlidingWindow.class, name = "SLIDING_WINDOW"),
    @JsonSubTypes.Type(value = ResetPeriod.Never.class, name = "NEVER")
})
@ToString
@EqualsAndHashCode
public abstract class ResetPeriod {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of ResetPeriod to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of ResetPeriod from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of ResetPeriod
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static ResetPeriod fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ResetPeriod.class);
    }

    // Variant classes
    /**
     * Variant: BILLING_CYCLE
     *
     * <p>This variant wraps BillingCycleResetPeriod.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("BILLING_CYCLE")
    public static class BillingCycle extends ResetPeriod {
        @JsonUnwrapped private BillingCycleResetPeriod data;

        public BillingCycle() {}

        public BillingCycle(BillingCycleResetPeriod data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "BILLING_CYCLE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public BillingCycleResetPeriod getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public BillingCycle data(BillingCycleResetPeriod data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: CALENDAR
     *
     * <p>This variant wraps CalendarResetPeriod.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("CALENDAR")
    public static class Calendar extends ResetPeriod {
        @JsonUnwrapped private CalendarResetPeriod data;

        public Calendar() {}

        public Calendar(CalendarResetPeriod data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "CALENDAR";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public CalendarResetPeriod getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Calendar data(CalendarResetPeriod data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: FIXED_WINDOW
     *
     * <p>This variant wraps FixedWindowResetPeriod.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("FIXED_WINDOW")
    public static class FixedWindow extends ResetPeriod {
        @JsonUnwrapped private FixedWindowResetPeriod data;

        public FixedWindow() {}

        public FixedWindow(FixedWindowResetPeriod data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "FIXED_WINDOW";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public FixedWindowResetPeriod getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public FixedWindow data(FixedWindowResetPeriod data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: SLIDING_WINDOW
     *
     * <p>This variant wraps SlidingWindowResetPeriod.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("SLIDING_WINDOW")
    public static class SlidingWindow extends ResetPeriod {
        @JsonUnwrapped private SlidingWindowResetPeriod data;

        public SlidingWindow() {}

        public SlidingWindow(SlidingWindowResetPeriod data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "SLIDING_WINDOW";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public SlidingWindowResetPeriod getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public SlidingWindow data(SlidingWindowResetPeriod data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: NEVER
     *
     * <p>This variant wraps NeverResetPeriod.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("NEVER")
    public static class Never extends ResetPeriod {
        @JsonUnwrapped private NeverResetPeriod data;

        public Never() {}

        public Never(NeverResetPeriod data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "NEVER";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public NeverResetPeriod getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Never data(NeverResetPeriod data) {
            this.data = data;
            return this;
        }
    }
}
