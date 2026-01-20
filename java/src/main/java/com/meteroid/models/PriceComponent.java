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
public class PriceComponent {
    @JsonProperty private Fee fee;
    @JsonProperty private String id;
    @JsonProperty private String name;

    @JsonProperty("product_id")
    private String productId;

    public PriceComponent() {}

    public PriceComponent fee(Fee fee) {
        this.fee = fee;
        return this;
    }

    /**
     * Get fee
     *
     * @return fee
     */
    @javax.annotation.Nonnull
    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public PriceComponent id(String id) {
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

    public PriceComponent name(String name) {
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

    public PriceComponent productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Get productId
     *
     * @return productId
     */
    @javax.annotation.Nullable
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Create an instance of PriceComponent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PriceComponent
     * @throws JsonProcessingException if the JSON string is invalid with respect to PriceComponent
     */
    public static PriceComponent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PriceComponent.class);
    }

    /**
     * Convert an instance of PriceComponent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
