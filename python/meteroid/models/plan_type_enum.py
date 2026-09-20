# this file is @generated
import enum


class PlanTypeEnum(str, enum.Enum):
    STANDARD = "STANDARD"
    FREE = "FREE"
    CUSTOM = "CUSTOM"

    def __str__(self) -> str:
        return str(self.value)
