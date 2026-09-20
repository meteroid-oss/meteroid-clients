# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .entitlement_product_ref import EntitlementProductRef
from .feature_id import FeatureId


@dataclasses.dataclass
class FeatureRef(BaseModel):
    code: str
    """Unique key used to reference this feature in your code. Cannot be changed after creation."""

    id: FeatureId

    name: str

    product: t.Optional[EntitlementProductRef] = None
