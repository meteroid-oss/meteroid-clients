// this file is @generated
import {
  type CancelSubscriptionRequest,
  CancelSubscriptionRequestSerializer,
} from "../models/cancelSubscriptionRequest";
import {
  type CancelSubscriptionResponse,
  CancelSubscriptionResponseSerializer,
} from "../models/cancelSubscriptionResponse";
import {
  type EffectiveEntitlementListResponse,
  EffectiveEntitlementListResponseSerializer,
} from "../models/effectiveEntitlementListResponse";
import type { PlanId } from "../models/planId";
import {
  type SubscriptionCreateRequest,
  SubscriptionCreateRequestSerializer,
} from "../models/subscriptionCreateRequest";
import {
  type SubscriptionDetails,
  SubscriptionDetailsSerializer,
} from "../models/subscriptionDetails";
import {
  type SubscriptionListResponse,
  SubscriptionListResponseSerializer,
} from "../models/subscriptionListResponse";
import type { SubscriptionStatusEnum } from "../models/subscriptionStatusEnum";
import {
  type SubscriptionUpdateRequest,
  SubscriptionUpdateRequestSerializer,
} from "../models/subscriptionUpdateRequest";
import {
  type SubscriptionUpdateResponse,
  SubscriptionUpdateResponseSerializer,
} from "../models/subscriptionUpdateResponse";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface SubscriptionsListSubscriptionsOptions {
  /** Filter by customer ID or alias */
  customerId?: string;
  planId?: PlanId;
  statuses?: SubscriptionStatusEnum[];
  /** Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`, `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`. */
  orderBy?: string;
  /** Page number (0-indexed) */
  page?: number;
  /** Number of items per page */
  perPage?: number;
}

export class Subscriptions {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List subscriptions with optional filtering by customer or plan. */
  public listSubscriptions(
    options?: SubscriptionsListSubscriptionsOptions
  ): Promise<SubscriptionListResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/subscriptions");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("plan_id", options?.planId);
    request.setExplodedQueryParam("statuses", options?.statuses);
    request.setQueryParam("order_by", options?.orderBy);
    request.setQueryParam("page", options?.page);
    request.setQueryParam("per_page", options?.perPage);
    return request.send(
      this.requestCtx,
      SubscriptionListResponseSerializer._fromJsonObject
    );
  }

  /** Create a new subscription for a customer with a specific plan. */
  public createSubscription(
    subscriptionCreateRequest: SubscriptionCreateRequest
  ): Promise<SubscriptionDetails> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/subscriptions");

    request.setBody(
      SubscriptionCreateRequestSerializer._toJsonObject(subscriptionCreateRequest)
    );
    return request.send(this.requestCtx, SubscriptionDetailsSerializer._fromJsonObject);
  }

  /** Retrieve detailed information about a subscription including price components and schedules. */
  public subscriptionDetails(subscriptionId: string): Promise<SubscriptionDetails> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/subscriptions/{subscription_id}"
    );

    request.setPathParam("subscription_id", subscriptionId);
    return request.send(this.requestCtx, SubscriptionDetailsSerializer._fromJsonObject);
  }

  /** Update subscription settings like payment configuration, billing options, etc. */
  public updateSubscription(
    subscriptionId: string,
    subscriptionUpdateRequest: SubscriptionUpdateRequest
  ): Promise<SubscriptionUpdateResponse> {
    const request = new MeteroidRequest(
      HttpMethod.PATCH,
      "/api/v1/subscriptions/{subscription_id}"
    );

    request.setPathParam("subscription_id", subscriptionId);
    request.setBody(
      SubscriptionUpdateRequestSerializer._toJsonObject(subscriptionUpdateRequest)
    );
    return request.send(
      this.requestCtx,
      SubscriptionUpdateResponseSerializer._fromJsonObject
    );
  }

  /** Cancel a subscription either immediately or at the end of the billing period. */
  public cancelSubscription(
    subscriptionId: string,
    cancelSubscriptionRequest: CancelSubscriptionRequest
  ): Promise<CancelSubscriptionResponse> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/subscriptions/{subscription_id}/cancel"
    );

    request.setPathParam("subscription_id", subscriptionId);
    request.setBody(
      CancelSubscriptionRequestSerializer._toJsonObject(cancelSubscriptionRequest)
    );
    return request.send(
      this.requestCtx,
      CancelSubscriptionResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public listSubscriptionEntitlements(
    subscriptionId: string
  ): Promise<EffectiveEntitlementListResponse> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/subscriptions/{subscription_id}/entitlements"
    );

    request.setPathParam("subscription_id", subscriptionId);
    return request.send(
      this.requestCtx,
      EffectiveEntitlementListResponseSerializer._fromJsonObject
    );
  }
}
