# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel
from .tax_exemption_type import TaxExemptionType


@dataclasses.dataclass
class TaxBreakdownItem(BaseModel):
    name: str

    tax_amount: int

    tax_rate: Decimal

    taxable_amount: int

    exemption_reason: t.Optional[str] = None
    """Free-text legal exemption mention (EU exempt/reverse-charge invoices)."""

    exemption_type: t.Optional[TaxExemptionType] = None

    tax_reference: t.Optional[str] = None
    """Accounting/reporting code of the tax rate for this line, for exports."""
