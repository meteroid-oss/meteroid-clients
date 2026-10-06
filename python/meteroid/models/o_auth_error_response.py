# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .o_auth_error_code import OAuthErrorCode


@dataclasses.dataclass(kw_only=True)
class OAuthErrorResponse(BaseModel):
    """OAuth 2.0 error response as per RFC 6749 Section 5.2"""

    error: OAuthErrorCode

    error_description: str | None = None

    error_uri: str | None = None
