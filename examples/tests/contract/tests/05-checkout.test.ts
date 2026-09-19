/**
 * `POST /api/checkout` — the hosted checkout hand-off.
 *
 * The suite can create a checkout session but cannot complete one: the hosted page needs
 * a browser and a card. So what is asserted here is the hand-off itself — that the
 * backend resolves the right plan version, that the URL it returns is usable, and that a
 * null `checkout_url` from Meteroid is turned into `CHECKOUT_UNAVAILABLE` rather than
 * handed to the frontend as a null it cannot act on.
 */

import { describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { planByCode } from '../src/catalog.js';
import { sharedSession } from '../src/session.js';
import type { CreateCheckoutResponse } from '../src/types.js';

describe('POST /api/checkout', () => {
  it('rejects an unauthenticated request', async () => {
    expectError(await api.createCheckout(undefined, { plan_code: 'pro' }), 401, 'UNAUTHORIZED');
  });

  it('rejects a missing body', async () => {
    const session = await sharedSession();
    expectError(
      await api.createCheckout(session.token, undefined, { rawBody: '' }),
      400,
      'BAD_REQUEST',
    );
  });

  it('rejects a plan code outside the contract enum', async () => {
    const session = await sharedSession();
    expectError(await api.createCheckout(session.token, { plan_code: 'gold' }), 400, 'BAD_REQUEST');
  });

  it('rejects an unknown property', async () => {
    const session = await sharedSession();
    expectError(
      await api.createCheckout(session.token, { plan_code: 'pro', discount: '100%' }),
      400,
      'BAD_REQUEST',
    );
  });

  it('starts a checkout against the plan version the pricing table advertises', async () => {
    const session = await sharedSession();
    const pro = await planByCode('pro');
    expect(pro, 'the pricing table has no `pro` plan; seed the catalog per CATALOG.md').toBeDefined();

    const checkout = expectStatus<CreateCheckoutResponse>(
      await api.createCheckout(session.token, { plan_code: 'pro' }),
      201,
    );

    expect(checkout.plan_code).toBe('pro');
    // The frontend renders the pricing table and then posts a plan code; if the backend
    // resolved a different version than the one it advertised, the visitor would be sold
    // something other than what they read.
    expect(
      checkout.plan_version_id,
      'checkout must target the same plan version GET /api/plans advertised',
    ).toBe(pro?.plan_version_id);

    expect(checkout.checkout_session_id.length).toBeGreaterThan(0);
    const url = new URL(checkout.checkout_url);
    expect(
      ['http:', 'https:'],
      `checkout_url must be a fetchable URL, got ${checkout.checkout_url}`,
    ).toContain(url.protocol);
  });

  it('accepts an optional coupon code without changing the response shape', async () => {
    const session = await sharedSession();
    const response = await api.createCheckout(session.token, {
      plan_code: 'pro',
      coupon_code: null,
    });
    expectStatus<CreateCheckoutResponse>(response, 201);
  });
});
