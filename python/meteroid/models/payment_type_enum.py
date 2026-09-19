# this file is @generated
import enum


class PaymentTypeEnum(str, enum.Enum):
    PAYMENT = "PAYMENT"
    REFUND = "REFUND"

    def __str__(self) -> str:
        return str(self.value)
