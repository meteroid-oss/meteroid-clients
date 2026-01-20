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
        property = "discriminator",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = UsagePricingModel.PerUnit.class, name = "PER_UNIT"),
    @JsonSubTypes.Type(value = UsagePricingModel.Tiered.class, name = "TIERED"),
    @JsonSubTypes.Type(value = UsagePricingModel.Volume.class, name = "VOLUME"),
    @JsonSubTypes.Type(value = UsagePricingModel.Package.class, name = "PACKAGE"),
    @JsonSubTypes.Type(value = UsagePricingModel.Matrix.class, name = "MATRIX")
})
@ToString
@EqualsAndHashCode
public abstract class UsagePricingModel {
    /** Get the discriminator value identifying this variant. */
    public abstract String getDiscriminator();

    /**
     * Convert an instance of UsagePricingModel to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of UsagePricingModel from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of UsagePricingModel
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static UsagePricingModel fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, UsagePricingModel.class);
    }

    // Variant classes
    /**
     * Variant: PER_UNIT
     *
     * <p>This variant wraps PerUnitPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("PER_UNIT")
    public static class PerUnit extends UsagePricingModel {
        @JsonUnwrapped private PerUnitPricing data;

        public PerUnit() {}

        public PerUnit(PerUnitPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "PER_UNIT";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public PerUnitPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public PerUnit data(PerUnitPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: TIERED
     *
     * <p>This variant wraps TieredPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("TIERED")
    public static class Tiered extends UsagePricingModel {
        @JsonUnwrapped private TieredPricing data;

        public Tiered() {}

        public Tiered(TieredPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "TIERED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public TieredPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Tiered data(TieredPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: VOLUME
     *
     * <p>This variant wraps VolumePricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("VOLUME")
    public static class Volume extends UsagePricingModel {
        @JsonUnwrapped private VolumePricing data;

        public Volume() {}

        public Volume(VolumePricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "VOLUME";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public VolumePricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Volume data(VolumePricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: PACKAGE
     *
     * <p>This variant wraps PackagePricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("PACKAGE")
    public static class Package extends UsagePricingModel {
        @JsonUnwrapped private PackagePricing data;

        public Package() {}

        public Package(PackagePricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "PACKAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public PackagePricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Package data(PackagePricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: MATRIX
     *
     * <p>This variant wraps MatrixPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("MATRIX")
    public static class Matrix extends UsagePricingModel {
        @JsonUnwrapped private MatrixPricing data;

        public Matrix() {}

        public Matrix(MatrixPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "MATRIX";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public MatrixPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Matrix data(MatrixPricing data) {
            this.data = data;
            return this;
        }
    }
}
