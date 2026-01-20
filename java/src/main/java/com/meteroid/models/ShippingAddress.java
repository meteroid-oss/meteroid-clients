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
public class ShippingAddress {
    @JsonProperty private Address address;

    @JsonProperty("same_as_billing")
    private Boolean sameAsBilling;

    public ShippingAddress() {}

    public ShippingAddress address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     */
    @javax.annotation.Nullable
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ShippingAddress sameAsBilling(Boolean sameAsBilling) {
        this.sameAsBilling = sameAsBilling;
        return this;
    }

    /**
     * Get sameAsBilling
     *
     * @return sameAsBilling
     */
    @javax.annotation.Nonnull
    public Boolean getSameAsBilling() {
        return sameAsBilling;
    }

    public void setSameAsBilling(Boolean sameAsBilling) {
        this.sameAsBilling = sameAsBilling;
    }

    /**
     * Create an instance of ShippingAddress given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ShippingAddress
     * @throws JsonProcessingException if the JSON string is invalid with respect to ShippingAddress
     */
    public static ShippingAddress fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ShippingAddress.class);
    }

    /**
     * Convert an instance of ShippingAddress to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
