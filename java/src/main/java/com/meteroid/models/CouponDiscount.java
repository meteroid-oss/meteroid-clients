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
        defaultImpl = CouponDiscount.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CouponDiscount.Percentage.class, name = "PERCENTAGE"),
    @JsonSubTypes.Type(value = CouponDiscount.Fixed.class, name = "FIXED")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class CouponDiscount {

    private CouponDiscount() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code PERCENTAGE} variant.
     *
     * @return whether it is
     */
    public final boolean isPercentage() {
        return this instanceof Percentage;
    }

    /**
     * This value as the {@code PERCENTAGE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Percentage asPercentage() {
        if (this instanceof Percentage) {
            return (Percentage) this;
        }
        throw new IllegalStateException("not the PERCENTAGE variant: " + type());
    }

    /**
     * Whether this is the {@code FIXED} variant.
     *
     * @return whether it is
     */
    public final boolean isFixed() {
        return this instanceof Fixed;
    }

    /**
     * This value as the {@code FIXED} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Fixed asFixed() {
        if (this instanceof Fixed) {
            return (Fixed) this;
        }
        throw new IllegalStateException("not the FIXED variant: " + type());
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
         * Visits the {@code PERCENTAGE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitPercentage(PercentageDiscount value);

        /**
         * Visits the {@code FIXED} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitFixed(FixedDiscount value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown CouponDiscount variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code CouponDiscount}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CouponDiscount fromJson(String json) {
        return Utils.parse(json, CouponDiscount.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code PERCENTAGE} variant. */
    @JsonTypeName("PERCENTAGE")
    public static final class Percentage extends CouponDiscount {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private PercentageDiscount data;

        private Percentage() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Percentage(PercentageDiscount data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Percentage of(PercentageDiscount data) {
            return new Percentage(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "PERCENTAGE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public PercentageDiscount data() {
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
            Percentage that = (Percentage) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Percentage{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitPercentage(data);
        }
    }

    /** The {@code FIXED} variant. */
    @JsonTypeName("FIXED")
    public static final class Fixed extends CouponDiscount {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private FixedDiscount data;

        private Fixed() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Fixed(FixedDiscount data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Fixed of(FixedDiscount data) {
            return new Fixed(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "FIXED";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public FixedDiscount data() {
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
            Fixed that = (Fixed) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Fixed{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitFixed(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends CouponDiscount {
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
