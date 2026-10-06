# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .address import Address
    from .currency import Currency
    from .custom_tax_rate import CustomTaxRate
    from .customer_id import CustomerId
    from .customer_type import CustomerType
    from .invoicing_entity_id import InvoicingEntityId
    from .shipping_address import ShippingAddress


@dataclasses.dataclass(kw_only=True)
class Customer(BaseModel):
    """The `Customer` object."""

    currency: Currency

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition `key`."""

    custom_taxes: list[CustomTaxRate]

    id: CustomerId

    invoicing_emails: list[str]

    invoicing_entity_id: InvoicingEntityId

    name: str

    preferred_locales: list[str]
    """Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    `["fr-FR", "en"]`); overrides the invoicing entity default."""

    alias: str | None = None

    billing_address: Address | None = None

    billing_email: str | None = None

    connected_account_id: str | None = None

    customer_type: CustomerType | None = None

    first_name: str | None = None

    invoicing_language: str | None = None
    """Deprecated: the first entry of `preferred_locales`.

    .. deprecated:: This field is deprecated."""

    last_name: str | None = None

    legal_number: str | None = None
    """BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB)."""

    phone: str | None = None

    shipping_address: ShippingAddress | None = None

    vat_number: str | None = None
