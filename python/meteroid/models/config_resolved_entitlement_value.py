# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .config_value import ConfigValue


@dataclasses.dataclass
class ConfigResolvedEntitlementValue(BaseModel):
    value: ConfigValue
