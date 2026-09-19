# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class TokenRequest(BaseModel):
    """Token request (from POST body, application/x-www-form-urlencoded)"""

    grant_type: str
    """Grant type: "authorization_code" or "refresh_token" """

    client_id: t.Optional[str] = None
    """Client ID (if not using HTTP Basic auth)"""

    client_secret: t.Optional[str] = None
    """Client secret (if not using HTTP Basic auth)"""

    code: t.Optional[str] = None
    """Authorization code (for authorization_code grant)"""

    code_verifier: t.Optional[str] = None
    """PKCE code verifier (for authorization_code grant with PKCE)"""

    redirect_uri: t.Optional[str] = None
    """Redirect URI (for authorization_code grant, must match the one used in /authorize)"""

    refresh_token: t.Optional[str] = None
    """Refresh token (for refresh_token grant)"""
