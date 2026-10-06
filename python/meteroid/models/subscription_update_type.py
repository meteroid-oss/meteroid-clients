# this file is @generated
import typing as t

from ..serialization import StrEnum


class SubscriptionUpdateType(StrEnum):
    """Identifies which mutation triggered a `subscription.updated` webhook."""

    ACTIVATED = "activated"
    TRIAL_ENDED = "trial_ended"
    BILLING_CONFIGURATION_UPDATED = "billing_configuration_updated"
    PLAN_CHANGED = "plan_changed"
    AMENDED = "amended"
    UNITS_CHANGED = "units_changed"
    PAUSED = "paused"
    CANCELLATION_SCHEDULED = "cancellation_scheduled"


SubscriptionUpdateTypeLiteral: t.TypeAlias = t.Literal[
    "activated",
    "trial_ended",
    "billing_configuration_updated",
    "plan_changed",
    "amended",
    "units_changed",
    "paused",
    "cancellation_scheduled",
]
"""The values of :class:`SubscriptionUpdateType`, which arguments take as plain strings too."""
