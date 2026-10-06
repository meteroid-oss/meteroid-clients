// this file is @generated
package com.meteroid.api;

import java.util.Objects;
import java.util.Optional;

/**
 * Optional parameters of {@code retrieveCustomer}, immutable: build them with {@link #builder()}.
 */
public final class UsageRetrieveCustomerOptions {
    private final String metricId;

    private UsageRetrieveCustomerOptions(Builder builder) {
        this.metricId = builder.metricId;
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
    public static UsageRetrieveCustomerOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.metricId = metricId;
        return builder;
    }

    /**
     * The {@code metric_id} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<String> metricId() {
        return Optional.ofNullable(metricId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UsageRetrieveCustomerOptions that = (UsageRetrieveCustomerOptions) o;
        return Objects.equals(metricId, that.metricId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metricId);
    }

    @Override
    public String toString() {
        return "UsageRetrieveCustomerOptions{" + "metricId=" + metricId + "}";
    }

    /** Builds {@link UsageRetrieveCustomerOptions}. */
    public static final class Builder {
        private String metricId;

        private Builder() {}

        /**
         * The {@code metric_id} parameter.
         *
         * @param metricId the value, null to leave it out
         * @return this builder
         */
        public Builder metricId(String metricId) {
            this.metricId = metricId;
            return this;
        }

        /**
         * The parameters.
         *
         * @return immutable parameters
         */
        public UsageRetrieveCustomerOptions build() {
            return new UsageRetrieveCustomerOptions(this);
        }
    }
}
