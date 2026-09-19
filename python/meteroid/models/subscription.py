# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .billing_period_enum import BillingPeriodEnum
from .currency import Currency
from .customer_id import CustomerId
from .payment_methods_config import PaymentMethodsConfig
from .plan_id import PlanId
from .plan_version_id import PlanVersionId
from .subscription_id import SubscriptionId
from .subscription_status_enum import SubscriptionStatusEnum


@dataclasses.dataclass
class Subscription(BaseModel):
    auto_advance_invoices: bool
    """If false, invoices will stay in Draft until manually reviewed and finalized. Default to true."""

    billing_day_anchor: int

    charge_automatically: bool
    """Automatically try to charge the customer's configured payment method on finalize."""

    created_at: datetime
    """When the subscription was created"""

    currency: Currency

    current_period_start: str
    """Current billing period start date"""

    custom_properties: t.Dict[str, t.Any]
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

    current_period_end: t.Optional[str] = None
    """Current billing period end date"""

    customer_alias: t.Optional[str] = None

    end_date: t.Optional[str] = None
    """When the subscription ends (if set)"""

    invoice_memo: t.Optional[str] = None
    """Default memo for invoices"""

    payment_methods_config: t.Optional[PaymentMethodsConfig] = None

    plan_description: t.Optional[str] = None

    purchase_order: t.Optional[str] = None

    trial_duration: t.Optional[int] = None
    """Trial duration in days"""
