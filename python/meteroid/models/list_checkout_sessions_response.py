# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .checkout_session import CheckoutSession


@dataclasses.dataclass(kw_only=True)
class ListCheckoutSessionsResponse(BaseModel):
    """The `ListCheckoutSessionsResponse` object."""

    sessions: list[CheckoutSession]
