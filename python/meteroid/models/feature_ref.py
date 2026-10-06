# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .entitlement_product_ref import EntitlementProductRef
    from .feature_id import FeatureId


@dataclasses.dataclass(kw_only=True)
class FeatureRef(BaseModel):
    """The `FeatureRef` object."""

    code: str
    """Unique key used to reference this feature in your code. Cannot be changed after creation."""

    id: FeatureId

    name: str

    product: EntitlementProductRef | None = None
