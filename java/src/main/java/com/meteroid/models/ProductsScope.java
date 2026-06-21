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
public class ProductsScope {
    @JsonProperty("product_ids")
    private List<String> productIds;

    public ProductsScope() {}

    public ProductsScope productIds(List<String> productIds) {
        this.productIds = productIds;
        return this;
    }

    public ProductsScope addProductIdsItem(String productIdsItem) {
        if (this.productIds == null) {
            this.productIds = new ArrayList<>();
        }
        this.productIds.add(productIdsItem);

        return this;
    }

    /**
     * Get productIds
     *
     * @return productIds
     */
    @javax.annotation.Nonnull
    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    /**
     * Create an instance of ProductsScope given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ProductsScope
     * @throws JsonProcessingException if the JSON string is invalid with respect to ProductsScope
     */
    public static ProductsScope fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ProductsScope.class);
    }

    /**
     * Convert an instance of ProductsScope to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
