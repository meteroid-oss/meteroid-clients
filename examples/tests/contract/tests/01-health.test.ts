/**
 * `GET /api/health` and the shape of a route that does not exist.
 *
 * Health runs first because a misconfigured run should fail here, with a sentence an
 * operator can act on, instead of thirty Meteroid-shaped 502s further down.
 */

import { beforeAll, describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectErrorEnvelope, expectStatus } from '../src/assert.js';
import { BASE_URL, EXPECT_BACKEND } from '../src/env.js';
import { rawRequest } from '../src/http.js';
import type { Health } from '../src/types.js';

describe('GET /api/health', () => {
  let health: Health;

  beforeAll(async () => {
    health = expectStatus<Health>(await api.getHealth(), 200);
  });

  it('reports which backend is answering', () => {
    expect(['rust', 'java', 'typescript', 'python', 'go']).toContain(health.backend);
    expect(health.status).toBe('ok');
    console.info(
      `  → ${BASE_URL} is the ${health.backend} backend` +
        `${health.version ? ` (version ${health.version})` : ''}`,
    );
  });

  it('is the backend this run expected', () => {
    if (!EXPECT_BACKEND) return; // Opt-in guard; unset means "whatever is listening".
    expect(
      health.backend,
      `SCRIBE_EXPECT_BACKEND=${EXPECT_BACKEND} but ${BASE_URL} is the ${health.backend} backend. ` +
        `Check the port: 8080 rust, 8081 java, 8082 typescript, 8083 python, 8084 go.`,
    ).toBe(EXPECT_BACKEND);
  });

  it('is configured to talk to Meteroid', () => {
    expect(
      health.meteroid_configured,
      `${BASE_URL} has no Meteroid credentials, so every Meteroid-backed operation in this ` +
        `suite will fail with UPSTREAM_UNAUTHORIZED. Set METEROID_API_KEY (and ` +
        `METEROID_BASE_URL) in the backend's environment and restart it.`,
    ).toBe(true);
  });

  it('needs no session token', async () => {
    // `security: []` on this operation — a liveness probe that required auth would be
    // useless to a load balancer.
    expectStatus<Health>(await api.getHealth({ token: undefined }), 200);
  });
});

describe('an unmatched route', () => {
  it('answers 404 in the shared error envelope', async () => {
    // The contract reserves NOT_FOUND for exactly this: no operation takes a path
    // parameter, so a 404 can only come from a typo — and it still has to arrive as an
    // Error object rather than as a framework's HTML page.
    const response = await rawRequest('GET', '/api/definitely-not-an-endpoint');
    expectErrorEnvelope(response, 404, 'NOT_FOUND');
  });
});
