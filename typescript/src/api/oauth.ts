// this file is @generated

import {
  type IntrospectionRequest,
  IntrospectionRequestSerializer,
} from "../models/introspectionRequest.js";
import { OAuthErrorResponseSerializer } from "../models/oAuthErrorResponse.js";
import { RestErrorResponseSerializer } from "../models/restErrorResponse.js";
import {
  type RevocationRequest,
  RevocationRequestSerializer,
} from "../models/revocationRequest.js";
import {
  type TokenIntrospectionResponse,
  TokenIntrospectionResponseSerializer,
} from "../models/tokenIntrospectionResponse.js";
import { type TokenRequest, TokenRequestSerializer } from "../models/tokenRequest.js";
import { type TokenResponse, TokenResponseSerializer } from "../models/tokenResponse.js";
import type { APIPromise } from "../apiPromise.js";
import {
  MeteroidRequest,
  type MeteroidRequestContext,
  type RequestOptions,
} from "../request.js";

/** The oauth operations, reached through the client's `oauth`. */
export class Oauth {
  /** @internal */
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**
   * Introspect token
   *
   * Token introspection endpoint (RFC 7662). Requires client credentials
   * via HTTP Basic auth.
   */
  public introspect(
    introspectionRequest: IntrospectionRequest,
    requestOptions?: RequestOptions
  ): APIPromise<TokenIntrospectionResponse> {
    const request = new MeteroidRequest("POST", "/api/v1/oauth/introspect");

    request.setSecurity([]);
    request.setErrors({
      "401": OAuthErrorResponseSerializer.parse,
      "429": RestErrorResponseSerializer.parse,
    });
    request.setFormBody(IntrospectionRequestSerializer.serialize(introspectionRequest));
    return request.send(
      this.requestCtx,
      TokenIntrospectionResponseSerializer.parse,
      requestOptions
    );
  }

  /**
   * Revoke token
   *
   * Token revocation endpoint (RFC 7009). Always returns 200 per spec.
   * Requires client credentials via HTTP Basic auth.
   */
  public revoke(
    revocationRequest: RevocationRequest,
    requestOptions?: RequestOptions
  ): APIPromise<void> {
    const request = new MeteroidRequest("POST", "/api/v1/oauth/revoke");

    request.setSecurity([]);
    request.setErrors({
      "401": OAuthErrorResponseSerializer.parse,
      "429": RestErrorResponseSerializer.parse,
    });
    request.setFormBody(RevocationRequestSerializer.serialize(revocationRequest));
    return request.sendNoResponseBody(this.requestCtx, requestOptions);
  }

  /**
   * Exchange tokens
   *
   * OAuth 2.0 token endpoint. Supports two grant types:
   * - `authorization_code`: Exchange an authorization code for tokens
   * - `refresh_token`: Refresh an access token
   *
   * Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters.
   */
  public token(
    tokenRequest: TokenRequest,
    requestOptions?: RequestOptions
  ): APIPromise<TokenResponse> {
    const request = new MeteroidRequest("POST", "/api/v1/oauth/token");

    request.setSecurity([]);
    request.setErrors({
      "400": OAuthErrorResponseSerializer.parse,
      "401": OAuthErrorResponseSerializer.parse,
      "429": RestErrorResponseSerializer.parse,
    });
    request.setFormBody(TokenRequestSerializer.serialize(tokenRequest));
    return request.send(this.requestCtx, TokenResponseSerializer.parse, requestOptions);
  }
}
