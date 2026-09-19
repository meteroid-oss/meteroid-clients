# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class TextConfigValue(BaseModel):
    """A text config value."""

    value: str
