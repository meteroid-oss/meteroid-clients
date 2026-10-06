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
public final class Address {
    @JsonProperty("city")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> city = JsonField.missing();

    @JsonProperty("country")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> country = JsonField.missing();

    @JsonProperty("line1")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> line1 = JsonField.missing();

    @JsonProperty("line2")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> line2 = JsonField.missing();

    @JsonProperty("state")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> state = JsonField.missing();

    @JsonProperty("zip_code")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> zipCode = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Address() {}

    private Address(Builder builder) {
        this.city = builder.city;
        this.country = builder.country;
        this.line1 = builder.line1;
        this.line2 = builder.line2;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Address}.
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
        builder.city = city;
        builder.country = country;
        builder.line1 = line1;
        builder.line2 = line2;
        builder.state = state;
        builder.zipCode = zipCode;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code city} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> city() {
        return city.asOptional();
    }

    /**
     * The {@code country} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> country() {
        return country.asOptional();
    }

    /**
     * The {@code line1} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> line1() {
        return line1.asOptional();
    }

    /**
     * The {@code line2} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> line2() {
        return line2.asOptional();
    }

    /**
     * The {@code state} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> state() {
        return state.asOptional();
    }

    /**
     * The {@code zip_code} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> zipCode() {
        return zipCode.asOptional();
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
        Address that = (Address) o;
        return Objects.equals(city, that.city)
                && Objects.equals(country, that.country)
                && Objects.equals(line1, that.line1)
                && Objects.equals(line2, that.line2)
                && Objects.equals(state, that.state)
                && Objects.equals(zipCode, that.zipCode)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country, line1, line2, state, zipCode, additionalProperties);
    }

    @Override
    public String toString() {
        return "Address{"
                + "city="
                + city
                + ", country="
                + country
                + ", line1="
                + line1
                + ", line2="
                + line2
                + ", state="
                + state
                + ", zipCode="
                + zipCode
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Address}. */
    public static final class Builder {
        private JsonField<String> city = JsonField.missing();
        private JsonField<String> country = JsonField.missing();
        private JsonField<String> line1 = JsonField.missing();
        private JsonField<String> line2 = JsonField.missing();
        private JsonField<String> state = JsonField.missing();
        private JsonField<String> zipCode = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code city} property.
         *
         * @param city the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder city(String city) {
            this.city = JsonField.ofNullable(city);
            return this;
        }

        /**
         * The {@code country} property.
         *
         * @param country the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder country(String country) {
            this.country = JsonField.ofNullable(country);
            return this;
        }

        /**
         * The {@code line1} property.
         *
         * @param line1 the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder line1(String line1) {
            this.line1 = JsonField.ofNullable(line1);
            return this;
        }

        /**
         * The {@code line2} property.
         *
         * @param line2 the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder line2(String line2) {
            this.line2 = JsonField.ofNullable(line2);
            return this;
        }

        /**
         * The {@code state} property.
         *
         * @param state the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder state(String state) {
            this.state = JsonField.ofNullable(state);
            return this;
        }

        /**
         * The {@code zip_code} property.
         *
         * @param zipCode the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder zipCode(String zipCode) {
            this.zipCode = JsonField.ofNullable(zipCode);
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
         * The {@code Address}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Address build() {
            return new Address(this);
        }
    }

    /**
     * Parse {@code json} as {@code Address}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Address fromJson(String json) {
        return Utils.parse(json, Address.class);
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
