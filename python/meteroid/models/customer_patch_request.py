# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .address import Address
from .currency import Currency
from .custom_tax_rate import CustomTaxRate
from .customer_type import CustomerType
from .invoicing_entity_id import InvoicingEntityId
from .shipping_address import ShippingAddress


@dataclasses.dataclass
class CustomerPatchRequest(BaseModel):
    alias: t.Optional[str] = None

    billing_address: t.Optional[Address] = None

    billing_email: t.Optional[str] = None

    currency: t.Optional[Currency] = None

    custom_properties: t.Optional[t.Any] = None
    """Partial update of custom property values (merge; send a key with `null` to remove it).
    Omit to leave unchanged."""

    custom_taxes: t.Optional[t.List[CustomTaxRate]] = None

    customer_type: t.Optional[CustomerType] = None

    exemption_reason: t.Optional[str] = None
    """Free-text legal exemption mention surfaced on exempt invoices."""

    first_name: t.Optional[str] = None

    invoicing_emails: t.Optional[t.List[str]] = None

    invoicing_entity_id: t.Optional[InvoicingEntityId] = None

    invoicing_language: t.Optional[str] = None
    """Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent."""

    is_tax_exempt: t.Optional[bool] = None

    last_name: t.Optional[str] = None

    legal_number: t.Optional[str] = None
    """BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB)."""

    name: t.Optional[str] = None

    phone: t.Optional[str] = None

    preferred_locales: t.Optional[t.List[str]] = None
    """Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    `["fr-FR", "en"]`); overrides the invoicing entity default. Omit to leave
    unchanged, send `[]` to reset to that default."""

    shipping_address: t.Optional[ShippingAddress] = None

    vat_number: t.Optional[str] = None
