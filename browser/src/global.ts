// Entry of the `<script>` build (`dist/meteroid.global.js`): sets `window.Meteroid`
// and mounts the embeds declared with data attributes. It keeps the API of the
// `/embed.js` it replaces (`mountBillingPortal`, `baseUrl`, `onNavigate(target)`).
import { createMeteroid } from "./client";
import {
  buildEmbedUrl,
  DEFAULT_PORTAL_URL,
  type EmbedHandle,
  type EmbedOptions,
  mountEmbed,
} from "./embed";
import { ApiException } from "./errors";
import { DEFAULT_API_URL } from "./http";

interface LegacyEmbedOptions extends Omit<EmbedOptions, "onNavigate"> {
  token: string;
  portalUrl?: string;
  baseUrl?: string;
  onNavigate?: (target: string) => void;
}

const fromLegacy = ({ baseUrl, onNavigate, ...options }: LegacyEmbedOptions) => ({
  ...options,
  portalUrl: options.portalUrl ?? baseUrl,
  onNavigate: onNavigate && ((event: { target: string }) => onNavigate(event.target)),
});

const mountBillingPortal = (
  target: string | HTMLElement,
  options: LegacyEmbedOptions
): EmbedHandle => mountEmbed(target, fromLegacy(options));

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
    buildEmbedUrl: (options: LegacyEmbedOptions) => buildEmbedUrl(fromLegacy(options)),
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
