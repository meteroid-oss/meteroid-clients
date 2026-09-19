# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class JsonConfigValue(BaseModel):
    """A structured (JSON) config value — the "metadata" case, several fields in one entitlement."""

    value: t.Dict[str, t.Any]
