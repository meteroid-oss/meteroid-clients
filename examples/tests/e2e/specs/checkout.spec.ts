import { expect, test, type Response } from '@playwright/test';

import { createSession } from '../support/api.js';
import { openApp, useSession } from '../support/app.js';
import { BASE_URL, CHECKOUT_PLAN_CODE, FRONTEND_URL } from '../support/env.js';
import { testIds } from '../support/selectors.js';

/**
 * Checkout is a *redirect*, and a redirect is the one thing an HTTP test cannot check.
 *
 * The contract suite already proves `POST /api/checkout` returns a well-formed 201 with a
 * `checkout_url`. What it cannot prove is that the browser then goes there — that the SPA reads the
 * field it was given, actually navigates, and survives coming back. That round trip is this test.
 *
 * What this test deliberately does NOT do is complete the payment. The hosted checkout is Meteroid's
 * page, on Meteroid's domain, with a payment form on it; driving it would make this suite fail every
 * time someone else redesigned a form we do not own. The outbound leg and the return leg are ours.
 * The middle is theirs.
 */
test.describe('checkout redirect', () => {
  test('leaves the SPA for the hosted Meteroid checkout and comes back', async ({ page, request }) => {
    const session = await createSession(request, 'e2e checkout');
    await useSession(page, session.session_token);

    // Registered before the click so no redirect in the chain can be missed.
    const documentResponses: Response[] = [];
    page.on('response', (response) => {
      if (response.request().resourceType() === 'document') documentResponses.push(response);
    });

    await openApp(page, 'plans');
    await expect(page.getByTestId(testIds.pricingTable)).toBeVisible();

    const checkoutCall = page.waitForResponse(
      (response) =>
        response.url() === `${BASE_URL}/api/checkout` && response.request().method() === 'POST',
    );
    await page.getByTestId(testIds.checkoutButton(CHECKOUT_PLAN_CODE)).click();

    const checkoutResponse = await checkoutCall;
    expect(
      checkoutResponse.status(),
      'the backend must mint a checkout session; 503 here means the catalog is not seeded',
    ).toBe(201);

    const { checkout_url: checkoutUrl, plan_code: planCode } = (await checkoutResponse.json()) as {
      checkout_url: string;
      plan_code: string;
    };
    expect(planCode).toBe(CHECKOUT_PLAN_CODE);

    // The assertion that matters: the browser ends up where the backend said, on Meteroid's origin
    // and off ours. Compared by origin rather than by exact URL because a hosted checkout is
    // entitled to bounce through its own routes and add its own query parameters on the way in.
    const checkoutOrigin = new URL(checkoutUrl).origin;
    expect(checkoutOrigin, 'checkout must be hosted off the SPA origin').not.toBe(FRONTEND_URL);

    await page.waitForURL((url) => url.origin === checkoutOrigin);

    // ...and Meteroid actually served a page there, rather than a 404 for a stale session.
    const servedCheckout = documentResponses.filter(
      (response) => new URL(response.url()).origin === checkoutOrigin,
    );
    expect(servedCheckout.length, `no document was served from ${checkoutOrigin}`).toBeGreaterThan(0);
    for (const response of servedCheckout) {
      expect(response.status(), `hosted checkout returned ${response.status()} for ${response.url()}`).toBeLessThan(400);
    }

    // The return leg. A visitor who changes their mind must land back in a working app, not a
    // blank screen — the SPA has to survive being navigated away from and back.
    await page.goBack();
    await expect(page.getByTestId(testIds.pricingTable)).toBeVisible();
  });
});
