# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import date, datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .checkout_session_id import CheckoutSessionId
    from .checkout_session_status import CheckoutSessionStatus
    from .checkout_type import CheckoutType
    from .customer_id import CustomerId
    from .payment_methods_config import PaymentMethodsConfig
    from .plan_version_id import PlanVersionId
    from .subscription_id import SubscriptionId


@dataclasses.dataclass(kw_only=True)
class CheckoutSession(BaseModel):
    """The `CheckoutSession` object."""

    checkout_type: CheckoutType

    created_at: datetime

    customer_id: CustomerId

    id: CheckoutSessionId

    plan_version_id: PlanVersionId

    status: CheckoutSessionStatus

    billing_day_anchor: int | None = None

    billing_start_date: date | None = None

    cancel_url: str | None = None

    checkout_url: str | None = None

    completed_at: datetime | None = None

    coupon_code: str | None = None

    expires_at: datetime | None = None
    """When the session expires. None means the session never expires."""

    net_terms: int | None = None

    payment_methods_config: PaymentMethodsConfig | None = None

    subscription_id: SubscriptionId | None = None

    success_url: str | None = None

    trial_duration_days: int | None = None
