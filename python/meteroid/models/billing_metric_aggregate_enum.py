# this file is @generated
import typing as t

from ..serialization import StrEnum


class BillingMetricAggregateEnum(StrEnum):
    """The values of `BillingMetricAggregateEnum`; others are kept as received."""

    COUNT = "COUNT"
    LATEST = "LATEST"
    MAX = "MAX"
    MIN = "MIN"
    MEAN = "MEAN"
    SUM = "SUM"
    COUNT_DISTINCT = "COUNT_DISTINCT"


BillingMetricAggregateEnumLiteral: t.TypeAlias = t.Literal[
    "COUNT", "LATEST", "MAX", "MIN", "MEAN", "SUM", "COUNT_DISTINCT"
]
"""The values of :class:`BillingMetricAggregateEnum`, which arguments take as plain strings too."""
