# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .applied_coupon_detailed import AppliedCouponDetailed
from .billing_period_enum import BillingPeriodEnum
from .currency import Currency
from .customer_id import CustomerId
from .entitlement import Entitlement
from .minimum_commitment import MinimumCommitment
from .payment_methods_config import PaymentMethodsConfig
from .plan_id import PlanId
from .plan_version_id import PlanVersionId
from .subscription_add_on import SubscriptionAddOn
from .subscription_component import SubscriptionComponent
from .subscription_id import SubscriptionId
from .subscription_status_enum import SubscriptionStatusEnum


@dataclasses.dataclass
class SubscriptionDetails(BaseModel):
    add_ons: t.List[SubscriptionAddOn]

    applied_coupons: t.List[AppliedCouponDetailed]

    auto_advance_invoices: bool

    billing_day_anchor: int

    charge_automatically: bool

    components: t.List[SubscriptionComponent]

    created_at: datetime
    """When the subscription was created"""

    currency: Currency

    current_period_start: str
    """Current billing period start date"""

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition `key`."""

    customer_id: CustomerId

    customer_name: str

    id: SubscriptionId

    mrr_cents: int
    """Monthly recurring revenue in cents"""

    net_terms: int
    """Payment terms in days (0 = due on issue)"""

    period: BillingPeriodEnum
    """Billing period (monthly, annual, etc.)"""

    plan_id: PlanId

    plan_name: str

    plan_version: int

    plan_version_id: PlanVersionId

    start_date: str
    """When the subscription contract starts (benefits apply from this date)"""

    status: SubscriptionStatusEnum

    activated_at: t.Optional[datetime] = None
    """When the subscription was activated (first payment or activation condition met)"""

    billing_start_date: t.Optional[str] = None
    """When billing started (after any trial period)"""

    checkout_url: t.Optional[str] = None

    current_period_end: t.Optional[str] = None
    """Current billing period end date"""

    customer_alias: t.Optional[str] = None

    end_date: t.Optional[str] = None
    """When the subscription ends (if set)"""

    entitlements: t.Optional[t.List[Entitlement]] = None

    invoice_memo: t.Optional[str] = None
    """Default memo for invoices"""

    minimum_commitment: t.Optional[MinimumCommitment] = None

    payment_methods_config: t.Optional[PaymentMethodsConfig] = None

    purchase_order: t.Optional[str] = None

    trial_duration: t.Optional[int] = None
    """Trial duration in days"""
