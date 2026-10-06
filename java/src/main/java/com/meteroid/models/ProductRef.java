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
        defaultImpl = ProductRef.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ProductRef.Existing.class, name = "EXISTING"),
    @JsonSubTypes.Type(value = ProductRef.New.class, name = "NEW")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class ProductRef {

    private ProductRef() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code EXISTING} variant.
     *
     * @return whether it is
     */
    public final boolean isExisting() {
        return this instanceof Existing;
    }

    /**
     * This value as the {@code EXISTING} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Existing asExisting() {
        if (this instanceof Existing) {
            return (Existing) this;
        }
        throw new IllegalStateException("not the EXISTING variant: " + type());
    }

    /**
     * Whether this is the {@code NEW} variant.
     *
     * @return whether it is
     */
    public final boolean isNew() {
        return this instanceof New;
    }

    /**
     * This value as the {@code NEW} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final New asNew() {
        if (this instanceof New) {
            return (New) this;
        }
        throw new IllegalStateException("not the NEW variant: " + type());
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
         * Visits the {@code EXISTING} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitExisting(ExistingProductRef value);

        /**
         * Visits the {@code NEW} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitNew(NewProductRef value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown ProductRef variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code ProductRef}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ProductRef fromJson(String json) {
        return Utils.parse(json, ProductRef.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code EXISTING} variant. */
    @JsonTypeName("EXISTING")
    public static final class Existing extends ProductRef {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private ExistingProductRef data;

        private Existing() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Existing(ExistingProductRef data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Existing of(ExistingProductRef data) {
            return new Existing(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "EXISTING";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public ExistingProductRef data() {
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
            Existing that = (Existing) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Existing{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitExisting(data);
        }
    }

    /** The {@code NEW} variant. */
    @JsonTypeName("NEW")
    public static final class New extends ProductRef {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private NewProductRef data;

        private New() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public New(NewProductRef data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static New of(NewProductRef data) {
            return new New(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "NEW";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public NewProductRef data() {
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
            New that = (New) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "New{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitNew(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends ProductRef {
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
