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
public final class CustomerDetails {
    @JsonProperty("alias")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> alias = JsonField.missing();

    @JsonProperty("billing_address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Address> billingAddress = JsonField.missing();

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> email = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("snapshot_at")
    private OffsetDateTime snapshotAt;

    @JsonProperty("vat_number")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> vatNumber = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CustomerDetails() {}

    private CustomerDetails(Builder builder) {
        this.alias = builder.alias;
        this.billingAddress = builder.billingAddress;
        this.email = builder.email;
        this.id = builder.id;
        this.name = builder.name;
        this.snapshotAt = builder.snapshotAt;
        this.vatNumber = builder.vatNumber;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CustomerDetails}.
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
        builder.alias = alias;
        builder.billingAddress = billingAddress;
        builder.email = email;
        builder.id = id;
        builder.name = name;
        builder.snapshotAt = snapshotAt;
        builder.vatNumber = vatNumber;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
    }

    /**
     * The {@code alias} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> alias() {
        return alias.asOptional();
    }

    /**
     * The {@code billing_address} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Address> billingAddress() {
        return billingAddress.asOptional();
    }

    /**
     * The {@code email} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> email() {
        return email.asOptional();
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
     * The {@code name} property.
     *
     * @return the value, never null
     */
    public String name() {
        return Utils.required(name, "name");
    }

    /**
     * The {@code snapshot_at} property.
     *
     * @return the value, never null
     */
    public OffsetDateTime snapshotAt() {
        return Utils.required(snapshotAt, "snapshot_at");
    }

    /**
     * The {@code vat_number} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> vatNumber() {
        return vatNumber.asOptional();
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
        CustomerDetails that = (CustomerDetails) o;
        return Objects.equals(alias, that.alias)
                && Objects.equals(billingAddress, that.billingAddress)
                && Objects.equals(email, that.email)
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(snapshotAt, that.snapshotAt)
                && Objects.equals(vatNumber, that.vatNumber)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                alias,
                billingAddress,
                email,
                id,
                name,
                snapshotAt,
                vatNumber,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CustomerDetails{"
                + "alias="
                + alias
                + ", billingAddress="
                + billingAddress
                + ", email="
                + email
                + ", id="
                + id
                + ", name="
                + name
                + ", snapshotAt="
                + snapshotAt
                + ", vatNumber="
                + vatNumber
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CustomerDetails}. */
    public static final class Builder {
        private JsonField<String> alias = JsonField.missing();
        private JsonField<Address> billingAddress = JsonField.missing();
        private JsonField<String> email = JsonField.missing();
        private String id;
        private String name;
        private OffsetDateTime snapshotAt;
        private JsonField<String> vatNumber = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

        /**
         * The {@code alias} property.
         *
         * @param alias the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder alias(String alias) {
            this.alias = JsonField.ofNullable(alias);
            return this;
        }

        /**
         * The {@code billing_address} property.
         *
         * @param billingAddress the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingAddress(Address billingAddress) {
            this.billingAddress = JsonField.ofNullable(billingAddress);
            return this;
        }

        /**
         * The {@code email} property.
         *
         * @param email the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder email(String email) {
            this.email = JsonField.ofNullable(email);
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
         * The {@code snapshot_at} property.
         *
         * @param snapshotAt the value
         * @return this builder
         */
        public Builder snapshotAt(OffsetDateTime snapshotAt) {
            this.snapshotAt = snapshotAt;
            return this;
        }

        /**
         * The {@code vat_number} property.
         *
         * @param vatNumber the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder vatNumber(String vatNumber) {
            this.vatNumber = JsonField.ofNullable(vatNumber);
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
         * The {@code CustomerDetails}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CustomerDetails build() {
            Utils.checkRequired(id, "id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(snapshotAt, "snapshot_at");
            return new CustomerDetails(this);
        }
    }

    /**
     * Parse {@code json} as {@code CustomerDetails}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CustomerDetails fromJson(String json) {
        return Utils.parse(json, CustomerDetails.class);
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
