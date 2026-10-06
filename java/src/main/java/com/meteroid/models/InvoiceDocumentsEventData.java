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

/**
 * Emitted once the accounting PDF is stored. This is also the moment the e-invoicing outcome is
 * known: the structured document is produced with the PDF, not at finalization.
 *
 * <p>Immutable: build one with {@link #builder()}, change a copy with {@link #toBuilder()}.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        getterVisibility = Visibility.NONE,
        isGetterVisibility = Visibility.NONE,
        setterVisibility = Visibility.NONE)
public final class InvoiceDocumentsEventData {
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("einvoicing_error")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> einvoicingError = JsonField.missing();

    @JsonProperty("einvoicing_findings")
    private List<EInvoicingFinding> einvoicingFindings;

    @JsonProperty("einvoicing_profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> einvoicingProfile = JsonField.missing();

    @JsonProperty("einvoicing_status")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<EInvoicingStatus> einvoicingStatus = JsonField.missing();

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("pdf_document_id")
    private String pdfDocumentId;

    @JsonProperty("xml_document_id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> xmlDocumentId = JsonField.missing();

    private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

    private InvoiceDocumentsEventData() {}

    private InvoiceDocumentsEventData(Builder builder) {
        this.customerId = builder.customerId;
        this.einvoicingError = builder.einvoicingError;
        this.einvoicingFindings = Utils.copyList(builder.einvoicingFindings);
        this.einvoicingProfile = builder.einvoicingProfile;
        this.einvoicingStatus = builder.einvoicingStatus;
        this.invoiceId = builder.invoiceId;
        this.pdfDocumentId = builder.pdfDocumentId;
        this.xmlDocumentId = builder.xmlDocumentId;
        this.additionalProperties.putAll(builder.additionalProperties);
    }

    /**
     * A builder of {@code InvoiceDocumentsEventData}.
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
        builder.customerId = customerId;
        builder.einvoicingError = einvoicingError;
        builder.einvoicingFindings = Utils.mutableList(einvoicingFindings);
        builder.einvoicingProfile = einvoicingProfile;
        builder.einvoicingStatus = einvoicingStatus;
        builder.invoiceId = invoiceId;
        builder.pdfDocumentId = pdfDocumentId;
        builder.xmlDocumentId = xmlDocumentId;
        builder.additionalProperties.putAll(additionalProperties);
        return builder;
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
     * Set when generation failed for a reason that is not a business rule.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> einvoicingError() {
        return einvoicingError.asOptional();
    }

    /**
     * Empty unless the status is <code>failed</code>.
     *
     * @return the value, never null
     */
    public List<EInvoicingFinding> einvoicingFindings() {
        return Utils.required(einvoicingFindings, "einvoicing_findings");
    }

    /**
     * The profile the document was checked against, e.g. "EN 16931".
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> einvoicingProfile() {
        return einvoicingProfile.asOptional();
    }

    /**
     * The {@code einvoicing_status} property.
     *
     * @return the value, empty when unset or null
     */
    public Optional<EInvoicingStatus> einvoicingStatus() {
        return einvoicingStatus.asOptional();
    }

    /**
     * The {@code invoice_id} property.
     *
     * @return the value, never null
     */
    public String invoiceId() {
        return Utils.required(invoiceId, "invoice_id");
    }

    /**
     * The {@code pdf_document_id} property.
     *
     * @return the value, never null
     */
    public String pdfDocumentId() {
        return Utils.required(pdfDocumentId, "pdf_document_id");
    }

    /**
     * The structured e-invoice stored beside the PDF, when one was produced.
     *
     * @return the value, empty when unset or null
     */
    public Optional<String> xmlDocumentId() {
        return xmlDocumentId.asOptional();
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
        InvoiceDocumentsEventData that = (InvoiceDocumentsEventData) o;
        return Objects.equals(customerId, that.customerId)
                && Objects.equals(einvoicingError, that.einvoicingError)
                && Objects.equals(einvoicingFindings, that.einvoicingFindings)
                && Objects.equals(einvoicingProfile, that.einvoicingProfile)
                && Objects.equals(einvoicingStatus, that.einvoicingStatus)
                && Objects.equals(invoiceId, that.invoiceId)
                && Objects.equals(pdfDocumentId, that.pdfDocumentId)
                && Objects.equals(xmlDocumentId, that.xmlDocumentId)
                && Objects.equals(additionalProperties, that.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                customerId,
                einvoicingError,
                einvoicingFindings,
                einvoicingProfile,
                einvoicingStatus,
                invoiceId,
                pdfDocumentId,
                xmlDocumentId,
                additionalProperties);
    }

    @Override
    public String toString() {
        return "InvoiceDocumentsEventData{"
                + "customerId="
                + customerId
                + ", einvoicingError="
                + einvoicingError
                + ", einvoicingFindings="
                + einvoicingFindings
                + ", einvoicingProfile="
                + einvoicingProfile
                + ", einvoicingStatus="
                + einvoicingStatus
                + ", invoiceId="
                + invoiceId
                + ", pdfDocumentId="
                + pdfDocumentId
                + ", xmlDocumentId="
                + xmlDocumentId
                + ", additionalProperties="
                + additionalProperties
                + "}";
    }

    /** Builds {@link InvoiceDocumentsEventData}. */
    public static final class Builder {
        private String customerId;
        private JsonField<String> einvoicingError = JsonField.missing();
        private List<EInvoicingFinding> einvoicingFindings;
        private JsonField<String> einvoicingProfile = JsonField.missing();
        private JsonField<EInvoicingStatus> einvoicingStatus = JsonField.missing();
        private String invoiceId;
        private String pdfDocumentId;
        private JsonField<String> xmlDocumentId = JsonField.missing();
        private final Map<String, JsonNode> additionalProperties = new LinkedHashMap<>();

        private Builder() {}

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
         * Set when generation failed for a reason that is not a business rule.
         *
         * @param einvoicingError the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder einvoicingError(String einvoicingError) {
            this.einvoicingError = JsonField.ofNullable(einvoicingError);
            return this;
        }

        /**
         * Empty unless the status is <code>failed</code>.
         *
         * @param einvoicingFindings the value
         * @return this builder
         */
        public Builder einvoicingFindings(List<EInvoicingFinding> einvoicingFindings) {
            this.einvoicingFindings = Utils.mutableList(einvoicingFindings);
            return this;
        }

        /**
         * Adds an item to {@code einvoicing_findings}.
         *
         * @param item the item
         * @return this builder
         */
        public Builder addEinvoicingFindingsItem(EInvoicingFinding item) {
            if (this.einvoicingFindings == null) {
                this.einvoicingFindings = new ArrayList<>();
            }
            this.einvoicingFindings.add(item);
            return this;
        }

        /**
         * The profile the document was checked against, e.g. "EN 16931".
         *
         * @param einvoicingProfile the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder einvoicingProfile(String einvoicingProfile) {
            this.einvoicingProfile = JsonField.ofNullable(einvoicingProfile);
            return this;
        }

        /**
         * The {@code einvoicing_status} property.
         *
         * @param einvoicingStatus the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder einvoicingStatus(EInvoicingStatus einvoicingStatus) {
            this.einvoicingStatus = JsonField.ofNullable(einvoicingStatus);
            return this;
        }

        /**
         * The {@code invoice_id} property.
         *
         * @param invoiceId the value
         * @return this builder
         */
        public Builder invoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        /**
         * The {@code pdf_document_id} property.
         *
         * @param pdfDocumentId the value
         * @return this builder
         */
        public Builder pdfDocumentId(String pdfDocumentId) {
            this.pdfDocumentId = pdfDocumentId;
            return this;
        }

        /**
         * The structured e-invoice stored beside the PDF, when one was produced.
         *
         * @param xmlDocumentId the value, null to send an explicit {@code null}
         * @return this builder
         */
        public Builder xmlDocumentId(String xmlDocumentId) {
            this.xmlDocumentId = JsonField.ofNullable(xmlDocumentId);
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
         * The {@code InvoiceDocumentsEventData}.
         *
         * @return the immutable value
         * @throws IllegalStateException when a required property is not set
         */
        public InvoiceDocumentsEventData build() {
            Utils.checkRequired(customerId, "customer_id");
            Utils.checkRequired(einvoicingFindings, "einvoicing_findings");
            Utils.checkRequired(invoiceId, "invoice_id");
            Utils.checkRequired(pdfDocumentId, "pdf_document_id");
            return new InvoiceDocumentsEventData(this);
        }
    }

    /**
     * Parse {@code json} as {@code InvoiceDocumentsEventData}.
     *
     * @param json the JSON text
     * @return the value
     * @throws com.meteroid.exceptions.InvalidDataException if it is not valid JSON of this shape
     */
    public static InvoiceDocumentsEventData fromJson(String json) {
        return Utils.parse(json, InvoiceDocumentsEventData.class);
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
