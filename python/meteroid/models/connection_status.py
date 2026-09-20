# this file is @generated
import enum


class ConnectionStatus(str, enum.Enum):
    """Status of a connected account"""

    PENDING = "pending"
    ACTIVE = "active"
    REVOKED = "revoked"
    SUSPENDED = "suspended"

    def __str__(self) -> str:
        return str(self.value)
