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
public class MinimumCommitmentInput {
    @JsonProperty private String amount;
    @JsonProperty private MinimumCommitmentInputScope scope;

    public MinimumCommitmentInput() {}

    public MinimumCommitmentInput amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Decimal string in the plan currency.
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

    public MinimumCommitmentInput scope(MinimumCommitmentInputScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     */
    @javax.annotation.Nonnull
    public MinimumCommitmentInputScope getScope() {
        return scope;
    }

    public void setScope(MinimumCommitmentInputScope scope) {
        this.scope = scope;
    }

    /**
     * Create an instance of MinimumCommitmentInput given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MinimumCommitmentInput
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MinimumCommitmentInput
     */
    public static MinimumCommitmentInput fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MinimumCommitmentInput.class);
    }

    /**
     * Convert an instance of MinimumCommitmentInput to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
