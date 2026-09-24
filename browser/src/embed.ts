import { type ClientToken, createTokenSource, type GetToken } from "./token";

/** Where the portal is served when neither `portalUrl` nor the token says otherwise. */
export const DEFAULT_PORTAL_URL = "https://app.meteroid.com";

const DEFAULT_HEIGHT = 240;

/** Which view the embedded portal renders (the `?embed=` parameter). */
export type EmbedView =
  | "portal"
  | "plan"
  | "subscriptions"
  | "subscription"
  | "usage"
  | "invoices"
  | "payment-methods";

/**
 * Events of protocol v1, keyed by their `type` without the `meteroid:` prefix.
 * Payloads carry ids only; their fields are camelCased.
 */
export interface EmbedEvents {
  ready: { view: string };
  resize: { height: number };
  /** Only sent when the host handles navigation (`onNavigate`). */
  navigate: { target: string; url?: string };
  plan_changed: { subscriptionId: string };
  subscription_canceled: { subscriptionId: string };
  payment_method_added: Record<string, never>;
  checkout_opened: { subscriptionId?: string };
  checkout_completed: { subscriptionId?: string };
  token_expired: Record<string, never>;
  /** Not sent by the portal: no token could be fetched for the embed. */
  error: { error: unknown };
}

export type EmbedEventType = keyof EmbedEvents;

export interface EmbedOptions {
  /** Default `"portal"`, the full portal. */
  view?: EmbedView;
  theme?: "light" | "dark";
  /** Hex accent color, e.g. `#C6F94E`. */
  accent?: string;
  radius?: "Sharp" | "Modern" | "Rounded";
  bg?: string;
  surface?: string;
  text?: string;
  border?: string;
  /** Rows per page of the `invoices` view. */
  count?: number;
  /** The subscription shown by the `subscription` view. */
  subscriptionId?: string;
  /** `false` hides the "Powered by Meteroid" attribution. */
  branding?: boolean;
  /** Initial iframe height in pixels; the embed then resizes itself. Default 240. */
  height?: number;
  /** Class name of the iframe. */
  className?: string;
  /**
   * Handle navigation in the host: the embed then posts `navigate` (e.g. a portal
   * page, or `target: "checkout"` with its `url`) instead of opening it itself.
   */
  onNavigate?: (event: EmbedEvents["navigate"]) => void;
}

export interface EmbedUrlOptions extends EmbedOptions {
  token: string;
  portalUrl?: string;
  /** The host page's origin, the only one the embed posts its events to. */
  origin?: string;
}

export type StandaloneEmbedOptions = EmbedOptions & {
  portalUrl?: string;
} & ({ token: string; getToken?: undefined } | { getToken: GetToken; token?: undefined });

export interface EmbedHandle {
  readonly iframe: HTMLIFrameElement;
  /** Listen to an event of the embed; returns the unsubscribe function. */
  on<T extends EmbedEventType>(
    type: T,
    listener: (event: EmbedEvents[T]) => void
  ): () => void;
  /** Remove the iframe and every listener. */
  destroy(): void;
}

/** @internal `setToken` serves the `/embed.js` API of the `<script>` build. */
export interface MountedEmbed extends EmbedHandle {
  setToken(token: string): void;
}

/** @internal */
export interface EmbedTokens {
  get(): Promise<ClientToken>;
  refresh?(stale?: string): Promise<ClientToken>;
}

/** Build the iframe URL of an embed. */
export function buildEmbedUrl(options: EmbedUrlOptions): string {
  const params = new URLSearchParams({
    token: options.token,
    embed: options.view ?? "portal",
  });
  const set = (name: string, value: string | number | undefined) => {
    if (value !== undefined && value !== "") {
      params.set(name, String(value));
    }
  };
  set("theme", options.theme);
  set("accent", options.accent);
  set("radius", options.radius);
  set("bg", options.bg);
  set("surface", options.surface);
  set("text", options.text);
  set("border", options.border);
  set("count", options.count);
  set("subscription", options.subscriptionId);
  if (options.branding === false) {
    params.set("branding", "false");
  }
  if (options.onNavigate) {
    params.set("nav", "host");
  }
  set("origin", options.origin);
  const base = (options.portalUrl || DEFAULT_PORTAL_URL).replace(/\/+$/, "");
  return `${base}/portal/customer?${params}`;
}

const httpUrl = (value: unknown): string | undefined => {
  try {
    const url = new URL(value as string);
    return url.protocol === "https:" || url.protocol === "http:" ? url.href : undefined;
  } catch {
    return undefined;
  }
};

/**
 * @internal The event carried by a portal message, or `undefined`. Portals older than protocol
 * v1 (no `source` and `v`) only send `resize` and `navigate`, the only types taken from them.
 */
