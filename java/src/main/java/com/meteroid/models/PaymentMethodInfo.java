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
public final class PaymentMethodInfo {
    @JsonProperty("account_number_hint")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> accountNumberHint = JsonField.missing();

    @JsonProperty("card_brand")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cardBrand = JsonField.missing();

    @JsonProperty("card_last4")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cardLast4 = JsonField.missing();

    @JsonProperty("payment_method_type")
    private PaymentMethodTypeEnum paymentMethodType;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private PaymentMethodInfo() {}

    private PaymentMethodInfo(Builder builder) {
        this.accountNumberHint = builder.accountNumberHint;
        this.cardBrand = builder.cardBrand;
        this.cardLast4 = builder.cardLast4;
        this.paymentMethodType = builder.paymentMethodType;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code PaymentMethodInfo}.
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
        builder.accountNumberHint = accountNumberHint;
        builder.cardBrand = cardBrand;
        builder.cardLast4 = cardLast4;
        builder.paymentMethodType = paymentMethodType;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code account_number_hint} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> accountNumberHint() {
        return accountNumberHint.asOptional();
    }

    /**
     * The {@code card_brand} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> cardBrand() {
        return cardBrand.asOptional();
    }

    /**
     * The {@code card_last4} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> cardLast4() {
        return cardLast4.asOptional();
    }

    /**
     * The {@code payment_method_type} property.
     *
     * @return the value, never null
     */
    public PaymentMethodTypeEnum paymentMethodType() {
        return Utils.required(paymentMethodType, "payment_method_type");
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
        PaymentMethodInfo that = (PaymentMethodInfo) o;
        return Objects.equals(accountNumberHint, that.accountNumberHint)
                && Objects.equals(cardBrand, that.cardBrand)
                && Objects.equals(cardLast4, that.cardLast4)
                && Objects.equals(paymentMethodType, that.paymentMethodType)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                accountNumberHint, cardBrand, cardLast4, paymentMethodType, additionalProperties);
    }

    @Override
    public String toString() {
        return "PaymentMethodInfo{"
                + "accountNumberHint="
                + accountNumberHint
                + ", cardBrand="
                + cardBrand
                + ", cardLast4="
                + cardLast4
                + ", paymentMethodType="
                + paymentMethodType
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link PaymentMethodInfo}. */
    public static final class Builder {
        private JsonField<String> accountNumberHint = JsonField.missing();
        private JsonField<String> cardBrand = JsonField.missing();
        private JsonField<String> cardLast4 = JsonField.missing();
        private PaymentMethodTypeEnum paymentMethodType;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code account_number_hint} property.
         *
         * @param accountNumberHint the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder accountNumberHint(String accountNumberHint) {
            this.accountNumberHint = JsonField.ofNullable(accountNumberHint);
            return this;
        }

        /**
         * The {@code card_brand} property.
         *
         * @param cardBrand the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder cardBrand(String cardBrand) {
            this.cardBrand = JsonField.ofNullable(cardBrand);
            return this;
        }

        /**
         * The {@code card_last4} property.
         *
         * @param cardLast4 the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder cardLast4(String cardLast4) {
            this.cardLast4 = JsonField.ofNullable(cardLast4);
            return this;
        }

        /**
         * The {@code payment_method_type} property.
         *
         * @param paymentMethodType the value
         * @return this builder
         */
        public Builder paymentMethodType(PaymentMethodTypeEnum paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
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
         * The {@code PaymentMethodInfo}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public PaymentMethodInfo build() {
            Utils.checkRequired(paymentMethodType, "payment_method_type");
            return new PaymentMethodInfo(this);
        }
    }

    /**
     * Parse {@code json} as {@code PaymentMethodInfo}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PaymentMethodInfo fromJson(String json) {
        return Utils.parse(json, PaymentMethodInfo.class);
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
