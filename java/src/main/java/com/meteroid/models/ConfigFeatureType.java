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
import java.util.Optional;

/**
 * A static, typed configuration value. No metric — resolved synchronously.
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ConfigFeatureType {
    @JsonProperty("options")
    private List<String> options;

    @JsonProperty("value_type")
    private ConfigValueType valueType;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ConfigFeatureType() {}

    private ConfigFeatureType(Builder builder) {
        this.options = Utils.copyList(builder.options);
        this.valueType = builder.valueType;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ConfigFeatureType}.
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
        builder.options = Utils.mutableList(options);
        builder.valueType = valueType;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Allowed values when <code>value_type = SELECT</code>. Empty otherwise.
     *
     * @return the value, empty when unset
     */
    public Optional<List<String>> options() {
        return Optional.ofNullable(options);
    }

    /**
     * The feature's value type, fixed at creation.
     *
     * @return the value, never null
     */
    public ConfigValueType valueType() {
        return Utils.required(valueType, "value_type");
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
        ConfigFeatureType that = (ConfigFeatureType) o;
        return Objects.equals(options, that.options)
                && Objects.equals(valueType, that.valueType)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, valueType, additionalProperties);
    }

    @Override
    public String toString() {
        return "ConfigFeatureType{"
                + "options="
                + options
                + ", valueType="
                + valueType
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ConfigFeatureType}. */
    public static final class Builder {
        private List<String> options;
        private ConfigValueType valueType;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Allowed values when <code>value_type = SELECT</code>. Empty otherwise.
         *
         * @param options the value
         * @return this builder
         */
        public Builder options(List<String> options) {
            this.options = Utils.mutableList(options);
            return this;
        }

        /**
         * Adds an item to {@code options}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addOptionsItem(String item) {
            if (this.options == null) {
                this.options = new ArrayList<>();
            }
            this.options.add(item);
            return this;
        }

        /**
         * The feature's value type, fixed at creation.
         *
         * @param valueType the value
         * @return this builder
         */
        public Builder valueType(ConfigValueType valueType) {
            this.valueType = valueType;
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
         * The {@code ConfigFeatureType}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ConfigFeatureType build() {
            Utils.checkRequired(valueType, "value_type");
            return new ConfigFeatureType(this);
        }
    }

    /**
     * Parse {@code json} as {@code ConfigFeatureType}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ConfigFeatureType fromJson(String json) {
        return Utils.parse(json, ConfigFeatureType.class);
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
