// this file is @generated
package com.meteroid.api;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class CustomersListOptions {
    private final String orderBy;
    private final Integer page;
    private final Integer perPage;
    private final String search;
    private final Boolean archived;

    private CustomersListOptions(Builder builder) {
        this.orderBy = builder.orderBy;
        this.page = builder.page;
        this.perPage = builder.perPage;
        this.search = builder.search;
        this.archived = builder.archived;
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
    public static CustomersListOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.orderBy = orderBy;
        builder.page = page;
        builder.perPage = perPage;
        builder.search = search;
        builder.archived = archived;
        return builder;
    }

    /**
     * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>name</code>, <code>
     * email</code>, <code>alias</code>, <code>created_at</code>. Direction: <code>asc</code> or
     * <code>desc</code>. Default: <code>created_at.desc</code>.
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

    /**
     * The {@code search} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> search() {
        return Optional.ofNullable(search);
    }

    /**
     * The {@code archived} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> archived() {
        return Optional.ofNullable(archived);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomersListOptions that = (CustomersListOptions) o;
        return Objects.equals(orderBy, that.orderBy)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage)
                && Objects.equals(search, that.search)
                && Objects.equals(archived, that.archived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderBy, page, perPage, search, archived);
    }

    @Override
    public String toString() {
        return "CustomersListOptions{"
                + "orderBy="
                + orderBy
                + ", page="
                + page
                + ", perPage="
                + perPage
                + ", search="
                + search
                + ", archived="
                + archived
                + "}";
    }

    /** Builds {@link CustomersListOptions}. */
    public static final class Builder {
        private String orderBy;
        private Integer page;
        private Integer perPage;
        private String search;
        private Boolean archived;

        private Builder() {}

        /**
         * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>name</code>,
         * <code>email</code>, <code>alias</code>, <code>created_at</code>. Direction: <code>asc
         * </code> or <code>desc</code>. Default: <code>created_at.desc</code>.
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
         * The {@code archived} parameter.
         *
         * @param archived the value, null to leave it out
         * @return this builder
         */
        public Builder archived(Boolean archived) {
            this.archived = archived;
            return this;
        }

        /**
         * The parameters.
         *
         * @return immutable parameters
         */
        public CustomersListOptions build() {
            return new CustomersListOptions(this);
        }
    }
}
