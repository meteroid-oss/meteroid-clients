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
public class IngestFailure {
    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty private String reason;

    public IngestFailure() {}

    public IngestFailure eventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    /**
     * Get eventId
     *
     * @return eventId
     */
    @javax.annotation.Nonnull
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public IngestFailure reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     */
    @javax.annotation.Nonnull
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Create an instance of IngestFailure given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IngestFailure
     * @throws JsonProcessingException if the JSON string is invalid with respect to IngestFailure
     */
    public static IngestFailure fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, IngestFailure.class);
    }

    /**
     * Convert an instance of IngestFailure to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
