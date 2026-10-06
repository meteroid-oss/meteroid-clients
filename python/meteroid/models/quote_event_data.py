# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .customer_id import CustomerId
    from .quote_id import QuoteId
    from .subscription_id import SubscriptionId


@dataclasses.dataclass(kw_only=True)
class QuoteEventData(BaseModel):
    """The `QuoteEventData` object."""

    customer_id: CustomerId

    quote_id: QuoteId

    subscription_id: SubscriptionId | None = None
