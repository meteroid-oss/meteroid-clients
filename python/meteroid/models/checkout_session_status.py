# this file is @generated
import enum


class CheckoutSessionStatus(str, enum.Enum):
    CREATED = "CREATED"
    AWAITING_PAYMENT = "AWAITING_PAYMENT"
    COMPLETED = "COMPLETED"
    EXPIRED = "EXPIRED"
    CANCELLED = "CANCELLED"

    def __str__(self) -> str:
        return str(self.value)
