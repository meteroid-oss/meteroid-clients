// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.*;

import java.util.List;
import java.util.Map;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "discriminator",
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
    public abstract String getDiscriminator();

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
        public String getDiscriminator() {
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
     * <p>Inline struct variant with its own fields.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("DOUBLE")
    public static class Double extends MetricSegmentationMatrix {
        @JsonProperty private MetricDimension dimension1;
        @JsonProperty private MetricDimension dimension2;

        public Double() {}

        @java.lang.Override
        public String getDiscriminator() {
            return "DOUBLE";
        }

        @javax.annotation.Nonnull
        public MetricDimension getDimension1() {
            return dimension1;
        }

        public Double dimension1(MetricDimension dimension1) {
            this.dimension1 = dimension1;
            return this;
        }

        public void setDimension1(MetricDimension dimension1) {
            this.dimension1 = dimension1;
        }

        @javax.annotation.Nonnull
        public MetricDimension getDimension2() {
            return dimension2;
        }

        public Double dimension2(MetricDimension dimension2) {
            this.dimension2 = dimension2;
            return this;
        }

        public void setDimension2(MetricDimension dimension2) {
            this.dimension2 = dimension2;
        }
    }

    /**
     * Variant: LINKED
     *
     * <p>Inline struct variant with its own fields.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("LINKED")
    public static class Linked extends MetricSegmentationMatrix {
        @JsonProperty("dimension1_key")
        private String dimension1Key;

        @JsonProperty("dimension2_key")
        private String dimension2Key;

        @JsonProperty private Map<String, List<String>> values;

        public Linked() {}

        @java.lang.Override
        public String getDiscriminator() {
            return "LINKED";
        }

        @javax.annotation.Nonnull
        public String getDimension1Key() {
            return dimension1Key;
        }

        public Linked dimension1Key(String dimension1Key) {
            this.dimension1Key = dimension1Key;
            return this;
        }

        public void setDimension1Key(String dimension1Key) {
            this.dimension1Key = dimension1Key;
        }

        @javax.annotation.Nonnull
        public String getDimension2Key() {
            return dimension2Key;
        }

        public Linked dimension2Key(String dimension2Key) {
            this.dimension2Key = dimension2Key;
            return this;
        }

        public void setDimension2Key(String dimension2Key) {
            this.dimension2Key = dimension2Key;
        }

        @javax.annotation.Nonnull
        public Map<String, List<String>> getValues() {
            return values;
        }

        public Linked values(Map<String, List<String>> values) {
            this.values = values;
            return this;
        }

        public void setValues(Map<String, List<String>> values) {
            this.values = values;
        }
    }
}
