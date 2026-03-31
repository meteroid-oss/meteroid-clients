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
public class OnlineMethodsConfig {
    @JsonProperty private OnlineMethodConfig card;

    @JsonProperty("direct_debit")
    private OnlineMethodConfig directDebit;

    public OnlineMethodsConfig() {}

    public OnlineMethodsConfig card(OnlineMethodConfig card) {
        this.card = card;
        return this;
    }

    /**
     * Get card
     *
     * @return card
     */
    @javax.annotation.Nullable
    public OnlineMethodConfig getCard() {
        return card;
    }

    public void setCard(OnlineMethodConfig card) {
        this.card = card;
    }

    public OnlineMethodsConfig directDebit(OnlineMethodConfig directDebit) {
        this.directDebit = directDebit;
        return this;
    }

    /**
     * Get directDebit
     *
     * @return directDebit
     */
    @javax.annotation.Nullable
    public OnlineMethodConfig getDirectDebit() {
        return directDebit;
    }

    public void setDirectDebit(OnlineMethodConfig directDebit) {
        this.directDebit = directDebit;
    }

    /**
     * Create an instance of OnlineMethodsConfig given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OnlineMethodsConfig
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     OnlineMethodsConfig
     */
    public static OnlineMethodsConfig fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OnlineMethodsConfig.class);
    }

    /**
     * Convert an instance of OnlineMethodsConfig to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
