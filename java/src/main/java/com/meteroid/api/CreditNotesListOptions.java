// this file is @generated
package com.meteroid.api;

import com.meteroid.models.CreditNoteStatus;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class CreditNotesListOptions {
    private final String customerId;
    private final String invoiceId;
    private final CreditNoteStatus status;
    private final String search;
    private final String orderBy;
    private final Integer page;
    private final Integer perPage;

    private CreditNotesListOptions(Builder builder) {
        this.customerId = builder.customerId;
        this.invoiceId = builder.invoiceId;
        this.status = builder.status;
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
    public static CreditNotesListOptions none() {
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
        builder.invoiceId = invoiceId;
        builder.status = status;
        builder.search = search;
        builder.orderBy = orderBy;
        builder.page = page;
        builder.perPage = perPage;
        return builder;
    }

    /**
     * Filter by customer ID
     *
     * @return the value, empty when unset
     */
    public Optional<String> customerId() {
        return Optional.ofNullable(customerId);
    }

    /**
     * Filter by invoice ID
     *
     * @return the value, empty when unset
     */
    public Optional<String> invoiceId() {
        return Optional.ofNullable(invoiceId);
    }

    /**
     * The {@code status} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<CreditNoteStatus> status() {
        return Optional.ofNullable(status);
    }

    /**
     * Free-text search over credit note number.
     *
     * @return the value, empty when unset
     */
    public Optional<String> search() {
        return Optional.ofNullable(search);
    }

    /**
     * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>created_at</code>,
     * <code>credit_note_number</code>, <code>total</code>, <code>status</code>. Direction: <code>
     * asc</code> or <code>desc</code>. Default: <code>created_at.desc</code>.
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
        CreditNotesListOptions that = (CreditNotesListOptions) o;
        return Objects.equals(customerId, that.customerId)
                && Objects.equals(invoiceId, that.invoiceId)
                && Objects.equals(status, that.status)
                && Objects.equals(search, that.search)
                && Objects.equals(orderBy, that.orderBy)
                && Objects.equals(page, that.page)
                && Objects.equals(perPage, that.perPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, invoiceId, status, search, orderBy, page, perPage);
    }

    @Override
    public String toString() {
        return "CreditNotesListOptions{"
                + "customerId="
                + customerId
                + ", invoiceId="
                + invoiceId
                + ", status="
                + status
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

    /** Builds {@link CreditNotesListOptions}. */
    public static final class Builder {
        private String customerId;
        private String invoiceId;
        private CreditNoteStatus status;
        private String search;
        private String orderBy;
        private Integer page;
        private Integer perPage;

        private Builder() {}

        /**
         * Filter by customer ID
         *
         * @param customerId the value, null to leave it out
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * Filter by invoice ID
         *
         * @param invoiceId the value, null to leave it out
         * @return this builder
         */
        public Builder invoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        /**
         * The {@code status} parameter.
         *
         * @param status the value, null to leave it out
         * @return this builder
         */
        public Builder status(CreditNoteStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Free-text search over credit note number.
         *
         * @param search the value, null to leave it out
         * @return this builder
         */
        public Builder search(String search) {
            this.search = search;
            return this;
        }

        /**
         * Sort order. Format: <code>column.direction</code>. Allowed columns: <code>created_at
         * </code>, <code>credit_note_number</code>, <code>total</code>, <code>status</code>.
         * Direction: <code>asc</code> or <code>desc</code>. Default: <code>created_at.desc</code>.
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
        public CreditNotesListOptions build() {
            return new CreditNotesListOptions(this);
        }
    }
}
