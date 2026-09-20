// this file is @generated
import {
  type ConnectedAccount,
  ConnectedAccountSerializer,
} from "../models/connectedAccount";
import {
  type ConnectedAccountsResponse,
  ConnectedAccountsResponseSerializer,
} from "../models/connectedAccountsResponse";
import {
  type CreateConnectedAccountRequest,
  CreateConnectedAccountRequestSerializer,
} from "../models/createConnectedAccountRequest";
import {
  type CreateOnboardingLinkRequest,
  CreateOnboardingLinkRequestSerializer,
} from "../models/createOnboardingLinkRequest";
import {
  type OnboardingLinkResponse,
  OnboardingLinkResponseSerializer,
} from "../models/onboardingLinkResponse";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export class Connect {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /** List all connected accounts for this platform. */
  public listConnectedAccounts(): Promise<ConnectedAccountsResponse> {
    const request = new MeteroidRequest(HttpMethod.GET, "/api/v1/connected-accounts");

    return request.send(
      this.requestCtx,
      ConnectedAccountsResponseSerializer._fromJsonObject
    );
  }

  /**
   * Create a new connected account (Express flow). Returns the account
   * and an onboarding link for the user to complete setup.
   */
  public createConnectedAccount(
    createConnectedAccountRequest: CreateConnectedAccountRequest
  ): Promise<ConnectedAccount> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/connected-accounts");

    request.setBody(
      CreateConnectedAccountRequestSerializer._toJsonObject(createConnectedAccountRequest)
    );
    return request.send(this.requestCtx, ConnectedAccountSerializer._fromJsonObject);
  }

  /** Retrieve a connected account by ID. */
  public getConnectedAccount(id: string): Promise<ConnectedAccount> {
    const request = new MeteroidRequest(
      HttpMethod.GET,
      "/api/v1/connected-accounts/{id}"
    );

    request.setPathParam("id", id);
    return request.send(this.requestCtx, ConnectedAccountSerializer._fromJsonObject);
  }

  /** Revoke a connected account. All associated tokens are invalidated. */
  public disconnectAccount(id: string): Promise<void> {
    const request = new MeteroidRequest(
      HttpMethod.DELETE,
      "/api/v1/connected-accounts/{id}"
    );

    request.setPathParam("id", id);
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**
   * Generate a new onboarding link for a connected account. Any existing
   * unused link is invalidated. The link expires after a configured duration.
   */
  public createOnboardingLink(
    id: string,
    createOnboardingLinkRequest: CreateOnboardingLinkRequest
  ): Promise<OnboardingLinkResponse> {
    const request = new MeteroidRequest(
      HttpMethod.POST,
      "/api/v1/connected-accounts/{id}/onboarding"
    );

    request.setPathParam("id", id);
    request.setBody(
      CreateOnboardingLinkRequestSerializer._toJsonObject(createOnboardingLinkRequest)
    );
    return request.send(
      this.requestCtx,
      OnboardingLinkResponseSerializer._fromJsonObject
    );
  }
}
