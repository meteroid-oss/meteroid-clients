# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel
from .sub_line_item import SubLineItem


@dataclasses.dataclass
class InvoiceLineItem(BaseModel):
    amount_total: int

    end_date: str

    name: str

    start_date: str

    sub_line_items: t.List[SubLineItem]

    tax_rate: Decimal

    description: t.Optional[str] = None

    quantity: t.Optional[Decimal] = None

    unit_price: t.Optional[Decimal] = None
