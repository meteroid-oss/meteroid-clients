# this file is @generated
import typing as t

from ..serialization import StrEnum


class SlotDowngradePolicyEnum(StrEnum):
    """The values of `SlotDowngradePolicyEnum`; others are kept as received."""

    REMOVE_AT_END_OF_PERIOD = "REMOVE_AT_END_OF_PERIOD"


SlotDowngradePolicyEnumLiteral: t.TypeAlias = t.Literal["REMOVE_AT_END_OF_PERIOD"]
"""The values of :class:`SlotDowngradePolicyEnum`, which arguments take as plain strings too."""
