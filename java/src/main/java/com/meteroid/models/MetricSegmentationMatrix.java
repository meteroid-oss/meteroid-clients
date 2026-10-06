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
        defaultImpl = MetricSegmentationMatrix.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MetricSegmentationMatrix.Single.class, name = "SINGLE"),
    @JsonSubTypes.Type(value = MetricSegmentationMatrix.Double.class, name = "DOUBLE"),
    @JsonSubTypes.Type(value = MetricSegmentationMatrix.Linked.class, name = "LINKED")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class MetricSegmentationMatrix {

    private MetricSegmentationMatrix() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code SINGLE} variant.
     *
     * @return whether it is
     */
    public final boolean isSingle() {
        return this instanceof Single;
    }

    /**
     * This value as the {@code SINGLE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Single asSingle() {
        if (this instanceof Single) {
            return (Single) this;
        }
        throw new IllegalStateException("not the SINGLE variant: " + type());
    }

    /**
     * Whether this is the {@code DOUBLE} variant.
     *
     * @return whether it is
     */
    public final boolean isDouble() {
        return this instanceof Double;
    }

    /**
     * This value as the {@code DOUBLE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Double asDouble() {
        if (this instanceof Double) {
            return (Double) this;
        }
        throw new IllegalStateException("not the DOUBLE variant: " + type());
    }

    /**
     * Whether this is the {@code LINKED} variant.
     *
     * @return whether it is
     */
    public final boolean isLinked() {
        return this instanceof Linked;
    }

    /**
     * This value as the {@code LINKED} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Linked asLinked() {
        if (this instanceof Linked) {
            return (Linked) this;
        }
        throw new IllegalStateException("not the LINKED variant: " + type());
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
         * Visits the {@code SINGLE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitSingle(MetricDimension value);

        /**
         * Visits the {@code DOUBLE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitDouble(DoubleSegmentationMatrix value);

        /**
         * Visits the {@code LINKED} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitLinked(LinkedSegmentationMatrix value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown MetricSegmentationMatrix variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code MetricSegmentationMatrix}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MetricSegmentationMatrix fromJson(String json) {
        return Utils.parse(json, MetricSegmentationMatrix.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code SINGLE} variant. */
    @JsonTypeName("SINGLE")
    public static final class Single extends MetricSegmentationMatrix {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private MetricDimension data;

        private Single() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Single(MetricDimension data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Single of(MetricDimension data) {
            return new Single(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "SINGLE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public MetricDimension data() {
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
            Single that = (Single) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Single{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitSingle(data);
        }
    }

    /** The {@code DOUBLE} variant. */
    @JsonTypeName("DOUBLE")
    public static final class Double extends MetricSegmentationMatrix {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private DoubleSegmentationMatrix data;

        private Double() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Double(DoubleSegmentationMatrix data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Double of(DoubleSegmentationMatrix data) {
            return new Double(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "DOUBLE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public DoubleSegmentationMatrix data() {
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
            Double that = (Double) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Double{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitDouble(data);
        }
    }

    /** The {@code LINKED} variant. */
    @JsonTypeName("LINKED")
    public static final class Linked extends MetricSegmentationMatrix {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private LinkedSegmentationMatrix data;

        private Linked() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Linked(LinkedSegmentationMatrix data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Linked of(LinkedSegmentationMatrix data) {
            return new Linked(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "LINKED";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public LinkedSegmentationMatrix data() {
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
            Linked that = (Linked) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Linked{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitLinked(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends MetricSegmentationMatrix {
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
