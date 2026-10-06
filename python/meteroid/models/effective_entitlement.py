# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .effective_entitlement_value import EffectiveEntitlementValue
    from .feature_ref import FeatureRef


@dataclasses.dataclass(kw_only=True)
class EffectiveEntitlement(BaseModel):
    """Merged entitlement value for a feature for a specific customer, enriched with live usage data."""

    feature: FeatureRef

    value: EffectiveEntitlementValue
