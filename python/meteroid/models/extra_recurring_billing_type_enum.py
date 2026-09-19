# this file is @generated
import enum


class ExtraRecurringBillingTypeEnum(str, enum.Enum):
    ADVANCE = "ADVANCE"
    ARREARS = "ARREARS"

    def __str__(self) -> str:
        return str(self.value)
