# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .payment_methods_config import PaymentMethodsConfig


@dataclasses.dataclass
class SubscriptionUpdateRequest(BaseModel):
    auto_advance_invoices: t.Optional[bool] = None
    """If false, invoices will stay in Draft until manually reviewed and finalized."""

    charge_automatically: t.Optional[bool] = None
    """Automatically try to charge the customer's configured payment method on finalize."""

    custom_properties: t.Optional[t.Dict[str, t.Any]] = None
    """Partial update of custom property values (merge; send a key with `null` to remove it).
    Validated against the tenant's `SUBSCRIPTION` property definitions. Omit to leave unchanged."""

    invoice_memo: t.Optional[str] = None
    """Default memo for invoices"""

    net_terms: t.Optional[int] = None
    """Payment terms in days (0 = due on issue)"""

    payment_methods_config: t.Optional[PaymentMethodsConfig] = None

    purchase_order: t.Optional[str] = None
    """Purchase order number"""
