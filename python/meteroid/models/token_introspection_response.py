# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class TokenIntrospectionResponse(BaseModel):
    """Token introspection response as per RFC 7662"""

    active: bool

    client_id: str | None = None

    exp: int | None = None

    iat: int | None = None

    scope: str | None = None

    sub: str | None = None

    token_type: str | None = None
