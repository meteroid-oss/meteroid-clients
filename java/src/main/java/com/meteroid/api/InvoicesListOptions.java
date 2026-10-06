// this file is @generated
package com.meteroid.api;

import com.meteroid.models.EInvoicingStatus;
import com.meteroid.models.InvoiceStatus;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class InvoicesListOptions {
    private final String customerId;
    private final String subscriptionId;
    private final List<InvoiceStatus> statuses;
    private final EInvoicingStatus einvoicingStatus;
    private final String orderBy;
    private final Integer page;
    private final Integer perPage;

    private InvoicesListOptions(Builder builder) {
        this.customerId = builder.customerId;
        this.subscriptionId = builder.subscriptionId;
        this.statuses = builder.statuses;
        this.einvoicingStatus = builder.einvoicingStatus;
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
    public static InvoicesListOptions none() {
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
        builder.subscriptionId = subscriptionId;
        builder.statuses = statuses;
        builder.einvoicingStatus = einvoicingStatus;
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
     * The {@code subscription_id} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> subscriptionId() {
        return Optional.ofNullable(subscriptionId);
    }

    /**
     * The {@code statuses} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<List<InvoiceStatus>> statuses() {
        return Optional.ofNullable(statuses);
    }

    /**
     * Only invoices whose e-invoice was generated, or failed. Invoices from entities that had not
     * opted in carry no status and match neither.
     *
     * @return the value, empty when unset
     */
    public Optional<EInvoicingStatus> einvoicingStatus() {
        return Optional.ofNullable(einvoicingStatus);
    }

    /**
     * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>invoice_number
     * </code>, <code>customer_name</code>, <code>amount</code>, <code>invoice_date</code>, <code>
     * status</code>, <code>payment_status</code>. Direction: <code>asc</code> or <code>desc</code>.
     * Default: <code>invoice_date.desc</code>.
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
        InvoicesListOptions that = (InvoicesListOptions) o;
        return Objects.equals(customerId, that.customerId)
                && Objects.equals(subscriptionId, that.subscriptionId)
                && Objects.equals(statuses, that.statuses)
                && Objects.equals(einvoicingStatus, that.einvoicingStatus)
                && Objects.equals(orderBy, that.orderBy)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                customerId, subscriptionId, statuses, einvoicingStatus, orderBy, page, perPage);
    }

    @Override
    public String toString() {
        return "InvoicesListOptions{"
                + "customerId="
                + customerId
                + ", subscriptionId="
                + subscriptionId
                + ", statuses="
                + statuses
                + ", einvoicingStatus="
                + einvoicingStatus
                + ", orderBy="
                + orderBy
                + ", page="
                + page
                + ", perPage="
                + perPage
                + "}";
    }

    /** Builds {@link InvoicesListOptions}. */
    public static final class Builder {
        private String customerId;
        private String subscriptionId;
        private List<InvoiceStatus> statuses;
        private EInvoicingStatus einvoicingStatus;
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
         * The {@code subscription_id} parameter.
         *
         * @param subscriptionId the value, null to leave it out
         * @return this builder
         */
        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        /**
         * The {@code statuses} parameter.
         *
         * @param statuses the value, null to leave it out
         * @return this builder
         */
        public Builder statuses(List<InvoiceStatus> statuses) {
            this.statuses = statuses;
            return this;
        }

        /**
         * Only invoices whose e-invoice was generated, or failed. Invoices from entities that had
         * not opted in carry no status and match neither.
         *
         * @param einvoicingStatus the value, null to leave it out
         * @return this builder
         */
        public Builder einvoicingStatus(EInvoicingStatus einvoicingStatus) {
            this.einvoicingStatus = einvoicingStatus;
            return this;
        }

        /**
         * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>invoice_number
         * </code>, <code>customer_name</code>, <code>amount</code>, <code>invoice_date</code>,
         * <code>status</code>, <code>payment_status</code>. Direction: <code>asc</code> or <code>
         * desc</code>. Default: <code>invoice_date.desc</code>.
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
        public InvoicesListOptions build() {
            return new InvoicesListOptions(this);
        }
    }
}
