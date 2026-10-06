// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.Utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * One of the variants below, told apart by {@code type}. A value this version of the SDK does not
 * know parses as {@link Unrecognized}, which keeps its properties.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true,
        defaultImpl = ResetPeriod.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ResetPeriod.BillingCycle.class, name = "BILLING_CYCLE"),
    @JsonSubTypes.Type(value = ResetPeriod.Calendar.class, name = "CALENDAR"),
    @JsonSubTypes.Type(value = ResetPeriod.FixedWindow.class, name = "FIXED_WINDOW"),
    @JsonSubTypes.Type(value = ResetPeriod.SlidingWindow.class, name = "SLIDING_WINDOW"),
    @JsonSubTypes.Type(value = ResetPeriod.Never.class, name = "NEVER")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class ResetPeriod {

    private ResetPeriod() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code BILLING_CYCLE} variant.
     *
     * @return whether it is
     */
    public final boolean isBillingCycle() {
        return this instanceof BillingCycle;
    }

    /**
     * This value as the {@code BILLING_CYCLE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final BillingCycle asBillingCycle() {
        if (this instanceof BillingCycle) {
            return (BillingCycle) this;
        }
        throw new IllegalStateException("not the BILLING_CYCLE variant: " + type());
    }

    /**
     * Whether this is the {@code CALENDAR} variant.
     *
     * @return whether it is
     */
    public final boolean isCalendar() {
        return this instanceof Calendar;
    }

    /**
     * This value as the {@code CALENDAR} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Calendar asCalendar() {
        if (this instanceof Calendar) {
            return (Calendar) this;
        }
        throw new IllegalStateException("not the CALENDAR variant: " + type());
    }

    /**
     * Whether this is the {@code FIXED_WINDOW} variant.
     *
     * @return whether it is
     */
    public final boolean isFixedWindow() {
        return this instanceof FixedWindow;
    }

    /**
     * This value as the {@code FIXED_WINDOW} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final FixedWindow asFixedWindow() {
        if (this instanceof FixedWindow) {
            return (FixedWindow) this;
        }
        throw new IllegalStateException("not the FIXED_WINDOW variant: " + type());
    }

    /**
     * Whether this is the {@code SLIDING_WINDOW} variant.
     *
     * @return whether it is
     */
    public final boolean isSlidingWindow() {
        return this instanceof SlidingWindow;
    }

    /**
     * This value as the {@code SLIDING_WINDOW} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final SlidingWindow asSlidingWindow() {
        if (this instanceof SlidingWindow) {
            return (SlidingWindow) this;
        }
        throw new IllegalStateException("not the SLIDING_WINDOW variant: " + type());
    }

    /**
     * Whether this is the {@code NEVER} variant.
     *
     * @return whether it is
     */
    public final boolean isNever() {
        return this instanceof Never;
    }

    /**
     * This value as the {@code NEVER} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Never asNever() {
        if (this instanceof Never) {
            return (Never) this;
        }
        throw new IllegalStateException("not the NEVER variant: " + type());
    }

    /**
     * Whether this is a variant this version of the SDK does not know.
     *
     * @return whether it is
     */
    public final boolean isUnrecognized() {
        return this instanceof Unrecognized;
    }

    /**
     * This value as a variant this version of the SDK does not know.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Unrecognized asUnrecognized() {
        if (this instanceof Unrecognized) {
            return (Unrecognized) this;
        }
        throw new IllegalStateException("not a known variant: " + type());
    }

    /**
     * Calls the method of {@code visitor} for this variant.
     *
     * @param <R> the result type
     * @param visitor the visitor
     * @return the result of the visitor
     */
    public abstract <R> R accept(Visitor<R> visitor);

    /**
     * A function of each variant, called by {@link #accept}.
     *
     * @param <R> the result type
     */
    public interface Visitor<R> {
        /**
         * Visits the {@code BILLING_CYCLE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitBillingCycle(BillingCycleResetPeriod value);

        /**
         * Visits the {@code CALENDAR} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitCalendar(CalendarResetPeriod value);

        /**
         * Visits the {@code FIXED_WINDOW} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitFixedWindow(FixedWindowResetPeriod value);

        /**
         * Visits the {@code SLIDING_WINDOW} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitSlidingWindow(SlidingWindowResetPeriod value);

        /**
         * Visits the {@code NEVER} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitNever(NeverResetPeriod value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown ResetPeriod variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code ResetPeriod}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ResetPeriod fromJson(String json) {
        return Utils.parse(json, ResetPeriod.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code BILLING_CYCLE} variant. */
    @JsonTypeName("BILLING_CYCLE")
    public static final class BillingCycle extends ResetPeriod {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private BillingCycleResetPeriod data;

        private BillingCycle() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public BillingCycle(BillingCycleResetPeriod data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static BillingCycle of(BillingCycleResetPeriod data) {
            return new BillingCycle(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "BILLING_CYCLE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public BillingCycleResetPeriod data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            BillingCycle that = (BillingCycle) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "BillingCycle{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBillingCycle(data);
        }
    }

    /** The {@code CALENDAR} variant. */
    @JsonTypeName("CALENDAR")
    public static final class Calendar extends ResetPeriod {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private CalendarResetPeriod data;

        private Calendar() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Calendar(CalendarResetPeriod data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Calendar of(CalendarResetPeriod data) {
            return new Calendar(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "CALENDAR";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public CalendarResetPeriod data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Calendar that = (Calendar) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Calendar{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitCalendar(data);
        }
    }

    /** The {@code FIXED_WINDOW} variant. */
    @JsonTypeName("FIXED_WINDOW")
    public static final class FixedWindow extends ResetPeriod {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private FixedWindowResetPeriod data;

        private FixedWindow() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public FixedWindow(FixedWindowResetPeriod data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static FixedWindow of(FixedWindowResetPeriod data) {
            return new FixedWindow(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "FIXED_WINDOW";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public FixedWindowResetPeriod data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            FixedWindow that = (FixedWindow) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "FixedWindow{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitFixedWindow(data);
        }
    }

    /** The {@code SLIDING_WINDOW} variant. */
    @JsonTypeName("SLIDING_WINDOW")
    public static final class SlidingWindow extends ResetPeriod {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private SlidingWindowResetPeriod data;

        private SlidingWindow() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public SlidingWindow(SlidingWindowResetPeriod data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static SlidingWindow of(SlidingWindowResetPeriod data) {
            return new SlidingWindow(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "SLIDING_WINDOW";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public SlidingWindowResetPeriod data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SlidingWindow that = (SlidingWindow) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "SlidingWindow{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitSlidingWindow(data);
        }
    }

    /** The {@code NEVER} variant. */
    @JsonTypeName("NEVER")
    public static final class Never extends ResetPeriod {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private NeverResetPeriod data;

        private Never() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Never(NeverResetPeriod data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Never of(NeverResetPeriod data) {
            return new Never(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "NEVER";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public NeverResetPeriod data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Never that = (Never) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Never{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitNever(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends ResetPeriod {
        @JsonProperty("type")
        private String discriminator;

        private final Map<String, JsonNode> properties = new LinkedHashMap<>();

        private Unrecognized() {}

        @Override
        @JsonProperty("type")
        public String type() {
            return discriminator;
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitUnknown(this);
        }

        /**
         * Every other property of the variant.
         *
         * @return the properties by name, unmodifiable
         */
        @JsonAnyGetter
        public Map<String, JsonNode> properties() {
            return Collections.unmodifiableMap(properties);
        }

        @JsonAnySetter
        private void putProperty(String name, JsonNode value) {
            properties.put(name, value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Unrecognized that = (Unrecognized) o;
            return Objects.equals(discriminator, that.discriminator)
                    && Objects.equals(properties, that.properties);
        }

        @Override
        public int hashCode() {
            return Objects.hash(discriminator, properties);
        }

        @Override
        public String toString() {
            return "Unrecognized{"
                    + "discriminator="
                    + discriminator
                    + ", properties="
                    + properties
                    + "}";
        }
    }
}
