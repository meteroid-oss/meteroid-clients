import { parseDateTime } from "./datetime";
import { type EmbedEventType, type EmbedHandle, type EmbedOptions, mount } from "./embed";
import {
  type CheckOptions,
  checkEntitlement,
  type EntitlementCheck,
} from "./entitlement";
import { createHttp } from "./http";
import { type ClientCustomer, ClientCustomerSerializer } from "./models/clientCustomer";
import type { ClientSubscription } from "./models/clientSubscription";
import {
  type ClientSubscriptionListResponse,
  ClientSubscriptionListResponseSerializer,
} from "./models/clientSubscriptionListResponse";
import {
  type EffectiveEntitlement,
  EffectiveEntitlementSerializer,
} from "./models/effectiveEntitlement";
import type { EffectiveEntitlementListResponse } from "./models/effectiveEntitlementListResponse";
import { createTokenSource, type GetToken } from "./token";

export interface MeteroidOptions {
  /**
   * Fetches a token for the signed-in customer from your backend, which mints it
   * with `POST /api/v1/customers/{id_or_alias}/portal-token`. Called again before
   * the token expires and when the API reports it expired.
   */
  getToken: GetToken;
  /**
   * Base URL of the REST API. Defaults to the `api_url` of the token response,
   * then to `https://api.meteroid.com`.
   */
  apiUrl?: string;
  /** Base URL of the portal, for embeds. Defaults like `apiUrl`, from `portal_url`. */
  portalUrl?: string;
  /** Entitlements fetched on the server, so that the first render knows them. */
  initialEntitlements?: EffectiveEntitlementListResponse;
  /** Custom fetch, e.g. for tests. */
  fetch?: typeof fetch;
}

export type ResourceStatus = "loading" | "ready" | "error";

/**
 * A resource of the store. After a successful load, a failed refresh keeps the data
 * (`status` stays `"ready"`) and only sets `error`.
 */
export interface ResourceState<T> {
  readonly status: ResourceStatus;
  readonly data: T | undefined;
  readonly error: unknown;
}

export interface MeteroidSnapshot {
  readonly entitlements: ResourceState<EffectiveEntitlement[]>;
  readonly customer: ResourceState<ClientCustomer>;
  readonly subscriptions: ResourceState<ClientSubscription[]>;
}

export interface Meteroid {
  readonly customer: { get(): Promise<ClientCustomer> };
  readonly entitlements: { list(): Promise<EffectiveEntitlementListResponse> };
  readonly subscriptions: { list(): Promise<ClientSubscriptionListResponse> };
  /**
   * Listen to snapshot changes; returns the unsubscribe function. The first
   * subscriber starts the store (load, then refresh on window focus), the last one
   * to leave stops it.
   */
  subscribe(listener: () => void): () => void;
  getSnapshot(): MeteroidSnapshot;
  /** The snapshot to render on the server and to hydrate with. */
  getServerSnapshot(): MeteroidSnapshot;
  /** Evaluate a feature against the current snapshot. */
  check(featureCode: string, options?: CheckOptions): EntitlementCheck;
  /** Reload entitlements, customer and subscriptions. Never rejects: see the snapshot. */
  refresh(): Promise<void>;
  /** Mount a billing embed that shares this client's token and refreshes it on change. */
  mountEmbed(target: string | HTMLElement, options?: EmbedOptions): EmbedHandle;
  /** Stop the store and remove the embeds mounted by this client. */
  destroy(): void;
}

const FOCUS_REFRESH_INTERVAL_MS = 30_000;

const CHANGE_EVENTS: EmbedEventType[] = [
  "plan_changed",
  "subscription_canceled",
  "payment_method_added",
  "checkout_completed",
];

const LOADING: ResourceState<never> = {
  status: "loading",
  data: undefined,
  error: undefined,
};

// An entitlement of a kind this version does not know is skipped, not fatal.
const parseEntitlements = (json: any): EffectiveEntitlementListResponse => ({
  data: json.data.flatMap((item: unknown) => {
    try {
      return [EffectiveEntitlementSerializer._fromJsonObject(item)];
    } catch {
      return [];
    }
  }),
});

// Server-rendered props may have gone through JSON, which turns dates into strings.
const hydrate = (entitlements: EffectiveEntitlement[]): EffectiveEntitlement[] =>
  entitlements.map((item) => {
    const value = item.value;
    const resetAt: unknown = value.type === "METERED" ? value.usage?.resetAt : undefined;
    return value.type === "METERED" && typeof resetAt === "string"
      ? {
          ...item,
          value: { ...value, usage: { ...value.usage, resetAt: parseDateTime(resetAt) } },
        }
      : item;
  });

