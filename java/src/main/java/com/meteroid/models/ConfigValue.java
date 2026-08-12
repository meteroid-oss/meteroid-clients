// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.*;

/**
 * A static, typed configuration value carried by a Config entitlement. Resolved synchronously
 * through the entitlement hierarchy — no metric, no usage counter.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "kind",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ConfigValue.Number.class, name = "NUMBER"),
    @JsonSubTypes.Type(value = ConfigValue.Boolean.class, name = "BOOLEAN"),
    @JsonSubTypes.Type(value = ConfigValue.Text.class, name = "TEXT"),
    @JsonSubTypes.Type(value = ConfigValue.Json.class, name = "JSON")
})
@ToString
@EqualsAndHashCode
public abstract class ConfigValue {
    /** Get the discriminator value identifying this variant. */
    public abstract String getKind();

    /**
     * Convert an instance of ConfigValue to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of ConfigValue from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of ConfigValue
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static ConfigValue fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ConfigValue.class);
    }

    // Variant classes
    /**
     * Variant: NUMBER
     *
     * <p>This variant wraps NumberConfigValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("NUMBER")
    public static class Number extends ConfigValue {
        @JsonUnwrapped private NumberConfigValue data;

        public Number() {}

        public Number(NumberConfigValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getKind() {
            return "NUMBER";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public NumberConfigValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Number data(NumberConfigValue data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: BOOLEAN
     *
     * <p>This variant wraps BooleanConfigValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("BOOLEAN")
    public static class Boolean extends ConfigValue {
        @JsonUnwrapped private BooleanConfigValue data;

        public Boolean() {}

        public Boolean(BooleanConfigValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getKind() {
            return "BOOLEAN";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public BooleanConfigValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Boolean data(BooleanConfigValue data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: TEXT
     *
     * <p>This variant wraps TextConfigValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("TEXT")
    public static class Text extends ConfigValue {
        @JsonUnwrapped private TextConfigValue data;

        public Text() {}

        public Text(TextConfigValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getKind() {
            return "TEXT";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public TextConfigValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Text data(TextConfigValue data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: JSON
     *
     * <p>This variant wraps JsonConfigValue.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("JSON")
    public static class Json extends ConfigValue {
        @JsonUnwrapped private JsonConfigValue data;

        public Json() {}

        public Json(JsonConfigValue data) {
            this.data = data;
        }

        @java.lang.Override
        public String getKind() {
            return "JSON";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public JsonConfigValue getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Json data(JsonConfigValue data) {
            this.data = data;
            return this;
        }
    }
}
