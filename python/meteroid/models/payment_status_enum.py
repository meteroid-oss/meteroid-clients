# this file is @generated
import enum


class PaymentStatusEnum(str, enum.Enum):
    READY = "READY"
    PENDING = "PENDING"
    SETTLED = "SETTLED"
    CANCELLED = "CANCELLED"
    FAILED = "FAILED"
    REFUNDED = "REFUNDED"

    def __str__(self) -> str:
        return str(self.value)
