/**
 * `POST /api/portal-session` — the customer-portal hand-off.
 *
 * Meteroid documents the token lifetime as 60..2592000 but types the field as a plain
 * non-negative integer, so the range is the backend's job. The rejections below are the
 * point of this file: a backend that forwards `expires_in_seconds: 5` and lets Meteroid
 * refuse it turns a client mistake into an opaque upstream error.
 */

import { describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { sharedSession } from '../src/session.js';
import type { CreatePortalSessionResponse } from '../src/types.js';

const DEFAULT_LIFETIME = 86_400;

describe('POST /api/portal-session', () => {
  it('rejects an unauthenticated request', async () => {
    expectError(await api.createPortalSession(undefined), 401, 'UNAUTHORIZED');
  });

  it('mints a token with no request body at all', async () => {
    const session = await sharedSession();
    const portal = expectStatus<CreatePortalSessionResponse>(
      await api.createPortalSession(session.token),
      201,
    );

    expect(portal.token.length, 'the portal token is what the frontend opens the portal with')
      .toBeGreaterThan(0);
    expect(portal.expires_in_seconds, "Meteroid's documented default").toBe(DEFAULT_LIFETIME);

    const url = new URL(portal.portal_url);
    expect(['http:', 'https:']).toContain(url.protocol);
  });

  it('treats an empty object and an explicit null the same as no body', async () => {
    const session = await sharedSession();
    for (const body of [{}, { expires_in_seconds: null }]) {
      const portal = expectStatus<CreatePortalSessionResponse>(
        await api.createPortalSession(session.token, body),
        201,
      );
      expect(portal.expires_in_seconds).toBe(DEFAULT_LIFETIME);
    }
  });

  it('echoes the lifetime it asked Meteroid for', async () => {
    const session = await sharedSession();
    const portal = expectStatus<CreatePortalSessionResponse>(
      await api.createPortalSession(session.token, { expires_in_seconds: 3600 }),
      201,
    );
    // Meteroid returns only `{ token, portal_url }`, so this is the requested value
    // echoed back, not something read out of the token.
    expect(portal.expires_in_seconds).toBe(3600);
  });

  it('rejects a lifetime below the documented range', async () => {
    const session = await sharedSession();
    expectError(
      await api.createPortalSession(session.token, { expires_in_seconds: 59 }),
      400,
      'BAD_REQUEST',
    );
  });

  it('rejects a lifetime above the documented range', async () => {
    const session = await sharedSession();
    expectError(
      await api.createPortalSession(session.token, { expires_in_seconds: 2_592_001 }),
      400,
      'BAD_REQUEST',
    );
  });

  it('rejects an unknown property', async () => {
    const session = await sharedSession();
    expectError(
      await api.createPortalSession(session.token, { expires_in_hours: 1 }),
      400,
      'BAD_REQUEST',
    );
  });
});
