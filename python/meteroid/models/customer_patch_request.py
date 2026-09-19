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
class CustomerPatchRequest(BaseModel):
    alias: t.Optional[str] = None

    billing_address: t.Optional[Address] = None

    billing_email: t.Optional[str] = None

    currency: t.Optional[Currency] = None

    custom_properties: t.Optional[t.Dict[str, t.Any]] = None
    """Partial update of custom property values (merge; send a key with `null` to remove it).
    Omit to leave unchanged."""

    custom_taxes: t.Optional[t.List[CustomTaxRate]] = None

    exemption_reason: t.Optional[str] = None
    """Free-text legal exemption mention surfaced on exempt invoices."""

    invoicing_emails: t.Optional[t.List[str]] = None

    invoicing_entity_id: t.Optional[InvoicingEntityId] = None

    invoicing_language: t.Optional[str] = None
    """Preferred document language (e.g. `en-US`, `fr-FR`); overrides the invoicing entity default.
    Omit to leave unchanged, send `""` to reset to the invoicing entity default.
    Unsupported languages fall back to `en-US` when rendering."""

    is_tax_exempt: t.Optional[bool] = None

    name: t.Optional[str] = None

    phone: t.Optional[str] = None

    shipping_address: t.Optional[ShippingAddress] = None

    vat_number: t.Optional[str] = None
