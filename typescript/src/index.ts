// this file is @generated
import { AddOns } from "./api/addOns.js";
import { BatchJobs } from "./api/batchJobs.js";
import { CheckoutSessions } from "./api/checkoutSessions.js";
import { Connect } from "./api/connect.js";
import { Coupons } from "./api/coupons.js";
import { CreditNotes } from "./api/creditNotes.js";
import { CustomProperties } from "./api/customProperties.js";
import { Customers } from "./api/customers.js";
import { Events } from "./api/events.js";
import { Features } from "./api/features.js";
import { Invoices } from "./api/invoices.js";
import { Metrics } from "./api/metrics.js";
import { Oauth } from "./api/oauth.js";
import { OauthApps } from "./api/oauthApps.js";
import { Plans } from "./api/plans.js";
import { ProductFamilies } from "./api/productFamilies.js";
import { Products } from "./api/products.js";
import { Subscriptions } from "./api/subscriptions.js";
import { Usage } from "./api/usage.js";
import type { Security, SecurityScheme } from "./auth.js";
import type { Middleware } from "./middleware.js";
import { readEnv, type MeteroidRequestContext } from "./request.js";
import {
  MeteroidError,
  APIError,
  BadRequestError,
  AuthenticationError,
  PermissionDeniedError,
  NotFoundError,
  ConflictError,
  UnprocessableEntityError,
  RateLimitError,
  InternalServerError,
  APIConnectionError,
  APIConnectionTimeoutError,
  APIUserAbortError,
  APIDecodeError,
} from "./apiErrors.js";
import { RestErrorResponseSerializer } from "./models/restErrorResponse.js";

export {
  MeteroidError,
  APIError,
  BadRequestError,
  AuthenticationError,
  PermissionDeniedError,
  NotFoundError,
  ConflictError,
  UnprocessableEntityError,
  RateLimitError,
  InternalServerError,
  APIConnectionError,
  APIConnectionTimeoutError,
  APIUserAbortError,
  APIDecodeError,
} from "./apiErrors.js";
/** The error bodies the API declares, `APIError.error` once parsed. */
export type MeteroidErrorBody =
  | import("./models/oAuthErrorResponse.js").OAuthErrorResponse
  | import("./models/restErrorResponse.js").RestErrorResponse;
export type { Middleware } from "./middleware.js";
export { parseJson, stringifyJson } from "./json.js";
export { expandableId } from "./unions.js";
export { LIB_VERSION, type RequestOptions } from "./request.js";
export { APIPromise } from "./apiPromise.js";
export { Page, PagePromise } from "./pagination.js";
export { EventStream, Stream } from "./streaming.js";
export type { WithResponse } from "./apiPromise.js";
export * from "./webhook.js";
export * from "./models/index.js";
export type { SseEvent, Upload, UploadBody } from "./streaming.js";

export { AddOns } from "./api/addOns.js";
export type { AddOnsListOptions } from "./api/addOns.js";
export { BatchJobs } from "./api/batchJobs.js";
export type { BatchJobsListOptions } from "./api/batchJobs.js";
export type { BatchJobsListFailuresOptions } from "./api/batchJobs.js";
export { CheckoutSessions } from "./api/checkoutSessions.js";
export type { CheckoutSessionsListOptions } from "./api/checkoutSessions.js";
export { Connect } from "./api/connect.js";
export { Coupons } from "./api/coupons.js";
export type { CouponsListOptions } from "./api/coupons.js";
export { CreditNotes } from "./api/creditNotes.js";
export type { CreditNotesListOptions } from "./api/creditNotes.js";
export { CustomProperties } from "./api/customProperties.js";
export type { CustomPropertiesListCustomPropertyDefinitionsOptions } from "./api/customProperties.js";
export { Customers } from "./api/customers.js";
export type { CustomersListOptions } from "./api/customers.js";
export { Events } from "./api/events.js";
export { Features } from "./api/features.js";
export type { FeaturesListOptions } from "./api/features.js";
export { Invoices } from "./api/invoices.js";
export type { InvoicesListOptions } from "./api/invoices.js";
export { Metrics } from "./api/metrics.js";
export type { MetricsListOptions } from "./api/metrics.js";
export { Oauth } from "./api/oauth.js";
export { OauthApps } from "./api/oauthApps.js";
export { Plans } from "./api/plans.js";
export type { PlansListOptions } from "./api/plans.js";
export type { PlansRetrieveOptions } from "./api/plans.js";
export type { PlansListVersionsOptions } from "./api/plans.js";
export { ProductFamilies } from "./api/productFamilies.js";
export type { ProductFamiliesListOptions } from "./api/productFamilies.js";
export { Products } from "./api/products.js";
export type { ProductsListOptions } from "./api/products.js";
export { Subscriptions } from "./api/subscriptions.js";
export type { SubscriptionsListOptions } from "./api/subscriptions.js";
export { Usage } from "./api/usage.js";
export type { UsageRetrieveCustomerOptions } from "./api/usage.js";
export type { UsageRetrieveSubscriptionOptions } from "./api/usage.js";
export type { UsageRetrieveSummaryOptions } from "./api/usage.js";

