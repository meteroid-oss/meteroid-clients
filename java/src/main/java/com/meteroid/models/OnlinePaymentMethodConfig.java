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
public class OnlinePaymentMethodConfig {
    @JsonProperty private OnlineMethodsConfig config;

    public OnlinePaymentMethodConfig() {}

    public OnlinePaymentMethodConfig config(OnlineMethodsConfig config) {
        this.config = config;
        return this;
    }

    /**
     * Get config
     *
     * @return config
     */
    @javax.annotation.Nullable
    public OnlineMethodsConfig getConfig() {
        return config;
    }

    public void setConfig(OnlineMethodsConfig config) {
        this.config = config;
    }

    /**
     * Create an instance of OnlinePaymentMethodConfig given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of OnlinePaymentMethodConfig
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     OnlinePaymentMethodConfig
     */
    public static OnlinePaymentMethodConfig fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, OnlinePaymentMethodConfig.class);
    }

    /**
     * Convert an instance of OnlinePaymentMethodConfig to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
