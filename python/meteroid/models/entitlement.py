# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .entitlement_id import EntitlementId
    from .entitlement_value import EntitlementValue
    from .feature_id import FeatureId


@dataclasses.dataclass(kw_only=True)
class Entitlement(BaseModel):
    """A raw entitlement row attached to one entity (feature, plan version, add-on, or subscription)."""

    created_at: datetime

    feature_id: FeatureId

    id: EntitlementId

    updated_at: datetime

    value: EntitlementValue
