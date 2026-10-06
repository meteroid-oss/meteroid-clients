// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.internal.JsonField;
import com.meteroid.internal.Utils;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class AppliedCoupon {
    @JsonProperty("applied_amount")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<BigDecimal> appliedAmount = JsonField.missing();

    @JsonProperty("applied_count")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> appliedCount = JsonField.missing();

    @JsonProperty("coupon_id")
    private String couponId;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("id")
    private String id;

    @JsonProperty("is_active")
    private Boolean isActive;

    @JsonProperty("last_applied_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> lastAppliedAt = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private AppliedCoupon() {}

    private AppliedCoupon(Builder builder) {
        this.appliedAmount = builder.appliedAmount;
        this.appliedCount = builder.appliedCount;
        this.couponId = builder.couponId;
        this.createdAt = builder.createdAt;
        this.id = builder.id;
        this.isActive = builder.isActive;
        this.lastAppliedAt = builder.lastAppliedAt;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code AppliedCoupon}.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder starting from this value.
     *
     * @return a new builder
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.appliedAmount = appliedAmount;
        builder.appliedCount = appliedCount;
        builder.couponId = couponId;
        builder.createdAt = createdAt;
        builder.id = id;
        builder.isActive = isActive;
        builder.lastAppliedAt = lastAppliedAt;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code applied_amount} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<BigDecimal> appliedAmount() {
        return appliedAmount.asOptional();
    }

    /**
     * The {@code applied_count} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> appliedCount() {
        return appliedCount.asOptional();
    }

    /**
     * The {@code coupon_id} property.
     *
     * @return the value, never null
     */
    public String couponId() {
        return Utils.required(couponId, "coupon_id");
    }

    /**
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
    }

    /**
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code is_active} property.
     *
     * @return the value, never null
     */
    public Boolean isActive() {
        return Utils.required(isActive, "is_active");
    }

    /**
     * The {@code last_applied_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> lastAppliedAt() {
        return lastAppliedAt.asOptional();
    }

    /**
     * Properties this version of the SDK does not know, kept as received and sent back.
     *
     * @return the properties by name, unmodifiable
     */
    public Map<String, JsonNode> additionalProperties() {
        return Collections.unmodifiableMap(additionalProperties);
    }

    @JsonAnyGetter
    private Map<String, JsonNode> anyProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    private void putAnyProperty(String name, JsonNode value) {
        additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppliedCoupon that = (AppliedCoupon) o;
        return Objects.equals(appliedAmount, that.appliedAmount)
                && Objects.equals(appliedCount, that.appliedCount)
                && Objects.equals(couponId, that.couponId)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(id, that.id)
                && Objects.equals(isActive, that.isActive)
                && Objects.equals(lastAppliedAt, that.lastAppliedAt)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                appliedAmount,
                appliedCount,
                couponId,
                createdAt,
                id,
                isActive,
                lastAppliedAt,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "AppliedCoupon{"
                + "appliedAmount="
                + appliedAmount
                + ", appliedCount="
                + appliedCount
                + ", couponId="
                + couponId
                + ", createdAt="
                + createdAt
                + ", id="
                + id
                + ", isActive="
                + isActive
                + ", lastAppliedAt="
                + lastAppliedAt
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link AppliedCoupon}. */
    public static final class Builder {
        private JsonField<BigDecimal> appliedAmount = JsonField.missing();
        private JsonField<Integer> appliedCount = JsonField.missing();
        private String couponId;
        private OffsetDateTime createdAt;
        private String id;
        private Boolean isActive;
        private JsonField<OffsetDateTime> lastAppliedAt = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code applied_amount} property.
         *
         * @param appliedAmount the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder appliedAmount(BigDecimal appliedAmount) {
            this.appliedAmount = JsonField.ofNullable(appliedAmount);
            return this;
        }

        /**
         * The {@code applied_count} property.
         *
         * @param appliedCount the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder appliedCount(Integer appliedCount) {
            this.appliedCount = JsonField.ofNullable(appliedCount);
            return this;
        }

        /**
         * The {@code coupon_id} property.
         *
         * @param couponId the value
         * @return this builder
         */
        public Builder couponId(String couponId) {
            this.couponId = couponId;
            return this;
        }

        /**
         * The {@code created_at} property.
         *
         * @param createdAt the value
         * @return this builder
         */
        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * The {@code id} property.
         *
         * @param id the value
         * @return this builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * The {@code is_active} property.
         *
         * @param isActive the value
         * @return this builder
         */
        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        /**
         * The {@code last_applied_at} property.
         *
         * @param lastAppliedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder lastAppliedAt(OffsetDateTime lastAppliedAt) {
            this.lastAppliedAt = JsonField.ofNullable(lastAppliedAt);
            return this;
        }

        /**
         * A property the SDK does not know, sent along.
         *
         * @param name the property name
         * @param value the JSON value
         * @return this builder
         */
        public Builder putAdditionalProperty(String name, JsonNode value) {
            additionalProperties.put(name, value);
            return this;
        }

        /**
         * Properties the SDK does not know, sent along.
         *
         * @param additionalProperties the properties by name
         * @return this builder
         */
        public Builder putAllAdditionalProperties(Map<String, JsonNode> additionalProperties) {
            this.additionalProperties.putAll(additionalProperties);
            return this;
        }

        /**
         * Leaves out a property the SDK does not know.
         *
         * @param name the property name
         * @return this builder
         */
        public Builder removeAdditionalProperty(String name) {
            additionalProperties.remove(name);
            return this;
        }

        /**
         * The {@code AppliedCoupon}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public AppliedCoupon build() {
            Utils.checkRequired(couponId, "coupon_id");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(isActive, "is_active");
            return new AppliedCoupon(this);
        }
    }

    /**
     * Parse {@code json} as {@code AppliedCoupon}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static AppliedCoupon fromJson(String json) {
        return Utils.parse(json, AppliedCoupon.class);
    }

    /**
     * This value as JSON.
     *
     * @return the JSON text
     */
    public String toJson() {
        return Utils.json(this);
    }
}
