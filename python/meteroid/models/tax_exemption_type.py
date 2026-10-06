# this file is @generated
import typing as t

from ..serialization import StrEnum


class TaxExemptionType(StrEnum):
    """The values of `TaxExemptionType`; others are kept as received."""

    REVERSE_CHARGE = "REVERSE_CHARGE"
    TAX_EXEMPT = "TAX_EXEMPT"
    NOT_REGISTERED = "NOT_REGISTERED"
    EXPORT = "EXPORT"
    NO_VAT_TERRITORY = "NO_VAT_TERRITORY"


TaxExemptionTypeLiteral: t.TypeAlias = t.Literal[
    "REVERSE_CHARGE", "TAX_EXEMPT", "NOT_REGISTERED", "EXPORT", "NO_VAT_TERRITORY"
]
"""The values of :class:`TaxExemptionType`, which arguments take as plain strings too."""
