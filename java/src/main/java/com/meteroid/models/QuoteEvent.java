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

import java.time.OffsetDateTime;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class QuoteEvent {
    @JsonProperty("__flatten_quoteeventdata")
    private QuoteEventData flattenQuoteeventdata;

    @JsonProperty private String id;
    @JsonProperty private OffsetDateTime timestamp;
    @JsonProperty private EventType type;

    public QuoteEvent() {}

    public QuoteEvent flattenQuoteeventdata(QuoteEventData flattenQuoteeventdata) {
        this.flattenQuoteeventdata = flattenQuoteeventdata;
        return this;
    }

    /**
     * Get flattenQuoteeventdata
     *
     * @return flattenQuoteeventdata
     */
    @javax.annotation.Nonnull
    public QuoteEventData getFlattenQuoteeventdata() {
        return flattenQuoteeventdata;
    }

    public void setFlattenQuoteeventdata(QuoteEventData flattenQuoteeventdata) {
        this.flattenQuoteeventdata = flattenQuoteeventdata;
    }

    public QuoteEvent id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuoteEvent timestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get timestamp
     *
     * @return timestamp
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public QuoteEvent type(EventType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @javax.annotation.Nonnull
    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    /**
     * Create an instance of QuoteEvent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of QuoteEvent
     * @throws JsonProcessingException if the JSON string is invalid with respect to QuoteEvent
     */
    public static QuoteEvent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, QuoteEvent.class);
    }

    /**
     * Convert an instance of QuoteEvent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
