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
public class AddOnListResponse {
    @JsonProperty private List<AddOn> data;

    @JsonProperty("pagination_meta")
    private PaginationResponse paginationMeta;

    public AddOnListResponse() {}

    public AddOnListResponse data(List<AddOn> data) {
        this.data = data;
        return this;
    }

    public AddOnListResponse addDataItem(AddOn dataItem) {
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
    public List<AddOn> getData() {
        return data;
    }

    public void setData(List<AddOn> data) {
        this.data = data;
    }

    public AddOnListResponse paginationMeta(PaginationResponse paginationMeta) {
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
     * Create an instance of AddOnListResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of AddOnListResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     AddOnListResponse
     */
    public static AddOnListResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, AddOnListResponse.class);
    }

    /**
     * Convert an instance of AddOnListResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
