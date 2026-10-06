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
        defaultImpl = UsagePricingModel.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = UsagePricingModel.PerUnit.class, name = "PER_UNIT"),
    @JsonSubTypes.Type(value = UsagePricingModel.Tiered.class, name = "TIERED"),
    @JsonSubTypes.Type(value = UsagePricingModel.Volume.class, name = "VOLUME"),
    @JsonSubTypes.Type(value = UsagePricingModel.Package.class, name = "PACKAGE"),
    @JsonSubTypes.Type(value = UsagePricingModel.Matrix.class, name = "MATRIX")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class UsagePricingModel {

    private UsagePricingModel() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code PER_UNIT} variant.
     *
     * @return whether it is
     */
    public final boolean isPerUnit() {
        return this instanceof PerUnit;
    }

    /**
     * This value as the {@code PER_UNIT} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final PerUnit asPerUnit() {
        if (this instanceof PerUnit) {
            return (PerUnit) this;
        }
        throw new IllegalStateException("not the PER_UNIT variant: " + type());
    }

    /**
     * Whether this is the {@code TIERED} variant.
     *
     * @return whether it is
     */
    public final boolean isTiered() {
        return this instanceof Tiered;
    }

    /**
     * This value as the {@code TIERED} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Tiered asTiered() {
        if (this instanceof Tiered) {
            return (Tiered) this;
        }
        throw new IllegalStateException("not the TIERED variant: " + type());
    }

    /**
     * Whether this is the {@code VOLUME} variant.
     *
     * @return whether it is
     */
    public final boolean isVolume() {
        return this instanceof Volume;
    }

    /**
     * This value as the {@code VOLUME} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Volume asVolume() {
        if (this instanceof Volume) {
            return (Volume) this;
        }
        throw new IllegalStateException("not the VOLUME variant: " + type());
    }

    /**
     * Whether this is the {@code PACKAGE} variant.
     *
     * @return whether it is
     */
    public final boolean isPackage() {
        return this instanceof Package;
    }

    /**
     * This value as the {@code PACKAGE} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Package asPackage() {
        if (this instanceof Package) {
            return (Package) this;
        }
        throw new IllegalStateException("not the PACKAGE variant: " + type());
    }

    /**
     * Whether this is the {@code MATRIX} variant.
     *
     * @return whether it is
     */
    public final boolean isMatrix() {
        return this instanceof Matrix;
    }

    /**
     * This value as the {@code MATRIX} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Matrix asMatrix() {
        if (this instanceof Matrix) {
            return (Matrix) this;
        }
        throw new IllegalStateException("not the MATRIX variant: " + type());
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
         * Visits the {@code PER_UNIT} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitPerUnit(PerUnitPricing value);

        /**
         * Visits the {@code TIERED} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitTiered(TieredPricing value);

        /**
         * Visits the {@code VOLUME} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitVolume(VolumePricing value);

        /**
         * Visits the {@code PACKAGE} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitPackage(PackagePricing value);

        /**
         * Visits the {@code MATRIX} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitMatrix(MatrixPricing value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown UsagePricingModel variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code UsagePricingModel}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static UsagePricingModel fromJson(String json) {
        return Utils.parse(json, UsagePricingModel.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code PER_UNIT} variant. */
    @JsonTypeName("PER_UNIT")
    public static final class PerUnit extends UsagePricingModel {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private PerUnitPricing data;

        private PerUnit() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public PerUnit(PerUnitPricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static PerUnit of(PerUnitPricing data) {
            return new PerUnit(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "PER_UNIT";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public PerUnitPricing data() {
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
            PerUnit that = (PerUnit) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "PerUnit{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitPerUnit(data);
        }
    }

    /** The {@code TIERED} variant. */
    @JsonTypeName("TIERED")
    public static final class Tiered extends UsagePricingModel {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private TieredPricing data;

        private Tiered() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Tiered(TieredPricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Tiered of(TieredPricing data) {
            return new Tiered(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "TIERED";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public TieredPricing data() {
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
            Tiered that = (Tiered) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Tiered{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitTiered(data);
        }
    }

    /** The {@code VOLUME} variant. */
    @JsonTypeName("VOLUME")
    public static final class Volume extends UsagePricingModel {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private VolumePricing data;

        private Volume() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Volume(VolumePricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Volume of(VolumePricing data) {
            return new Volume(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "VOLUME";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public VolumePricing data() {
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
            Volume that = (Volume) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Volume{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitVolume(data);
        }
    }

    /** The {@code PACKAGE} variant. */
    @JsonTypeName("PACKAGE")
    public static final class Package extends UsagePricingModel {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private PackagePricing data;

        private Package() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Package(PackagePricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Package of(PackagePricing data) {
            return new Package(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "PACKAGE";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public PackagePricing data() {
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
            Package that = (Package) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Package{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitPackage(data);
        }
    }

    /** The {@code MATRIX} variant. */
    @JsonTypeName("MATRIX")
    public static final class Matrix extends UsagePricingModel {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private MatrixPricing data;

        private Matrix() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Matrix(MatrixPricing data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Matrix of(MatrixPricing data) {
            return new Matrix(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "MATRIX";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public MatrixPricing data() {
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
            Matrix that = (Matrix) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Matrix{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitMatrix(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends UsagePricingModel {
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
