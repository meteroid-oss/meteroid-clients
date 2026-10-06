# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .payment_methods_config import PaymentMethodsConfig


@dataclasses.dataclass(kw_only=True)
class SubscriptionUpdateRequest(BaseModel):
    """The `SubscriptionUpdateRequest` object."""

    auto_advance_invoices: bool | None | Unset = UNSET
    """If false, invoices will stay in Draft until manually reviewed and finalized."""

    charge_automatically: bool | None | Unset = UNSET
    """Automatically try to charge the customer's configured payment method on finalize."""

    custom_properties: t.Any = None
    """Partial update of custom property values (merge; send a key with `null` to remove it).
    Validated against the tenant's `SUBSCRIPTION` property definitions. Omit to leave unchanged."""

    invoice_memo: str | None | Unset = UNSET
    """Default memo for invoices"""

    net_terms: int | None | Unset = UNSET
    """Payment terms in days (0 = due on issue)"""

    payment_methods_config: PaymentMethodsConfig | None | Unset = UNSET

    purchase_order: str | None | Unset = UNSET
    """Purchase order number"""
