# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .subscription_details import SubscriptionDetails


@dataclasses.dataclass(kw_only=True)
class SubscriptionUpdateResponse(BaseModel):
    """The `SubscriptionUpdateResponse` object."""

    subscription: SubscriptionDetails
