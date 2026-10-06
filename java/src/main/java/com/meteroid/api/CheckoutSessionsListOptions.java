// this file is @generated
package com.meteroid.api;

import com.meteroid.models.CheckoutSessionStatus;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code list}, immutable: build them with {@link #builder()}. */
public final class CheckoutSessionsListOptions {
    private final String customerId;
    private final CheckoutSessionStatus status;

    private CheckoutSessionsListOptions(Builder builder) {
        this.customerId = builder.customerId;
        this.status = builder.status;
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
    public static CheckoutSessionsListOptions none() {
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
        builder.status = status;
        return builder;
    }

    /**
     * The {@code customer_id} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> customerId() {
        return Optional.ofNullable(customerId);
    }

    /**
     * The {@code status} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<CheckoutSessionStatus> status() {
        return Optional.ofNullable(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheckoutSessionsListOptions that = (CheckoutSessionsListOptions) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, status);
    }

    @Override
    public String toString() {
        return "CheckoutSessionsListOptions{"
                + "customerId="
                + customerId
                + ", status="
                + status
                + "}";
    }

    /** Builds {@link CheckoutSessionsListOptions}. */
    public static final class Builder {
        private String customerId;
        private CheckoutSessionStatus status;

        private Builder() {}

        /**
         * The {@code customer_id} parameter.
         *
         * @param customerId the value, null to leave it out
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * The {@code status} parameter.
         *
         * @param status the value, null to leave it out
         * @return this builder
         */
        public Builder status(CheckoutSessionStatus status) {
            this.status = status;
            return this;
        }

        /**
         * The parameters.
         *
         * @return immutable parameters
         */
        public CheckoutSessionsListOptions build() {
            return new CheckoutSessionsListOptions(this);
        }
    }
}
