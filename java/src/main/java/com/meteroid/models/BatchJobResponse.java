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
public class BatchJobResponse {
    @JsonProperty("completed_at")
    private OffsetDateTime completedAt;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("failed_items")
    private Integer failedItems;

    @JsonProperty private String id;

    @JsonProperty("input_file_name")
    private String inputFileName;

    @JsonProperty("job_type")
    private BatchJobType jobType;

    @JsonProperty("processed_items")
    private Integer processedItems;

    @JsonProperty private BatchJobStatus status;

    @JsonProperty("total_items")
    private Integer totalItems;

    public BatchJobResponse() {}

    public BatchJobResponse completedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    /**
     * Get completedAt
     *
     * @return completedAt
     */
    @javax.annotation.Nullable
    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public BatchJobResponse createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     */
    @javax.annotation.Nonnull
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BatchJobResponse createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     *
     * @return createdBy
     */
    @javax.annotation.Nonnull
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public BatchJobResponse failedItems(Integer failedItems) {
        this.failedItems = failedItems;
        return this;
    }

    /**
     * Get failedItems
     *
     * @return failedItems
     */
    @javax.annotation.Nonnull
    public Integer getFailedItems() {
        return failedItems;
    }

    public void setFailedItems(Integer failedItems) {
        this.failedItems = failedItems;
    }

    public BatchJobResponse id(String id) {
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

    public BatchJobResponse inputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
        return this;
    }

    /**
     * Get inputFileName
     *
     * @return inputFileName
     */
    @javax.annotation.Nullable
    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public BatchJobResponse jobType(BatchJobType jobType) {
        this.jobType = jobType;
        return this;
    }

    /**
     * Get jobType
     *
     * @return jobType
     */
    @javax.annotation.Nonnull
    public BatchJobType getJobType() {
        return jobType;
    }

    public void setJobType(BatchJobType jobType) {
        this.jobType = jobType;
    }

    public BatchJobResponse processedItems(Integer processedItems) {
        this.processedItems = processedItems;
        return this;
    }

    /**
     * Get processedItems
     *
     * @return processedItems
     */
    @javax.annotation.Nonnull
    public Integer getProcessedItems() {
        return processedItems;
    }

    public void setProcessedItems(Integer processedItems) {
        this.processedItems = processedItems;
    }

    public BatchJobResponse status(BatchJobStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @javax.annotation.Nonnull
    public BatchJobStatus getStatus() {
        return status;
    }

    public void setStatus(BatchJobStatus status) {
        this.status = status;
    }

    public BatchJobResponse totalItems(Integer totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    /**
     * Get totalItems
     *
     * @return totalItems
     */
    @javax.annotation.Nullable
    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * Create an instance of BatchJobResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BatchJobResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BatchJobResponse
     */
    public static BatchJobResponse fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BatchJobResponse.class);
    }

    /**
     * Convert an instance of BatchJobResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
