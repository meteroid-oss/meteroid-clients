// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.JsonField;
import com.meteroid.internal.Utils;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class BatchJobDetailResponse {
    @JsonProperty("completed_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> completedAt = JsonField.missing();

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("created_by")
    private UUID createdBy;

    @JsonProperty("error_csv_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> errorCsvUrl = JsonField.missing();

    @JsonProperty("failed_items")
    private Integer failedItems;

    @JsonProperty("failure_count")
    private Long failureCount;

    @JsonProperty("has_error_csv")
    private Boolean hasErrorCsv;

    @JsonProperty("has_output")
    private Boolean hasOutput;

    @JsonProperty("id")
    private String id;

    @JsonProperty("input_file_name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> inputFileName = JsonField.missing();

    @JsonProperty("input_file_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> inputFileUrl = JsonField.missing();

    @JsonProperty("job_type")
    private BatchJobType jobType;

    @JsonProperty("output_url")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> outputUrl = JsonField.missing();

    @JsonProperty("processed_items")
    private Integer processedItems;

    @JsonProperty("status")
    private BatchJobStatus status;

    @JsonProperty("total_items")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> totalItems = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private BatchJobDetailResponse() {}

    private BatchJobDetailResponse(Builder builder) {
        this.completedAt = builder.completedAt;
        this.createdAt = builder.createdAt;
        this.createdBy = builder.createdBy;
        this.errorCsvUrl = builder.errorCsvUrl;
        this.failedItems = builder.failedItems;
        this.failureCount = builder.failureCount;
        this.hasErrorCsv = builder.hasErrorCsv;
        this.hasOutput = builder.hasOutput;
        this.id = builder.id;
        this.inputFileName = builder.inputFileName;
        this.inputFileUrl = builder.inputFileUrl;
        this.jobType = builder.jobType;
        this.outputUrl = builder.outputUrl;
        this.processedItems = builder.processedItems;
        this.status = builder.status;
        this.totalItems = builder.totalItems;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code BatchJobDetailResponse}.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder starting from this value.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.completedAt = completedAt;
        builder.createdAt = createdAt;
        builder.createdBy = createdBy;
        builder.errorCsvUrl = errorCsvUrl;
        builder.failedItems = failedItems;
        builder.failureCount = failureCount;
        builder.hasErrorCsv = hasErrorCsv;
        builder.hasOutput = hasOutput;
        builder.id = id;
        builder.inputFileName = inputFileName;
        builder.inputFileUrl = inputFileUrl;
        builder.jobType = jobType;
        builder.outputUrl = outputUrl;
        builder.processedItems = processedItems;
        builder.status = status;
        builder.totalItems = totalItems;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code completed_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> completedAt() {
        return completedAt.asOptional();
    }

    /**
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
    }

    /**
     * The {@code created_by} property.
     *
     * @return the value, never null
     */
    public UUID createdBy() {
        return Utils.required(createdBy, "created_by");
    }

    /**
     * The {@code error_csv_url} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> errorCsvUrl() {
        return errorCsvUrl.asOptional();
    }

    /**
     * The {@code failed_items} property.
     *
     * @return the value, never null
     */
    public Integer failedItems() {
        return Utils.required(failedItems, "failed_items");
    }

    /**
     * The {@code failure_count} property.
     *
     * @return the value, never null
     */
    public Long failureCount() {
        return Utils.required(failureCount, "failure_count");
    }

    /**
     * The {@code has_error_csv} property.
     *
     * @return the value, never null
     */
    public Boolean hasErrorCsv() {
        return Utils.required(hasErrorCsv, "has_error_csv");
    }

    /**
     * The {@code has_output} property.
     *
     * @return the value, never null
     */
    public Boolean hasOutput() {
        return Utils.required(hasOutput, "has_output");
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code input_file_name} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> inputFileName() {
        return inputFileName.asOptional();
    }

    /**
     * The {@code input_file_url} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> inputFileUrl() {
        return inputFileUrl.asOptional();
    }

    /**
     * The {@code job_type} property.
     *
     * @return the value, never null
     */
    public BatchJobType jobType() {
        return Utils.required(jobType, "job_type");
    }

    /**
     * The {@code output_url} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> outputUrl() {
        return outputUrl.asOptional();
    }

    /**
     * The {@code processed_items} property.
     *
     * @return the value, never null
     */
    public Integer processedItems() {
        return Utils.required(processedItems, "processed_items");
    }

    /**
     * The {@code status} property.
     *
     * @return the value, never null
     */
    public BatchJobStatus status() {
        return Utils.required(status, "status");
    }

    /**
     * The {@code total_items} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> totalItems() {
        return totalItems.asOptional();
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnyGetter
    private Map<String, JsonNode> anyProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void putAnyProperty(String name, JsonNode value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BatchJobDetailResponse that = (BatchJobDetailResponse) o;
        return Objects.equals(completedAt, that.completedAt)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(createdBy, that.createdBy)
                && Objects.equals(errorCsvUrl, that.errorCsvUrl)
                && Objects.equals(failedItems, that.failedItems)
                && Objects.equals(failureCount, that.failureCount)
                && Objects.equals(hasErrorCsv, that.hasErrorCsv)
                && Objects.equals(hasOutput, that.hasOutput)
                && Objects.equals(id, that.id)
                && Objects.equals(inputFileName, that.inputFileName)
                && Objects.equals(inputFileUrl, that.inputFileUrl)
                && Objects.equals(jobType, that.jobType)
                && Objects.equals(outputUrl, that.outputUrl)
                && Objects.equals(processedItems, that.processedItems)
                && Objects.equals(status, that.status)
                && Objects.equals(totalItems, that.totalItems)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                completedAt,
                createdAt,
                createdBy,
                errorCsvUrl,
                failedItems,
                failureCount,
                hasErrorCsv,
                hasOutput,
                id,
                inputFileName,
                inputFileUrl,
                jobType,
                outputUrl,
                processedItems,
                status,
                totalItems,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "BatchJobDetailResponse{"
                + "completedAt="
                + completedAt
                + ", createdAt="
                + createdAt
                + ", createdBy="
                + createdBy
                + ", errorCsvUrl="
                + errorCsvUrl
                + ", failedItems="
                + failedItems
                + ", failureCount="
                + failureCount
                + ", hasErrorCsv="
                + hasErrorCsv
                + ", hasOutput="
                + hasOutput
                + ", id="
                + id
                + ", inputFileName="
                + inputFileName
                + ", inputFileUrl="
                + inputFileUrl
                + ", jobType="
                + jobType
                + ", outputUrl="
                + outputUrl
                + ", processedItems="
                + processedItems
                + ", status="
                + status
                + ", totalItems="
                + totalItems
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link BatchJobDetailResponse}. */
    public static final class Builder {
        private JsonField<OffsetDateTime> completedAt = JsonField.missing();
        private OffsetDateTime createdAt;
        private UUID createdBy;
        private JsonField<String> errorCsvUrl = JsonField.missing();
        private Integer failedItems;
        private Long failureCount;
        private Boolean hasErrorCsv;
        private Boolean hasOutput;
        private String id;
        private JsonField<String> inputFileName = JsonField.missing();
        private JsonField<String> inputFileUrl = JsonField.missing();
        private BatchJobType jobType;
        private JsonField<String> outputUrl = JsonField.missing();
        private Integer processedItems;
        private BatchJobStatus status;
        private JsonField<Integer> totalItems = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code completed_at} property.
         *
         * @param completedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder completedAt(OffsetDateTime completedAt) {
            this.completedAt = JsonField.ofNullable(completedAt);
            return this;
        }

        /**
         * The {@code created_at} property.
         *
         * @param createdAt the value
         * @return this builder
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * The {@code created_by} property.
         *
         * @param createdBy the value
         * @return this builder
         */
        public Builder createdBy(UUID createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        /**
         * The {@code error_csv_url} property.
         *
         * @param errorCsvUrl the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder errorCsvUrl(String errorCsvUrl) {
            this.errorCsvUrl = JsonField.ofNullable(errorCsvUrl);
            return this;
        }

        /**
         * The {@code failed_items} property.
         *
         * @param failedItems the value
         * @return this builder
         */
        public Builder failedItems(Integer failedItems) {
            this.failedItems = failedItems;
            return this;
        }

        /**
         * The {@code failure_count} property.
         *
         * @param failureCount the value
         * @return this builder
         */
        public Builder failureCount(Long failureCount) {
            this.failureCount = failureCount;
            return this;
        }

        /**
         * The {@code has_error_csv} property.
         *
         * @param hasErrorCsv the value
         * @return this builder
         */
        public Builder hasErrorCsv(Boolean hasErrorCsv) {
            this.hasErrorCsv = hasErrorCsv;
            return this;
        }

        /**
         * The {@code has_output} property.
         *
         * @param hasOutput the value
         * @return this builder
         */
        public Builder hasOutput(Boolean hasOutput) {
            this.hasOutput = hasOutput;
            return this;
        }

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * The {@code input_file_name} property.
         *
         * @param inputFileName the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder inputFileName(String inputFileName) {
            this.inputFileName = JsonField.ofNullable(inputFileName);
            return this;
        }

        /**
         * The {@code input_file_url} property.
         *
         * @param inputFileUrl the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder inputFileUrl(String inputFileUrl) {
            this.inputFileUrl = JsonField.ofNullable(inputFileUrl);
            return this;
        }

        /**
         * The {@code job_type} property.
         *
         * @param jobType the value
         * @return this builder
         */
        public Builder jobType(BatchJobType jobType) {
            this.jobType = jobType;
            return this;
        }

        /**
         * The {@code output_url} property.
         *
         * @param outputUrl the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder outputUrl(String outputUrl) {
            this.outputUrl = JsonField.ofNullable(outputUrl);
            return this;
        }

        /**
         * The {@code processed_items} property.
         *
         * @param processedItems the value
         * @return this builder
         */
        public Builder processedItems(Integer processedItems) {
            this.processedItems = processedItems;
            return this;
        }

        /**
         * The {@code status} property.
         *
         * @param status the value
         * @return this builder
         */
        public Builder status(BatchJobStatus status) {
            this.status = status;
            return this;
        }

        /**
         * The {@code total_items} property.
         *
         * @param totalItems the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder totalItems(Integer totalItems) {
            this.totalItems = JsonField.ofNullable(totalItems);
            return this;
        }

        /**
         * A property the SDK does not know, sent along.
         *
         * @param name the property name
         * @param value the JSON value
         * @return this builder
         */
        public Builder putAdditionalProperty(String name, JsonNode value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Properties the SDK does not know, sent along.
         *
         * @param additionalProperties the properties by name
         * @return this builder
         */
        public Builder putAllAdditionalProperties(Map<String, JsonNode> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        /**
         * Leaves out a property the SDK does not know.
         *
         * @param name the property name
         * @return this builder
         */
        public Builder removeAdditionalProperty(String name) {
            additionalProperties.remove(name);
            return this;
        }

        /**
         * The {@code BatchJobDetailResponse}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public BatchJobDetailResponse build() {
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(createdBy, "created_by");
            Utils.checkRequired(failedItems, "failed_items");
            Utils.checkRequired(failureCount, "failure_count");
            Utils.checkRequired(hasErrorCsv, "has_error_csv");
            Utils.checkRequired(hasOutput, "has_output");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(jobType, "job_type");
            Utils.checkRequired(processedItems, "processed_items");
            Utils.checkRequired(status, "status");
            return new BatchJobDetailResponse(this);
        }
    }

    /**
     * Parse {@code json} as {@code BatchJobDetailResponse}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static BatchJobDetailResponse fromJson(String json) {
        return Utils.parse(json, BatchJobDetailResponse.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }
}
