# this file is @generated
import enum


class BillingMetricAggregateEnum(str, enum.Enum):
    COUNT = "COUNT"
    LATEST = "LATEST"
    MAX = "MAX"
    MIN = "MIN"
    MEAN = "MEAN"
    SUM = "SUM"
    COUNT_DISTINCT = "COUNT_DISTINCT"

    def __str__(self) -> str:
        return str(self.value)
