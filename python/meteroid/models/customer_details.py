# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .address import Address
    from .customer_id import CustomerId


@dataclasses.dataclass(kw_only=True)
class CustomerDetails(BaseModel):
    """The `CustomerDetails` object."""

    id: CustomerId

    name: str

    snapshot_at: datetime

    alias: str | None = None

    billing_address: Address | None = None

    email: str | None = None

    vat_number: str | None = None
