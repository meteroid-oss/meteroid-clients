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
public class SlidingWindowResetPeriod {
    @JsonProperty private Integer interval;
    @JsonProperty private CalendarUnit unit;

    public SlidingWindowResetPeriod() {}

    public SlidingWindowResetPeriod interval(Integer interval) {
        this.interval = interval;
        return this;
    }

    /**
     * Get interval
     *
     * @return interval
     */
    @javax.annotation.Nonnull
    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public SlidingWindowResetPeriod unit(CalendarUnit unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get unit
     *
     * @return unit
     */
    @javax.annotation.Nonnull
    public CalendarUnit getUnit() {
        return unit;
    }

    public void setUnit(CalendarUnit unit) {
        this.unit = unit;
    }

    /**
     * Create an instance of SlidingWindowResetPeriod given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of SlidingWindowResetPeriod
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     SlidingWindowResetPeriod
     */
    public static SlidingWindowResetPeriod fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, SlidingWindowResetPeriod.class);
    }

    /**
     * Convert an instance of SlidingWindowResetPeriod to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
