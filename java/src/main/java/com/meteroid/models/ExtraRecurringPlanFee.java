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

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Extra recurring fee
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class ExtraRecurringPlanFee {
    @JsonProperty("billing_type")
    private BillingType billingType;

    @JsonProperty("cadence")
    private BillingPeriodEnum cadence;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private ExtraRecurringPlanFee() {}

    private ExtraRecurringPlanFee(Builder builder) {
        this.billingType = builder.billingType;
        this.cadence = builder.cadence;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code ExtraRecurringPlanFee}.
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
        builder.billingType = billingType;
        builder.cadence = cadence;
        builder.quantity = quantity;
        builder.unitPrice = unitPrice;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code billing_type} property.
     *
     * @return the value, never null
     */
    public BillingType billingType() {
        return Utils.required(billingType, "billing_type");
    }

    /**
     * The {@code cadence} property.
     *
     * @return the value, never null
     */
    public BillingPeriodEnum cadence() {
        return Utils.required(cadence, "cadence");
    }

    /**
     * The {@code quantity} property.
     *
     * @return the value, never null
     */
    public Integer quantity() {
        return Utils.required(quantity, "quantity");
    }

    /**
     * The {@code unit_price} property.
     *
     * @return the value, never null
     */
    public BigDecimal unitPrice() {
        return Utils.required(unitPrice, "unit_price");
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
        ExtraRecurringPlanFee that = (ExtraRecurringPlanFee) o;
        return Objects.equals(billingType, that.billingType)
                && Objects.equals(cadence, that.cadence)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(unitPrice, that.unitPrice)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingType, cadence, quantity, unitPrice, additionalProperties);
    }

    @Override
    public String toString() {
        return "ExtraRecurringPlanFee{"
                + "billingType="
                + billingType
                + ", cadence="
                + cadence
                + ", quantity="
                + quantity
                + ", unitPrice="
                + unitPrice
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link ExtraRecurringPlanFee}. */
    public static final class Builder {
        private BillingType billingType;
        private BillingPeriodEnum cadence;
        private Integer quantity;
        private BigDecimal unitPrice;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code billing_type} property.
         *
         * @param billingType the value
         * @return this builder
         */
        public Builder billingType(BillingType billingType) {
            this.billingType = billingType;
            return this;
        }

        /**
         * The {@code cadence} property.
         *
         * @param cadence the value
         * @return this builder
         */
        public Builder cadence(BillingPeriodEnum cadence) {
            this.cadence = cadence;
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
         * The {@code unit_price} property.
         *
         * @param unitPrice the value
         * @return this builder
         */
        public Builder unitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
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
         * The {@code ExtraRecurringPlanFee}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public ExtraRecurringPlanFee build() {
            Utils.checkRequired(billingType, "billing_type");
            Utils.checkRequired(cadence, "cadence");
            Utils.checkRequired(quantity, "quantity");
            Utils.checkRequired(unitPrice, "unit_price");
            return new ExtraRecurringPlanFee(this);
        }
    }

    /**
     * Parse {@code json} as {@code ExtraRecurringPlanFee}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static ExtraRecurringPlanFee fromJson(String json) {
        return Utils.parse(json, ExtraRecurringPlanFee.class);
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
