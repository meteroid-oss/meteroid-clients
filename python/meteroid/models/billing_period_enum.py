# this file is @generated
import enum


class BillingPeriodEnum(str, enum.Enum):
    MONTHLY = "MONTHLY"
    QUARTERLY = "QUARTERLY"
    SEMIANNUAL = "SEMIANNUAL"
    ANNUAL = "ANNUAL"

    def __str__(self) -> str:
        return str(self.value)