export type MeteroidOptions = {
  /**
   * The API key or bearer token sent with every request. Defaults to the `METEROID_API_KEY` environment variable.
   */
  apiKey?: string | null | undefined;
  /**
   * The API server URL. Defaults to the `METEROID_BASE_URL` environment variable, then
   * `https://api.meteroid.com`.
   */
  baseURL?: string | null | undefined;
  /**
   * Time in milliseconds to wait for each attempt to get a response. Default:
   * 60000 (60 seconds); `Infinity` waits forever.
   */
  timeout?: number | undefined;
  /**
   * How many times a failed request is retried: connection errors, timeouts, 408, 429
   * and 5xx responses. Default: 2, or the length of `retryScheduleInMs`.
   */
  maxRetries?: number | undefined;
  /** Headers sent with every request; `null` removes a header the SDK sets. */
  defaultHeaders?: Record<string, string | null | undefined> | undefined;
  /** Query parameters sent with every request. */
  defaultQuery?: Record<string, string | undefined> | undefined;
  /** Custom fetch implementation, for tests or non-standard runtimes. */
  fetch?: typeof fetch | undefined;
  /** Wraps every HTTP attempt: caching, logging, custom headers. */
  middleware?: Middleware[] | undefined;
  /** Write a one-line summary of every request and response to stderr. */
  debug?: boolean | undefined;
  /** Delays in milliseconds before each retry, instead of the default backoff. */
  retryScheduleInMs?: number[] | undefined;
  /**
   * Called before each request for a fresh bearer token, e.g. an OAuth2 access
   * token. Takes precedence over `apiKey`.
   */
  tokenProvider?: (() => string | Promise<string>) | undefined;
};

const DEFAULT_BASE_URL = "https://api.meteroid.com";
const DEFAULT_TIMEOUT_MS = 60000;

const AUTH: { schemes: Record<string, SecurityScheme>; security: Security } = {
  schemes: {
    bearer_auth: { kind: "bearer" },
  },
  security: [["bearer_auth"]],
};

/**
 * Meteroid billing API client.
 *
 * @example
 * ```typescript
 * const meteroid = new Meteroid({ apiKey: "your-api-key" });
 *
 * // Access the generated resources through the client.
 * ```
 */
export class Meteroid {
  static readonly MeteroidError = MeteroidError;
  static readonly APIError = APIError;
  static readonly BadRequestError = BadRequestError;
  static readonly AuthenticationError = AuthenticationError;
  static readonly PermissionDeniedError = PermissionDeniedError;
  static readonly NotFoundError = NotFoundError;
  static readonly ConflictError = ConflictError;
  static readonly UnprocessableEntityError = UnprocessableEntityError;
  static readonly RateLimitError = RateLimitError;
  static readonly InternalServerError = InternalServerError;
  static readonly APIConnectionError = APIConnectionError;
  static readonly APIConnectionTimeoutError = APIConnectionTimeoutError;
  static readonly APIUserAbortError = APIUserAbortError;
  static readonly APIDecodeError = APIDecodeError;

  private readonly requestCtx: MeteroidRequestContext;
  private _addOns?: AddOns;
  private _batchJobs?: BatchJobs;
  private _checkoutSessions?: CheckoutSessions;
  private _connect?: Connect;
  private _coupons?: Coupons;
  private _creditNotes?: CreditNotes;
  private _customProperties?: CustomProperties;
  private _customers?: Customers;
  private _events?: Events;
  private _features?: Features;
  private _invoices?: Invoices;
  private _metrics?: Metrics;
  private _oauth?: Oauth;
  private _oauthApps?: OauthApps;
  private _plans?: Plans;
  private _productFamilies?: ProductFamilies;
  private _products?: Products;
  private _subscriptions?: Subscriptions;
  private _usage?: Usage;

