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
public class InvoiceDocumentsEventData {
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("einvoicing_error")
    private String einvoicingError;

    @JsonProperty("einvoicing_findings")
    private List<EInvoicingFinding> einvoicingFindings;

    @JsonProperty("einvoicing_profile")
    private String einvoicingProfile;

    @JsonProperty("einvoicing_status")
    private EInvoicingStatus einvoicingStatus;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("pdf_document_id")
    private String pdfDocumentId;

    @JsonProperty("xml_document_id")
    private String xmlDocumentId;

    public InvoiceDocumentsEventData() {}

    public InvoiceDocumentsEventData customerId(String customerId) {
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

    public InvoiceDocumentsEventData einvoicingError(String einvoicingError) {
        this.einvoicingError = einvoicingError;
        return this;
    }

    /**
     * Set when generation failed for a reason that is not a business rule.
     *
     * @return einvoicingError
     */
    @javax.annotation.Nullable
    public String getEinvoicingError() {
        return einvoicingError;
    }

    public void setEinvoicingError(String einvoicingError) {
        this.einvoicingError = einvoicingError;
    }

    public InvoiceDocumentsEventData einvoicingFindings(
            List<EInvoicingFinding> einvoicingFindings) {
        this.einvoicingFindings = einvoicingFindings;
        return this;
    }

    public InvoiceDocumentsEventData addEinvoicingFindingsItem(
            EInvoicingFinding einvoicingFindingsItem) {
        if (this.einvoicingFindings == null) {
            this.einvoicingFindings = new ArrayList<>();
        }
        this.einvoicingFindings.add(einvoicingFindingsItem);

        return this;
    }

    /**
     * Empty unless the status is `failed`.
     *
     * @return einvoicingFindings
     */
    @javax.annotation.Nonnull
    public List<EInvoicingFinding> getEinvoicingFindings() {
        return einvoicingFindings;
    }

    public void setEinvoicingFindings(List<EInvoicingFinding> einvoicingFindings) {
        this.einvoicingFindings = einvoicingFindings;
    }

    public InvoiceDocumentsEventData einvoicingProfile(String einvoicingProfile) {
        this.einvoicingProfile = einvoicingProfile;
        return this;
    }

    /**
     * The profile the document was checked against, e.g. &quot;EN 16931&quot;.
     *
     * @return einvoicingProfile
     */
    @javax.annotation.Nullable
    public String getEinvoicingProfile() {
        return einvoicingProfile;
    }

    public void setEinvoicingProfile(String einvoicingProfile) {
        this.einvoicingProfile = einvoicingProfile;
    }

    public InvoiceDocumentsEventData einvoicingStatus(EInvoicingStatus einvoicingStatus) {
        this.einvoicingStatus = einvoicingStatus;
        return this;
    }

    /**
     * Get einvoicingStatus
     *
     * @return einvoicingStatus
     */
    @javax.annotation.Nullable
    public EInvoicingStatus getEinvoicingStatus() {
        return einvoicingStatus;
    }

    public void setEinvoicingStatus(EInvoicingStatus einvoicingStatus) {
        this.einvoicingStatus = einvoicingStatus;
    }

    public InvoiceDocumentsEventData invoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    /**
     * Get invoiceId
     *
     * @return invoiceId
     */
    @javax.annotation.Nonnull
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceDocumentsEventData pdfDocumentId(String pdfDocumentId) {
        this.pdfDocumentId = pdfDocumentId;
        return this;
    }

    /**
     * Get pdfDocumentId
     *
     * @return pdfDocumentId
     */
    @javax.annotation.Nonnull
    public String getPdfDocumentId() {
        return pdfDocumentId;
    }

    public void setPdfDocumentId(String pdfDocumentId) {
        this.pdfDocumentId = pdfDocumentId;
    }

    public InvoiceDocumentsEventData xmlDocumentId(String xmlDocumentId) {
        this.xmlDocumentId = xmlDocumentId;
        return this;
    }

    /**
     * The structured e-invoice stored beside the PDF, when one was produced.
     *
     * @return xmlDocumentId
     */
    @javax.annotation.Nullable
    public String getXmlDocumentId() {
        return xmlDocumentId;
    }

    public void setXmlDocumentId(String xmlDocumentId) {
        this.xmlDocumentId = xmlDocumentId;
    }

    /**
     * Create an instance of InvoiceDocumentsEventData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of InvoiceDocumentsEventData
     * @throws JsonProcessingException if the JSON string is invalid with respect to
     *     InvoiceDocumentsEventData
     */
    public static InvoiceDocumentsEventData fromJson(String jsonString)
            throws JsonProcessingException {
        return Utils.getObjectMapper().readValue(jsonString, InvoiceDocumentsEventData.class);
    }

    /**
     * Convert an instance of InvoiceDocumentsEventData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() throws JsonProcessingException {
        return Utils.getObjectMapper().writeValueAsString(this);
    }
}
