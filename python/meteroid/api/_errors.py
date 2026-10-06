# this file is @generated
"""API errors by status, carrying the decoded error body."""

from __future__ import annotations

import typing as t

import httpx

from .. import models as _models
from .._exceptions import APIError, request_of
from ..serialization import JSONValue
from ._response import request_id

__all__ = [
    "APIStatusError",
    "AuthenticationError",
    "BadRequestError",
    "ConflictError",
    "ErrorBody",
    "InternalServerError",
    "NotFoundError",
    "PermissionDeniedError",
    "RateLimitError",
    "UnprocessableEntityError",
    "error_class",
]

_MAX_DETAIL = 500

ErrorBody: t.TypeAlias = _models.OAuthErrorResponse | _models.RestErrorResponse
"""The error responses the API declares."""


class APIStatusError(APIError):
    """The API answered with a non-2xx status. Subclasses tell the common ones apart."""

    response: httpx.Response
    status_code: int
    body: ErrorBody | JSONValue
    """The error response decoded into the schema the operation declares for its
    status; its JSON when it declares none or it does not match; else `None`."""

    def __init__(self, response: httpx.Response, body: object) -> None:
        detail = _body_text(response) or response.reason_phrase or "error"
        super().__init__(
            f"Error code: {response.status_code} - {detail}", request_of(response)
        )
        self.response = response
        self.status_code = response.status_code
        self.body = t.cast("ErrorBody | JSONValue", body)

    @property
    def headers(self) -> httpx.Headers:
        """The response headers."""
        return self.response.headers

    @property
    def request_id(self) -> str | None:
        """The request id to quote to support, when the API sends one."""
        return request_id(self.response.headers)

    @property
    def raw_body(self) -> bytes:
        """The response body."""
        return self.response.content


def _body_text(response: httpx.Response) -> str:
    """The start of the response body, for the error message."""
    try:
        text = response.text.strip()
    except httpx.ResponseNotRead:
        return ""
    return text if len(text) <= _MAX_DETAIL else f"{text[:_MAX_DETAIL]}..."


class BadRequestError(APIStatusError):
    """400 Bad Request."""


class AuthenticationError(APIStatusError):
    """401 Unauthorized."""


class PermissionDeniedError(APIStatusError):
    """403 Forbidden."""


class NotFoundError(APIStatusError):
    """404 Not Found."""


class ConflictError(APIStatusError):
    """409 Conflict."""


class UnprocessableEntityError(APIStatusError):
    """422 Unprocessable Entity."""


class RateLimitError(APIStatusError):
    """429 Too Many Requests, once retries are exhausted."""


class InternalServerError(APIStatusError):
    """Any 5xx status, once retries are exhausted."""


_BY_STATUS: dict[int, type[APIStatusError]] = {
    400: BadRequestError,
    401: AuthenticationError,
    403: PermissionDeniedError,
    404: NotFoundError,
    409: ConflictError,
    422: UnprocessableEntityError,
    429: RateLimitError,
}


def error_class(status_code: int) -> type[APIStatusError]:
    """The error raised for a response with this status."""
    if status_code >= 500:
        return InternalServerError
    return _BY_STATUS.get(status_code, APIStatusError)
