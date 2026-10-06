# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class TokenResponse(BaseModel):
    """Token response as per OAuth 2.0 spec"""

    access_token: str

    expires_in: int

    token_type: str

    refresh_token: str | None = None

    scope: str | None = None
