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
    @JsonSubTypes.Type(value = SubscriptionAddOnCustomization.Override.class, name = "OVERRIDE"),
    @JsonSubTypes.Type(
            value = SubscriptionAddOnCustomization.Parameterization.class,
            name = "PARAMETERIZATION")
})
@ToString
@EqualsAndHashCode
public abstract class SubscriptionAddOnCustomization {
    /** Get the discriminator value identifying this variant. */
    public abstract String getDiscriminator();

    /**
     * Convert an instance of SubscriptionAddOnCustomization to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of SubscriptionAddOnCustomization from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of SubscriptionAddOnCustomization
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static SubscriptionAddOnCustomization fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubscriptionAddOnCustomization.class);
    }

    // Variant classes
    /**
     * Variant: OVERRIDE
     *
     * <p>This variant wraps SubscriptionAddOnOverride.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("OVERRIDE")
    public static class Override extends SubscriptionAddOnCustomization {
        @JsonUnwrapped private SubscriptionAddOnOverride data;

        public Override() {}

        public Override(SubscriptionAddOnOverride data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "OVERRIDE";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public SubscriptionAddOnOverride getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Override data(SubscriptionAddOnOverride data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: PARAMETERIZATION
     *
     * <p>This variant wraps SubscriptionAddOnParameterization.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("PARAMETERIZATION")
    public static class Parameterization extends SubscriptionAddOnCustomization {
        @JsonUnwrapped private SubscriptionAddOnParameterization data;

        public Parameterization() {}

        public Parameterization(SubscriptionAddOnParameterization data) {
            this.data = data;
        }

        @java.lang.Override
        public String getDiscriminator() {
            return "PARAMETERIZATION";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public SubscriptionAddOnParameterization getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Parameterization data(SubscriptionAddOnParameterization data) {
            this.data = data;
            return this;
        }
    }
}
