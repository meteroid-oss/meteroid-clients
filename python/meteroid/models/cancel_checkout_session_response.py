# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .checkout_session import CheckoutSession


@dataclasses.dataclass(kw_only=True)
class CancelCheckoutSessionResponse(BaseModel):
    """The `CancelCheckoutSessionResponse` object."""

    session: CheckoutSession
