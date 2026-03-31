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
    @JsonSubTypes.Type(value = PriceEntry.Existing.class, name = "EXISTING"),
    @JsonSubTypes.Type(value = PriceEntry.New.class, name = "NEW")
})
@ToString
@EqualsAndHashCode
public abstract class PriceEntry {
    /** Get the discriminator value identifying this variant. */
    public abstract String getDiscriminator();

    /**
     * Convert an instance of PriceEntry to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of PriceEntry from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of PriceEntry
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static PriceEntry fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PriceEntry.class);
    }

    // Variant classes
    /**
     * Variant: EXISTING
     *
     * <p>This variant wraps ExistingPriceRef.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("EXISTING")
    public static class Existing extends PriceEntry {
        @JsonUnwrapped private ExistingPriceRef data;

        public Existing() {}

        public Existing(ExistingPriceRef data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "EXISTING";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ExistingPriceRef getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Existing data(ExistingPriceRef data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: NEW
     *
     * <p>This variant wraps PriceInput.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("NEW")
    public static class New extends PriceEntry {
        @JsonUnwrapped private PriceInput data;

        public New() {}

        public New(PriceInput data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "NEW";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public PriceInput getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public New data(PriceInput data) {
            this.data = data;
            return this;
        }
    }
}
