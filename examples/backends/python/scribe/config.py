"""Configuration, entirely from the environment. Nothing here is ever hard-coded —
see ``examples/.env.example`` for the full list and ``README.md`` for how to set it.
"""

import json
import os
import re
from collections.abc import Mapping
from dataclasses import dataclass

from meteroid import MeteroidAsync, MeteroidOptions
from meteroid.models import Currency


@dataclass(frozen=True)
class Config:
    """Everything the backend needs to start. Read once, at boot."""

    # Meteroid API key. May be empty: the process still starts so that `GET /api/health`
    # can report `meteroid_configured: false` instead of the operator getting a silent crash.
    meteroid_api_key: str
    meteroid_base_url: str
    # Signing secret of the Meteroid webhook endpoint (`whsec_…`). May be empty.
    meteroid_webhook_secret: str
    # HMAC key for demo session tokens. Not a Meteroid credential.
    session_secret: str
    # Currency new demo customers are created with. Must match the seeded plans.
    default_currency: Currency
    port: int

    @property
    def meteroid_configured(self) -> bool:
        """True when the backend has enough credentials to reach Meteroid at all."""
        return self.meteroid_api_key != "" and self.meteroid_base_url != ""


class ConfigError(Exception):
    """A configuration problem the operator has to fix. Reported at startup, never to a client."""


def config_from_env(env: Mapping[str, str] | None = None) -> Config:
    source = os.environ if env is None else env

    def non_empty(key: str) -> str | None:
        return source.get(key, "").strip() or None

    # `PORT` is the convention every host uses; `SCRIBE_PORT` is what
    # examples/.env.example calls it. Accept both, `PORT` wins.
    raw_port = non_empty("PORT") or non_empty("SCRIBE_PORT") or "8083"
    port = int(raw_port) if re.fullmatch(r"[0-9]+", raw_port) else 0
    if not 1 <= port <= 65535:
        raise ConfigError(f"PORT must be a number between 1 and 65535, got {json.dumps(raw_port)}")

    # The session secret has no safe default: a predictable one would let anyone mint a
    # token for any workspace. Refuse to start without it.
    session_secret = non_empty("SCRIBE_SESSION_SECRET")
    if session_secret is None:
        raise ConfigError(
            "SCRIBE_SESSION_SECRET is not set. It is the HMAC key for demo session tokens; "
            "generate one with `openssl rand -hex 32`. See examples/.env.example."
        )

    return Config(
        meteroid_api_key=non_empty("METEROID_API_KEY") or "",
        meteroid_base_url=non_empty("METEROID_BASE_URL") or "https://api.meteroid.com",
        meteroid_webhook_secret=non_empty("METEROID_WEBHOOK_SECRET") or "",
        session_secret=session_secret,
        default_currency=_parse_currency(non_empty("SCRIBE_DEFAULT_CURRENCY") or "USD"),
        port=port,
    )


def meteroid_client(config: Config) -> MeteroidAsync:
    """Build the Meteroid SDK client. One client is shared by every handler: it holds a
    connection pool and nothing that changes, so sharing it needs no care at all.
    """
    return MeteroidAsync(
        config.meteroid_api_key,
        MeteroidOptions(server_url=config.meteroid_base_url, timeout=15.0),
    )


def _parse_currency(code: str) -> Currency:
    """`Currency` is a closed enum in the SDK, so a configuration string gets in by being
    looked up among its values.
    """
    try:
        return Currency(code.upper())
    except ValueError:
        raise ConfigError(
            f"SCRIBE_DEFAULT_CURRENCY={json.dumps(code)} is not an ISO 4217 code "
            "Meteroid recognizes."
        ) from None
