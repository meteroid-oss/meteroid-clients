# this file is @generated
import typing as t

from ..serialization import StrEnum


class CustomerType(StrEnum):
    """Company vs. individual (B2C). Defaults to `COMPANY`."""

    COMPANY = "COMPANY"
    INDIVIDUAL = "INDIVIDUAL"


CustomerTypeLiteral: t.TypeAlias = t.Literal["COMPANY", "INDIVIDUAL"]
"""The values of :class:`CustomerType`, which arguments take as plain strings too."""
