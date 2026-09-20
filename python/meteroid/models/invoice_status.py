# this file is @generated
import enum


class InvoiceStatus(str, enum.Enum):
    DRAFT = "DRAFT"
    FINALIZED = "FINALIZED"
    UNCOLLECTIBLE = "UNCOLLECTIBLE"
    VOID = "VOID"
    CLOSED = "CLOSED"

    def __str__(self) -> str:
        return str(self.value)
