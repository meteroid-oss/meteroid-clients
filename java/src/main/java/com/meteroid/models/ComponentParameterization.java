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
public final class ComponentParameterization {
    @JsonProperty("component_id")
    private String componentId;

    @JsonProperty("parameters")
    private ComponentParameters parameters;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ComponentParameterization() {}

    private ComponentParameterization(Builder builder) {
        this.componentId = builder.componentId;
        this.parameters = builder.parameters;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ComponentParameterization}.
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
        builder.parameters = parameters;
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
     * The {@code parameters} property.
     *
     * @return the value, never null
     */
    public ComponentParameters parameters() {
        return Utils.required(parameters, "parameters");
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
        ComponentParameterization that = (ComponentParameterization) o;
        return Objects.equals(componentId, that.componentId)
                && Objects.equals(parameters, that.parameters)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentId, parameters, additionalProperties);
    }

    @Override
    public String toString() {
        return "ComponentParameterization{"
                + "componentId="
                + componentId
                + ", parameters="
                + parameters
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ComponentParameterization}. */
    public static final class Builder {
        private String componentId;
        private ComponentParameters parameters;
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
         * The {@code parameters} property.
         *
         * @param parameters the value
         * @return this builder
         */
        public Builder parameters(ComponentParameters parameters) {
            this.parameters = parameters;
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
         * The {@code ComponentParameterization}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ComponentParameterization build() {
            Utils.checkRequired(componentId, "component_id");
            Utils.checkRequired(parameters, "parameters");
            return new ComponentParameterization(this);
        }
    }

    /**
     * Parse {@code json} as {@code ComponentParameterization}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ComponentParameterization fromJson(String json) {
        return Utils.parse(json, ComponentParameterization.class);
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
