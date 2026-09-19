/**
 * Everything the handlers share: configuration, one Meteroid client, the catalog
 * caches, and the in-memory transcription history.
 *
 * There is exactly **one** `Meteroid` client for the whole process. It holds nothing
 * but the base URL, the API key and the retry policy, and Node's `fetch` pools
 * connections underneath it, so every handler simply uses `state.meteroid`.
 */

import type { Meteroid } from "@meteroid/sdk";

import { type Catalog, CatalogCache, MetricCache } from "./catalog.js";
import { type Config, meteroidClient } from "./config.js";
import type { Transcription } from "./dto.js";

export class AppState {
  public readonly meteroid: Meteroid;
  public readonly metrics = new MetricCache();
  public readonly transcriptions = new TranscriptionStore();
  private readonly catalogCache = new CatalogCache();

  /** `meteroid` is only ever passed by the tests, to put a fake `fetch` under the SDK. */
  public constructor(
    public readonly config: Config,
    meteroid: Meteroid = meteroidClient(config),
  ) {
    this.meteroid = meteroid;
  }

  /**
   * The seeded Meteroid catalog, resolved on first use and cached afterwards. Only
   * successes are cached, so seeding the tenant while the demo is running fixes it
   * without a restart.
   */
  public catalog(): Promise<Catalog> {
    return this.catalogCache.get(this.meteroid, this.metrics, this.config.defaultCurrency);
  }
}

/**
 * Transcription history, per workspace.
 *
 * Deliberately in memory: Meteroid is the source of truth for *usage*, not for the
 * application objects that produced it. Restarting the backend empties this; the usage
 * it reported to Meteroid survives.
 */
export class TranscriptionStore {
  private readonly byWorkspace = new Map<string, Transcription[]>();

  public record(customerAlias: string, transcription: Transcription): void {
    const history = this.byWorkspace.get(customerAlias) ?? [];
    // Newest first, which is the order `GET /api/transcriptions` promises.
    history.unshift(transcription);
    this.byWorkspace.set(customerAlias, history);
  }

  public list(customerAlias: string): Transcription[] {
    return [...(this.byWorkspace.get(customerAlias) ?? [])];
  }
}
