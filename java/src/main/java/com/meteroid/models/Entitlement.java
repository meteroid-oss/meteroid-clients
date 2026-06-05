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
public class Entitlement {
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("feature_id")
    private String featureId;

    @JsonProperty private String id;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    @JsonProperty private EntitlementValue value;

    public Entitlement() {}

    public Entitlement createdAt(OffsetDateTime createdAt) {
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

    public Entitlement featureId(String featureId) {
        this.featureId = featureId;
        return this;
    }

    /**
     * Get featureId
     *
     * @return featureId
     */
    @javax.annotation.Nonnull
    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public Entitlement id(String id) {
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

    public Entitlement updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Entitlement value(EntitlementValue value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     */
    @javax.annotation.Nonnull
    public EntitlementValue getValue() {
        return value;
    }

    public void setValue(EntitlementValue value) {
        this.value = value;
    }

    /**
     * Create an instance of Entitlement given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Entitlement
     * @throws JsonProcessingException if the JSON string is invalid with respect to Entitlement
     */
    public static Entitlement fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Entitlement.class);
    }

    /**
     * Convert an instance of Entitlement to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
