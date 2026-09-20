// this file is @generated
import { AddOns } from "./api/addOns";
import { BatchJobs } from "./api/batchJobs";
import { CheckoutSessions } from "./api/checkoutSessions";
import { Connect } from "./api/connect";
import { Coupons } from "./api/coupons";
import { CreditNotes } from "./api/creditNotes";
import { CustomProperties } from "./api/customProperties";
import { Customers } from "./api/customers";
import { Events } from "./api/events";
import { Features } from "./api/features";
import { Invoices } from "./api/invoices";
import { Metrics } from "./api/metrics";
import { OAuth } from "./api/oAuth";
import { OAuthApps } from "./api/oAuthApps";
import { Plans } from "./api/plans";
import { ProductFamilies } from "./api/productFamilies";
import { Products } from "./api/products";
import { Subscriptions } from "./api/subscriptions";
import { Usage } from "./api/usage";
import type { MeteroidRequestContext } from "./request";
import type { XOR } from "./util";

export { ApiException } from "./util";
export type { XOR } from "./util";
export * from "./webhook";
export * from "./models/index";
export { LIB_VERSION } from "./request";

export { AddOns } from "./api/addOns";
export type { AddOnsListAddonsOptions } from "./api/addOns";
export { BatchJobs } from "./api/batchJobs";
export type { BatchJobsListBatchJobsOptions } from "./api/batchJobs";
export type { BatchJobsListBatchJobFailuresOptions } from "./api/batchJobs";
export { CheckoutSessions } from "./api/checkoutSessions";
export type { CheckoutSessionsListCheckoutSessionsOptions } from "./api/checkoutSessions";
export { Connect } from "./api/connect";
export { Coupons } from "./api/coupons";
export type { CouponsListCouponsOptions } from "./api/coupons";
export { CreditNotes } from "./api/creditNotes";
export type { CreditNotesListCreditNotesOptions } from "./api/creditNotes";
export { CustomProperties } from "./api/customProperties";
export type { CustomPropertiesListDefinitionsOptions } from "./api/customProperties";
export { Customers } from "./api/customers";
export type { CustomersListCustomersOptions } from "./api/customers";
export { Events } from "./api/events";
export { Features } from "./api/features";
export type { FeaturesListFeaturesOptions } from "./api/features";
export { Invoices } from "./api/invoices";
export type { InvoicesListInvoicesOptions } from "./api/invoices";
export { Metrics } from "./api/metrics";
export type { MetricsListMetricsOptions } from "./api/metrics";
export { OAuth } from "./api/oAuth";
export { OAuthApps } from "./api/oAuthApps";
export { Plans } from "./api/plans";
export type { PlansListPlansOptions } from "./api/plans";
export type { PlansGetPlanDetailsOptions } from "./api/plans";
export type { PlansListPlanVersionsOptions } from "./api/plans";
export { ProductFamilies } from "./api/productFamilies";
export type { ProductFamiliesListProductFamiliesOptions } from "./api/productFamilies";
export { Products } from "./api/products";
export type { ProductsListProductsOptions } from "./api/products";
export { Subscriptions } from "./api/subscriptions";
export type { SubscriptionsListSubscriptionsOptions } from "./api/subscriptions";
export { Usage } from "./api/usage";
export type { UsageGetCustomerUsageOptions } from "./api/usage";
export type { UsageGetSubscriptionUsageOptions } from "./api/usage";
export type { UsageGetUsageSummaryOptions } from "./api/usage";

export type MeteroidOptions = {
  /** Write a one-line summary of every request and response to stderr. */
  debug?: boolean;
  /** Custom API server URL. Defaults to `https://api.meteroid.com`. */
  serverUrl?: string;
  /** Time in milliseconds to wait for requests to get a response. */
  requestTimeout?: number;
  /**
   * Custom fetch implementation to use for HTTP requests.
   * Useful for testing, adding custom middleware, or running in non-standard environments.
   */
  fetch?: typeof fetch;
} & XOR<
  {
    /** List of delays (in milliseconds) to wait before each retry attempt. */
    retryScheduleInMs?: number[];
  },
  {
    /**
     * The number of times the client will retry if a server-side error
     * or timeout is received.
     * Default: 2
     */
    numRetries?: number;
  }
