# this file is @generated
import enum


class CouponFilter(str, enum.Enum):
    ALL = "ALL"
    ACTIVE = "ACTIVE"
    INACTIVE = "INACTIVE"
    ARCHIVED = "ARCHIVED"

    def __str__(self) -> str:
        return str(self.value)
