# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .feature_ref import FeatureRef
from .resolved_entitlement_value import ResolvedEntitlementValue


@dataclasses.dataclass
class ResolvedEntitlement(BaseModel):
    """Merged entitlement value for a feature across the priority hierarchy, without usage data."""

    feature: FeatureRef

    value: ResolvedEntitlementValue
