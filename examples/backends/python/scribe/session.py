"""Demo session tokens.

There is no real user auth in this demo — that is not what it teaches. A session token
is a stateless HMAC over the Meteroid customer alias::

    v1.<base64url(alias)>.<base64url(hmac_sha256(SCRIBE_SESSION_SECRET, alias))>

Stateless and deterministic means every backend that shares the secret mints and accepts
the same tokens, so one contract-suite session works against all of them. The Meteroid
API key never leaves the backend.
"""

from __future__ import annotations

import base64
import binascii
import hashlib
import hmac
from dataclasses import dataclass
from typing import TYPE_CHECKING

from .error import ApiError

if TYPE_CHECKING:
    from .http import ScribeRequest
    from .state import AppState


def mint(secret: str, alias: str) -> str:
    return f"v1.{_encode(alias.encode())}.{_encode(_sign(secret, alias))}"


def verify(secret: str, token: str) -> str:
    """Returns the customer alias the token is bound to, or raises the `401 UNAUTHORIZED`
    the caller answers with.
    """
    version, _, rest = token.partition(".")
    # Everything after the second dot is the signature, so a token with a fourth segment
    # fails to decode below rather than being quietly truncated.
    alias_b64, dot, signature_b64 = rest.partition(".")
    if version != "v1" or not dot:
        raise ApiError.unauthorized(
            "Session token is malformed; expected `v1.<payload>.<signature>`."
        )

    alias_bytes = _decode(alias_b64)
    try:
        if alias_bytes is None:
            raise ValueError
        alias = alias_bytes.decode("utf-8")
    except ValueError:
        raise ApiError.unauthorized("Session token payload is not valid base64url UTF-8.") from None
    signature = _decode(signature_b64)
    if signature is None:
        raise ApiError.unauthorized("Session token signature is not valid base64url.")

    # Constant-time comparison.
    if not hmac.compare_digest(signature, _sign(secret, alias)):
        raise ApiError.unauthorized("Session token was not signed by this deployment.")
    return alias


def _sign(secret: str, alias: str) -> bytes:
    return hmac.new(secret.encode(), alias.encode(), hashlib.sha256).digest()


def _encode(data: bytes) -> str:
    return base64.urlsafe_b64encode(data).rstrip(b"=").decode("ascii")


def _decode(value: str) -> bytes | None:
    """Strict unpadded base64url. `urlsafe_b64decode` skips what it does not understand,
    so a forged token would decode to *something*. Re-encoding and comparing is what
    makes this reject exactly what the other backends reject.
    """
    try:
        data = base64.urlsafe_b64decode(value + "=" * (-len(value) % 4))
    except (binascii.Error, ValueError):
        return None
    return data if _encode(data) == value else None


@dataclass(frozen=True)
class Session:
    """The workspace a request is acting on."""

    # The Meteroid customer alias this workspace maps onto. Every Meteroid call in this
    # backend passes it where an `id_or_alias` is accepted.
    customer_alias: str


def require_session(state: AppState, request: ScribeRequest) -> Session:
    """Call this first in a handler and the route requires a valid
    `Authorization: Bearer <session_token>` header.
    """
    header = request.headers.get("authorization", "")
    token = header.removeprefix("Bearer ").strip() if header.startswith("Bearer ") else ""
    if token == "":
        raise ApiError.unauthorized("Missing Authorization: Bearer <session_token> header.")
    return Session(customer_alias=verify(state.config.session_secret, token))
