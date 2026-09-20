# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .o_auth_error_code import OAuthErrorCode


@dataclasses.dataclass
class OAuthErrorResponse(BaseModel):
    """OAuth 2.0 error response as per RFC 6749 Section 5.2"""

    error: OAuthErrorCode

    error_description: t.Optional[str] = None

    error_uri: t.Optional[str] = None
