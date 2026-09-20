# this file is @generated
import enum


class FeatureStatus(str, enum.Enum):
    """Lifecycle status of a feature."""

    ACTIVE = "ACTIVE"
    DISABLED = "DISABLED"
    ARCHIVED = "ARCHIVED"

    def __str__(self) -> str:
        return str(self.value)
