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
public final class CreateSubscriptionAddOn {
    @JsonProperty("add_on_id")
    private String addOnId;

    @JsonProperty("customization")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<SubscriptionAddOnCustomization> customization = JsonField.missing();

    @JsonProperty("quantity")
    private Integer quantity;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateSubscriptionAddOn() {}

    private CreateSubscriptionAddOn(Builder builder) {
        this.addOnId = builder.addOnId;
        this.customization = builder.customization;
        this.quantity = builder.quantity;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateSubscriptionAddOn}.
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
        builder.addOnId = addOnId;
        builder.customization = customization;
        builder.quantity = quantity;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code add_on_id} property.
     *
     * @return the value, never null
     */
    public String addOnId() {
        return Utils.required(addOnId, "add_on_id");
    }

    /**
     * The {@code customization} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<SubscriptionAddOnCustomization> customization() {
        return customization.asOptional();
    }

    /**
     * The {@code quantity} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> quantity() {
        return Optional.ofNullable(quantity);
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
        CreateSubscriptionAddOn that = (CreateSubscriptionAddOn) o;
        return Objects.equals(addOnId, that.addOnId)
                && Objects.equals(customization, that.customization)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addOnId, customization, quantity, additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateSubscriptionAddOn{"
                + "addOnId="
                + addOnId
                + ", customization="
                + customization
                + ", quantity="
                + quantity
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateSubscriptionAddOn}. */
    public static final class Builder {
        private String addOnId;
        private JsonField<SubscriptionAddOnCustomization> customization = JsonField.missing();
        private Integer quantity;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code add_on_id} property.
         *
         * @param addOnId the value
         * @return this builder
         */
        public Builder addOnId(String addOnId) {
            this.addOnId = addOnId;
            return this;
        }

        /**
         * The {@code customization} property.
         *
         * @param customization the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder customization(SubscriptionAddOnCustomization customization) {
            this.customization = JsonField.ofNullable(customization);
            return this;
        }

        /**
         * The {@code quantity} property.
         *
         * @param quantity the value
         * @return this builder
         */
        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
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
         * The {@code CreateSubscriptionAddOn}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateSubscriptionAddOn build() {
            Utils.checkRequired(addOnId, "add_on_id");
            return new CreateSubscriptionAddOn(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateSubscriptionAddOn}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateSubscriptionAddOn fromJson(String json) {
        return Utils.parse(json, CreateSubscriptionAddOn.class);
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
