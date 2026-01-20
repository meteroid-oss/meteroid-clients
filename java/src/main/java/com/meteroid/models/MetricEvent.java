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
public class MetricEvent {
    @JsonProperty("__flatten_metriceventdata")
    private MetricEventData flattenMetriceventdata;

    @JsonProperty private String id;
    @JsonProperty private OffsetDateTime timestamp;
    @JsonProperty private EventType type;

    public MetricEvent() {}

    public MetricEvent flattenMetriceventdata(MetricEventData flattenMetriceventdata) {
        this.flattenMetriceventdata = flattenMetriceventdata;
        return this;
    }

    /**
     * Get flattenMetriceventdata
     *
     * @return flattenMetriceventdata
     */
    @javax.annotation.Nonnull
    public MetricEventData getFlattenMetriceventdata() {
        return flattenMetriceventdata;
    }

    public void setFlattenMetriceventdata(MetricEventData flattenMetriceventdata) {
        this.flattenMetriceventdata = flattenMetriceventdata;
    }

    public MetricEvent id(String id) {
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

    public MetricEvent timestamp(OffsetDateTime timestamp) {
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

    public MetricEvent type(EventType type) {
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
     * Create an instance of MetricEvent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MetricEvent
     * @throws JsonProcessingException if the JSON string is invalid with respect to MetricEvent
     */
    public static MetricEvent fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricEvent.class);
    }

    /**
     * Convert an instance of MetricEvent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
