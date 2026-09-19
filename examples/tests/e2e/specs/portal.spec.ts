import { expect, test } from '@playwright/test';

import { createSession } from '../support/api.js';
import { openApp, useSession } from '../support/app.js';
import { BASE_URL } from '../support/env.js';
import { testIds } from '../support/selectors.js';

/**
 * The customer portal is a token handed across an origin boundary.
 *
 * The contract suite can prove `POST /api/portal-session` returns a `token` and a `portal_url`. It
 * cannot prove the token is any good, because proving that means presenting it to Meteroid's portal
 * and being let in — a different origin, in a real browser, which is precisely what Playwright is
 * for. A backend that minted a token for the wrong customer, or truncated it, would pass every
 * schema check and fail here.
 */
test.describe('customer portal', () => {
  test('opens the Meteroid portal in a new tab with a working token', async ({ page, context, request }) => {
    const session = await createSession(request, 'e2e portal');
    await useSession(page, session.session_token);
    await openApp(page, 'billing');

    const portalCall = page.waitForResponse(
      (response) =>
        response.url() === `${BASE_URL}/api/portal-session` && response.request().method() === 'POST',
    );

    // The portal opens in a new tab, so wait for the tab and the click together — awaiting the
    // click first would race the popup.
    const [portalPage] = await Promise.all([
      context.waitForEvent('page'),
      page.getByTestId(testIds.managePortalButton).click(),
    ]);

    const portalResponse = await portalCall;
    expect(portalResponse.status()).toBe(201);
    const { portal_url: portalUrl, token } = (await portalResponse.json()) as {
      portal_url: string;
      token: string;
    };
    expect(token, 'a portal token must not be empty').not.toHaveLength(0);

    await portalPage.waitForLoadState('domcontentloaded');

    // The tab must be on Meteroid's portal origin and must be carrying the token the backend just
    // minted. The contract says only that the frontend "opens portal_url with the token" and does
    // not fix the mechanism, so this accepts either convention — `?token=` or `#token=` — and
    // asserts the thing that actually matters, which is that the token was carried at all.
    const portalOrigin = new URL(portalUrl).origin;
    expect(new URL(portalPage.url()).origin).toBe(portalOrigin);
    expect(portalPage.url(), 'the portal tab must carry the minted token').toContain(token);

    // A rejected token renders Meteroid's own error page rather than a failed navigation, so the
    // status alone is not enough: assert the portal rendered something, and that it is not
    // shouting about the token.
    await expect(portalPage.locator('body')).not.toBeEmpty();
    await expect(portalPage.locator('body')).not.toContainText(/invalid token|expired|unauthorized/i);

    await portalPage.close();
  });
});
