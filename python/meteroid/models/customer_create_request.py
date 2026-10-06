# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .address import Address
    from .currency import Currency
    from .custom_tax_rate import CustomTaxRate
    from .customer_type import CustomerType
    from .invoicing_entity_id import InvoicingEntityId
    from .shipping_address import ShippingAddress


@dataclasses.dataclass(kw_only=True)
class CustomerCreateRequest(BaseModel):
    """The `CustomerCreateRequest` object."""

    currency: Currency

    custom_taxes: list[CustomTaxRate]

    invoicing_emails: list[str]

    alias: str | None | Unset = UNSET

    billing_address: Address | None | Unset = UNSET

    billing_email: str | None | Unset = UNSET

    connected_account_id: str | None | Unset = UNSET

    custom_properties: t.Any = None
    """User-defined custom property values, keyed by definition `key`. Validated against the
    tenant's `CUSTOMER` property definitions. Omit to leave unset."""

    customer_type: CustomerType | None = None
    """`INDIVIDUAL` requires `first_name`, `last_name`, and a billing-address country."""

    exemption_reason: str | None | Unset = UNSET
    """Free-text legal exemption mention surfaced on exempt invoices."""

    first_name: str | None | Unset = UNSET

    invoicing_entity_id: InvoicingEntityId | None | Unset = UNSET

    invoicing_language: str | None | Unset = UNSET
    """Deprecated: use `preferred_locales`. Applied only when `preferred_locales` is absent.

    .. deprecated:: This field is deprecated."""

    is_tax_exempt: bool | None | Unset = UNSET

    last_name: str | None | Unset = UNSET

    legal_number: str | None | Unset = UNSET
    """BT-47 — the buyer's national register identifier (SIREN/SIRET, HRB)."""

    name: str | None = None
    """Required for `COMPANY`. Ignored for `INDIVIDUAL`: derived from `first_name` + `last_name`."""

    phone: str | None | Unset = UNSET

    preferred_locales: list[str] | None | Unset = UNSET
    """Preferred document languages, most-preferred first (BCP-47 tags, e.g.
    `["fr-FR", "en"]`); overrides the invoicing entity default. The first one the
    renderer has a template for wins, so an unsupported entry alongside a supported
    one just falls through; a list of only unsupported ones is rejected."""

    shipping_address: ShippingAddress | None | Unset = UNSET

    vat_number: str | None | Unset = UNSET
