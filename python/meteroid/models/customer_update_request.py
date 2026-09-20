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
class CustomerUpdateRequest(BaseModel):
    currency: Currency

    custom_taxes: t.List[CustomTaxRate]

    invoicing_emails: t.List[str]

    invoicing_entity_id: InvoicingEntityId

    alias: t.Optional[str] = None

    billing_address: t.Optional[Address] = None

    billing_email: t.Optional[str] = None

    custom_properties: t.Optional[t.Any] = None
    """User-defined custom property values (full replace). Omit to leave unchanged."""

    customer_type: t.Optional[CustomerType] = None

    exemption_reason: t.Optional[str] = None
    """Free-text legal exemption mention surfaced on exempt invoices."""

    first_name: t.Optional[str] = None
    """Omit to keep the stored value (a full replace does not blank a person's name)."""

    invoicing_language: t.Optional[str] = None
    """Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent."""

    is_tax_exempt: t.Optional[bool] = None

    last_name: t.Optional[str] = None

    legal_number: t.Optional[str] = None
    """BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB)."""

    name: t.Optional[str] = None
    """Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`."""

    phone: t.Optional[str] = None

    preferred_locales: t.Optional[t.List[str]] = None
    """Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    `["fr-FR", "en"]`); overrides the invoicing entity default. Omit or send `[]` to
    reset to that default (full-replace update)."""

    shipping_address: t.Optional[ShippingAddress] = None

    vat_number: t.Optional[str] = None
