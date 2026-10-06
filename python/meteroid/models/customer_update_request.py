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
class CustomerUpdateRequest(BaseModel):
    """The `CustomerUpdateRequest` object."""

    currency: Currency

    custom_taxes: list[CustomTaxRate]

    invoicing_emails: list[str]

    invoicing_entity_id: InvoicingEntityId

    alias: str | None | Unset = UNSET

    billing_address: Address | None | Unset = UNSET

    billing_email: str | None | Unset = UNSET

    custom_properties: t.Any = None
    """User-defined custom property values (full replace). Omit to leave unchanged."""

    customer_type: CustomerType | None | Unset = UNSET

    exemption_reason: str | None | Unset = UNSET
    """Free-text legal exemption mention surfaced on exempt invoices."""

    first_name: str | None | Unset = UNSET
    """Omit to keep the stored value (a full replace does not blank a person's name)."""

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
    `["fr-FR", "en"]`); overrides the invoicing entity default. Omit or send `[]` to
    reset to that default (full-replace update)."""

    shipping_address: ShippingAddress | None | Unset = UNSET

    vat_number: str | None | Unset = UNSET
