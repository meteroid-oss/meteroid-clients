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
    @JsonSubTypes.Type(value = ResolvedEntitlementValue.Boolean.class, name = "BOOLEAN"),
    @JsonSubTypes.Type(value = ResolvedEntitlementValue.Metered.class, name = "METERED")
})
@ToString
@EqualsAndHashCode
public abstract class ResolvedEntitlementValue {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of ResolvedEntitlementValue to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of ResolvedEntitlementValue from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of ResolvedEntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static ResolvedEntitlementValue fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ResolvedEntitlementValue.class);
    }

    // Variant classes
    /**
     * Variant: BOOLEAN
     *
     * <p>This variant wraps BooleanResolvedEntitlementValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("BOOLEAN")
    public static class Boolean extends ResolvedEntitlementValue {
        @JsonUnwrapped private BooleanResolvedEntitlementValue data;

        public Boolean() {}

        public Boolean(BooleanResolvedEntitlementValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "BOOLEAN";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public BooleanResolvedEntitlementValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Boolean data(BooleanResolvedEntitlementValue data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: METERED
     *
     * <p>This variant wraps MeteredResolvedEntitlementValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("METERED")
    public static class Metered extends ResolvedEntitlementValue {
        @JsonUnwrapped private MeteredResolvedEntitlementValue data;

        public Metered() {}

        public Metered(MeteredResolvedEntitlementValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "METERED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public MeteredResolvedEntitlementValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Metered data(MeteredResolvedEntitlementValue data) {
            this.data = data;
            return this;
        }
    }
}
