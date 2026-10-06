# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .customer_id import CustomerId
    from .e_invoicing_finding import EInvoicingFinding
    from .e_invoicing_status import EInvoicingStatus
    from .invoice_id import InvoiceId


@dataclasses.dataclass(kw_only=True)
class InvoiceDocumentsEventData(BaseModel):
    """Emitted once the accounting PDF is stored. This is also the moment the e-invoicing
    outcome is known: the structured document is produced with the PDF, not at finalization."""

    customer_id: CustomerId

    einvoicing_findings: list[EInvoicingFinding]
    """Empty unless the status is `failed`."""

    invoice_id: InvoiceId

    pdf_document_id: str

    einvoicing_error: str | None = None
    """Set when generation failed for a reason that is not a business rule."""

    einvoicing_profile: str | None = None
    """The profile the document was checked against, e.g. "EN 16931"."""

    einvoicing_status: EInvoicingStatus | None = None

    xml_document_id: str | None = None
    """The structured e-invoice stored beside the PDF, when one was produced."""
