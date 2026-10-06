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
        defaultImpl = MinimumCommitmentScope.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MinimumCommitmentScope.AllComponents.class, name = "all_components"),
    @JsonSubTypes.Type(value = MinimumCommitmentScope.Products.class, name = "products")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class MinimumCommitmentScope {

    private MinimumCommitmentScope() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code all_components} variant.
     *
     * @return whether it is
     */
    public final boolean isAllComponents() {
        return this instanceof AllComponents;
    }

    /**
     * This value as the {@code all_components} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final AllComponents asAllComponents() {
        if (this instanceof AllComponents) {
            return (AllComponents) this;
        }
        throw new IllegalStateException("not the all_components variant: " + type());
    }

    /**
     * Whether this is the {@code products} variant.
     *
     * @return whether it is
     */
    public final boolean isProducts() {
        return this instanceof Products;
    }

    /**
     * This value as the {@code products} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Products asProducts() {
        if (this instanceof Products) {
            return (Products) this;
        }
        throw new IllegalStateException("not the products variant: " + type());
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
         * Visits the {@code all_components} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitAllComponents(AllComponentsScope value);

        /**
         * Visits the {@code products} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitProducts(ProductsScope value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown MinimumCommitmentScope variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code MinimumCommitmentScope}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MinimumCommitmentScope fromJson(String json) {
        return Utils.parse(json, MinimumCommitmentScope.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code all_components} variant. */
    @JsonTypeName("all_components")
    public static final class AllComponents extends MinimumCommitmentScope {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private AllComponentsScope data;

        private AllComponents() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public AllComponents(AllComponentsScope data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static AllComponents of(AllComponentsScope data) {
            return new AllComponents(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "all_components";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public AllComponentsScope data() {
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
            AllComponents that = (AllComponents) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "AllComponents{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitAllComponents(data);
        }
    }

    /** The {@code products} variant. */
    @JsonTypeName("products")
    public static final class Products extends MinimumCommitmentScope {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private ProductsScope data;

        private Products() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Products(ProductsScope data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Products of(ProductsScope data) {
            return new Products(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "products";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public ProductsScope data() {
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
            Products that = (Products) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Products{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitProducts(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends MinimumCommitmentScope {
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
