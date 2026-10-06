// this file is @generated
package com.meteroid.api;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/**
 * Optional parameters of {@code retrieveSubscription}, immutable: build them with {@link
 * #builder()}.
 */
public final class UsageRetrieveSubscriptionOptions {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String metricId;

    private UsageRetrieveSubscriptionOptions(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
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
    public static UsageRetrieveSubscriptionOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.startDate = startDate;
        builder.endDate = endDate;
        builder.metricId = metricId;
        return builder;
    }

    /**
     * The {@code start_date} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<LocalDate> startDate() {
        return Optional.ofNullable(startDate);
    }

    /**
     * The {@code end_date} parameter.
     *
     * @return the value, empty when unset
     */
    public Optional<LocalDate> endDate() {
        return Optional.ofNullable(endDate);
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
        UsageRetrieveSubscriptionOptions that = (UsageRetrieveSubscriptionOptions) o;
        return Objects.equals(startDate, that.startDate)
                && Objects.equals(endDate, that.endDate)
                && Objects.equals(metricId, that.metricId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, metricId);
    }

    @Override
    public String toString() {
        return "UsageRetrieveSubscriptionOptions{"
                + "startDate="
                + startDate
                + ", endDate="
                + endDate
                + ", metricId="
                + metricId
                + "}";
    }

    /** Builds {@link UsageRetrieveSubscriptionOptions}. */
    public static final class Builder {
        private LocalDate startDate;
        private LocalDate endDate;
        private String metricId;

        private Builder() {}

        /**
         * The {@code start_date} parameter.
         *
         * @param startDate the value, null to leave it out
         * @return this builder
         */
        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * The {@code end_date} parameter.
         *
         * @param endDate the value, null to leave it out
         * @return this builder
         */
        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

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
        public UsageRetrieveSubscriptionOptions build() {
            return new UsageRetrieveSubscriptionOptions(this);
        }
    }
}
