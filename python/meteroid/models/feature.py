# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .entitlement import Entitlement
from .entitlement_product_ref import EntitlementProductRef
from .feature_id import FeatureId
from .feature_status import FeatureStatus
from .feature_type import FeatureType


@dataclasses.dataclass
class Feature(BaseModel):
    code: str
    """Unique key used to reference this feature in your code. Cannot be changed after creation."""

    created_at: datetime

    feature_type: FeatureType

    id: FeatureId

    name: str

    status: FeatureStatus

    description: t.Optional[str] = None

    entitlement: t.Optional[Entitlement] = None

    product: t.Optional[EntitlementProductRef] = None
