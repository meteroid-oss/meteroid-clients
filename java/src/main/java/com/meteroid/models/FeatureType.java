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
    @JsonSubTypes.Type(value = FeatureType.Boolean.class, name = "BOOLEAN"),
    @JsonSubTypes.Type(value = FeatureType.Metered.class, name = "METERED")
})
@ToString
@EqualsAndHashCode
public abstract class FeatureType {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of FeatureType to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of FeatureType from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of FeatureType
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static FeatureType fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, FeatureType.class);
    }

    // Variant classes
    /**
     * Variant: BOOLEAN
     *
     * <p>This variant wraps BooleanFeatureType.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("BOOLEAN")
    public static class Boolean extends FeatureType {
        @JsonUnwrapped private BooleanFeatureType data;

        public Boolean() {}

        public Boolean(BooleanFeatureType data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "BOOLEAN";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public BooleanFeatureType getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Boolean data(BooleanFeatureType data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: METERED
     *
     * <p>This variant wraps MeteredFeatureType.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("METERED")
    public static class Metered extends FeatureType {
        @JsonUnwrapped private MeteredFeatureType data;

        public Metered() {}

        public Metered(MeteredFeatureType data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "METERED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public MeteredFeatureType getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Metered data(MeteredFeatureType data) {
            this.data = data;
            return this;
        }
    }
}
