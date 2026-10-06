// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.Utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ComponentOverride {
    @JsonProperty("component_id")
    private String componentId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price_entry")
    private PriceEntry priceEntry;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ComponentOverride() {}

    private ComponentOverride(Builder builder) {
        this.componentId = builder.componentId;
        this.name = builder.name;
        this.priceEntry = builder.priceEntry;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ComponentOverride}.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder starting from this value.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.componentId = componentId;
        builder.name = name;
        builder.priceEntry = priceEntry;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code component_id} property.
     *
     * @return the value, never null
     */
    public String componentId() {
        return Utils.required(componentId, "component_id");
    }

    /**
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code price_entry} property.
     *
     * @return the value, never null
     */
    public PriceEntry priceEntry() {
        return Utils.required(priceEntry, "price_entry");
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnyGetter
    private Map<String, JsonNode> anyProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void putAnyProperty(String name, JsonNode value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComponentOverride that = (ComponentOverride) o;
        return Objects.equals(componentId, that.componentId)
                && Objects.equals(name, that.name)
                && Objects.equals(priceEntry, that.priceEntry)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentId, name, priceEntry, additionalProperties);
    }

    @Override
    public String toString() {
        return "ComponentOverride{"
                + "componentId="
                + componentId
                + ", name="
                + name
                + ", priceEntry="
                + priceEntry
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ComponentOverride}. */
    public static final class Builder {
        private String componentId;
        private String name;
        private PriceEntry priceEntry;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code component_id} property.
         *
         * @param componentId the value
         * @return this builder
         */
        public Builder componentId(String componentId) {
            this.componentId = componentId;
            return this;
        }

        /**
         * The {@code name} property.
         *
         * @param name the value
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The {@code price_entry} property.
         *
         * @param priceEntry the value
         * @return this builder
         */
        public Builder priceEntry(PriceEntry priceEntry) {
            this.priceEntry = priceEntry;
            return this;
        }

        /**
         * A property the SDK does not know, sent along.
         *
         * @param name the property name
         * @param value the JSON value
         * @return this builder
         */
        public Builder putAdditionalProperty(String name, JsonNode value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Properties the SDK does not know, sent along.
         *
         * @param additionalProperties the properties by name
         * @return this builder
         */
        public Builder putAllAdditionalProperties(Map<String, JsonNode> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        /**
         * Leaves out a property the SDK does not know.
         *
         * @param name the property name
         * @return this builder
         */
        public Builder removeAdditionalProperty(String name) {
            additionalProperties.remove(name);
            return this;
        }

        /**
         * The {@code ComponentOverride}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ComponentOverride build() {
            Utils.checkRequired(componentId, "component_id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(priceEntry, "price_entry");
            return new ComponentOverride(this);
        }
    }

    /**
     * Parse {@code json} as {@code ComponentOverride}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ComponentOverride fromJson(String json) {
        return Utils.parse(json, ComponentOverride.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }
}
