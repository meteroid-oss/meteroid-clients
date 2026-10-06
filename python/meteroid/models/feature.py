# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .entitlement import Entitlement
    from .entitlement_product_ref import EntitlementProductRef
    from .feature_id import FeatureId
    from .feature_status import FeatureStatus
    from .feature_type import FeatureType


@dataclasses.dataclass(kw_only=True)
class Feature(BaseModel):
    """The `Feature` object."""

    code: str
    """Unique key used to reference this feature in your code. Cannot be changed after creation."""

    created_at: datetime

    feature_type: FeatureType

    id: FeatureId

    name: str

    status: FeatureStatus

    description: str | None = None

    entitlement: Entitlement | None = None

    product: EntitlementProductRef | None = None
