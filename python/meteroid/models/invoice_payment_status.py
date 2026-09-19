# this file is @generated
import enum


class InvoicePaymentStatus(str, enum.Enum):
    UNPAID = "UNPAID"
    PARTIALLY_PAID = "PARTIALLY_PAID"
    PAID = "PAID"
    ERRORED = "ERRORED"
    PROCESSING = "PROCESSING"

    def __str__(self) -> str:
        return str(self.value)
