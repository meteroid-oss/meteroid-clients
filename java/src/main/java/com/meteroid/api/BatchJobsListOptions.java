// this file is @generated
package com.meteroid.api;

import com.meteroid.models.BatchJobStatus;
import com.meteroid.models.BatchJobType;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class BatchJobsListOptions {
    private final BatchJobType jobType;
    private final List<BatchJobStatus> status;
    private final Integer page;
    private final Integer perPage;

    private BatchJobsListOptions(Builder builder) {
        this.jobType = builder.jobType;
        this.status = builder.status;
        this.page = builder.page;
        this.perPage = builder.perPage;
    }

    /**
     * A builder of parameters.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * No parameters.
     *
     * @return empty parameters
     */
    public static BatchJobsListOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.jobType = jobType;
        builder.status = status;
        builder.page = page;
        builder.perPage = perPage;
        return builder;
    }

    /**
     * The {@code job_type} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<BatchJobType> jobType() {
        return Optional.ofNullable(jobType);
    }

    /**
     * The {@code status} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<List<BatchJobStatus>> status() {
        return Optional.ofNullable(status);
    }

    /**
     * Page number (0-indexed)
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> page() {
        return Optional.ofNullable(page);
    }

    /**
     * Number of items per page
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> perPage() {
        return Optional.ofNullable(perPage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BatchJobsListOptions that = (BatchJobsListOptions) o;
        return Objects.equals(jobType, that.jobType)
                && Objects.equals(status, that.status)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobType, status, page, perPage);
    }

    @Override
    public String toString() {
        return "BatchJobsListOptions{"
                + "jobType="
                + jobType
                + ", status="
                + status
                + ", page="
                + page
                + ", perPage="
                + perPage
                + "}";
    }

    /** Builds {@link BatchJobsListOptions}. */
    public static final class Builder {
        private BatchJobType jobType;
        private List<BatchJobStatus> status;
        private Integer page;
        private Integer perPage;

        private Builder() {}

        /**
         * The {@code job_type} parameter.
         *
         * @param jobType the value, null to leave it out
         * @return this builder
         */
        public Builder jobType(BatchJobType jobType) {
            this.jobType = jobType;
            return this;
        }

        /**
         * The {@code status} parameter.
         *
         * @param status the value, null to leave it out
         * @return this builder
         */
        public Builder status(List<BatchJobStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Page number (0-indexed)
         *
         * @param page the value, null to leave it out
         * @return this builder
         */
        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        /**
         * Number of items per page
         *
         * @param perPage the value, null to leave it out
         * @return this builder
         */
        public Builder perPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        /**
         * The parameters.
         *
         * @return immutable parameters
         */
        public BatchJobsListOptions build() {
            return new BatchJobsListOptions(this);
        }
    }
}
