"""Exceptions raised by the Meteroid SDK.

Every exception this SDK raises derives from :class:`MeteroidError`:

* :class:`ApiException` -- the API answered with a non-2xx status code.
* :class:`NetworkException` -- the request never got an answer.
* :class:`ResponseDecodeError` -- a 2xx body was not valid JSON or did not
  match its model.
* :class:`ModelParseError` -- a payload handed to ``Model.from_dict`` /
  ``Model.from_json`` could not be mapped onto the model.
* :class:`meteroid.webhooks.WebhookVerificationError` -- a webhook payload
  failed signature verification.
"""

from __future__ import annotations

import typing as t

from .models.error_code import ErrorCode
from .models.o_auth_error_code import OAuthErrorCode
from .models.o_auth_error_response import OAuthErrorResponse
from .models.rest_error_response import RestErrorResponse
from .serialization import MeteroidError, ModelParseError

__all__ = [
    "MeteroidError",
    "ApiException",
    "ErrorPayload",
    "NetworkException",
    "ModelParseError",
    "ResponseDecodeError",
]

#: The typed error bodies documented by the OpenAPI spec.
ErrorPayload = t.Union[RestErrorResponse, OAuthErrorResponse]


class NetworkException(MeteroidError):
    """The request could not be completed (connection error, timeout, ...)."""


def parse_error_payload(raw_body: bytes) -> t.Optional[ErrorPayload]:
    """Decode an error body into the first spec model it matches.

    :class:`RestErrorResponse` is tried first (every non-OAuth endpoint), then
    :class:`OAuthErrorResponse` (the OAuth token endpoints). ``None`` means the
    body matched neither -- not JSON, a different shape, or an enum value this
    SDK version does not know.
    """
    for model in (RestErrorResponse, OAuthErrorResponse):
        try:
            return model.from_json(raw_body)
        # `ModelParseError`, `json.JSONDecodeError` and `UnicodeDecodeError`
        # are all `ValueError`s.
        except ValueError:
            continue
    return None


class ApiException(MeteroidError):
    """The API answered with a non-2xx status code.

    Every status, 4xx or 5xx, goes through the same path: the body is decoded
    as a :class:`RestErrorResponse`, then as an :class:`OAuthErrorResponse`,
    and ``payload`` is ``None`` when it matches neither.

    ``status_code`` and ``raw_body`` are *always* set and are the guarantee to
    fall back on. In particular, if the server sends an ``ErrorCode`` (or
    ``OAuthErrorCode``) newer than this SDK knows, the body does not parse,
    ``payload``/``code``/``message`` are ``None``, and the code is still
    readable from ``raw_body``.

    In the common case, ``code`` and ``message`` give direct access to the
    decoded error::

        try:
            client.customers.get_customer("cust_123")
        except ApiException as exc:
            if exc.code is ErrorCode.NOT_FOUND:
                ...
            print(exc.status_code, exc.message)
    """

    status_code: int
    raw_body: bytes
    payload: t.Optional[ErrorPayload]

    def __init__(
        self,
        status_code: int,
        raw_body: bytes,
        payload: t.Optional[ErrorPayload] = None,
    ) -> None:
        self.status_code = status_code
        self.raw_body = raw_body
        self.payload = payload
        super().__init__(str(self))

    @classmethod
    def from_response(cls, status_code: int, raw_body: bytes) -> "ApiException":
        """Build the exception for a non-2xx response, decoding its body."""
        return cls(status_code, raw_body, parse_error_payload(raw_body))

    @property
    def rest_error(self) -> t.Optional[RestErrorResponse]:
        """The payload if it is a :class:`RestErrorResponse`, else ``None``."""
        return self.payload if isinstance(self.payload, RestErrorResponse) else None

    @property
    def oauth_error(self) -> t.Optional[OAuthErrorResponse]:
        """The payload if it is an :class:`OAuthErrorResponse`, else ``None``."""
        return self.payload if isinstance(self.payload, OAuthErrorResponse) else None

    @property
    def code(self) -> t.Optional[t.Union[ErrorCode, OAuthErrorCode]]:
        """``RestErrorResponse.code`` or ``OAuthErrorResponse.error``."""
        if isinstance(self.payload, RestErrorResponse):
            return self.payload.code
        if isinstance(self.payload, OAuthErrorResponse):
            return self.payload.error
        return None

    @property
    def message(self) -> t.Optional[str]:
        """``RestErrorResponse.message`` or ``OAuthErrorResponse.error_description``."""
        if isinstance(self.payload, RestErrorResponse):
            return self.payload.message
        if isinstance(self.payload, OAuthErrorResponse):
            return self.payload.error_description
        return None

    @property
    def body_as_str(self) -> str:
        return self.raw_body.decode("utf-8", errors="replace")

    def __str__(self) -> str:
        if self.payload is not None:
            return f"Http error (status={self.status_code}) {self.code}: {self.message}"
        return f"Http error (status={self.status_code}) body={self.body_as_str}"


class ResponseDecodeError(MeteroidError, ValueError):
    """A 2xx response body could not be decoded into the expected model.

    Raised when the body is not valid JSON or does not match the model this
    SDK version expects (e.g. a value it does not know yet). The original
    exception is chained as ``__cause__``; ``status_code`` and ``raw_body``
    keep the full response for inspection.
    """

    status_code: int
    raw_body: bytes

    def __init__(self, status_code: int, raw_body: bytes, reason: str) -> None:
        self.status_code = status_code
        self.raw_body = raw_body
        super().__init__(f"Could not decode response (status={status_code}): {reason}")

    @property
    def body_as_str(self) -> str:
        return self.raw_body.decode("utf-8", errors="replace")
