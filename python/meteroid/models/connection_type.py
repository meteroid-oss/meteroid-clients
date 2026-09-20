# this file is @generated
import enum


class ConnectionType(str, enum.Enum):
    """Type of connection between platform and connected account"""

    STANDARD = "standard"
    EXPRESS = "express"

    def __str__(self) -> str:
        return str(self.value)
