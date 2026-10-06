# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .subscription import Subscription


@dataclasses.dataclass(kw_only=True)
class CancelSubscriptionResponse(BaseModel):
    """The `CancelSubscriptionResponse` object."""

    subscription: Subscription
