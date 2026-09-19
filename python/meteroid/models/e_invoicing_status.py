# this file is @generated
import enum


class EInvoicingStatus(str, enum.Enum):
    """Whether the structured e-invoice was produced with the accounting PDF. Absent when the
    invoicing entity had not opted in at the time the invoice was issued."""

    GENERATED = "GENERATED"
    FAILED = "FAILED"

    def __str__(self) -> str:
        return str(self.value)
