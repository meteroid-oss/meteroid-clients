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

import java.math.BigDecimal;
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
public final class TaxBreakdownItem {
    @JsonProperty("exemption_reason")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> exemptionReason = JsonField.missing();

    @JsonProperty("exemption_type")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<TaxExemptionType> exemptionType = JsonField.missing();

    @JsonProperty("name")
    private String name;

    @JsonProperty("tax_amount")
    private Long taxAmount;

    @JsonProperty("tax_rate")
    private BigDecimal taxRate;

    @JsonProperty("tax_reference")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> taxReference = JsonField.missing();

    @JsonProperty("taxable_amount")
    private Long taxableAmount;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private TaxBreakdownItem() {}

    private TaxBreakdownItem(Builder builder) {
        this.exemptionReason = builder.exemptionReason;
        this.exemptionType = builder.exemptionType;
        this.name = builder.name;
        this.taxAmount = builder.taxAmount;
        this.taxRate = builder.taxRate;
        this.taxReference = builder.taxReference;
        this.taxableAmount = builder.taxableAmount;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code TaxBreakdownItem}.
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
        builder.exemptionReason = exemptionReason;
        builder.exemptionType = exemptionType;
        builder.name = name;
        builder.taxAmount = taxAmount;
        builder.taxRate = taxRate;
        builder.taxReference = taxReference;
        builder.taxableAmount = taxableAmount;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * Free-text legal exemption mention (EU exempt/reverse-charge invoices).
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> exemptionReason() {
        return exemptionReason.asOptional();
    }

    /**
     * The {@code exemption_type} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<TaxExemptionType> exemptionType() {
        return exemptionType.asOptional();
    }

    /**
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code tax_amount} property.
     *
     * @return the value, never null
     */
    public Long taxAmount() {
        return Utils.required(taxAmount, "tax_amount");
    }

    /**
     * The {@code tax_rate} property.
     *
     * @return the value, never null
     */
    public BigDecimal taxRate() {
        return Utils.required(taxRate, "tax_rate");
    }

    /**
     * Accounting/reporting code of the tax rate for this line, for exports.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> taxReference() {
        return taxReference.asOptional();
    }

    /**
     * The {@code taxable_amount} property.
     *
     * @return the value, never null
     */
    public Long taxableAmount() {
        return Utils.required(taxableAmount, "taxable_amount");
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
        TaxBreakdownItem that = (TaxBreakdownItem) o;
        return Objects.equals(exemptionReason, that.exemptionReason)
                && Objects.equals(exemptionType, that.exemptionType)
                && Objects.equals(name, that.name)
                && Objects.equals(taxAmount, that.taxAmount)
                && Objects.equals(taxRate, that.taxRate)
                && Objects.equals(taxReference, that.taxReference)
                && Objects.equals(taxableAmount, that.taxableAmount)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                exemptionReason,
                exemptionType,
                name,
                taxAmount,
                taxRate,
                taxReference,
                taxableAmount,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "TaxBreakdownItem{"
                + "exemptionReason="
                + exemptionReason
                + ", exemptionType="
                + exemptionType
                + ", name="
                + name
                + ", taxAmount="
                + taxAmount
                + ", taxRate="
                + taxRate
                + ", taxReference="
                + taxReference
                + ", taxableAmount="
                + taxableAmount
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link TaxBreakdownItem}. */
    public static final class Builder {
        private JsonField<String> exemptionReason = JsonField.missing();
        private JsonField<TaxExemptionType> exemptionType = JsonField.missing();
        private String name;
        private Long taxAmount;
        private BigDecimal taxRate;
        private JsonField<String> taxReference = JsonField.missing();
        private Long taxableAmount;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * Free-text legal exemption mention (EU exempt/reverse-charge invoices).
         *
         * @param exemptionReason the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder exemptionReason(String exemptionReason) {
            this.exemptionReason = JsonField.ofNullable(exemptionReason);
            return this;
        }

        /**
         * The {@code exemption_type} property.
         *
         * @param exemptionType the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder exemptionType(TaxExemptionType exemptionType) {
            this.exemptionType = JsonField.ofNullable(exemptionType);
            return this;
        }

        /**
         * The {@code name} property.
         *
         * @param name the value
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The {@code tax_amount} property.
         *
         * @param taxAmount the value
         * @return this builder
         */
        public Builder taxAmount(Long taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        /**
         * The {@code tax_rate} property.
         *
         * @param taxRate the value
         * @return this builder
         */
        public Builder taxRate(BigDecimal taxRate) {
            this.taxRate = taxRate;
            return this;
        }

        /**
         * Accounting/reporting code of the tax rate for this line, for exports.
         *
         * @param taxReference the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder taxReference(String taxReference) {
            this.taxReference = JsonField.ofNullable(taxReference);
            return this;
        }

        /**
         * The {@code taxable_amount} property.
         *
         * @param taxableAmount the value
         * @return this builder
         */
        public Builder taxableAmount(Long taxableAmount) {
            this.taxableAmount = taxableAmount;
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
         * The {@code TaxBreakdownItem}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public TaxBreakdownItem build() {
            Utils.checkRequired(name, "name");
            Utils.checkRequired(taxAmount, "tax_amount");
            Utils.checkRequired(taxRate, "tax_rate");
            Utils.checkRequired(taxableAmount, "taxable_amount");
            return new TaxBreakdownItem(this);
        }
    }

    /**
     * Parse {@code json} as {@code TaxBreakdownItem}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static TaxBreakdownItem fromJson(String json) {
        return Utils.parse(json, TaxBreakdownItem.class);
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
