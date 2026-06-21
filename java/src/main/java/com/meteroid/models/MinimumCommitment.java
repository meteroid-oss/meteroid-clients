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
public class MinimumCommitment {
    @JsonProperty private String amount;
    @JsonProperty private MinimumCommitmentScope scope;

    public MinimumCommitment() {}

    public MinimumCommitment amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Decimal string in the plan currency, e.g. &quot;100.00&quot;.
     *
     * @return amount
     */
    @javax.annotation.Nonnull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public MinimumCommitment scope(MinimumCommitmentScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     */
    @javax.annotation.Nonnull
    public MinimumCommitmentScope getScope() {
        return scope;
    }

    public void setScope(MinimumCommitmentScope scope) {
        this.scope = scope;
    }

    /**
     * Create an instance of MinimumCommitment given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MinimumCommitment
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MinimumCommitment
     */
    public static MinimumCommitment fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MinimumCommitment.class);
    }

    /**
     * Convert an instance of MinimumCommitment to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
