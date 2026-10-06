# this file is @generated
import typing as t

from ..serialization import StrEnum


class BatchJobType(StrEnum):
    """The values of `BatchJobType`; others are kept as received."""

    EVENT_CSV_IMPORT = "EVENT_CSV_IMPORT"
    CUSTOMER_CSV_IMPORT = "CUSTOMER_CSV_IMPORT"
    SUBSCRIPTION_CSV_IMPORT = "SUBSCRIPTION_CSV_IMPORT"
    SUBSCRIPTION_PLAN_MIGRATION = "SUBSCRIPTION_PLAN_MIGRATION"
    TAX_REPORT_EXPORT = "TAX_REPORT_EXPORT"


BatchJobTypeLiteral: t.TypeAlias = t.Literal[
    "EVENT_CSV_IMPORT",
    "CUSTOMER_CSV_IMPORT",
    "SUBSCRIPTION_CSV_IMPORT",
    "SUBSCRIPTION_PLAN_MIGRATION",
    "TAX_REPORT_EXPORT",
]
"""The values of :class:`BatchJobType`, which arguments take as plain strings too."""
