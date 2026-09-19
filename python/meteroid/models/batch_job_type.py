# this file is @generated
import enum


class BatchJobType(str, enum.Enum):
    EVENT_CSV_IMPORT = "EVENT_CSV_IMPORT"
    CUSTOMER_CSV_IMPORT = "CUSTOMER_CSV_IMPORT"
    SUBSCRIPTION_CSV_IMPORT = "SUBSCRIPTION_CSV_IMPORT"
    SUBSCRIPTION_PLAN_MIGRATION = "SUBSCRIPTION_PLAN_MIGRATION"
    TAX_REPORT_EXPORT = "TAX_REPORT_EXPORT"

    def __str__(self) -> str:
        return str(self.value)