  /**
   * Reads the API key from `METEROID_API_KEY` and the base URL from `METEROID_BASE_URL`
   * unless `options` sets them.
   */
  public constructor(options: MeteroidOptions = {}) {
    const token = options.apiKey ?? readEnv("METEROID_API_KEY");
    const baseUrl = options.baseURL ?? readEnv("METEROID_BASE_URL") ?? DEFAULT_BASE_URL;
    this.requestCtx = {
      auth: AUTH,
      token,
      tokenProvider: options.tokenProvider,

      baseUrl: baseUrl.replace(/\/+$/, ""),
      timeout: options.timeout ?? DEFAULT_TIMEOUT_MS,
      parseError: RestErrorResponseSerializer.parse,
      debug: options.debug,
      fetch: options.fetch,
      middleware: options.middleware,
      retryScheduleInMs: options.retryScheduleInMs,
      maxRetries: options.maxRetries,
      defaultHeaders: options.defaultHeaders,
      defaultQuery: options.defaultQuery,
    };
  }

  /** The add ons API. */
  public get addOns(): AddOns {
    this._addOns ??= new AddOns(this.requestCtx);
    return this._addOns;
  }

  /** The batch jobs API. */
  public get batchJobs(): BatchJobs {
    this._batchJobs ??= new BatchJobs(this.requestCtx);
    return this._batchJobs;
  }

  /** The checkout sessions API. */
  public get checkoutSessions(): CheckoutSessions {
    this._checkoutSessions ??= new CheckoutSessions(this.requestCtx);
    return this._checkoutSessions;
  }

  /** The connect API. */
  public get connect(): Connect {
    this._connect ??= new Connect(this.requestCtx);
    return this._connect;
  }

  /** The coupons API. */
  public get coupons(): Coupons {
    this._coupons ??= new Coupons(this.requestCtx);
    return this._coupons;
  }

  /** The credit notes API. */
  public get creditNotes(): CreditNotes {
    this._creditNotes ??= new CreditNotes(this.requestCtx);
    return this._creditNotes;
  }

  /** The custom properties API. */
  public get customProperties(): CustomProperties {
    this._customProperties ??= new CustomProperties(this.requestCtx);
    return this._customProperties;
  }

  /** The customers API. */
  public get customers(): Customers {
    this._customers ??= new Customers(this.requestCtx);
    return this._customers;
  }

  /** The events API. */
  public get events(): Events {
    this._events ??= new Events(this.requestCtx);
    return this._events;
  }

  /** The features API. */
  public get features(): Features {
    this._features ??= new Features(this.requestCtx);
    return this._features;
  }

  /** The invoices API. */
  public get invoices(): Invoices {
    this._invoices ??= new Invoices(this.requestCtx);
    return this._invoices;
  }

  /** The metrics API. */
  public get metrics(): Metrics {
    this._metrics ??= new Metrics(this.requestCtx);
    return this._metrics;
  }

  /** The oauth API. */
  public get oauth(): Oauth {
    this._oauth ??= new Oauth(this.requestCtx);
    return this._oauth;
  }

  /** The oauth apps API. */
  public get oauthApps(): OauthApps {
    this._oauthApps ??= new OauthApps(this.requestCtx);
    return this._oauthApps;
  }

  /** The plans API. */
  public get plans(): Plans {
    this._plans ??= new Plans(this.requestCtx);
    return this._plans;
  }

  /** The product families API. */
  public get productFamilies(): ProductFamilies {
    this._productFamilies ??= new ProductFamilies(this.requestCtx);
    return this._productFamilies;
  }

  /** The products API. */
  public get products(): Products {
    this._products ??= new Products(this.requestCtx);
    return this._products;
  }

  /** The subscriptions API. */
  public get subscriptions(): Subscriptions {
    this._subscriptions ??= new Subscriptions(this.requestCtx);
    return this._subscriptions;
  }

  /** The usage API. */
  public get usage(): Usage {
    this._usage ??= new Usage(this.requestCtx);
    return this._usage;
  }
}
