# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .customer_id import CustomerId
from .e_invoicing_finding import EInvoicingFinding
from .e_invoicing_status import EInvoicingStatus
from .invoice_id import InvoiceId


@dataclasses.dataclass
class InvoiceDocumentsEventData(BaseModel):
    """Emitted once the accounting PDF is stored. This is also the moment the e-invoicing
    outcome is known: the structured document is produced with the PDF, not at finalization."""

    customer_id: CustomerId

    einvoicing_findings: t.List[EInvoicingFinding]
    """Empty unless the status is `failed`."""

    invoice_id: InvoiceId

    pdf_document_id: str

    einvoicing_error: t.Optional[str] = None
    """Set when generation failed for a reason that is not a business rule."""

    einvoicing_profile: t.Optional[str] = None
    """The profile the document was checked against, e.g. "EN 16931"."""

    einvoicing_status: t.Optional[EInvoicingStatus] = None

    xml_document_id: t.Optional[str] = None
    """The structured e-invoice stored beside the PDF, when one was produced."""
