// this file is @generated
import { extraProperties } from "../json.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import {
  type EInvoicingFinding,
  EInvoicingFindingSerializer,
} from "./eInvoicingFinding.js";
import { type EInvoicingStatus, EInvoicingStatusSerializer } from "./eInvoicingStatus.js";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId.js";
/**
 * Emitted once the accounting PDF is stored. This is also the moment the e-invoicing
 * outcome is known: the structured document is produced with the PDF, not at finalization.
 */
export interface InvoiceDocumentsEventData {
  customerId: CustomerId;
  /** Set when generation failed for a reason that is not a business rule. */
  einvoicingError?: string | null | undefined;
  /** Empty unless the status is `failed`. */
  einvoicingFindings: EInvoicingFinding[];
  /** The profile the document was checked against, e.g. "EN 16931". */
  einvoicingProfile?: string | null | undefined;
  einvoicingStatus?: EInvoicingStatus | null | undefined;
  invoiceId: InvoiceId;
  pdfDocumentId: string;
  /** The structured e-invoice stored beside the PDF, when one was produced. */
  xmlDocumentId?: string | null | undefined;
}

/** Converts `InvoiceDocumentsEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceDocumentsEventDataSerializer = {
  parse(json: any): InvoiceDocumentsEventData {
    return {
      ...extraProperties(json, [
        "customer_id",
        "einvoicing_error",
        "einvoicing_findings",
        "einvoicing_profile",
        "einvoicing_status",
        "invoice_id",
        "pdf_document_id",
        "xml_document_id",
      ]),
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      einvoicingError: json["einvoicing_error"],
      einvoicingFindings: json["einvoicing_findings"].map((item: any) =>
        EInvoicingFindingSerializer.parse(item)
      ),
      einvoicingProfile: json["einvoicing_profile"],
      einvoicingStatus:
        json["einvoicing_status"] != null
          ? EInvoicingStatusSerializer.parse(json["einvoicing_status"])
          : json["einvoicing_status"],
      invoiceId: InvoiceIdSerializer.parse(json["invoice_id"]),
      pdfDocumentId: json["pdf_document_id"],
      xmlDocumentId: json["xml_document_id"],
    };
  },

  serialize(value: InvoiceDocumentsEventData): any {
    return {
      ...extraProperties(value, [
        "customerId",
        "einvoicingError",
        "einvoicingFindings",
        "einvoicingProfile",
        "einvoicingStatus",
        "invoiceId",
        "pdfDocumentId",
        "xmlDocumentId",
      ]),
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      einvoicing_error: value.einvoicingError,
      einvoicing_findings: value.einvoicingFindings.map((item: any) =>
        EInvoicingFindingSerializer.serialize(item)
      ),
      einvoicing_profile: value.einvoicingProfile,
      einvoicing_status:
        value.einvoicingStatus != null
          ? EInvoicingStatusSerializer.serialize(value.einvoicingStatus)
          : value.einvoicingStatus,
      invoice_id: InvoiceIdSerializer.serialize(value.invoiceId),
      pdf_document_id: value.pdfDocumentId,
      xml_document_id: value.xmlDocumentId,
    };
  },
};
