# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class RevocationRequest(BaseModel):
    """Token revocation request"""

    token: str
    """The token to revoke"""

    token_type_hint: t.Optional[str] = None
    """Optional hint about the token type (access_token or refresh_token)"""
