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
public class ProductEvent {
    @JsonProperty("__flatten_producteventdata")
    private ProductEventData flattenProducteventdata;

    @JsonProperty private String id;
    @JsonProperty private OffsetDateTime timestamp;
    @JsonProperty private EventType type;

    public ProductEvent() {}

    public ProductEvent flattenProducteventdata(ProductEventData flattenProducteventdata) {
        this.flattenProducteventdata = flattenProducteventdata;
        return this;
    }

    /**
     * Get flattenProducteventdata
     *
     * @return flattenProducteventdata
     */
    @javax.annotation.Nonnull
    public ProductEventData getFlattenProducteventdata() {
        return flattenProducteventdata;
    }

    public void setFlattenProducteventdata(ProductEventData flattenProducteventdata) {
        this.flattenProducteventdata = flattenProducteventdata;
    }

    public ProductEvent id(String id) {
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

    public ProductEvent timestamp(OffsetDateTime timestamp) {
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

    public ProductEvent type(EventType type) {
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
     * Create an instance of ProductEvent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ProductEvent
     * @throws JsonProcessingException if the JSON string is invalid with respect to ProductEvent
     */
    public static ProductEvent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, ProductEvent.class);
    }

    /**
     * Convert an instance of ProductEvent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
