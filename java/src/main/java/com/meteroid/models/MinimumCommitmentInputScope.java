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
    @JsonSubTypes.Type(
            value = MinimumCommitmentInputScope.AllComponents.class,
            name = "all_components"),
    @JsonSubTypes.Type(value = MinimumCommitmentInputScope.Components.class, name = "components")
})
@ToString
@EqualsAndHashCode
public abstract class MinimumCommitmentInputScope {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of MinimumCommitmentInputScope to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of MinimumCommitmentInputScope from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of MinimumCommitmentInputScope
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static MinimumCommitmentInputScope fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MinimumCommitmentInputScope.class);
    }

    // Variant classes
    /**
     * Variant: all_components
     *
     * <p>This variant wraps AllComponentsScope.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("all_components")
    public static class AllComponents extends MinimumCommitmentInputScope {
        @JsonUnwrapped private AllComponentsScope data;

        public AllComponents() {}

        public AllComponents(AllComponentsScope data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "all_components";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public AllComponentsScope getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public AllComponents data(AllComponentsScope data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: components
     *
     * <p>This variant wraps ComponentsScope.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("components")
    public static class Components extends MinimumCommitmentInputScope {
        @JsonUnwrapped private ComponentsScope data;

        public Components() {}

        public Components(ComponentsScope data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "components";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ComponentsScope getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Components data(ComponentsScope data) {
            this.data = data;
            return this;
        }
    }
}
