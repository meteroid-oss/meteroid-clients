# this file is @generated
import typing as t

from ..serialization import StrEnum


class ConnectionType(StrEnum):
    """Type of connection between platform and connected account"""

    STANDARD = "standard"
    EXPRESS = "express"


ConnectionTypeLiteral: t.TypeAlias = t.Literal["standard", "express"]
"""The values of :class:`ConnectionType`, which arguments take as plain strings too."""
