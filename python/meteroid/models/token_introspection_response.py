# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class TokenIntrospectionResponse(BaseModel):
    """Token introspection response as per RFC 7662"""

    active: bool

    client_id: t.Optional[str] = None

    exp: t.Optional[int] = None

    iat: t.Optional[int] = None

    scope: t.Optional[str] = None

    sub: t.Optional[str] = None

    token_type: t.Optional[str] = None
