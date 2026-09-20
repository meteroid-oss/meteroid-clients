# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel
from .coupon_id import CouponId
from .create_subscription_add_on import CreateSubscriptionAddOn
from .create_subscription_components import CreateSubscriptionComponents
from .payment_methods_config import PaymentMethodsConfig
from .plan_version_id import PlanVersionId


@dataclasses.dataclass
class CreateCheckoutSessionRequest(BaseModel):
    customer_id: str
    """Customer ID or alias"""

    plan_version_id: PlanVersionId

    add_ons: t.Optional[t.List[CreateSubscriptionAddOn]] = None

    auto_advance_invoices: t.Optional[bool] = None
    """If false, invoices will stay in Draft until manually reviewed and finalized. Default is true."""

    billing_day_anchor: t.Optional[int] = None

    billing_start_date: t.Optional[str] = None

    cancel_url: t.Optional[str] = None
    """Absolute http(s) URL offered to the customer to leave the checkout without paying."""

    charge_automatically: t.Optional[bool] = None
    """Automatically try to charge the customer's configured payment method on finalize. Default is true."""

    components: t.Optional[CreateSubscriptionComponents] = None

    coupon_code: t.Optional[str] = None

    coupon_ids: t.Optional[t.List[CouponId]] = None

    end_date: t.Optional[str] = None

    expires_in_hours: t.Optional[int] = None
    """Session expiry time in hours. Default is 1 hour for self-serve checkout."""

    invoice_memo: t.Optional[str] = None

    invoice_threshold: t.Optional[Decimal] = None

    metadata: t.Optional[t.Any] = None

    net_terms: t.Optional[int] = None

    payment_methods_config: t.Optional[PaymentMethodsConfig] = None

    purchase_order: t.Optional[str] = None

    success_url: t.Optional[str] = None
    """Absolute http(s) URL the customer is sent to after a successful checkout.
    `checkout_session_id` is appended as a query parameter. Without it the customer stays on
    the hosted confirmation page."""

    trial_duration_days: t.Optional[int] = None
