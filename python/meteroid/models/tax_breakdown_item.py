# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .tax_exemption_type import TaxExemptionType


@dataclasses.dataclass(kw_only=True)
class TaxBreakdownItem(BaseModel):
    """The `TaxBreakdownItem` object."""

    name: str

    tax_amount: int

    tax_rate: Decimal

    taxable_amount: int

    exemption_reason: str | None = None
    """Free-text legal exemption mention (EU exempt/reverse-charge invoices)."""

    exemption_type: TaxExemptionType | None = None

    tax_reference: str | None = None
    """Accounting/reporting code of the tax rate for this line, for exports."""
