# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .subscription import Subscription


@dataclasses.dataclass
class CancelSubscriptionResponse(BaseModel):
    subscription: Subscription
