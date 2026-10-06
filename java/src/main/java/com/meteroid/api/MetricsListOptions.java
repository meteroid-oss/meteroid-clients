// this file is @generated
package com.meteroid.api;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class MetricsListOptions {
    private final String productFamilyId;
    private final String search;
    private final String orderBy;
    private final Integer page;
    private final Integer perPage;

    private MetricsListOptions(Builder builder) {
        this.productFamilyId = builder.productFamilyId;
        this.search = builder.search;
        this.orderBy = builder.orderBy;
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
    public static MetricsListOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.productFamilyId = productFamilyId;
        builder.search = search;
        builder.orderBy = orderBy;
        builder.page = page;
        builder.perPage = perPage;
        return builder;
    }

    /**
     * The {@code product_family_id} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> productFamilyId() {
        return Optional.ofNullable(productFamilyId);
    }

    /**
     * Search by metric name or code
     *
     * @return the value, empty when unset
     */
    public Optional<String> search() {
        return Optional.ofNullable(search);
    }

    /**
     * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>name</code>, <code>
     * code</code>, <code>created_at</code>. Direction: <code>asc</code> or <code>desc</code>.
     * Default: <code>name.asc</code>.
     *
     * @return the value, empty when unset
     */
    public Optional<String> orderBy() {
        return Optional.ofNullable(orderBy);
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
        MetricsListOptions that = (MetricsListOptions) o;
        return Objects.equals(productFamilyId, that.productFamilyId)
                && Objects.equals(search, that.search)
                && Objects.equals(orderBy, that.orderBy)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productFamilyId, search, orderBy, page, perPage);
    }

    @Override
    public String toString() {
        return "MetricsListOptions{"
                + "productFamilyId="
                + productFamilyId
                + ", search="
                + search
                + ", orderBy="
                + orderBy
                + ", page="
                + page
                + ", perPage="
                + perPage
                + "}";
    }

    /** Builds {@link MetricsListOptions}. */
    public static final class Builder {
        private String productFamilyId;
        private String search;
        private String orderBy;
        private Integer page;
        private Integer perPage;

        private Builder() {}

        /**
         * The {@code product_family_id} parameter.
         *
         * @param productFamilyId the value, null to leave it out
         * @return this builder
         */
        public Builder productFamilyId(String productFamilyId) {
            this.productFamilyId = productFamilyId;
            return this;
        }

        /**
         * Search by metric name or code
         *
         * @param search the value, null to leave it out
         * @return this builder
         */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

        /**
         * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>name</code>,
         * <code>code</code>, <code>created_at</code>. Direction: <code>asc</code> or <code>desc
         * </code>. Default: <code>name.asc</code>.
         *
         * @param orderBy the value, null to leave it out
         * @return this builder
         */
        public Builder orderBy(String orderBy) {
            this.orderBy = orderBy;
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
        public MetricsListOptions build() {
            return new MetricsListOptions(this);
        }
    }
}
