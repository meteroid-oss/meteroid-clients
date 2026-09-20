# this file is @generated
import enum


class SubscriptionFeeBillingPeriodEnum(str, enum.Enum):
    ONE_TIME = "ONE_TIME"
    MONTHLY = "MONTHLY"
    QUARTERLY = "QUARTERLY"
    SEMIANNUAL = "SEMIANNUAL"
    ANNUAL = "ANNUAL"

    def __str__(self) -> str:
        return str(self.value)
