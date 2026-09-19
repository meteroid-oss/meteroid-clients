package com.scribe;

import com.meteroid.Meteroid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Everything the handlers share: configuration, one Meteroid client, the catalog caches, and the
 * in-memory transcription history — the Java twin of the Rust backend's {@code src/state.rs}.
 *
 * <p>There is exactly <b>one</b> {@link Meteroid} client for the whole process. It owns an OkHttp
 * connection pool, so building one per request would throw away keep-alive and TLS session reuse.
 */
public final class AppState {

    public final Config config;
    public final Meteroid meteroid;
    public final MetricCache metrics = new MetricCache();
    public final TranscriptionStore transcriptions = new TranscriptionStore();

    private final CatalogCache catalogCache = new CatalogCache();

    public AppState(Config config) {
        this.config = config;
        this.meteroid = config.meteroidClient();
    }

    /**
     * The seeded Meteroid catalog, resolved on first use and cached afterwards. Only successes are
     * cached, so seeding the tenant while the demo is running fixes it without a restart.
     */
    public Catalog catalog() {
        return catalogCache.get(meteroid, metrics, config.defaultCurrency.getValue());
    }

    /**
     * Transcription history, per workspace.
     *
     * <p>Deliberately in memory: Meteroid is the source of truth for <i>usage</i>, not for the
     * application objects that produced it. Restarting the backend empties this; the usage it
     * reported to Meteroid survives.
     */
    public static final class TranscriptionStore {

        private final Map<String, List<Dto.Transcription>> byWorkspace = new ConcurrentHashMap<>();

        public void record(String customerAlias, Dto.Transcription transcription) {
            byWorkspace.compute(
                    customerAlias,
                    (alias, existing) -> {
                        List<Dto.Transcription> updated =
                                existing == null ? new ArrayList<>() : new ArrayList<>(existing);
                        // Newest first, which is the order `GET /api/transcriptions` promises.
                        updated.add(0, transcription);
                        return List.copyOf(updated);
                    });
        }

        public List<Dto.Transcription> list(String customerAlias) {
            return byWorkspace.getOrDefault(customerAlias, List.of());
        }
    }
}
