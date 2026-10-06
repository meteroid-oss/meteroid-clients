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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
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
public final class CreateCouponRequest {
    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("discount")
    private CouponDiscount discount;

    @JsonProperty("expires_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> expiresAt = JsonField.missing();

    @JsonProperty("plan_ids")
    private List<String> planIds;

    @JsonProperty("recurring_value")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> recurringValue = JsonField.missing();

    @JsonProperty("redemption_limit")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> redemptionLimit = JsonField.missing();

    @JsonProperty("reusable")
    private Boolean reusable;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CreateCouponRequest() {}

    private CreateCouponRequest(Builder builder) {
        this.code = builder.code;
        this.description = builder.description;
        this.discount = builder.discount;
        this.expiresAt = builder.expiresAt;
        this.planIds = Utils.copyList(builder.planIds);
        this.recurringValue = builder.recurringValue;
        this.redemptionLimit = builder.redemptionLimit;
        this.reusable = builder.reusable;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CreateCouponRequest}.
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
        builder.code = code;
        builder.description = description;
        builder.discount = discount;
        builder.expiresAt = expiresAt;
        builder.planIds = Utils.mutableList(planIds);
        builder.recurringValue = recurringValue;
        builder.redemptionLimit = redemptionLimit;
        builder.reusable = reusable;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code code} property.
     *
     * @return the value, never null
     */
    public String code() {
        return Utils.required(code, "code");
    }

    /**
     * The {@code description} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> description() {
        return description.asOptional();
    }

    /**
     * The {@code discount} property.
     *
     * @return the value, never null
     */
    public CouponDiscount discount() {
        return Utils.required(discount, "discount");
    }

    /**
     * The {@code expires_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> expiresAt() {
        return expiresAt.asOptional();
    }

    /**
     * The {@code plan_ids} property.
     *
     * @return the value, empty when unset
     */
    public Optional<List<String>> planIds() {
        return Optional.ofNullable(planIds);
    }

    /**
     * The {@code recurring_value} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> recurringValue() {
        return recurringValue.asOptional();
    }

    /**
     * The {@code redemption_limit} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Integer> redemptionLimit() {
        return redemptionLimit.asOptional();
    }

    /**
     * The {@code reusable} property.
     *
     * @return the value, empty when unset
     */
    public Optional<Boolean> reusable() {
        return Optional.ofNullable(reusable);
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
        CreateCouponRequest that = (CreateCouponRequest) o;
        return Objects.equals(code, that.code)
                && Objects.equals(description, that.description)
                && Objects.equals(discount, that.discount)
                && Objects.equals(expiresAt, that.expiresAt)
                && Objects.equals(planIds, that.planIds)
                && Objects.equals(recurringValue, that.recurringValue)
                && Objects.equals(redemptionLimit, that.redemptionLimit)
                && Objects.equals(reusable, that.reusable)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                code,
                description,
                discount,
                expiresAt,
                planIds,
                recurringValue,
                redemptionLimit,
                reusable,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CreateCouponRequest{"
                + "code="
                + code
                + ", description="
                + description
                + ", discount="
                + discount
                + ", expiresAt="
                + expiresAt
                + ", planIds="
                + planIds
                + ", recurringValue="
                + recurringValue
                + ", redemptionLimit="
                + redemptionLimit
                + ", reusable="
                + reusable
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CreateCouponRequest}. */
    public static final class Builder {
        private String code;
        private JsonField<String> description = JsonField.missing();
        private CouponDiscount discount;
        private JsonField<OffsetDateTime> expiresAt = JsonField.missing();
        private List<String> planIds;
        private JsonField<Integer> recurringValue = JsonField.missing();
        private JsonField<Integer> redemptionLimit = JsonField.missing();
        private Boolean reusable;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code code} property.
         *
         * @param code the value
         * @return this builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * The {@code description} property.
         *
         * @param description the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder description(String description) {
            this.description = JsonField.ofNullable(description);
            return this;
        }

        /**
         * The {@code discount} property.
         *
         * @param discount the value
         * @return this builder
         */
        public Builder discount(CouponDiscount discount) {
            this.discount = discount;
            return this;
        }

        /**
         * The {@code expires_at} property.
         *
         * @param expiresAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder expiresAt(OffsetDateTime expiresAt) {
            this.expiresAt = JsonField.ofNullable(expiresAt);
            return this;
        }

        /**
         * The {@code plan_ids} property.
         *
         * @param planIds the value
         * @return this builder
         */
        public Builder planIds(List<String> planIds) {
            this.planIds = Utils.mutableList(planIds);
            return this;
        }

        /**
         * Adds an item to {@code plan_ids}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addPlanIdsItem(String item) {
            if (this.planIds == null) {
                this.planIds = new ArrayList<>();
            }
            this.planIds.add(item);
            return this;
        }

        /**
         * The {@code recurring_value} property.
         *
         * @param recurringValue the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder recurringValue(Integer recurringValue) {
            this.recurringValue = JsonField.ofNullable(recurringValue);
            return this;
        }

        /**
         * The {@code redemption_limit} property.
         *
         * @param redemptionLimit the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder redemptionLimit(Integer redemptionLimit) {
            this.redemptionLimit = JsonField.ofNullable(redemptionLimit);
            return this;
        }

        /**
         * The {@code reusable} property.
         *
         * @param reusable the value
         * @return this builder
         */
        public Builder reusable(Boolean reusable) {
            this.reusable = reusable;
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
         * The {@code CreateCouponRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CreateCouponRequest build() {
            Utils.checkRequired(code, "code");
            Utils.checkRequired(discount, "discount");
            return new CreateCouponRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CreateCouponRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CreateCouponRequest fromJson(String json) {
        return Utils.parse(json, CreateCouponRequest.class);
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
