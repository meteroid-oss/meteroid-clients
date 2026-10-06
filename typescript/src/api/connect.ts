// this file is @generated

import {
  type ConnectedAccount,
  ConnectedAccountSerializer,
} from "../models/connectedAccount.js";
import {
  type ConnectedAccountsResponse,
  ConnectedAccountsResponseSerializer,
} from "../models/connectedAccountsResponse.js";
import {
  type CreateConnectedAccountRequest,
  CreateConnectedAccountRequestSerializer,
} from "../models/createConnectedAccountRequest.js";
import {
  type CreateOnboardingLinkRequest,
  CreateOnboardingLinkRequestSerializer,
} from "../models/createOnboardingLinkRequest.js";
import {
  type OnboardingLinkResponse,
  OnboardingLinkResponseSerializer,
} from "../models/onboardingLinkResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The connect operations, reached through the client's `connect`. */
export class Connect {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**
   * List connected accounts
   *
   * List all connected accounts for this platform.
   */
  public listConnectedAccounts(
    requestOptions?: RequestOptions
  ): APIPromise<ConnectedAccountsResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/connected-accounts");

    return request.send(
      this.requestCtx,
      ConnectedAccountsResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Create connected account
   *
   * Create a new connected account (Express flow). Returns the account
   * and an onboarding link for the user to complete setup.
   */
  public createConnectedAccount(
    createConnectedAccountRequest: CreateConnectedAccountRequest,
    requestOptions?: RequestOptions
  ): APIPromise<ConnectedAccount> {
    const request = new MeteroidRequest("POST", "/api/v1/connected-accounts");

    request.setBody(
      CreateConnectedAccountRequestSerializer.serialize(createConnectedAccountRequest)
    );
    return request.send(
      this.requestCtx,
      ConnectedAccountSerializer.parse,
      requestOptions
    );
  }

  /**
   * Get connected account
   *
   * Retrieve a connected account by ID.
   */
  public retrieveConnectedAccount(
    id: string,
    requestOptions?: RequestOptions
  ): APIPromise<ConnectedAccount> {
    const request = new MeteroidRequest("GET", "/api/v1/connected-accounts/{id}");

    request.setPathParam("id", id);
    return request.send(
      this.requestCtx,
      ConnectedAccountSerializer.parse,
      requestOptions
    );
  }

  /**
   * Disconnect account
   *
   * Revoke a connected account. All associated tokens are invalidated.
   */
  public disconnectAccount(
    id: string,
    requestOptions?: RequestOptions
  ): APIPromise<void> {
    const request = new MeteroidRequest("DELETE", "/api/v1/connected-accounts/{id}");

    request.setPathParam("id", id);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /**
   * Create onboarding link
   *
   * Generate a new onboarding link for a connected account. Any existing
   * unused link is invalidated. The link expires after a configured duration.
   */
  public createOnboardingLink(
    id: string,
    createOnboardingLinkRequest: CreateOnboardingLinkRequest,
    requestOptions?: RequestOptions
  ): APIPromise<OnboardingLinkResponse> {
    const request = new MeteroidRequest(
      "POST",
      "/api/v1/connected-accounts/{id}/onboarding"
    );

    request.setPathParam("id", id);
    request.setBody(
      CreateOnboardingLinkRequestSerializer.serialize(createOnboardingLinkRequest)
    );
    return request.send(
      this.requestCtx,
      OnboardingLinkResponseSerializer.parse,
      requestOptions
    );
  }
}
