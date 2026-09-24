// Runs against the built package (`dist/`), resolved through its own name so that
// the `exports` map is what gets tested.

import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import { createRequire } from "node:module";
import { describe, it } from "node:test";
import { fileURLToPath } from "node:url";
import { gzipSync } from "node:zlib";
import { Gate, MeteroidProvider, useEntitlement } from "@meteroid/react";
import { build } from "esbuild";
import { createElement } from "react";
import { renderToString } from "react-dom/server";

const require = createRequire(import.meta.url);

describe("built package", () => {
  it("exposes the same API to import and require", () => {
    const cjs = require("@meteroid/react");
    assert.equal(typeof MeteroidProvider, "function");
    assert.equal(typeof useEntitlement, "function");
    for (const name of [
      "MeteroidProvider",
      "Gate",
      "UsageMeter",
      "BillingEmbed",
      "useEntitlement",
    ]) {
      assert.equal(typeof cjs[name], "function", name);
    }
  });

  it("marks both builds as client modules", () => {
    for (const file of ["../dist/index.mjs", "../dist/index.cjs"]) {
      const source = readFileSync(new URL(file, import.meta.url), "utf8");
      assert.ok(source.startsWith('"use client";'), file);
    }
  });

  it("renders on the server", () => {
    const html = renderToString(
      createElement(
        MeteroidProvider,
        { getToken: async () => "tok" },
        createElement(Gate, { feature: "sso", loading: "loading" }, "sso")
      )
    );
    assert.equal(html, "loading");
  });

  it("stays under 5 KB gzipped on top of @meteroid/browser", async () => {
    const result = await build({
      stdin: {
        contents: 'export * from "@meteroid/react";',
        resolveDir: fileURLToPath(new URL(".", import.meta.url)),
      },
      bundle: true,
      minify: true,
      format: "esm",
      external: ["react", "react/jsx-runtime", "@meteroid/browser"],
      write: false,
    });
    const size = gzipSync(result.outputFiles[0].contents).length;
    assert.ok(size < 5_000, `${size} bytes`);
  });
});
