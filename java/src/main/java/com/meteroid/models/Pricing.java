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
        defaultImpl = Pricing.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Pricing.Rate.class, name = "RATE"),
    @JsonSubTypes.Type(value = Pricing.Slot.class, name = "SLOT"),
    @JsonSubTypes.Type(value = Pricing.Capacity.class, name = "CAPACITY"),
    @JsonSubTypes.Type(value = Pricing.Usage.class, name = "USAGE"),
    @JsonSubTypes.Type(value = Pricing.ExtraRecurring.class, name = "EXTRA_RECURRING"),
    @JsonSubTypes.Type(value = Pricing.OneTime.class, name = "ONE_TIME")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class Pricing {

    private Pricing() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code RATE} variant.
     *
     * @return whether it is
     */
    public final boolean isRate() {
        return this instanceof Rate;
    }

    /**
     * This value as the {@code RATE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Rate asRate() {
        if (this instanceof Rate) {
            return (Rate) this;
        }
        throw new IllegalStateException("not the RATE variant: " + type());
    }

    /**
     * Whether this is the {@code SLOT} variant.
     *
     * @return whether it is
     */
    public final boolean isSlot() {
        return this instanceof Slot;
    }

    /**
     * This value as the {@code SLOT} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Slot asSlot() {
        if (this instanceof Slot) {
            return (Slot) this;
        }
        throw new IllegalStateException("not the SLOT variant: " + type());
    }

    /**
     * Whether this is the {@code CAPACITY} variant.
     *
     * @return whether it is
     */
    public final boolean isCapacity() {
        return this instanceof Capacity;
    }

    /**
     * This value as the {@code CAPACITY} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Capacity asCapacity() {
        if (this instanceof Capacity) {
            return (Capacity) this;
        }
        throw new IllegalStateException("not the CAPACITY variant: " + type());
    }

    /**
     * Whether this is the {@code USAGE} variant.
     *
     * @return whether it is
     */
    public final boolean isUsage() {
        return this instanceof Usage;
    }

    /**
     * This value as the {@code USAGE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Usage asUsage() {
        if (this instanceof Usage) {
            return (Usage) this;
        }
        throw new IllegalStateException("not the USAGE variant: " + type());
    }

    /**
     * Whether this is the {@code EXTRA_RECURRING} variant.
     *
     * @return whether it is
     */
    public final boolean isExtraRecurring() {
        return this instanceof ExtraRecurring;
    }

    /**
     * This value as the {@code EXTRA_RECURRING} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final ExtraRecurring asExtraRecurring() {
        if (this instanceof ExtraRecurring) {
            return (ExtraRecurring) this;
        }
        throw new IllegalStateException("not the EXTRA_RECURRING variant: " + type());
    }

    /**
     * Whether this is the {@code ONE_TIME} variant.
     *
     * @return whether it is
     */
    public final boolean isOneTime() {
        return this instanceof OneTime;
    }

    /**
     * This value as the {@code ONE_TIME} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final OneTime asOneTime() {
        if (this instanceof OneTime) {
            return (OneTime) this;
        }
        throw new IllegalStateException("not the ONE_TIME variant: " + type());
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
         * Visits the {@code RATE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitRate(RatePricing value);

        /**
         * Visits the {@code SLOT} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitSlot(SlotPricing value);

        /**
         * Visits the {@code CAPACITY} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitCapacity(CapacityPricing value);

        /**
         * Visits the {@code USAGE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitUsage(UsagePricing value);

        /**
         * Visits the {@code EXTRA_RECURRING} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitExtraRecurring(ExtraRecurringPricing value);

        /**
         * Visits the {@code ONE_TIME} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitOneTime(OneTimePricing value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown Pricing variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code Pricing}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Pricing fromJson(String json) {
        return Utils.parse(json, Pricing.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code RATE} variant. */
    @JsonTypeName("RATE")
    public static final class Rate extends Pricing {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private RatePricing data;

        private Rate() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Rate(RatePricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Rate of(RatePricing data) {
            return new Rate(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "RATE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public RatePricing data() {
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
            Rate that = (Rate) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Rate{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitRate(data);
        }
    }

    /** The {@code SLOT} variant. */
    @JsonTypeName("SLOT")
    public static final class Slot extends Pricing {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private SlotPricing data;

        private Slot() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Slot(SlotPricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Slot of(SlotPricing data) {
            return new Slot(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "SLOT";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public SlotPricing data() {
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
            Slot that = (Slot) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Slot{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitSlot(data);
        }
    }

    /** The {@code CAPACITY} variant. */
    @JsonTypeName("CAPACITY")
    public static final class Capacity extends Pricing {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private CapacityPricing data;

        private Capacity() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Capacity(CapacityPricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Capacity of(CapacityPricing data) {
            return new Capacity(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "CAPACITY";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public CapacityPricing data() {
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
            Capacity that = (Capacity) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Capacity{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitCapacity(data);
        }
    }

    /** The {@code USAGE} variant. */
    @JsonTypeName("USAGE")
    public static final class Usage extends Pricing {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private UsagePricing data;

        private Usage() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Usage(UsagePricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Usage of(UsagePricing data) {
            return new Usage(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "USAGE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public UsagePricing data() {
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
            Usage that = (Usage) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Usage{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitUsage(data);
        }
    }

    /** The {@code EXTRA_RECURRING} variant. */
    @JsonTypeName("EXTRA_RECURRING")
    public static final class ExtraRecurring extends Pricing {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private ExtraRecurringPricing data;

        private ExtraRecurring() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public ExtraRecurring(ExtraRecurringPricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static ExtraRecurring of(ExtraRecurringPricing data) {
            return new ExtraRecurring(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "EXTRA_RECURRING";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public ExtraRecurringPricing data() {
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
            ExtraRecurring that = (ExtraRecurring) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "ExtraRecurring{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitExtraRecurring(data);
        }
    }

    /** The {@code ONE_TIME} variant. */
    @JsonTypeName("ONE_TIME")
    public static final class OneTime extends Pricing {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private OneTimePricing data;

        private OneTime() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public OneTime(OneTimePricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static OneTime of(OneTimePricing data) {
            return new OneTime(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "ONE_TIME";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public OneTimePricing data() {
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
            OneTime that = (OneTime) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "OneTime{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitOneTime(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends Pricing {
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
