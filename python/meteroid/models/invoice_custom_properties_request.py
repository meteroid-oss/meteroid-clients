# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class InvoiceCustomPropertiesRequest(BaseModel):
    """Merge update of an invoice's custom property values (send a key with `null` to remove it).
    Allowed at any status — custom properties stay editable after the invoice is finalized."""

    custom_properties: t.Dict[str, t.Any]
