# this file is @generated
import enum


class CustomPropertyEntityType(str, enum.Enum):
    CUSTOMER = "CUSTOMER"
    SUBSCRIPTION = "SUBSCRIPTION"
    INVOICE = "INVOICE"
    CREDIT_NOTE = "CREDIT_NOTE"

    def __str__(self) -> str:
        return str(self.value)
