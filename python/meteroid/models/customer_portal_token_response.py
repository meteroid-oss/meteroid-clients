# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class CustomerPortalTokenResponse(BaseModel):
    """The `CustomerPortalTokenResponse` object."""

    portal_url: str
    """Base URL of the customer portal"""

    token: str
    """JWT token for portal access"""
