// Entry of the `<script>` build (`dist/meteroid.global.js`): sets `window.Meteroid`
// and mounts the embeds declared with data attributes. It keeps the API of the
// `/embed.js` it replaces (`mountBillingPortal`, `baseUrl`, `on*` callbacks, `setToken`).
import { createMeteroid } from "./client";
import {
  buildEmbedUrl,
  DEFAULT_PORTAL_URL,
  type EmbedEventType,
  type EmbedOptions,
  hostOrigin,
  type MountedEmbed,
  mount,
  mountEmbed,
} from "./embed";
import { ApiException } from "./errors";
import { DEFAULT_API_URL } from "./http";
import { createTokenSource, type GetToken } from "./token";

const LEGACY_CALLBACKS = {
  ready: "onReady",
  plan_changed: "onPlanChanged",
  subscription_canceled: "onSubscriptionCanceled",
  payment_method_added: "onPaymentMethodAdded",
  checkout_opened: "onCheckoutOpened",
  checkout_completed: "onCheckoutCompleted",
  token_expired: "onTokenExpired",
} as const;

type LegacyEvent = Record<string, unknown>;

type LegacyCallbacks = {
  [K in (typeof LEGACY_CALLBACKS)[keyof typeof LEGACY_CALLBACKS]]?: (
    event: LegacyEvent
  ) => void;
};

interface LegacyEmbedOptions extends Omit<EmbedOptions, "onNavigate">, LegacyCallbacks {
  token: string;
  portalUrl?: string;
  baseUrl?: string;
  /** Only called on `token_expired`: the iframe starts with `token`. */
  getToken?: GetToken;
  onNavigate?: (target: string, event: LegacyEvent) => void;
}

// `/embed.js` passed its callbacks the message itself, with snake_case ids.
const legacyEvent = (
  type: string,
  { subscriptionId, ...payload }: LegacyEvent
): LegacyEvent => ({
  source: "meteroid",
  v: 1,
  type: `meteroid:${type}`,
  ...payload,
  ...(subscriptionId === undefined ? {} : { subscription_id: subscriptionId }),
});

const fromLegacy = ({ baseUrl, onNavigate, ...options }: LegacyEmbedOptions) => ({
  ...options,
  portalUrl: options.portalUrl ?? baseUrl,
  onNavigate:
    onNavigate &&
    ((event: { target: string; url?: string }) =>
      onNavigate(event.target, legacyEvent("navigate", event))),
});

function mountBillingPortal(
  target: string | HTMLElement,
  legacy: LegacyEmbedOptions
): MountedEmbed {
  const { token, getToken, portalUrl, ...options } = fromLegacy(legacy);
  const renew = getToken && createTokenSource(getToken);
  const handle = mount(
    target,
    options,
    { get: async () => ({ token }), refresh: renew?.refresh },
    portalUrl
  );
  for (const [type, name] of Object.entries(LEGACY_CALLBACKS)) {
    handle.on(type as EmbedEventType, (event) =>
      legacy[name]?.(legacyEvent(type, event as LegacyEvent))
    );
  }
  return handle;
}

const DATA_ATTRIBUTES: Record<string, string> = {
  view: "view",
  theme: "theme",
  accent: "accent",
  radius: "radius",
  bg: "bg",
  surface: "surface",
  text: "text",
  border: "border",
  baseUrl: "base-url",
  portalUrl: "portal-url",
  subscriptionId: "subscription-id",
};

function optionsFromElement(element: HTMLElement): LegacyEmbedOptions | undefined {
  const token =
    element.getAttribute("data-token") ?? element.getAttribute("data-meteroid-token");
  if (!token) {
    return undefined;
  }
  const options: Record<string, unknown> = { token };
  for (const [key, name] of Object.entries(DATA_ATTRIBUTES)) {
    const value = element.getAttribute(`data-${name}`);
    if (value) {
      options[key] = value;
    }
  }
  const count = element.getAttribute("data-count");
  if (count) {
    options.count = Number(count);
  }
  if (element.getAttribute("data-branding") === "false") {
    options.branding = false;
  }
  return options as unknown as LegacyEmbedOptions;
}

function autoMount() {
  const elements = document.querySelectorAll<HTMLElement>(
    "[data-meteroid-portal],[data-meteroid-token]"
  );
  for (const element of Array.from(elements)) {
    const options = optionsFromElement(element);
    if (!options || element.getAttribute("data-meteroid-mounted") === "true") {
      continue;
    }
    element.setAttribute("data-meteroid-mounted", "true");
    // A `<script data-meteroid-portal>` mounts into a new element right after it.
    let host = element;
    if (element.tagName === "SCRIPT") {
      host = document.createElement("div");
      element.parentNode?.insertBefore(host, element.nextSibling);
    }
    mountBillingPortal(host, options);
  }
}

if (typeof window !== "undefined") {
  (window as unknown as { Meteroid: object }).Meteroid = {
    createMeteroid,
    mountEmbed,
    buildEmbedUrl: (options: LegacyEmbedOptions) =>
      buildEmbedUrl({ origin: hostOrigin(), ...fromLegacy(options) }),
    mountBillingPortal,
    ApiException,
    DEFAULT_API_URL,
    DEFAULT_PORTAL_URL,
    DEFAULT_BASE_URL: DEFAULT_PORTAL_URL,
  };
  if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", autoMount);
  } else {
    autoMount();
  }
}
