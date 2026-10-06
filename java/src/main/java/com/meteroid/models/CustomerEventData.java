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
public final class CustomerEventData {
    @JsonProperty("alias")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> alias = JsonField.missing();

    @JsonProperty("billing_email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> billingEmail = JsonField.missing();

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("invoicing_emails")
    private List<String> invoicingEmails;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> phone = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CustomerEventData() {}

    private CustomerEventData(Builder builder) {
        this.alias = builder.alias;
        this.billingEmail = builder.billingEmail;
        this.currency = builder.currency;
        this.customProperties = builder.customProperties;
        this.customerId = builder.customerId;
        this.invoicingEmails = Utils.copyList(builder.invoicingEmails);
        this.name = builder.name;
        this.phone = builder.phone;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CustomerEventData}.
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
        builder.billingEmail = billingEmail;
        builder.currency = currency;
        builder.customProperties = customProperties;
        builder.customerId = customerId;
        builder.invoicingEmails = Utils.mutableList(invoicingEmails);
        builder.name = name;
        builder.phone = phone;
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
     * The {@code billing_email} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> billingEmail() {
        return billingEmail.asOptional();
    }

    /**
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public String currency() {
        return Utils.required(currency, "currency");
    }

    /**
     * User-defined custom property values, keyed by definition key.
     *
     * @return the value, never null
     */
    public Object customProperties() {
        return Utils.required(customProperties, "custom_properties");
    }

    /**
     * The {@code customer_id} property.
     *
     * @return the value, never null
     */
    public String customerId() {
        return Utils.required(customerId, "customer_id");
    }

    /**
     * The {@code invoicing_emails} property.
     *
     * @return the value, never null
     */
    public List<String> invoicingEmails() {
        return Utils.required(invoicingEmails, "invoicing_emails");
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
     * The {@code phone} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> phone() {
        return phone.asOptional();
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
        CustomerEventData that = (CustomerEventData) o;
        return Objects.equals(alias, that.alias)
                && Objects.equals(billingEmail, that.billingEmail)
                && Objects.equals(currency, that.currency)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(invoicingEmails, that.invoicingEmails)
                && Objects.equals(name, that.name)
                && Objects.equals(phone, that.phone)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                alias,
                billingEmail,
                currency,
                customProperties,
                customerId,
                invoicingEmails,
                name,
                phone,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "CustomerEventData{"
                + "alias="
                + alias
                + ", billingEmail="
                + billingEmail
                + ", currency="
                + currency
                + ", customProperties="
                + customProperties
                + ", customerId="
                + customerId
                + ", invoicingEmails="
                + invoicingEmails
                + ", name="
                + name
                + ", phone="
                + phone
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link CustomerEventData}. */
    public static final class Builder {
        private JsonField<String> alias = JsonField.missing();
        private JsonField<String> billingEmail = JsonField.missing();
        private String currency;
        private Object customProperties;
        private String customerId;
        private List<String> invoicingEmails;
        private String name;
        private JsonField<String> phone = JsonField.missing();
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
         * The {@code billing_email} property.
         *
         * @param billingEmail the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder billingEmail(String billingEmail) {
            this.billingEmail = JsonField.ofNullable(billingEmail);
            return this;
        }

        /**
         * The {@code currency} property.
         *
         * @param currency the value
         * @return this builder
         */
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * User-defined custom property values, keyed by definition key.
         *
         * @param customProperties the value
         * @return this builder
         */
        public Builder customProperties(Object customProperties) {
            this.customProperties = customProperties;
            return this;
        }

        /**
         * The {@code customer_id} property.
         *
         * @param customerId the value
         * @return this builder
         */
        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        /**
         * The {@code invoicing_emails} property.
         *
         * @param invoicingEmails the value
         * @return this builder
         */
        public Builder invoicingEmails(List<String> invoicingEmails) {
            this.invoicingEmails = Utils.mutableList(invoicingEmails);
            return this;
        }

        /**
         * Adds an item to {@code invoicing_emails}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addInvoicingEmailsItem(String item) {
            if (this.invoicingEmails == null) {
                this.invoicingEmails = new ArrayList<>();
            }
            this.invoicingEmails.add(item);
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
         * The {@code phone} property.
         *
         * @param phone the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder phone(String phone) {
            this.phone = JsonField.ofNullable(phone);
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
         * The {@code CustomerEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CustomerEventData build() {
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(customProperties, "custom_properties");
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(invoicingEmails, "invoicing_emails");
            Utils.checkRequired(name, "name");
            return new CustomerEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code CustomerEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CustomerEventData fromJson(String json) {
        return Utils.parse(json, CustomerEventData.class);
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
