// this file is @generated
package com.meteroid.api;

import com.meteroid.models.FeatureStatus;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class FeaturesListOptions {
    private final List<FeatureStatus> statuses;
    private final String productId;
    private final String search;
    private final Integer page;
    private final Integer perPage;

    private FeaturesListOptions(Builder builder) {
        this.statuses = builder.statuses;
        this.productId = builder.productId;
        this.search = builder.search;
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
    public static FeaturesListOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.statuses = statuses;
        builder.productId = productId;
        builder.search = search;
        builder.page = page;
        builder.perPage = perPage;
        return builder;
    }

    /**
     * Filter by feature status. Repeat the param to select multiple, omit to return all.
     *
     * @return the value, empty when unset
     */
    public Optional<List<FeatureStatus>> statuses() {
        return Optional.ofNullable(statuses);
    }

    /**
     * Filter by product. Omit to return features across all products.
     *
     * @return the value, empty when unset
     */
    public Optional<String> productId() {
        return Optional.ofNullable(productId);
    }

    /**
     * Search by feature name.
     *
     * @return the value, empty when unset
     */
    public Optional<String> search() {
        return Optional.ofNullable(search);
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
        FeaturesListOptions that = (FeaturesListOptions) o;
        return Objects.equals(statuses, that.statuses)
                && Objects.equals(productId, that.productId)
                && Objects.equals(search, that.search)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statuses, productId, search, page, perPage);
    }

    @Override
    public String toString() {
        return "FeaturesListOptions{"
                + "statuses="
                + statuses
                + ", productId="
                + productId
                + ", search="
                + search
                + ", page="
                + page
                + ", perPage="
                + perPage
                + "}";
    }

    /** Builds {@link FeaturesListOptions}. */
    public static final class Builder {
        private List<FeatureStatus> statuses;
        private String productId;
        private String search;
        private Integer page;
        private Integer perPage;

        private Builder() {}

        /**
         * Filter by feature status. Repeat the param to select multiple, omit to return all.
         *
         * @param statuses the value, null to leave it out
         * @return this builder
         */
        public Builder statuses(List<FeatureStatus> statuses) {
            this.statuses = statuses;
            return this;
        }

        /**
         * Filter by product. Omit to return features across all products.
         *
         * @param productId the value, null to leave it out
         * @return this builder
         */
        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        /**
         * Search by feature name.
         *
         * @param search the value, null to leave it out
         * @return this builder
         */
        public Builder search(String search) {
            this.search = search;
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
        public FeaturesListOptions build() {
            return new FeaturesListOptions(this);
        }
    }
}
