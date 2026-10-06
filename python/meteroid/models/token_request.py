# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class TokenRequest(BaseModel):
    """Token request (from POST body, application/x-www-form-urlencoded)"""

    grant_type: str
    """Grant type: "authorization_code" or "refresh_token" """

    client_id: str | None | Unset = UNSET
    """Client ID (if not using HTTP Basic auth)"""

    client_secret: str | None | Unset = UNSET
    """Client secret (if not using HTTP Basic auth)"""

    code: str | None | Unset = UNSET
    """Authorization code (for authorization_code grant)"""

    code_verifier: str | None | Unset = UNSET
    """PKCE code verifier (for authorization_code grant with PKCE)"""

    redirect_uri: str | None | Unset = UNSET
    """Redirect URI (for authorization_code grant, must match the one used in /authorize)"""

    refresh_token: str | None | Unset = UNSET
    """Refresh token (for refresh_token grant)"""
