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
    @JsonSubTypes.Type(value = EffectiveEntitlementValue.Boolean.class, name = "BOOLEAN"),
    @JsonSubTypes.Type(value = EffectiveEntitlementValue.Metered.class, name = "METERED")
})
@ToString
@EqualsAndHashCode
public abstract class EffectiveEntitlementValue {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of EffectiveEntitlementValue to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of EffectiveEntitlementValue from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of EffectiveEntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static EffectiveEntitlementValue fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, EffectiveEntitlementValue.class);
    }

    // Variant classes
    /**
     * Variant: BOOLEAN
     *
     * <p>This variant wraps BooleanEffectiveEntitlementValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("BOOLEAN")
    public static class Boolean extends EffectiveEntitlementValue {
        @JsonUnwrapped private BooleanEffectiveEntitlementValue data;

        public Boolean() {}

        public Boolean(BooleanEffectiveEntitlementValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "BOOLEAN";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public BooleanEffectiveEntitlementValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Boolean data(BooleanEffectiveEntitlementValue data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: METERED
     *
     * <p>This variant wraps MeteredEffectiveEntitlementValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("METERED")
    public static class Metered extends EffectiveEntitlementValue {
        @JsonUnwrapped private MeteredEffectiveEntitlementValue data;

        public Metered() {}

        public Metered(MeteredEffectiveEntitlementValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "METERED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public MeteredEffectiveEntitlementValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Metered data(MeteredEffectiveEntitlementValue data) {
            this.data = data;
            return this;
        }
    }
}
