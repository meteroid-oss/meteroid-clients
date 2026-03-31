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
public class CouponPercentageDiscount {
    @JsonProperty private String percentage;

    public CouponPercentageDiscount() {}

    public CouponPercentageDiscount percentage(String percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Get percentage
     *
     * @return percentage
     */
    @javax.annotation.Nonnull
    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    /**
     * Create an instance of CouponPercentageDiscount given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CouponPercentageDiscount
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CouponPercentageDiscount
     */
    public static CouponPercentageDiscount fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CouponPercentageDiscount.class);
    }

    /**
     * Convert an instance of CouponPercentageDiscount to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
