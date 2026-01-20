// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.meteroid.Utils;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Customer {
    @JsonProperty private String alias;

    @JsonProperty("bank_account_id")
    private String bankAccountId;

    @JsonProperty("billing_address")
    private Address billingAddress;

    @JsonProperty("billing_email")
    private String billingEmail;

    @JsonProperty private Currency currency;

    @JsonProperty("custom_taxes")
    private List<CustomTaxRate> customTaxes;

    @JsonProperty private String id;

    @JsonProperty("invoicing_emails")
    private List<String> invoicingEmails;

    @JsonProperty("invoicing_entity_id")
    private String invoicingEntityId;

    @JsonProperty private String name;
    @JsonProperty private String phone;

    @JsonProperty("shipping_address")
    private ShippingAddress shippingAddress;

    @JsonProperty("vat_number")
    private String vatNumber;

    public Customer() {}

    public Customer alias(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * Get alias
     *
     * @return alias
     */
    @javax.annotation.Nullable
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Customer bankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
        return this;
    }

    /**
     * Get bankAccountId
     *
     * @return bankAccountId
     */
    @javax.annotation.Nullable
    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Customer billingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    /**
     * Get billingAddress
     *
     * @return billingAddress
     */
    @javax.annotation.Nullable
    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Customer billingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
        return this;
    }

    /**
     * Get billingEmail
     *
     * @return billingEmail
     */
    @javax.annotation.Nullable
    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public Customer currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @javax.annotation.Nonnull
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Customer customTaxes(List<CustomTaxRate> customTaxes) {
        this.customTaxes = customTaxes;
        return this;
    }

    public Customer addCustomTaxesItem(CustomTaxRate customTaxesItem) {
        if (this.customTaxes == null) {
            this.customTaxes = new ArrayList<>();
        }
        this.customTaxes.add(customTaxesItem);

        return this;
    }

    /**
     * Get customTaxes
     *
     * @return customTaxes
     */
    @javax.annotation.Nonnull
    public List<CustomTaxRate> getCustomTaxes() {
        return customTaxes;
    }

    public void setCustomTaxes(List<CustomTaxRate> customTaxes) {
        this.customTaxes = customTaxes;
    }

    public Customer id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer invoicingEmails(List<String> invoicingEmails) {
        this.invoicingEmails = invoicingEmails;
        return this;
    }

    public Customer addInvoicingEmailsItem(String invoicingEmailsItem) {
        if (this.invoicingEmails == null) {
            this.invoicingEmails = new ArrayList<>();
        }
        this.invoicingEmails.add(invoicingEmailsItem);

        return this;
    }

    /**
     * Get invoicingEmails
     *
     * @return invoicingEmails
     */
    @javax.annotation.Nonnull
    public List<String> getInvoicingEmails() {
        return invoicingEmails;
    }

    public void setInvoicingEmails(List<String> invoicingEmails) {
        this.invoicingEmails = invoicingEmails;
    }

    public Customer invoicingEntityId(String invoicingEntityId) {
        this.invoicingEntityId = invoicingEntityId;
        return this;
    }

    /**
     * Get invoicingEntityId
     *
     * @return invoicingEntityId
     */
    @javax.annotation.Nonnull
    public String getInvoicingEntityId() {
        return invoicingEntityId;
    }

    public void setInvoicingEntityId(String invoicingEntityId) {
        this.invoicingEntityId = invoicingEntityId;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     */
    @javax.annotation.Nullable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer shippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    /**
     * Get shippingAddress
     *
     * @return shippingAddress
     */
    @javax.annotation.Nullable
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Customer vatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    /**
     * Get vatNumber
     *
     * @return vatNumber
     */
    @javax.annotation.Nullable
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    /**
     * Create an instance of Customer given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Customer
     * @throws JsonProcessingException if the JSON string is invalid with respect to Customer
     */
    public static Customer fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, Customer.class);
    }

    /**
     * Convert an instance of Customer to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
