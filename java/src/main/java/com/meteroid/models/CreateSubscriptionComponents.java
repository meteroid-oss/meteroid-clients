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

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class CreateSubscriptionComponents {
    @JsonProperty("extra_components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<ExtraComponent>> extraComponents = JsonField.missing();

    @JsonProperty("overridden_components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<ComponentOverride>> overriddenComponents = JsonField.missing();

    @JsonProperty("parameterized_components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<ComponentParameterization>> parameterizedComponents =
            JsonField.missing();

    @JsonProperty("remove_components")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<String>> removeComponents = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateSubscriptionComponents() {}

    private CreateSubscriptionComponents(Builder builder) {
        this.extraComponents = builder.extraComponents.map(Utils::copyList);
        this.overriddenComponents = builder.overriddenComponents.map(Utils::copyList);
        this.parameterizedComponents = builder.parameterizedComponents.map(Utils::copyList);
        this.removeComponents = builder.removeComponents.map(Utils::copyList);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateSubscriptionComponents}.
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
        builder.extraComponents = extraComponents.map(Utils::mutableList);
        builder.overriddenComponents = overriddenComponents.map(Utils::mutableList);
        builder.parameterizedComponents = parameterizedComponents.map(Utils::mutableList);
        builder.removeComponents = removeComponents.map(Utils::mutableList);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code extra_components} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<ExtraComponent>> extraComponents() {
        return extraComponents.asOptional();
    }

    /**
     * The {@code overridden_components} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<ComponentOverride>> overriddenComponents() {
        return overriddenComponents.asOptional();
    }

    /**
     * The {@code parameterized_components} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<ComponentParameterization>> parameterizedComponents() {
        return parameterizedComponents.asOptional();
    }

    /**
     * The {@code remove_components} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<String>> removeComponents() {
        return removeComponents.asOptional();
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
        CreateSubscriptionComponents that = (CreateSubscriptionComponents) o;
        return Objects.equals(extraComponents, that.extraComponents)
                && Objects.equals(overriddenComponents, that.overriddenComponents)
                && Objects.equals(parameterizedComponents, that.parameterizedComponents)
                && Objects.equals(removeComponents, that.removeComponents)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                extraComponents,
                overriddenComponents,
                parameterizedComponents,
                removeComponents,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateSubscriptionComponents{"
                + "extraComponents="
                + extraComponents
                + ", overriddenComponents="
                + overriddenComponents
                + ", parameterizedComponents="
                + parameterizedComponents
                + ", removeComponents="
                + removeComponents
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateSubscriptionComponents}. */
    public static final class Builder {
        private JsonField<List<ExtraComponent>> extraComponents = JsonField.missing();
        private JsonField<List<ComponentOverride>> overriddenComponents = JsonField.missing();
        private JsonField<List<ComponentParameterization>> parameterizedComponents =
                JsonField.missing();
        private JsonField<List<String>> removeComponents = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code extra_components} property.
         *
         * @param extraComponents the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder extraComponents(List<ExtraComponent> extraComponents) {
            this.extraComponents = JsonField.ofNullable(Utils.mutableList(extraComponents));
            return this;
        }

        /**
         * Adds an item to {@code extra_components}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addExtraComponentsItem(ExtraComponent item) {
            List<ExtraComponent> items = this.extraComponents.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.extraComponents = JsonField.ofNullable(items);
            }
            items.add(item);
            return this;
        }

        /**
         * The {@code overridden_components} property.
         *
         * @param overriddenComponents the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder overriddenComponents(List<ComponentOverride> overriddenComponents) {
            this.overriddenComponents =
                    JsonField.ofNullable(Utils.mutableList(overriddenComponents));
            return this;
        }

        /**
         * Adds an item to {@code overridden_components}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addOverriddenComponentsItem(ComponentOverride item) {
            List<ComponentOverride> items = this.overriddenComponents.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.overriddenComponents = JsonField.ofNullable(items);
            }
            items.add(item);
            return this;
        }

        /**
         * The {@code parameterized_components} property.
         *
         * @param parameterizedComponents the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder parameterizedComponents(
                List<ComponentParameterization> parameterizedComponents) {
            this.parameterizedComponents =
                    JsonField.ofNullable(Utils.mutableList(parameterizedComponents));
            return this;
        }

        /**
         * Adds an item to {@code parameterized_components}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addParameterizedComponentsItem(ComponentParameterization item) {
            List<ComponentParameterization> items = this.parameterizedComponents.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.parameterizedComponents = JsonField.ofNullable(items);
            }
            items.add(item);
            return this;
        }

        /**
         * The {@code remove_components} property.
         *
         * @param removeComponents the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder removeComponents(List<String> removeComponents) {
            this.removeComponents = JsonField.ofNullable(Utils.mutableList(removeComponents));
            return this;
        }

        /**
         * Adds an item to {@code remove_components}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addRemoveComponentsItem(String item) {
            List<String> items = this.removeComponents.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.removeComponents = JsonField.ofNullable(items);
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
         * The {@code CreateSubscriptionComponents}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateSubscriptionComponents build() {
            return new CreateSubscriptionComponents(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateSubscriptionComponents}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateSubscriptionComponents fromJson(String json) {
        return Utils.parse(json, CreateSubscriptionComponents.class);
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
