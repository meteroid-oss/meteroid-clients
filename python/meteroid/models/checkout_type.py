# this file is @generated
import enum


class CheckoutType(str, enum.Enum):
    SELF_SERVE = "SELF_SERVE"
    SUBSCRIPTION_ACTIVATION = "SUBSCRIPTION_ACTIVATION"
    PLAN_CHANGE = "PLAN_CHANGE"
    ADDON_PURCHASE = "ADDON_PURCHASE"

    def __str__(self) -> str:
        return str(self.value)
