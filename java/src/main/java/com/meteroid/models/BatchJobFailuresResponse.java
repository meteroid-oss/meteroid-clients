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
public class BatchJobFailuresResponse {
    @JsonProperty private List<BatchJobItemFailureResponse> data;

    @JsonProperty("total_count")
    private Long totalCount;

    public BatchJobFailuresResponse() {}

    public BatchJobFailuresResponse data(List<BatchJobItemFailureResponse> data) {
        this.data = data;
        return this;
    }

    public BatchJobFailuresResponse addDataItem(BatchJobItemFailureResponse dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);

        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @javax.annotation.Nonnull
    public List<BatchJobItemFailureResponse> getData() {
        return data;
    }

    public void setData(List<BatchJobItemFailureResponse> data) {
        this.data = data;
    }

    public BatchJobFailuresResponse totalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * Get totalCount
     *
     * @return totalCount
     */
    @javax.annotation.Nonnull
    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Create an instance of BatchJobFailuresResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BatchJobFailuresResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BatchJobFailuresResponse
     */
    public static BatchJobFailuresResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BatchJobFailuresResponse.class);
    }

    /**
     * Convert an instance of BatchJobFailuresResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
