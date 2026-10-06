# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import date, datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billing_period_enum import BillingPeriodEnum
    from .currency import Currency
    from .customer_id import CustomerId
    from .payment_methods_config import PaymentMethodsConfig
    from .plan_id import PlanId
    from .plan_version_id import PlanVersionId
    from .subscription_id import SubscriptionId
    from .subscription_status_enum import SubscriptionStatusEnum


@dataclasses.dataclass(kw_only=True)
class Subscription(BaseModel):
    """The `Subscription` object."""

    auto_advance_invoices: bool
    """If false, invoices will stay in Draft until manually reviewed and finalized. Default to true."""

    billing_day_anchor: int

    charge_automatically: bool
    """Automatically try to charge the customer's configured payment method on finalize."""

    created_at: datetime
    """When the subscription was created"""

    currency: Currency

    current_period_start: date
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

    start_date: date
    """When the subscription contract starts (benefits apply from this date)"""

    status: SubscriptionStatusEnum

    activated_at: datetime | None = None
    """When the subscription was activated (first payment or activation condition met)"""

    billing_start_date: date | None = None
    """When billing started (after any trial period)"""

    current_period_end: date | None = None
    """Current billing period end date"""

    customer_alias: str | None = None

    end_date: date | None = None
    """When the subscription ends (if set)"""

    invoice_memo: str | None = None
    """Default memo for invoices"""

    payment_methods_config: PaymentMethodsConfig | None = None

    plan_description: str | None = None

    purchase_order: str | None = None

    trial_duration: int | None = None
    """Trial duration in days"""
