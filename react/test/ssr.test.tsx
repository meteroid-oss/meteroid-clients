import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { renderToString } from "react-dom/server";
import {
  BillingEmbed,
  BillingPortal,
  Gate,
  MeteroidProvider,
  UsageMeter,
  useEntitlement,
} from "../src/index";
import { parsedEntitlements } from "./helpers";

describe("server rendering", () => {
  let tokenCalls = 0;
  const getToken = async () => {
    tokenCalls += 1;
    return "tok";
  };
  globalThis.fetch = (() => {
    throw new Error("no request on the server");
  }) as typeof fetch;

  const page = (props: object) => (
    <MeteroidProvider getToken={getToken} {...props}>
      <Gate feature="sso" fallback="[upgrade sso]" loading="[loading]">
        [sso]
      </Gate>
      <Gate feature="audit_log" fallback="[upgrade audit]">
        [audit]
      </Gate>
      <UsageMeter feature="api_calls" />
      <BillingEmbed view="plan" />
      <BillingPortal />
    </MeteroidProvider>
  );

  it("runs without a DOM", () => {
    assert.equal(typeof window, "undefined");
  });

  it("renders the gates from initialEntitlements, and placeholders for embeds", () => {
    const initialEntitlements = parsedEntitlements();
    const html = renderToString(page({ initialEntitlements }));
    assert.match(html, /\[sso\]/);
    assert.match(html, /\[upgrade audit\]/);
    assert.match(html, /data-meteroid-usage-meter="" data-meteroid-feature="api_calls"/);
    assert.match(html, /--meteroid-usage-ratio:0.1234/);
    assert.match(html, /<div data-meteroid-embed="plan"><\/div>/);
    assert.match(html, /<div data-meteroid-embed="portal"><\/div>/);
    assert.doesNotMatch(html, /<iframe/);
  });

  it("renders the loading state without initialEntitlements", () => {
    const html = renderToString(page({}));
    assert.match(html, /\[loading\]/);
    assert.doesNotMatch(html, /\[sso\]|\[upgrade/);
    assert.match(html, /data-meteroid-status="loading"/);
  });

  it("fetches nothing on the server", () => {
    assert.equal(tokenCalls, 0);
  });

  it("needs a provider", () => {
    function Orphan() {
      useEntitlement("sso");
      return null;
    }
    assert.throws(() => renderToString(<Orphan />), /inside <MeteroidProvider>/);
  });
});
