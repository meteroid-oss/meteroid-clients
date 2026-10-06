// this file is @generated

import {
  type CancelCheckoutSessionResponse,
  CancelCheckoutSessionResponseSerializer,
} from "../models/cancelCheckoutSessionResponse.js";
import type { CheckoutSessionStatus } from "../models/checkoutSessionStatus.js";
import {
  type CreateCheckoutSessionRequest,
  CreateCheckoutSessionRequestSerializer,
} from "../models/createCheckoutSessionRequest.js";
import {
  type CreateCheckoutSessionResponse,
  CreateCheckoutSessionResponseSerializer,
} from "../models/createCheckoutSessionResponse.js";
import type { CustomerId } from "../models/customerId.js";
import {
  type GetCheckoutSessionResponse,
  GetCheckoutSessionResponseSerializer,
} from "../models/getCheckoutSessionResponse.js";
import {
  type ListCheckoutSessionsResponse,
  ListCheckoutSessionsResponseSerializer,
} from "../models/listCheckoutSessionsResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The query and header parameters of `list`. */
export interface CheckoutSessionsListOptions {
  customerId?: CustomerId | undefined;
  status?: CheckoutSessionStatus | undefined;
}

/** The checkout sessions operations, reached through the client's `checkoutSessions`. */
export class CheckoutSessions {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List checkout sessions */
  public list(
    options?: CheckoutSessionsListOptions,
    requestOptions?: RequestOptions
  ): APIPromise<ListCheckoutSessionsResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/checkout-sessions");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("status", options?.status);
    return request.send(
      this.requestCtx,
      ListCheckoutSessionsResponseSerializer.parse,
      requestOptions
    );
  }

  /** Create a checkout session */
  public create(
    createCheckoutSessionRequest: CreateCheckoutSessionRequest,
    requestOptions?: RequestOptions
  ): APIPromise<CreateCheckoutSessionResponse> {
    const request = new MeteroidRequest("POST", "/api/v1/checkout-sessions");

    request.setBody(
      CreateCheckoutSessionRequestSerializer.serialize(createCheckoutSessionRequest)
    );
    return request.send(
      this.requestCtx,
      CreateCheckoutSessionResponseSerializer.parse,
      requestOptions
    );
  }

  /** Get a checkout session by ID */
  public retrieve(
    id: string,
    requestOptions?: RequestOptions
  ): APIPromise<GetCheckoutSessionResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/checkout-sessions/{id}");

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      GetCheckoutSessionResponseSerializer.parse,
      requestOptions
    );
  }

  /** Cancel a checkout session */
  public cancel(
    id: string,
    requestOptions?: RequestOptions
  ): APIPromise<CancelCheckoutSessionResponse> {
    const request = new MeteroidRequest("POST", "/api/v1/checkout-sessions/{id}/cancel");

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      CancelCheckoutSessionResponseSerializer.parse,
      requestOptions
    );
  }
}
