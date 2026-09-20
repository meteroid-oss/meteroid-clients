# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .config_value import ConfigValue


@dataclasses.dataclass
class ConfigEffectiveEntitlementValue(BaseModel):
    value: ConfigValue
