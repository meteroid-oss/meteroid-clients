import assert from "node:assert/strict";
import { afterEach, beforeEach, describe, it } from "node:test";
import { createMeteroid } from "../src/client";
import { buildEmbedUrl, mountEmbed, parseEmbedMessage } from "../src/embed";
import { flush, installDom, mockApi } from "./helpers";

const PORTAL = "https://portal.example";
const dom = installDom("https://merchant.example/billing");

const v1 = (type: string, payload: object = {}) => ({
  source: "meteroid",
  v: 1,
  type: `meteroid:${type}`,
  ...payload,
});

function post(data: unknown, source: unknown, origin = PORTAL) {
  window.dispatchEvent(
    new dom.window.MessageEvent("message", { data, origin, source: source as Window })
  );
}

describe("buildEmbedUrl", () => {
  it("builds the portal URL with only the options given", () => {
    const url = new URL(
      buildEmbedUrl({
        token: "tok",
        portalUrl: `${PORTAL}/`,
        view: "invoices",
        accent: "#C6F94E",
        count: 10,
        subscriptionId: "sub_1",
        branding: false,
        onNavigate: () => {},
        origin: "https://merchant.example",
      })
    );
    assert.equal(url.origin + url.pathname, `${PORTAL}/portal/customer`);
    assert.deepEqual(Object.fromEntries(url.searchParams), {
      token: "tok",
      embed: "invoices",
      accent: "#C6F94E",
      count: "10",
      subscription: "sub_1",
      branding: "false",
      nav: "host",
      origin: "https://merchant.example",
    });
  });

  it("defaults to the full portal on app.meteroid.com", () => {
    assert.equal(
      buildEmbedUrl({ token: "a b" }),
      "https://app.meteroid.com/portal/customer?token=a+b&embed=portal"
    );
  });
});

describe("parseEmbedMessage", () => {
  it("reads protocol v1 events, camelCasing their payload", () => {
    assert.deepEqual(
      parseEmbedMessage(v1("plan_changed", { subscription_id: "sub_1" })),
      ["plan_changed", { subscriptionId: "sub_1" }]
    );
    assert.deepEqual(parseEmbedMessage(v1("checkout_completed")), [
      "checkout_completed",
      {},
    ]);
    assert.deepEqual(parseEmbedMessage(v1("ready", { view: "plan" })), [
      "ready",
      { view: "plan" },
    ]);
  });

  it("accepts resize and navigate from portals older than v1, and nothing else", () => {
    assert.deepEqual(parseEmbedMessage({ type: "meteroid:resize", height: 300 }), [
      "resize",
      { height: 300 },
    ]);
    assert.deepEqual(
      parseEmbedMessage({ type: "meteroid:navigate", target: "invoices" }),
      ["navigate", { target: "invoices" }]
    );
    assert.equal(
      parseEmbedMessage({ type: "meteroid:plan_changed", subscription_id: "sub_1" }),
      undefined
    );
    assert.equal(
      parseEmbedMessage({ ...v1("token_expired"), source: "other" }),
      undefined
    );
  });

  it("drops malformed payloads and unknown types", () => {
    for (const data of [
      null,
      "meteroid:resize",
      { type: "resize", height: 10 },
      v1("resize", { height: "10" }),
      v1("resize", { height: -1 }),
      v1("plan_changed"),
      v1("navigate"),
      v1("something_new"),
    ]) {
      assert.equal(parseEmbedMessage(data), undefined, JSON.stringify(data));
    }
  });

  it("only passes http(s) navigation URLs", () => {
    const checkout = "https://portal.example/checkout?token=x";
    assert.deepEqual(
      parseEmbedMessage(v1("navigate", { target: "checkout", url: checkout })),
      ["navigate", { target: "checkout", url: checkout }]
    );
    assert.deepEqual(
      parseEmbedMessage(
        v1("navigate", { target: "checkout", url: "javascript:alert(1)" })
      ),
      ["navigate", { target: "checkout" }]
    );
  });
});

