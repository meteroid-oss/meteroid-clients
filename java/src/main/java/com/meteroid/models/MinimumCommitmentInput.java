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
public final class MinimumCommitmentInput {
    @JsonProperty("amount")
    private String amount;

    @JsonProperty("scope")
    private MinimumCommitmentInputScope scope;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private MinimumCommitmentInput() {}

    private MinimumCommitmentInput(Builder builder) {
        this.amount = builder.amount;
        this.scope = builder.scope;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code MinimumCommitmentInput}.
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
        builder.amount = amount;
        builder.scope = scope;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Decimal string in the plan currency.
     *
     * @return the value, never null
     */
    public String amount() {
        return Utils.required(amount, "amount");
    }

    /**
     * The {@code scope} property.
     *
     * @return the value, never null
     */
    public MinimumCommitmentInputScope scope() {
        return Utils.required(scope, "scope");
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
        MinimumCommitmentInput that = (MinimumCommitmentInput) o;
        return Objects.equals(amount, that.amount)
                && Objects.equals(scope, that.scope)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, scope, additionalProperties);
    }

    @Override
    public String toString() {
        return "MinimumCommitmentInput{"
                + "amount="
                + amount
                + ", scope="
                + scope
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link MinimumCommitmentInput}. */
    public static final class Builder {
        private String amount;
        private MinimumCommitmentInputScope scope;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Decimal string in the plan currency.
         *
         * @param amount the value
         * @return this builder
         */
        public Builder amount(String amount) {
            this.amount = amount;
            return this;
        }

        /**
         * The {@code scope} property.
         *
         * @param scope the value
         * @return this builder
         */
        public Builder scope(MinimumCommitmentInputScope scope) {
            this.scope = scope;
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
         * The {@code MinimumCommitmentInput}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public MinimumCommitmentInput build() {
            Utils.checkRequired(amount, "amount");
            Utils.checkRequired(scope, "scope");
            return new MinimumCommitmentInput(this);
        }
    }

    /**
     * Parse {@code json} as {@code MinimumCommitmentInput}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static MinimumCommitmentInput fromJson(String json) {
        return Utils.parse(json, MinimumCommitmentInput.class);
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
