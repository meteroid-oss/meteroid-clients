# this file is @generated
import enum


class CreditType(str, enum.Enum):
    CREDIT_TO_BALANCE = "CREDIT_TO_BALANCE"
    REFUND = "REFUND"
    DEBT_CANCELLATION = "DEBT_CANCELLATION"

    def __str__(self) -> str:
        return str(self.value)
