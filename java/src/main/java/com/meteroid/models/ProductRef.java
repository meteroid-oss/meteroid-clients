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
    @JsonSubTypes.Type(value = ProductRef.Existing.class, name = "EXISTING"),
    @JsonSubTypes.Type(value = ProductRef.New.class, name = "NEW")
})
@ToString
@EqualsAndHashCode
public abstract class ProductRef {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of ProductRef to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of ProductRef from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of ProductRef
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static ProductRef fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ProductRef.class);
    }

    // Variant classes
    /**
     * Variant: EXISTING
     *
     * <p>This variant wraps ExistingProductRef.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("EXISTING")
    public static class Existing extends ProductRef {
        @JsonUnwrapped private ExistingProductRef data;

        public Existing() {}

        public Existing(ExistingProductRef data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "EXISTING";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ExistingProductRef getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Existing data(ExistingProductRef data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: NEW
     *
     * <p>This variant wraps NewProductRef.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("NEW")
    public static class New extends ProductRef {
        @JsonUnwrapped private NewProductRef data;

        public New() {}

        public New(NewProductRef data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "NEW";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public NewProductRef getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public New data(NewProductRef data) {
            this.data = data;
            return this;
        }
    }
}
