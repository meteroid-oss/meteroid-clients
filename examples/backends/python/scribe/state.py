"""Everything the handlers share: configuration, one Meteroid client, the catalog
caches, and the in-memory transcription history.

There is exactly **one** ``MeteroidAsync`` client for the whole process. It holds the
base URL, the API key, the retry policy and an ``httpx`` connection pool, so every
handler simply uses ``state.meteroid``.
"""

from meteroid import MeteroidAsync

from .catalog import Catalog, CatalogCache, MetricCache
from .config import Config, meteroid_client
from .dto import Transcription


class TranscriptionStore:
    """Transcription history, per workspace.

    Deliberately in memory: Meteroid is the source of truth for *usage*, not for the
    application objects that produced it. Restarting the backend empties this; the usage
    it reported to Meteroid survives.
    """

    def __init__(self) -> None:
        self._by_workspace: dict[str, list[Transcription]] = {}

    def record(self, customer_alias: str, transcription: Transcription) -> None:
        # Newest first, which is the order `GET /api/transcriptions` promises.
        self._by_workspace.setdefault(customer_alias, []).insert(0, transcription)

    def history(self, customer_alias: str) -> list[Transcription]:
        return [*self._by_workspace.get(customer_alias, [])]


class AppState:
    def __init__(self, config: Config, meteroid: MeteroidAsync | None = None) -> None:
        """`meteroid` is only ever passed by the tests, to put a fake transport under the SDK."""
        self.config = config
        self.meteroid = meteroid if meteroid is not None else meteroid_client(config)
        self.metrics = MetricCache()
        self.transcriptions = TranscriptionStore()
        self._catalog_cache = CatalogCache()

    async def catalog(self) -> Catalog:
        """The seeded Meteroid catalog, resolved on first use and cached afterwards. Only
        successes are cached, so seeding the tenant while the demo is running fixes it
        without a restart.
        """
        return await self._catalog_cache.get(
            self.meteroid, self.metrics, self.config.default_currency.value
        )
