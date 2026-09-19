# this file is @generated
import enum


class PaymentMethodTypeEnum(str, enum.Enum):
    CARD = "CARD"
    BANK_TRANSFER = "BANK_TRANSFER"
    WALLET = "WALLET"
    OTHER = "OTHER"

    def __str__(self) -> str:
        return str(self.value)
