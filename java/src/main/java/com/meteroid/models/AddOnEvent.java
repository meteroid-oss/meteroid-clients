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
public class AddOnEvent {
    @JsonProperty("__flatten_addoneventdata")
    private AddOnEventData flattenAddoneventdata;

    @JsonProperty private String id;
    @JsonProperty private OffsetDateTime timestamp;
    @JsonProperty private EventType type;

    public AddOnEvent() {}

    public AddOnEvent flattenAddoneventdata(AddOnEventData flattenAddoneventdata) {
        this.flattenAddoneventdata = flattenAddoneventdata;
        return this;
    }

    /**
     * Get flattenAddoneventdata
     *
     * @return flattenAddoneventdata
     */
    @javax.annotation.Nonnull
    public AddOnEventData getFlattenAddoneventdata() {
        return flattenAddoneventdata;
    }

    public void setFlattenAddoneventdata(AddOnEventData flattenAddoneventdata) {
        this.flattenAddoneventdata = flattenAddoneventdata;
    }

    public AddOnEvent id(String id) {
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

    public AddOnEvent timestamp(OffsetDateTime timestamp) {
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

    public AddOnEvent type(EventType type) {
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
     * Create an instance of AddOnEvent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AddOnEvent
     * @throws JsonProcessingException if the JSON string is invalid with respect to AddOnEvent
     */
    public static AddOnEvent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, AddOnEvent.class);
    }

    /**
     * Convert an instance of AddOnEvent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
