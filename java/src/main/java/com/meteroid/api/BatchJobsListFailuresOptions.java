// this file is @generated
package com.meteroid.api;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code listFailures}, immutable: build them with {@link #builder()}. */
public final class BatchJobsListFailuresOptions {
    private final String chunkId;
    private final Integer limit;
    private final Integer offset;

    private BatchJobsListFailuresOptions(Builder builder) {
        this.chunkId = builder.chunkId;
        this.limit = builder.limit;
        this.offset = builder.offset;
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
    public static BatchJobsListFailuresOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.chunkId = chunkId;
        builder.limit = limit;
        builder.offset = offset;
        return builder;
    }

    /**
     * The {@code chunk_id} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> chunkId() {
        return Optional.ofNullable(chunkId);
    }

    /**
     * The {@code limit} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> limit() {
        return Optional.ofNullable(limit);
    }

    /**
     * The {@code offset} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<Integer> offset() {
        return Optional.ofNullable(offset);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BatchJobsListFailuresOptions that = (BatchJobsListFailuresOptions) o;
        return Objects.equals(chunkId, that.chunkId)
                && Objects.equals(limit, that.limit)
                && Objects.equals(offset, that.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chunkId, limit, offset);
    }

    @Override
    public String toString() {
        return "BatchJobsListFailuresOptions{"
                + "chunkId="
                + chunkId
                + ", limit="
                + limit
                + ", offset="
                + offset
                + "}";
    }

    /** Builds {@link BatchJobsListFailuresOptions}. */
    public static final class Builder {
        private String chunkId;
        private Integer limit;
        private Integer offset;

        private Builder() {}

        /**
         * The {@code chunk_id} parameter.
         *
         * @param chunkId the value, null to leave it out
         * @return this builder
         */
        public Builder chunkId(String chunkId) {
            this.chunkId = chunkId;
            return this;
        }

        /**
         * The {@code limit} parameter.
         *
         * @param limit the value, null to leave it out
         * @return this builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * The {@code offset} parameter.
         *
         * @param offset the value, null to leave it out
         * @return this builder
         */
        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        /**
         * The parameters.
         *
         * @return immutable parameters
         */
        public BatchJobsListFailuresOptions build() {
            return new BatchJobsListFailuresOptions(this);
        }
    }
}
