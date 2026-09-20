# this file is @generated
import enum


class SubscriptionActivationConditionEnum(str, enum.Enum):
    ON_START = "ON_START"
    ON_CHECKOUT = "ON_CHECKOUT"
    MANUAL = "MANUAL"

    def __str__(self) -> str:
        return str(self.value)
