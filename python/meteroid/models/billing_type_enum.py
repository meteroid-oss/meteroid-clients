# this file is @generated
import enum


class BillingTypeEnum(str, enum.Enum):
    ADVANCE = "ADVANCE"
    ARREARS = "ARREARS"

    def __str__(self) -> str:
        return str(self.value)
