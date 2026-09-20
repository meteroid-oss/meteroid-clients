# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .create_subscription_add_on import CreateSubscriptionAddOn
from .create_subscription_components import CreateSubscriptionComponents
from .payment_methods_config import PaymentMethodsConfig
from .plan_id import PlanId
from .subscription_activation_condition_enum import SubscriptionActivationConditionEnum


@dataclasses.dataclass
class SubscriptionCreateRequest(BaseModel):
    activation_condition: SubscriptionActivationConditionEnum

    customer_id_or_alias: str

    plan_id: PlanId

    start_date: str

    add_ons: t.Optional[t.List[CreateSubscriptionAddOn]] = None

    auto_advance_invoices: t.Optional[bool] = None

    backdate_invoices: t.Optional[bool] = None
    """Historical import mode: when true, invoices finalized for this subscription keep their
    billing-period date as the invoice date instead of being stamped with the emission date."""

    billing_day_anchor: t.Optional[int] = None

    charge_automatically: t.Optional[bool] = None

    coupon_codes: t.Optional[t.List[str]] = None

    custom_properties: t.Optional[t.Any] = None
    """User-defined custom property values, keyed by definition `key`. Validated against the
    tenant's subscription definitions."""

    end_date: t.Optional[str] = None

    invoice_memo: t.Optional[str] = None

    net_terms: t.Optional[int] = None

    payment_methods_config: t.Optional[PaymentMethodsConfig] = None
    """Payment methods configuration. If not specified, inherits from the invoicing entity."""

    price_components: t.Optional[CreateSubscriptionComponents] = None

    purchase_order: t.Optional[str] = None

    skip_past_invoices: t.Optional[bool] = None
    """Migration mode: when true with a past start_date, skip creating invoices for past cycles.
    The subscription will be set to the current billing period with correct cycle_index."""

    trial_days: t.Optional[int] = None

    version: t.Optional[int] = None
