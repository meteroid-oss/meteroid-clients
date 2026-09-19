# this file is @generated
import enum


class TaxExemptionType(str, enum.Enum):
    REVERSE_CHARGE = "REVERSE_CHARGE"
    TAX_EXEMPT = "TAX_EXEMPT"
    NOT_REGISTERED = "NOT_REGISTERED"
    EXPORT = "EXPORT"

    def __str__(self) -> str:
        return str(self.value)
