# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import date
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .sub_line_item import SubLineItem


@dataclasses.dataclass(kw_only=True)
class InvoiceLineItem(BaseModel):
    """The `InvoiceLineItem` object."""

    amount_total: int

    end_date: date

    name: str

    start_date: date

    sub_line_items: list[SubLineItem]

    tax_rate: Decimal

    description: str | None = None

    quantity: Decimal | None = None

    unit_price: Decimal | None = None
