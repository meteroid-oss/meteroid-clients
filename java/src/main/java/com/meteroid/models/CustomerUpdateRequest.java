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
public final class CustomerUpdateRequest {
    @JsonProperty("alias")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> alias = JsonField.missing();

    @JsonProperty("billing_address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Address> billingAddress = JsonField.missing();

    @JsonProperty("billing_email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> billingEmail = JsonField.missing();

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("custom_properties")
    private Object customProperties;

    @JsonProperty("custom_taxes")
    private List<CustomTaxRate> customTaxes;

    @JsonProperty("customer_type")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<CustomerType> customerType = JsonField.missing();

    @JsonProperty("exemption_reason")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> exemptionReason = JsonField.missing();

    @JsonProperty("first_name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> firstName = JsonField.missing();

    @JsonProperty("invoicing_emails")
    private List<String> invoicingEmails;

    @JsonProperty("invoicing_entity_id")
    private String invoicingEntityId;

    @JsonProperty("invoicing_language")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoicingLanguage = JsonField.missing();

    @JsonProperty("is_tax_exempt")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Boolean> isTaxExempt = JsonField.missing();

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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<List<String>> preferredLocales = JsonField.missing();

    @JsonProperty("shipping_address")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<ShippingAddress> shippingAddress = JsonField.missing();

    @JsonProperty("vat_number")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> vatNumber = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private CustomerUpdateRequest() {}

    private CustomerUpdateRequest(Builder builder) {
        this.alias = builder.alias;
        this.billingAddress = builder.billingAddress;
        this.billingEmail = builder.billingEmail;
        this.currency = builder.currency;
        this.customProperties = builder.customProperties;
        this.customTaxes = Utils.copyList(builder.customTaxes);
        this.customerType = builder.customerType;
        this.exemptionReason = builder.exemptionReason;
        this.firstName = builder.firstName;
        this.invoicingEmails = Utils.copyList(builder.invoicingEmails);
        this.invoicingEntityId = builder.invoicingEntityId;
        this.invoicingLanguage = builder.invoicingLanguage;
        this.isTaxExempt = builder.isTaxExempt;
        this.lastName = builder.lastName;
        this.legalNumber = builder.legalNumber;
        this.name = builder.name;
        this.phone = builder.phone;
        this.preferredLocales = builder.preferredLocales.map(Utils::copyList);
        this.shippingAddress = builder.shippingAddress;
        this.vatNumber = builder.vatNumber;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code CustomerUpdateRequest}.
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
        builder.currency = currency;
        builder.customProperties = customProperties;
        builder.customTaxes = Utils.mutableList(customTaxes);
        builder.customerType = customerType;
        builder.exemptionReason = exemptionReason;
        builder.firstName = firstName;
        builder.invoicingEmails = Utils.mutableList(invoicingEmails);
        builder.invoicingEntityId = invoicingEntityId;
        builder.invoicingLanguage = invoicingLanguage;
        builder.isTaxExempt = isTaxExempt;
        builder.lastName = lastName;
        builder.legalNumber = legalNumber;
        builder.name = name;
        builder.phone = phone;
        builder.preferredLocales = preferredLocales.map(Utils::mutableList);
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
     * The {@code currency} property.
     *
     * @return the value, never null
     */
    public Currency currency() {
        return Utils.required(currency, "currency");
    }

    /**
     * User-defined custom property values (full replace). Omit to leave unchanged.
     *
     * @return the value, empty when unset
     */
    public Optional<Object> customProperties() {
        return Optional.ofNullable(customProperties);
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
     * @return the value, empty when unset or null
     */
    public Optional<CustomerType> customerType() {
        return customerType.asOptional();
    }

    /**
     * Free-text legal exemption mention surfaced on exempt invoices.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> exemptionReason() {
        return exemptionReason.asOptional();
    }

    /**
     * Omit to keep the stored value (a full replace does not blank a person's name).
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> firstName() {
        return firstName.asOptional();
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
     * Deprecated: use <code>preferred_locales</code>. Applied only when <code>preferred_locales
     * </code> is absent.
     *
     * @return the value, empty when unset or null
     * @deprecated the API deprecates this property.
     */
    @Deprecated
    public Optional<String> invoicingLanguage() {
        return invoicingLanguage.asOptional();
    }

    /**
     * The {@code is_tax_exempt} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<Boolean> isTaxExempt() {
        return isTaxExempt.asOptional();
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
     * Required for <code>COMPANY</code>. Ignored for <code>INDIVIDUAL</code>: derived from <code>
     * first_name</code> + <code>last_name</code>.
     *
     * @return the value, empty when unset
     */
    public Optional<String> name() {
        return Optional.ofNullable(name);
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
     * </code>); overrides the invoicing entity default. Omit or send <code>[]</code> to reset to
     * that default (full-replace update).
     *
     * @return the value, empty when unset or null
     */
    public Optional<List<String>> preferredLocales() {
        return preferredLocales.asOptional();
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
        CustomerUpdateRequest that = (CustomerUpdateRequest) o;
        return Objects.equals(alias, that.alias)
                && Objects.equals(billingAddress, that.billingAddress)
                && Objects.equals(billingEmail, that.billingEmail)
                && Objects.equals(currency, that.currency)
                && Objects.equals(customProperties, that.customProperties)
                && Objects.equals(customTaxes, that.customTaxes)
                && Objects.equals(customerType, that.customerType)
                && Objects.equals(exemptionReason, that.exemptionReason)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(invoicingEmails, that.invoicingEmails)
                && Objects.equals(invoicingEntityId, that.invoicingEntityId)
                && Objects.equals(invoicingLanguage, that.invoicingLanguage)
                && Objects.equals(isTaxExempt, that.isTaxExempt)
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
                currency,
                customProperties,
                customTaxes,
                customerType,
                exemptionReason,
                firstName,
                invoicingEmails,
                invoicingEntityId,
                invoicingLanguage,
                isTaxExempt,
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
        return "CustomerUpdateRequest{"
                + "alias="
                + alias
                + ", billingAddress="
                + billingAddress
                + ", billingEmail="
                + billingEmail
                + ", currency="
                + currency
                + ", customProperties="
                + customProperties
                + ", customTaxes="
                + customTaxes
                + ", customerType="
                + customerType
                + ", exemptionReason="
                + exemptionReason
                + ", firstName="
                + firstName
                + ", invoicingEmails="
                + invoicingEmails
                + ", invoicingEntityId="
                + invoicingEntityId
                + ", invoicingLanguage="
                + invoicingLanguage
                + ", isTaxExempt="
                + isTaxExempt
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

    /** Builds {@link CustomerUpdateRequest}. */
    public static final class Builder {
        private JsonField<String> alias = JsonField.missing();
        private JsonField<Address> billingAddress = JsonField.missing();
        private JsonField<String> billingEmail = JsonField.missing();
        private Currency currency;
        private Object customProperties;
        private List<CustomTaxRate> customTaxes;
        private JsonField<CustomerType> customerType = JsonField.missing();
        private JsonField<String> exemptionReason = JsonField.missing();
        private JsonField<String> firstName = JsonField.missing();
        private List<String> invoicingEmails;
        private String invoicingEntityId;
        private JsonField<String> invoicingLanguage = JsonField.missing();
        private JsonField<Boolean> isTaxExempt = JsonField.missing();
        private JsonField<String> lastName = JsonField.missing();
        private JsonField<String> legalNumber = JsonField.missing();
        private String name;
        private JsonField<String> phone = JsonField.missing();
        private JsonField<List<String>> preferredLocales = JsonField.missing();
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
         * User-defined custom property values (full replace). Omit to leave unchanged.
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
         * @param customerType the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder customerType(CustomerType customerType) {
            this.customerType = JsonField.ofNullable(customerType);
            return this;
        }

        /**
         * Free-text legal exemption mention surfaced on exempt invoices.
         *
         * @param exemptionReason the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder exemptionReason(String exemptionReason) {
            this.exemptionReason = JsonField.ofNullable(exemptionReason);
            return this;
        }

        /**
         * Omit to keep the stored value (a full replace does not blank a person's name).
         *
         * @param firstName the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder firstName(String firstName) {
            this.firstName = JsonField.ofNullable(firstName);
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
         * Deprecated: use <code>preferred_locales</code>. Applied only when <code>preferred_locales
         * </code> is absent.
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
         * The {@code is_tax_exempt} property.
         *
         * @param isTaxExempt the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder isTaxExempt(Boolean isTaxExempt) {
            this.isTaxExempt = JsonField.ofNullable(isTaxExempt);
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
         * Required for <code>COMPANY</code>. Ignored for <code>INDIVIDUAL</code>: derived from
         * <code>first_name</code> + <code>last_name</code>.
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
         * ["fr-FR", "en"]</code>); overrides the invoicing entity default. Omit or send <code>[]
         * </code> to reset to that default (full-replace update).
         *
         * @param preferredLocales the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder preferredLocales(List<String> preferredLocales) {
            this.preferredLocales = JsonField.ofNullable(Utils.mutableList(preferredLocales));
            return this;
        }

        /**
         * Adds an item to {@code preferred_locales}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addPreferredLocalesItem(String item) {
            List<String> items = this.preferredLocales.orNull();
            if (items == null) {
                items = new ArrayList<>();
                this.preferredLocales = JsonField.ofNullable(items);
            }
            items.add(item);
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
         * The {@code CustomerUpdateRequest}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public CustomerUpdateRequest build() {
            Utils.checkRequired(currency, "currency");
            Utils.checkRequired(customTaxes, "custom_taxes");
            Utils.checkRequired(invoicingEmails, "invoicing_emails");
            Utils.checkRequired(invoicingEntityId, "invoicing_entity_id");
            return new CustomerUpdateRequest(this);
        }
    }

    /**
     * Parse {@code json} as {@code CustomerUpdateRequest}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static CustomerUpdateRequest fromJson(String json) {
        return Utils.parse(json, CustomerUpdateRequest.class);
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
