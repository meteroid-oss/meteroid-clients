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
public class PercentageDiscount {
    @JsonProperty private String percentage;

    public PercentageDiscount() {}

    public PercentageDiscount percentage(String percentage) {
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
     * Create an instance of PercentageDiscount given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PercentageDiscount
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     PercentageDiscount
     */
    public static PercentageDiscount fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PercentageDiscount.class);
    }

    /**
     * Convert an instance of PercentageDiscount to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
