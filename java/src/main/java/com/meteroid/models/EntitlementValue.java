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
    @JsonSubTypes.Type(value = EntitlementValue.Boolean.class, name = "BOOLEAN"),
    @JsonSubTypes.Type(value = EntitlementValue.Metered.class, name = "METERED")
})
@ToString
@EqualsAndHashCode
public abstract class EntitlementValue {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of EntitlementValue to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of EntitlementValue from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of EntitlementValue
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static EntitlementValue fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, EntitlementValue.class);
    }

    // Variant classes
    /**
     * Variant: BOOLEAN
     *
     * <p>This variant wraps BooleanEntitlementValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("BOOLEAN")
    public static class Boolean extends EntitlementValue {
        @JsonUnwrapped private BooleanEntitlementValue data;

        public Boolean() {}

        public Boolean(BooleanEntitlementValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "BOOLEAN";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public BooleanEntitlementValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Boolean data(BooleanEntitlementValue data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: METERED
     *
     * <p>This variant wraps MeteredEntitlementValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("METERED")
    public static class Metered extends EntitlementValue {
        @JsonUnwrapped private MeteredEntitlementValue data;

        public Metered() {}

        public Metered(MeteredEntitlementValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "METERED";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public MeteredEntitlementValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Metered data(MeteredEntitlementValue data) {
            this.data = data;
            return this;
        }
    }
}
