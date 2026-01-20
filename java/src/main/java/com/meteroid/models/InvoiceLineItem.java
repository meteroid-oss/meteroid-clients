// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class InvoiceLineItem {
    @JsonProperty("amount_total")
    private Long amountTotal;

    @JsonProperty private String description;

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty private String name;
    @JsonProperty private String quantity;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("sub_line_items")
    private List<SubLineItem> subLineItems;

    @JsonProperty("tax_rate")
    private String taxRate;

    @JsonProperty("unit_price")
    private String unitPrice;

    public InvoiceLineItem() {}

    public InvoiceLineItem amountTotal(Long amountTotal) {
        this.amountTotal = amountTotal;
        return this;
    }

    /**
     * Get amountTotal
     *
     * @return amountTotal
     */
    @javax.annotation.Nonnull
    public Long getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Long amountTotal) {
        this.amountTotal = amountTotal;
    }

    public InvoiceLineItem description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     */
    @javax.annotation.Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InvoiceLineItem endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     */
    @javax.annotation.Nonnull
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public InvoiceLineItem name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InvoiceLineItem quantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     *
     * @return quantity
     */
    @javax.annotation.Nullable
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public InvoiceLineItem startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     */
    @javax.annotation.Nonnull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public InvoiceLineItem subLineItems(List<SubLineItem> subLineItems) {
        this.subLineItems = subLineItems;
        return this;
    }

    public InvoiceLineItem addSubLineItemsItem(SubLineItem subLineItemsItem) {
        if (this.subLineItems == null) {
            this.subLineItems = new ArrayList<>();
        }
        this.subLineItems.add(subLineItemsItem);

        return this;
    }

    /**
     * Get subLineItems
     *
     * @return subLineItems
     */
    @javax.annotation.Nonnull
    public List<SubLineItem> getSubLineItems() {
        return subLineItems;
    }

    public void setSubLineItems(List<SubLineItem> subLineItems) {
        this.subLineItems = subLineItems;
    }

    public InvoiceLineItem taxRate(String taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    /**
     * Get taxRate
     *
     * @return taxRate
     */
    @javax.annotation.Nonnull
    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public InvoiceLineItem unitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Get unitPrice
     *
     * @return unitPrice
     */
    @javax.annotation.Nullable
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Create an instance of InvoiceLineItem given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of InvoiceLineItem
     * @throws JsonProcessingException if the JSON string is invalid with respect to InvoiceLineItem
     */
    public static InvoiceLineItem fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, InvoiceLineItem.class);
    }

    /**
     * Convert an instance of InvoiceLineItem to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
