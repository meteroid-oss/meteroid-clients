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
public class CreditNoteCustomPropertiesRequest {
    @JsonProperty("custom_properties")
    private Object customProperties;

    public CreditNoteCustomPropertiesRequest() {}

    public CreditNoteCustomPropertiesRequest customProperties(Object customProperties) {
        this.customProperties = customProperties;
        return this;
    }

    /**
     * Get customProperties
     *
     * @return customProperties
     */
    @javax.annotation.Nonnull
    public Object getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Object customProperties) {
        this.customProperties = customProperties;
    }

    /**
     * Create an instance of CreditNoteCustomPropertiesRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CreditNoteCustomPropertiesRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CreditNoteCustomPropertiesRequest
     */
    public static CreditNoteCustomPropertiesRequest fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper()
                .readValue(jsonString, CreditNoteCustomPropertiesRequest.class);
    }

    /**
     * Convert an instance of CreditNoteCustomPropertiesRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
