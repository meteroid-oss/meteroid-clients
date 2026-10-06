# this file is @generated
import typing as t

from ..serialization import StrEnum


class CreditNoteStatus(StrEnum):
    """The values of `CreditNoteStatus`; others are kept as received."""

    DRAFT = "DRAFT"
    FINALIZED = "FINALIZED"
    VOIDED = "VOIDED"


CreditNoteStatusLiteral: t.TypeAlias = t.Literal["DRAFT", "FINALIZED", "VOIDED"]
"""The values of :class:`CreditNoteStatus`, which arguments take as plain strings too."""
