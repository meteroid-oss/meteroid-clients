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
import com.meteroid.internal.Utils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/** Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class CouponLineItem {
    @JsonProperty("coupon_id")
    private String couponId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("total")
    private Long total;

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CouponLineItem() {}

    private CouponLineItem(Builder builder) {
        this.couponId = builder.couponId;
        this.name = builder.name;
        this.total = builder.total;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CouponLineItem}.
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
        builder.couponId = couponId;
        builder.name = name;
        builder.total = total;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code total} property.
     *
     * @return the value, never null
     */
    public Long total() {
        return Utils.required(total, "total");
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
        CouponLineItem that = (CouponLineItem) o;
        return Objects.equals(couponId, that.couponId)
                && Objects.equals(name, that.name)
                && Objects.equals(total, that.total)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponId, name, total, additionalProperties);
    }

    @Override
    public String toString() {
        return "CouponLineItem{"
                + "couponId="
                + couponId
                + ", name="
                + name
                + ", total="
                + total
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CouponLineItem}. */
    public static final class Builder {
        private String couponId;
        private String name;
        private Long total;
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * The {@code name} property.
         *
         * @param name the value
         * @return this builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * The {@code total} property.
         *
         * @param total the value
         * @return this builder
         */
        public Builder total(Long total) {
            this.total = total;
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
         * The {@code CouponLineItem}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CouponLineItem build() {
            Utils.checkRequired(couponId, "coupon_id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(total, "total");
            return new CouponLineItem(this);
        }
    }

    /**
     * Parse {@code json} as {@code CouponLineItem}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CouponLineItem fromJson(String json) {
        return Utils.parse(json, CouponLineItem.class);
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
