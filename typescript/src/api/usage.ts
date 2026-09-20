// this file is @generated
import type { BillableMetricId } from "../models/billableMetricId";
import { type UsageResponse, UsageResponseSerializer } from "../models/usageResponse";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface UsageGetCustomerUsageOptions {
  startDate: string;
  endDate: string;
  metricId?: BillableMetricId;
}

export interface UsageGetSubscriptionUsageOptions {
  startDate?: string;
  endDate?: string;
  metricId?: BillableMetricId;
}

export interface UsageGetUsageSummaryOptions {
  startDate: string;
  endDate: string;
  metricId?: BillableMetricId;
}

export class Usage {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** Retrieve aggregated usage data for a customer over a specified period. */
  public getCustomerUsage(
    customerId: string,
    options: UsageGetCustomerUsageOptions
  ): Promise<UsageResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/usage/customer/{customer_id}"
    );

    request.setPathParam("customer_id", customerId);
    request.setQueryParam("start_date", options.startDate);
    request.setQueryParam("end_date", options.endDate);
    request.setQueryParam("metric_id", options?.metricId);
    return request.send(this.requestCtx, UsageResponseSerializer._fromJsonObject);
  }

  /**
   * Retrieve aggregated usage data for a subscription's usage-based components.
   * If start_date/end_date are omitted, defaults to the current billing period.
   */
  public getSubscriptionUsage(
    subscriptionId: string,
    options?: UsageGetSubscriptionUsageOptions
  ): Promise<UsageResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/usage/subscription/{subscription_id}"
    );

    request.setPathParam("subscription_id", subscriptionId);
    request.setQueryParam("start_date", options?.startDate);
    request.setQueryParam("end_date", options?.endDate);
    request.setQueryParam("metric_id", options?.metricId);
    return request.send(this.requestCtx, UsageResponseSerializer._fromJsonObject);
  }

  /** Retrieve aggregated usage data across all customers for the tenant. */
  public getUsageSummary(options: UsageGetUsageSummaryOptions): Promise<UsageResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/usage/summary");

    request.setQueryParam("start_date", options.startDate);
    request.setQueryParam("end_date", options.endDate);
    request.setQueryParam("metric_id", options?.metricId);
    return request.send(this.requestCtx, UsageResponseSerializer._fromJsonObject);
  }
}
