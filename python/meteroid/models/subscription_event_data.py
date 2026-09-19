# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .billing_period_enum import BillingPeriodEnum
from .customer_id import CustomerId
from .subscription_id import SubscriptionId
from .subscription_status_enum import SubscriptionStatusEnum
from .subscription_update_type import SubscriptionUpdateType


@dataclasses.dataclass
class SubscriptionEventData(BaseModel):
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

    start_date: str

    status: SubscriptionStatusEnum

    subscription_id: SubscriptionId

    version: int

    activated_at: t.Optional[datetime] = None

    billing_start_date: t.Optional[str] = None

    cancellation_reason: t.Optional[str] = None
    """Present on `subscription.cancelled` when a reason was supplied."""

    change_type: t.Optional[SubscriptionUpdateType] = None

    customer_alias: t.Optional[str] = None

    end_date: t.Optional[str] = None

    invoice_memo: t.Optional[str] = None

    invoice_threshold: t.Optional[str] = None

    purchase_order: t.Optional[str] = None

    trial_duration: t.Optional[int] = None
