# this file is @generated
import enum


class SubscriptionUpdateType(str, enum.Enum):
    """Identifies which mutation triggered a `subscription.updated` webhook."""

    ACTIVATED = "activated"
    TRIAL_ENDED = "trial_ended"
    BILLING_CONFIGURATION_UPDATED = "billing_configuration_updated"
    PLAN_CHANGED = "plan_changed"
    AMENDED = "amended"
    UNITS_CHANGED = "units_changed"
    PAUSED = "paused"
    CANCELLATION_SCHEDULED = "cancellation_scheduled"

    def __str__(self) -> str:
        return str(self.value)
