import "./setup-dom";

import assert from "node:assert/strict";
import { afterEach, beforeEach, describe, it } from "node:test";
import type { EntitlementCheck } from "@meteroid/browser";
import { act, type ReactNode } from "react";
import { createRoot, hydrateRoot, type Root } from "react-dom/client";
import { renderToString } from "react-dom/server";
import {
  BillingEmbed,
  Gate,
  MeteroidProvider,
  UsageMeter,
  useCustomer,
  useEntitlement,
  useMeteroid,
  useSubscriptions,
} from "../src/index";
import {
  entitlementsFor,
  flush,
  json,
  mockApi,
  PORTAL,
  parsedEntitlements,
} from "./helpers";

let container: HTMLElement;
let root: Root | undefined;

beforeEach(() => {
  container = document.body.appendChild(document.createElement("div"));
});

afterEach(async () => {
  await act(async () => root?.unmount());
  root = undefined;
  container.remove();
});

async function render(node: ReactNode) {
  root ??= createRoot(container);
  await act(async () => root!.render(node));
  await settle();
}

const settle = () => act(flush);

const tokenFor = (who: string) => async () => ({
  token: `tok_${who}`,
  portal_url: PORTAL,
});

function postFromIframe(iframe: HTMLIFrameElement, data: object) {
  window.dispatchEvent(
    new window.MessageEvent("message", {
      data: { source: "meteroid", v: 1, ...data },
      origin: PORTAL,
      source: iframe.contentWindow,
    })
  );
}

describe("useEntitlement", () => {
  it("answers with the fallback while loading, then from the entitlements", async () => {
    mockApi();
    const seen: EntitlementCheck[] = [];
    function Probe() {
      seen.push(useEntitlement("api_calls", { fallback: true }));
      return null;
    }
    await render(
      <MeteroidProvider getToken={tokenFor("a")}>
        <Probe />
      </MeteroidProvider>
    );
    assert.deepEqual(seen[0], {
      status: "loading",
      hasAccess: true,
      isFallback: true,
      entitlement: undefined,
    });
    const last = seen[seen.length - 1];
    assert.equal(last.status, "ready");
    assert.equal(last.isFallback, false);
    assert.equal(last.hasAccess, true);
    assert.equal(last.usage?.consumed, "1234");
    assert.equal(last.usage?.limit, "10000");
  });

  it("serves the customer and the subscriptions", async () => {
    mockApi();
    let customer: ReturnType<typeof useCustomer> | undefined;
    let subscriptions: ReturnType<typeof useSubscriptions> | undefined;
    function Probe() {
      customer = useCustomer();
      subscriptions = useSubscriptions();
      return null;
    }
    await render(
      <MeteroidProvider getToken={tokenFor("a")}>
        <Probe />
      </MeteroidProvider>
    );
    assert.equal(customer?.data?.name, "a");
    assert.equal(subscriptions?.data?.[0].planName, "Pro");
  });
});

describe("MeteroidProvider", () => {
  it("keeps its client across renders with a new inline getToken, and calls the latest", async () => {
    let expire = false;
    const calls = mockApi((path, authorization) =>
      expire && path === "/entitlements" && authorization === "Bearer tok_a"
        ? json(401, { code: "TOKEN_EXPIRED", message: "expired" })
        : undefined
    );
    let refresh: (() => Promise<void>) | undefined;
    function Probe() {
      refresh = useMeteroid().refresh;
      useEntitlement("sso");
      return null;
    }
    const app = (who: string) => (
      <MeteroidProvider getToken={() => tokenFor(who)()}>
        <Probe />
      </MeteroidProvider>
    );
    await render(app("a"));
    await render(app("b"));
    await render(app("c"));
    assert.equal(calls.length, 3);

    expire = true;
    await act(() => refresh!());
    assert.deepEqual(
      calls.slice(3).map((c) => c.authorization),
      ["Bearer tok_a", "Bearer tok_a", "Bearer tok_a", "Bearer tok_c"]
    );
  });

  it("resets the state when customerKey changes", async () => {
    const calls = mockApi();
    const names: (string | undefined)[] = [];
    function Probe() {
      const customer = useCustomer();
      names.push(customer.status === "ready" ? customer.data?.name : customer.status);
      return null;
    }
    const app = (who: string) => (
      <MeteroidProvider getToken={tokenFor(who)} customerKey={who}>
        <Probe />
      </MeteroidProvider>
    );
    await render(app("a"));
    await render(app("b"));
    assert.deepEqual(
      [names[0], names.includes("a"), names[names.length - 1]],
      ["loading", true, "b"]
    );
    assert.equal(names[names.lastIndexOf("a") + 1], "loading");
    assert.ok(calls.slice(3).every((c) => c.authorization === "Bearer tok_b"));
  });

  it("keeps the previous customer's initialEntitlements out of the next one", async () => {
    mockApi();
    const seen: string[] = [];
    function Probe() {
      const { status, hasAccess } = useEntitlement("sso");
      seen.push(`${status}:${hasAccess}`);
      return null;
    }
    const initial = parsedEntitlements();
    const app = (who: string, initialEntitlements = initial) => (
      <MeteroidProvider
        getToken={() => new Promise<string>(() => {})}
        customerKey={who}
        initialEntitlements={initialEntitlements}
      >
        <Probe />
      </MeteroidProvider>
    );
    await render(app("a"));
    assert.equal(seen[seen.length - 1], "ready:true");
    await render(app("b"));
    assert.equal(seen[seen.length - 1], "loading:false");
    await render(app("c", parsedEntitlements()));
    assert.equal(seen[seen.length - 1], "ready:true");
  });

  it("hydrates server-rendered markup without a mismatch", async () => {
    mockApi();
    const initialEntitlements = parsedEntitlements();
    const app = (
      <MeteroidProvider
        getToken={tokenFor("a")}
        initialEntitlements={initialEntitlements}
      >
        <Gate feature="sso" fallback="upgrade">
          sso on
        </Gate>
        <UsageMeter feature="api_calls" />
        <BillingEmbed view="plan" />
      </MeteroidProvider>
    );
    container.innerHTML = renderToString(app);
    const errors: unknown[] = [];
    await act(async () => {
      root = hydrateRoot(container, app, { onRecoverableError: (e) => errors.push(e) });
    });
    await settle();
    assert.deepEqual(errors, []);
    assert.match(container.textContent ?? "", /sso on/);
  });
});

