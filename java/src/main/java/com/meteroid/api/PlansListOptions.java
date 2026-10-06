// this file is @generated
package com.meteroid.api;

import com.meteroid.models.PlanStatusEnum;
import com.meteroid.models.PlanTypeEnum;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class PlansListOptions {
    private final String productFamilyId;
    private final String search;
    private final List<PlanStatusEnum> status;
    private final List<PlanTypeEnum> planType;
    private final String orderBy;
    private final Integer page;
    private final Integer perPage;

    private PlansListOptions(Builder builder) {
        this.productFamilyId = builder.productFamilyId;
        this.search = builder.search;
        this.status = builder.status;
        this.planType = builder.planType;
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
    public static PlansListOptions none() {
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
        builder.status = status;
        builder.planType = planType;
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
     * Search by plan name
     *
     * @return the value, empty when unset
     */
    public Optional<String> search() {
        return Optional.ofNullable(search);
    }

    /**
     * Filter by plan status (can be repeated)
     *
     * @return the value, empty when unset
     */
    public Optional<List<PlanStatusEnum>> status() {
        return Optional.ofNullable(status);
    }

    /**
     * Filter by plan type (can be repeated)
     *
     * @return the value, empty when unset
     */
    public Optional<List<PlanTypeEnum>> planType() {
        return Optional.ofNullable(planType);
    }

    /**
     * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>name</code>, <code>
     * status</code>, <code>plan_type</code>, <code>created_at</code>. Direction: <code>asc</code>
     * or <code>desc</code>. Default: <code>created_at.desc</code>.
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
        PlansListOptions that = (PlansListOptions) o;
        return Objects.equals(productFamilyId, that.productFamilyId)
                && Objects.equals(search, that.search)
                && Objects.equals(status, that.status)
                && Objects.equals(planType, that.planType)
                && Objects.equals(orderBy, that.orderBy)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productFamilyId, search, status, planType, orderBy, page, perPage);
    }

    @Override
    public String toString() {
        return "PlansListOptions{"
                + "productFamilyId="
                + productFamilyId
                + ", search="
                + search
                + ", status="
                + status
                + ", planType="
                + planType
                + ", orderBy="
                + orderBy
                + ", page="
                + page
                + ", perPage="
                + perPage
                + "}";
    }

    /** Builds {@link PlansListOptions}. */
    public static final class Builder {
        private String productFamilyId;
        private String search;
        private List<PlanStatusEnum> status;
        private List<PlanTypeEnum> planType;
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
         * Search by plan name
         *
         * @param search the value, null to leave it out
         * @return this builder
         */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

        /**
         * Filter by plan status (can be repeated)
         *
         * @param status the value, null to leave it out
         * @return this builder
         */
        public Builder status(List<PlanStatusEnum> status) {
            this.status = status;
            return this;
        }

        /**
         * Filter by plan type (can be repeated)
         *
         * @param planType the value, null to leave it out
         * @return this builder
         */
        public Builder planType(List<PlanTypeEnum> planType) {
            this.planType = planType;
            return this;
        }

        /**
         * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>name</code>,
         * <code>status</code>, <code>plan_type</code>, <code>created_at</code>. Direction: <code>
         * asc</code> or <code>desc</code>. Default: <code>created_at.desc</code>.
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
        public PlansListOptions build() {
            return new PlansListOptions(this);
        }
    }
}
