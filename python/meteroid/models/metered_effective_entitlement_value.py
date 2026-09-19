# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .metered_entitlement_spec import MeteredEntitlementSpec
from .metered_entitlement_usage import MeteredEntitlementUsage


@dataclasses.dataclass
class MeteredEffectiveEntitlementValue(BaseModel):
    spec: MeteredEntitlementSpec

    usage: MeteredEntitlementUsage
