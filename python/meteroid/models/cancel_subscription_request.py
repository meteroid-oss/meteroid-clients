# this file is @generated
from __future__ import annotations

import dataclasses
from datetime import date

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class CancelSubscriptionRequest(BaseModel):
    """The `CancelSubscriptionRequest` object."""

    effective_date: date | None | Unset = UNSET
    """If not provided, the cancellation will be effective at the end of the current billing or committed period."""

    reason: str | None | Unset = UNSET
