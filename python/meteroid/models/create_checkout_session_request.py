# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import date
from decimal import Decimal

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .coupon_id import CouponId
    from .create_subscription_add_on import CreateSubscriptionAddOn
    from .create_subscription_components import CreateSubscriptionComponents
    from .payment_methods_config import PaymentMethodsConfig
    from .plan_version_id import PlanVersionId


@dataclasses.dataclass(kw_only=True)
class CreateCheckoutSessionRequest(BaseModel):
    """The `CreateCheckoutSessionRequest` object."""

    customer_id: str
    """Customer ID or alias"""

    plan_version_id: PlanVersionId

    add_ons: list[CreateSubscriptionAddOn] | None | Unset = UNSET

    auto_advance_invoices: bool | None | Unset = UNSET
    """If false, invoices will stay in Draft until manually reviewed and finalized. Default is true."""

    billing_day_anchor: int | None | Unset = UNSET

    billing_start_date: date | None | Unset = UNSET

    cancel_url: str | None | Unset = UNSET
    """Absolute http(s) URL offered to the customer to leave the checkout without paying."""

    charge_automatically: bool | None | Unset = UNSET
    """Automatically try to charge the customer's configured payment method on finalize. Default is true."""

    components: CreateSubscriptionComponents | None | Unset = UNSET

    coupon_code: str | None | Unset = UNSET

    coupon_ids: list[CouponId] | None = None

    end_date: date | None | Unset = UNSET

    expires_in_hours: int | None | Unset = UNSET
    """Session expiry time in hours. Default is 1 hour for self-serve checkout."""

    invoice_memo: str | None | Unset = UNSET

    invoice_threshold: Decimal | None | Unset = UNSET

    metadata: t.Any = None

    net_terms: int | None | Unset = UNSET

    payment_methods_config: PaymentMethodsConfig | None | Unset = UNSET

    purchase_order: str | None | Unset = UNSET

    success_url: str | None | Unset = UNSET
    """Absolute http(s) URL the customer is sent to after a successful checkout.
    `checkout_session_id` is appended as a query parameter. Without it the customer stays on
    the hosted confirmation page."""

    trial_duration_days: int | None | Unset = UNSET
