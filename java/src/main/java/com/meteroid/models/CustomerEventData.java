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
public class CustomerEventData {
    @JsonProperty private String alias;

    @JsonProperty("billing_email")
    private String billingEmail;

    @JsonProperty private String currency;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("invoicing_emails")
    private List<String> invoicingEmails;

    @JsonProperty private String name;
    @JsonProperty private String phone;

    public CustomerEventData() {}

    public CustomerEventData alias(String alias) {
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

    public CustomerEventData billingEmail(String billingEmail) {
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

    public CustomerEventData currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @javax.annotation.Nonnull
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CustomerEventData customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Get customerId
     *
     * @return customerId
     */
    @javax.annotation.Nonnull
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerEventData invoicingEmails(List<String> invoicingEmails) {
        this.invoicingEmails = invoicingEmails;
        return this;
    }

    public CustomerEventData addInvoicingEmailsItem(String invoicingEmailsItem) {
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

    public CustomerEventData name(String name) {
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

    public CustomerEventData phone(String phone) {
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

    /**
     * Create an instance of CustomerEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of CustomerEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     CustomerEventData
     */
    public static CustomerEventData fromJson(String jsonString) throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, CustomerEventData.class);
    }

    /**
     * Convert an instance of CustomerEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
