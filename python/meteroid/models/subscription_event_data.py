# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import date, datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billing_period_enum import BillingPeriodEnum
    from .customer_id import CustomerId
    from .subscription_id import SubscriptionId
    from .subscription_status_enum import SubscriptionStatusEnum
    from .subscription_update_type import SubscriptionUpdateType


@dataclasses.dataclass(kw_only=True)
class SubscriptionEventData(BaseModel):
    """The `SubscriptionEventData` object."""

    auto_advance_invoices: bool

    billing_day_anchor: int

    charge_automatically: bool

    created_at: datetime

    currency: str

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition key."""

    customer_id: CustomerId

    customer_name: str

    mrr_cents: int

    net_terms: int

    period: BillingPeriodEnum

    plan_name: str

    start_date: date

    status: SubscriptionStatusEnum

    subscription_id: SubscriptionId

    version: int

    activated_at: datetime | None = None

    billing_start_date: date | None = None

    cancellation_reason: str | None = None
    """Present on `subscription.cancelled` when a reason was supplied."""

    change_type: SubscriptionUpdateType | None = None

    customer_alias: str | None = None

    end_date: date | None = None

    invoice_memo: str | None = None

    invoice_threshold: str | None = None

    purchase_order: str | None = None

    trial_duration: int | None = None