/** Create a client for the signed-in customer. Touches no browser API until used. */
export function createMeteroid(options: MeteroidOptions): Meteroid {
  const tokens = createTokenSource(options.getToken);
  const get = createHttp(tokens, { apiUrl: options.apiUrl, fetch: options.fetch });
  const initial = options.initialEntitlements;
  const serverSnapshot: MeteroidSnapshot = {
    entitlements: initial
      ? { status: "ready", data: hydrate(initial.data), error: undefined }
      : LOADING,
    customer: LOADING,
    subscriptions: LOADING,
  };
  let snapshot = serverSnapshot;
  const listeners = new Set<() => void>();
  const embeds = new Set<EmbedHandle>();
  let running: Promise<void> | undefined;
  let queued: Promise<void> | undefined;
  let lastRefresh = Number.NEGATIVE_INFINITY;
  let destroyed = false;

  const update = (key: keyof MeteroidSnapshot, state: ResourceState<unknown>) => {
    if (destroyed) {
      return;
    }
    snapshot = { ...snapshot, [key]: state };
    for (const listener of listeners) {
      listener();
    }
  };

  const load = <T>(key: keyof MeteroidSnapshot, fetcher: () => Promise<T>) =>
    fetcher().then(
      (data) => update(key, { status: "ready", data, error: undefined }),
      (error) => {
        const previous = snapshot[key];
        update(
          key,
          previous.data === undefined
            ? { status: "error", data: undefined, error }
            : { ...previous, error }
        );
      }
    );

  const refresh = (): Promise<void> => {
    if (destroyed) {
      return Promise.resolve();
    }
    if (running) {
      // One more pass once the current one is done: it may predate the change.
      queued ??= running.then(() => {
        queued = undefined;
        return refresh();
      });
      return queued;
    }
    lastRefresh = Date.now();
    running = Promise.all([
      load("entitlements", () => client.entitlements.list().then((r) => r.data)),
      load("customer", client.customer.get),
      load("subscriptions", () => client.subscriptions.list().then((r) => r.data)),
    ]).then(() => {
      running = undefined;
    });
    return running;
  };

  const refreshIfIdle = () => {
    if (!running && Date.now() - lastRefresh >= FOCUS_REFRESH_INTERVAL_MS) {
      void refresh();
    }
  };

  const onFocus = () => {
    if (document.visibilityState !== "hidden") {
      refreshIfIdle();
    }
  };

  const setActive = (active: boolean) => {
    tokens.keepFresh(active);
    if (typeof window !== "undefined") {
      const method = active ? "addEventListener" : "removeEventListener";
      window[method]("focus", onFocus);
      document[method]("visibilitychange", onFocus);
    }
    if (active) {
      refreshIfIdle();
    }
  };

  const client: Meteroid = {
    customer: {
      get: () => get("/customer", ClientCustomerSerializer._fromJsonObject),
    },
    entitlements: {
      list: () => get("/entitlements", parseEntitlements),
    },
    subscriptions: {
      list: () =>
        get("/subscriptions", ClientSubscriptionListResponseSerializer._fromJsonObject),
    },
    subscribe(listener) {
      listeners.add(listener);
      if (listeners.size === 1 && !destroyed) {
        setActive(true);
      }
      return () => {
        if (listeners.delete(listener) && listeners.size === 0 && !destroyed) {
          setActive(false);
        }
      };
    },
    getSnapshot: () => snapshot,
    getServerSnapshot: () => serverSnapshot,
    check: (featureCode, checkOptions) =>
      checkEntitlement(snapshot.entitlements, featureCode, checkOptions),
    refresh,
    mountEmbed(target, embedOptions = {}) {
      const handle = mount(target, embedOptions, tokens, options.portalUrl);
      for (const type of CHANGE_EVENTS) {
        handle.on(type, () => void refresh());
      }
      const destroy = handle.destroy;
      const tracked: EmbedHandle = {
        ...handle,
        destroy() {
          embeds.delete(tracked);
          destroy();
        },
      };
      embeds.add(tracked);
      return tracked;
    },
    destroy() {
      if (listeners.size > 0) {
        setActive(false);
      }
      destroyed = true;
      listeners.clear();
      for (const embed of embeds) {
        embed.destroy();
      }
    },
  };
  return client;
}
