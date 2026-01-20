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

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class IngestEventsRequest {
    @JsonProperty("allow_backfilling")
    private Boolean allowBackfilling;

    @JsonProperty private List<Event> events;

    public IngestEventsRequest() {}

    public IngestEventsRequest allowBackfilling(Boolean allowBackfilling) {
        this.allowBackfilling = allowBackfilling;
        return this;
    }

    /**
     * allow ingesting events with timestamps more than a day in the past
     *
     * @return allowBackfilling
     */
    @javax.annotation.Nullable
    public Boolean getAllowBackfilling() {
        return allowBackfilling;
    }

    public void setAllowBackfilling(Boolean allowBackfilling) {
        this.allowBackfilling = allowBackfilling;
    }

    public IngestEventsRequest events(List<Event> events) {
        this.events = events;
        return this;
    }

    public IngestEventsRequest addEventsItem(Event eventsItem) {
        if (this.events == null) {
            this.events = new ArrayList<>();
        }
        this.events.add(eventsItem);

        return this;
    }

    /**
     * Get events
     *
     * @return events
     */
    @javax.annotation.Nonnull
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * Create an instance of IngestEventsRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IngestEventsRequest
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     IngestEventsRequest
     */
    public static IngestEventsRequest fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, IngestEventsRequest.class);
    }

    /**
     * Convert an instance of IngestEventsRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
