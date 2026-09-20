# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class TokenResponse(BaseModel):
    """Token response as per OAuth 2.0 spec"""

    access_token: str

    expires_in: int

    token_type: str

    refresh_token: t.Optional[str] = None

    scope: t.Optional[str] = None
