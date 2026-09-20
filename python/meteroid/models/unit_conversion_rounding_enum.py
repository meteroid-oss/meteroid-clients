# this file is @generated
import enum


class UnitConversionRoundingEnum(str, enum.Enum):
    UP = "UP"
    DOWN = "DOWN"
    NEAREST = "NEAREST"
    NEAREST_HALF = "NEAREST_HALF"
    NEAREST_DECILE = "NEAREST_DECILE"
    NONE = "NONE"

    def __str__(self) -> str:
        return str(self.value)
