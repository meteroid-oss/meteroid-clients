import { defineConfig, devices } from '@playwright/test';

import { BASE_URL, FRONTEND_URL } from './support/env.js';

/**
 * This suite is deliberately small.
 *
 * `tests/contract` already drives every operation in `openapi.yaml` and validates each response
 * against its schema, which is a far better and far faster way to test a backend than a browser.
 * So the only things that live here are the three behaviours that genuinely cannot be seen over
 * HTTP: a redirect that leaves the app, a token that has to work on someone else's domain, and a
 * UI state that only appears in response to a `402`.
 *
 * It needs a live Meteroid sandbox, so it belongs in a nightly job, not on a pull request. See
 * README.md.
 */
export default defineConfig({
  testDir: './specs',

  // A live sandbox is slow and rate-limited; running specs in parallel against one tenant
  // invites 429s and cross-talk between workspaces. Nightly runs can afford to be serial.
  fullyParallel: false,
  workers: 1,

  // Fail the CI run if a stray `test.only` was committed, rather than passing on a subset.
  // (Note this does *not* police `test.skip` — see README on why a run of three skips is a broken
  // fixture, not a pass.)
  forbidOnly: !!process.env.CI,

  // Retry once in CI. A single retry absorbs a flaky sandbox without hiding a real regression;
  // more than that starts papering over genuine intermittency.
  retries: process.env.CI ? 1 : 0,

  reporter: process.env.CI ? [['github'], ['html', { open: 'never' }]] : [['list']],

  // Every timeout below is generous *and* bounded. Nothing in this suite ever calls
  // `waitForTimeout` — assertions retry until the condition holds or the deadline passes, so a
  // fast sandbox stays fast and a slow one still succeeds.
  timeout: 90_000,
  expect: { timeout: 15_000 },

  use: {
    baseURL: FRONTEND_URL,

    // The hosted Meteroid checkout and portal are third-party pages on a slow-ish sandbox.
    actionTimeout: 15_000,
    navigationTimeout: 45_000,

    trace: 'retain-on-failure',
    screenshot: 'only-on-failure',
    video: 'retain-on-failure',

    // Matches the `data-testid` attributes named in support/selectors.ts.
    testIdAttribute: 'data-testid',
  },

  projects: [{ name: 'chromium', use: { ...devices['Desktop Chrome'] } }],

  metadata: {
    backend: BASE_URL,
    frontend: FRONTEND_URL,
  },
});
