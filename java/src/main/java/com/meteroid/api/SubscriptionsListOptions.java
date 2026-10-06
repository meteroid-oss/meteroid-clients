// this file is @generated
package com.meteroid.api;

import com.meteroid.models.SubscriptionStatusEnum;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class SubscriptionsListOptions {
    private final String customerId;
    private final String planId;
    private final List<SubscriptionStatusEnum> statuses;
    private final String orderBy;
    private final Integer page;
    private final Integer perPage;

    private SubscriptionsListOptions(Builder builder) {
        this.customerId = builder.customerId;
        this.planId = builder.planId;
        this.statuses = builder.statuses;
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
    public static SubscriptionsListOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.customerId = customerId;
        builder.planId = planId;
        builder.statuses = statuses;
        builder.orderBy = orderBy;
        builder.page = page;
        builder.perPage = perPage;
        return builder;
    }

    /**
     * Filter by customer ID or alias
     *
     * @return the value, empty when unset
     */
    public Optional<String> customerId() {
        return Optional.ofNullable(customerId);
    }

    /**
     * The {@code plan_id} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> planId() {
        return Optional.ofNullable(planId);
    }

    /**
     * The {@code statuses} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<List<SubscriptionStatusEnum>> statuses() {
        return Optional.ofNullable(statuses);
    }

    /**
     * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>customer_name
     * </code>, <code>plan_name</code>, <code>mrr_cents</code>, <code>billing_start_date</code>,
     * <code>end_date</code>, <code>status</code>, <code>created_at</code>. Direction: <code>asc
     * </code> or <code>desc</code>. Default: <code>created_at.desc</code>.
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
        SubscriptionsListOptions that = (SubscriptionsListOptions) o;
        return Objects.equals(customerId, that.customerId)
                && Objects.equals(planId, that.planId)
                && Objects.equals(statuses, that.statuses)
                && Objects.equals(orderBy, that.orderBy)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, planId, statuses, orderBy, page, perPage);
    }

    @Override
    public String toString() {
        return "SubscriptionsListOptions{"
                + "customerId="
                + customerId
                + ", planId="
                + planId
                + ", statuses="
                + statuses
                + ", orderBy="
                + orderBy
                + ", page="
                + page
                + ", perPage="
                + perPage
                + "}";
    }

    /** Builds {@link SubscriptionsListOptions}. */
    public static final class Builder {
        private String customerId;
        private String planId;
        private List<SubscriptionStatusEnum> statuses;
        private String orderBy;
        private Integer page;
        private Integer perPage;

        private Builder() {}

        /**
         * Filter by customer ID or alias
         *
         * @param customerId the value, null to leave it out
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * The {@code plan_id} parameter.
         *
         * @param planId the value, null to leave it out
         * @return this builder
         */
        public Builder planId(String planId) {
            this.planId = planId;
            return this;
        }

        /**
         * The {@code statuses} parameter.
         *
         * @param statuses the value, null to leave it out
         * @return this builder
         */
        public Builder statuses(List<SubscriptionStatusEnum> statuses) {
            this.statuses = statuses;
            return this;
        }

        /**
         * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>customer_name
         * </code>, <code>plan_name</code>, <code>mrr_cents</code>, <code>billing_start_date</code>,
         * <code>end_date</code>, <code>status</code>, <code>created_at</code>. Direction: <code>asc
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
         * The parameters.
         *
         * @return immutable parameters
         */
        public SubscriptionsListOptions build() {
            return new SubscriptionsListOptions(this);
        }
    }
}
