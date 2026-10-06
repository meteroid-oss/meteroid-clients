// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.Utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * One of the variants below, told apart by {@code type}. A value this version of the SDK does not
 * know parses as {@link Unrecognized}, which keeps its properties.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true,
        defaultImpl = EffectiveEntitlementValue.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = EffectiveEntitlementValue.Boolean.class, name = "BOOLEAN"),
    @JsonSubTypes.Type(value = EffectiveEntitlementValue.Metered.class, name = "METERED"),
    @JsonSubTypes.Type(value = EffectiveEntitlementValue.Config.class, name = "CONFIG")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class EffectiveEntitlementValue {

    private EffectiveEntitlementValue() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code BOOLEAN} variant.
     *
     * @return whether it is
     */
    public final boolean isBoolean() {
        return this instanceof Boolean;
    }

    /**
     * This value as the {@code BOOLEAN} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Boolean asBoolean() {
        if (this instanceof Boolean) {
            return (Boolean) this;
        }
        throw new IllegalStateException("not the BOOLEAN variant: " + type());
    }

    /**
     * Whether this is the {@code METERED} variant.
     *
     * @return whether it is
     */
    public final boolean isMetered() {
        return this instanceof Metered;
    }

    /**
     * This value as the {@code METERED} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Metered asMetered() {
        if (this instanceof Metered) {
            return (Metered) this;
        }
        throw new IllegalStateException("not the METERED variant: " + type());
    }

    /**
     * Whether this is the {@code CONFIG} variant.
     *
     * @return whether it is
     */
    public final boolean isConfig() {
        return this instanceof Config;
    }

    /**
     * This value as the {@code CONFIG} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Config asConfig() {
        if (this instanceof Config) {
            return (Config) this;
        }
        throw new IllegalStateException("not the CONFIG variant: " + type());
    }

    /**
     * Whether this is a variant this version of the SDK does not know.
     *
     * @return whether it is
     */
    public final boolean isUnrecognized() {
        return this instanceof Unrecognized;
    }

    /**
     * This value as a variant this version of the SDK does not know.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Unrecognized asUnrecognized() {
        if (this instanceof Unrecognized) {
            return (Unrecognized) this;
        }
        throw new IllegalStateException("not a known variant: " + type());
    }

    /**
     * Calls the method of {@code visitor} for this variant.
     *
     * @param <R> the result type
     * @param visitor the visitor
     * @return the result of the visitor
     */
    public abstract <R> R accept(Visitor<R> visitor);

    /**
     * A function of each variant, called by {@link #accept}.
     *
     * @param <R> the result type
     */
    public interface Visitor<R> {
        /**
         * Visits the {@code BOOLEAN} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitBoolean(BooleanEffectiveEntitlementValue value);

        /**
         * Visits the {@code METERED} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitMetered(MeteredEffectiveEntitlementValue value);

        /**
         * Visits the {@code CONFIG} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitConfig(ConfigEffectiveEntitlementValue value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown EffectiveEntitlementValue variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code EffectiveEntitlementValue}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static EffectiveEntitlementValue fromJson(String json) {
        return Utils.parse(json, EffectiveEntitlementValue.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code BOOLEAN} variant. */
    @JsonTypeName("BOOLEAN")
    public static final class Boolean extends EffectiveEntitlementValue {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private BooleanEffectiveEntitlementValue data;

        private Boolean() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Boolean(BooleanEffectiveEntitlementValue data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Boolean of(BooleanEffectiveEntitlementValue data) {
            return new Boolean(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "BOOLEAN";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public BooleanEffectiveEntitlementValue data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Boolean that = (Boolean) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Boolean{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBoolean(data);
        }
    }

    /** The {@code METERED} variant. */
    @JsonTypeName("METERED")
    public static final class Metered extends EffectiveEntitlementValue {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private MeteredEffectiveEntitlementValue data;

        private Metered() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Metered(MeteredEffectiveEntitlementValue data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Metered of(MeteredEffectiveEntitlementValue data) {
            return new Metered(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "METERED";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public MeteredEffectiveEntitlementValue data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Metered that = (Metered) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Metered{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitMetered(data);
        }
    }

    /** The {@code CONFIG} variant. */
    @JsonTypeName("CONFIG")
    public static final class Config extends EffectiveEntitlementValue {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private ConfigEffectiveEntitlementValue data;

        private Config() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Config(ConfigEffectiveEntitlementValue data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Config of(ConfigEffectiveEntitlementValue data) {
            return new Config(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "CONFIG";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public ConfigEffectiveEntitlementValue data() {
            return data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Config that = (Config) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Config{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitConfig(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends EffectiveEntitlementValue {
        @JsonProperty("type")
        private String discriminator;

        private final Map<String, JsonNode> properties = new LinkedHashMap<>();

        private Unrecognized() {}

        @Override
        @JsonProperty("type")
        public String type() {
            return discriminator;
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitUnknown(this);
        }

        /**
         * Every other property of the variant.
         *
         * @return the properties by name, unmodifiable
         */
        @JsonAnyGetter
        public Map<String, JsonNode> properties() {
            return Collections.unmodifiableMap(properties);
        }

        @JsonAnySetter
        private void putProperty(String name, JsonNode value) {
            properties.put(name, value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Unrecognized that = (Unrecognized) o;
            return Objects.equals(discriminator, that.discriminator)
                    && Objects.equals(properties, that.properties);
        }

        @Override
        public int hashCode() {
            return Objects.hash(discriminator, properties);
        }

        @Override
        public String toString() {
            return "Unrecognized{"
                    + "discriminator="
                    + discriminator
                    + ", properties="
                    + properties
                    + "}";
        }
    }
}
