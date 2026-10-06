# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class CustomerPortalTokenRequest(BaseModel):
    """The `CustomerPortalTokenRequest` object."""

    expires_in_seconds: int | None | Unset = UNSET
    """Token lifetime in seconds. Defaults to 86400 (24 hours).
    Must be between 60 and 2592000 (30 days)."""