describe("Gate", () => {
  it("renders loading, then the children or the fallback", async () => {
    mockApi();
    let release: (token: string) => void = () => {};
    const getToken = () =>
      new Promise<string>((resolve) => {
        release = resolve;
      });
    await render(
      <MeteroidProvider getToken={getToken}>
        <Gate feature="sso" loading="loading" fallback="upgrade">
          [sso]
        </Gate>
        <Gate feature="audit_log" fallback="upgrade">
          [audit]
        </Gate>
      </MeteroidProvider>
    );
    assert.equal(container.textContent, "loading");
    await act(async () => release("tok"));
    await settle();
    assert.equal(container.textContent, "[sso]upgrade");
  });
});

describe("UsageMeter", () => {
  it("renders unstyled markup with data attributes and CSS variables", async () => {
    mockApi();
    await render(
      <MeteroidProvider getToken={tokenFor("a")}>
        <UsageMeter feature="api_calls" className="meter" />
      </MeteroidProvider>
    );
    const meter = container.querySelector<HTMLElement>("[data-meteroid-usage-meter]")!;
    assert.equal(meter.className, "meter");
    assert.equal(meter.dataset.meteroidFeature, "api_calls");
    assert.equal(meter.dataset.meteroidStatus, "ready");
    assert.equal(meter.dataset.meteroidAccess, "granted");
    assert.equal(meter.style.getPropertyValue("--meteroid-usage-ratio"), "0.1234");
    assert.equal(meter.style.getPropertyValue("--meteroid-usage-percent"), "12.34%");
    assert.equal(
      meter.querySelector("[data-meteroid-usage-value]")?.textContent,
      "1234 / 10000"
    );
    assert.equal(meter.querySelector("meter")?.getAttribute("value"), "0.1234");
  });

  it("flags unlimited features and hands the state to a render prop", async () => {
    mockApi((path) =>
      path === "/entitlements" ? json(200, entitlementsFor(null)) : undefined
    );
    await render(
      <MeteroidProvider getToken={tokenFor("a")}>
        <UsageMeter feature="api_calls" />
        <UsageMeter feature="api_calls">
          {(state) => <output>{`${state.ratio}|${state.usage?.consumed}`}</output>}
        </UsageMeter>
      </MeteroidProvider>
    );
    const meter = container.querySelector<HTMLElement>("[data-meteroid-usage-meter]")!;
    assert.equal(meter.dataset.meteroidUnlimited, "");
    assert.equal(meter.querySelector("meter"), null);
    assert.equal(container.querySelector("output")?.textContent, "undefined|1234");
  });
});

describe("BillingEmbed", () => {
  it("mounts the embed, forwards typed events and refreshes the state", async () => {
    const calls = mockApi();
    const changed: string[] = [];
    const app = (label: string) => (
      <MeteroidProvider getToken={tokenFor("a")}>
        <BillingEmbed
          view="plan"
          className="billing"
          onPlanChanged={(event) => changed.push(`${label}:${event.subscriptionId}`)}
        />
      </MeteroidProvider>
    );
    await render(app("first"));
    const host = container.querySelector<HTMLElement>('[data-meteroid-embed="plan"]')!;
    assert.equal(host.className, "billing");
    const iframe = host.querySelector("iframe")!;
    const src = new URL(iframe.src);
    assert.equal(src.origin, PORTAL);
    assert.equal(src.searchParams.get("embed"), "plan");
    assert.equal(src.searchParams.get("nav"), null);

    await render(app("second"));
    assert.equal(host.querySelector("iframe"), iframe);
    const before = calls.length;
    postFromIframe(iframe, { type: "meteroid:plan_changed", subscription_id: "sub_1" });
    await settle();
    assert.deepEqual(changed, ["second:sub_1"]);
    assert.equal(calls.length, before + 3);

    await act(async () => root!.unmount());
    root = undefined;
    assert.equal(iframe.isConnected, false);
  });

  it("asks the embed to delegate navigation when onNavigate is set", async () => {
    mockApi();
    const targets: string[] = [];
    await render(
      <MeteroidProvider getToken={tokenFor("a")}>
        <BillingEmbed view="plan" onNavigate={(event) => targets.push(event.target)} />
      </MeteroidProvider>
    );
    const iframe = container.querySelector("iframe")!;
    assert.equal(new URL(iframe.src).searchParams.get("nav"), "host");
    postFromIframe(iframe, { type: "meteroid:navigate", target: "invoices" });
    assert.deepEqual(targets, ["invoices"]);
  });
});
