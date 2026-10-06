// this file is @generated

import {
  type CreateOAuthAppRequest,
  CreateOAuthAppRequestSerializer,
} from "../models/createOAuthAppRequest.js";
import { type OAuthApp, OAuthAppSerializer } from "../models/oAuthApp.js";
import {
  type OAuthAppWithSecret,
  OAuthAppWithSecretSerializer,
} from "../models/oAuthAppWithSecret.js";
import {
  type OAuthAppsResponse,
  OAuthAppsResponseSerializer,
} from "../models/oAuthAppsResponse.js";
import { type RotatedSecret, RotatedSecretSerializer } from "../models/rotatedSecret.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The oauth apps operations, reached through the client's `oauthApps`. */
export class OauthApps {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**
   * List OAuth apps
   *
   * List all OAuth applications registered for this platform.
   */
  public list(requestOptions?: RequestOptions): APIPromise<OAuthAppsResponse> {
    const request = new MeteroidRequest("GET", "/api/v1/oauth-apps");

    return request.send(
      this.requestCtx,
      OAuthAppsResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Create OAuth app
   *
   * Register a new OAuth application. Returns the app with its client secret
   * (only shown once).
   */
  public create(
    createOAuthAppRequest: CreateOAuthAppRequest,
    requestOptions?: RequestOptions
  ): APIPromise<OAuthAppWithSecret> {
    const request = new MeteroidRequest("POST", "/api/v1/oauth-apps");

    request.setBody(CreateOAuthAppRequestSerializer.serialize(createOAuthAppRequest));
    return request.send(
      this.requestCtx,
      OAuthAppWithSecretSerializer.parse,
      requestOptions
    );
  }

  /**
   * Get OAuth app
   *
   * Retrieve an OAuth application by ID.
   */
  public retrieve(id: string, requestOptions?: RequestOptions): APIPromise<OAuthApp> {
    const request = new MeteroidRequest("GET", "/api/v1/oauth-apps/{id}");

    request.setPathParam("id", id);
    return request.send(this.requestCtx, OAuthAppSerializer.parse, requestOptions);
  }

  /**
   * Delete OAuth app
   *
   * Delete an OAuth application and revoke all associated tokens.
   */
  public delete(id: string, requestOptions?: RequestOptions): APIPromise<void> {
    const request = new MeteroidRequest("DELETE", "/api/v1/oauth-apps/{id}");

    request.setPathParam("id", id);
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /**
   * Rotate client secret
   *
   * Generate a new client secret for an OAuth app. The old secret is
   * immediately invalidated.
   */
  public rotate(id: string, requestOptions?: RequestOptions): APIPromise<RotatedSecret> {
    const request = new MeteroidRequest("POST", "/api/v1/oauth-apps/{id}/rotate");

    request.setPathParam("id", id);
    return request.send(this.requestCtx, RotatedSecretSerializer.parse, requestOptions);
  }
}
