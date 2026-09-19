"""`GET /api/health` — unauthenticated liveness and configuration probe."""

import tomllib
from pathlib import Path

from ..dto import Health
from ..http import Reply, ScribeRequest, ok
from ..state import AppState

_PYPROJECT = Path(__file__).resolve().parents[2] / "pyproject.toml"
_VERSION: str | None = tomllib.loads(_PYPROJECT.read_text("utf-8"))["project"].get("version")


async def get_health(state: AppState, _request: ScribeRequest) -> Reply[Health]:
    return ok(
        {
            "status": "ok",
            "backend": "python",
            # False means METEROID_API_KEY (or the base URL) is missing, and every
            # Meteroid-backed operation below will fail with UPSTREAM_UNAUTHORIZED.
            # Reporting it here is what turns a wall of 502s into one clear message.
            "meteroid_configured": state.config.meteroid_configured,
            "version": _VERSION,
        }
    )
