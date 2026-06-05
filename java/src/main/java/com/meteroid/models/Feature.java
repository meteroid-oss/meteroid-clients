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

import java.time.OffsetDateTime;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Feature {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty private String description;
    @JsonProperty private Entitlement entitlement;

    @JsonProperty("feature_type")
    private FeatureType featureType;

    @JsonProperty private String id;
    @JsonProperty private String name;
    @JsonProperty private ProductRef product;
    @JsonProperty private FeatureStatus status;

    public Feature() {}

    public Feature createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Feature description(String description) {
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

    public Feature entitlement(Entitlement entitlement) {
        this.entitlement = entitlement;
        return this;
    }

    /**
     * Get entitlement
     *
     * @return entitlement
     */
    @javax.annotation.Nullable
    public Entitlement getEntitlement() {
        return entitlement;
    }

    public void setEntitlement(Entitlement entitlement) {
        this.entitlement = entitlement;
    }

    public Feature featureType(FeatureType featureType) {
        this.featureType = featureType;
        return this;
    }

    /**
     * Get featureType
     *
     * @return featureType
     */
    @javax.annotation.Nonnull
    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    public Feature id(String id) {
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

    public Feature name(String name) {
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

    public Feature product(ProductRef product) {
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

    public Feature status(FeatureStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public FeatureStatus getStatus() {
        return status;
    }

    public void setStatus(FeatureStatus status) {
        this.status = status;
    }

    /**
     * Create an instance of Feature given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Feature
     * @throws JsonProcessingException if the JSON string is invalid with respect to Feature
     */
    public static Feature fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Feature.class);
    }

    /**
     * Convert an instance of Feature to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
