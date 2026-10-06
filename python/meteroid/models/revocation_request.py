# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class RevocationRequest(BaseModel):
    """Token revocation request"""

    token: str
    """The token to revoke"""

    token_type_hint: str | None | Unset = UNSET
    """Optional hint about the token type (access_token or refresh_token)"""
