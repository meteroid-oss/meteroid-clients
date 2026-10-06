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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
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
public final class InvoiceLineItem {
    @JsonProperty("amount_total")
    private Long amountTotal;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("end_date")
    private LocalDate endDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("quantity")
    private BigDecimal quantity;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("sub_line_items")
    private List<SubLineItem> subLineItems;

    @JsonProperty("tax_rate")
    private BigDecimal taxRate;

    @JsonProperty("unit_price")
    private BigDecimal unitPrice;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private InvoiceLineItem() {}

    private InvoiceLineItem(Builder builder) {
        this.amountTotal = builder.amountTotal;
        this.description = builder.description;
        this.endDate = builder.endDate;
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.startDate = builder.startDate;
        this.subLineItems = Utils.copyList(builder.subLineItems);
        this.taxRate = builder.taxRate;
        this.unitPrice = builder.unitPrice;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code InvoiceLineItem}.
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
        builder.amountTotal = amountTotal;
        builder.description = description;
        builder.endDate = endDate;
        builder.name = name;
        builder.quantity = quantity;
        builder.startDate = startDate;
        builder.subLineItems = Utils.mutableList(subLineItems);
        builder.taxRate = taxRate;
        builder.unitPrice = unitPrice;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code amount_total} property.
     *
     * @return the value, never null
     */
    public Long amountTotal() {
        return Utils.required(amountTotal, "amount_total");
    }

    /**
     * The {@code description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> description() {
        return description.asOptional();
    }

    /**
     * The {@code end_date} property.
     *
     * @return the value, never null
     */
    public LocalDate endDate() {
        return Utils.required(endDate, "end_date");
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
     * The {@code quantity} property.
     *
     * @return the value, empty when unset
     */
    public Optional<BigDecimal> quantity() {
        return Optional.ofNullable(quantity);
    }

    /**
     * The {@code start_date} property.
     *
     * @return the value, never null
     */
    public LocalDate startDate() {
        return Utils.required(startDate, "start_date");
    }

    /**
     * The {@code sub_line_items} property.
     *
     * @return the value, never null
     */
    public List<SubLineItem> subLineItems() {
        return Utils.required(subLineItems, "sub_line_items");
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
     * The {@code unit_price} property.
     *
     * @return the value, empty when unset
     */
    public Optional<BigDecimal> unitPrice() {
        return Optional.ofNullable(unitPrice);
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
        InvoiceLineItem that = (InvoiceLineItem) o;
        return Objects.equals(amountTotal, that.amountTotal)
                && Objects.equals(description, that.description)
                && Objects.equals(endDate, that.endDate)
                && Objects.equals(name, that.name)
                && Objects.equals(quantity, that.quantity)
                && Objects.equals(startDate, that.startDate)
                && Objects.equals(subLineItems, that.subLineItems)
                && Objects.equals(taxRate, that.taxRate)
                && Objects.equals(unitPrice, that.unitPrice)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                amountTotal,
                description,
                endDate,
                name,
                quantity,
                startDate,
                subLineItems,
                taxRate,
                unitPrice,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "InvoiceLineItem{"
                + "amountTotal="
                + amountTotal
                + ", description="
                + description
                + ", endDate="
                + endDate
                + ", name="
                + name
                + ", quantity="
                + quantity
                + ", startDate="
                + startDate
                + ", subLineItems="
                + subLineItems
                + ", taxRate="
                + taxRate
                + ", unitPrice="
                + unitPrice
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link InvoiceLineItem}. */
    public static final class Builder {
        private Long amountTotal;
        private JsonField<String> description = JsonField.missing();
        private LocalDate endDate;
        private String name;
        private BigDecimal quantity;
        private LocalDate startDate;
        private List<SubLineItem> subLineItems;
        private BigDecimal taxRate;
        private BigDecimal unitPrice;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code amount_total} property.
         *
         * @param amountTotal the value
         * @return this builder
         */
        public Builder amountTotal(Long amountTotal) {
            this.amountTotal = amountTotal;
            return this;
        }

        /**
         * The {@code description} property.
         *
         * @param description the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder description(String description) {
            this.description = JsonField.ofNullable(description);
            return this;
        }

        /**
         * The {@code end_date} property.
         *
         * @param endDate the value
         * @return this builder
         */
        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
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
         * The {@code quantity} property.
         *
         * @param quantity the value
         * @return this builder
         */
        public Builder quantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * The {@code start_date} property.
         *
         * @param startDate the value
         * @return this builder
         */
        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * The {@code sub_line_items} property.
         *
         * @param subLineItems the value
         * @return this builder
         */
        public Builder subLineItems(List<SubLineItem> subLineItems) {
            this.subLineItems = Utils.mutableList(subLineItems);
            return this;
        }

        /**
         * Adds an item to {@code sub_line_items}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addSubLineItemsItem(SubLineItem item) {
            if (this.subLineItems == null) {
                this.subLineItems = new ArrayList<>();
            }
            this.subLineItems.add(item);
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
         * The {@code InvoiceLineItem}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public InvoiceLineItem build() {
            Utils.checkRequired(amountTotal, "amount_total");
            Utils.checkRequired(endDate, "end_date");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(startDate, "start_date");
            Utils.checkRequired(subLineItems, "sub_line_items");
            Utils.checkRequired(taxRate, "tax_rate");
            return new InvoiceLineItem(this);
        }
    }

    /**
     * Parse {@code json} as {@code InvoiceLineItem}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static InvoiceLineItem fromJson(String json) {
        return Utils.parse(json, InvoiceLineItem.class);
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
