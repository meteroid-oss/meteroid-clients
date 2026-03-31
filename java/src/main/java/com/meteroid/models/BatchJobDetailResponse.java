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
public class BatchJobDetailResponse {
    @JsonProperty("completed_at")
    private OffsetDateTime completedAt;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("error_csv_url")
    private String errorCsvUrl;

    @JsonProperty("failed_items")
    private Integer failedItems;

    @JsonProperty("failure_count")
    private Long failureCount;

    @JsonProperty("has_error_csv")
    private Boolean hasErrorCsv;

    @JsonProperty private String id;

    @JsonProperty("input_file_name")
    private String inputFileName;

    @JsonProperty("input_file_url")
    private String inputFileUrl;

    @JsonProperty("job_type")
    private BatchJobType jobType;

    @JsonProperty("processed_items")
    private Integer processedItems;

    @JsonProperty private BatchJobStatus status;

    @JsonProperty("total_items")
    private Integer totalItems;

    public BatchJobDetailResponse() {}

    public BatchJobDetailResponse completedAt(OffsetDateTime completedAt) {
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

    public BatchJobDetailResponse createdAt(OffsetDateTime createdAt) {
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

    public BatchJobDetailResponse createdBy(String createdBy) {
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

    public BatchJobDetailResponse errorCsvUrl(String errorCsvUrl) {
        this.errorCsvUrl = errorCsvUrl;
        return this;
    }

    /**
     * Get errorCsvUrl
     *
     * @return errorCsvUrl
     */
    @javax.annotation.Nullable
    public String getErrorCsvUrl() {
        return errorCsvUrl;
    }

    public void setErrorCsvUrl(String errorCsvUrl) {
        this.errorCsvUrl = errorCsvUrl;
    }

    public BatchJobDetailResponse failedItems(Integer failedItems) {
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

    public BatchJobDetailResponse failureCount(Long failureCount) {
        this.failureCount = failureCount;
        return this;
    }

    /**
     * Get failureCount
     *
     * @return failureCount
     */
    @javax.annotation.Nonnull
    public Long getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(Long failureCount) {
        this.failureCount = failureCount;
    }

    public BatchJobDetailResponse hasErrorCsv(Boolean hasErrorCsv) {
        this.hasErrorCsv = hasErrorCsv;
        return this;
    }

    /**
     * Get hasErrorCsv
     *
     * @return hasErrorCsv
     */
    @javax.annotation.Nonnull
    public Boolean getHasErrorCsv() {
        return hasErrorCsv;
    }

    public void setHasErrorCsv(Boolean hasErrorCsv) {
        this.hasErrorCsv = hasErrorCsv;
    }

    public BatchJobDetailResponse id(String id) {
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

    public BatchJobDetailResponse inputFileName(String inputFileName) {
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

    public BatchJobDetailResponse inputFileUrl(String inputFileUrl) {
        this.inputFileUrl = inputFileUrl;
        return this;
    }

    /**
     * Get inputFileUrl
     *
     * @return inputFileUrl
     */
    @javax.annotation.Nullable
    public String getInputFileUrl() {
        return inputFileUrl;
    }

    public void setInputFileUrl(String inputFileUrl) {
        this.inputFileUrl = inputFileUrl;
    }

    public BatchJobDetailResponse jobType(BatchJobType jobType) {
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

    public BatchJobDetailResponse processedItems(Integer processedItems) {
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

    public BatchJobDetailResponse status(BatchJobStatus status) {
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

    public BatchJobDetailResponse totalItems(Integer totalItems) {
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
     * Create an instance of BatchJobDetailResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of BatchJobDetailResponse
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     BatchJobDetailResponse
     */
    public static BatchJobDetailResponse fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, BatchJobDetailResponse.class);
    }

    /**
     * Convert an instance of BatchJobDetailResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
