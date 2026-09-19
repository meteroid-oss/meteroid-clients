"""`python -m scribe` — read the configuration, open the port, probe the catalog."""

import asyncio
import sys

import uvicorn

from . import log
from .app import router
from .config import ConfigError, config_from_env
from .http import serve
from .state import AppState


async def main() -> None:
    # A configuration error is the operator's to fix and there is nothing useful to
    # serve without it, so say what is wrong and stop.
    try:
        config = config_from_env()
    except ConfigError as err:
        log.error(str(err))
        sys.exit(1)

    if not config.meteroid_configured:
        log.warn(
            "METEROID_API_KEY is not set. The server will start and GET /api/health will report "
            "meteroid_configured=false, but every Meteroid-backed operation will fail. "
            "See examples/.env.example."
        )

    state = AppState(config)
    server = uvicorn.Server(
        uvicorn.Config(
            serve(router(state)),
            host="0.0.0.0",
            port=config.port,
            # This backend logs for itself, in the format the other backends use. uvicorn
            # still reports what only it can know: a port it could not bind.
            log_level="warning",
            access_log=False,
            server_header=False,
            lifespan="off",
        )
    )

    probe = asyncio.create_task(_probe_catalog(state, server))
    try:
        # Returns on Ctrl-C, once the open connections have drained. (A SIGTERM drains
        # them too, but uvicorn then re-raises it and the process ends right there.)
        await server.serve()
    finally:
        probe.cancel()
        await state.meteroid.aclose()
    log.info("Shutting down.")


async def _probe_catalog(state: AppState, server: uvicorn.Server) -> None:
    """Resolve the seeded catalog once at boot.

    This is not a hard requirement to start — the process stays up so that
    `GET /api/health` answers and so that seeding the tenant fixes things without a
    restart — but it turns "my first transcription says I'm not entitled" into an
    unmissable startup error naming the object that is missing.
    """
    # Probe once the port is open rather than before binding: an unreachable Meteroid
    # would otherwise hold it closed for the length of the SDK's retry schedule, and
    # `GET /api/health` is exactly what you want answering during that.
    while not server.started:
        await asyncio.sleep(0.05)
    log.info(f"Scribe (python) listening on http://localhost:{state.config.port}")

    if not state.config.meteroid_configured:
        return
    try:
        catalog = await state.catalog()
    except Exception as err:
        log.error(
            f"Meteroid catalog is not usable yet: {err}\n"
            "The demo never creates catalog objects — seed them once, by hand, as described in "
            "examples/CATALOG.md. Requests that need the catalog will keep returning "
            "503 CATALOG_NOT_SEEDED until it is there."
        )
        return
    names = ", ".join(plan["name"] for plan in catalog.plans)
    log.info(f"Meteroid catalog resolved: {len(catalog.plans)} plans ({names}).")


if __name__ == "__main__":
    asyncio.run(main())
