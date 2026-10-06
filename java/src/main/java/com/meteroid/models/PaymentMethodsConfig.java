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
 * Online (card/direct debit), BankTransfer, or External.
 *
 * <p>One of the variants below, told apart by {@code type}. A value this version of the SDK does
 * not know parses as {@link Unrecognized}, which keeps its properties.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true,
        defaultImpl = PaymentMethodsConfig.Unrecognized.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = PaymentMethodsConfig.Online.class, name = "online"),
    @JsonSubTypes.Type(value = PaymentMethodsConfig.BankTransfer.class, name = "bank_transfer"),
    @JsonSubTypes.Type(value = PaymentMethodsConfig.External.class, name = "external")
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public abstract class PaymentMethodsConfig {

    private PaymentMethodsConfig() {}

    /**
     * The discriminator value identifying this variant.
     *
     * @return the {@code type} value
     */
    @JsonProperty("type")
    public abstract String type();

    /**
     * Whether this is the {@code online} variant.
     *
     * @return whether it is
     */
    public final boolean isOnline() {
        return this instanceof Online;
    }

    /**
     * This value as the {@code online} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final Online asOnline() {
        if (this instanceof Online) {
            return (Online) this;
        }
        throw new IllegalStateException("not the online variant: " + type());
    }

    /**
     * Whether this is the {@code bank_transfer} variant.
     *
     * @return whether it is
     */
    public final boolean isBankTransfer() {
        return this instanceof BankTransfer;
    }

    /**
     * This value as the {@code bank_transfer} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final BankTransfer asBankTransfer() {
        if (this instanceof BankTransfer) {
            return (BankTransfer) this;
        }
        throw new IllegalStateException("not the bank_transfer variant: " + type());
    }

    /**
     * Whether this is the {@code external} variant.
     *
     * @return whether it is
     */
    public final boolean isExternal() {
        return this instanceof External;
    }

    /**
     * This value as the {@code external} variant.
     *
     * @return the variant
     * @throws IllegalStateException if this is another variant
     */
    public final External asExternal() {
        if (this instanceof External) {
            return (External) this;
        }
        throw new IllegalStateException("not the external variant: " + type());
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
         * Visits the {@code online} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitOnline(OnlinePaymentMethodConfig value);

        /**
         * Visits the {@code bank_transfer} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitBankTransfer(BankTransferPaymentMethodConfig value);

        /**
         * Visits the {@code external} variant.
         *
         * @param value the variant
         * @return the result
         */
        R visitExternal(ExternalPaymentMethodConfig value);

        /**
         * Visits a variant this version of the SDK does not know.
         *
         * @param value the variant, with its properties
         * @return the result
         * @throws com.meteroid.exceptions.InvalidDataException unless overridden
         */
        default R visitUnknown(Unrecognized value) {
            throw new com.meteroid.exceptions.InvalidDataException(
                    "unknown PaymentMethodsConfig variant: " + value.type());
        }
    }

    /**
     * Parse {@code json} as {@code PaymentMethodsConfig}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static PaymentMethodsConfig fromJson(String json) {
        return Utils.parse(json, PaymentMethodsConfig.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }

    /** The {@code online} variant. */
    @JsonTypeName("online")
    public static final class Online extends PaymentMethodsConfig {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private OnlinePaymentMethodConfig data;

        private Online() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public Online(OnlinePaymentMethodConfig data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static Online of(OnlinePaymentMethodConfig data) {
            return new Online(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "online";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public OnlinePaymentMethodConfig data() {
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
            Online that = (Online) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "Online{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitOnline(data);
        }
    }

    /** The {@code bank_transfer} variant. */
    @JsonTypeName("bank_transfer")
    public static final class BankTransfer extends PaymentMethodsConfig {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private BankTransferPaymentMethodConfig data;

        private BankTransfer() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public BankTransfer(BankTransferPaymentMethodConfig data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static BankTransfer of(BankTransferPaymentMethodConfig data) {
            return new BankTransfer(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "bank_transfer";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public BankTransferPaymentMethodConfig data() {
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
            BankTransfer that = (BankTransfer) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "BankTransfer{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitBankTransfer(data);
        }
    }

    /** The {@code external} variant. */
    @JsonTypeName("external")
    public static final class External extends PaymentMethodsConfig {
        @JsonUnwrapped
        @JsonIgnoreProperties(value = "type", allowSetters = true)
        private ExternalPaymentMethodConfig data;

        private External() {}

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         */
        public External(ExternalPaymentMethodConfig data) {
            this.data = Objects.requireNonNull(data, "data");
        }

        /**
         * The variant holding {@code data}.
         *
         * @param data the value of the variant
         * @return the variant
         */
        public static External of(ExternalPaymentMethodConfig data) {
            return new External(data);
        }

        @Override
        @JsonProperty("type")
        public String type() {
            return "external";
        }

        /**
         * The value of the variant.
         *
         * @return the value
         */
        public ExternalPaymentMethodConfig data() {
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
            External that = (External) o;
            return Objects.equals(data, that.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public String toString() {
            return "External{" + "data=" + data + "}";
        }

        @Override
        public <R> R accept(Visitor<R> visitor) {
            return visitor.visitExternal(data);
        }
    }

    /** A variant this version of the SDK does not know. */
    public static final class Unrecognized extends PaymentMethodsConfig {
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
