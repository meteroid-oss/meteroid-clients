# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .customer_id import CustomerId
from .quote_id import QuoteId
from .subscription_id import SubscriptionId


@dataclasses.dataclass
class QuoteEventData(BaseModel):
    customer_id: CustomerId

    quote_id: QuoteId

    subscription_id: t.Optional[SubscriptionId] = None
