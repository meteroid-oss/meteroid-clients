// this file is @generated
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type EInvoicingFinding, EInvoicingFindingSerializer } from "./eInvoicingFinding";
import { type EInvoicingStatus, EInvoicingStatusSerializer } from "./eInvoicingStatus";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId";
/**
 * Emitted once the accounting PDF is stored. This is also the moment the e-invoicing
 * outcome is known: the structured document is produced with the PDF, not at finalization.
 */
export interface InvoiceDocumentsEventData {
  customerId: CustomerId;

  /** Set when generation failed for a reason that is not a business rule. */
  einvoicingError?: string | null;

  /** Empty unless the status is `failed`. */
  einvoicingFindings: EInvoicingFinding[];

  /** The profile the document was checked against, e.g. "EN 16931". */
  einvoicingProfile?: string | null;

  einvoicingStatus?: EInvoicingStatus | null;

  invoiceId: InvoiceId;

  pdfDocumentId: string;

  /** The structured e-invoice stored beside the PDF, when one was produced. */
  xmlDocumentId?: string | null;
}

export const InvoiceDocumentsEventDataSerializer = {
  _fromJsonObject(object: any): InvoiceDocumentsEventData {
    return {
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      einvoicingError: object["einvoicing_error"],
      einvoicingFindings: object["einvoicing_findings"].map((item: any) =>
        EInvoicingFindingSerializer._fromJsonObject(item)
      ),
      einvoicingProfile: object["einvoicing_profile"],
      einvoicingStatus:
        object["einvoicing_status"] != null
          ? EInvoicingStatusSerializer._fromJsonObject(object["einvoicing_status"])
          : undefined,
      invoiceId: InvoiceIdSerializer._fromJsonObject(object["invoice_id"]),
      pdfDocumentId: object["pdf_document_id"],
      xmlDocumentId: object["xml_document_id"],
    };
  },

  _toJsonObject(self: InvoiceDocumentsEventData): any {
    return {
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      einvoicing_error: self.einvoicingError,
      einvoicing_findings: self.einvoicingFindings.map((item: any) =>
        EInvoicingFindingSerializer._toJsonObject(item)
      ),
      einvoicing_profile: self.einvoicingProfile,
      einvoicing_status:
        self.einvoicingStatus != null
          ? EInvoicingStatusSerializer._toJsonObject(self.einvoicingStatus)
          : undefined,
      invoice_id: InvoiceIdSerializer._toJsonObject(self.invoiceId),
      pdf_document_id: self.pdfDocumentId,
      xml_document_id: self.xmlDocumentId,
    };
  },
};
