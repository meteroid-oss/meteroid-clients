# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class CancelSubscriptionRequest(BaseModel):
    effective_date: t.Optional[str] = None
    """If not provided, the cancellation will be effective at the end of the current billing or committed period."""

    reason: t.Optional[str] = None