export function parseEmbedMessage(data: unknown): [EmbedEventType, object] | undefined {
  if (typeof data !== "object" || data === null) {
    return undefined;
  }
  const message = data as Record<string, unknown>;
  if (typeof message.type !== "string" || !message.type.startsWith("meteroid:")) {
    return undefined;
  }
  const type = message.type.slice("meteroid:".length);
  const subscriptionId = message.subscription_id;
  if (type === "resize") {
    const height = message.height;
    return typeof height === "number" && height >= 0 && height < Number.POSITIVE_INFINITY
      ? [type, { height }]
      : undefined;
  }
  if (type === "navigate") {
    if (typeof message.target !== "string") {
      return undefined;
    }
    const url = httpUrl(message.url);
    return [type, url ? { target: message.target, url } : { target: message.target }];
  }
  if (message.source !== "meteroid" || !((message.v as number) >= 1)) {
    return undefined;
  }
  switch (type) {
    case "ready":
      return [type, { view: typeof message.view === "string" ? message.view : "" }];
    case "plan_changed":
    case "subscription_canceled":
      return typeof subscriptionId === "string" ? [type, { subscriptionId }] : undefined;
    case "checkout_opened":
    case "checkout_completed":
      return [type, typeof subscriptionId === "string" ? { subscriptionId } : {}];
    case "payment_method_added":
    case "token_expired":
      return [type, {}];
    default:
      return undefined;
  }
}

/** @internal */
export const hostOrigin = (): string | undefined => {
  const origin = window.location.origin;
  return origin && origin !== "null" ? origin : undefined;
};

/** @internal */
export function mount(
  target: string | HTMLElement,
  options: EmbedOptions,
  tokens: EmbedTokens,
  portalUrl: string | undefined
): MountedEmbed {
  const container =
    typeof target === "string" ? document.querySelector<HTMLElement>(target) : target;
  if (!container) {
    throw new Error(`Meteroid: embed target not found: ${target}`);
  }
  const iframe = document.createElement("iframe");
  iframe.title = "Meteroid billing portal";
  iframe.setAttribute("allow", "payment");
  iframe.style.cssText = `width:100%;border:none;display:block;height:${options.height ?? DEFAULT_HEIGHT}px`;
  if (options.className) {
    iframe.className = options.className;
  }

  const listeners = new Map<string, Set<(event: any) => void>>();
  let origin: string | undefined;
  let token: string | undefined;
  let destroyed = false;

  const emit = (type: EmbedEventType, event: object) =>
    listeners.get(type)?.forEach((listener) => listener(event));

  const setToken = (next: string) => {
    token = next;
    if (!destroyed && origin) {
      iframe.contentWindow?.postMessage(
        { source: "meteroid", v: 1, type: "meteroid:set_token", token: next },
        origin
      );
    }
  };

  const onMessage = (message: MessageEvent) => {
    const frame = iframe.contentWindow;
    if (!origin || !frame || message.origin !== origin || message.source !== frame) {
      return;
    }
    const parsed = parseEmbedMessage(message.data);
    if (!parsed) {
      return;
    }
    const [type, event] = parsed;
    if (type === "resize") {
      iframe.style.height = `${(event as EmbedEvents["resize"]).height}px`;
    } else if (type === "navigate") {
      options.onNavigate?.(event as EmbedEvents["navigate"]);
    } else if (type === "token_expired" && tokens.refresh) {
      tokens.refresh(token).then(
        (next) => setToken(next.token),
        (error) => emit("error", { error })
      );
    }
    emit(type, event);
  };

  window.addEventListener("message", onMessage);
  container.appendChild(iframe);

  tokens.get().then(
    (current) => {
      if (destroyed) {
        return;
      }
      token = current.token;
      const src = buildEmbedUrl({
        ...options,
        token: current.token,
        portalUrl: portalUrl ?? current.portalUrl,
        origin: hostOrigin(),
      });
      origin = new URL(src).origin;
      iframe.src = src;
    },
    (error) => {
      if (!destroyed) {
        emit("error", { error });
      }
    }
  );

  return {
    iframe,
    on(type, listener) {
      let set = listeners.get(type);
      if (!set) {
        set = new Set();
        listeners.set(type, set);
      }
      set.add(listener);
      return () => set.delete(listener);
    },
    destroy() {
      destroyed = true;
      window.removeEventListener("message", onMessage);
      iframe.remove();
      listeners.clear();
    },
    setToken,
  };
}

/**
 * Mount a billing embed into `target` (an element or a selector), with a `token` or `getToken`.
 * Prefer `client.mountEmbed`: it shares the client's token and refreshes its data on changes.
 */
export function mountEmbed(
  target: string | HTMLElement,
  options: StandaloneEmbedOptions
): EmbedHandle {
  const { token, getToken } = options;
  if (!token && !getToken) {
    throw new TypeError("Meteroid: mountEmbed() needs a token or getToken");
  }
  const tokens: EmbedTokens = getToken
    ? createTokenSource(getToken)
    : { get: () => Promise.resolve({ token: token! }) };
  return mount(target, options, tokens, options.portalUrl);
}
