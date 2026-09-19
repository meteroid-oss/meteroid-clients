# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .address import Address
from .currency import Currency
from .custom_tax_rate import CustomTaxRate
from .invoicing_entity_id import InvoicingEntityId
from .shipping_address import ShippingAddress


@dataclasses.dataclass
class CustomerUpdateRequest(BaseModel):
    currency: Currency

    custom_taxes: t.List[CustomTaxRate]

    invoicing_emails: t.List[str]

    invoicing_entity_id: InvoicingEntityId

    name: str

    alias: t.Optional[str] = None

    billing_address: t.Optional[Address] = None

    billing_email: t.Optional[str] = None

    custom_properties: t.Optional[t.Dict[str, t.Any]] = None
    """User-defined custom property values (full replace). Omit to leave unchanged."""

    exemption_reason: t.Optional[str] = None
    """Free-text legal exemption mention surfaced on exempt invoices."""

    invoicing_language: t.Optional[str] = None
    """Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default.
    Omit or send `""` to reset to the invoicing entity default (full-replace update).
    Unsupported languages fall back to `en-US` when rendering."""

    is_tax_exempt: t.Optional[bool] = None

    phone: t.Optional[str] = None

    shipping_address: t.Optional[ShippingAddress] = None

    vat_number: t.Optional[str] = None
