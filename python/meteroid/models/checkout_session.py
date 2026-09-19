# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .checkout_session_id import CheckoutSessionId
from .checkout_session_status import CheckoutSessionStatus
from .checkout_type import CheckoutType
from .customer_id import CustomerId
from .payment_methods_config import PaymentMethodsConfig
from .plan_version_id import PlanVersionId
from .subscription_id import SubscriptionId


@dataclasses.dataclass
class CheckoutSession(BaseModel):
    checkout_type: CheckoutType

    created_at: datetime

    customer_id: CustomerId

    id: CheckoutSessionId

    plan_version_id: PlanVersionId

    status: CheckoutSessionStatus

    billing_day_anchor: t.Optional[int] = None

    billing_start_date: t.Optional[str] = None

    cancel_url: t.Optional[str] = None

    checkout_url: t.Optional[str] = None

    completed_at: t.Optional[datetime] = None

    coupon_code: t.Optional[str] = None

    expires_at: t.Optional[datetime] = None
    """When the session expires. None means the session never expires."""

    net_terms: t.Optional[int] = None

    payment_methods_config: t.Optional[PaymentMethodsConfig] = None

    subscription_id: t.Optional[SubscriptionId] = None

    success_url: t.Optional[str] = None

    trial_duration_days: t.Optional[int] = None
