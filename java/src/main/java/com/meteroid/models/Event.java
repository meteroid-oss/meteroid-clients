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

import java.util.HashMap;
import java.util.Map;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Event {
    @JsonProperty private String code;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty private Map<String, String> properties;
    @JsonProperty private String timestamp;

    public Event() {}

    public Event code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     */
    @javax.annotation.Nonnull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Event customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Either Meteroid's customer_id or an alias
     *
     * @return customerId
     */
    @javax.annotation.Nonnull
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Event eventId(String eventId) {
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

    public Event properties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

    public Event putPropertiesItem(String key, String propertiesItem) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, propertiesItem);

        return this;
    }

    /**
     * Get properties
     *
     * @return properties
     */
    @javax.annotation.Nullable
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Event timestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get timestamp
     *
     * @return timestamp
     */
    @javax.annotation.Nonnull
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Create an instance of Event given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Event
     * @throws JsonProcessingException if the JSON string is invalid with respect to Event
     */
    public static Event fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Event.class);
    }

    /**
     * Convert an instance of Event to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
