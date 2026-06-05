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
public class FeatureRef {
    @JsonProperty private String id;
    @JsonProperty private String name;
    @JsonProperty private ProductRef product;

    public FeatureRef() {}

    public FeatureRef id(String id) {
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

    public FeatureRef name(String name) {
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

    public FeatureRef product(ProductRef product) {
        this.product = product;
        return this;
    }

    /**
     * Get product
     *
     * @return product
     */
    @javax.annotation.Nullable
    public ProductRef getProduct() {
        return product;
    }

    public void setProduct(ProductRef product) {
        this.product = product;
    }

    /**
     * Create an instance of FeatureRef given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of FeatureRef
     * @throws JsonProcessingException if the JSON string is invalid with respect to FeatureRef
     */
    public static FeatureRef fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, FeatureRef.class);
    }

    /**
     * Convert an instance of FeatureRef to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
