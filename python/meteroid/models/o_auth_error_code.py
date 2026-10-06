# this file is @generated
import typing as t

from ..serialization import StrEnum


class OAuthErrorCode(StrEnum):
    """OAuth 2.0 error codes as per RFC 6749"""

    INVALID_REQUEST = "invalid_request"
    UNAUTHORIZED_CLIENT = "unauthorized_client"
    ACCESS_DENIED = "access_denied"
    UNSUPPORTED_RESPONSE_TYPE = "unsupported_response_type"
    INVALID_SCOPE = "invalid_scope"
    SERVER_ERROR = "server_error"
    TEMPORARILY_UNAVAILABLE = "temporarily_unavailable"
    INVALID_GRANT = "invalid_grant"
    INVALID_CLIENT = "invalid_client"
    UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type"


OAuthErrorCodeLiteral: t.TypeAlias = t.Literal[
    "invalid_request",
    "unauthorized_client",
    "access_denied",
    "unsupported_response_type",
    "invalid_scope",
    "server_error",
    "temporarily_unavailable",
    "invalid_grant",
    "invalid_client",
    "unsupported_grant_type",
]
"""The values of :class:`OAuthErrorCode`, which arguments take as plain strings too."""
