// this file is @generated
import {
  type IntrospectionRequest,
  IntrospectionRequestSerializer,
} from "../models/introspectionRequest";
import {
  type RevocationRequest,
  RevocationRequestSerializer,
} from "../models/revocationRequest";
import {
  type TokenIntrospectionResponse,
  TokenIntrospectionResponseSerializer,
} from "../models/tokenIntrospectionResponse";
import { type TokenRequest, TokenRequestSerializer } from "../models/tokenRequest";
import { type TokenResponse, TokenResponseSerializer } from "../models/tokenResponse";
import { HttpMethod, MeteroidRequest, type MeteroidRequestContext } from "../request";

export class OAuth {
  public constructor(private readonly requestCtx: MeteroidRequestContext) {}

  /**
   * Token introspection endpoint (RFC 7662). Requires client credentials
   * via HTTP Basic auth.
   */
  public introspectEndpoint(
    introspectionRequest: IntrospectionRequest
  ): Promise<TokenIntrospectionResponse> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/oauth/introspect");

    request.setFormBody(
      IntrospectionRequestSerializer._toJsonObject(introspectionRequest)
    );
    return request.send(
      this.requestCtx,
      TokenIntrospectionResponseSerializer._fromJsonObject
    );
  }

  /**
   * Token revocation endpoint (RFC 7009). Always returns 200 per spec.
   * Requires client credentials via HTTP Basic auth.
   */
  public revokeEndpoint(revocationRequest: RevocationRequest): Promise<void> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/oauth/revoke");

    request.setFormBody(RevocationRequestSerializer._toJsonObject(revocationRequest));
    return request.sendNoResponseBody(this.requestCtx);
  }

  /**
   * OAuth 2.0 token endpoint. Supports two grant types:
   * - `authorization_code`: Exchange an authorization code for tokens
   * - `refresh_token`: Refresh an access token
   *
   * Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters.
   */
  public tokenEndpoint(tokenRequest: TokenRequest): Promise<TokenResponse> {
    const request = new MeteroidRequest(HttpMethod.POST, "/api/v1/oauth/token");

    request.setFormBody(TokenRequestSerializer._toJsonObject(tokenRequest));
    return request.send(this.requestCtx, TokenResponseSerializer._fromJsonObject);
  }
}
