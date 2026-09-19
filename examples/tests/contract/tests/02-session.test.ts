/**
 * `POST /api/session` and `GET /api/me` — the workspace lifecycle.
 *
 * Two things get pinned down here that everything downstream depends on: that the
 * optional-request-body rule really is "no body == empty body == `{}`", and that a
 * workspace which has never checked out reports `subscription: null` and `plan: null`
 * rather than inventing something.
 */

import { beforeAll, describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { createSession, sharedSession } from '../src/session.js';
import type { SessionHandle } from '../src/session.js';
import type { CreateSessionResponse, MeResponse } from '../src/types.js';

describe('POST /api/session', () => {
  it('creates a workspace with no request body at all', async () => {
    const created = expectStatus<CreateSessionResponse>(await api.createSession(), 201);
    expect(created.session_token.length).toBeGreaterThan(0);
    expect(created.workspace.customer_alias.length).toBeGreaterThan(0);
  });

  it('treats an empty object the same as no body', async () => {
    expectStatus<CreateSessionResponse>(await api.createSession({}), 201);
  });

  it('treats explicit nulls the same as no body', async () => {
    expectStatus<CreateSessionResponse>(
      await api.createSession({ workspace_name: null, email: null }),
      201,
    );
  });

  it('uses the supplied name and reports the Meteroid customer it created', async () => {
    const name = `Scribe contract suite ${Date.now()}`;
    const created = expectStatus<CreateSessionResponse>(
      await api.createSession({ workspace_name: name, email: 'contract-suite@example.com' }),
      201,
    );

    expect(created.workspace.name).toBe(name);
    // The contract says the workspace id *is* the customer alias; the demo ingests usage
    // events against that alias rather than the Meteroid id, which is the point it makes.
    expect(created.workspace.id).toBe(created.workspace.customer_alias);
    expect(created.workspace.customer_id.length).toBeGreaterThan(0);
  });

  it('gives every session its own workspace', async () => {
    const first = await createSession();
    const second = await createSession();
    expect(first.workspace.customer_alias).not.toBe(second.workspace.customer_alias);
    expect(first.token).not.toBe(second.token);
  });

  it('rejects a malformed body', async () => {
    expectError(await api.createSession({ workspace_name: 123 }), 400, 'BAD_REQUEST');
  });

  it('rejects an unknown property', async () => {
    // Every request schema in the contract sets `additionalProperties: false`. A backend
    // that silently drops unknown keys will accept a typo'd field forever.
    expectError(await api.createSession({ workspace_nmae: 'typo' }), 400, 'BAD_REQUEST');
  });

  it('rejects a body that is not JSON', async () => {
    expectError(await api.createSession(undefined, { rawBody: '{not json' }), 400, 'BAD_REQUEST');
  });
});

describe('GET /api/me', () => {
  let session: SessionHandle;

  beforeAll(async () => {
    session = await sharedSession();
  });

  it('rejects a request with no Authorization header', async () => {
    expectError(await api.getMe(undefined), 401, 'UNAUTHORIZED');
  });

  it('rejects a token this deployment did not sign', async () => {
    expectError(await api.getMe('v1.YWxpY2U.bm90LWEtc2lnbmF0dXJl'), 401, 'UNAUTHORIZED');
  });

  it('rejects a structurally invalid token', async () => {
    expectError(await api.getMe('not-a-token'), 401, 'UNAUTHORIZED');
  });

  it('rejects an Authorization header that is not a bearer token', async () => {
    expectError(
      await api.getMe(undefined, { rawAuthorization: 'Basic c2NyaWJlOnNjcmliZQ==' }),
      401,
      'UNAUTHORIZED',
    );
  });

  it('returns the workspace the token is bound to', async () => {
    const me = expectStatus<MeResponse>(await api.getMe(session.token), 200);
    expect(me.workspace.customer_alias).toBe(session.workspace.customer_alias);
    expect(me.workspace.customer_id).toBe(session.workspace.customer_id);
  });

  it('reports a never-subscribed workspace as having no subscription and no plan', async () => {
    // The suite creates this workspace itself and cannot complete a hosted checkout, so
    // it is definitively unsubscribed — which makes this a deterministic assertion rather
    // than a hopeful one.
    const me = expectStatus<MeResponse>(await api.getMe(session.token), 200);
    expect(me.subscription).toBeNull();
    expect(
      me.plan,
      'plan must be null whenever subscription is null — the contract ties them together.',
    ).toBeNull();
  });
});
