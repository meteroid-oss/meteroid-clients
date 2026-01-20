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
public class IngestEventsResponse {
    @JsonProperty private List<IngestFailure> failures;

    public IngestEventsResponse() {}

    public IngestEventsResponse failures(List<IngestFailure> failures) {
        this.failures = failures;
        return this;
    }

    public IngestEventsResponse addFailuresItem(IngestFailure failuresItem) {
        if (this.failures == null) {
            this.failures = new ArrayList<>();
        }
        this.failures.add(failuresItem);

        return this;
    }

    /**
     * Get failures
     *
     * @return failures
     */
    @javax.annotation.Nullable
    public List<IngestFailure> getFailures() {
        return failures;
    }

    public void setFailures(List<IngestFailure> failures) {
        this.failures = failures;
    }

    /**
     * Create an instance of IngestEventsResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IngestEventsResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     IngestEventsResponse
     */
    public static IngestEventsResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, IngestEventsResponse.class);
    }

    /**
     * Convert an instance of IngestEventsResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
