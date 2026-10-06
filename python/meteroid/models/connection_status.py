# this file is @generated
import typing as t

from ..serialization import StrEnum


class ConnectionStatus(StrEnum):
    """Status of a connected account"""

    PENDING = "pending"
    ACTIVE = "active"
    REVOKED = "revoked"
    SUSPENDED = "suspended"


ConnectionStatusLiteral: t.TypeAlias = t.Literal[
    "pending", "active", "revoked", "suspended"
]
"""The values of :class:`ConnectionStatus`, which arguments take as plain strings too."""
