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
public final class Customer {
    @JsonProperty("alias")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> alias = JsonField.missing();

    @JsonProperty("billing_address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Address> billingAddress = JsonField.missing();

    @JsonProperty("billing_email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> billingEmail = JsonField.missing();

    @JsonProperty("connected_account_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> connectedAccountId = JsonField.missing();

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("custom_taxes")
    private List<CustomTaxRate> customTaxes;

    @JsonProperty("customer_type")
    private CustomerType customerType;

    @JsonProperty("first_name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> firstName = JsonField.missing();

    @JsonProperty("id")
    private String id;

    @JsonProperty("invoicing_emails")
    private List<String> invoicingEmails;

    @JsonProperty("invoicing_entity_id")
    private String invoicingEntityId;

    @JsonProperty("invoicing_language")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoicingLanguage = JsonField.missing();

    @JsonProperty("last_name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> lastName = JsonField.missing();

    @JsonProperty("legal_number")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> legalNumber = JsonField.missing();

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> phone = JsonField.missing();

    @JsonProperty("preferred_locales")
    private List<String> preferredLocales;

    @JsonProperty("shipping_address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<ShippingAddress> shippingAddress = JsonField.missing();

    @JsonProperty("vat_number")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> vatNumber = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private Customer() {}

    private Customer(Builder builder) {
        this.alias = builder.alias;
        this.billingAddress = builder.billingAddress;
        this.billingEmail = builder.billingEmail;
        this.connectedAccountId = builder.connectedAccountId;
        this.currency = builder.currency;
        this.customProperties = builder.customProperties;
        this.customTaxes = Utils.copyList(builder.customTaxes);
        this.customerType = builder.customerType;
        this.firstName = builder.firstName;
        this.id = builder.id;
        this.invoicingEmails = Utils.copyList(builder.invoicingEmails);
        this.invoicingEntityId = builder.invoicingEntityId;
        this.invoicingLanguage = builder.invoicingLanguage;
        this.lastName = builder.lastName;
        this.legalNumber = builder.legalNumber;
        this.name = builder.name;
        this.phone = builder.phone;
        this.preferredLocales = Utils.copyList(builder.preferredLocales);
        this.shippingAddress = builder.shippingAddress;
        this.vatNumber = builder.vatNumber;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code Customer}.
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
        builder.billingEmail = billingEmail;
        builder.connectedAccountId = connectedAccountId;
        builder.currency = currency;
        builder.customProperties = customProperties;
        builder.customTaxes = Utils.mutableList(customTaxes);
        builder.customerType = customerType;
        builder.firstName = firstName;
        builder.id = id;
        builder.invoicingEmails = Utils.mutableList(invoicingEmails);
        builder.invoicingEntityId = invoicingEntityId;
        builder.invoicingLanguage = invoicingLanguage;
        builder.lastName = lastName;
        builder.legalNumber = legalNumber;
        builder.name = name;
        builder.phone = phone;
        builder.preferredLocales = Utils.mutableList(preferredLocales);
        builder.shippingAddress = shippingAddress;
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
     * The {@code billing_email} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> billingEmail() {
        return billingEmail.asOptional();
    }

    /**
     * The {@code connected_account_id} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> connectedAccountId() {
        return connectedAccountId.asOptional();
    }

    /**
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public Currency currency() {
        return Utils.required(currency, "currency");
    }

    /**
     * User-defined custom property values, keyed by definition <code>key</code>.
     *
     * @return the value, never null
     */
    public Object customProperties() {
        return Utils.required(customProperties, "custom_properties");
    }

    /**
     * The {@code custom_taxes} property.
     *
     * @return the value, never null
     */
    public List<CustomTaxRate> customTaxes() {
        return Utils.required(customTaxes, "custom_taxes");
    }

    /**
     * The {@code customer_type} property.
     *
     * @return the value, empty when unset
     */
    public Optional<CustomerType> customerType() {
        return Optional.ofNullable(customerType);
    }

    /**
     * The {@code first_name} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> firstName() {
        return firstName.asOptional();
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
     * The {@code invoicing_emails} property.
     *
     * @return the value, never null
     */
    public List<String> invoicingEmails() {
        return Utils.required(invoicingEmails, "invoicing_emails");
    }

    /**
     * The {@code invoicing_entity_id} property.
     *
     * @return the value, never null
     */
    public String invoicingEntityId() {
        return Utils.required(invoicingEntityId, "invoicing_entity_id");
    }

    /**
     * Deprecated: the first entry of <code>preferred_locales</code>.
     *
     * @return the value, empty when unset or null
     * @deprecated the API deprecates this property.
     */
    @Deprecated
    public Optional<String> invoicingLanguage() {
        return invoicingLanguage.asOptional();
    }

    /**
     * The {@code last_name} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> lastName() {
        return lastName.asOptional();
    }

    /**
     * BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> legalNumber() {
        return legalNumber.asOptional();
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
     * Preferred document languages, most-preferred first (BCP-47 tags, e.g. <code>["fr-FR", "en"]
     * </code>); overrides the invoicing entity default.
     *
     * @return the value, never null
     */
    public List<String> preferredLocales() {
        return Utils.required(preferredLocales, "preferred_locales");
    }

    /**
     * The {@code shipping_address} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<ShippingAddress> shippingAddress() {
        return shippingAddress.asOptional();
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
        Customer that = (Customer) o;
        return Objects.equals(alias, that.alias)
                && Objects.equals(billingAddress, that.billingAddress)
                && Objects.equals(billingEmail, that.billingEmail)
                && Objects.equals(connectedAccountId, that.connectedAccountId)
                && Objects.equals(currency, that.currency)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customTaxes, that.customTaxes)
                && Objects.equals(customerType, that.customerType)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(id, that.id)
                && Objects.equals(invoicingEmails, that.invoicingEmails)
                && Objects.equals(invoicingEntityId, that.invoicingEntityId)
                && Objects.equals(invoicingLanguage, that.invoicingLanguage)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(legalNumber, that.legalNumber)
                && Objects.equals(name, that.name)
                && Objects.equals(phone, that.phone)
                && Objects.equals(preferredLocales, that.preferredLocales)
                && Objects.equals(shippingAddress, that.shippingAddress)
                && Objects.equals(vatNumber, that.vatNumber)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                alias,
                billingAddress,
                billingEmail,
                connectedAccountId,
                currency,
                customProperties,
                customTaxes,
                customerType,
                firstName,
                id,
                invoicingEmails,
                invoicingEntityId,
                invoicingLanguage,
                lastName,
                legalNumber,
                name,
                phone,
                preferredLocales,
                shippingAddress,
                vatNumber,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "Customer{"
                + "alias="
                + alias
                + ", billingAddress="
                + billingAddress
                + ", billingEmail="
                + billingEmail
                + ", connectedAccountId="
                + connectedAccountId
                + ", currency="
                + currency
                + ", customProperties="
                + customProperties
                + ", customTaxes="
                + customTaxes
                + ", customerType="
                + customerType
                + ", firstName="
                + firstName
                + ", id="
                + id
                + ", invoicingEmails="
                + invoicingEmails
                + ", invoicingEntityId="
                + invoicingEntityId
                + ", invoicingLanguage="
                + invoicingLanguage
                + ", lastName="
                + lastName
                + ", legalNumber="
                + legalNumber
                + ", name="
                + name
                + ", phone="
                + phone
                + ", preferredLocales="
                + preferredLocales
                + ", shippingAddress="
                + shippingAddress
                + ", vatNumber="
                + vatNumber
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link Customer}. */
    public static final class Builder {
        private JsonField<String> alias = JsonField.missing();
        private JsonField<Address> billingAddress = JsonField.missing();
        private JsonField<String> billingEmail = JsonField.missing();
        private JsonField<String> connectedAccountId = JsonField.missing();
        private Currency currency;
        private Object customProperties;
        private List<CustomTaxRate> customTaxes;
        private CustomerType customerType;
        private JsonField<String> firstName = JsonField.missing();
        private String id;
        private List<String> invoicingEmails;
        private String invoicingEntityId;
        private JsonField<String> invoicingLanguage = JsonField.missing();
        private JsonField<String> lastName = JsonField.missing();
        private JsonField<String> legalNumber = JsonField.missing();
        private String name;
        private JsonField<String> phone = JsonField.missing();
        private List<String> preferredLocales;
        private JsonField<ShippingAddress> shippingAddress = JsonField.missing();
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
         * The {@code connected_account_id} property.
         *
         * @param connectedAccountId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder connectedAccountId(String connectedAccountId) {
            this.connectedAccountId = JsonField.ofNullable(connectedAccountId);
            return this;
        }

        /**
         * The {@code currency} property.
         *
         * @param currency the value
         * @return this builder
         */
        public Builder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        /**
         * User-defined custom property values, keyed by definition <code>key</code>.
         *
         * @param customProperties the value
         * @return this builder
         */
        public Builder customProperties(Object customProperties) {
            this.customProperties = customProperties;
            return this;
        }

        /**
         * The {@code custom_taxes} property.
         *
         * @param customTaxes the value
         * @return this builder
         */
        public Builder customTaxes(List<CustomTaxRate> customTaxes) {
            this.customTaxes = Utils.mutableList(customTaxes);
            return this;
        }

        /**
         * Adds an item to {@code custom_taxes}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addCustomTaxesItem(CustomTaxRate item) {
            if (this.customTaxes == null) {
                this.customTaxes = new ArrayList<>();
            }
            this.customTaxes.add(item);
            return this;
        }

        /**
         * The {@code customer_type} property.
         *
         * @param customerType the value
         * @return this builder
         */
        public Builder customerType(CustomerType customerType) {
            this.customerType = customerType;
            return this;
        }

        /**
         * The {@code first_name} property.
         *
         * @param firstName the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder firstName(String firstName) {
            this.firstName = JsonField.ofNullable(firstName);
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
         * The {@code invoicing_entity_id} property.
         *
         * @param invoicingEntityId the value
         * @return this builder
         */
        public Builder invoicingEntityId(String invoicingEntityId) {
            this.invoicingEntityId = invoicingEntityId;
            return this;
        }

        /**
         * Deprecated: the first entry of <code>preferred_locales</code>.
         *
         * @param invoicingLanguage the value, null to send an explicit {@code null}
         * @return this builder
         * @deprecated the API deprecates this property.
         */
        @Deprecated
        public Builder invoicingLanguage(String invoicingLanguage) {
            this.invoicingLanguage = JsonField.ofNullable(invoicingLanguage);
            return this;
        }

        /**
         * The {@code last_name} property.
         *
         * @param lastName the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder lastName(String lastName) {
            this.lastName = JsonField.ofNullable(lastName);
            return this;
        }

        /**
         * BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB).
         *
         * @param legalNumber the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder legalNumber(String legalNumber) {
            this.legalNumber = JsonField.ofNullable(legalNumber);
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
         * Preferred document languages, most-preferred first (BCP-47 tags, e.g. <code>
         * ["fr-FR", "en"]</code>); overrides the invoicing entity default.
         *
         * @param preferredLocales the value
         * @return this builder
         */
        public Builder preferredLocales(List<String> preferredLocales) {
            this.preferredLocales = Utils.mutableList(preferredLocales);
            return this;
        }

        /**
         * Adds an item to {@code preferred_locales}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addPreferredLocalesItem(String item) {
            if (this.preferredLocales == null) {
                this.preferredLocales = new ArrayList<>();
            }
            this.preferredLocales.add(item);
            return this;
        }

        /**
         * The {@code shipping_address} property.
         *
         * @param shippingAddress the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder shippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = JsonField.ofNullable(shippingAddress);
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
         * The {@code Customer}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public Customer build() {
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(customProperties, "custom_properties");
            Utils.checkRequired(customTaxes, "custom_taxes");
            Utils.checkRequired(id, "id");
            Utils.checkRequired(invoicingEmails, "invoicing_emails");
            Utils.checkRequired(invoicingEntityId, "invoicing_entity_id");
            Utils.checkRequired(name, "name");
            Utils.checkRequired(preferredLocales, "preferred_locales");
            return new Customer(this);
        }
    }

    /**
     * Parse {@code json} as {@code Customer}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static Customer fromJson(String json) {
        return Utils.parse(json, Customer.class);
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
