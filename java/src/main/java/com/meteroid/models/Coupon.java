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
public final class Coupon {
    @JsonProperty("archived_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> archivedAt = JsonField.missing();

    @JsonProperty("code")
    private String code;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("disabled")
    private Boolean disabled;

    @JsonProperty("discount")
    private CouponDiscount discount;

    @JsonProperty("expires_at")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<OffsetDateTime> expiresAt = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("plan_ids")
    private List<String> planIds;

    @JsonProperty("recurring_value")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> recurringValue = JsonField.missing();

    @JsonProperty("redemption_count")
    private Integer redemptionCount;

    @JsonProperty("redemption_limit")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Integer> redemptionLimit = JsonField.missing();

    @JsonProperty("reusable")
    private Boolean reusable;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Coupon() {}

    private Coupon(Builder builder) {
        this.archivedAt = builder.archivedAt;
        this.code = builder.code;
        this.createdAt = builder.createdAt;
        this.description = builder.description;
        this.disabled = builder.disabled;
        this.discount = builder.discount;
        this.expiresAt = builder.expiresAt;
        this.id = builder.id;
        this.planIds = Utils.copyList(builder.planIds);
        this.recurringValue = builder.recurringValue;
        this.redemptionCount = builder.redemptionCount;
        this.redemptionLimit = builder.redemptionLimit;
        this.reusable = builder.reusable;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Coupon}.
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
        builder.archivedAt = archivedAt;
        builder.code = code;
        builder.createdAt = createdAt;
        builder.description = description;
        builder.disabled = disabled;
        builder.discount = discount;
        builder.expiresAt = expiresAt;
        builder.id = id;
        builder.planIds = Utils.mutableList(planIds);
        builder.recurringValue = recurringValue;
        builder.redemptionCount = redemptionCount;
        builder.redemptionLimit = redemptionLimit;
        builder.reusable = reusable;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code archived_at} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<OffsetDateTime> archivedAt() {
        return archivedAt.asOptional();
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
     * The {@code created_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime createdAt() {
        return Utils.required(createdAt, "created_at");
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
     * The {@code disabled} property.
     *
     * @return the value, never null
     */
    public Boolean disabled() {
        return Utils.required(disabled, "disabled");
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
     * The {@code id} property.
     *
     * @return the value, never null
     */
    public String id() {
        return Utils.required(id, "id");
    }

    /**
     * The {@code plan_ids} property.
     *
     * @return the value, never null
     */
    public List<String> planIds() {
        return Utils.required(planIds, "plan_ids");
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
     * The {@code redemption_count} property.
     *
     * @return the value, never null
     */
    public Integer redemptionCount() {
        return Utils.required(redemptionCount, "redemption_count");
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
     * @return the value, never null
     */
    public Boolean reusable() {
        return Utils.required(reusable, "reusable");
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
        Coupon that = (Coupon) o;
        return Objects.equals(archivedAt, that.archivedAt)
                && Objects.equals(code, that.code)
                && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(description, that.description)
                && Objects.equals(disabled, that.disabled)
                && Objects.equals(discount, that.discount)
                && Objects.equals(expiresAt, that.expiresAt)
                && Objects.equals(id, that.id)
                && Objects.equals(planIds, that.planIds)
                && Objects.equals(recurringValue, that.recurringValue)
                && Objects.equals(redemptionCount, that.redemptionCount)
                && Objects.equals(redemptionLimit, that.redemptionLimit)
                && Objects.equals(reusable, that.reusable)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                archivedAt,
                code,
                createdAt,
                description,
                disabled,
                discount,
                expiresAt,
                id,
                planIds,
                recurringValue,
                redemptionCount,
                redemptionLimit,
                reusable,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "Coupon{"
                + "archivedAt="
                + archivedAt
                + ", code="
                + code
                + ", createdAt="
                + createdAt
                + ", description="
                + description
                + ", disabled="
                + disabled
                + ", discount="
                + discount
                + ", expiresAt="
                + expiresAt
                + ", id="
                + id
                + ", planIds="
                + planIds
                + ", recurringValue="
                + recurringValue
                + ", redemptionCount="
                + redemptionCount
                + ", redemptionLimit="
                + redemptionLimit
                + ", reusable="
                + reusable
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Coupon}. */
    public static final class Builder {
        private JsonField<OffsetDateTime> archivedAt = JsonField.missing();
        private String code;
        private OffsetDateTime createdAt;
        private JsonField<String> description = JsonField.missing();
        private Boolean disabled;
        private CouponDiscount discount;
        private JsonField<OffsetDateTime> expiresAt = JsonField.missing();
        private String id;
        private List<String> planIds;
        private JsonField<Integer> recurringValue = JsonField.missing();
        private Integer redemptionCount;
        private JsonField<Integer> redemptionLimit = JsonField.missing();
        private Boolean reusable;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code archived_at} property.
         *
         * @param archivedAt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder archivedAt(OffsetDateTime archivedAt) {
            this.archivedAt = JsonField.ofNullable(archivedAt);
            return this;
        }

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
         * The {@code disabled} property.
         *
         * @param disabled the value
         * @return this builder
         */
        public Builder disabled(Boolean disabled) {
            this.disabled = disabled;
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
         * The {@code redemption_count} property.
         *
         * @param redemptionCount the value
         * @return this builder
         */
        public Builder redemptionCount(Integer redemptionCount) {
            this.redemptionCount = redemptionCount;
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
         * The {@code Coupon}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Coupon build() {
            Utils.checkRequired(code, "code");
            Utils.checkRequired(createdAt, "created_at");
            Utils.checkRequired(disabled, "disabled");
            Utils.checkRequired(discount, "discount");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(planIds, "plan_ids");
            Utils.checkRequired(redemptionCount, "redemption_count");
            Utils.checkRequired(reusable, "reusable");
            return new Coupon(this);
        }
    }

    /**
     * Parse {@code json} as {@code Coupon}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Coupon fromJson(String json) {
        return Utils.parse(json, Coupon.class);
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