>;

const DEFAULT_BASE_URL = "https://api.meteroid.com";

/**
 * Meteroid API client for billing and subscription management.
 *
 * @example
 * ```typescript
 * const meteroid = new Meteroid("your-api-key");
 *
 * // Create a customer
 * const customer = await meteroid.customers.createCustomer({
 *   name: "Acme Inc",
 *   billingEmail: "billing@acme.com",
 * });
 * ```
 */
export class Meteroid {
  private readonly requestCtx: MeteroidRequestContext;

  /**
   * Create a new Meteroid client.
   *
   * @param token API token for authentication
   * @param options Client configuration options
   */
  public constructor(token: string, options: MeteroidOptions = {}) {
    const baseUrl: string = options.serverUrl ?? DEFAULT_BASE_URL;

    if (options.retryScheduleInMs != null) {
      this.requestCtx = {
        baseUrl,
        token,
        timeout: options.requestTimeout,
        retryScheduleInMs: options.retryScheduleInMs,
        debug: options.debug,
        fetch: options.fetch,
      };
      return;
    }

    if (options.numRetries != null) {
      this.requestCtx = {
        baseUrl,
        token,
        timeout: options.requestTimeout,
        numRetries: options.numRetries,
        debug: options.debug,
        fetch: options.fetch,
      };
      return;
    }

    this.requestCtx = {
      baseUrl,
      token,
      timeout: options.requestTimeout,
      debug: options.debug,
      fetch: options.fetch,
    };
  }

  /** Access the add ons API. */
  public get addOns(): AddOns {
    return new AddOns(this.requestCtx);
  }

  /** Access the batch jobs API. */
  public get batchJobs(): BatchJobs {
    return new BatchJobs(this.requestCtx);
  }

  /** Access the checkout sessions API. */
  public get checkoutSessions(): CheckoutSessions {
    return new CheckoutSessions(this.requestCtx);
  }

  /** Access the connect API. */
  public get connect(): Connect {
    return new Connect(this.requestCtx);
  }

  /** Access the coupons API. */
  public get coupons(): Coupons {
    return new Coupons(this.requestCtx);
  }

  /** Access the credit notes API. */
  public get creditNotes(): CreditNotes {
    return new CreditNotes(this.requestCtx);
  }

  /** Access the custom properties API. */
  public get customProperties(): CustomProperties {
    return new CustomProperties(this.requestCtx);
  }

  /** Access the customers API. */
  public get customers(): Customers {
    return new Customers(this.requestCtx);
  }

  /** Access the events API. */
  public get events(): Events {
    return new Events(this.requestCtx);
  }

  /** Access the features API. */
  public get features(): Features {
    return new Features(this.requestCtx);
  }

  /** Access the invoices API. */
  public get invoices(): Invoices {
    return new Invoices(this.requestCtx);
  }

  /** Access the metrics API. */
  public get metrics(): Metrics {
    return new Metrics(this.requestCtx);
  }

  /** Access the o auth API. */
  public get oAuth(): OAuth {
    return new OAuth(this.requestCtx);
  }

  /** Access the o auth apps API. */
  public get oAuthApps(): OAuthApps {
    return new OAuthApps(this.requestCtx);
  }

  /** Access the plans API. */
  public get plans(): Plans {
    return new Plans(this.requestCtx);
  }

  /** Access the product families API. */
  public get productFamilies(): ProductFamilies {
    return new ProductFamilies(this.requestCtx);
  }

  /** Access the products API. */
  public get products(): Products {
    return new Products(this.requestCtx);
  }

  /** Access the subscriptions API. */
  public get subscriptions(): Subscriptions {
    return new Subscriptions(this.requestCtx);
  }

  /** Access the usage API. */
  public get usage(): Usage {
    return new Usage(this.requestCtx);
  }
}
