# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .subscription_details import SubscriptionDetails


@dataclasses.dataclass
class SubscriptionUpdateResponse(BaseModel):
    subscription: SubscriptionDetails
