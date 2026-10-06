// this file is @generated
package com.meteroid.api;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code listVersions}, immutable: build them with {@link #builder()}. */
public final class PlansListVersionsOptions {
    private final Integer page;
    private final Integer perPage;

    private PlansListVersionsOptions(Builder builder) {
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
    public static PlansListVersionsOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.page = page;
        builder.perPage = perPage;
        return builder;
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
        PlansListVersionsOptions that = (PlansListVersionsOptions) o;
        return Objects.equals(page, that.page) && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, perPage);
    }

    @Override
    public String toString() {
        return "PlansListVersionsOptions{" + "page=" + page + ", perPage=" + perPage + "}";
    }

    /** Builds {@link PlansListVersionsOptions}. */
    public static final class Builder {
        private Integer page;
        private Integer perPage;

        private Builder() {}

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
        public PlansListVersionsOptions build() {
            return new PlansListVersionsOptions(this);
        }
    }
}
