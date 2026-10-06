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

/**
 * Resets on calendar boundaries (e.g. the 1st of every month) — not tied to subscription start
 * date.
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class CalendarResetPeriod {
    @JsonProperty("interval")
    private Integer interval;

    @JsonProperty("unit")
    private CalendarUnit unit;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CalendarResetPeriod() {}

    private CalendarResetPeriod(Builder builder) {
        this.interval = builder.interval;
        this.unit = builder.unit;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CalendarResetPeriod}.
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
        builder.interval = interval;
        builder.unit = unit;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code interval} property.
     *
     * @return the value, never null
     */
    public Integer interval() {
        return Utils.required(interval, "interval");
    }

    /**
     * The {@code unit} property.
     *
     * @return the value, never null
     */
    public CalendarUnit unit() {
        return Utils.required(unit, "unit");
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
        CalendarResetPeriod that = (CalendarResetPeriod) o;
        return Objects.equals(interval, that.interval)
                && Objects.equals(unit, that.unit)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interval, unit, additionalProperties);
    }

    @Override
    public String toString() {
        return "CalendarResetPeriod{"
                + "interval="
                + interval
                + ", unit="
                + unit
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CalendarResetPeriod}. */
    public static final class Builder {
        private Integer interval;
        private CalendarUnit unit;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code interval} property.
         *
         * @param interval the value
         * @return this builder
         */
        public Builder interval(Integer interval) {
            this.interval = interval;
            return this;
        }

        /**
         * The {@code unit} property.
         *
         * @param unit the value
         * @return this builder
         */
        public Builder unit(CalendarUnit unit) {
            this.unit = unit;
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
         * The {@code CalendarResetPeriod}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CalendarResetPeriod build() {
            Utils.checkRequired(interval, "interval");
            Utils.checkRequired(unit, "unit");
            return new CalendarResetPeriod(this);
        }
    }

    /**
     * Parse {@code json} as {@code CalendarResetPeriod}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CalendarResetPeriod fromJson(String json) {
        return Utils.parse(json, CalendarResetPeriod.class);
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
