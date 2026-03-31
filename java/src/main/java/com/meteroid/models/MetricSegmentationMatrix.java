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
        property = "type",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MetricSegmentationMatrix.Single.class, name = "SINGLE"),
    @JsonSubTypes.Type(value = MetricSegmentationMatrix.Double.class, name = "DOUBLE"),
    @JsonSubTypes.Type(value = MetricSegmentationMatrix.Linked.class, name = "LINKED")
})
@ToString
@EqualsAndHashCode
public abstract class MetricSegmentationMatrix {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of MetricSegmentationMatrix to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of MetricSegmentationMatrix from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of MetricSegmentationMatrix
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static MetricSegmentationMatrix fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricSegmentationMatrix.class);
    }

    // Variant classes
    /**
     * Variant: SINGLE
     *
     * <p>This variant wraps MetricDimension.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("SINGLE")
    public static class Single extends MetricSegmentationMatrix {
        @JsonUnwrapped private MetricDimension data;

        public Single() {}

        public Single(MetricDimension data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "SINGLE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public MetricDimension getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Single data(MetricDimension data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: DOUBLE
     *
     * <p>This variant wraps DoubleSegmentationMatrix.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("DOUBLE")
    public static class Double extends MetricSegmentationMatrix {
        @JsonUnwrapped private DoubleSegmentationMatrix data;

        public Double() {}

        public Double(DoubleSegmentationMatrix data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "DOUBLE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public DoubleSegmentationMatrix getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Double data(DoubleSegmentationMatrix data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: LINKED
     *
     * <p>This variant wraps LinkedSegmentationMatrix.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("LINKED")
    public static class Linked extends MetricSegmentationMatrix {
        @JsonUnwrapped private LinkedSegmentationMatrix data;

        public Linked() {}

        public Linked(LinkedSegmentationMatrix data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "LINKED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public LinkedSegmentationMatrix getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Linked data(LinkedSegmentationMatrix data) {
            this.data = data;
            return this;
        }
    }
}
