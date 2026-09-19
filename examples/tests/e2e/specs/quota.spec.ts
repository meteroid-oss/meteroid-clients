import { expect, test } from '@playwright/test';

import { drainQuota, readQuota, type ApiError } from '../support/api.js';
import { openApp, setControlValue, useSession } from '../support/app.js';
import { BASE_URL, SUBSCRIBED_SESSION_TOKEN } from '../support/env.js';
import { testIds } from '../support/selectors.js';

/** The contract's per-transcription maximum. Exceeds any drained balance, whatever is left of it. */
const OVER_LIMIT_DURATION_SECONDS = 7200;

/**
 * The quota wall — the reason entitlements exist, and the only place billing reaches into the
 * product's hot path.
 *
 * The contract suite already asserts that `POST /api/transcriptions` returns `402 QUOTA_EXHAUSTED`
 * with a populated `quota` and an `upgrade_plan_code`. The open question, and the only one left for
 * a browser, is what the *visitor* sees: a 402 is a failed HTTP request, and the default thing a
 * SPA does with a failed request is show a generic error toast. Turning it into a paywall with the
 * right plan on it is frontend work, and nothing but a browser can check it.
 *
 * The wall is reached through the API rather than through thirty clicks, because reaching it is
 * backend behaviour that is already covered; only the last step happens in the page.
 */
test.describe('quota exhaustion', () => {
  test.skip(
    SUBSCRIBED_SESSION_TOKEN === undefined,
    'SCRIBE_SUBSCRIBED_SESSION_TOKEN is not set. This spec needs a workspace already subscribed to a ' +
      'plan with a finite transcription_minutes limit (Free). Provisioning one means completing a ' +
      'hosted checkout, which this suite does not automate — see README.md.',
  );

  test('shows the upgrade prompt instead of a generic error', async ({ page, request }) => {
    const token = SUBSCRIBED_SESSION_TOKEN;
    if (!token) throw new Error('unreachable: guarded by the describe-level skip');

    const quota = await readQuota(request, token);
    test.skip(
      quota === null,
      'the fixture workspace has no METERED transcription_minutes entitlement — it is not subscribed, ' +
        'or the catalog is not seeded. Check GET /api/entitlements for that token.',
    );
    if (!quota) return;

    test.skip(
      quota.unlimited,
      'the fixture workspace is on an unlimited plan, where 402 is unreachable by design. Point ' +
        'SCRIBE_SUBSCRIBED_SESSION_TOKEN at a Free workspace.',
    );

    // Spend the balance over HTTP. Stops just short of the wall, leaving the 402 for the browser.
    await drainQuota(request, token, quota);

    await useSession(page, token);
    await openApp(page);
    await expect(page.getByTestId(testIds.quotaMeter)).toBeVisible();

    const attempt = page.waitForResponse(
      (response) =>
        response.url() === `${BASE_URL}/api/transcriptions` && response.request().method() === 'POST',
    );

    await page.getByTestId(testIds.transcribeTitle).fill('One clip too many');
    await setControlValue(page, testIds.transcribeDuration, String(OVER_LIMIT_DURATION_SECONDS));
    await page.getByTestId(testIds.transcribeSubmit).click();

    const response = await attempt;
    expect(response.status(), 'the drained workspace must be over its limit').toBe(402);

    const error = (await response.json()) as ApiError;
    expect(error.code).toBe('QUOTA_EXHAUSTED');
    expect(error.quota, 'a 402 must carry the live quota snapshot so the SPA needs no second round trip').not.toBeNull();
    expect(
      error.upgrade_plan_code,
      'a finite plan always has a plan above it; null here means the upgrade ladder is broken',
    ).not.toBeNull();

    // What the visitor actually gets: a paywall naming the plan that fixes it, not an error toast.
    await expect(page.getByTestId(testIds.quotaExhausted)).toBeVisible();
    await expect(page.getByTestId(testIds.upgradePlanCode)).toHaveText(String(error.upgrade_plan_code));
    await expect(page.getByTestId(testIds.upgradeCta)).toBeVisible();
  });
});
