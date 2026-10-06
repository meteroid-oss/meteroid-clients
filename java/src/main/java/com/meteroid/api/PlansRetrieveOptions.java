// this file is @generated
package com.meteroid.api;

import java.util.Objects;
import java.util.Optional;

/** Optional parameters of {@code retrieve}, immutable: build them with {@link #builder()}. */
public final class PlansRetrieveOptions {
    private final String version;

    private PlansRetrieveOptions(Builder builder) {
        this.version = builder.version;
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
    public static PlansRetrieveOptions none() {
        return builder().build();
    }

    /**
     * A builder starting from these parameters.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.version = version;
        return builder;
    }

    /**
     * Filter by version: "draft", a version number, or omitted for active
     *
     * @return the value, empty when unset
     */
    public Optional<String> version() {
        return Optional.ofNullable(version);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlansRetrieveOptions that = (PlansRetrieveOptions) o;
        return Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public String toString() {
        return "PlansRetrieveOptions{" + "version=" + version + "}";
    }

    /** Builds {@link PlansRetrieveOptions}. */
    public static final class Builder {
        private String version;

        private Builder() {}

        /**
         * Filter by version: "draft", a version number, or omitted for active
         *
         * @param version the value, null to leave it out
         * @return this builder
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * The parameters.
         *
         * @return immutable parameters
         */
        public PlansRetrieveOptions build() {
            return new PlansRetrieveOptions(this);
        }
    }
}
