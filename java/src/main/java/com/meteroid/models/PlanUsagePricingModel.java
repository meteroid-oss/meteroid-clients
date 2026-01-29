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
    @JsonSubTypes.Type(value = PlanUsagePricingModel.PerUnit.class, name = "PER_UNIT"),
    @JsonSubTypes.Type(value = PlanUsagePricingModel.Tiered.class, name = "TIERED"),
    @JsonSubTypes.Type(value = PlanUsagePricingModel.Volume.class, name = "VOLUME"),
    @JsonSubTypes.Type(value = PlanUsagePricingModel.Package.class, name = "PACKAGE"),
    @JsonSubTypes.Type(value = PlanUsagePricingModel.Matrix.class, name = "MATRIX")
})
@ToString
@EqualsAndHashCode
public abstract class PlanUsagePricingModel {
    /** Get the discriminator value identifying this variant. */
    public abstract String getDiscriminator();

    /**
     * Convert an instance of PlanUsagePricingModel to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of PlanUsagePricingModel from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of PlanUsagePricingModel
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static PlanUsagePricingModel fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PlanUsagePricingModel.class);
    }

    // Variant classes
    /**
     * Variant: PER_UNIT
     *
     * <p>This variant wraps PerUnitPlanPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("PER_UNIT")
    public static class PerUnit extends PlanUsagePricingModel {
        @JsonUnwrapped private PerUnitPlanPricing data;

        public PerUnit() {}

        public PerUnit(PerUnitPlanPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "PER_UNIT";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public PerUnitPlanPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public PerUnit data(PerUnitPlanPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: TIERED
     *
     * <p>This variant wraps TieredPlanPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("TIERED")
    public static class Tiered extends PlanUsagePricingModel {
        @JsonUnwrapped private TieredPlanPricing data;

        public Tiered() {}

        public Tiered(TieredPlanPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "TIERED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public TieredPlanPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Tiered data(TieredPlanPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: VOLUME
     *
     * <p>This variant wraps VolumePlanPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("VOLUME")
    public static class Volume extends PlanUsagePricingModel {
        @JsonUnwrapped private VolumePlanPricing data;

        public Volume() {}

        public Volume(VolumePlanPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "VOLUME";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public VolumePlanPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Volume data(VolumePlanPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: PACKAGE
     *
     * <p>This variant wraps PackagePlanPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("PACKAGE")
    public static class Package extends PlanUsagePricingModel {
        @JsonUnwrapped private PackagePlanPricing data;

        public Package() {}

        public Package(PackagePlanPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "PACKAGE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public PackagePlanPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Package data(PackagePlanPricing data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: MATRIX
     *
     * <p>This variant wraps MatrixPlanPricing.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("MATRIX")
    public static class Matrix extends PlanUsagePricingModel {
        @JsonUnwrapped private MatrixPlanPricing data;

        public Matrix() {}

        public Matrix(MatrixPlanPricing data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "MATRIX";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public MatrixPlanPricing getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Matrix data(MatrixPlanPricing data) {
            this.data = data;
            return this;
        }
    }
}
