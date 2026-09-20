# this file is @generated
import enum


class SubscriptionStatusEnum(str, enum.Enum):
    PENDING_ACTIVATION = "PENDING_ACTIVATION"
    PENDING_CHARGE = "PENDING_CHARGE"
    TRIAL_ACTIVE = "TRIAL_ACTIVE"
    ACTIVE = "ACTIVE"
    TRIAL_EXPIRED = "TRIAL_EXPIRED"
    PAUSED = "PAUSED"
    SUSPENDED = "SUSPENDED"
    CANCELLED = "CANCELLED"
    ABORTED = "ABORTED"
    COMPLETED = "COMPLETED"
    SUPERSEDED = "SUPERSEDED"
    ERRORED = "ERRORED"

    def __str__(self) -> str:
        return str(self.value)