describe("mountEmbed", () => {
  let container: HTMLElement;
  beforeEach(() => {
    container = document.createElement("div");
    container.id = "billing";
    document.body.appendChild(container);
  });
  afterEach(() => container.remove());

  async function mounted(options: Parameters<typeof mountEmbed>[1]) {
    const handle = mountEmbed("#billing", options);
    await flush();
    return handle;
  }

  it("loads the iframe once the token is known, with the host origin", async () => {
    const handle = await mounted({
      getToken: async () => ({ token: "tok", portal_url: PORTAL }),
      view: "plan",
      height: 120,
    });
    const src = new URL(handle.iframe.src);
    assert.equal(src.origin, PORTAL);
    assert.equal(src.searchParams.get("token"), "tok");
    assert.equal(src.searchParams.get("embed"), "plan");
    assert.equal(src.searchParams.get("origin"), "https://merchant.example");
    assert.equal(handle.iframe.style.height, "120px");
    assert.equal(handle.iframe.getAttribute("allow"), "payment");
    assert.equal(container.firstChild, handle.iframe);
    handle.destroy();
  });

  it("only listens to its own iframe, from the portal origin", async () => {
    const handle = await mounted({ token: "tok", portalUrl: PORTAL });
    const other = await mounted({ token: "tok", portalUrl: PORTAL });
    const seen: string[] = [];
    handle.on("plan_changed", (e) => seen.push(e.subscriptionId));
    const frame = handle.iframe.contentWindow;

    post(
      v1("plan_changed", { subscription_id: "wrong-origin" }),
      frame,
      "https://evil.example"
    );
    post(
      v1("plan_changed", { subscription_id: "wrong-source" }),
      other.iframe.contentWindow
    );
    post(v1("plan_changed", { subscription_id: "from-parent" }), window);
    post(v1("plan_changed", { subscription_id: "sub_1" }), frame);

    assert.deepEqual(seen, ["sub_1"]);
    handle.destroy();
    other.destroy();
  });

  it("resizes the iframe and forwards navigation", async () => {
    const targets: object[] = [];
    const handle = await mounted({
      token: "tok",
      portalUrl: PORTAL,
      onNavigate: (event) => targets.push(event),
    });
    assert.equal(new URL(handle.iframe.src).searchParams.get("nav"), "host");
    post({ type: "meteroid:resize", height: 480 }, handle.iframe.contentWindow);
    post(
      v1("navigate", { target: "checkout", url: `${PORTAL}/checkout` }),
      handle.iframe.contentWindow
    );
    assert.equal(handle.iframe.style.height, "480px");
    assert.deepEqual(targets, [{ target: "checkout", url: `${PORTAL}/checkout` }]);
    handle.destroy();
  });

  it("answers token_expired with set_token, to the portal origin only", async () => {
    let calls = 0;
    const handle = await mounted({
      getToken: async () => {
        calls += 1;
        return `tok_${calls}`;
      },
      portalUrl: PORTAL,
    });
    const frame = handle.iframe.contentWindow!;
    const posted: [unknown, string][] = [];
    frame.postMessage = ((message: unknown, targetOrigin: string) =>
      posted.push([message, targetOrigin])) as typeof frame.postMessage;
    const expired: object[] = [];
    handle.on("token_expired", (e) => expired.push(e));

    post(v1("token_expired"), frame);
    await flush();

    assert.deepEqual(expired, [{}]);
    assert.deepEqual(posted, [
      [{ source: "meteroid", v: 1, type: "meteroid:set_token", token: "tok_2" }, PORTAL],
    ]);
    handle.destroy();
  });

  it("reports a token that cannot be fetched", async () => {
    const errors: unknown[] = [];
    const handle = mountEmbed(container, {
      getToken: async () => {
        throw new Error("no session");
      },
    });
    handle.on("error", (e) => errors.push(e.error));
    await flush();
    assert.equal(handle.iframe.getAttribute("src"), null);
    assert.match(String(errors[0]), /no session/);
    handle.destroy();
  });

  it("stops listening and removes the iframe on destroy", async () => {
    const handle = await mounted({ token: "tok", portalUrl: PORTAL });
    const frame = handle.iframe.contentWindow;
    const seen: unknown[] = [];
    handle.on("ready", (e) => seen.push(e));
    handle.destroy();
    post(v1("ready", { view: "portal" }), frame);
    assert.deepEqual(seen, []);
    assert.equal(container.childElementCount, 0);
  });

  it("needs a token or getToken", () => {
    assert.throws(() => mountEmbed(container, {} as never), TypeError);
  });
});

describe("client.mountEmbed", () => {
  it("shares the client's token and refreshes the store on change events", async () => {
    const api = mockApi();
    let tokenCalls = 0;
    const client = createMeteroid({
      getToken: async () => {
        tokenCalls += 1;
        return { token: "tok", portal_url: PORTAL };
      },
      fetch: api.fetch,
    });
    const container = document.body.appendChild(document.createElement("div"));
    const handle = client.mountEmbed(container, { view: "plan" });
    await flush();
    assert.equal(new URL(handle.iframe.src).origin, PORTAL);
    assert.equal(api.calls.length, 0);

    post(v1("plan_changed", { subscription_id: "sub_1" }), handle.iframe.contentWindow);
    await flush();
    assert.equal(api.calls.length, 3);
    assert.equal(client.getSnapshot().entitlements.status, "ready");
    assert.equal(tokenCalls, 1);

    client.destroy();
    assert.equal(container.childElementCount, 0);
  });
});
