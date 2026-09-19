# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class CustomerPortalTokenRequest(BaseModel):
    expires_in_seconds: t.Optional[int] = None
    """Token lifetime in seconds. Defaults to 86400 (24 hours).
    Must be between 60 and 2592000 (30 days)."""
