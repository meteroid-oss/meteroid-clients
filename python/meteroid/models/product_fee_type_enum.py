# this file is @generated
import enum


class ProductFeeTypeEnum(str, enum.Enum):
    RATE = "RATE"
    SLOT = "SLOT"
    CAPACITY = "CAPACITY"
    USAGE = "USAGE"
    EXTRA_RECURRING = "EXTRA_RECURRING"
    ONE_TIME = "ONE_TIME"

    def __str__(self) -> str:
        return str(self.value)
