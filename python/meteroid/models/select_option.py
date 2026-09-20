# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class SelectOption(BaseModel):
    value: str

    label: t.Optional[str] = None
