// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.*;

/** Online (card/direct debit), BankTransfer, or External. */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PaymentMethodsConfig.Online.class, name = "online"),
    @JsonSubTypes.Type(value = PaymentMethodsConfig.BankTransfer.class, name = "bank_transfer"),
    @JsonSubTypes.Type(value = PaymentMethodsConfig.External.class, name = "external")
})
@ToString
@EqualsAndHashCode
public abstract class PaymentMethodsConfig {
    /** Get the discriminator value identifying this variant. */
    public abstract String getType();

    /**
     * Convert an instance of PaymentMethodsConfig to a JSON string.
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }

    /**
     * Create an instance of PaymentMethodsConfig from a JSON string.
     *
     * @param jsonString JSON string
     * @return An instance of PaymentMethodsConfig
     * @throws JsonProcessingException if the JSON string is invalid
     */
    public static PaymentMethodsConfig fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PaymentMethodsConfig.class);
    }

    // Variant classes
    /**
     * Variant: online
     *
     * <p>This variant wraps OnlinePaymentMethodConfig.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("online")
    public static class Online extends PaymentMethodsConfig {
        @JsonUnwrapped private OnlinePaymentMethodConfig data;

        public Online() {}

        public Online(OnlinePaymentMethodConfig data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "online";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public OnlinePaymentMethodConfig getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public Online data(OnlinePaymentMethodConfig data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: bank_transfer
     *
     * <p>This variant wraps BankTransferPaymentMethodConfig.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("bank_transfer")
    public static class BankTransfer extends PaymentMethodsConfig {
        @JsonUnwrapped private BankTransferPaymentMethodConfig data;

        public BankTransfer() {}

        public BankTransfer(BankTransferPaymentMethodConfig data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "bank_transfer";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public BankTransferPaymentMethodConfig getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public BankTransfer data(BankTransferPaymentMethodConfig data) {
            this.data = data;
            return this;
        }
    }

    /**
     * Variant: external
     *
     * <p>This variant wraps ExternalPaymentMethodConfig.
     */
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    @JsonTypeName("external")
    public static class External extends PaymentMethodsConfig {
        @JsonUnwrapped private ExternalPaymentMethodConfig data;

        public External() {}

        public External(ExternalPaymentMethodConfig data) {
            this.data = data;
        }

        @java.lang.Override
        public String getType() {
            return "external";
        }

        /** Get the wrapped data for this variant. */
        @javax.annotation.Nonnull
        public ExternalPaymentMethodConfig getData() {
            return data;
        }

        /** Set the wrapped data for this variant. */
        public External data(ExternalPaymentMethodConfig data) {
            this.data = data;
            return this;
        }
    }
}
