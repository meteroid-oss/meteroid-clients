// this file is @generated
import {
  type CancelCheckoutSessionResponse,
  CancelCheckoutSessionResponseSerializer,
} from "../models/cancelCheckoutSessionResponse";
import type { CheckoutSessionStatus } from "../models/checkoutSessionStatus";
import {
  type CreateCheckoutSessionRequest,
  CreateCheckoutSessionRequestSerializer,
} from "../models/createCheckoutSessionRequest";
import {
  type CreateCheckoutSessionResponse,
  CreateCheckoutSessionResponseSerializer,
} from "../models/createCheckoutSessionResponse";
import type { CustomerId } from "../models/customerId";
import {
  type GetCheckoutSessionResponse,
  GetCheckoutSessionResponseSerializer,
} from "../models/getCheckoutSessionResponse";
import {
  type ListCheckoutSessionsResponse,
  ListCheckoutSessionsResponseSerializer,
} from "../models/listCheckoutSessionsResponse";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export interface CheckoutSessionsListCheckoutSessionsOptions {
  customerId?: CustomerId;
  status?: CheckoutSessionStatus;
}

export class CheckoutSessions {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**  */
  public listCheckoutSessions(
    options?: CheckoutSessionsListCheckoutSessionsOptions
  ): Promise<ListCheckoutSessionsResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/checkout-sessions");

    request.setQueryParam("customer_id", options?.customerId);
    request.setQueryParam("status", options?.status);
    return request.send(
      this.requestCtx,
      ListCheckoutSessionsResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public createCheckoutSession(
    createCheckoutSessionRequest: CreateCheckoutSessionRequest
  ): Promise<CreateCheckoutSessionResponse> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/checkout-sessions");

    request.setBody(
      CreateCheckoutSessionRequestSerializer._toJsonObject(createCheckoutSessionRequest)
    );
    return request.send(
      this.requestCtx,
      CreateCheckoutSessionResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public getCheckoutSession(id: string): Promise<GetCheckoutSessionResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/checkout-sessions/{id}");

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      GetCheckoutSessionResponseSerializer._fromJsonObject
    );
  }

  /**  */
  public cancelCheckoutSession(id: string): Promise<CancelCheckoutSessionResponse> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/checkout-sessions/{id}/cancel"
    );

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      CancelCheckoutSessionResponseSerializer._fromJsonObject
    );
  }
}
