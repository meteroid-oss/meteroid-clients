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

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class SubLineItem {
    @JsonProperty private String id;
    @JsonProperty private String name;
    @JsonProperty private String quantity;
    @JsonProperty private Long total;

    @JsonProperty("unit_price")
    private String unitPrice;

    public SubLineItem() {}

    public SubLineItem id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubLineItem name(String name) {
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

    public SubLineItem quantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     *
     * @return quantity
     */
    @javax.annotation.Nonnull
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public SubLineItem total(Long total) {
        this.total = total;
        return this;
    }

    /**
     * Get total
     *
     * @return total
     */
    @javax.annotation.Nonnull
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public SubLineItem unitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    /**
     * Get unitPrice
     *
     * @return unitPrice
     */
    @javax.annotation.Nonnull
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Create an instance of SubLineItem given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SubLineItem
     * @throws JsonProcessingException if the JSON string is invalid with respect to SubLineItem
     */
    public static SubLineItem fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SubLineItem.class);
    }

    /**
     * Convert an instance of SubLineItem to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
