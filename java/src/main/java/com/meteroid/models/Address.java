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
public class Address {
    @JsonProperty private String city;
    @JsonProperty private String country;
    @JsonProperty private String line1;
    @JsonProperty private String line2;
    @JsonProperty private String state;

    @JsonProperty("zip_code")
    private String zipCode;

    public Address() {}

    public Address city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Get city
     *
     * @return city
     */
    @javax.annotation.Nullable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     *
     * @return country
     */
    @javax.annotation.Nullable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address line1(String line1) {
        this.line1 = line1;
        return this;
    }

    /**
     * Get line1
     *
     * @return line1
     */
    @javax.annotation.Nullable
    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public Address line2(String line2) {
        this.line2 = line2;
        return this;
    }

    /**
     * Get line2
     *
     * @return line2
     */
    @javax.annotation.Nullable
    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public Address state(String state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     */
    @javax.annotation.Nullable
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    /**
     * Get zipCode
     *
     * @return zipCode
     */
    @javax.annotation.Nullable
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Create an instance of Address given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Address
     * @throws JsonProcessingException if the JSON string is invalid with respect to Address
     */
    public static Address fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Address.class);
    }

    /**
     * Convert an instance of Address to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
