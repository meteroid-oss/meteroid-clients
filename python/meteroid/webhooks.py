"""Webhook signature verification.

Implements the `Standard Webhooks <https://www.standardwebhooks.com>`_ scheme,
accepting both the ``webhook-*`` headers and the legacy ``svix-*`` ones, exactly
like ``rust/src/webhooks.rs``.

Example
-------
::

    from meteroid.webhooks import Webhook

    wh = Webhook("whsec_your_webhook_secret")
    wh.verify(request_body, request_headers)
"""

from __future__ import annotations

import base64
import hashlib
import hmac
import math
import time
import typing as t

from .errors import MeteroidError

__all__ = ["Webhook", "WebhookVerificationError"]

WEBHOOK_TOLERANCE_IN_SECONDS = 5 * 60
_SECRET_PREFIX = "whsec_"

_HEADER_ID = "webhook-id"
_HEADER_SIGNATURE = "webhook-signature"
_HEADER_TIMESTAMP = "webhook-timestamp"

_SVIX_ID = "svix-id"
_SVIX_SIGNATURE = "svix-signature"
_SVIX_TIMESTAMP = "svix-timestamp"


class WebhookVerificationError(MeteroidError):
    """Raised when a webhook payload fails signature verification."""


def _get_header(
    headers: t.Mapping[str, str], primary: str, fallback: str
) -> t.Optional[str]:
    # Header lookups are case-insensitive; `httpx`/`werkzeug`/`django` mappings
    # already are, plain dicts are not, so normalize defensively.
    lowered = {str(k).lower(): v for k, v in headers.items()}
    value = lowered.get(primary)
    if value is None:
        value = lowered.get(fallback)
    return value


class Webhook:
    """Verifies and signs Meteroid webhook payloads."""

    _secret: bytes

    def __init__(self, secret: t.Union[str, bytes]) -> None:
        if isinstance(secret, str):
            if secret.startswith(_SECRET_PREFIX):
                secret = secret[len(_SECRET_PREFIX) :]
            self._secret = base64.b64decode(secret)
        else:
            self._secret = secret

    @classmethod
    def from_bytes(cls, secret: bytes) -> "Webhook":
        """Build a verifier from raw (already decoded) secret bytes."""
        return cls(secret)

    def verify(self, data: t.Union[str, bytes], headers: t.Mapping[str, str]) -> None:
        """Verify a payload against its signature headers.

        Raises :class:`WebhookVerificationError` when the signature is missing,
        malformed, stale or does not match.
        """
        msg_id = _get_header(headers, _HEADER_ID, _SVIX_ID)
        msg_signature = _get_header(headers, _HEADER_SIGNATURE, _SVIX_SIGNATURE)
        msg_timestamp = _get_header(headers, _HEADER_TIMESTAMP, _SVIX_TIMESTAMP)

        if not (msg_id and msg_signature and msg_timestamp):
            raise WebhookVerificationError("Missing required webhook headers")

        timestamp = self._verify_timestamp(msg_timestamp)
        try:
            expected = self.sign(msg_id=msg_id, timestamp=timestamp, data=data)
        except UnicodeEncodeError as exc:
            # `bytes` payloads are signed as-is and can never fail here; a `str`
            # one carrying lone surrogates can. Either way the caller only ever
            # has to catch `WebhookVerificationError`.
            raise WebhookVerificationError("Payload is not encodable as UTF-8") from exc
        # `compare_digest` refuses non-ASCII `str` inputs, and the signature
        # header is attacker controlled, so compare raw bytes instead.
        expected_signature = expected.partition(",")[2].encode("utf-8")

        for versioned_signature in msg_signature.split(" "):
            version, _, signature = versioned_signature.partition(",")
            if version != "v1":
                continue
            try:
                candidate = signature.encode("utf-8")
            except UnicodeEncodeError:
                # Not even encodable, so it cannot equal a base64 digest.
                continue
            if hmac.compare_digest(candidate, expected_signature):
                return

        raise WebhookVerificationError("No matching signature found")

    def sign(self, msg_id: str, timestamp: int, data: t.Union[str, bytes]) -> str:
        """Return the ``v1,<base64>`` signature for a payload.

        ``bytes`` payloads are signed as-is. Decoding them first would both
        reject perfectly valid non-UTF-8 bodies and diverge from the Rust SDK,
        which hands the raw bytes to ``standardwebhooks``.
        """
        payload = data if isinstance(data, bytes) else data.encode("utf-8")
        to_sign = f"{msg_id}.{timestamp}.".encode("utf-8") + payload
        signature = hmac.new(self._secret, to_sign, hashlib.sha256).digest()
        return f"v1,{base64.b64encode(signature).decode()}"

    @staticmethod
    def _verify_timestamp(timestamp_header: str) -> int:
        now = math.floor(time.time())
        try:
            timestamp = int(timestamp_header)
        except ValueError as exc:
            raise WebhookVerificationError("Invalid Signature Headers") from exc

        if timestamp < now - WEBHOOK_TOLERANCE_IN_SECONDS:
            raise WebhookVerificationError("Message timestamp too old")
        if timestamp > now + WEBHOOK_TOLERANCE_IN_SECONDS:
            raise WebhookVerificationError("Message timestamp too new")
        return timestamp
