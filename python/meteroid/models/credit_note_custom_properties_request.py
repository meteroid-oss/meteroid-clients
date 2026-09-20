# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class CreditNoteCustomPropertiesRequest(BaseModel):
    """Merge update of a credit note's custom property values (send a key with `null` to remove it).
    Allowed at any status — custom properties stay editable after the credit note is finalized."""

    custom_properties: t.Any
