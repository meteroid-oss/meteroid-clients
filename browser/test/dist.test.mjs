// Runs against the built package (`dist/`), resolved through its own name so that
// the `exports` map is what gets tested.

import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import { createRequire } from "node:module";
import { describe, it } from "node:test";
import { fileURLToPath } from "node:url";
import { gzipSync } from "node:zlib";
import {
  ApiException,
  buildEmbedUrl,
  checkEntitlement,
  compareDecimal,
  createMeteroid,
  ErrorCode,
  mountEmbed,
} from "@meteroid/browser";
import { build } from "esbuild";
import { JSDOM } from "jsdom";

const require = createRequire(import.meta.url);

describe("built package", () => {
  it("exposes the same API to import and require", () => {
    const cjs = require("@meteroid/browser");
    const functions = {
      createMeteroid,
      mountEmbed,
      buildEmbedUrl,
      checkEntitlement,
      compareDecimal,
      ApiException,
    };
    for (const [name, value] of Object.entries(functions)) {
      assert.equal(typeof value, "function", name);
      assert.equal(typeof cjs[name], "function", name);
    }
    assert.equal(ErrorCode.TokenExpired, "TOKEN_EXPIRED");
    assert.equal(cjs.DEFAULT_API_URL, "https://api.meteroid.com");
  });

  it("does not touch the DOM when imported", () => {
    assert.equal(typeof globalThis.window, "undefined");
    const client = createMeteroid({ getToken: async () => "tok" });
    assert.equal(client.getSnapshot().entitlements.status, "loading");
  });

  it("stays under 10 KB gzipped for createMeteroid + mountEmbed", async () => {
    const result = await build({
      stdin: {
        contents: 'export { createMeteroid, mountEmbed } from "@meteroid/browser";',
        resolveDir: fileURLToPath(new URL(".", import.meta.url)),
      },
      bundle: true,
      minify: true,
      format: "esm",
      write: false,
    });
    const size = gzipSync(result.outputFiles[0].contents).length;
    assert.ok(size < 10_000, `${size} bytes`);
  });

  it("keeps the side effects of the <script> build when a bundler imports it", async () => {
    const result = await build({
      stdin: {
        contents: 'import "@meteroid/browser/meteroid.global.js";',
        resolveDir: fileURLToPath(new URL(".", import.meta.url)),
      },
      bundle: true,
      format: "esm",
      write: false,
      logLevel: "silent",
    });
    assert.match(result.outputFiles[0].text, /mountBillingPortal/);
  });
});

describe("<script> build", () => {
  const script = readFileSync(
    require.resolve("@meteroid/browser/meteroid.global.js"),
    "utf8"
  );

  function load(body) {
    const dom = new JSDOM(`<!doctype html><html><body>${body}</body></html>`, {
      url: "https://merchant.example/",
      runScripts: "outside-only",
    });
    dom.window.eval(script);
    return dom.window;
  }

  it("sets window.Meteroid, including the API of the previous /embed.js", () => {
    const { Meteroid } = load("");
    for (const name of [
      "createMeteroid",
      "mountEmbed",
      "mountBillingPortal",
      "buildEmbedUrl",
    ]) {
      assert.equal(typeof Meteroid[name], "function", name);
    }
    assert.equal(Meteroid.DEFAULT_BASE_URL, "https://app.meteroid.com");
    assert.equal(
      Meteroid.buildEmbedUrl({ token: "t", baseUrl: "https://portal.example" }),
      "https://portal.example/portal/customer?token=t&embed=portal&origin=https%3A%2F%2Fmerchant.example"
    );
  });

  it("keeps the callbacks, getToken and setToken of mountBillingPortal", async () => {
    const window = load('<div id="billing"></div>');
    const events = [];
    let calls = 0;
    const handle = window.Meteroid.mountBillingPortal("#billing", {
      token: "tok_0",
      baseUrl: "https://portal.example",
      getToken: async () => `tok_${++calls}`,
      // Copied out of the jsdom realm, whose Object.prototype differs.
      onPlanChanged: (event) => events.push({ ...event }),
      onNavigate: (target, event) => events.push([target, event.url]),
    });
    await new Promise((resolve) => setTimeout(resolve, 10));
    const frame = handle.iframe.contentWindow;
    assert.equal(new URL(handle.iframe.src).searchParams.get("token"), "tok_0");
    const posted = [];
    frame.postMessage = (message, origin) => posted.push([message.token, origin]);
    const post = (type, payload) =>
      window.dispatchEvent(
        new window.MessageEvent("message", {
          data: { source: "meteroid", v: 1, type: `meteroid:${type}`, ...payload },
          origin: "https://portal.example",
          source: frame,
        })
      );

    post("plan_changed", { subscription_id: "sub_1" });
    post("navigate", { target: "checkout", url: "https://portal.example/checkout" });
    post("token_expired", {});
    await new Promise((resolve) => setTimeout(resolve, 10));
    handle.setToken("tok_manual");

    assert.deepEqual(events, [
      {
        source: "meteroid",
        v: 1,
        type: "meteroid:plan_changed",
        subscription_id: "sub_1",
      },
      ["checkout", "https://portal.example/checkout"],
    ]);
    assert.deepEqual(posted, [
      ["tok_1", "https://portal.example"],
      ["tok_manual", "https://portal.example"],
    ]);
    handle.destroy();
  });

  it("mounts embeds declared with data attributes", async () => {
    const window = load(
      '<div id="a" data-meteroid-portal data-token="tok" data-view="plan" ' +
        'data-base-url="https://portal.example" data-count="3" data-branding="false"></div>'
    );
    await new Promise((resolve) => setTimeout(resolve, 10));
    const iframe = window.document.querySelector("#a iframe");
    assert.ok(iframe);
    const src = new URL(iframe.src);
    assert.equal(src.origin, "https://portal.example");
    assert.equal(src.searchParams.get("embed"), "plan");
    assert.equal(src.searchParams.get("count"), "3");
    assert.equal(src.searchParams.get("branding"), "false");
    assert.equal(src.searchParams.get("origin"), "https://merchant.example");
  });
});
