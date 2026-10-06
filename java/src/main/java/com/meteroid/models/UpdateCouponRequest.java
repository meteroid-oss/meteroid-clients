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
public final class UpdateCouponRequest {
    @JsonProperty("description")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("discount")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<CouponDiscount> discount = JsonField.missing();

    @JsonProperty("plan_ids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<String>> planIds = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private UpdateCouponRequest() {}

    private UpdateCouponRequest(Builder builder) {
        this.description = builder.description;
        this.discount = builder.discount;
        this.planIds = builder.planIds.map(Utils::copyList);
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code UpdateCouponRequest}.
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
        builder.description = description;
        builder.discount = discount;
        builder.planIds = planIds.map(Utils::mutableList);
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * @return the value, empty when unset or null
     */
    public Optional<CouponDiscount> discount() {
        return discount.asOptional();
    }

    /**
     * The {@code plan_ids} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<String>> planIds() {
        return planIds.asOptional();
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
        UpdateCouponRequest that = (UpdateCouponRequest) o;
        return Objects.equals(description, that.description)
                && Objects.equals(discount, that.discount)
                && Objects.equals(planIds, that.planIds)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, discount, planIds, additionalProperties);
    }

    @Override
    public String toString() {
        return "UpdateCouponRequest{"
                + "description="
                + description
                + ", discount="
                + discount
                + ", planIds="
                + planIds
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link UpdateCouponRequest}. */
    public static final class Builder {
        private JsonField<String> description = JsonField.missing();
        private JsonField<CouponDiscount> discount = JsonField.missing();
        private JsonField<List<String>> planIds = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * @param discount the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder discount(CouponDiscount discount) {
            this.discount = JsonField.ofNullable(discount);
            return this;
        }

        /**
         * The {@code plan_ids} property.
         *
         * @param planIds the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder planIds(List<String> planIds) {
            this.planIds = JsonField.ofNullable(Utils.mutableList(planIds));
            return this;
        }

        /**
         * Adds an item to {@code plan_ids}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addPlanIdsItem(String item) {
            List<String> items = this.planIds.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.planIds = JsonField.ofNullable(items);
            }
            items.add(item);
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
         * The {@code UpdateCouponRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public UpdateCouponRequest build() {
            return new UpdateCouponRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code UpdateCouponRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static UpdateCouponRequest fromJson(String json) {
        return Utils.parse(json, UpdateCouponRequest.class);
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
