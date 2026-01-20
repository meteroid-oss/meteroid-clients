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
public class CustomerDetails {
    @JsonProperty private String alias;

    @JsonProperty("billing_address")
    private Address billingAddress;

    @JsonProperty private String email;
    @JsonProperty private String id;
    @JsonProperty private String name;

    @JsonProperty("snapshot_at")
    private OffsetDateTime snapshotAt;

    @JsonProperty("vat_number")
    private String vatNumber;

    public CustomerDetails() {}

    public CustomerDetails alias(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * Get alias
     *
     * @return alias
     */
    @javax.annotation.Nullable
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public CustomerDetails billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * Get billingAddress
     *
     * @return billingAddress
     */
    @javax.annotation.Nullable
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public CustomerDetails email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     */
    @javax.annotation.Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerDetails id(String id) {
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

    public CustomerDetails name(String name) {
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

    public CustomerDetails snapshotAt(OffsetDateTime snapshotAt) {
        this.snapshotAt = snapshotAt;
        return this;
    }

    /**
     * Get snapshotAt
     *
     * @return snapshotAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getSnapshotAt() {
        return snapshotAt;
    }

    public void setSnapshotAt(OffsetDateTime snapshotAt) {
        this.snapshotAt = snapshotAt;
    }

    public CustomerDetails vatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    /**
     * Get vatNumber
     *
     * @return vatNumber
     */
    @javax.annotation.Nullable
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    /**
     * Create an instance of CustomerDetails given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CustomerDetails
     * @throws JsonProcessingException if the JSON string is invalid with respect to CustomerDetails
     */
    public static CustomerDetails fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CustomerDetails.class);
    }

    /**
     * Convert an instance of CustomerDetails to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
