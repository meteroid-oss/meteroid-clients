"""Webhook verification tests, mirroring rust/src/webhooks.rs unit tests."""

import time
import typing as t

import pytest

from meteroid import (
    InvalidWebhookSecretError,
    MeteroidError,
    Webhook,
    WebhookVerificationError,
)

SECRET = "whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD"
PAYLOAD = b'{"test": "data"}'
MSG_ID = "msg_test123"


def headers_for(prefix: str, signature: str, timestamp: int) -> t.Dict[str, str]:
    return {
        f"{prefix}-id": MSG_ID,
        f"{prefix}-signature": signature,
        f"{prefix}-timestamp": str(timestamp),
    }


def test_verify_standard_headers() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())
    signature = wh.sign(MSG_ID, timestamp, PAYLOAD)

    wh.verify(PAYLOAD, headers_for("webhook", signature, timestamp))


def test_verify_svix_headers() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())
    signature = wh.sign(MSG_ID, timestamp, PAYLOAD)

    wh.verify(PAYLOAD, headers_for("svix", signature, timestamp))


def test_verify_is_case_insensitive() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())
    signature = wh.sign(MSG_ID, timestamp, PAYLOAD)

    wh.verify(
        PAYLOAD,
        {
            "Webhook-Id": MSG_ID,
            "Webhook-Signature": signature,
            "Webhook-Timestamp": str(timestamp),
        },
    )


def test_invalid_signature() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())

    with pytest.raises(WebhookVerificationError):
        wh.verify(PAYLOAD, headers_for("webhook", "v1,invalid_signature_here", timestamp))


def test_tampered_payload() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())
    signature = wh.sign(MSG_ID, timestamp, PAYLOAD)

    with pytest.raises(WebhookVerificationError):
        wh.verify(b'{"test": "tampered"}', headers_for("webhook", signature, timestamp))


def test_missing_headers() -> None:
    wh = Webhook(SECRET)
    with pytest.raises(WebhookVerificationError):
        wh.verify(PAYLOAD, {})


def test_stale_timestamp() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time()) - 10_000
    signature = wh.sign(MSG_ID, timestamp, PAYLOAD)

    with pytest.raises(WebhookVerificationError):
        wh.verify(PAYLOAD, headers_for("webhook", signature, timestamp))


def test_multiple_signatures_one_matching() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())
    signature = wh.sign(MSG_ID, timestamp, PAYLOAD)

    combined = f"v1,bogus {signature}"
    wh.verify(PAYLOAD, headers_for("webhook", combined, timestamp))


# A body `bytes.decode("utf-8")` chokes on: a lone 0xFF plus a truncated
# multi-byte sequence. Rust's `standardwebhooks` signs the raw bytes, so this
# must verify rather than blow up with a `UnicodeDecodeError`.
NON_UTF8_PAYLOAD = b'{"blob": "\xff\xfe\x80 \xc3"}'


def test_verify_non_utf8_payload() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())
    signature = wh.sign(MSG_ID, timestamp, NON_UTF8_PAYLOAD)

    wh.verify(NON_UTF8_PAYLOAD, headers_for("webhook", signature, timestamp))


def test_non_utf8_payload_with_bad_signature_raises_verification_error() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())

    with pytest.raises(WebhookVerificationError):
        wh.verify(
            NON_UTF8_PAYLOAD,
            headers_for("webhook", "v1,not_the_right_signature", timestamp),
        )


def test_non_utf8_payload_is_tamper_evident() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())
    signature = wh.sign(MSG_ID, timestamp, NON_UTF8_PAYLOAD)

    with pytest.raises(WebhookVerificationError):
        wh.verify(
            NON_UTF8_PAYLOAD + b"\x00", headers_for("webhook", signature, timestamp)
        )


def test_str_and_bytes_payloads_sign_identically() -> None:
    wh = Webhook(SECRET)
    timestamp = int(time.time())

    assert wh.sign(MSG_ID, timestamp, PAYLOAD) == wh.sign(
        MSG_ID, timestamp, PAYLOAD.decode()
    )


def test_non_ascii_signature_header_raises_verification_error() -> None:
    # `hmac.compare_digest` rejects non-ASCII `str` with a `TypeError`; the
    # header is attacker controlled, so it must surface as a verification error.
    wh = Webhook(SECRET)
    timestamp = int(time.time())

    with pytest.raises(WebhookVerificationError):
        wh.verify(PAYLOAD, headers_for("webhook", "v1,sïgnature", timestamp))


def test_unencodable_signature_header_raises_verification_error() -> None:
    # A header value carrying lone surrogates (a surrogateescape decode) is not
    # even encodable, so it must be rejected rather than crash the comparison.
    wh = Webhook(SECRET)
    timestamp = int(time.time())

    with pytest.raises(WebhookVerificationError):
        wh.verify(PAYLOAD, headers_for("webhook", "v1,\udcff", timestamp))


def test_undecodable_str_payload_raises_verification_error() -> None:
    # A `str` carrying lone surrogates (e.g. from a surrogateescape decode)
    # cannot be encoded; that must not escape as a raw `UnicodeEncodeError`.
    wh = Webhook(SECRET)
    timestamp = int(time.time())

    with pytest.raises(WebhookVerificationError):
        wh.verify("\udcff", headers_for("webhook", "v1,whatever", timestamp))


def _signature_with(wh: Webhook) -> str:
    return wh.sign(MSG_ID, 1_700_000_000, PAYLOAD)


def test_secret_with_and_without_prefix_and_raw_bytes_agree() -> None:
    import base64

    bare = SECRET[len("whsec_") :]
    expected = _signature_with(Webhook(SECRET))
    assert _signature_with(Webhook(bare)) == expected
    assert _signature_with(Webhook(base64.b64decode(bare))) == expected
    assert _signature_with(Webhook.from_bytes(base64.b64decode(bare))) == expected


@pytest.mark.parametrize(
    "secret",
    [
        "whsec_!",  # non-strict base64 used to decode this to an empty key
        "whsec_",
        "",
        "whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7o",  # bad padding
        "whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD!",  # stray character
        "whsec_C2FVsBQI hrscChlQIMV+b5sSYspob7oD",  # embedded whitespace
        "whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oé",  # non-ASCII
        b"",
    ],
)
def test_invalid_secret_is_rejected(secret: t.Union[str, bytes]) -> None:
    with pytest.raises(InvalidWebhookSecretError) as excinfo:
        Webhook(secret)
    assert isinstance(excinfo.value, MeteroidError)
    assert not isinstance(excinfo.value, WebhookVerificationError)
