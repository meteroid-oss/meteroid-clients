# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .feature_ref import FeatureRef
    from .resolved_entitlement_value import ResolvedEntitlementValue


@dataclasses.dataclass(kw_only=True)
class ResolvedEntitlement(BaseModel):
    """Merged entitlement value for a feature across the priority hierarchy, without usage data."""

    feature: FeatureRef

    value: ResolvedEntitlementValue
