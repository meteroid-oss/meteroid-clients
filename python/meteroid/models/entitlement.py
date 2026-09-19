# this file is @generated
import dataclasses
from datetime import datetime

from ..serialization import BaseModel
from .entitlement_id import EntitlementId
from .entitlement_value import EntitlementValue
from .feature_id import FeatureId


@dataclasses.dataclass
class Entitlement(BaseModel):
    """A raw entitlement row attached to one entity (feature, plan version, add-on, or subscription)."""

    created_at: datetime

    feature_id: FeatureId

    id: EntitlementId

    updated_at: datetime

    value: EntitlementValue
