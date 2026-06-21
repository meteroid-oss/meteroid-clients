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
    @JsonSubTypes.Type(value = MinimumCommitmentScope.AllComponents.class, name = "all_components"),
    @JsonSubTypes.Type(value = MinimumCommitmentScope.Products.class, name = "products")
})
@ToString
@EqualsAndHashCode
public abstract class MinimumCommitmentScope {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of MinimumCommitmentScope to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of MinimumCommitmentScope from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of MinimumCommitmentScope
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static MinimumCommitmentScope fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MinimumCommitmentScope.class);
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
    public static class AllComponents extends MinimumCommitmentScope {
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
     * Variant: products
     *
     * <p>This variant wraps ProductsScope.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("products")
    public static class Products extends MinimumCommitmentScope {
        @JsonUnwrapped private ProductsScope data;

        public Products() {}

        public Products(ProductsScope data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "products";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ProductsScope getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Products data(ProductsScope data) {
            this.data = data;
            return this;
        }
    }
}
