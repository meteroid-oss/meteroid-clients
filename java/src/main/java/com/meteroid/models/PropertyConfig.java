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
import com.meteroid.internal.JsonField;
import com.meteroid.internal.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Type-specific configuration. Only the fields relevant to <code>property_type</code> are
 * interpreted.
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class PropertyConfig {
    @JsonProperty("max")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Double> max = JsonField.missing();

    @JsonProperty("max_length")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> maxLength = JsonField.missing();

    @JsonProperty("min")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Double> min = JsonField.missing();

    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<SelectOption>> options = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private PropertyConfig() {}

    private PropertyConfig(Builder builder) {
        this.max = builder.max;
        this.maxLength = builder.maxLength;
        this.min = builder.min;
        this.options = builder.options.map(Utils::copyList);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code PropertyConfig}.
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
        builder.max = max;
        builder.maxLength = maxLength;
        builder.min = min;
        builder.options = options.map(Utils::mutableList);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code max} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Double> max() {
        return max.asOptional();
    }

    /**
     * Maximum length for <code>TEXT</code>.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> maxLength() {
        return maxLength.asOptional();
    }

    /**
     * Inclusive numeric bounds for <code>NUMBER</code>.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Double> min() {
        return min.asOptional();
    }

    /**
     * Allowed choices for <code>SINGLE_SELECT</code> / <code>MULTI_SELECT</code>.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<SelectOption>> options() {
        return options.asOptional();
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
        PropertyConfig that = (PropertyConfig) o;
        return Objects.equals(max, that.max)
                && Objects.equals(maxLength, that.maxLength)
                && Objects.equals(min, that.min)
                && Objects.equals(options, that.options)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, maxLength, min, options, additionalProperties);
    }

    @Override
    public String toString() {
        return "PropertyConfig{"
                + "max="
                + max
                + ", maxLength="
                + maxLength
                + ", min="
                + min
                + ", options="
                + options
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link PropertyConfig}. */
    public static final class Builder {
        private JsonField<Double> max = JsonField.missing();
        private JsonField<Integer> maxLength = JsonField.missing();
        private JsonField<Double> min = JsonField.missing();
        private JsonField<List<SelectOption>> options = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code max} property.
         *
         * @param max the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder max(Double max) {
            this.max = JsonField.ofNullable(max);
            return this;
        }

        /**
         * Maximum length for <code>TEXT</code>.
         *
         * @param maxLength the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder maxLength(Integer maxLength) {
            this.maxLength = JsonField.ofNullable(maxLength);
            return this;
        }

        /**
         * Inclusive numeric bounds for <code>NUMBER</code>.
         *
         * @param min the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder min(Double min) {
            this.min = JsonField.ofNullable(min);
            return this;
        }

        /**
         * Allowed choices for <code>SINGLE_SELECT</code> / <code>MULTI_SELECT</code>.
         *
         * @param options the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder options(List<SelectOption> options) {
            this.options = JsonField.ofNullable(Utils.mutableList(options));
            return this;
        }

        /**
         * Adds an item to {@code options}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addOptionsItem(SelectOption item) {
            List<SelectOption> items = this.options.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.options = JsonField.ofNullable(items);
            }
            items.add(item);
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
         * The {@code PropertyConfig}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public PropertyConfig build() {
            return new PropertyConfig(this);
        }
    }

    /**
     * Parse {@code json} as {@code PropertyConfig}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PropertyConfig fromJson(String json) {
        return Utils.parse(json, PropertyConfig.class);
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
