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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Component names — matched against <code>ReplacePlanRequest::components[].name</code>.
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ComponentsScope {
    @JsonProperty("component_names")
    private List<String> componentNames;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ComponentsScope() {}

    private ComponentsScope(Builder builder) {
        this.componentNames = Utils.copyList(builder.componentNames);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ComponentsScope}.
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
        builder.componentNames = Utils.mutableList(componentNames);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code component_names} property.
     *
     * @return the value, never null
     */
    public List<String> componentNames() {
        return Utils.required(componentNames, "component_names");
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
        ComponentsScope that = (ComponentsScope) o;
        return Objects.equals(componentNames, that.componentNames)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentNames, additionalProperties);
    }

    @Override
    public String toString() {
        return "ComponentsScope{"
                + "componentNames="
                + componentNames
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ComponentsScope}. */
    public static final class Builder {
        private List<String> componentNames;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code component_names} property.
         *
         * @param componentNames the value
         * @return this builder
         */
        public Builder componentNames(List<String> componentNames) {
            this.componentNames = Utils.mutableList(componentNames);
            return this;
        }

        /**
         * Adds an item to {@code component_names}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addComponentNamesItem(String item) {
            if (this.componentNames == null) {
                this.componentNames = new ArrayList<>();
            }
            this.componentNames.add(item);
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
         * The {@code ComponentsScope}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ComponentsScope build() {
            Utils.checkRequired(componentNames, "component_names");
            return new ComponentsScope(this);
        }
    }

    /**
     * Parse {@code json} as {@code ComponentsScope}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ComponentsScope fromJson(String json) {
        return Utils.parse(json, ComponentsScope.class);
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
