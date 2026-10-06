// this file is @generated

import {
  type CancelSubscriptionRequest,
  CancelSubscriptionRequestSerializer,
} from "../models/cancelSubscriptionRequest.js";
import {
  type CancelSubscriptionResponse,
  CancelSubscriptionResponseSerializer,
} from "../models/cancelSubscriptionResponse.js";
import {
  type EffectiveEntitlementListResponse,
  EffectiveEntitlementListResponseSerializer,
} from "../models/effectiveEntitlementListResponse.js";
import type { PlanId } from "../models/planId.js";
import { type Subscription, SubscriptionSerializer } from "../models/subscription.js";
import {
  type SubscriptionCreateRequest,
  SubscriptionCreateRequestSerializer,
} from "../models/subscriptionCreateRequest.js";
import {
  type SubscriptionDetails,
  SubscriptionDetailsSerializer,
} from "../models/subscriptionDetails.js";
import {
  type SubscriptionListResponse,
  SubscriptionListResponseSerializer,
} from "../models/subscriptionListResponse.js";
import type { SubscriptionStatusEnum } from "../models/subscriptionStatusEnum.js";
import {
  type SubscriptionUpdateRequest,
  SubscriptionUpdateRequestSerializer,
} from "../models/subscriptionUpdateRequest.js";
import {
  type SubscriptionUpdateResponse,
  SubscriptionUpdateResponseSerializer,
} from "../models/subscriptionUpdateResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface SubscriptionsListOptions {
  /** Filter by customer ID or alias */
  customerId?: string | undefined;
  planId?: PlanId | undefined;
  statuses?: SubscriptionStatusEnum[] | undefined;
  /** Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`, `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string | undefined;
  /** Page number (0-indexed) */
  page?: number | undefined;
  /** Number of items per page */
  perPage?: number | undefined;
}

/** The subscriptions operations, reached through the client's `subscriptions`. */
export class Subscriptions {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List subscriptions with optional filtering by customer or plan. */
  public list(
    options?: SubscriptionsListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<SubscriptionListResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/subscriptions");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("plan_id", options?.planId);
    request.setExplodedQueryParam("statuses", options?.statuses);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      SubscriptionListResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Create subscription
   *
   * Create a new subscription for a customer with a specific plan.
   */
  public create(
    subscriptionCreateRequest: SubscriptionCreateRequest,
    requestOptions?: RequestOptions
  ): APIPromise<SubscriptionDetails> {
    const request = new MeteroidRequest("POST", "/api/v1/subscriptions");

    request.setBody(
      SubscriptionCreateRequestSerializer.serialize(subscriptionCreateRequest)
    );
    return request.send(
      this.requestCtx,
      SubscriptionDetailsSerializer.parse,
      requestOptions
    );
  }

  /**
   * Get subscription details
   *
   * Retrieve detailed information about a subscription including price components and schedules.
   */
  public retrieve(
    subscriptionId: string,
    requestOptions?: RequestOptions
  ): APIPromise<SubscriptionDetails> {
    const request = new MeteroidRequest("GET", "/api/v1/subscriptions/{subscription_id}");

    request.setPathParam("subscription_id", subscriptionId);
    return request.send(
      this.requestCtx,
      SubscriptionDetailsSerializer.parse,
      requestOptions
    );
  }

  /** Update subscription settings like payment configuration, billing options, etc. */
  public update(
    subscriptionId: string,
    subscriptionUpdateRequest: SubscriptionUpdateRequest,
    requestOptions?: RequestOptions
  ): APIPromise<SubscriptionUpdateResponse> {
    const request = new MeteroidRequest(
      "PATCH",
      "/api/v1/subscriptions/{subscription_id}"
    );

    request.setPathParam("subscription_id", subscriptionId);
    request.setBody(
      SubscriptionUpdateRequestSerializer.serialize(subscriptionUpdateRequest)
    );
    return request.send(
      this.requestCtx,
      SubscriptionUpdateResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Cancel subscription
   *
   * Cancel a subscription either immediately or at the end of the billing period.
   */
  public cancel(
    subscriptionId: string,
    cancelSubscriptionRequest: CancelSubscriptionRequest,
    requestOptions?: RequestOptions
  ): APIPromise<CancelSubscriptionResponse> {
    const request = new MeteroidRequest(
      "POST",
      "/api/v1/subscriptions/{subscription_id}/cancel"
    );

    request.setPathParam("subscription_id", subscriptionId);
    request.setBody(
      CancelSubscriptionRequestSerializer.serialize(cancelSubscriptionRequest)
    );
    return request.send(
      this.requestCtx,
      CancelSubscriptionResponseSerializer.parse,
      requestOptions
    );
  }

  /** List subscription entitlements */
  public listEntitlements(
    subscriptionId: string,
    requestOptions?: RequestOptions
  ): APIPromise<EffectiveEntitlementListResponse> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/subscriptions/{subscription_id}/entitlements"
    );

    request.setPathParam("subscription_id", subscriptionId);
    return request.send(
      this.requestCtx,
      EffectiveEntitlementListResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Get subscription summary
   *
   * Retrieve a subscription without its components, add-ons, coupons and entitlements: the same
   * shape as list items, for callers that only need status and billing dates.
   */
  public retrieveSummary(
    subscriptionId: string,
    requestOptions?: RequestOptions
  ): APIPromise<Subscription> {
    const request = new MeteroidRequest(
      "GET",
      "/api/v1/subscriptions/{subscription_id}/summary"
    );

    request.setPathParam("subscription_id", subscriptionId);
    return request.send(this.requestCtx, SubscriptionSerializer.parse, requestOptions);
  }
}
