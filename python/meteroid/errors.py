"""Every error this SDK raises derives from `MeteroidError`.

* `APIStatusError` (and a subclass per common status): the API answered with
  an error status. `body` is the error response decoded into its schema.
* `APIConnectionError`: no response, after retries; `APITimeoutError` when the
  request timed out.
* `APIResponseValidationError`: a successful response that does not decode.
"""
# ruff: noqa: I001  (the import order depends on the client name)

from ._exceptions import (
    APIConnectionError,
    APIError,
    APIResponseValidationError,
    APITimeoutError,
)
from .api._errors import (
    APIStatusError,
    AuthenticationError,
    BadRequestError,
    ConflictError,
    InternalServerError,
    NotFoundError,
    PermissionDeniedError,
    RateLimitError,
    UnprocessableEntityError,
)
from .serialization import MeteroidError, ModelParseError

__all__ = [
    "MeteroidError",
    "APIConnectionError",
    "APIError",
    "APIResponseValidationError",
    "APIStatusError",
    "APITimeoutError",
    "AuthenticationError",
    "BadRequestError",
    "ConflictError",
    "InternalServerError",
    "ModelParseError",
    "NotFoundError",
    "PermissionDeniedError",
    "RateLimitError",
    "UnprocessableEntityError",
]
