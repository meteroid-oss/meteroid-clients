# this file is @generated
import enum


class UsageModelEnum(str, enum.Enum):
    PER_UNIT = "PER_UNIT"
    TIERED = "TIERED"
    VOLUME = "VOLUME"
    PACKAGE = "PACKAGE"
    MATRIX = "MATRIX"

    def __str__(self) -> str:
        return str(self.value)
