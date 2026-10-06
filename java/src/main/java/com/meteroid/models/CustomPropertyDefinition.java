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

import java.util.Collections;
import java.util.LinkedHashMap;
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
public final class CustomPropertyDefinition {
    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("config")
    private PropertyConfig config;

    @JsonProperty("default_value")
    private Object defaultValue;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("display_order")
    private Integer displayOrder;

    @JsonProperty("entity_type")
    private CustomPropertyEntityType entityType;

    @JsonProperty("id")
    private String id;

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("property_type")
    private CustomPropertyType propertyType;

    @JsonProperty("required")
    private Boolean required;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CustomPropertyDefinition() {}

    private CustomPropertyDefinition(Builder builder) {
        this.archived = builder.archived;
        this.config = builder.config;
        this.defaultValue = builder.defaultValue;
        this.description = builder.description;
        this.displayOrder = builder.displayOrder;
        this.entityType = builder.entityType;
        this.id = builder.id;
        this.key = builder.key;
        this.name = builder.name;
        this.propertyType = builder.propertyType;
        this.required = builder.required;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CustomPropertyDefinition}.
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
        builder.archived = archived;
        builder.config = config;
        builder.defaultValue = defaultValue;
        builder.description = description;
        builder.displayOrder = displayOrder;
        builder.entityType = entityType;
        builder.id = id;
        builder.key = key;
        builder.name = name;
        builder.propertyType = propertyType;
        builder.required = required;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code archived} property.
     *
     * @return the value, never null
     */
    public Boolean archived() {
        return Utils.required(archived, "archived");
    }

    /**
     * The {@code config} property.
     *
     * @return the value, never null
     */
    public PropertyConfig config() {
        return Utils.required(config, "config");
    }

    /**
     * The {@code default_value} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Object> defaultValue() {
        return Optional.ofNullable(defaultValue);
    }

    /**
     * The {@code description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> description() {
        return description.asOptional();
    }

    /**
     * The {@code display_order} property.
     *
     * @return the value, never null
     */
    public Integer displayOrder() {
        return Utils.required(displayOrder, "display_order");
    }

    /**
     * The {@code entity_type} property.
     *
     * @return the value, never null
     */
    public CustomPropertyEntityType entityType() {
        return Utils.required(entityType, "entity_type");
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code key} property.
     *
     * @return the value, never null
     */
    public String key() {
        return Utils.required(key, "key");
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
     * The {@code property_type} property.
     *
     * @return the value, never null
     */
    public CustomPropertyType propertyType() {
        return Utils.required(propertyType, "property_type");
    }

    /**
     * The {@code required} property.
     *
     * @return the value, never null
     */
    public Boolean required() {
        return Utils.required(required, "required");
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
        CustomPropertyDefinition that = (CustomPropertyDefinition) o;
        return Objects.equals(archived, that.archived)
                && Objects.equals(config, that.config)
                && Objects.equals(defaultValue, that.defaultValue)
                && Objects.equals(description, that.description)
                && Objects.equals(displayOrder, that.displayOrder)
                && Objects.equals(entityType, that.entityType)
                && Objects.equals(id, that.id)
                && Objects.equals(key, that.key)
                && Objects.equals(name, that.name)
                && Objects.equals(propertyType, that.propertyType)
                && Objects.equals(required, that.required)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                archived,
                config,
                defaultValue,
                description,
                displayOrder,
                entityType,
                id,
                key,
                name,
                propertyType,
                required,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CustomPropertyDefinition{"
                + "archived="
                + archived
                + ", config="
                + config
                + ", defaultValue="
                + defaultValue
                + ", description="
                + description
                + ", displayOrder="
                + displayOrder
                + ", entityType="
                + entityType
                + ", id="
                + id
                + ", key="
                + key
                + ", name="
                + name
                + ", propertyType="
                + propertyType
                + ", required="
                + required
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CustomPropertyDefinition}. */
    public static final class Builder {
        private Boolean archived;
        private PropertyConfig config;
        private Object defaultValue;
        private JsonField<String> description = JsonField.missing();
        private Integer displayOrder;
        private CustomPropertyEntityType entityType;
        private String id;
        private String key;
        private String name;
        private CustomPropertyType propertyType;
        private Boolean required;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code archived} property.
         *
         * @param archived the value
         * @return this builder
         */
        public Builder archived(Boolean archived) {
            this.archived = archived;
            return this;
        }

        /**
         * The {@code config} property.
         *
         * @param config the value
         * @return this builder
         */
        public Builder config(PropertyConfig config) {
            this.config = config;
            return this;
        }

        /**
         * The {@code default_value} property.
         *
         * @param defaultValue the value
         * @return this builder
         */
        public Builder defaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        /**
         * The {@code description} property.
         *
         * @param description the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder description(String description) {
            this.description = JsonField.ofNullable(description);
            return this;
        }

        /**
         * The {@code display_order} property.
         *
         * @param displayOrder the value
         * @return this builder
         */
        public Builder displayOrder(Integer displayOrder) {
            this.displayOrder = displayOrder;
            return this;
        }

        /**
         * The {@code entity_type} property.
         *
         * @param entityType the value
         * @return this builder
         */
        public Builder entityType(CustomPropertyEntityType entityType) {
            this.entityType = entityType;
            return this;
        }

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * The {@code key} property.
         *
         * @param key the value
         * @return this builder
         */
        public Builder key(String key) {
            this.key = key;
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
         * The {@code property_type} property.
         *
         * @param propertyType the value
         * @return this builder
         */
        public Builder propertyType(CustomPropertyType propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        /**
         * The {@code required} property.
         *
         * @param required the value
         * @return this builder
         */
        public Builder required(Boolean required) {
            this.required = required;
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
         * The {@code CustomPropertyDefinition}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CustomPropertyDefinition build() {
            Utils.checkRequired(archived, "archived");
            Utils.checkRequired(config, "config");
            Utils.checkRequired(displayOrder, "display_order");
            Utils.checkRequired(entityType, "entity_type");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(key, "key");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(propertyType, "property_type");
            Utils.checkRequired(required, "required");
            return new CustomPropertyDefinition(this);
        }
    }

    /**
     * Parse {@code json} as {@code CustomPropertyDefinition}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CustomPropertyDefinition fromJson(String json) {
        return Utils.parse(json, CustomPropertyDefinition.class);
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
