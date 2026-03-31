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
public class ExtraComponent {
    @JsonProperty private String name;

    @JsonProperty("price_entry")
    private PriceEntry priceEntry;

    @JsonProperty("product_ref")
    private ProductRef productRef;

    public ExtraComponent() {}

    public ExtraComponent name(String name) {
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

    public ExtraComponent priceEntry(PriceEntry priceEntry) {
        this.priceEntry = priceEntry;
        return this;
    }

    /**
     * Get priceEntry
     *
     * @return priceEntry
     */
    @javax.annotation.Nonnull
    public PriceEntry getPriceEntry() {
        return priceEntry;
    }

    public void setPriceEntry(PriceEntry priceEntry) {
        this.priceEntry = priceEntry;
    }

    public ExtraComponent productRef(ProductRef productRef) {
        this.productRef = productRef;
        return this;
    }

    /**
     * Get productRef
     *
     * @return productRef
     */
    @javax.annotation.Nonnull
    public ProductRef getProductRef() {
        return productRef;
    }

    public void setProductRef(ProductRef productRef) {
        this.productRef = productRef;
    }

    /**
     * Create an instance of ExtraComponent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ExtraComponent
     * @throws JsonProcessingException if the JSON string is invalid with respect to ExtraComponent
     */
    public static ExtraComponent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ExtraComponent.class);
    }

    /**
     * Convert an instance of ExtraComponent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
