# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .customer_id import CustomerId


@dataclasses.dataclass(kw_only=True)
class CustomerEventData(BaseModel):
    """The `CustomerEventData` object."""

    currency: str

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition key."""

    customer_id: CustomerId

    invoicing_emails: list[str]

    name: str

    alias: str | None = None

    billing_email: str | None = None

    phone: str | None = None
