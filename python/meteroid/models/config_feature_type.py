# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .config_value_type import ConfigValueType


@dataclasses.dataclass
class ConfigFeatureType(BaseModel):
    """A static, typed configuration value. No metric — resolved synchronously."""

    value_type: ConfigValueType
    """The feature's value type, fixed at creation."""

    options: t.Optional[t.List[str]] = None
    """Allowed values when `value_type = SELECT`. Empty otherwise."""
