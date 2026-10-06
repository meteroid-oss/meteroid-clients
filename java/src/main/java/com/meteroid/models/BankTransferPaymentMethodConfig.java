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
public final class BankTransferPaymentMethodConfig {
    @JsonProperty("account_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> accountId = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private BankTransferPaymentMethodConfig() {}

    private BankTransferPaymentMethodConfig(Builder builder) {
        this.accountId = builder.accountId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code BankTransferPaymentMethodConfig}.
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
        builder.accountId = accountId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code account_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> accountId() {
        return accountId.asOptional();
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
        BankTransferPaymentMethodConfig that = (BankTransferPaymentMethodConfig) o;
        return Objects.equals(accountId, that.accountId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, additionalProperties);
    }

    @Override
    public String toString() {
        return "BankTransferPaymentMethodConfig{"
                + "accountId="
                + accountId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link BankTransferPaymentMethodConfig}. */
    public static final class Builder {
        private JsonField<String> accountId = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code account_id} property.
         *
         * @param accountId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder accountId(String accountId) {
            this.accountId = JsonField.ofNullable(accountId);
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
         * The {@code BankTransferPaymentMethodConfig}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public BankTransferPaymentMethodConfig build() {
            return new BankTransferPaymentMethodConfig(this);
        }
    }

    /**
     * Parse {@code json} as {@code BankTransferPaymentMethodConfig}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static BankTransferPaymentMethodConfig fromJson(String json) {
        return Utils.parse(json, BankTransferPaymentMethodConfig.class);
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
