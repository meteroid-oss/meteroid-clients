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
        defaultImpl = SubscriptionAddOnCustomization.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(
            value = SubscriptionAddOnCustomization.PriceOverride.class,
            name = "PRICE_OVERRIDE"),
    @JsonSubTypes.Type(
            value = SubscriptionAddOnCustomization.Parameterization.class,
            name = "PARAMETERIZATION")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class SubscriptionAddOnCustomization {

    private SubscriptionAddOnCustomization() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code PRICE_OVERRIDE} variant.
     *
     * @return whether it is
     */
    public final boolean isPriceOverride() {
        return this instanceof PriceOverride;
    }

    /**
     * This value as the {@code PRICE_OVERRIDE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final PriceOverride asPriceOverride() {
        if (this instanceof PriceOverride) {
            return (PriceOverride) this;
        }
        throw new IllegalStateException("not the PRICE_OVERRIDE variant: " + type());
    }

    /**
     * Whether this is the {@code PARAMETERIZATION} variant.
     *
     * @return whether it is
     */
    public final boolean isParameterization() {
        return this instanceof Parameterization;
    }

    /**
     * This value as the {@code PARAMETERIZATION} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Parameterization asParameterization() {
        if (this instanceof Parameterization) {
            return (Parameterization) this;
        }
        throw new IllegalStateException("not the PARAMETERIZATION variant: " + type());
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
         * Visits the {@code PRICE_OVERRIDE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitPriceOverride(SubscriptionAddOnPriceOverride value);

        /**
         * Visits the {@code PARAMETERIZATION} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitParameterization(SubscriptionAddOnParameterization value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown SubscriptionAddOnCustomization variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code SubscriptionAddOnCustomization}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static SubscriptionAddOnCustomization fromJson(String json) {
        return Utils.parse(json, SubscriptionAddOnCustomization.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code PRICE_OVERRIDE} variant. */
    @JsonTypeName("PRICE_OVERRIDE")
    public static final class PriceOverride extends SubscriptionAddOnCustomization {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private SubscriptionAddOnPriceOverride data;

        private PriceOverride() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public PriceOverride(SubscriptionAddOnPriceOverride data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static PriceOverride of(SubscriptionAddOnPriceOverride data) {
            return new PriceOverride(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "PRICE_OVERRIDE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public SubscriptionAddOnPriceOverride data() {
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
            PriceOverride that = (PriceOverride) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "PriceOverride{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitPriceOverride(data);
        }
    }

    /** The {@code PARAMETERIZATION} variant. */
    @JsonTypeName("PARAMETERIZATION")
    public static final class Parameterization extends SubscriptionAddOnCustomization {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private SubscriptionAddOnParameterization data;

        private Parameterization() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Parameterization(SubscriptionAddOnParameterization data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Parameterization of(SubscriptionAddOnParameterization data) {
            return new Parameterization(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "PARAMETERIZATION";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public SubscriptionAddOnParameterization data() {
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
            Parameterization that = (Parameterization) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Parameterization{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitParameterization(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends SubscriptionAddOnCustomization {
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
