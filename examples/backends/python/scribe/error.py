"""The single error envelope of ``examples/openapi.yaml``.

Every non-2xx response in this backend is an :class:`ApiError`. ``quota`` and
``upgrade_plan_code`` are always serialized, ``null`` where they do not apply, so a
strict client never has to tell an absent key from a null one.
"""

from __future__ import annotations

from collections.abc import Iterator
from contextlib import contextmanager
from typing import TYPE_CHECKING, Literal, Self, TypedDict

from meteroid import ApiException

if TYPE_CHECKING:
    from .dto import PlanCode, QuotaSnapshot

ErrorCode = Literal[
    "BAD_REQUEST",
    "UNAUTHORIZED",
    "NOT_FOUND",
    # Reserved by the contract; no operation requires a subscription.
    "NO_SUBSCRIPTION",
    "FEATURE_NOT_ENTITLED",
    "QUOTA_EXHAUSTED",
    "CHECKOUT_UNAVAILABLE",
    "CATALOG_NOT_SEEDED",
    "WEBHOOK_SIGNATURE_INVALID",
    "UPSTREAM_UNAUTHORIZED",
    "UPSTREAM_ERROR",
    "RATE_LIMITED",
    "INTERNAL",
]

_STATUS: dict[ErrorCode, int] = {
    "BAD_REQUEST": 400,
    "WEBHOOK_SIGNATURE_INVALID": 400,
    "UNAUTHORIZED": 401,
    "QUOTA_EXHAUSTED": 402,
    "FEATURE_NOT_ENTITLED": 403,
    "NOT_FOUND": 404,
    "NO_SUBSCRIPTION": 409,
    "CHECKOUT_UNAVAILABLE": 409,
    "RATE_LIMITED": 429,
    "INTERNAL": 500,
    "UPSTREAM_UNAUTHORIZED": 502,
    "UPSTREAM_ERROR": 502,
    "CATALOG_NOT_SEEDED": 503,
}


class ErrorBody(TypedDict):
    """The wire shape of the contract's `Error` schema."""

    code: ErrorCode
    message: str
    quota: QuotaSnapshot | None
    upgrade_plan_code: PlanCode | None


class ApiError(Exception):
    def __init__(self, code: ErrorCode, message: str) -> None:
        super().__init__(message)
        self.code: ErrorCode = code
        self.message = message
        self.quota: QuotaSnapshot | None = None
        self.upgrade_plan_code: PlanCode | None = None
        # Set only where the HTTP status is not the one the code implies (a 413).
        self._status_override: int | None = None

    @property
    def status(self) -> int:
        override = self._status_override
        return _STATUS[self.code] if override is None else override

    def with_quota(self, quota: QuotaSnapshot) -> Self:
        self.quota = quota
        return self

    def with_upgrade(self, plan: PlanCode | None) -> Self:
        self.upgrade_plan_code = plan
        return self

    def with_status(self, status: int) -> Self:
        self._status_override = status
        return self

    @classmethod
    def bad_request(cls, message: str) -> ApiError:
        return cls("BAD_REQUEST", message)

    @classmethod
    def unauthorized(cls, message: str) -> ApiError:
        return cls("UNAUTHORIZED", message)

    @classmethod
    def catalog_not_seeded(cls, message: str) -> ApiError:
        return cls("CATALOG_NOT_SEEDED", message)

    @classmethod
    def internal(cls, message: str) -> ApiError:
        return cls("INTERNAL", message)

    def to_json(self) -> ErrorBody:
        """Every key, every time: this is what goes on the wire."""
        return {
            "code": self.code,
            "message": self.message,
            "quota": self.quota,
            "upgrade_plan_code": self.upgrade_plan_code,
        }


@contextmanager
def upstream(context: str) -> Iterator[None]:
    """Translate an SDK failure into this contract's envelope. Written to wrap exactly the
    SDK call it belongs to::

        with upstream(f"GET /api/v1/customers/{alias}"):
            customer = await meteroid.customers.get_customer(alias)

    Nothing but the SDK call goes inside, which is what makes the broad ``except`` in
    :func:`to_api_error` safe: whatever escapes that one line is Meteroid's doing.
    """
    try:
        yield
    except Exception as exc:
        raise to_api_error(context, exc) from exc


def to_api_error(context: str, exc: Exception) -> ApiError:
    """The SDK raises an `ApiException` for every non-2xx answer, and its `status_code` is
    what separates "your API key is wrong" (an operator problem) from "Meteroid is
    throttling" (retry) from everything else. When the body parsed as Meteroid's error
    envelope, `rest_error` carries the typed `code` and `message`. Anything that is *not*
    an `ApiException` never produced a usable HTTP answer at all: a refused connection or
    a timeout (`NetworkException`), or a 2xx body the SDK could not decode
    (`ModelParseError`, or the bare `ValueError` of a body that is not JSON).
    """
    if isinstance(exc, ApiError):
        return exc
    if not isinstance(exc, ApiException):
        return ApiError("UPSTREAM_ERROR", f"Could not reach Meteroid for {context}: {exc}")

    status = exc.status_code
    if status in (401, 403):
        return ApiError(
            "UPSTREAM_UNAUTHORIZED",
            f"Meteroid rejected the API key on {context} (HTTP {status}). Check METEROID_API_KEY.",
        )
    if status == 429:
        return ApiError("RATE_LIMITED", f"Meteroid responded 429 to {context}. Retry shortly.")

    if exc.rest_error is not None:
        detail = f"{exc.rest_error.code.value}: {exc.rest_error.message}"
    elif exc.oauth_error is not None:
        detail = f"{exc.oauth_error.error.value}: {exc.oauth_error.error_description or ''}"
    else:
        detail = exc.body_as_str
    return ApiError(
        "UPSTREAM_ERROR", f"Meteroid responded {status} to {context}: {_truncate(detail)}"
    )


def is_not_found(exc: Exception) -> bool:
    """True when the SDK error is an upstream 404 — "this object does not exist", which
    for a catalog lookup means "not seeded" rather than "Meteroid is broken".
    """
    return isinstance(exc, ApiException) and exc.status_code == 404


def _truncate(body: str, limit: int = 300) -> str:
    return body if len(body) <= limit else f"{body[:limit]}…"
