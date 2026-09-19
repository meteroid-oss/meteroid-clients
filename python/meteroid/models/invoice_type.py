# this file is @generated
import enum


class InvoiceType(str, enum.Enum):
    RECURRING = "RECURRING"
    ONE_OFF = "ONE_OFF"
    ADJUSTMENT = "ADJUSTMENT"
    USAGE_THRESHOLD = "USAGE_THRESHOLD"

    def __str__(self) -> str:
        return str(self.value)
