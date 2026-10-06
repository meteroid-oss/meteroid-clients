// this file is @generated
package com.meteroid.api;

import com.meteroid.models.CouponFilter;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class CouponsListOptions {
    private final String search;
    private final CouponFilter filter;
    private final String orderBy;
    private final Integer page;
    private final Integer perPage;

    private CouponsListOptions(Builder builder) {
        this.search = builder.search;
        this.filter = builder.filter;
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
    public static CouponsListOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.search = search;
        builder.filter = filter;
        builder.orderBy = orderBy;
        builder.page = page;
        builder.perPage = perPage;
        return builder;
    }

    /**
     * The {@code search} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> search() {
        return Optional.ofNullable(search);
    }

    /**
     * The {@code filter} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<CouponFilter> filter() {
        return Optional.ofNullable(filter);
    }

    /**
     * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>code</code>, <code>
     * created_at</code>, <code>expires_at</code>. Direction: <code>asc</code> or <code>desc</code>.
     * Default: <code>created_at.desc</code>.
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
        CouponsListOptions that = (CouponsListOptions) o;
        return Objects.equals(search, that.search)
                && Objects.equals(filter, that.filter)
                && Objects.equals(orderBy, that.orderBy)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(search, filter, orderBy, page, perPage);
    }

    @Override
    public String toString() {
        return "CouponsListOptions{"
                + "search="
                + search
                + ", filter="
                + filter
                + ", orderBy="
                + orderBy
                + ", page="
                + page
                + ", perPage="
                + perPage
                + "}";
    }

    /** Builds {@link CouponsListOptions}. */
    public static final class Builder {
        private String search;
        private CouponFilter filter;
        private String orderBy;
        private Integer page;
        private Integer perPage;

        private Builder() {}

        /**
         * The {@code search} parameter.
         *
         * @param search the value, null to leave it out
         * @return this builder
         */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

        /**
         * The {@code filter} parameter.
         *
         * @param filter the value, null to leave it out
         * @return this builder
         */
        public Builder filter(CouponFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>code</code>,
         * <code>created_at</code>, <code>expires_at</code>. Direction: <code>asc</code> or <code>
         * desc</code>. Default: <code>created_at.desc</code>.
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
        public CouponsListOptions build() {
            return new CouponsListOptions(this);
        }
    }
}
