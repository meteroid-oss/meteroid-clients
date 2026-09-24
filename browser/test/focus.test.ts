import assert from "node:assert/strict";
import { describe, it, mock } from "node:test";
import { createMeteroid } from "../src/client";
import { flush, installDom, mockApi } from "./helpers";

const dom = installDom();

describe("refresh on focus", () => {
  it("refreshes when the window regains focus, at most every 30 s, while subscribed", async () => {
    mock.timers.enable({ apis: ["Date"], now: 1_000_000 });
    const api = mockApi();
    const client = createMeteroid({ getToken: async () => "tok", fetch: api.fetch });
    const unsubscribe = client.subscribe(() => {});
    await flush();
    assert.equal(api.calls.length, 3);

    window.dispatchEvent(new dom.window.Event("focus"));
    await flush();
    assert.equal(api.calls.length, 3);

    mock.timers.tick(30_000);
    document.dispatchEvent(new dom.window.Event("visibilitychange"));
    await flush();
    assert.equal(api.calls.length, 6);

    unsubscribe();
    mock.timers.tick(30_000);
    window.dispatchEvent(new dom.window.Event("focus"));
    await flush();
    assert.equal(api.calls.length, 6);
    mock.timers.reset();
  });
});
