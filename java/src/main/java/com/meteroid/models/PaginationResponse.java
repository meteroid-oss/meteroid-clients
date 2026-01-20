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
public class PaginationResponse {
    @JsonProperty private Integer page;

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("total_items")
    private Long totalItems;

    @JsonProperty("total_pages")
    private Integer totalPages;

    public PaginationResponse() {}

    public PaginationResponse page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Get page
     *
     * @return page
     */
    @javax.annotation.Nonnull
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public PaginationResponse perPage(Integer perPage) {
        this.perPage = perPage;
        return this;
    }

    /**
     * Get perPage
     *
     * @return perPage
     */
    @javax.annotation.Nonnull
    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public PaginationResponse totalItems(Long totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    /**
     * Get totalItems
     *
     * @return totalItems
     */
    @javax.annotation.Nonnull
    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public PaginationResponse totalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    /**
     * Get totalPages
     *
     * @return totalPages
     */
    @javax.annotation.Nonnull
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * Create an instance of PaginationResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of PaginationResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     PaginationResponse
     */
    public static PaginationResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, PaginationResponse.class);
    }

    /**
     * Convert an instance of PaginationResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
