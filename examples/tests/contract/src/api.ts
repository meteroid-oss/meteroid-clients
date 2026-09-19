/**
 * One helper per operation in the contract, keyed by `operationId`.
 *
 * Keeping the keys equal to the contract's operation ids is what lets the harness
 * self-test assert that the suite covers every operation: `Object.keys(api)` is compared
 * against the operation ids in `examples/openapi.yaml`, and each helper name is looked
 * for in the test sources. Add an operation to the contract without testing it and the
 * suite fails instead of quietly ignoring it.
 */

import { request } from './http.js';
import type { RequestOptions, ScribeResponse } from './http.js';

export const api = {
  getHealth: (options: RequestOptions = {}): Promise<ScribeResponse> =>
    request('getHealth', options),

  createSession: (body?: unknown, options: RequestOptions = {}): Promise<ScribeResponse> =>
    request('createSession', { ...options, ...(body === undefined ? {} : { body }) }),

  getMe: (token: string | undefined, options: RequestOptions = {}): Promise<ScribeResponse> =>
    request('getMe', { token, ...options }),

  listPlans: (options: RequestOptions = {}): Promise<ScribeResponse> =>
    request('listPlans', options),

  createCheckout: (
    token: string | undefined,
    body: unknown,
    options: RequestOptions = {},
  ): Promise<ScribeResponse> => request('createCheckout', { token, body, ...options }),

  listEntitlements: (
    token: string | undefined,
    options: RequestOptions = {},
  ): Promise<ScribeResponse> => request('listEntitlements', { token, ...options }),

  listTranscriptions: (
    token: string | undefined,
    options: RequestOptions = {},
  ): Promise<ScribeResponse> => request('listTranscriptions', { token, ...options }),

  createTranscription: (
    token: string | undefined,
    body: unknown,
    options: RequestOptions = {},
  ): Promise<ScribeResponse> => request('createTranscription', { token, body, ...options }),

  getUsage: (token: string | undefined, options: RequestOptions = {}): Promise<ScribeResponse> =>
    request('getUsage', { token, ...options }),

  createPortalSession: (
    token: string | undefined,
    body?: unknown,
    options: RequestOptions = {},
  ): Promise<ScribeResponse> =>
    request('createPortalSession', { token, ...options, ...(body === undefined ? {} : { body }) }),

  listInvoices: (
    token: string | undefined,
    query: RequestOptions['query'] = {},
    options: RequestOptions = {},
  ): Promise<ScribeResponse> => request('listInvoices', { token, query, ...options }),

  /**
   * The webhook receiver takes the body as raw bytes: the Standard Webhooks signature
   * covers the exact payload, so anything that re-serializes it invalidates the
   * signature — which is the classic receiver bug this endpoint exists to demonstrate.
   */
  receiveMeteroidWebhook: (
    rawBody: string,
    headers: Record<string, string>,
    options: RequestOptions = {},
  ): Promise<ScribeResponse> =>
    request('receiveMeteroidWebhook', { rawBody, headers, ...options }),
};

export type ApiHelperName = keyof typeof api;
