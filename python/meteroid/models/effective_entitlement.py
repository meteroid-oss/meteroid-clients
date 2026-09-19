# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .effective_entitlement_value import EffectiveEntitlementValue
from .feature_ref import FeatureRef


@dataclasses.dataclass
class EffectiveEntitlement(BaseModel):
    """Merged entitlement value for a feature for a specific customer, enriched with live usage data."""

    feature: FeatureRef

    value: EffectiveEntitlementValue
