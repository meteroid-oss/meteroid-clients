# this file is @generated
import enum


class OAuthErrorCode(str, enum.Enum):
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

    def __str__(self) -> str:
        return str(self.value)
