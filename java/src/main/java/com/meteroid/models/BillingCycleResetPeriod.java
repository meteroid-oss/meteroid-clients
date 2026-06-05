// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class BillingCycleResetPeriod {
    public BillingCycleResetPeriod() {}

    /**
     * Create an instance of BillingCycleResetPeriod given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BillingCycleResetPeriod
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BillingCycleResetPeriod
     */
    public static BillingCycleResetPeriod fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BillingCycleResetPeriod.class);
    }

    /**
     * Convert an instance of BillingCycleResetPeriod to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
