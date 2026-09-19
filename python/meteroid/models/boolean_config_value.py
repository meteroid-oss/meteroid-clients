# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class BooleanConfigValue(BaseModel):
    """A boolean config value."""

    value: bool
