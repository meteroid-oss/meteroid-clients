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
class CustomerCreateRequest(BaseModel):
    currency: Currency

    custom_taxes: t.List[CustomTaxRate]

    invoicing_emails: t.List[str]

    alias: t.Optional[str] = None

    billing_address: t.Optional[Address] = None

    billing_email: t.Optional[str] = None

    connected_account_id: t.Optional[str] = None

    custom_properties: t.Optional[t.Any] = None
    """User-defined custom property values, keyed by definition `key`. Validated against the
    tenant's `CUSTOMER` property definitions. Omit to leave unset."""

    customer_type: t.Optional[CustomerType] = None
    """`INDIVIDUAL` requires `first_name`, `last_name`, and a billing-address country."""

    exemption_reason: t.Optional[str] = None
    """Free-text legal exemption mention surfaced on exempt invoices."""

    first_name: t.Optional[str] = None

    invoicing_entity_id: t.Optional[InvoicingEntityId] = None

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
    `["fr-FR", "en"]`); overrides the invoicing entity default. The first one the
    renderer has a template for wins, so an unsupported entry alongside a supported
    one just falls through; a list of only unsupported ones is rejected."""

    shipping_address: t.Optional[ShippingAddress] = None

    vat_number: t.Optional[str] = None
