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
public class ExtraRecurringFeeStructure {
    @JsonProperty("billing_type")
    private ExtraRecurringBillingTypeEnum billingType;

    public ExtraRecurringFeeStructure() {}

    public ExtraRecurringFeeStructure billingType(ExtraRecurringBillingTypeEnum billingType) {
        this.billingType = billingType;
        return this;
    }

    /**
     * Get billingType
     *
     * @return billingType
     */
    @javax.annotation.Nonnull
    public ExtraRecurringBillingTypeEnum getBillingType() {
        return billingType;
    }

    public void setBillingType(ExtraRecurringBillingTypeEnum billingType) {
        this.billingType = billingType;
    }

    /**
     * Create an instance of ExtraRecurringFeeStructure given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ExtraRecurringFeeStructure
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     ExtraRecurringFeeStructure
     */
    public static ExtraRecurringFeeStructure fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ExtraRecurringFeeStructure.class);
    }

    /**
     * Convert an instance of ExtraRecurringFeeStructure to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
