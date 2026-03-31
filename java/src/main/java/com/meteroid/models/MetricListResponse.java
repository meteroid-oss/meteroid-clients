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
public class MetricListResponse {
    @JsonProperty private List<MetricSummary> data;

    @JsonProperty("pagination_meta")
    private PaginationResponse paginationMeta;

    public MetricListResponse() {}

    public MetricListResponse data(List<MetricSummary> data) {
        this.data = data;
        return this;
    }

    public MetricListResponse addDataItem(MetricSummary dataItem) {
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
    public List<MetricSummary> getData() {
        return data;
    }

    public void setData(List<MetricSummary> data) {
        this.data = data;
    }

    public MetricListResponse paginationMeta(PaginationResponse paginationMeta) {
        this.paginationMeta = paginationMeta;
        return this;
    }

    /**
     * Get paginationMeta
     *
     * @return paginationMeta
     */
    @javax.annotation.Nonnull
    public PaginationResponse getPaginationMeta() {
        return paginationMeta;
    }

    public void setPaginationMeta(PaginationResponse paginationMeta) {
        this.paginationMeta = paginationMeta;
    }

    /**
     * Create an instance of MetricListResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of MetricListResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     MetricListResponse
     */
    public static MetricListResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, MetricListResponse.class);
    }

    /**
     * Convert an instance of MetricListResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
